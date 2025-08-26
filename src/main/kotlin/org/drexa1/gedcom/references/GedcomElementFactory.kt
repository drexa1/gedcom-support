package org.drexa1.gedcom.references

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import org.drexa1.gedcom.GedcomFileType
import org.drexa1.gedcom.psi.GedcomPointer

object GedcomElementFactory {

    /**
     * Create a temporary file that contains the pointer text and parse it to extract a Pointer node.
     * i.e: "@I0@"
     */
    fun createPointer(project: Project, newPointerText: String): GedcomPointer? {
        // Put it on a minimal line so parser produces a Pointer node
        val fileText = "0 $newPointerText DUMMY\n"
        val file: PsiFile = PsiFileFactory.getInstance(project).createFileFromText("dummy.ged", GedcomFileType(), fileText)
        return PsiTreeUtil.findChildOfType(file, GedcomPointer::class.java)
    }
}