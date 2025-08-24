package org.drexa1.gedcom.highlighter

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.drexa1.gedcom.GedcomLanguage

class GedcomTokens private constructor() {
    companion object {
        @JvmField val LEVEL                         = IElementType("LEVEL", GedcomLanguage)
        @JvmField val LEVEL_META                    = IElementType("LEVEL", GedcomLanguage)
        @JvmField val LEVEL_INDI                    = IElementType("LEVEL", GedcomLanguage)
        @JvmField val LEVEL_FAM                     = IElementType("LEVEL", GedcomLanguage)
        @JvmField val AT                            = IElementType("AT", GedcomLanguage)
        @JvmField val POINTER                       = IElementType("POINTER", GedcomLanguage)
        @JvmField val INDI_POINTER                  = IElementType("INDI_POINTER", GedcomLanguage)
        @JvmField val FAM_POINTER                   = IElementType("FAM_POINTER", GedcomLanguage)
        @JvmField val TAG                           = IElementType("TAG", GedcomLanguage)
        @JvmField val TAG_META                      = IElementType("TAG", GedcomLanguage)
        @JvmField val TAG_INDI                      = IElementType("TAG", GedcomLanguage)
        @JvmField val TAG_FAM                       = IElementType("TAG", GedcomLanguage)
        @JvmField val VALUE                         = IElementType("VALUE", GedcomLanguage)
        @JvmField val WHITESPACE: IElementType      = TokenType.WHITE_SPACE
        @JvmField val NEW_LINE_INDENT: IElementType = TokenType.NEW_LINE_INDENT
        @JvmField val BAD_CHARACTER: IElementType   = TokenType.BAD_CHARACTER
    }
}