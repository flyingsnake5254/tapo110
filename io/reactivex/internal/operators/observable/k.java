package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;

public final class k<T>
  extends a<T, T>
{
  final g<? super T> d;
  final g<? super Throwable> f;
  final io.reactivex.g0.a q;
  final io.reactivex.g0.a x;
  
  public k(t<T> paramt, g<? super T> paramg, g<? super Throwable> paramg1, io.reactivex.g0.a parama1, io.reactivex.g0.a parama2)
  {
    super(paramt);
    this.d = paramg;
    this.f = paramg1;
    this.q = parama1;
    this.x = parama2;
  }
  
  public void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv, this.d, this.f, this.q, this.x));
  }
  
  static final class a<T>
    implements v<T>, c
  {
    final v<? super T> c;
    final g<? super T> d;
    final g<? super Throwable> f;
    final io.reactivex.g0.a q;
    final io.reactivex.g0.a x;
    c y;
    boolean z;
    
    a(v<? super T> paramv, g<? super T> paramg, g<? super Throwable> paramg1, io.reactivex.g0.a parama1, io.reactivex.g0.a parama2)
    {
      this.c = paramv;
      this.d = paramg;
      this.f = paramg1;
      this.q = parama1;
      this.x = parama2;
    }
    
    public void dispose()
    {
      this.y.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.y.isDisposed();
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 57	io/reactivex/internal/operators/observable/k$a:z	Z
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 40	io/reactivex/internal/operators/observable/k$a:q	Lio/reactivex/g0/a;
      //   12: invokeinterface 62 1 0
      //   17: aload_0
      //   18: iconst_1
      //   19: putfield 57	io/reactivex/internal/operators/observable/k$a:z	Z
      //   22: aload_0
      //   23: getfield 34	io/reactivex/internal/operators/observable/k$a:c	Lio/reactivex/v;
      //   26: invokeinterface 64 1 0
      //   31: aload_0
      //   32: getfield 42	io/reactivex/internal/operators/observable/k$a:x	Lio/reactivex/g0/a;
      //   35: invokeinterface 62 1 0
      //   40: goto +12 -> 52
      //   43: astore_1
      //   44: aload_1
      //   45: invokestatic 70	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   48: aload_1
      //   49: invokestatic 75	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   52: return
      //   53: astore_1
      //   54: aload_1
      //   55: invokestatic 70	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   58: aload_0
      //   59: aload_1
      //   60: invokevirtual 78	io/reactivex/internal/operators/observable/k$a:onError	(Ljava/lang/Throwable;)V
      //   63: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	64	0	this	a
      //   43	6	1	localThrowable1	Throwable
      //   53	7	1	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   31	40	43	finally
      //   8	17	53	finally
    }
    
    /* Error */
    public void onError(Throwable paramThrowable)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 57	io/reactivex/internal/operators/observable/k$a:z	Z
      //   4: ifeq +8 -> 12
      //   7: aload_1
      //   8: invokestatic 75	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   11: return
      //   12: aload_0
      //   13: iconst_1
      //   14: putfield 57	io/reactivex/internal/operators/observable/k$a:z	Z
      //   17: aload_0
      //   18: getfield 38	io/reactivex/internal/operators/observable/k$a:f	Lio/reactivex/g0/g;
      //   21: aload_1
      //   22: invokeinterface 84 2 0
      //   27: goto +28 -> 55
      //   30: astore_2
      //   31: aload_2
      //   32: invokestatic 70	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   35: new 86	io/reactivex/exceptions/CompositeException
      //   38: dup
      //   39: iconst_2
      //   40: anewarray 88	java/lang/Throwable
      //   43: dup
      //   44: iconst_0
      //   45: aload_1
      //   46: aastore
      //   47: dup
      //   48: iconst_1
      //   49: aload_2
      //   50: aastore
      //   51: invokespecial 91	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   54: astore_1
      //   55: aload_0
      //   56: getfield 34	io/reactivex/internal/operators/observable/k$a:c	Lio/reactivex/v;
      //   59: aload_1
      //   60: invokeinterface 92 2 0
      //   65: aload_0
      //   66: getfield 42	io/reactivex/internal/operators/observable/k$a:x	Lio/reactivex/g0/a;
      //   69: invokeinterface 62 1 0
      //   74: goto +12 -> 86
      //   77: astore_1
      //   78: aload_1
      //   79: invokestatic 70	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   82: aload_1
      //   83: invokestatic 75	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   86: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	87	0	this	a
      //   0	87	1	paramThrowable	Throwable
      //   30	20	2	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   17	27	30	finally
      //   65	74	77	finally
    }
    
    public void onNext(T paramT)
    {
      if (this.z) {
        return;
      }
      try
      {
        this.d.accept(paramT);
        this.c.onNext(paramT);
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(paramT);
        this.y.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.y, paramc))
      {
        this.y = paramc;
        this.c.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */