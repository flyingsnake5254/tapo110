package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

public final class FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$3$lambda$1$1
  extends ContinuationImpl
{
  int label;
  
  public FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$3$lambda$1$1(d2 paramd2, c paramc)
  {
    super(paramc);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    throw null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$3$lambda$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */