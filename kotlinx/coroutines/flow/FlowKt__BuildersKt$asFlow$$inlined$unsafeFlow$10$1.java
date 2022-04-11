package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@kotlin.coroutines.jvm.internal.d(c="kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10", f="Builders.kt", l={128}, m="collect")
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1
  extends ContinuationImpl
{
  long J$0;
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  Object L$6;
  int label;
  
  public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1(d paramd, c paramc)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */