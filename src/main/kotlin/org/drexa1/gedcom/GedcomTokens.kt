package org.drexa1.gedcom

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class GedcomTokens private constructor() {
    companion object {
        @JvmField val LEVEL = IElementType("LEVEL", GedcomLanguage)
        @JvmField val AT = IElementType("AT", GedcomLanguage)
        @JvmField val POINTER = IElementType("POINTER", GedcomLanguage)
        @JvmField val INDI_POINTER = IElementType("INDI_POINTER", GedcomLanguage)
        @JvmField val FAM_POINTER = IElementType("FAM_POINTER", GedcomLanguage)
        @JvmField val TAG = IElementType("TAG", GedcomLanguage)
        @JvmField val VALUE = IElementType("VALUE", GedcomLanguage)
        @JvmField val WHITESPACE: IElementType = TokenType.WHITE_SPACE
        @JvmField val NEW_LINE_INDENT: IElementType = TokenType.NEW_LINE_INDENT
        @JvmField val BAD_CHARACTER: IElementType = TokenType.BAD_CHARACTER
    }
}