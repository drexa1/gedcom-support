package org.drexa1.gedcom

import org.drexa1.gedcom.highlighter.GedcomLexer
import java.io.File
import kotlin.test.Test

@kotlin.concurrent.atomics.ExperimentalAtomicApi
class TestGedcomLexer {

    @Test
    fun testLexer() {
        // GIVEN
        val resource = object {}.javaClass.classLoader.getResource("sample.ged")
            ?: throw IllegalArgumentException("sample.ged not found")
        val gedcomText = File(resource.toURI()).readText()
        // val lexer = FlexAdapter(FlexGedcomLexer(null))
        val lexer = GedcomLexer()
        lexer.start(gedcomText)
        // GIVEN
        while (true) {
            val tokenType = lexer.tokenType ?: break
            val tokenText = lexer.bufferSequence.subSequence(lexer.tokenStart, lexer.tokenEnd).toString()
            // THEN
            when (tokenType) {
                GedcomTokens.LEVEL -> assert(tokenText.toIntOrNull() != null)
                GedcomTokens.AT -> assert(tokenText == "@")
                GedcomTokens.POINTER -> assert(tokenText.isNotEmpty())
                GedcomTokens.INDI_POINTER -> assert(tokenText.startsWith('I'))
                GedcomTokens.FAM_POINTER -> assert(tokenText.startsWith('F'))
                GedcomTokens.TAG -> assert(tokenText.isNotEmpty())
                GedcomTokens.VALUE -> assert(tokenText.isNotEmpty())
                GedcomTokens.WHITESPACE -> assert(tokenText.single().isWhitespace())
                GedcomTokens.NEW_LINE_INDENT -> assert(tokenText.single().code == 10)
                GedcomTokens.BAD_CHARACTER -> assert(tokenText.length == 1)
            }
            lexer.advance()
        }
    }
}