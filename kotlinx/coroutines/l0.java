package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Result.a;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.p;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.x;

public final class l0
{
  private static final t a = new t("UNDEFINED");
  
  public static final <T> void b(m0<? super T> paramm0, int paramInt)
  {
    j.f(paramm0, "$this$dispatch");
    Object localObject = paramm0.d();
    if ((s1.b(paramInt)) && ((localObject instanceof j0)) && (s1.a(paramInt) == s1.a(paramm0.f)))
    {
      y localy = ((j0)localObject).z;
      localObject = ((c)localObject).getContext();
      if (localy.isDispatchNeeded((f)localObject)) {
        localy.dispatch((f)localObject, paramm0);
      } else {
        h(paramm0);
      }
    }
    else
    {
      c(paramm0, (c)localObject, paramInt);
    }
  }
  
  public static final <T> void c(m0<? super T> paramm0, c<? super T> paramc, int paramInt)
  {
    j.f(paramm0, "$this$resume");
    j.f(paramc, "delegate");
    Object localObject = paramm0.j();
    Throwable localThrowable = paramm0.e(localObject);
    if (localThrowable != null)
    {
      if ((paramc instanceof m0)) {
        paramm0 = localThrowable;
      } else {
        paramm0 = s.k(localThrowable, paramc);
      }
      s1.f(paramc, paramm0, paramInt);
    }
    else
    {
      s1.c(paramc, paramm0.g(localObject), paramInt);
    }
  }
  
  public static final <T> void d(c<? super T> paramc, T paramT)
  {
    j.f(paramc, "$this$resumeCancellable");
    Object localObject1;
    if ((paramc instanceof j0))
    {
      localObject1 = (j0)paramc;
      if (((j0)localObject1).z.isDispatchNeeded(((j0)localObject1).getContext()))
      {
        ((j0)localObject1).q = paramT;
        ((m0)localObject1).f = 1;
        ((j0)localObject1).z.dispatch(((j0)localObject1).getContext(), (Runnable)localObject1);
      }
      else
      {
        paramc = x1.b.a();
        if (paramc.A())
        {
          ((j0)localObject1).q = paramT;
          ((m0)localObject1).f = 1;
          paramc.w((m0)localObject1);
        }
        else
        {
          paramc.y(true);
          try
          {
            Object localObject2 = (d1)((j0)localObject1).getContext().get(d1.h);
            Object localObject3;
            int i;
            if ((localObject2 != null) && (!((d1)localObject2).isActive()))
            {
              localObject3 = ((d1)localObject2).i();
              localObject2 = Result.Companion;
              ((c)localObject1).resumeWith(Result.constructor-impl(k.a((Throwable)localObject3)));
              i = 1;
            }
            else
            {
              i = 0;
            }
            if (i == 0)
            {
              localObject3 = ((j0)localObject1).getContext();
              localObject2 = x.c((f)localObject3, ((j0)localObject1).y);
            }
            for (;;)
            {
              boolean bool;
              try
              {
                c localc = ((j0)localObject1).p0;
                Result.a locala = Result.Companion;
                localc.resumeWith(Result.constructor-impl(paramT));
                paramT = p.a;
                x.a((f)localObject3, localObject2);
              }
              finally
              {
                x.a((f)localObject3, localObject2);
              }
              if (!bool) {
                break;
              }
            }
          }
          finally {}
        }
      }
    }
    else
    {
      try
      {
        ((m0)localObject1).i(paramT, null);
        paramc.u(true);
      }
      finally
      {
        paramc.u(true);
      }
      paramc.resumeWith(Result.constructor-impl(paramT));
    }
  }
  
