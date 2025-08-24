package org.drexa1.gedcom.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class GedcomSyntaxHighlighter : SyntaxHighlighterBase() {

    enum class Pointer {
        GEN,  // Generic pointer (ie: UUID)
        INDI,  // INDI ID
        FAM   // FAM ID
    }

    enum class SectionType {
        META,  // Meta or file structure
        INDI,  // INDI record
        FAM,  // FAM record
    }

    @kotlin.concurrent.atomics.ExperimentalAtomicApi
    override fun getHighlightingLexer(): Lexer = GedcomLexer()  // Try that ChatGPT or Flex or regex 😁

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = when (tokenType) {
        GedcomTokens.LEVEL_META    -> arrayOf(GedcomLanguageHighlights.LEVEL_META)
        GedcomTokens.LEVEL_INDI    -> arrayOf(GedcomLanguageHighlights.LEVEL_INDI)
        GedcomTokens.LEVEL_FAM     -> arrayOf(GedcomLanguageHighlights.LEVEL_FAM)
        GedcomTokens.AT            -> arrayOf(GedcomLanguageHighlights.AT)
        GedcomTokens.POINTER       -> arrayOf(GedcomLanguageHighlights.POINTER)
        GedcomTokens.INDI_POINTER  -> arrayOf(GedcomLanguageHighlights.INDI_POINTER)
        GedcomTokens.FAM_POINTER   -> arrayOf(GedcomLanguageHighlights.FAM_POINTER)
        GedcomTokens.TAG_META      -> arrayOf(GedcomLanguageHighlights.TAG_META)
        GedcomTokens.TAG_INDI      -> arrayOf(GedcomLanguageHighlights.TAG_INDI)
        GedcomTokens.TAG_FAM       -> arrayOf(GedcomLanguageHighlights.TAG_FAM)
        GedcomTokens.VALUE         -> arrayOf(GedcomLanguageHighlights.VALUE)
        GedcomTokens.BAD_CHARACTER -> arrayOf(GedcomLanguageHighlights.BAD_CHARACTER)
        else -> emptyArray()
    }
}
