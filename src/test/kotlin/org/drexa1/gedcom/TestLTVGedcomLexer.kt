package org.drexa1.gedcom

import com.intellij.lexer.FlexAdapter
import org.drexa1.gedcom.highlighter.GedcomTokens
import org.drexa1.gedcom.highlighter.LTVGedcomLexer
import java.io.File
import kotlin.test.Test

@Suppress("MISSING_DEPENDENCY_SUPERCLASS_WARNING")
class TestLTVGedcomLexer {

    @Test
    fun testLexer() {
        // GIVEN
        val resource = object {}.javaClass.classLoader.getResource("sample.ged")
            ?: throw IllegalArgumentException("sample.ged not found")
        val gedcomText = File(resource.toURI()).readText()
        val lexer = FlexAdapter(LTVGedcomLexer(null))
        lexer.start(gedcomText)
        // GIVEN
        while (true) {
            val tokenType = lexer.tokenType ?: break
            val tokenText = lexer.bufferSequence.subSequence(lexer.tokenStart, lexer.tokenEnd).toString().trim()
            println("Token: $tokenType -> '$tokenText'")
            // THEN
            when (tokenType) {
                GedcomTokens.LEVEL -> assert(tokenText.toIntOrNull() != null) { "LEVEL token is not numeric: $tokenText" }
                GedcomTokens.VALUE -> assert(tokenText.isNotEmpty()) { "VALUE token is empty" }
                GedcomTokens.TAG -> assert(tokenText.isNotEmpty()) { "TAG token invalid: $tokenText" }
                GedcomTokens.BAD_CHARACTER -> assert(tokenText.length == 1) { "BAD_CHARACTER token invalid length: $tokenText" }
            }
            lexer.advance()
        }
    }
}