package org.drexa1.gedcom

import com.intellij.lexer.FlexAdapter
import org.drexa1.gedcom.highlighter.GedcomLexer
import org.drexa1.gedcom.highlighter.GedcomTokens
import java.io.File
import kotlin.test.Test

class TestGedcomLexer {

    @Test
    fun testLexer() {
        // GIVEN
        val resource = object {}.javaClass.classLoader.getResource("sample.ged")
            ?: throw IllegalArgumentException("sample.ged not found")
        val gedcomText = File(resource.toURI()).readText()
        val lexer = FlexAdapter(GedcomLexer(null))
        lexer.start(gedcomText)
        // GIVEN
        while (true) {
            val tokenType = lexer.tokenType ?: break
            val tokenText = lexer.bufferSequence.subSequence(lexer.tokenStart, lexer.tokenEnd).toString()
            println("Token: $tokenType -> '$tokenText'")
            // THEN
            if (tokenType == GedcomTokens.LEVEL) {
                assert(tokenText.toIntOrNull() != null) { "LEVEL token is not numeric: $tokenText" }
            }
            lexer.advance()
        }
    }
}