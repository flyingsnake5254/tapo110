package kotlin.coroutines;

import java.util.Objects;
import kotlin.jvm.internal.j;

public abstract interface d
  extends f.b
{
  public static final b e = b.a;
  
  public abstract <T> c<T> interceptContinuation(c<? super T> paramc);
  
  public abstract void releaseInterceptedContinuation(c<?> paramc);
  
  public static final class a
  {
    public static <E extends f.b> E a(d paramd, f.c<E> paramc)
    {
      j.e(paramc, "key");
      boolean bool = paramc instanceof b;
      Object localObject = null;
      if (bool)
      {
        b localb = (b)paramc;
        paramc = (f.c<E>)localObject;
        if (localb.a(paramd.getKey()))
        {
          paramc = localb.b(paramd);
          if (!(paramc instanceof f.b)) {
            paramc = (f.c<E>)localObject;
          }
        }
        return paramc;
      }
      if (d.e == paramc) {
        Objects.requireNonNull(paramd, "null cannot be cast to non-null type E");
      } else {
        paramd = null;
      }
      return paramd;
    }
    
    public static f b(d paramd, f.c<?> paramc)
    {
      j.e(paramc, "key");
      if ((paramc instanceof b))
      {
        b localb = (b)paramc;
        paramc = paramd;
        if (localb.a(paramd.getKey()))
        {
          paramc = paramd;
          if (localb.b(paramd) != null) {
            paramc = EmptyCoroutineContext.INSTANCE;
          }
        }
        return paramc;
      }
      if (d.e == paramc) {
        paramd = EmptyCoroutineContext.INSTANCE;
      }
      return paramd;
    }
    
    public static void c(d paramd, c<?> paramc)
    {
      j.e(paramc, "continuation");
    }
  }
  
  public static final class b
    implements f.c<d>
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */