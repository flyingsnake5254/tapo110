package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.n;
import io.reactivex.o;

public final class h<T>
  extends a<T, T>
{
  final g<? super c> d;
  final g<? super T> f;
  final g<? super Throwable> q;
  final io.reactivex.g0.a x;
  final io.reactivex.g0.a y;
  final io.reactivex.g0.a z;
  
  public h(o<T> paramo, g<? super c> paramg, g<? super T> paramg1, g<? super Throwable> paramg2, io.reactivex.g0.a parama1, io.reactivex.g0.a parama2, io.reactivex.g0.a parama3)
  {
    super(paramo);
    this.d = paramg;
    this.f = paramg1;
    this.q = paramg2;
    this.x = parama1;
    this.y = parama2;
    this.z = parama3;
  }
  
  protected void n(n<? super T> paramn)
  {
    this.c.a(new a(paramn, this));
  }
  
  static final class a<T>
    implements n<T>, c
  {
    final n<? super T> c;
    final h<T> d;
    c f;
    
    a(n<? super T> paramn, h<T> paramh)
    {
      this.c = paramn;
      this.d = paramh;
    }
    
    /* Error */
    void a()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 29	io/reactivex/internal/operators/maybe/h$a:d	Lio/reactivex/internal/operators/maybe/h;
      //   4: getfield 36	io/reactivex/internal/operators/maybe/h:y	Lio/reactivex/g0/a;
      //   7: invokeinterface 41 1 0
      //   12: goto +12 -> 24
      //   15: astore_1
      //   16: aload_1
      //   17: invokestatic 47	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   20: aload_1
      //   21: invokestatic 52	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
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
    void b(Throwable paramThrowable)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 29	io/reactivex/internal/operators/maybe/h$a:d	Lio/reactivex/internal/operators/maybe/h;
      //   4: getfield 56	io/reactivex/internal/operators/maybe/h:q	Lio/reactivex/g0/g;
      //   7: aload_1
      //   8: invokeinterface 62 2 0
      //   13: goto +28 -> 41
      //   16: astore_2
      //   17: aload_2
      //   18: invokestatic 47	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   21: new 64	io/reactivex/exceptions/CompositeException
      //   24: dup
      //   25: iconst_2
      //   26: anewarray 66	java/lang/Throwable
      //   29: dup
      //   30: iconst_0
      //   31: aload_1
      //   32: aastore
      //   33: dup
      //   34: iconst_1
      //   35: aload_2
      //   36: aastore
      //   37: invokespecial 69	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   40: astore_1
      //   41: aload_0
      //   42: getstatic 75	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
      //   45: putfield 77	io/reactivex/internal/operators/maybe/h$a:f	Lio/reactivex/e0/c;
      //   48: aload_0
      //   49: getfield 27	io/reactivex/internal/operators/maybe/h$a:c	Lio/reactivex/n;
      //   52: aload_1
      //   53: invokeinterface 80 2 0
      //   58: aload_0
      //   59: invokevirtual 82	io/reactivex/internal/operators/maybe/h$a:a	()V
      //   62: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	a
      //   0	63	1	paramThrowable	Throwable
      //   16	20	2	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	13	16	finally
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 29	io/reactivex/internal/operators/maybe/h$a:d	Lio/reactivex/internal/operators/maybe/h;
      //   4: getfield 86	io/reactivex/internal/operators/maybe/h:z	Lio/reactivex/g0/a;
      //   7: invokeinterface 41 1 0
      //   12: goto +12 -> 24
      //   15: astore_1
      //   16: aload_1
      //   17: invokestatic 47	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   20: aload_1
      //   21: invokestatic 52	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   24: aload_0
      //   25: getfield 77	io/reactivex/internal/operators/maybe/h$a:f	Lio/reactivex/e0/c;
      //   28: invokeinterface 88 1 0
      //   33: aload_0
      //   34: getstatic 75	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
      //   37: putfield 77	io/reactivex/internal/operators/maybe/h$a:f	Lio/reactivex/e0/c;
      //   40: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	41	0	this	a
      //   15	6	1	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	12	15	finally
    }
    
    public boolean isDisposed()
    {
      return this.f.isDisposed();
    }
    
    public void onComplete()
    {
      c localc = this.f;
      DisposableHelper localDisposableHelper = DisposableHelper.DISPOSED;
      if (localc == localDisposableHelper) {
        return;
      }
      try
      {
        this.d.x.run();
        this.f = localDisposableHelper;
        this.c.onComplete();
        a();
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(localThrowable);
        b(localThrowable);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.f == DisposableHelper.DISPOSED)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      b(paramThrowable);
    }
    
    /* Error */
    public void onSubscribe(c paramc)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 77	io/reactivex/internal/operators/maybe/h$a:f	Lio/reactivex/e0/c;
      //   4: aload_1
      //   5: invokestatic 105	io/reactivex/internal/disposables/DisposableHelper:validate	(Lio/reactivex/e0/c;Lio/reactivex/e0/c;)Z
      //   8: ifeq +60 -> 68
      //   11: aload_0
      //   12: getfield 29	io/reactivex/internal/operators/maybe/h$a:d	Lio/reactivex/internal/operators/maybe/h;
      //   15: getfield 107	io/reactivex/internal/operators/maybe/h:d	Lio/reactivex/g0/g;
      //   18: aload_1
      //   19: invokeinterface 62 2 0
      //   24: aload_0
      //   25: aload_1
      //   26: putfield 77	io/reactivex/internal/operators/maybe/h$a:f	Lio/reactivex/e0/c;
      //   29: aload_0
      //   30: getfield 27	io/reactivex/internal/operators/maybe/h$a:c	Lio/reactivex/n;
      //   33: aload_0
      //   34: invokeinterface 109 2 0
      //   39: goto +29 -> 68
      //   42: astore_2
      //   43: aload_2
      //   44: invokestatic 47	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   47: aload_1
      //   48: invokeinterface 88 1 0
      //   53: aload_0
      //   54: getstatic 75	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
      //   57: putfield 77	io/reactivex/internal/operators/maybe/h$a:f	Lio/reactivex/e0/c;
      //   60: aload_2
      //   61: aload_0
      //   62: getfield 27	io/reactivex/internal/operators/maybe/h$a:c	Lio/reactivex/n;
      //   65: invokestatic 115	io/reactivex/internal/disposables/EmptyDisposable:error	(Ljava/lang/Throwable;Lio/reactivex/n;)V
      //   68: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	69	0	this	a
      //   0	69	1	paramc	c
      //   42	19	2	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   11	24	42	finally
    }
    
    public void onSuccess(T paramT)
    {
      c localc = this.f;
      DisposableHelper localDisposableHelper = DisposableHelper.DISPOSED;
      if (localc == localDisposableHelper) {
        return;
      }
      try
      {
        this.d.f.accept(paramT);
        this.f = localDisposableHelper;
        this.c.onSuccess(paramT);
        a();
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(paramT);
        b(paramT);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\maybe\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */