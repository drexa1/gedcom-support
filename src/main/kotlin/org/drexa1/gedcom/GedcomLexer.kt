package org.drexa1.gedcom

import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType

class GedcomLexer : LexerBase() {
    private var buffer: CharSequence = ""
    private var startOffset = 0
    private var endOffset = 0
    private var tokenStart = 0
    private var tokenEnd = 0
    private var tokenType: IElementType? = null

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        tokenStart = startOffset
        tokenEnd = startOffset
        tokenType = null
    }

    override fun advance() {
        if (tokenEnd >= endOffset) {
            tokenType = null
            return
        }
        tokenStart = tokenEnd
        // Find end of line
        val lineEnd = buffer.indexOf('\n', tokenStart).let { if (it == -1) endOffset else it + 1 }
        val line = buffer.subSequence(tokenStart, lineEnd).toString()
        // Reset tokenEnd for next advance
        tokenEnd = lineEnd
        // Simple parsing logic
        tokenType = when {
            line.matches(Regex("^\\d+.*")) -> GedcomTokenTypes.LEVEL
            line.matches(Regex("^0\\s+@I[^@]+@\\s+INDI.*")) -> GedcomTokenTypes.INDI_ID
            line.matches(Regex("^0\\s+@F[^@]+@\\s+FAM.*")) -> GedcomTokenTypes.FAM_ID
            line.matches(Regex("^0\\s+[A-Z]+.*")) -> GedcomTokenTypes.META
            line.matches(Regex("^[1-9][0-9]*\\s+[A-Z]+.*")) -> GedcomTokenTypes.TAG
            else -> GedcomTokenTypes.BAD_CHARACTER
        }
    }

    override fun getState(): Int = 0
    override fun getTokenType(): IElementType? = tokenType
    override fun getTokenStart(): Int = tokenStart
    override fun getTokenEnd(): Int = tokenEnd
    override fun getBufferSequence(): CharSequence = buffer
    override fun getBufferEnd(): Int = endOffset

}
