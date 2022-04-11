package io.reactivex.d0.a;

import io.reactivex.g0.j;
import io.reactivex.w;
import java.util.Objects;
import java.util.concurrent.Callable;

public final class a
{
  private static volatile j<Callable<w>, w> a;
  private static volatile j<w, w> b;
  
  static <T, R> R a(j<T, R> paramj, T paramT)
  {
    try
    {
      paramj = paramj.apply(paramT);
      return paramj;
    }
    finally {}
  }
  
  static w b(j<Callable<w>, w> paramj, Callable<w> paramCallable)
  {
    paramj = (w)a(paramj, paramCallable);
    Objects.requireNonNull(paramj, "Scheduler Callable returned null");
    return paramj;
  }
  
  static w c(Callable<w> paramCallable)
  {
    try
    {
      paramCallable = (w)paramCallable.call();
      if (paramCallable != null) {
        return paramCallable;
      }
      paramCallable = new java/lang/NullPointerException;
      paramCallable.<init>("Scheduler Callable returned null");
      throw paramCallable;
    }
    finally {}
  }
  
  public static w d(Callable<w> paramCallable)
  {
    Objects.requireNonNull(paramCallable, "scheduler == null");
    j localj = a;
    if (localj == null) {
      return c(paramCallable);
    }
    return b(localj, paramCallable);
  }
  
  public static w e(w paramw)
  {
    Objects.requireNonNull(paramw, "scheduler == null");
    j localj = b;
    if (localj == null) {
      return paramw;
    }
    return (w)a(localj, paramw);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\d0\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */