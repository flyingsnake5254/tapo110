package io.reactivex.h0.c.a;

import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  extends io.reactivex.a
{
  final e c;
  final io.reactivex.g0.a d;
  
  public c(e parame, io.reactivex.g0.a parama)
  {
    this.c = parame;
    this.d = parama;
  }
  
  protected void B(io.reactivex.c paramc)
  {
    this.c.a(new a(paramc, this.d));
  }
  
  static final class a
    extends AtomicInteger
    implements io.reactivex.c, io.reactivex.e0.c
  {
    final io.reactivex.c c;
    final io.reactivex.g0.a d;
    io.reactivex.e0.c f;
    
    a(io.reactivex.c paramc, io.reactivex.g0.a parama)
    {
      this.c = paramc;
      this.d = parama;
    }
    
    /* Error */
    void a()
    {
      // Byte code:
      //   0: aload_0
      //   1: iconst_0
      //   2: iconst_1
      //   3: invokevirtual 31	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
      //   6: ifeq +24 -> 30
      //   9: aload_0
      //   10: getfield 26	io/reactivex/h0/c/a/c$a:d	Lio/reactivex/g0/a;
      //   13: invokeinterface 36 1 0
      //   18: goto +12 -> 30
      //   21: astore_1
      //   22: aload_1
      //   23: invokestatic 42	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   26: aload_1
      //   27: invokestatic 47	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   30: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	31	0	this	a
      //   21	6	1	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   9	18	21	finally
    }
    
    public void dispose()
    {
      this.f.dispose();
      a();
    }
    
    public boolean isDisposed()
    {
      return this.f.isDisposed();
    }
    
    public void onComplete()
    {
      this.c.onComplete();
      a();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
      a();
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      if (DisposableHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        this.c.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */