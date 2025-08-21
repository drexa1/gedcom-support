package org.drexa1.gedcom.highlighter;

import com.intellij.psi.tree.IElementType;
import org.drexa1.gedcom.highlighter.GedcomTokens;

%%
%public
%class LTVGedcomLexer
%implements com.intellij.lexer.FlexLexer
%unicode
%function advance
%type IElementType

%{

// Detect numeric level
boolean isLevel(String text) {
    try {
        Integer.parseInt(text.trim());
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

%}

%state VALUE_STATE

%%

// Skip spaces and tabs
[ \t]+                  { /* skip whitespace */ }

/* Skip newline, but update lexer state */
(\r?\n)                 { /* skip newline */ }

/* Level numbers (0,1,2...) */
[0-9]+                  {
                            if (isLevel(yytext().toString())) {
                                return GedcomTokens.LEVEL;
                            } else {
                                return GedcomTokens.BAD_CHARACTER;
                            }
                        }

/* Tags: all caps letters and underscores */
[A-Z_]+                 { return GedcomTokens.TAG; }

/* Cross-reference IDs like @I0@ */
@[A-Z0-9]+@             { return GedcomTokens.VALUE; }

/* Everything else in VALUE state */
.                       { yybegin(VALUE_STATE); return GedcomTokens.VALUE; }


/* ======= VALUE_STATE rules ======= */
<VALUE_STATE>[^\n\r]+   {
                            yybegin(YYINITIAL);
                            return GedcomTokens.VALUE;
                        }

/* Any remaining single characters that don’t match above */
.                       { return GedcomTokens.BAD_CHARACTER; }
