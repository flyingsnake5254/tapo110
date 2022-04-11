package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.c;
import kotlin.coroutines.e;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.d2.a;
import kotlinx.coroutines.d2.b;

public enum CoroutineStart
{
  static
  {
    CoroutineStart localCoroutineStart1 = new CoroutineStart("DEFAULT", 0);
    DEFAULT = localCoroutineStart1;
    CoroutineStart localCoroutineStart2 = new CoroutineStart("LAZY", 1);
    LAZY = localCoroutineStart2;
    CoroutineStart localCoroutineStart3 = new CoroutineStart("ATOMIC", 2);
    ATOMIC = localCoroutineStart3;
    CoroutineStart localCoroutineStart4 = new CoroutineStart("UNDISPATCHED", 3);
    UNDISPATCHED = localCoroutineStart4;
    $VALUES = new CoroutineStart[] { localCoroutineStart1, localCoroutineStart2, localCoroutineStart3, localCoroutineStart4 };
  }
  
  public final <T> void invoke(l<? super c<? super T>, ? extends Object> paraml, c<? super T> paramc)
  {
    j.f(paraml, "block");
    j.f(paramc, "completion");
    int i = f0.a[ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            throw new NoWhenBranchMatchedException();
          }
        }
        else {
          b.a(paraml, paramc);
        }
      }
      else {
        e.a(paraml, paramc);
      }
    }
    else {
      a.a(paraml, paramc);
    }
  }
  
  public final <R, T> void invoke(p<? super R, ? super c<? super T>, ? extends Object> paramp, R paramR, c<? super T> paramc)
  {
    j.f(paramp, "block");
    j.f(paramc, "completion");
    int i = f0.b[ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            throw new NoWhenBranchMatchedException();
          }
        }
        else {
          b.b(paramp, paramR, paramc);
        }
      }
      else {
        e.b(paramp, paramR, paramc);
      }
    }
    else {
      a.b(paramp, paramR, paramc);
    }
  }
  
  public final boolean isLazy()
  {
    boolean bool;
    if (this == LAZY) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\CoroutineStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */