package org.drexa1.gedcom.references

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import org.drexa1.gedcom.GedcomFileType
import org.drexa1.gedcom.psi.GedcomLevel
import org.drexa1.gedcom.psi.GedcomLine
import org.drexa1.gedcom.psi.GedcomPointer

object GedcomUtils {

    val GedcomFileTypeInstance: GedcomFileType = GedcomFileType()

    fun findPointers(project: Project, id: String): MutableCollection<GedcomPointer> {
        val result: MutableCollection<GedcomPointer> = ArrayList()
        val files = FileTypeIndex.getFiles(GedcomFileTypeInstance, GlobalSearchScope.projectScope(project))
        for (vf in files) {
            val psi = PsiManager.getInstance(project).findFile(vf) ?: continue
            val pointers: Collection<GedcomPointer> = PsiTreeUtil.findChildrenOfType(psi, GedcomPointer::class.java)
            for (p in pointers) {
                if (id == p.text) result.add(p)
            }
        }
        return result
    }

    fun findAllPointers(project: Project): MutableCollection<GedcomPointer> {
        val result: MutableCollection<GedcomPointer> = ArrayList()
        val files = FileTypeIndex.getFiles(GedcomFileTypeInstance, GlobalSearchScope.projectScope(project))
        for (vf in files) {
            val psi = PsiManager.getInstance(project).findFile(vf) ?: continue
            result.addAll(PsiTreeUtil.findChildrenOfType(psi, GedcomPointer::class.java))
        }
        return result
    }

    fun isDefinition(pointer: GedcomPointer?): Boolean {
        val line: GedcomLine = PsiTreeUtil.getParentOfType(pointer, GedcomLine::class.java) ?: return false
        val lvl: GedcomLevel? = PsiTreeUtil.findChildOfType(line, GedcomLevel::class.java)
        return lvl != null && lvl.text.trim() == "0"
    }
}
