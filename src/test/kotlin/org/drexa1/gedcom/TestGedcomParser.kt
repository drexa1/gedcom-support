package org.drexa1.gedcom

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import org.drexa1.gedcom.psi.GedcomPointer
import kotlin.test.assertNull

class GedcomReferenceTest: BasePlatformTestCase() {

    override fun getTestDataPath(): String = "src/test/resources"

    override fun setUp() {
        super.setUp()
    }

    fun testPointerReferenceResolves() {
        // GIVEN: a sample file
        val gedcomSample = myFixture.configureByFile("sample.ged")
        // WHEN: the caret is placed on the @I...@ reference inside family record HUSB tag
        val offset = gedcomSample.text.indexOf("@I0@", gedcomSample.text.indexOf("HUSB"))
        myFixture.editor.caretModel.moveToOffset(offset)
        val pointer = myFixture.elementAtCaret as? GedcomPointer
        // THEN: should resolve to the level-0 definition of @I...@
        val resolved = pointer?.reference?.resolve()
        assertNotNull(resolved)
    }

    fun testLevel0DefinitionHasNoReference() {
        // GIVEN: a sample file
        val gedcomSample = myFixture.configureByFile("sample.ged")
        // WHEN:
        val offset = gedcomSample.text.indexOf("@I0@")
        myFixture.editor.caretModel.moveToOffset(offset)
        val pointer = myFixture.elementAtCaret as? GedcomPointer
        // THEN:
        assertNull(pointer?.reference, "Level-0 definitions should not have a reference")
    }

    fun testHandleElementRenameUpdatesPointer() {
        // GIVEN: a sample file
        val gedcomSample = myFixture.configureByFile("sample.ged")
        // WHEN:
        val offset = gedcomSample.text.indexOf("@I0@", gedcomSample.text.indexOf("HUSB"))
        myFixture.editor.caretModel.moveToOffset(offset)
        val pointer = myFixture.elementAtCaret as GedcomPointer
        val newElement = pointer.reference!!.handleElementRename("@I42@")
        // THEN:
        assertEquals("@I42@", newElement.text)
    }
}