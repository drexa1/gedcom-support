package org.drexa1.gedcom.highlighter

import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import org.drexa1.gedcom.IconProvider
import javax.swing.Icon

class GedcomColorSettingsPage : ColorSettingsPage {

    private val attributesDescriptors = arrayOf(
        AttributesDescriptor("Level", DefaultLanguageHighlighterColors.KEYWORD),
        AttributesDescriptor("At symbol", DefaultLanguageHighlighterColors.MARKUP_TAG),
        AttributesDescriptor("Pointer", DefaultLanguageHighlighterColors.MARKUP_ENTITY),
        AttributesDescriptor("Individual pointer", DefaultLanguageHighlighterColors.MARKUP_ENTITY),
        AttributesDescriptor("Family pointer", DefaultLanguageHighlighterColors.MARKUP_ENTITY),
        AttributesDescriptor("Tag", DefaultLanguageHighlighterColors.KEYWORD),
        AttributesDescriptor("Value", DefaultLanguageHighlighterColors.STRING),
        AttributesDescriptor("Bad character", HighlighterColors.BAD_CHARACTER),
    )

    override fun getDisplayName(): String = "GEDCOM"
    override fun getIcon(): Icon = IconProvider.FILE
    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = attributesDescriptors
    override fun getColorDescriptors() = emptyArray<com.intellij.openapi.options.colors.ColorDescriptor>()
    override fun getHighlighter() = GedcomSyntaxHighlighter()

    override fun getDemoText(): String {
        val stream = javaClass.getResourceAsStream("/sample.ged") ?: return "Could not load demo GEDCOM text."
        return stream.bufferedReader().use { it.readText() }
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, com.intellij.openapi.editor.colors.TextAttributesKey>? {
        return null
    }
}