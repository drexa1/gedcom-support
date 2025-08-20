package org.drexa1.gedcom

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType


object GedcomTextAttributes {
    // Paragraph type colors
    val HEAD = TextAttributesKey.createTextAttributesKey("HEAD", DefaultLanguageHighlighterColors.KEYWORD)
    val TRLR = TextAttributesKey.createTextAttributesKey("TRLR", DefaultLanguageHighlighterColors.KEYWORD)
    val SOUR = TextAttributesKey.createTextAttributesKey("SOUR", DefaultLanguageHighlighterColors.KEYWORD)
    val INDI = TextAttributesKey.createTextAttributesKey("INDI", DefaultLanguageHighlighterColors.NUMBER)
    val FAM  = TextAttributesKey.createTextAttributesKey("FAM", DefaultLanguageHighlighterColors.NUMBER)
    // Values share color with paragraph type
    val VALUE = TextAttributesKey.createTextAttributesKey("VALUE", DefaultLanguageHighlighterColors.STRING)
    val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("BAD_CHARACTER", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE)
}

class GedcomSyntaxHighlighter : SyntaxHighlighterBase() {

    var currentParagraphType: TextAttributesKey = GedcomTextAttributes.VALUE

    override fun getHighlightingLexer(): Lexer = GedcomLexer(this)

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = when (tokenType) {
        GedcomTokenTypes.LEVEL,
        GedcomTokenTypes.TAG,
        GedcomTokenTypes.META,
        GedcomTokenTypes.VALUE -> arrayOf(currentParagraphType)
        GedcomTokenTypes.INDI_ID -> arrayOf(GedcomTextAttributes.INDI)
        GedcomTokenTypes.FAM_ID -> arrayOf(GedcomTextAttributes.FAM)
        GedcomTokenTypes.BAD_CHARACTER -> arrayOf(GedcomTextAttributes.BAD_CHARACTER)
        else -> emptyArray()
    }
}
