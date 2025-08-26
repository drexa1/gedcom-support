// This is a generated file. Not intended for manual editing.
package org.drexa1.gedcom.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.drexa1.gedcom.psi.impl.*;

public interface GedcomTypes {

  IElementType ALPHA = new IElementType("ALPHA", null);
  IElementType ALPHANUM = new IElementType("ALPHANUM", null);
  IElementType ANYCHAR = new IElementType("ANYCHAR", null);
  IElementType DIGIT = new IElementType("DIGIT", null);
  IElementType EOF = new IElementType("EOF", null);
  IElementType EOL = new IElementType("EOL", null);
  IElementType ESCAPE = new IElementType("ESCAPE", null);
  IElementType ESCAPE_TEXT = new IElementType("ESCAPE_TEXT", null);
  IElementType LEVEL = new IElementType("LEVEL", null);
  IElementType LINE = new IElementType("LINE", null);
  IElementType LINE_ITEM = new IElementType("LINE_ITEM", null);
  IElementType LINE_VALUE = new IElementType("LINE_VALUE", null);
  IElementType NON_AT = new IElementType("NON_AT", null);
  IElementType OPT_XREF_ID = new IElementType("OPT_XREF_ID", null);
  IElementType OTHERCHAR = new IElementType("OTHERCHAR", null);
  IElementType POINTER = new IElementType("POINTER", null);
  IElementType POINTER_CHAR = new IElementType("POINTER_CHAR", null);
  IElementType POINTER_STRING = new IElementType("POINTER_STRING", null);
  IElementType TAG = new IElementType("TAG", null);


  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ALPHA) {
        return new GedcomAlphaImpl(node);
      }
      else if (type == ALPHANUM) {
        return new GedcomAlphanumImpl(node);
      }
      else if (type == ANYCHAR) {
        return new GedcomAnycharImpl(node);
      }
      else if (type == DIGIT) {
        return new GedcomDigitImpl(node);
      }
      else if (type == EOF) {
        return new GedcomEofImpl(node);
      }
      else if (type == EOL) {
        return new GedcomEolImpl(node);
      }
      else if (type == ESCAPE) {
        return new GedcomEscapeImpl(node);
      }
      else if (type == ESCAPE_TEXT) {
        return new GedcomEscapeTextImpl(node);
      }
      else if (type == LEVEL) {
        return new GedcomLevelImpl(node);
      }
      else if (type == LINE) {
        return new GedcomLineImpl(node);
      }
      else if (type == LINE_ITEM) {
        return new GedcomLineItemImpl(node);
      }
      else if (type == LINE_VALUE) {
        return new GedcomLineValueImpl(node);
      }
      else if (type == NON_AT) {
        return new GedcomNonAtImpl(node);
      }
      else if (type == OPT_XREF_ID) {
        return new GedcomOptXrefIdImpl(node);
      }
      else if (type == OTHERCHAR) {
        return new GedcomOthercharImpl(node);
      }
      else if (type == POINTER) {
        return new GedcomPointerImpl(node);
      }
      else if (type == POINTER_CHAR) {
        return new GedcomPointerCharImpl(node);
      }
      else if (type == POINTER_STRING) {
        return new GedcomPointerStringImpl(node);
      }
      else if (type == TAG) {
        return new GedcomTagImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
