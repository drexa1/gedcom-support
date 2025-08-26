// This is a generated file. Not intended for manual editing.
package org.drexa1.gedcom.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.drexa1.gedcom.psi.GedcomTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.drexa1.gedcom.psi.*;

public class GedcomPointerCharImpl extends ASTWrapperPsiElement implements GedcomPointerChar {

  public GedcomPointerCharImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GedcomVisitor visitor) {
    visitor.visitPointerChar(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GedcomVisitor) accept((GedcomVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GedcomAlpha getAlpha() {
    return findChildByClass(GedcomAlpha.class);
  }

  @Override
  @Nullable
  public GedcomDigit getDigit() {
    return findChildByClass(GedcomDigit.class);
  }

  @Override
  @Nullable
  public GedcomOtherchar getOtherchar() {
    return findChildByClass(GedcomOtherchar.class);
  }

}
