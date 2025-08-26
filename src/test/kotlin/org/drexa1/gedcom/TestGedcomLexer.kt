package org.drexa1.gedcom

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import org.drexa1.gedcom.highlighter.GedcomLexer
import org.drexa1.gedcom.highlighter.GedcomTokens

@kotlin.concurrent.atomics.ExperimentalAtomicApi
class TestGedcomLexer: BasePlatformTestCase() {

    override fun getTestDataPath(): String = "src/test/resources"

    fun testLexer() {
        // GIVEN: a sample file
        val lexer = GedcomLexer()
        lexer.start(myFixture.configureByFile("sample.ged").text)
        // WHEN: the lexer tokenizes it from start to end
        while (true) {
            val tokenType = lexer.tokenType ?: break
            val tokenText = lexer.bufferSequence.subSequence(lexer.tokenStart, lexer.tokenEnd).toString()
            when (tokenType) {
                // THEN: each token type is captured correctly
                GedcomTokens.LEVEL           -> assert(tokenText.toIntOrNull() != null)
                GedcomTokens.AT              -> assert(tokenText == "@")
                GedcomTokens.POINTER         -> assert(tokenText.isNotEmpty())
                GedcomTokens.INDI_POINTER    -> assert(tokenText.startsWith('I'))
                GedcomTokens.FAM_POINTER     -> assert(tokenText.startsWith('F'))
                GedcomTokens.TAG             -> assert(tokenText.isNotEmpty())
                GedcomTokens.VALUE           -> assert(tokenText.isNotEmpty())
                GedcomTokens.WHITESPACE      -> assert(tokenText.single().isWhitespace())
                GedcomTokens.NEW_LINE_INDENT -> assert(tokenText.single().code == 10)
                GedcomTokens.BAD_CHARACTER   -> assert(tokenText.length == 1)
            }
            lexer.advance()
        }
    }
}