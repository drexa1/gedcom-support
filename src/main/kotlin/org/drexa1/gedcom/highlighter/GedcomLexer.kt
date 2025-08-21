import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import org.drexa1.gedcom.highlighter.GedcomTokens

class GedcomLexer : LexerBase() {
    private lateinit var buffer: CharSequence
    private var tokenStart = 0
    private var tokenEnd = 0
    private var endOffset = 0
    private var tokenType: IElementType? = null
    private var lineTokens: List<Pair<String, IElementType>> = emptyList()
    private var currentTokenIndex = 0
    private var nextLineOffset = 0

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.tokenStart = startOffset
        this.tokenEnd = startOffset
        this.endOffset = endOffset
        this.lineTokens = emptyList()
        this.currentTokenIndex = 0
        this.nextLineOffset = startOffset
        advance()
    }

    override fun advance() {
        try {
            println("Lexer advance: tokenStart=$tokenStart tokenEnd=$tokenEnd tokenType=$tokenType")

            // Emit remaining tokens from the previous line first
            if (currentTokenIndex < lineTokens.size) {
                val (text, type) = lineTokens[currentTokenIndex]
                tokenStart = tokenEnd
                tokenEnd = tokenStart + text.length
                tokenType = type
                currentTokenIndex++
                return
            }

            if (nextLineOffset >= endOffset) {
                tokenType = null
                return
            }

            tokenStart = nextLineOffset
            val lineEnd = buffer.indexOf('\n', tokenStart).let { if (it == -1) endOffset else it + 1 }
            val line = buffer.subSequence(tokenStart, lineEnd).toString().trim()
            nextLineOffset = lineEnd

            if (line.isEmpty()) {
                lineTokens = listOf(" " to GedcomTokens.VALUE)
                currentTokenIndex = 0
                advance()
                return
            }

            // Split the line into LEVEL TAG VALUE
            val parts = line.split("\\s+".toRegex(), 3)
            val level = if (parts.isNotEmpty()) parts[0] else ""
            val tag = if (parts.size > 1) parts[1] else ""
            val value = if (parts.size > 2) parts[2] else ""

            // Merge CONT and CONC lines for multi-line notes
            val mergedValue = StringBuilder(value)
            var lookAheadOffset = nextLineOffset
            while (lookAheadOffset < endOffset) {
                val nextLineEnd = buffer.indexOf('\n', lookAheadOffset).let { if (it == -1) endOffset else it + 1 }
                val nextLine = buffer.subSequence(lookAheadOffset, nextLineEnd).toString().trim()
                if (nextLine.matches(Regex("^\\d+\\s+(CONT|CONC)\\s+.*"))) {
                    val contParts = nextLine.split("\\s+".toRegex(), 3)
                    if (contParts.size > 2) {
                        val contText = contParts[2]
                        if (contParts[1] == "CONC") mergedValue.append(contText)
                        else mergedValue.append("\n").append(contText)
                    }
                    lookAheadOffset = nextLineEnd
                    nextLineOffset = lookAheadOffset
                } else break
            }

            // Build token triple
            lineTokens = mutableListOf<Pair<String, IElementType>>().apply {
                if (level.isNotEmpty()) add(level to GedcomTokens.LEVEL)
                if (tag.isNotEmpty()) add(tag to GedcomTokens.TAG)
                if (mergedValue.isNotEmpty()) add(mergedValue.toString() to GedcomTokens.VALUE)
            }

            currentTokenIndex = 0
            tokenEnd = tokenStart
            advance()
        } catch (e: Exception) {
            throw RuntimeException("Lexer error at offset $tokenStart: ${e.message}", e)
        }
    }

    override fun getState(): Int = 0
    override fun getTokenType(): IElementType? = tokenType
    override fun getTokenStart(): Int = tokenStart
    override fun getTokenEnd(): Int = tokenEnd
    override fun getBufferSequence(): CharSequence = buffer
    override fun getBufferEnd(): Int = endOffset
}