  public static final <T> void e(c<? super T> paramc, Throwable paramThrowable)
  {
    j.f(paramc, "$this$resumeCancellableWithException");
    j.f(paramThrowable, "exception");
    Object localObject1;
    if ((paramc instanceof j0))
    {
      paramc = (j0)paramc;
      localObject1 = paramc.p0.getContext();
      int i = 0;
      Object localObject2 = new r(paramThrowable, false, 2, null);
      if (paramc.z.isDispatchNeeded((f)localObject1))
      {
        paramc.q = new r(paramThrowable, false, 2, null);
        paramc.f = 1;
        paramc.z.dispatch((f)localObject1, paramc);
      }
      else
      {
        localObject1 = x1.b.a();
        if (((q0)localObject1).A())
        {
          paramc.q = localObject2;
          paramc.f = 1;
          ((q0)localObject1).w(paramc);
        }
        else
        {
          ((q0)localObject1).y(true);
          try
          {
            localObject2 = (d1)paramc.getContext().get(d1.h);
            int j = i;
            Object localObject3;
            if (localObject2 != null)
            {
              j = i;
              if (!((d1)localObject2).isActive())
              {
                localObject3 = ((d1)localObject2).i();
                localObject2 = Result.Companion;
                paramc.resumeWith(Result.constructor-impl(k.a((Throwable)localObject3)));
                j = 1;
              }
            }
            if (j == 0)
            {
              localObject3 = paramc.getContext();
              localObject2 = x.c((f)localObject3, paramc.y);
            }
            for (;;)
            {
              boolean bool;
              try
              {
                c localc = paramc.p0;
                Result.a locala = Result.Companion;
                localc.resumeWith(Result.constructor-impl(k.a(s.k(paramThrowable, localc))));
                paramThrowable = p.a;
                x.a((f)localObject3, localObject2);
              }
              finally
              {
                x.a((f)localObject3, localObject2);
              }
              if (!bool) {
                break;
              }
            }
          }
          finally {}
        }
      }
    }
    else
    {
      try
      {
        paramc.i(paramThrowable, null);
        ((q0)localObject1).u(true);
      }
      finally
      {
        ((q0)localObject1).u(true);
      }
      paramc.resumeWith(Result.constructor-impl(k.a(s.k(paramThrowable, paramc))));
    }
  }
  
  public static final <T> void f(c<? super T> paramc, T paramT)
  {
    j.f(paramc, "$this$resumeDirect");
    Object localObject;
    if ((paramc instanceof j0))
    {
      localObject = ((j0)paramc).p0;
      paramc = Result.Companion;
      ((c)localObject).resumeWith(Result.constructor-impl(paramT));
    }
    else
    {
      localObject = Result.Companion;
      paramc.resumeWith(Result.constructor-impl(paramT));
    }
  }
  
  public static final <T> void g(c<? super T> paramc, Throwable paramThrowable)
  {
    j.f(paramc, "$this$resumeDirectWithException");
    j.f(paramThrowable, "exception");
    Result.a locala;
    if ((paramc instanceof j0))
    {
      paramc = ((j0)paramc).p0;
      locala = Result.Companion;
      paramc.resumeWith(Result.constructor-impl(k.a(s.k(paramThrowable, paramc))));
    }
    else
    {
      locala = Result.Companion;
      paramc.resumeWith(Result.constructor-impl(k.a(s.k(paramThrowable, paramc))));
    }
  }
  
  private static final void h(m0<?> paramm0)
  {
    q0 localq0 = x1.b.a();
    if (localq0.A())
    {
      localq0.w(paramm0);
    }
    else
    {
      localq0.y(true);
      try
      {
        c(paramm0, paramm0.d(), 3);
        for (;;)
        {
          boolean bool = localq0.C();
          if (!bool) {
            break;
          }
        }
      }
      finally {}
    }
    try
    {
      paramm0.i(localThrowable, null);
      return;
    }
    finally
    {
      localq0.u(true);
    }
  }
  
  public static final boolean i(j0<? super p> paramj0)
  {
    j.f(paramj0, "$this$yieldUndispatched");
    p localp = p.a;
    q0 localq0 = x1.b.a();
    boolean bool1 = localq0.B();
    boolean bool2 = false;
    if (!bool1) {
      if (localq0.A())
      {
        paramj0.q = localp;
        paramj0.f = 1;
        localq0.w(paramj0);
        bool2 = true;
      }
      else
      {
        localq0.y(true);
        try
        {
          paramj0.run();
          for (;;)
          {
            bool1 = localq0.C();
            if (!bool1) {
              break;
            }
          }
        }
        finally {}
      }
    }
    try
    {
      paramj0.i(localThrowable, null);
      return bool2;
    }
    finally
    {
      localq0.u(true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\l0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */