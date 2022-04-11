package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;

public final class v<T, R>
  extends a<T, R>
{
  final j<? super T, ? extends Iterable<? extends R>> d;
  
  public v(t<T> paramt, j<? super T, ? extends Iterable<? extends R>> paramj)
  {
    super(paramt);
    this.d = paramj;
  }
  
  protected void K0(io.reactivex.v<? super R> paramv)
  {
    this.c.a(new a(paramv, this.d));
  }
  
  static final class a<T, R>
    implements io.reactivex.v<T>, c
  {
    final io.reactivex.v<? super R> c;
    final j<? super T, ? extends Iterable<? extends R>> d;
    c f;
    
    a(io.reactivex.v<? super R> paramv, j<? super T, ? extends Iterable<? extends R>> paramj)
    {
      this.c = paramv;
      this.d = paramj;
    }
    
    public void dispose()
    {
      this.f.dispose();
      this.f = DisposableHelper.DISPOSED;
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
      this.f = localDisposableHelper;
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      c localc = this.f;
      DisposableHelper localDisposableHelper = DisposableHelper.DISPOSED;
      if (localc == localDisposableHelper)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      this.f = localDisposableHelper;
      this.c.onError(paramThrowable);
    }
    
    /* Error */
    public void onNext(T paramT)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 35	io/reactivex/internal/operators/observable/v$a:f	Lio/reactivex/e0/c;
      //   4: getstatic 43	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
      //   7: if_acmpne +4 -> 11
      //   10: return
      //   11: aload_0
      //   12: getfield 29	io/reactivex/internal/operators/observable/v$a:d	Lio/reactivex/g0/j;
      //   15: aload_1
      //   16: invokeinterface 67 2 0
      //   21: checkcast 69	java/lang/Iterable
      //   24: invokeinterface 73 1 0
      //   29: astore_2
      //   30: aload_0
      //   31: getfield 27	io/reactivex/internal/operators/observable/v$a:c	Lio/reactivex/v;
      //   34: astore_1
      //   35: aload_2
      //   36: invokeinterface 78 1 0
      //   41: istore_3
      //   42: iload_3
      //   43: ifeq +46 -> 89
      //   46: aload_2
      //   47: invokeinterface 82 1 0
      //   52: ldc 84
      //   54: invokestatic 90	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   57: astore 4
      //   59: aload_1
      //   60: aload 4
      //   62: invokeinterface 92 2 0
      //   67: goto -32 -> 35
      //   70: astore_1
      //   71: aload_1
      //   72: invokestatic 97	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   75: aload_0
      //   76: getfield 35	io/reactivex/internal/operators/observable/v$a:f	Lio/reactivex/e0/c;
      //   79: invokeinterface 37 1 0
      //   84: aload_0
      //   85: aload_1
      //   86: invokevirtual 98	io/reactivex/internal/operators/observable/v$a:onError	(Ljava/lang/Throwable;)V
      //   89: return
      //   90: astore_1
      //   91: aload_1
      //   92: invokestatic 97	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   95: aload_0
      //   96: getfield 35	io/reactivex/internal/operators/observable/v$a:f	Lio/reactivex/e0/c;
      //   99: invokeinterface 37 1 0
      //   104: aload_0
      //   105: aload_1
      //   106: invokevirtual 98	io/reactivex/internal/operators/observable/v$a:onError	(Ljava/lang/Throwable;)V
      //   109: return
      //   110: astore_1
      //   111: aload_1
      //   112: invokestatic 97	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   115: aload_0
      //   116: getfield 35	io/reactivex/internal/operators/observable/v$a:f	Lio/reactivex/e0/c;
      //   119: invokeinterface 37 1 0
      //   124: aload_0
      //   125: aload_1
      //   126: invokevirtual 98	io/reactivex/internal/operators/observable/v$a:onError	(Ljava/lang/Throwable;)V
      //   129: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	130	0	this	a
      //   0	130	1	paramT	T
      //   29	18	2	localIterator	java.util.Iterator
      //   41	2	3	bool	boolean
      //   57	4	4	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   46	59	70	finally
      //   35	42	90	finally
      //   11	30	110	finally
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        this.c.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */