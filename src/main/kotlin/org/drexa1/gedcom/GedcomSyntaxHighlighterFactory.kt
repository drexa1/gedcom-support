package org.drexa1.gedcom

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import com.intellij.openapi.fileTypes.SyntaxHighlighter

class GedcomSyntaxHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {
    override fun createHighlighter(): SyntaxHighlighter = GedcomSyntaxHighlighter()
}