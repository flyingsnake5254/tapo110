package kotlin.coroutines.intrinsics;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.b.l;
import kotlin.k;

public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
  extends RestrictedContinuationImpl
{
  private int label;
  
  public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1(l paraml, c paramc1, c paramc2)
  {
    super(paramc2);
  }
  
  protected Object invokeSuspend(Object paramObject)
  {
    int i = this.label;
    if (i != 0)
    {
      if (i == 1)
      {
        this.label = 2;
        k.b(paramObject);
      }
      else
      {
        throw new IllegalStateException("This coroutine had already completed".toString());
      }
    }
    else
    {
      this.label = 1;
      k.b(paramObject);
      paramObject = this.$block.invoke(this);
    }
    return paramObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\intrinsics\IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */