package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.h0.b.i;
import io.reactivex.internal.observers.f;
import io.reactivex.internal.util.j;
import io.reactivex.observers.d;
import io.reactivex.t;
import io.reactivex.v;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class b<T, U extends Collection<? super T>, B>
  extends a<T, U>
{
  final t<B> d;
  final Callable<U> f;
  
  public b(t<T> paramt, t<B> paramt1, Callable<U> paramCallable)
  {
    super(paramt);
    this.d = paramt1;
    this.f = paramCallable;
  }
  
  protected void K0(v<? super U> paramv)
  {
    this.c.a(new b(new d(paramv), this.f, this.d));
  }
  
  static final class a<T, U extends Collection<? super T>, B>
    extends io.reactivex.observers.b<B>
  {
    final b.b<T, U, B> d;
    
    a(b.b<T, U, B> paramb)
    {
      this.d = paramb;
    }
    
    public void onComplete()
    {
      this.d.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.d.onError(paramThrowable);
    }
    
    public void onNext(B paramB)
    {
      this.d.i();
    }
  }
  
  static final class b<T, U extends Collection<? super T>, B>
    extends f<T, U, U>
    implements v<T>, c
  {
    final t<B> p0;
    c p1;
    c p2;
    U p3;
    final Callable<U> z;
    
    b(v<? super U> paramv, Callable<U> paramCallable, t<B> paramt)
    {
      super(new io.reactivex.internal.queue.a());
      this.z = paramCallable;
      this.p0 = paramt;
    }
    
    public void dispose()
    {
      if (!this.q)
      {
        this.q = true;
        this.p2.dispose();
        this.p1.dispose();
        if (f()) {
          this.f.clear();
        }
      }
    }
    
    public void h(v<? super U> paramv, U paramU)
    {
      this.d.onNext(paramU);
    }
    
    void i()
    {
      try
      {
        Collection localCollection1 = (Collection)io.reactivex.h0.a.b.e(this.z.call(), "The buffer supplied is null");
        try
        {
          Collection localCollection2 = this.p3;
          if (localCollection2 == null) {
            return;
          }
          this.p3 = localCollection1;
          g(localCollection2, false, this);
          return;
        }
        finally {}
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(localThrowable);
        dispose();
      }
    }
    
    public boolean isDisposed()
    {
      return this.q;
    }
    
    public void onComplete()
    {
      try
      {
        Collection localCollection = this.p3;
        if (localCollection == null) {
          return;
        }
        this.p3 = null;
        this.f.offer(localCollection);
        this.x = true;
        if (f()) {
          j.c(this.f, this.d, false, this, this);
        }
        return;
      }
      finally {}
    }
    
    public void onError(Throwable paramThrowable)
    {
      dispose();
      this.d.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      try
      {
        Collection localCollection = this.p3;
        if (localCollection == null) {
          return;
        }
        localCollection.add(paramT);
        return;
      }
      finally {}
    }
    
    /* Error */
    public void onSubscribe(c paramc)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 60	io/reactivex/internal/operators/observable/b$b:p1	Lio/reactivex/e0/c;
      //   4: aload_1
      //   5: invokestatic 138	io/reactivex/internal/disposables/DisposableHelper:validate	(Lio/reactivex/e0/c;Lio/reactivex/e0/c;)Z
      //   8: ifeq +99 -> 107
      //   11: aload_0
      //   12: aload_1
      //   13: putfield 60	io/reactivex/internal/operators/observable/b$b:p1	Lio/reactivex/e0/c;
      //   16: aload_0
      //   17: getfield 36	io/reactivex/internal/operators/observable/b$b:z	Ljava/util/concurrent/Callable;
      //   20: invokeinterface 88 1 0
      //   25: ldc 90
      //   27: invokestatic 96	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   30: checkcast 45	java/util/Collection
      //   33: astore_2
      //   34: aload_0
      //   35: aload_2
      //   36: putfield 98	io/reactivex/internal/operators/observable/b$b:p3	Ljava/util/Collection;
      //   39: new 140	io/reactivex/internal/operators/observable/b$a
      //   42: dup
      //   43: aload_0
      //   44: invokespecial 143	io/reactivex/internal/operators/observable/b$a:<init>	(Lio/reactivex/internal/operators/observable/b$b;)V
      //   47: astore_1
      //   48: aload_0
      //   49: aload_1
      //   50: putfield 56	io/reactivex/internal/operators/observable/b$b:p2	Lio/reactivex/e0/c;
      //   53: aload_0
      //   54: getfield 76	io/reactivex/internal/observers/f:d	Lio/reactivex/v;
      //   57: aload_0
      //   58: invokeinterface 145 2 0
      //   63: aload_0
      //   64: getfield 54	io/reactivex/internal/observers/f:q	Z
      //   67: ifne +40 -> 107
      //   70: aload_0
      //   71: getfield 38	io/reactivex/internal/operators/observable/b$b:p0	Lio/reactivex/t;
      //   74: aload_1
      //   75: invokeinterface 150 2 0
      //   80: goto +27 -> 107
      //   83: astore_2
      //   84: aload_2
      //   85: invokestatic 107	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   88: aload_0
      //   89: iconst_1
      //   90: putfield 54	io/reactivex/internal/observers/f:q	Z
      //   93: aload_1
      //   94: invokeinterface 58 1 0
      //   99: aload_2
      //   100: aload_0
      //   101: getfield 76	io/reactivex/internal/observers/f:d	Lio/reactivex/v;
      //   104: invokestatic 156	io/reactivex/internal/disposables/EmptyDisposable:error	(Ljava/lang/Throwable;Lio/reactivex/v;)V
      //   107: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	108	0	this	b
      //   0	108	1	paramc	c
      //   33	3	2	localCollection	Collection
      //   83	17	2	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   16	34	83	finally
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */