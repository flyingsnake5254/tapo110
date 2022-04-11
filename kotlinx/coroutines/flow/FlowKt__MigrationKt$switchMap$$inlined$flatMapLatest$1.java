package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.j;
import kotlin.k;

@d(c="kotlinx.coroutines.flow.FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1", f="Migration.kt", l={154, 180}, m="invokeSuspend")
public final class FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1
  extends SuspendLambda
  implements q<b<? super R>, T, c<? super kotlin.p>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  int label;
  private b p$;
  private Object p$0;
  
  public FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(kotlin.jvm.b.p paramp, c paramc)
  {
    super(3, paramc);
  }
  
  public final c<kotlin.p> create(b<? super R> paramb, T paramT, c<? super kotlin.p> paramc)
  {
    j.f(paramb, "$this$create");
    j.f(paramc, "continuation");
    paramc = new 1(this.$transform, paramc);
    paramc.p$ = paramb;
    paramc.p$0 = paramT;
    return paramc;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return ((1)create((b)paramObject1, paramObject2, (c)paramObject3)).invokeSuspend(kotlin.p.a);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    Object localObject1 = kotlin.coroutines.intrinsics.a.d();
    int i = this.label;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localObject2 = (a)this.L$3;
          localObject2 = (b)this.L$2;
          localObject2 = (b)this.L$0;
          k.b(paramObject);
          break label218;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject2 = (b)this.L$2;
      localObject3 = this.L$1;
      localObject4 = (b)this.L$0;
      k.b(paramObject);
      localObject5 = paramObject;
    }
    else
    {
      k.b(paramObject);
      paramObject = this.p$;
      localObject3 = this.p$0;
      localObject2 = this.$transform;
      this.L$0 = paramObject;
      this.L$1 = localObject3;
      this.L$2 = paramObject;
      this.label = 1;
      localObject5 = ((kotlin.jvm.b.p)localObject2).invoke(localObject3, this);
      if (localObject5 == localObject1) {
        return localObject1;
      }
      localObject4 = paramObject;
      localObject2 = paramObject;
    }
    paramObject = (a)localObject5;
    this.L$0 = localObject4;
    this.L$1 = localObject3;
    this.L$2 = localObject2;
    this.L$3 = paramObject;
    this.label = 2;
    if (((a)paramObject).a((b)localObject2, this) == localObject1) {
      return localObject1;
    }
    label218:
    return kotlin.p.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */