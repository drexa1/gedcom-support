package org.drexa1.gedcom.highlighter

import com.intellij.psi.tree.IElementType
import org.drexa1.gedcom.GedcomLanguage

class GedcomTokens private constructor() {
    companion object {
        @JvmField val LEVEL = IElementType("LEVEL", GedcomLanguage)
        @JvmField val TAG = IElementType("TAG", GedcomLanguage)
        @JvmField val VALUE = IElementType("VALUE", GedcomLanguage)
        @JvmField val BAD_CHARACTER = IElementType("BAD_CHARACTER", GedcomLanguage)
    }
}