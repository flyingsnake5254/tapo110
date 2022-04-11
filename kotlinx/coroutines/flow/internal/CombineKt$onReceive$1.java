package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.k;

@d(c="kotlinx.coroutines.flow.internal.CombineKt$onReceive$1", f="Combine.kt", l={90, 90}, m="invokeSuspend")
public final class CombineKt$onReceive$1
  extends SuspendLambda
  implements kotlin.jvm.b.p<Object, c<? super kotlin.p>, Object>
{
  Object L$0;
  int label;
  private Object p$0;
  
  public CombineKt$onReceive$1(kotlin.jvm.b.a parama, kotlin.jvm.b.p paramp, c paramc)
  {
    super(2, paramc);
  }
  
  public final c<kotlin.p> create(Object paramObject, c<?> paramc)
  {
    j.f(paramc, "completion");
    paramc = new 1(this.$onClosed, this.$onReceive, paramc);
    paramc.p$0 = paramObject;
    return paramc;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (c)paramObject2)).invokeSuspend(kotlin.p.a);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    Object localObject1 = kotlin.coroutines.intrinsics.a.d();
    int i = this.label;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          k.b(paramObject);
          break label128;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      k.b(paramObject);
    }
    else
    {
      k.b(paramObject);
      paramObject = this.p$0;
      if (paramObject == null)
      {
        this.$onClosed.invoke();
        break label128;
      }
      Object localObject2 = this.$onReceive;
      this.L$0 = paramObject;
      this.label = 2;
      this.L$0 = paramObject;
      this.label = 1;
      localObject2 = ((kotlin.jvm.b.p)localObject2).invoke(paramObject, this);
      paramObject = localObject2;
      if (localObject2 == localObject1) {
        return localObject1;
      }
    }
    if (paramObject == localObject1) {
      return localObject1;
    }
    label128:
    return kotlin.p.a;
  }
  
  public final Object invokeSuspend$$forInline(Object paramObject)
  {
    Object localObject = this.p$0;
    if (localObject == null)
    {
      this.$onClosed.invoke();
    }
    else
    {
      paramObject = this.$onReceive;
      i.c(0);
      ((kotlin.jvm.b.p)paramObject).invoke(localObject, this);
      i.c(2);
      i.c(1);
    }
    return kotlin.p.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\internal\CombineKt$onReceive$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */