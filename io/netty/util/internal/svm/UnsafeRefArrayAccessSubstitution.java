package io.netty.util.internal.svm;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.RecomputeFieldValue.Kind;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className="io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess")
final class UnsafeRefArrayAccessSubstitution
{
  @Alias
  @RecomputeFieldValue(declClass=Object[].class, kind=RecomputeFieldValue.Kind.ArrayIndexShift)
  public static int REF_ELEMENT_SHIFT;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\svm\UnsafeRefArrayAccessSubstitution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */