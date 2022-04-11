package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;

public final class d<T>
  implements v<T>, c
{
  final v<? super T> c;
  final g<? super c> d;
  final io.reactivex.g0.a f;
  c q;
  
  public d(v<? super T> paramv, g<? super c> paramg, io.reactivex.g0.a parama)
  {
    this.c = paramv;
    this.d = paramg;
    this.f = parama;
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	io/reactivex/internal/observers/d:q	Lio/reactivex/e0/c;
    //   4: astore_1
    //   5: getstatic 42	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
    //   8: astore_2
    //   9: aload_1
    //   10: aload_2
    //   11: if_acmpeq +35 -> 46
    //   14: aload_0
    //   15: aload_2
    //   16: putfield 36	io/reactivex/internal/observers/d:q	Lio/reactivex/e0/c;
    //   19: aload_0
    //   20: getfield 30	io/reactivex/internal/observers/d:f	Lio/reactivex/g0/a;
    //   23: invokeinterface 47 1 0
    //   28: goto +12 -> 40
    //   31: astore_2
    //   32: aload_2
    //   33: invokestatic 53	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   36: aload_2
    //   37: invokestatic 58	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   40: aload_1
    //   41: invokeinterface 60 1 0
    //   46: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	d
    //   4	37	1	localc	c
    //   8	8	2	localDisposableHelper	DisposableHelper
    //   31	6	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   19	28	31	finally
  }
  
  public boolean isDisposed()
  {
    return this.q.isDisposed();
  }
  
  public void onComplete()
  {
    c localc = this.q;
    DisposableHelper localDisposableHelper = DisposableHelper.DISPOSED;
    if (localc != localDisposableHelper)
    {
      this.q = localDisposableHelper;
      this.c.onComplete();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    c localc = this.q;
    DisposableHelper localDisposableHelper = DisposableHelper.DISPOSED;
    if (localc != localDisposableHelper)
    {
      this.q = localDisposableHelper;
      this.c.onError(paramThrowable);
    }
    else
    {
      io.reactivex.j0.a.r(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    this.c.onNext(paramT);
  }
  
  public void onSubscribe(c paramc)
  {
    try
    {
      this.d.accept(paramc);
      if (DisposableHelper.validate(this.q, paramc))
      {
        this.q = paramc;
        this.c.onSubscribe(this);
      }
      return;
    }
    finally
    {
      io.reactivex.exceptions.a.b(localThrowable);
      paramc.dispose();
      this.q = DisposableHelper.DISPOSED;
      EmptyDisposable.error(localThrowable, this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */