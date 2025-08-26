// This is a generated file. Not intended for manual editing.
package org.drexa1.gedcom.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GedcomLine extends PsiElement {

  @NotNull
  GedcomEol getEol();

  @NotNull
  GedcomLevel getLevel();

  @Nullable
  GedcomLineValue getLineValue();

  @Nullable
  GedcomOptXrefId getOptXrefId();

  @NotNull
  GedcomTag getTag();

}
