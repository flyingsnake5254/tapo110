package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c="kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f="Merge.kt", l={137, 137}, m="emit")
public final class FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  Object L$6;
  Object L$7;
  int label;
  
  public FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1(o0 paramo0, c paramc)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */