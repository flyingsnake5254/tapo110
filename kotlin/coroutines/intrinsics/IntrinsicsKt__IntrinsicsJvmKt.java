package kotlin.coroutines.intrinsics;

import java.util.Objects;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.q;
import kotlin.k;

class IntrinsicsKt__IntrinsicsJvmKt
{
  public static <T> c<kotlin.p> a(final l<? super c<? super T>, ? extends Object> paraml, c<? super T> paramc)
  {
    j.e(paraml, "$this$createCoroutineUnintercepted");
    j.e(paramc, "completion");
    paramc = kotlin.coroutines.jvm.internal.f.a(paramc);
    if ((paraml instanceof BaseContinuationImpl))
    {
      paraml = ((BaseContinuationImpl)paraml).create(paramc);
    }
    else
    {
      final kotlin.coroutines.f localf = paramc.getContext();
      if (localf == EmptyCoroutineContext.INSTANCE) {
        paraml = new RestrictedContinuationImpl(paramc)
        {
          private int label;
          
          protected Object invokeSuspend(Object paramAnonymousObject)
          {
            int i = this.label;
            if (i != 0)
            {
              if (i == 1)
              {
                this.label = 2;
                k.b(paramAnonymousObject);
              }
              else
              {
                throw new IllegalStateException("This coroutine had already completed".toString());
              }
            }
            else
            {
              this.label = 1;
              k.b(paramAnonymousObject);
              paramAnonymousObject = paraml;
              Objects.requireNonNull(paramAnonymousObject, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
              paramAnonymousObject = ((l)q.b(paramAnonymousObject, 1)).invoke(this);
            }
            return paramAnonymousObject;
          }
        };
      } else {
        paraml = new ContinuationImpl(paramc, localf)
        {
          private int label;
          
          protected Object invokeSuspend(Object paramAnonymousObject)
          {
            int i = this.label;
            if (i != 0)
            {
              if (i == 1)
              {
                this.label = 2;
                k.b(paramAnonymousObject);
              }
              else
              {
                throw new IllegalStateException("This coroutine had already completed".toString());
              }
            }
            else
            {
              this.label = 1;
              k.b(paramAnonymousObject);
              paramAnonymousObject = paraml;
              Objects.requireNonNull(paramAnonymousObject, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
              paramAnonymousObject = ((l)q.b(paramAnonymousObject, 1)).invoke(this);
            }
            return paramAnonymousObject;
          }
        };
      }
    }
    return paraml;
  }
  
  public static <R, T> c<kotlin.p> b(final kotlin.jvm.b.p<? super R, ? super c<? super T>, ? extends Object> paramp, final R paramR, final c<? super T> paramc)
  {
    j.e(paramp, "$this$createCoroutineUnintercepted");
    j.e(paramc, "completion");
    c localc = kotlin.coroutines.jvm.internal.f.a(paramc);
    if ((paramp instanceof BaseContinuationImpl))
    {
      paramp = ((BaseContinuationImpl)paramp).create(paramR, localc);
    }
    else
    {
      paramc = localc.getContext();
      if (paramc == EmptyCoroutineContext.INSTANCE) {
        paramp = new RestrictedContinuationImpl(localc)
        {
          private int label;
          
          protected Object invokeSuspend(Object paramAnonymousObject)
          {
            int i = this.label;
            if (i != 0)
            {
              if (i == 1)
              {
                this.label = 2;
                k.b(paramAnonymousObject);
              }
              else
              {
                throw new IllegalStateException("This coroutine had already completed".toString());
              }
            }
            else
            {
              this.label = 1;
              k.b(paramAnonymousObject);
              paramAnonymousObject = paramp;
              Objects.requireNonNull(paramAnonymousObject, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
              paramAnonymousObject = ((kotlin.jvm.b.p)q.b(paramAnonymousObject, 2)).invoke(paramR, this);
            }
            return paramAnonymousObject;
          }
        };
      } else {
        paramp = new ContinuationImpl(localc, paramc)
        {
          private int label;
          
          protected Object invokeSuspend(Object paramAnonymousObject)
          {
            int i = this.label;
            if (i != 0)
            {
              if (i == 1)
              {
                this.label = 2;
                k.b(paramAnonymousObject);
              }
              else
              {
                throw new IllegalStateException("This coroutine had already completed".toString());
              }
            }
            else
            {
              this.label = 1;
              k.b(paramAnonymousObject);
              paramAnonymousObject = paramp;
              Objects.requireNonNull(paramAnonymousObject, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
              paramAnonymousObject = ((kotlin.jvm.b.p)q.b(paramAnonymousObject, 2)).invoke(paramR, this);
            }
            return paramAnonymousObject;
          }
        };
      }
    }
    return paramp;
  }
  
  public static <T> c<T> c(c<? super T> paramc)
  {
    j.e(paramc, "$this$intercepted");
    if (!(paramc instanceof ContinuationImpl)) {
      localObject1 = null;
    } else {
      localObject1 = paramc;
    }
    Object localObject2 = (ContinuationImpl)localObject1;
    Object localObject1 = paramc;
    if (localObject2 != null)
    {
      localObject2 = ((ContinuationImpl)localObject2).intercepted();
      localObject1 = paramc;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    return (c<T>)localObject1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\intrinsics\IntrinsicsKt__IntrinsicsJvmKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */