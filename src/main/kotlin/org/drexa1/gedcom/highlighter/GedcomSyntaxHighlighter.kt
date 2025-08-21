package org.drexa1.gedcom.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.intellij.psi.TokenType.*

class GedcomSyntaxHighlighter : SyntaxHighlighterBase() {

    object GedcomTextAttributes {
        val LEVEL: TextAttributesKey           = TextAttributesKey.createTextAttributesKey("LEVEL", DefaultLanguageHighlighterColors.KEYWORD)
        val TAG: TextAttributesKey             = TextAttributesKey.createTextAttributesKey("TAG", DefaultLanguageHighlighterColors.KEYWORD)
        val VALUE: TextAttributesKey           = TextAttributesKey.createTextAttributesKey("VALUE", DefaultLanguageHighlighterColors.STRING)
        val BAD_CHARACTER: TextAttributesKey   = HighlighterColors.BAD_CHARACTER
    }

//    override fun getHighlightingLexer(): Lexer = FlexAdapter(FlexGedcomLexer(null))

    override fun getHighlightingLexer(): Lexer = GedcomLexer()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = when (tokenType) {
        GedcomTokens.LEVEL -> arrayOf(GedcomTextAttributes.LEVEL)
        GedcomTokens.TAG -> arrayOf(GedcomTextAttributes.TAG)
        GedcomTokens.VALUE -> arrayOf(GedcomTextAttributes.VALUE)
        BAD_CHARACTER -> arrayOf(GedcomTextAttributes.BAD_CHARACTER)
        else -> emptyArray()
    }
}
