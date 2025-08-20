package org.drexa1.gedcom

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class GedcomSyntaxHighlighter : SyntaxHighlighterBase() {

    companion object {
        val LEVEL_ATTR: TextAttributesKey = TextAttributesKey.createTextAttributesKey("GEDCOM_LEVEL", DefaultLanguageHighlighterColors.NUMBER)
        val META: TextAttributesKey = TextAttributesKey.createTextAttributesKey("GEDCOM_VALUE", DefaultLanguageHighlighterColors.KEYWORD)
        val INDI_ID: TextAttributesKey = TextAttributesKey.createTextAttributesKey("GEDCOM_TAG", DefaultLanguageHighlighterColors.STRING)
        val FAM_ID: TextAttributesKey = TextAttributesKey.createTextAttributesKey("GEDCOM_VALUE", DefaultLanguageHighlighterColors.STRING)
        val TAG: TextAttributesKey = TextAttributesKey.createTextAttributesKey("GEDCOM_VALUE", DefaultLanguageHighlighterColors.KEYWORD)
        val VALUE: TextAttributesKey = TextAttributesKey.createTextAttributesKey("GEDCOM_VALUE", DefaultLanguageHighlighterColors.STRING)
        val BAD_CHARACTER: TextAttributesKey = TextAttributesKey.createTextAttributesKey("GEDCOM_ID", DefaultLanguageHighlighterColors.HIGHLIGHTED_REFERENCE)
    }

    override fun getHighlightingLexer(): Lexer {
        return GedcomLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = when (tokenType) {
        GedcomTokenTypes.LEVEL         -> arrayOf(LEVEL_ATTR)
        GedcomTokenTypes.META          -> arrayOf(META)
        GedcomTokenTypes.INDI_ID       -> arrayOf(INDI_ID)
        GedcomTokenTypes.FAM_ID        -> arrayOf(FAM_ID)
        GedcomTokenTypes.TAG           -> arrayOf(TAG)
        GedcomTokenTypes.VALUE         -> arrayOf(VALUE)
        GedcomTokenTypes.BAD_CHARACTER -> arrayOf(BAD_CHARACTER)
        else                           -> emptyArray()
    }
}
