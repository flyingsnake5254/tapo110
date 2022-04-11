package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.channels.r;

public final class CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4
  extends SuspendLambda
  implements kotlin.jvm.b.p<Object, kotlin.coroutines.c<? super kotlin.p>, Object>
{
  Object L$0;
  int label;
  private Object p$0;
  
  public CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4(kotlin.jvm.b.p paramp, kotlin.coroutines.c paramc, c paramc1, Ref.BooleanRef paramBooleanRef1, r paramr1, Ref.ObjectRef paramObjectRef1, Ref.ObjectRef paramObjectRef2, Ref.BooleanRef paramBooleanRef2, r paramr2)
  {
    super(2, paramc);
  }
  
  public final kotlin.coroutines.c<kotlin.p> create(Object paramObject, kotlin.coroutines.c<?> paramc)
  {
    j.f(paramc, "completion");
    paramc = new 4(this.$onReceive, paramc, this.this$0, this.$firstIsClosed$inlined, this.$firstChannel$inlined, this.$firstValue$inlined, this.$secondValue$inlined, this.$secondIsClosed$inlined, this.$secondChannel$inlined);
    paramc.p$0 = paramObject;
    return paramc;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((4)create(paramObject1, (kotlin.coroutines.c)paramObject2)).invokeSuspend(kotlin.p.a);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    Object localObject1 = a.d();
    int i = this.label;
    if (i != 0)
    {
      if (i == 1) {
        k.b(paramObject);
      } else {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      k.b(paramObject);
      Object localObject2 = this.p$0;
      if (localObject2 == null)
      {
        this.$secondIsClosed$inlined.element = true;
      }
      else
      {
        paramObject = this.$onReceive;
        this.L$0 = localObject2;
        this.label = 1;
        if (((kotlin.jvm.b.p)paramObject).invoke(localObject2, this) == localObject1) {
          return localObject1;
        }
      }
    }
    return kotlin.p.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\internal\CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */