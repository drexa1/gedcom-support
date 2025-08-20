package org.drexa1.gedcom

import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType

class GedcomLexer(private val highlighter: GedcomSyntaxHighlighter) : LexerBase() {
    private lateinit var buffer: CharSequence
    private var tokenStart = 0
    private var tokenEnd = 0
    private var endOffset = 0
    private var tokenType: IElementType? = null
    private var insideMultiLine = false
    private var multiLineType: IElementType? = null

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.tokenStart = startOffset
        this.tokenEnd = startOffset
        this.endOffset = endOffset
        this.insideMultiLine = false
        advance()
    }

    override fun advance() {
        if (tokenEnd >= endOffset) {
            tokenType = null
            return
        }

        tokenStart = tokenEnd
        val lineEnd = buffer.indexOf('\n', tokenStart).let { if (it == -1) endOffset else it + 1 }
        val line = buffer.subSequence(tokenStart, lineEnd).toString().trimEnd()
        tokenEnd = lineEnd

        if (insideMultiLine) {
            if (line.matches(Regex("^0\\b.*"))) {
                insideMultiLine = false
                advance()
                return
            } else {
                tokenType = multiLineType
                highlighter.currentParagraphType = GedcomTextAttributes.VALUE
                return
            }
        }

        // Multi-line tags
        if (line.matches(Regex("^\\d+\\s+(NOTE|CONC|CONT)\\b.*"))) {
            insideMultiLine = true
            multiLineType = GedcomTokenTypes.VALUE
            highlighter.currentParagraphType = GedcomTextAttributes.VALUE
            tokenType = GedcomTokenTypes.VALUE
            return
        }

        // Set paragraph color based on first token
        highlighter.currentParagraphType = when {
            line.startsWith("0 HEAD") -> GedcomTextAttributes.HEAD
            line.startsWith("0 TRLR") -> GedcomTextAttributes.TRLR
            line.startsWith("0 SOUR") -> GedcomTextAttributes.SOUR
            line.startsWith("0 @I")   -> GedcomTextAttributes.INDI
            line.startsWith("0 @F")   -> GedcomTextAttributes.FAM
            else -> GedcomTextAttributes.VALUE
        }

        // Detect token type
        tokenType = when {
            line.matches(Regex("^0\\s+@I[^@]+@\\s+INDI.*")) -> GedcomTokenTypes.INDI_ID
            line.matches(Regex("^0\\s+@F[^@]+@\\s+FAM.*")) -> GedcomTokenTypes.FAM_ID
            line.matches(Regex("^\\d+\\s+[A-Z]+.*")) -> GedcomTokenTypes.TAG
            else -> GedcomTokenTypes.VALUE
        }
    }

    override fun getState(): Int = 0
    override fun getTokenType(): IElementType? = tokenType
    override fun getTokenStart(): Int = tokenStart
    override fun getTokenEnd(): Int = tokenEnd
    override fun getBufferSequence(): CharSequence = buffer
    override fun getBufferEnd(): Int = endOffset

}
