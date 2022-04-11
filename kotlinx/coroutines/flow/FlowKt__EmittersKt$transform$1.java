package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.k;

@d(c="kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f="Emitters.kt", l={161}, m="invokeSuspend")
public final class FlowKt__EmittersKt$transform$1
  extends SuspendLambda
  implements kotlin.jvm.b.p<b<? super R>, c<? super kotlin.p>, Object>
{
  Object L$0;
  Object L$1;
  int label;
  private b p$;
  
  public FlowKt__EmittersKt$transform$1(a parama, q paramq, c paramc)
  {
    super(2, paramc);
  }
  
  public final c<kotlin.p> create(Object paramObject, c<?> paramc)
  {
    j.f(paramc, "completion");
    paramc = new 1(this.$this_transform, this.$transform, paramc);
    paramc.p$ = ((b)paramObject);
    return paramc;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (c)paramObject2)).invokeSuspend(kotlin.p.a);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    Object localObject = kotlin.coroutines.intrinsics.a.d();
    int i = this.label;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject = (a)this.L$1;
        localObject = (b)this.L$0;
        k.b(paramObject);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      k.b(paramObject);
      final b localb = this.p$;
      paramObject = this.$this_transform;
      b local1 = new b()
      {
        public Object a(Object paramAnonymousObject, c paramAnonymousc)
        {
          return this.a.$transform.invoke(localb, paramAnonymousObject, paramAnonymousc);
        }
      };
      this.L$0 = localb;
      this.L$1 = paramObject;
      this.label = 1;
      if (((a)paramObject).a(local1, this) == localObject) {
        return localObject;
      }
    }
    return kotlin.p.a;
  }
  
  public final Object invokeSuspend$$forInline(Object paramObject)
  {
    Object localObject = this.p$;
    paramObject = this.$this_transform;
    localObject = new b()
    {
      public Object a(Object paramAnonymousObject, c paramAnonymousc)
      {
        return this.a.$transform.invoke(localb, paramAnonymousObject, paramAnonymousc);
      }
    };
    i.c(0);
    ((a)paramObject).a((b)localObject, this);
    i.c(2);
    i.c(1);
    return kotlin.p.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\FlowKt__EmittersKt$transform$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */