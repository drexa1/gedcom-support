package org.drexa1.gedcom.highlighter;

import com.intellij.psi.tree.IElementType;
import org.drexa1.gedcom.psi.GedcomTypes;

%%
%public
%class FlexGedcomLexer
%implements com.intellij.lexer.FlexLexer
%unicode
%function advance
%type IElementType

// Lexer macros
ALPHA     = [a-zA-Z_]
DIGIT     = [0-9]
OTHERCHAR = [\-!\"$&'()*+,./]
POINTER   = "@"({ALPHA}+|{DIGIT}+)"@"
ESCAPE    = "@#"({ALPHA}+|{DIGIT}+)"@"({ALPHA}+|{DIGIT}+)
EOL       = \r\n|\r|\n
WS        = [ \t]+

%%

// Rules
<YYINITIAL> {
  {EOL}       { return GedcomTypes.EOL; }
  {POINTER}   { return GedcomTypes.POINTER; }
  {ESCAPE}    { return GedcomTypes.ESCAPE; }
  {ALPHA}     { return GedcomTypes.ALPHA; }
  {DIGIT}     { return GedcomTypes.DIGIT; }
  {OTHERCHAR} { return GedcomTypes.OTHERCHAR; }
  {WS}        { /* skip whitespace */ }
}