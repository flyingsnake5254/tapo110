package io.netty.util.internal.svm;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.RecomputeFieldValue.Kind;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className="io.netty.util.internal.CleanerJava6")
final class CleanerJava6Substitution
{
  @Alias
  @RecomputeFieldValue(declClassName="java.nio.DirectByteBuffer", kind=RecomputeFieldValue.Kind.FieldOffset, name="cleaner")
  private static long CLEANER_FIELD_OFFSET;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\svm\CleanerJava6Substitution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */