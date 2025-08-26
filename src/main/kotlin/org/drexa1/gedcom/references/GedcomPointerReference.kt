package org.drexa1.gedcom.references

import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import org.drexa1.gedcom.psi.GedcomPointer

class GedcomPointerReference(element: GedcomPointer, rangeInElement: TextRange?) :

    PsiReferenceBase<GedcomPointer?>(element, rangeInElement, false) {
    override fun resolve(): PsiElement? {
        val id: String = element.text.trim()
        val targets: MutableCollection<GedcomPointer> = GedcomUtils.findPointers(element.project, id)
        for (p in targets) {
            // Prefer a level-0 definition
            if (GedcomUtils.isDefinition(p)) return p
        }
        return targets.stream().findFirst().orElse(null)
    }

    override fun getVariants(): Array<Any?> {
        val all: MutableCollection<GedcomPointer> = GedcomUtils.findAllPointers(element.project)
        return all.stream()
            .map<Any?>(GedcomPointer::getText)
            .distinct()
            .map { `object`: Any? -> LookupElementBuilder.create(`object`!!) }
            .toArray()
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        val newPtr = GedcomElementFactory.createPointer(element.project, newElementName) ?: return element
        return element.replace(newPtr)
    }
}