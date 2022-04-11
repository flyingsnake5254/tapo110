package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.l;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;

public final class b1<T>
  extends a<T, T>
{
  final l<? super T> d;
  
  public b1(t<T> paramt, l<? super T> paraml)
  {
    super(paramt);
    this.d = paraml;
  }
  
  public void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv, this.d));
  }
  
  static final class a<T>
    implements v<T>, c
  {
    final v<? super T> c;
    final l<? super T> d;
    c f;
    boolean q;
    
    a(v<? super T> paramv, l<? super T> paraml)
    {
      this.c = paramv;
      this.d = paraml;
    }
    
    public void dispose()
    {
      this.f.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.f.isDisposed();
    }
    
    public void onComplete()
    {
      if (!this.q)
      {
        this.q = true;
        this.c.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!this.q)
      {
        this.q = true;
        this.c.onError(paramThrowable);
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    /* Error */
    public void onNext(T paramT)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 46	io/reactivex/internal/operators/observable/b1$a:q	Z
      //   4: ifne +73 -> 77
      //   7: aload_0
      //   8: getfield 29	io/reactivex/internal/operators/observable/b1$a:c	Lio/reactivex/v;
      //   11: aload_1
      //   12: invokeinterface 61 2 0
      //   17: aload_0
      //   18: getfield 31	io/reactivex/internal/operators/observable/b1$a:d	Lio/reactivex/g0/l;
      //   21: aload_1
      //   22: invokeinterface 67 2 0
      //   27: istore_2
      //   28: iload_2
      //   29: ifeq +48 -> 77
      //   32: aload_0
      //   33: iconst_1
      //   34: putfield 46	io/reactivex/internal/operators/observable/b1$a:q	Z
      //   37: aload_0
      //   38: getfield 37	io/reactivex/internal/operators/observable/b1$a:f	Lio/reactivex/e0/c;
      //   41: invokeinterface 39 1 0
      //   46: aload_0
      //   47: getfield 29	io/reactivex/internal/operators/observable/b1$a:c	Lio/reactivex/v;
      //   50: invokeinterface 48 1 0
      //   55: goto +22 -> 77
      //   58: astore_1
      //   59: aload_1
      //   60: invokestatic 72	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   63: aload_0
      //   64: getfield 37	io/reactivex/internal/operators/observable/b1$a:f	Lio/reactivex/e0/c;
      //   67: invokeinterface 39 1 0
      //   72: aload_0
      //   73: aload_1
      //   74: invokevirtual 73	io/reactivex/internal/operators/observable/b1$a:onError	(Ljava/lang/Throwable;)V
      //   77: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	a
      //   0	78	1	paramT	T
      //   27	2	2	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   17	28	58	finally
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\b1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */