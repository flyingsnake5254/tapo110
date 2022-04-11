package kotlinx.coroutines;

import kotlin.coroutines.f;
import kotlin.coroutines.f.b;
import kotlin.coroutines.f.b.a;
import kotlin.coroutines.f.c;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

public abstract interface w1<S>
  extends f.b
{
  public abstract void k(f paramf, S paramS);
  
  public abstract S s(f paramf);
  
  public static final class a
  {
    public static <S, R> R a(w1<S> paramw1, R paramR, p<? super R, ? super f.b, ? extends R> paramp)
    {
      j.f(paramp, "operation");
      return (R)f.b.a.a(paramw1, paramR, paramp);
    }
    
    public static <S, E extends f.b> E b(w1<S> paramw1, f.c<E> paramc)
    {
      j.f(paramc, "key");
      return f.b.a.b(paramw1, paramc);
    }
    
    public static <S> f c(w1<S> paramw1, f.c<?> paramc)
    {
      j.f(paramc, "key");
      return f.b.a.c(paramw1, paramc);
    }
    
    public static <S> f d(w1<S> paramw1, f paramf)
    {
      j.f(paramf, "context");
      return f.b.a.d(paramw1, paramf);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\w1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */