package org.drexa1.gedcom

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class GedcomFileType : LanguageFileType(GedcomLanguage) {
    override fun getName(): String = "GEDCOM File"
    override fun getDescription(): String = "GEDCOM genealogy file"
    override fun getDefaultExtension(): String = "ged"
    override fun getIcon(): Icon = GedcomIcons.FILE
}