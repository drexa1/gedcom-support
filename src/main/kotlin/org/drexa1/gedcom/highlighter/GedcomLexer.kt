package org.drexa1.gedcom.highlighter

import GedcomTags
import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import java.lang.Character.isWhitespace
import kotlin.concurrent.atomics.AtomicInt
import org.drexa1.gedcom.highlighter.GedcomSyntaxHighlighter.Pointer
import org.drexa1.gedcom.highlighter.GedcomSyntaxHighlighter.SectionType

data class GedcomLTV(var level: Int?, var id: String?, var tag: String?, var value: String?)

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
    private var currentSectionType = SectionType.META
    private val currentLTV: GedcomLTV = GedcomLTV(null,null,null, null)

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
        // Clear previous token length
        tokenLength.store(0)
        val ch = buffer[startOffset.load()]
        // Match pattern
        tokenType = when {
            ch == '\n' -> {
                // Advance line
                currentLTV.apply { level = null; tag = null; value = null }
                currentLine.addAndFetch(1)
                GedcomTokens.NEW_LINE_INDENT
            }
            isWhitespace(ch.code)                               -> GedcomTokens.WHITESPACE
            currentSectionType == SectionType.META && isLevel() -> GedcomTokens.LEVEL_META
            currentSectionType == SectionType.INDI && isLevel() -> GedcomTokens.LEVEL_INDI
            currentSectionType == SectionType.FAM  && isLevel() -> GedcomTokens.LEVEL_FAM
            ch == '@'                                           -> GedcomTokens.AT
            isPointer()?.equals(Pointer.GEN) ?: false           -> GedcomTokens.POINTER
            isPointer()?.equals(Pointer.INDI) ?: false          -> GedcomTokens.INDI_POINTER
            isPointer()?.equals(Pointer.FAM) ?: false           -> GedcomTokens.FAM_POINTER
            currentSectionType == SectionType.META && isTag()   -> GedcomTokens.TAG_META
            currentSectionType == SectionType.INDI && isTag()   -> GedcomTokens.TAG_INDI
            currentSectionType == SectionType.FAM  && isTag()   -> GedcomTokens.TAG_FAM
            isValue()                                           -> GedcomTokens.VALUE
            else                                                -> GedcomTokens.BAD_CHARACTER
        }
        when (tokenType) {
            // Bump offset for varying length tokens
            GedcomTokens.LEVEL_META,
            GedcomTokens.LEVEL_INDI,
            GedcomTokens.LEVEL_FAM,
            GedcomTokens.INDI_POINTER,
            GedcomTokens.FAM_POINTER,
            GedcomTokens.TAG_META,
            GedcomTokens.TAG_INDI,
            GedcomTokens.TAG_FAM,
            GedcomTokens.VALUE ->
                startOffset.addAndFetch(tokenLength.load())
            else -> {
                // Bump offset for 1 char
                startOffset.addAndFetch(1)
                tokenLength.addAndFetch(1)
            }
        }
        tokenEnd.store(startOffset.load())
        verify()
    }

    fun verify() {
        try {
            assert(getTokenEnd() > getTokenStart()) { "tokenStart < tokenEnd" }
            assert(tokenLength.load() == tokenSequence.length) { "offset length > token length" }
            /* println("token: <<${if (tokenType == GedcomTokens.NEW_LINE_INDENT) "\\n" else tokenSequence}>> - " +
                    "tokenStart: '${getTokenStart()}', " +
                    "tokenEnd: ${getTokenEnd()} " +
                    "(tokenLength: $tokenLength) -> " +
                    "tokenType: $tokenType") */
        } catch(e: Exception) {
            println("ERROR: ${e.message}")
        }
    }

    fun isLevel(): Boolean {
        try {
            // It's a digit, and it is at the very start of a line
            val isLevel = buffer[startOffset.load()].isDigit() && startOffset.load() in lineOffsets
            if(isLevel) {
                // Save token length for offset bump
                tokenLength.store(buffer[startOffset.load()].toString().length)
                currentLTV.level = buffer[startOffset.load()].digitToInt()
                // On levels 0 verify if a change in section is happening (META -> INDI -> FAM -> META)
                checkSectionChange()
            }
            return isLevel
        } catch (_: NumberFormatException) {
            return false
        }
    }

    fun checkSectionChange() {
        // On 0 levels check if it follows an INDI or FAM record
        if (currentLTV.level == 0) {
            val lineEnd = lineOffsets.getOrNull(currentLine.load() + 1)?.minus(1) ?: endOffset.load()
            val candidateTag = buffer.subSequence(startOffset.load(), lineEnd).toString().substringAfterLast(' ')
            currentSectionType = when (candidateTag) {
                GedcomTags.INDI.name -> SectionType.INDI
                GedcomTags.FAM.name  -> SectionType.FAM
                else                 -> SectionType.META
            }
        }
    }

    /**
     * ID's between @ and @.
     * Can be the subject for a new INDI/FAM record, or the complement of a tag.
     */
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
                currentLTV.apply {
                    val isLastArgument = buffer.subSequence(startOffset.load(), nextLineStart - 1).toString().split(' ').size == 1
                    if (isLastArgument) value = pointerCandidate else id = pointerCandidate
                }
                return when (pointerCandidate.firstOrNull()) {
                    'I' -> Pointer.INDI
                    'F' -> Pointer.FAM
                    else -> Pointer.GEN
                }
            } else null
        } catch (e: Exception) {
            println("ERROR: ${e.message}")
            return null
        }
    }

    /**
     * GEDCOM tags.
     * Can appear in control sections, INDI sections or FAM sections.
     * @see GedcomTags
     */
    fun isTag(): Boolean {
        try {
            val tagCandidate = tokenCandidate()
            // See if it's a recognizable tag
            return if (enumValues<GedcomTags>().any { it.name == tagCandidate }) {
                // Save token length for offset bump
                tokenLength.store(tagCandidate.length)
                currentLTV.tag = tagCandidate
                return true
            } else false
        } catch (_: Exception) {
            return false
        }
    }

    /**
     * Anything following a tag, regardless of the section (META/INDI/FAM).
     */
    fun isValue(): Boolean {
        try {
            val valueCandidate = tokenCandidate()
            // As long as it is not empty it's fine
            val isValue = !valueCandidate.isEmpty()
            return if (isValue) {
                // Save token length for offset bump
                tokenLength.store(valueCandidate.length)
                currentLTV.value = valueCandidate
                return true
            } else false
        } catch (e: Exception) {
            println("ERROR: ${e.message}")
            return false
        }
    }

    fun tokenCandidate(): String {
        val lineStart = lineOffsets[currentLine.load()]
        require(startOffset.load() >= lineStart + 2) { "Cant be line start (level) nor the adjacent whitespace" }
        // Collect chars until next delimiter
        val lineEnd = lineOffsets.getOrNull(currentLine.load() + 1)?.minus(1) ?: endOffset.load()
        // For values, collect whitespaces too and take until the end of the line
        val nextDelimiter = if (currentLTV.tag != null) '\n' else ' '
        val remainingLineTokens = buffer.subSequence(startOffset.load(), lineEnd).toString().split(nextDelimiter)
        return remainingLineTokens.first()
    }
}
