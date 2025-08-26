package org.drexa1.gedcom.references

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import org.drexa1.gedcom.psi.GedcomPointer
import com.intellij.psi.*

class GedcomReferenceContributor : PsiReferenceContributor() {

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(GedcomPointer::class.java), referenceProvider())
    }

    fun referenceProvider(): PsiReferenceProvider = object : PsiReferenceProvider() {
        override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference?> {
            if (element !is GedcomPointer) return PsiReference.EMPTY_ARRAY
            val pointer: GedcomPointer = element
            // If the pointer is level 0 no need to create a reference
            if (GedcomUtils.isDefinition(pointer)) return PsiReference.EMPTY_ARRAY
            val range = TextRange(0, element.textLength)
            return arrayOf(GedcomPointerReference(pointer, range))
        }
    }
}