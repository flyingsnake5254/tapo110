package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.p;

@d(c="kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$2$3", f="Zip.kt", l={319}, m="invokeSuspend")
public final class FlowKt__ZipKt$combine$$inlined$combine$2$3
  extends SuspendLambda
  implements q<b<? super R>, Object[], c<? super p>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private b p$;
  private Object[] p$0;
  
  public FlowKt__ZipKt$combine$$inlined$combine$2$3(c paramc, p2 paramp2)
  {
    super(3, paramc);
  }
  
  public final c<p> create(b<? super R> paramb, Object[] paramArrayOfObject, c<? super p> paramc)
  {
    j.f(paramb, "$this$create");
    j.f(paramArrayOfObject, "it");
    j.f(paramc, "continuation");
    paramc = new 3(paramc, this.this$0);
    paramc.p$ = paramb;
    paramc.p$0 = paramArrayOfObject;
    return paramc;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return ((3)create((b)paramObject1, (Object[])paramObject2, (c)paramObject3)).invokeSuspend(p.a);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    a.d();
    int i = this.label;
    if (i != 0)
    {
      if (i == 1)
      {
        Object localObject = (Object[])this.L$1;
        localObject = (b)this.L$0;
        k.b(paramObject);
        return p.a;
      }
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
    k.b(paramObject);
    throw null;
  }
  
  public final Object invokeSuspend$$forInline(Object paramObject)
  {
    throw null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\FlowKt__ZipKt$combine$$inlined$combine$2$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */