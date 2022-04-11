package io.netty.util.internal.svm;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.RecomputeFieldValue.Kind;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className="io.netty.util.internal.PlatformDependent")
final class PlatformDependentSubstitution
{
  @Alias
  @RecomputeFieldValue(declClass=byte[].class, kind=RecomputeFieldValue.Kind.ArrayBaseOffset)
  private static long BYTE_ARRAY_BASE_OFFSET;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\svm\PlatformDependentSubstitution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */