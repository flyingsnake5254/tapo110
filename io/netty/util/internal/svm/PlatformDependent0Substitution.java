package io.netty.util.internal.svm;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.RecomputeFieldValue.Kind;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className="io.netty.util.internal.PlatformDependent0")
final class PlatformDependent0Substitution
{
  @Alias
  @RecomputeFieldValue(declClassName="java.nio.Buffer", kind=RecomputeFieldValue.Kind.FieldOffset, name="address")
  private static long ADDRESS_FIELD_OFFSET;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\svm\PlatformDependent0Substitution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */