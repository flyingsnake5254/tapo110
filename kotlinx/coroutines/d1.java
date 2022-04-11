package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.f;
import kotlin.coroutines.f.b;
import kotlin.coroutines.f.b.a;
import kotlin.coroutines.f.c;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

public abstract interface d1
  extends f.b
{
  public static final b h = b.a;
  
  public abstract void a(CancellationException paramCancellationException);
  
  public abstract o0 g(boolean paramBoolean1, boolean paramBoolean2, l<? super Throwable, kotlin.p> paraml);
  
  public abstract CancellationException i();
  
  public abstract boolean isActive();
  
  public abstract boolean start();
  
  public abstract m t(o paramo);
  
  public static final class a
  {
    public static <R> R b(d1 paramd1, R paramR, kotlin.jvm.b.p<? super R, ? super f.b, ? extends R> paramp)
    {
      j.f(paramp, "operation");
      return (R)f.b.a.a(paramd1, paramR, paramp);
    }
    
    public static <E extends f.b> E c(d1 paramd1, f.c<E> paramc)
    {
      j.f(paramc, "key");
      return f.b.a.b(paramd1, paramc);
    }
    
    public static f e(d1 paramd1, f.c<?> paramc)
    {
      j.f(paramc, "key");
      return f.b.a.c(paramd1, paramc);
    }
    
    public static f f(d1 paramd1, f paramf)
    {
      j.f(paramf, "context");
      return f.b.a.d(paramd1, paramf);
    }
  }
  
  public static final class b
    implements f.c<d1>
  {
    static
    {
      CoroutineExceptionHandler.a locala = CoroutineExceptionHandler.g;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\d1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */