package io.reactivex.h0.c.a;

import io.reactivex.e;
import io.reactivex.exceptions.CompositeException;

public final class l
  extends io.reactivex.a
{
  final e c;
  final io.reactivex.g0.l<? super Throwable> d;
  
  public l(e parame, io.reactivex.g0.l<? super Throwable> paraml)
  {
    this.c = parame;
    this.d = paraml;
  }
  
  protected void B(io.reactivex.c paramc)
  {
    this.c.a(new a(paramc));
  }
  
  final class a
    implements io.reactivex.c
  {
    private final io.reactivex.c c;
    
    a(io.reactivex.c paramc)
    {
      this.c = paramc;
    }
    
    public void onComplete()
    {
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      try
      {
        boolean bool = l.this.d.test(paramThrowable);
        if (bool) {
          this.c.onComplete();
        } else {
          this.c.onError(paramThrowable);
        }
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(localThrowable);
        this.c.onError(new CompositeException(new Throwable[] { paramThrowable, localThrowable }));
      }
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      this.c.onSubscribe(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */