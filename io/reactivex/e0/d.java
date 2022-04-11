package io.reactivex.e0;

import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class d
{
  public static c a()
  {
    return EmptyDisposable.INSTANCE;
  }
  
  public static c b()
  {
    return d(io.reactivex.h0.a.a.b);
  }
  
  public static c c(io.reactivex.g0.a parama)
  {
    b.e(parama, "run is null");
    return new a(parama);
  }
  
  public static c d(Runnable paramRunnable)
  {
    b.e(paramRunnable, "run is null");
    return new f(paramRunnable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\e0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */