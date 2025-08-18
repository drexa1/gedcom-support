package org.drexa1.gedcom

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType


class GedcomSyntaxHighlighter : SyntaxHighlighterBase() {

    companion object {
        val TAG = TextAttributesKey.createTextAttributesKey("GEDCOM_TAG")
        val VALUE = TextAttributesKey.createTextAttributesKey("GEDCOM_VALUE")
        val COMMENT = TextAttributesKey.createTextAttributesKey("GEDCOM_COMMENT")
    }

    override fun getHighlightingLexer() = GedcomLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType) = when (tokenType.toString()) {
        "TAG" -> arrayOf(TAG)
        "VALUE" -> arrayOf(VALUE)
        "COMMENT" -> arrayOf(COMMENT)
        else -> emptyArray()
    }
}