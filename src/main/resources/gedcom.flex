%%

%class _GedcomLexer
%unicode
%cup
%implements com.intellij.lexer.Lexer
%function advance
%type com.intellij.psi.tree.IElementType
%char
%state YYINITIAL

%%

[0-9]+                 { return GedcomTokenTypes.NUMBER; }
[A-Z]+                 { return GedcomTokenTypes.TAG; }
\n                     { return GedcomTokenTypes.NEWLINE; }
[ \t]+                 { /* skip whitespace */ }
.                      { return GedcomTokenTypes.UNKNOWN; }
