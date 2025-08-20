package org.drexa1.gedcom

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class GedcomSyntaxHighlighter : SyntaxHighlighterBase() {

    object GedcomTextAttributes {
        val LEVEL = TextAttributesKey.createTextAttributesKey("LEVEL", DefaultLanguageHighlighterColors.KEYWORD)
        val TAG   = TextAttributesKey.createTextAttributesKey("TAG", DefaultLanguageHighlighterColors.KEYWORD)
        val VALUE = TextAttributesKey.createTextAttributesKey("VALUE", DefaultLanguageHighlighterColors.STRING)
        val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("BAD_CHARACTER", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE)
    }

    companion object Tokens {
        val LEVEL = GedcomTokenType("LEVEL")
        val TAG = GedcomTokenType("TAG")
        val VALUE = GedcomTokenType("VALUE")
        val BAD_CHARACTER = GedcomTokenType("BAD_CHARACTER")
    }

    class GedcomTokenType(debugName: String) : IElementType(debugName, GedcomLanguage)

    override fun getHighlightingLexer(): Lexer = GedcomLexer()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = when (tokenType) {
        LEVEL -> arrayOf(GedcomTextAttributes.LEVEL)
        TAG -> arrayOf(GedcomTextAttributes.TAG)
        VALUE -> arrayOf(GedcomTextAttributes.VALUE)
        BAD_CHARACTER -> arrayOf(GedcomTextAttributes.BAD_CHARACTER)
        else -> emptyArray()
    }
}
