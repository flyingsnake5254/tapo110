package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c="kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1", f="Merge.kt", l={138}, m="emit")
public final class ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  int label;
  
  public ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$1(b paramb, c paramc)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\internal\ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */