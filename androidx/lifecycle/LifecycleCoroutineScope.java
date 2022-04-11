package androidx.lifecycle;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.d1;

public abstract class LifecycleCoroutineScope
  implements d0
{
  public abstract Lifecycle getLifecycle$lifecycle_runtime_ktx_release();
  
  public final d1 launchWhenCreated(final kotlin.jvm.b.p<? super d0, ? super c<? super kotlin.p>, ? extends Object> paramp)
  {
    j.f(paramp, "block");
    kotlinx.coroutines.d.b(this, null, null, new SuspendLambda(paramp, null)
    {
      Object L$0;
      int label;
      private d0 p$;
      
      public final c<kotlin.p> create(Object paramAnonymousObject, c<?> paramAnonymousc)
      {
        j.f(paramAnonymousc, "completion");
        paramAnonymousc = new 1(this.this$0, paramp, paramAnonymousc);
        paramAnonymousc.p$ = ((d0)paramAnonymousObject);
        return paramAnonymousc;
      }
      
      public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        return ((1)create(paramAnonymousObject1, (c)paramAnonymousObject2)).invokeSuspend(kotlin.p.a);
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        Object localObject = a.d();
        int i = this.label;
        if (i != 0)
        {
          if (i == 1)
          {
            localObject = (d0)this.L$0;
            k.b(paramAnonymousObject);
          }
          else
          {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          }
        }
        else
        {
          k.b(paramAnonymousObject);
          d0 locald0 = this.p$;
          paramAnonymousObject = this.this$0.getLifecycle$lifecycle_runtime_ktx_release();
          kotlin.jvm.b.p localp = paramp;
          this.L$0 = locald0;
          this.label = 1;
          if (PausingDispatcherKt.whenCreated((Lifecycle)paramAnonymousObject, localp, this) == localObject) {
            return localObject;
          }
        }
        return kotlin.p.a;
      }
    }, 3, null);
  }
  
  public final d1 launchWhenResumed(final kotlin.jvm.b.p<? super d0, ? super c<? super kotlin.p>, ? extends Object> paramp)
  {
    j.f(paramp, "block");
    kotlinx.coroutines.d.b(this, null, null, new SuspendLambda(paramp, null)
    {
      Object L$0;
      int label;
      private d0 p$;
      
      public final c<kotlin.p> create(Object paramAnonymousObject, c<?> paramAnonymousc)
      {
        j.f(paramAnonymousc, "completion");
        paramAnonymousc = new 1(this.this$0, paramp, paramAnonymousc);
        paramAnonymousc.p$ = ((d0)paramAnonymousObject);
        return paramAnonymousc;
      }
      
      public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        return ((1)create(paramAnonymousObject1, (c)paramAnonymousObject2)).invokeSuspend(kotlin.p.a);
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        Object localObject = a.d();
        int i = this.label;
        if (i != 0)
        {
          if (i == 1)
          {
            localObject = (d0)this.L$0;
            k.b(paramAnonymousObject);
          }
          else
          {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          }
        }
        else
        {
          k.b(paramAnonymousObject);
          d0 locald0 = this.p$;
          Lifecycle localLifecycle = this.this$0.getLifecycle$lifecycle_runtime_ktx_release();
          paramAnonymousObject = paramp;
          this.L$0 = locald0;
          this.label = 1;
          if (PausingDispatcherKt.whenResumed(localLifecycle, (kotlin.jvm.b.p)paramAnonymousObject, this) == localObject) {
            return localObject;
          }
        }
        return kotlin.p.a;
      }
    }, 3, null);
  }
  
  public final d1 launchWhenStarted(final kotlin.jvm.b.p<? super d0, ? super c<? super kotlin.p>, ? extends Object> paramp)
  {
    j.f(paramp, "block");
    kotlinx.coroutines.d.b(this, null, null, new SuspendLambda(paramp, null)
    {
      Object L$0;
      int label;
      private d0 p$;
      
      public final c<kotlin.p> create(Object paramAnonymousObject, c<?> paramAnonymousc)
      {
        j.f(paramAnonymousc, "completion");
        paramAnonymousc = new 1(this.this$0, paramp, paramAnonymousc);
        paramAnonymousc.p$ = ((d0)paramAnonymousObject);
        return paramAnonymousc;
      }
      
      public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        return ((1)create(paramAnonymousObject1, (c)paramAnonymousObject2)).invokeSuspend(kotlin.p.a);
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        Object localObject = a.d();
        int i = this.label;
        if (i != 0)
        {
          if (i == 1)
          {
            localObject = (d0)this.L$0;
            k.b(paramAnonymousObject);
          }
          else
          {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          }
        }
        else
        {
          k.b(paramAnonymousObject);
          d0 locald0 = this.p$;
          Lifecycle localLifecycle = this.this$0.getLifecycle$lifecycle_runtime_ktx_release();
          paramAnonymousObject = paramp;
          this.L$0 = locald0;
          this.label = 1;
          if (PausingDispatcherKt.whenStarted(localLifecycle, (kotlin.jvm.b.p)paramAnonymousObject, this) == localObject) {
            return localObject;
          }
        }
        return kotlin.p.a;
      }
    }, 3, null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\LifecycleCoroutineScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */