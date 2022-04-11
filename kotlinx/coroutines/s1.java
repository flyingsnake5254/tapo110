package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Result.a;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.p;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.x;

public final class s1
{
  public static final boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean b(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramInt != 0) {
      if (paramInt == 1) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public static final <T> void c(c<? super T> paramc, T paramT, int paramInt)
  {
    j.f(paramc, "$this$resumeMode");
    Object localObject2;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        Object localObject1;
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              paramc = new StringBuilder();
              paramc.append("Invalid mode ");
              paramc.append(paramInt);
              throw new IllegalStateException(paramc.toString().toString());
            }
          }
          else
          {
            localObject1 = (j0)paramc;
            localObject2 = ((j0)localObject1).getContext();
            paramc = x.c((f)localObject2, ((j0)localObject1).y);
          }
        }
        else {
          try
          {
            c localc = ((j0)localObject1).p0;
            localObject1 = Result.Companion;
            localc.resumeWith(Result.constructor-impl(paramT));
            paramT = p.a;
            x.a((f)localObject2, paramc);
          }
          finally
          {
            x.a((f)localObject2, paramc);
          }
        }
      }
      else
      {
        l0.d(paramc, paramT);
      }
    }
    else
    {
      localObject2 = Result.Companion;
      paramc.resumeWith(Result.constructor-impl(paramT));
    }
  }
  
  public static final <T> void d(c<? super T> paramc, T paramT, int paramInt)
  {
    j.f(paramc, "$this$resumeUninterceptedMode");
    Object localObject1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        Object localObject2;
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              paramc = new StringBuilder();
              paramc.append("Invalid mode ");
              paramc.append(paramInt);
              throw new IllegalStateException(paramc.toString().toString());
            }
          }
          else
          {
            localObject1 = paramc.getContext();
            localObject2 = x.c((f)localObject1, null);
          }
        }
        else
        {
          try
          {
            Result.a locala = Result.Companion;
            paramc.resumeWith(Result.constructor-impl(paramT));
            paramc = p.a;
            x.a((f)localObject1, localObject2);
          }
          finally
          {
            x.a((f)localObject1, localObject2);
          }
          paramc.resumeWith(Result.constructor-impl(paramT));
        }
      }
      else
      {
        l0.d(a.c(paramc), paramT);
      }
    }
    else
    {
      paramc = a.c(paramc);
      localObject1 = Result.Companion;
      paramc.resumeWith(Result.constructor-impl(paramT));
    }
  }
  
  public static final <T> void e(c<? super T> paramc, Throwable paramThrowable, int paramInt)
  {
    j.f(paramc, "$this$resumeUninterceptedWithExceptionMode");
    j.f(paramThrowable, "exception");
    Object localObject1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        Object localObject2;
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              paramc = new StringBuilder();
              paramc.append("Invalid mode ");
              paramc.append(paramInt);
              throw new IllegalStateException(paramc.toString().toString());
            }
          }
          else
          {
            localObject1 = paramc.getContext();
            localObject2 = x.c((f)localObject1, null);
          }
        }
        else
        {
          try
          {
            Result.a locala = Result.Companion;
            paramc.resumeWith(Result.constructor-impl(k.a(paramThrowable)));
            paramc = p.a;
            x.a((f)localObject1, localObject2);
          }
          finally
          {
            x.a((f)localObject1, localObject2);
          }
          paramc.resumeWith(Result.constructor-impl(k.a(paramThrowable)));
        }
      }
      else
      {
        l0.e(a.c(paramc), paramThrowable);
      }
    }
    else
    {
      paramc = a.c(paramc);
      localObject1 = Result.Companion;
      paramc.resumeWith(Result.constructor-impl(k.a(paramThrowable)));
    }
  }
  
  public static final <T> void f(c<? super T> paramc, Throwable paramThrowable, int paramInt)
  {
    j.f(paramc, "$this$resumeWithExceptionMode");
    j.f(paramThrowable, "exception");
    Object localObject2;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        Object localObject1;
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              paramc = new StringBuilder();
              paramc.append("Invalid mode ");
              paramc.append(paramInt);
              throw new IllegalStateException(paramc.toString().toString());
            }
          }
          else
          {
            localObject1 = (j0)paramc;
            paramc = ((j0)localObject1).getContext();
            localObject2 = x.c(paramc, ((j0)localObject1).y);
          }
        }
        else {
          try
          {
            c localc = ((j0)localObject1).p0;
            localObject1 = Result.Companion;
            localc.resumeWith(Result.constructor-impl(k.a(s.k(paramThrowable, localc))));
            paramThrowable = p.a;
            x.a(paramc, localObject2);
          }
          finally
          {
            x.a(paramc, localObject2);
          }
        }
      }
      else
      {
        l0.e(paramc, paramThrowable);
      }
    }
    else
    {
      localObject2 = Result.Companion;
      paramc.resumeWith(Result.constructor-impl(k.a(paramThrowable)));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\s1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */