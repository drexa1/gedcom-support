package org.drexa1.gedcom

import java.io.File

fun main() {
    val resource = object {}.javaClass.classLoader.getResource("sample.ged")
        ?: throw IllegalArgumentException("sample.ged not found")
    val gedcomText = File(resource.toURI()).readText()

    val lexer = GedcomLexer()
    lexer.start(gedcomText)
    // TODO: implement
}