// This is a generated file. Not intended for manual editing.
package org.drexa1.gedcom.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.drexa1.gedcom.psi.GedcomTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GedcomParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return gedcom(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // "A" | "B" | "C" | "D" | "E" | "F" | "G" | "H" | "I" | "J" | "K" | "L" | "M" | "N" | "O" | "P" | "Q" | "R" | "S" | "T" | "U" | "V" | "W" | "X" | "Y" | "Z"
  //           | "a" | "b" | "c" | "d" | "e" | "f" | "g" | "h" | "i" | "j" | "k" | "l" | "m" | "n" | "o" | "p" | "q" | "r" | "s" | "t" | "u" | "v" | "w" | "x" | "y" | "z"
  //           | "_"
  public static boolean ALPHA(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ALPHA")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ALPHA, "<alpha>");
    result_ = consumeToken(builder_, "A");
    if (!result_) result_ = consumeToken(builder_, "B");
    if (!result_) result_ = consumeToken(builder_, "C");
    if (!result_) result_ = consumeToken(builder_, "D");
    if (!result_) result_ = consumeToken(builder_, "E");
    if (!result_) result_ = consumeToken(builder_, "F");
    if (!result_) result_ = consumeToken(builder_, "G");
    if (!result_) result_ = consumeToken(builder_, "H");
    if (!result_) result_ = consumeToken(builder_, "I");
    if (!result_) result_ = consumeToken(builder_, "J");
    if (!result_) result_ = consumeToken(builder_, "K");
    if (!result_) result_ = consumeToken(builder_, "L");
    if (!result_) result_ = consumeToken(builder_, "M");
    if (!result_) result_ = consumeToken(builder_, "N");
    if (!result_) result_ = consumeToken(builder_, "O");
    if (!result_) result_ = consumeToken(builder_, "P");
    if (!result_) result_ = consumeToken(builder_, "Q");
    if (!result_) result_ = consumeToken(builder_, "R");
    if (!result_) result_ = consumeToken(builder_, "S");
    if (!result_) result_ = consumeToken(builder_, "T");
    if (!result_) result_ = consumeToken(builder_, "U");
    if (!result_) result_ = consumeToken(builder_, "V");
    if (!result_) result_ = consumeToken(builder_, "W");
    if (!result_) result_ = consumeToken(builder_, "X");
    if (!result_) result_ = consumeToken(builder_, "Y");
    if (!result_) result_ = consumeToken(builder_, "Z");
    if (!result_) result_ = consumeToken(builder_, "a");
    if (!result_) result_ = consumeToken(builder_, "b");
    if (!result_) result_ = consumeToken(builder_, "c");
    if (!result_) result_ = consumeToken(builder_, "d");
    if (!result_) result_ = consumeToken(builder_, "e");
    if (!result_) result_ = consumeToken(builder_, "f");
    if (!result_) result_ = consumeToken(builder_, "g");
    if (!result_) result_ = consumeToken(builder_, "h");
    if (!result_) result_ = consumeToken(builder_, "i");
    if (!result_) result_ = consumeToken(builder_, "j");
    if (!result_) result_ = consumeToken(builder_, "k");
    if (!result_) result_ = consumeToken(builder_, "l");
    if (!result_) result_ = consumeToken(builder_, "m");
    if (!result_) result_ = consumeToken(builder_, "n");
    if (!result_) result_ = consumeToken(builder_, "o");
    if (!result_) result_ = consumeToken(builder_, "p");
    if (!result_) result_ = consumeToken(builder_, "q");
    if (!result_) result_ = consumeToken(builder_, "r");
    if (!result_) result_ = consumeToken(builder_, "s");
    if (!result_) result_ = consumeToken(builder_, "t");
    if (!result_) result_ = consumeToken(builder_, "u");
    if (!result_) result_ = consumeToken(builder_, "v");
    if (!result_) result_ = consumeToken(builder_, "w");
    if (!result_) result_ = consumeToken(builder_, "x");
    if (!result_) result_ = consumeToken(builder_, "y");
    if (!result_) result_ = consumeToken(builder_, "z");
    if (!result_) result_ = consumeToken(builder_, "_");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
  public static boolean DIGIT(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DIGIT")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, DIGIT, "<digit>");
    result_ = consumeToken(builder_, "0");
    if (!result_) result_ = consumeToken(builder_, "1");
    if (!result_) result_ = consumeToken(builder_, "2");
    if (!result_) result_ = consumeToken(builder_, "3");
    if (!result_) result_ = consumeToken(builder_, "4");
    if (!result_) result_ = consumeToken(builder_, "5");
    if (!result_) result_ = consumeToken(builder_, "6");
    if (!result_) result_ = consumeToken(builder_, "7");
    if (!result_) result_ = consumeToken(builder_, "8");
    if (!result_) result_ = consumeToken(builder_, "9");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  public static boolean EOF(PsiBuilder builder_, int level_) {
    Marker marker_ = enter_section_(builder_);
    exit_section_(builder_, marker_, EOF, true);
    return true;
  }

  /* ********************************************************** */
  // "\r" | "\n" | "\r\n"
  public static boolean EOL(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "EOL")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EOL, "<eol>");
    result_ = consumeToken(builder_, "\r");
    if (!result_) result_ = consumeToken(builder_, "\n");
    if (!result_) result_ = consumeToken(builder_, "\r\n");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // <ALPHA> | <DIGIT>
  public static boolean alphanum(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "alphanum")) return false;
    if (!nextTokenIs(builder_, "<alphanum>", ALPHA, DIGIT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ALPHANUM, "<alphanum>");
    result_ = ALPHA(builder_, level_ + 1);
    if (!result_) result_ = DIGIT(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // <ALPHA> | <DIGIT> | <otherchar> | "#" | "@@"
  public static boolean anychar(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "anychar")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ANYCHAR, "<anychar>");
    result_ = ALPHA(builder_, level_ + 1);
    if (!result_) result_ = DIGIT(builder_, level_ + 1);
    if (!result_) result_ = otherchar(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, "#");
    if (!result_) result_ = consumeToken(builder_, "@@");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // "@" "#" <escape_text> "@" <non_at>
  public static boolean escape(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "escape")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ESCAPE, "<escape>");
    result_ = consumeToken(builder_, "@");
    result_ = result_ && consumeToken(builder_, "#");
    result_ = result_ && escape_text(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, "@");
    result_ = result_ && non_at(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // <anychar>+
  public static boolean escape_text(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "escape_text")) return false;
    if (!nextTokenIs(builder_, ANYCHAR)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = anychar(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!anychar(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "escape_text", pos_)) break;
    }
    exit_section_(builder_, marker_, ESCAPE_TEXT, result_);
    return result_;
  }

  /* ********************************************************** */
  // <line>+ <EOF>
  static boolean gedcom(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "gedcom")) return false;
    if (!nextTokenIs(builder_, LINE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = gedcom_0(builder_, level_ + 1);
    result_ = result_ && EOF(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // <line>+
  private static boolean gedcom_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "gedcom_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = line(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!line(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "gedcom_0", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // <DIGIT>+
  public static boolean level(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "level")) return false;
    if (!nextTokenIs(builder_, DIGIT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = DIGIT(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!DIGIT(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "level", pos_)) break;
    }
    exit_section_(builder_, marker_, LEVEL, result_);
    return result_;
  }

  /* ********************************************************** */
  // <level> <opt_xref_id>? <tag> <line_value>? <EOL>
  public static boolean line(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "line")) return false;
    if (!nextTokenIs(builder_, LEVEL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = level(builder_, level_ + 1);
    result_ = result_ && line_1(builder_, level_ + 1);
    result_ = result_ && tag(builder_, level_ + 1);
    result_ = result_ && line_3(builder_, level_ + 1);
    result_ = result_ && EOL(builder_, level_ + 1);
    exit_section_(builder_, marker_, LINE, result_);
    return result_;
  }

  // <opt_xref_id>?
  private static boolean line_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "line_1")) return false;
    opt_xref_id(builder_, level_ + 1);
    return true;
  }

  // <line_value>?
  private static boolean line_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "line_3")) return false;
    line_value(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // <pointer> | <escape> | <anychar>
  public static boolean line_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "line_item")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LINE_ITEM, "<line item>");
    result_ = pointer(builder_, level_ + 1);
    if (!result_) result_ = escape(builder_, level_ + 1);
    if (!result_) result_ = anychar(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // <line_item>+
  public static boolean line_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "line_value")) return false;
    if (!nextTokenIs(builder_, LINE_ITEM)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = line_item(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!line_item(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "line_value", pos_)) break;
    }
    exit_section_(builder_, marker_, LINE_VALUE, result_);
    return result_;
  }

  /* ********************************************************** */
  // <ALPHA> | <DIGIT> | <otherchar> | "#"
  public static boolean non_at(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "non_at")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NON_AT, "<non at>");
    result_ = ALPHA(builder_, level_ + 1);
    if (!result_) result_ = DIGIT(builder_, level_ + 1);
    if (!result_) result_ = otherchar(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, "#");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // <pointer>
  public static boolean opt_xref_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "opt_xref_id")) return false;
    if (!nextTokenIs(builder_, POINTER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = pointer(builder_, level_ + 1);
    exit_section_(builder_, marker_, OPT_XREF_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // "!" | '"' | "$" | "&" | "'" | "(" | ")" | "*" | "+" | "-" | "," | "." | "/"
  public static boolean otherchar(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "otherchar")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OTHERCHAR, "<otherchar>");
    result_ = consumeToken(builder_, "!");
    if (!result_) result_ = consumeToken(builder_, "\"");
    if (!result_) result_ = consumeToken(builder_, "$");
    if (!result_) result_ = consumeToken(builder_, "&");
    if (!result_) result_ = consumeToken(builder_, "'");
    if (!result_) result_ = consumeToken(builder_, "(");
    if (!result_) result_ = consumeToken(builder_, ")");
    if (!result_) result_ = consumeToken(builder_, "*");
    if (!result_) result_ = consumeToken(builder_, "+");
    if (!result_) result_ = consumeToken(builder_, "-");
    if (!result_) result_ = consumeToken(builder_, ",");
    if (!result_) result_ = consumeToken(builder_, ".");
    if (!result_) result_ = consumeToken(builder_, "/");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // "@" <alphanum> <pointer_string> "@"
  public static boolean pointer(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "pointer")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, POINTER, "<pointer>");
    result_ = consumeToken(builder_, "@");
    result_ = result_ && alphanum(builder_, level_ + 1);
    result_ = result_ && pointer_string(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, "@");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // <ALPHA> | <DIGIT> | <otherchar> | "#"
  public static boolean pointer_char(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "pointer_char")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, POINTER_CHAR, "<pointer char>");
    result_ = ALPHA(builder_, level_ + 1);
    if (!result_) result_ = DIGIT(builder_, level_ + 1);
    if (!result_) result_ = otherchar(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, "#");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // <pointer_char>+
  public static boolean pointer_string(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "pointer_string")) return false;
    if (!nextTokenIs(builder_, POINTER_CHAR)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = pointer_char(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!pointer_char(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "pointer_string", pos_)) break;
    }
    exit_section_(builder_, marker_, POINTER_STRING, result_);
    return result_;
  }

  /* ********************************************************** */
  // <alphanum>+
  public static boolean tag(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tag")) return false;
    if (!nextTokenIs(builder_, ALPHANUM)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = alphanum(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!alphanum(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "tag", pos_)) break;
    }
    exit_section_(builder_, marker_, TAG, result_);
    return result_;
  }

}
