package org.drexa1.gedcom

import com.intellij.lexer.FlexAdapter
import java.io.Reader

// Adapter for IntelliJ to use the JFlex-generated GedcomLexer
class GedcomLexerAdapter : FlexAdapter(GedcomLexer(null as Reader?))