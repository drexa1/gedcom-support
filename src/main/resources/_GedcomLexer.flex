%{
import com.intellij.psi.tree.IElementType;
%}

%class _GedcomLexer
%unicode
%function advance
%type TAG VALUE COMMENT

%%

"0"|"1"|"2"|"3"|"4"|"5"|"6"|"7"|"8"|"9" { return new TAG("TAG"); }
"@[^@]+@"                             { return new TAG("TAG"); }
"INDI"|"FAM"|"BIRT"|"DEAT"|"NAME"|"SEX"|"DATE"|"PLAC" { return new TAG("TAG"); }
"\\s+.*"                               { return new VALUE("VALUE"); }
"\\n"                                  { return null; }
