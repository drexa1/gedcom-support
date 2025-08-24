package org.drexa1.gedcom.highlighter

import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.ui.JBColor
import java.awt.Font

val AT_COLOR    = JBColor(0x808080, 0xA9A9A9)  // gray
val META_COLOR  = JBColor(0xDA70D6, 0xFFB6C1)  // orchid
val ID_COLOR    = JBColor(0xDC143C, 0xFF6B6B)  // crimson
val INDI_COLOR  = JBColor(0xFFA500, 0xFFB84D)  // orange
val FAM_COLOR   = JBColor(0x1E90FF, 0x3399FF)  // dodgerblue
val VALUE_COLOR = JBColor(0x32CD32, 0x7CFC00)  // limegreen

/**
 * Suit both light and dark theming.
 */
@Suppress("Deprecation")  // We just need the constant for Font styling
object GedcomLanguageHighlights {
    val LEVEL_META: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "LEVEL_META",
        TextAttributes(META_COLOR, null, null, null, Font.PLAIN)
    )
    val LEVEL_INDI: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "LEVEL_INDI",
        TextAttributes(INDI_COLOR, null, null, null, Font.PLAIN)
    )
    val LEVEL_FAM: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "LEVEL_FAM",
        TextAttributes(FAM_COLOR, null, null, null, Font.PLAIN)
    )
    val AT: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "AT",
        TextAttributes(AT_COLOR, null, null, null, Font.PLAIN)
    )
    val POINTER: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "POINTER",
        TextAttributes(ID_COLOR, null, null, null, Font.BOLD)
    )
    val INDI_POINTER: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "INDI_POINTER",
        TextAttributes(INDI_COLOR, null, null, null, Font.BOLD)
    )
    val FAM_POINTER: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "FAM_POINTER",
        TextAttributes(FAM_COLOR, null, null, null, Font.BOLD)
    )
    val TAG_META: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "TAG_META",
        TextAttributes(META_COLOR, null, null, null, Font.BOLD)
    )
    val TAG_INDI: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "TAG_INDI",
        TextAttributes(INDI_COLOR, null, null, null, Font.BOLD)
    )
    val TAG_FAM: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "TAG_FAM",
        TextAttributes(FAM_COLOR, null, null, null, Font.BOLD)
    )
    val VALUE: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "VALUE",
        TextAttributes(VALUE_COLOR, null, null, null, Font.PLAIN)
    )
    val BAD_CHARACTER: TextAttributesKey = HighlighterColors.BAD_CHARACTER
}