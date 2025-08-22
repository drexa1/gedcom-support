package org.drexa1.gedcom.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.drexa1.gedcom.GedcomTokens

class GedcomSyntaxHighlighter : SyntaxHighlighterBase() {

    enum class Pointer {
        G, // Generic pointer (ie: UUID)
        I, // INDI ID
        F  // FAM ID
    }

    object GedcomTextAttributes {
        val LEVEL: TextAttributesKey           = TextAttributesKey.createTextAttributesKey("LEVEL", DefaultLanguageHighlighterColors.KEYWORD)
        val AT: TextAttributesKey              = TextAttributesKey.createTextAttributesKey("AT", DefaultLanguageHighlighterColors.MARKUP_TAG)
        val POINTER: TextAttributesKey         = TextAttributesKey.createTextAttributesKey("POINTER", DefaultLanguageHighlighterColors.MARKUP_ENTITY)
        val INDI_POINTER: TextAttributesKey    = TextAttributesKey.createTextAttributesKey("INDI_POINTER", DefaultLanguageHighlighterColors.MARKUP_ENTITY)
        val FAM_POINTER: TextAttributesKey     = TextAttributesKey.createTextAttributesKey("FAM_POINTER", DefaultLanguageHighlighterColors.MARKUP_ENTITY)
        val TAG: TextAttributesKey             = TextAttributesKey.createTextAttributesKey("TAG", DefaultLanguageHighlighterColors.KEYWORD)
        val VALUE: TextAttributesKey           = TextAttributesKey.createTextAttributesKey("VALUE", DefaultLanguageHighlighterColors.STRING)
        val BAD_CHARACTER: TextAttributesKey   = HighlighterColors.BAD_CHARACTER
    }

    @kotlin.concurrent.atomics.ExperimentalAtomicApi
    override fun getHighlightingLexer(): Lexer = GedcomLexer()  // Try that ChatGPT or Flex or regex 😁

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = when (tokenType) {
        GedcomTokens.LEVEL -> arrayOf(GedcomTextAttributes.LEVEL)
        GedcomTokens.AT -> arrayOf(GedcomTextAttributes.AT)
        GedcomTokens.POINTER -> arrayOf(GedcomTextAttributes.POINTER)
        GedcomTokens.INDI_POINTER -> arrayOf(GedcomTextAttributes.INDI_POINTER)
        GedcomTokens.FAM_POINTER -> arrayOf(GedcomTextAttributes.FAM_POINTER)
        GedcomTokens.TAG -> arrayOf(GedcomTextAttributes.TAG)
        GedcomTokens.VALUE -> arrayOf(GedcomTextAttributes.VALUE)
        GedcomTokens.BAD_CHARACTER -> arrayOf(GedcomTextAttributes.BAD_CHARACTER)
        else -> emptyArray()
    }
}
