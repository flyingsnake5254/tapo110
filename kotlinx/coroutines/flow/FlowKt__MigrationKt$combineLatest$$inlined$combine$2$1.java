package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

public final class FlowKt__MigrationKt$combineLatest$$inlined$combine$2$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  int label;
  
  public FlowKt__MigrationKt$combineLatest$$inlined$combine$2$1(f1 paramf1, c paramc)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\FlowKt__MigrationKt$combineLatest$$inlined$combine$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */