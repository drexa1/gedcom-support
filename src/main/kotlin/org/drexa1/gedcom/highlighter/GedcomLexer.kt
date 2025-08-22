package org.drexa1.gedcom.highlighter

import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import org.drexa1.gedcom.GedcomTags
import org.drexa1.gedcom.GedcomTokens
import java.lang.Character.isWhitespace
import kotlin.concurrent.atomics.AtomicInt

data class GedcomLTV(var level: Int?, var id: String?, var tag: String?, var value: String?)

enum class Pointer {
    G, // Generic pointer (ie: UUID)
    I, // INDI ID
    F // FAM ID
}

@kotlin.concurrent.atomics.ExperimentalAtomicApi
class GedcomLexer : LexerBase() {
    private lateinit var buffer: CharSequence
    private lateinit var lineOffsets: List<Int>

    private val startOffset = AtomicInt(0)
    private val endOffset = AtomicInt(0)
    private val currentLine = AtomicInt(0)

    private val tokenStart = AtomicInt(0)
    private val tokenEnd = AtomicInt(0)
    private val tokenLength = AtomicInt(0)
    private var tokenType: IElementType? = null
    private var currentLTV: GedcomLTV? = GedcomLTV(null,null,null, null)

    override fun getState(): Int = 0
    override fun getBufferSequence(): CharSequence = buffer
    override fun getBufferEnd(): Int = endOffset.load()

    override fun getTokenStart(): Int = tokenStart.load()
    override fun getTokenEnd(): Int = tokenEnd.load()
    override fun getTokenType(): IElementType? = tokenType

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.lineOffsets = buffer.split("\n").runningFold(0) { acc, line -> acc + line.length + 1 }.dropLast(1)
        this.startOffset.store(startOffset)
        this.endOffset.store(endOffset)
        advance()
    }

    override fun advance() {
        if (startOffset.load() >= buffer.length) {
            tokenType = null
            return
        }
        tokenStart.store(startOffset.load()) // save the start before consuming
        val ch = buffer[startOffset.load()]
        tokenType = when {
            ch == '\n' -> {
                // Advance line
                currentLTV?.apply { level = null; tag = null; value = null }
                currentLine.addAndFetch(1)
                GedcomTokens.NEW_LINE_INDENT
            }
            isWhitespace(ch.code) -> GedcomTokens.WHITESPACE
            isLevel() -> GedcomTokens.LEVEL
            ch == '@' -> GedcomTokens.AT
            isPointer()?.equals(Pointer.G) ?: false -> GedcomTokens.POINTER
            isPointer()?.equals(Pointer.I) ?: false -> GedcomTokens.INDI_POINTER
            isPointer()?.equals(Pointer.F) ?: false -> GedcomTokens.FAM_POINTER
            isTag() -> GedcomTokens.TAG
            isValue() -> GedcomTokens.VALUE
            else -> GedcomTokens.BAD_CHARACTER
        }
        // Bump offset
        when (tokenType) {
            GedcomTokens.LEVEL, GedcomTokens.INDI_POINTER, GedcomTokens.FAM_POINTER, GedcomTokens.TAG, GedcomTokens.VALUE ->
                startOffset.addAndFetch(tokenLength.load())
            else ->
                startOffset.addAndFetch(1)
        }
        tokenEnd.store(startOffset.load())
    }

    fun isLevel(): Boolean {
        try {
            // It's a digit, and it is at the very start of a line
            val isLevel = buffer[startOffset.load()].isDigit() && startOffset.load() in lineOffsets
            if(isLevel) {
                // Save token length for offset bump
                tokenLength.store(buffer[startOffset.load()].toString().length)
                currentLTV?.level = buffer[startOffset.load()].digitToInt()
            }
            return isLevel
        } catch (_: NumberFormatException) {
            return false
        }
    }

    fun isPointer(): Pointer? {
        try {
            val lineStart = lineOffsets[currentLine.load()]
            require(startOffset.load() >= lineStart + 2) { "Cant be line start (level) nor the adjacent whitespace" }
            return if (buffer[startOffset.load() - 1] == '@') {
                val nextLineStart = lineOffsets[currentLine.load() + 1]
                val pointerCandidate = buffer.subSequence(startOffset.load(), nextLineStart - 1).toString().split('@').first()
                // Save token length for offset bump
                tokenLength.store(pointerCandidate.length)
                // The pointer can be the ID of and INDI/FAM record or an ID argument for FAMS/FAMC/HUSB/WIFE/CHIL
                currentLTV?.let { ltv -> if (ltv.tag != null) ltv.value = pointerCandidate else ltv.id = pointerCandidate }
                return when (pointerCandidate.firstOrNull()) {
                    'I' -> Pointer.I
                    'F' -> Pointer.F
                    else -> Pointer.G
                }
            } else null
        } catch (_: Exception) {
            return null
        }
    }

    fun isTag(): Boolean {
        try {
            val tagCandidate = tokenCandidate()
            // See if it's a recognizable tag
            return if (enumValues<GedcomTags>().any { it.name == tagCandidate }) {
                // Save token length for offset bump
                tokenLength.store(tagCandidate.length)
                currentLTV?.tag = tagCandidate
                return true
            } else false
        } catch (_: Exception) {
            return false
        }
    }

    fun isValue(): Boolean {
        try {
            val valueCandidate = tokenCandidate()
            // As long as it is not empty it's fine
            val isValue = !valueCandidate.isEmpty()
            return if (isValue) {
                // Save token length for offset bump
                tokenLength.store(valueCandidate.length)
                currentLTV?.value = valueCandidate
                return true
            } else false
        } catch (_: Exception) {
            return false
        }
    }

    fun tokenCandidate(): String {
        val lineStart = lineOffsets[currentLine.load()]
        require(startOffset.load() >= lineStart + 2) { "Cant be line start (level) nor the adjacent whitespace" }
        // Collect chars until next delimiter
        val lineEnd = lineOffsets.getOrNull(currentLine.load() + 1)?.minus(1) ?: endOffset.load()
        // For values, collect whitespaces too and take until the end of the line
        val nextDelimiter = if (currentLTV?.tag != null) '\n' else ' '
        val remainingLineTokens = buffer.subSequence(startOffset.load(), lineEnd).toString().split(nextDelimiter)
        return remainingLineTokens.first()
    }
}
