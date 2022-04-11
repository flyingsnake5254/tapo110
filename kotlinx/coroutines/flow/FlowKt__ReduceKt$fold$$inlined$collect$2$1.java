package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c="kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$2", f="Reduce.kt", l={136}, m="emit")
public final class FlowKt__ReduceKt$fold$$inlined$collect$2$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  int label;
  
  public FlowKt__ReduceKt$fold$$inlined$collect$2$1(FlowKt__ReduceKt.a parama, c paramc)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\FlowKt__ReduceKt$fold$$inlined$collect$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */