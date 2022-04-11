package io.reactivex.h0.c.a;

import io.reactivex.e0.d;

public final class f
  extends io.reactivex.a
{
  final io.reactivex.g0.a c;
  
  public f(io.reactivex.g0.a parama)
  {
    this.c = parama;
  }
  
  protected void B(io.reactivex.c paramc)
  {
    io.reactivex.e0.c localc = d.b();
    paramc.onSubscribe(localc);
    try
    {
      this.c.run();
      if (!localc.isDisposed()) {
        paramc.onComplete();
      }
      return;
    }
    finally
    {
      io.reactivex.exceptions.a.b(localThrowable);
      if (!localc.isDisposed()) {
        paramc.onError(localThrowable);
      } else {
        io.reactivex.j0.a.r(localThrowable);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */