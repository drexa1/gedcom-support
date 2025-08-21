package org.drexa1.gedcom.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.drexa1.gedcom.GedcomLanguage

class GedcomSyntaxHighlighter : SyntaxHighlighterBase() {

    object GedcomTextAttributes {
        val LEVEL: TextAttributesKey           = TextAttributesKey.createTextAttributesKey("LEVEL", DefaultLanguageHighlighterColors.KEYWORD)
        val TAG: TextAttributesKey             = TextAttributesKey.createTextAttributesKey("TAG", DefaultLanguageHighlighterColors.KEYWORD)
        val VALUE: TextAttributesKey           = TextAttributesKey.createTextAttributesKey("VALUE", DefaultLanguageHighlighterColors.STRING)
        val BAD_CHARACTER: TextAttributesKey   = HighlighterColors.BAD_CHARACTER
    }

    companion object Tokens {
        val LEVEL = IElementType("LEVEL", GedcomLanguage)
        val TAG = IElementType("TAG", GedcomLanguage)
        val VALUE = IElementType("VALUE", GedcomLanguage)
        val BAD_CHARACTER = IElementType("BAD_CHARACTER", GedcomLanguage)
    }

    override fun getHighlightingLexer(): Lexer = _GedcomLexer()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = when (tokenType) {
        LEVEL -> arrayOf(GedcomTextAttributes.LEVEL)
        TAG -> arrayOf(GedcomTextAttributes.TAG)
        VALUE -> arrayOf(GedcomTextAttributes.VALUE)
        BAD_CHARACTER -> arrayOf(GedcomTextAttributes.BAD_CHARACTER)
        else -> emptyArray()
    }
}
