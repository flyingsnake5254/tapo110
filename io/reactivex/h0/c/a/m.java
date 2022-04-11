package io.reactivex.h0.c.a;

import io.reactivex.e;
import io.reactivex.g0.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class m
  extends io.reactivex.a
{
  final e c;
  final g<? super io.reactivex.e0.c> d;
  final g<? super Throwable> f;
  final io.reactivex.g0.a q;
  final io.reactivex.g0.a x;
  final io.reactivex.g0.a y;
  final io.reactivex.g0.a z;
  
  public m(e parame, g<? super io.reactivex.e0.c> paramg, g<? super Throwable> paramg1, io.reactivex.g0.a parama1, io.reactivex.g0.a parama2, io.reactivex.g0.a parama3, io.reactivex.g0.a parama4)
  {
    this.c = parame;
    this.d = paramg;
    this.f = paramg1;
    this.q = parama1;
    this.x = parama2;
    this.y = parama3;
    this.z = parama4;
  }
  
  protected void B(io.reactivex.c paramc)
  {
    this.c.a(new a(paramc));
  }
  
  final class a
    implements io.reactivex.c, io.reactivex.e0.c
  {
    final io.reactivex.c c;
    io.reactivex.e0.c d;
    
    a(io.reactivex.c paramc)
    {
      this.c = paramc;
    }
    
    /* Error */
    void a()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 21	io/reactivex/h0/c/a/m$a:f	Lio/reactivex/h0/c/a/m;
      //   4: getfield 31	io/reactivex/h0/c/a/m:y	Lio/reactivex/g0/a;
      //   7: invokeinterface 36 1 0
      //   12: goto +12 -> 24
      //   15: astore_1
      //   16: aload_1
      //   17: invokestatic 42	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   20: aload_1
      //   21: invokestatic 47	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   24: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	25	0	this	a
      //   15	6	1	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	12	15	finally
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 21	io/reactivex/h0/c/a/m$a:f	Lio/reactivex/h0/c/a/m;
      //   4: getfield 51	io/reactivex/h0/c/a/m:z	Lio/reactivex/g0/a;
      //   7: invokeinterface 36 1 0
      //   12: goto +12 -> 24
      //   15: astore_1
      //   16: aload_1
      //   17: invokestatic 42	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   20: aload_1
      //   21: invokestatic 47	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   24: aload_0
      //   25: getfield 53	io/reactivex/h0/c/a/m$a:d	Lio/reactivex/e0/c;
      //   28: invokeinterface 55 1 0
      //   33: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	34	0	this	a
      //   15	6	1	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	12	15	finally
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public void onComplete()
    {
      if (this.d == DisposableHelper.DISPOSED) {
        return;
      }
      try
      {
        m.this.q.run();
        m.this.x.run();
        this.c.onComplete();
        a();
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(localThrowable);
        this.c.onError(localThrowable);
      }
    }
    
    /* Error */
    public void onError(Throwable paramThrowable)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 53	io/reactivex/h0/c/a/m$a:d	Lio/reactivex/e0/c;
      //   4: getstatic 66	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
      //   7: if_acmpne +8 -> 15
      //   10: aload_1
      //   11: invokestatic 47	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   14: return
      //   15: aload_0
      //   16: getfield 21	io/reactivex/h0/c/a/m$a:f	Lio/reactivex/h0/c/a/m;
      //   19: getfield 82	io/reactivex/h0/c/a/m:f	Lio/reactivex/g0/g;
      //   22: aload_1
      //   23: invokeinterface 88 2 0
      //   28: aload_0
      //   29: getfield 21	io/reactivex/h0/c/a/m$a:f	Lio/reactivex/h0/c/a/m;
      //   32: getfield 72	io/reactivex/h0/c/a/m:x	Lio/reactivex/g0/a;
      //   35: invokeinterface 36 1 0
      //   40: goto +28 -> 68
      //   43: astore_2
      //   44: aload_2
      //   45: invokestatic 42	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   48: new 90	io/reactivex/exceptions/CompositeException
      //   51: dup
      //   52: iconst_2
      //   53: anewarray 92	java/lang/Throwable
      //   56: dup
      //   57: iconst_0
      //   58: aload_1
      //   59: aastore
      //   60: dup
      //   61: iconst_1
      //   62: aload_2
      //   63: aastore
      //   64: invokespecial 95	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   67: astore_1
      //   68: aload_0
      //   69: getfield 26	io/reactivex/h0/c/a/m$a:c	Lio/reactivex/c;
      //   72: aload_1
      //   73: invokeinterface 79 2 0
      //   78: aload_0
      //   79: invokevirtual 76	io/reactivex/h0/c/a/m$a:a	()V
      //   82: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	a
      //   0	83	1	paramThrowable	Throwable
      //   43	20	2	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   15	40	43	finally
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      try
      {
        m.this.d.accept(paramc);
        if (DisposableHelper.validate(this.d, paramc))
        {
          this.d = paramc;
          this.c.onSubscribe(this);
        }
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(localThrowable);
        paramc.dispose();
        this.d = DisposableHelper.DISPOSED;
        EmptyDisposable.error(localThrowable, this.c);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */