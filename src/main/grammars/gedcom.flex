package org.drexa1.gedcom.highlighter;

import com.intellij.psi.tree.IElementType;
import org.drexa1.gedcom.highlighter.GedcomTokens;

%%
%public
%class GedcomLexer
%implements com.intellij.lexer.FlexLexer
%unicode
%function advance
%type IElementType

%{

// Detect numeric level
private boolean isLevel(String text) {
    try {
        Integer.parseInt(text);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

%}

%state VALUE_STATE

%%

[ \t]+                     { /* skip whitespace */ }

[0-9]+                     {
if (isLevel(yytext().toString())) {
        return GedcomTokens.LEVEL;
    } else {
        return GedcomTokens.BAD_CHARACTER;
    }
}

@[A-Z0-9]+@                { return GedcomTokens.VALUE; }  // cross-reference ID

[A-Z_]+                     { return GedcomTokens.TAG; }

\n                          { /* skip newline */ }

.                          { yybegin(VALUE_STATE); return GedcomTokens.VALUE; }

<VALUE_STATE>[^\\n]+        {
    yybegin(YYINITIAL);
    return GedcomTokens.VALUE;
}

.                           { return GedcomTokens.BAD_CHARACTER; }
