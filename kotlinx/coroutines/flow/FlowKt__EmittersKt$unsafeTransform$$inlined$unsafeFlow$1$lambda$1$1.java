package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

public final class FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1$lambda$1$1
  extends ContinuationImpl
{
  int label;
  
  public FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1$lambda$1$1(c0 paramc0, c paramc)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1$lambda$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */