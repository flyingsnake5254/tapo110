package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c="kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f="Emitters.kt", l={128, 131, 131}, m="collect")
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  int label;
  
  public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1(a0 parama0, c paramc)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */