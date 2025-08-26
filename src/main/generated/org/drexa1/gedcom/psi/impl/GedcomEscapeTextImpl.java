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

public class GedcomEscapeTextImpl extends ASTWrapperPsiElement implements GedcomEscapeText {

  public GedcomEscapeTextImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GedcomVisitor visitor) {
    visitor.visitEscapeText(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GedcomVisitor) accept((GedcomVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GedcomAnychar> getAnycharList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GedcomAnychar.class);
  }

}
