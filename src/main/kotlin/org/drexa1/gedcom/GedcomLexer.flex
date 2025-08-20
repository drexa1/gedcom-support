%%

%class GedcomLexer
%unicode
%cup
%implements java_cup.runtime.Scanner
%function yylex
%type GedcomToken
%char
%line

%%

<YYINITIAL>{

    // Level number
    ^[0-9]+ { return token(GedcomTokenTypes.LEVEL); }

    // INDI ID line, e.g., 0 @I0@ INDI
    ^0[ \t]+(@I[^@]+@)[ \t]+INDI {
        return token(GedcomTokenTypes.INDI_ID);
    }

    // FAM ID line
    ^0[ \t]+(@F[^@]+@)[ \t]+FAM {
        return token(GedcomTokenTypes.FAM_ID);
    }

    // Level 0 other
    ^0[ \t]+[A-Z]+ {
        return token(GedcomTokenTypes.META);
    }

    // Level 1 or 2 lines: tag + value
    ^[1-9][0-9]*[ \t]+([A-Z]+)([ \t]+.*)? {
        // Emit LEVEL token first
        token(GedcomTokenTypes.LEVEL, yytext().substring(0, 1));
        // Emit TAG token
        token(GedcomTokenTypes.TAG, yytext().substring(matchedTagStart, matchedTagEnd));
        // Emit VALUE token if present
        if (matchedValue != null) token(GedcomTokenTypes.VALUE, matchedValue);
    }

    // Fallback for unknown
    . { return token(GedcomTokenTypes.BAD_CHARACTER); }
}