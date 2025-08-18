package org.drexa1.gedcom

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon


object GedcomFileType : LanguageFileType(GedcomLanguage) {
    override fun getName() = "GEDCOM File"
    override fun getDescription() = "GEDCOM genealogy file"
    override fun getDefaultExtension() = "ged"
    override fun getIcon(): Icon? = GedcomIcons.FILE
}