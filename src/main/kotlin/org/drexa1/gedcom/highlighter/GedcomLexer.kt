package org.drexa1.gedcom.highlighter

import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType


class GedcomLexer : LexerBase() {
    private lateinit var buffer: CharSequence
    private var tokenStart = 0
    private var tokenEnd = 0
    private var endOffset = 0
    private var tokenType: IElementType? = null

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.tokenStart = startOffset
        this.tokenEnd = startOffset
        this.endOffset = endOffset
        advance()
    }

    override fun advance() {
        if (tokenEnd >= endOffset) {
            tokenType = null
            return
        }

        tokenStart = tokenEnd
        val lineEnd = buffer.indexOf('\n', tokenStart).let { if (it == -1) endOffset else it + 1 }
        val line = buffer.subSequence(tokenStart, lineEnd).toString().trim()
        tokenEnd = lineEnd

        tokenType = when {
            line.isEmpty() -> GedcomTokens.VALUE
            line.matches(Regex("^\\d+\\b.*")) -> GedcomTokens.LEVEL
            line.matches(Regex("^\\d+\\s+[A-Z]+.*")) -> GedcomTokens.TAG
            else -> GedcomTokens.VALUE
        }
    }

    override fun getState(): Int = 0
    override fun getTokenType(): IElementType? = tokenType
    override fun getTokenStart(): Int = tokenStart
    override fun getTokenEnd(): Int = tokenEnd
    override fun getBufferSequence(): CharSequence = buffer
    override fun getBufferEnd(): Int = endOffset
}