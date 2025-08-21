package org.drexa1.gedcom

import org.drexa1.gedcom.highlighter._GedcomLexer
import java.io.File
import kotlin.test.Test

class TestGedcomLexer {

    @Test
    fun testLexer() {
        val resource = object {}.javaClass.classLoader.getResource("sample.ged")
            ?: throw IllegalArgumentException("sample.ged not found")
        val gedcomText = File(resource.toURI()).readText()

        val lexer = _GedcomLexer()
        lexer.start(gedcomText)
        while (lexer.tokenType != null) {
            println(lexer.tokenType)
            lexer.advance()
        }
    }
}