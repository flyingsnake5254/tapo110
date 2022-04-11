package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j0.a;
import io.reactivex.m;
import io.reactivex.n;
import io.reactivex.t;
import io.reactivex.v;

public final class m0<T>
  extends m<T>
{
  final t<T> c;
  final io.reactivex.g0.c<T, T, T> d;
  
  public m0(t<T> paramt, io.reactivex.g0.c<T, T, T> paramc)
  {
    this.c = paramt;
    this.d = paramc;
  }
  
  protected void n(n<? super T> paramn)
  {
    this.c.a(new a(paramn, this.d));
  }
  
  static final class a<T>
    implements v<T>, io.reactivex.e0.c
  {
    final n<? super T> c;
    final io.reactivex.g0.c<T, T, T> d;
    boolean f;
    T q;
    io.reactivex.e0.c x;
    
    a(n<? super T> paramn, io.reactivex.g0.c<T, T, T> paramc)
    {
      this.c = paramn;
      this.d = paramc;
    }
    
    public void dispose()
    {
      this.x.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.x.isDisposed();
    }
    
    public void onComplete()
    {
      if (this.f) {
        return;
      }
      this.f = true;
      Object localObject = this.q;
      this.q = null;
      if (localObject != null) {
        this.c.onSuccess(localObject);
      } else {
        this.c.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.f)
      {
        a.r(paramThrowable);
        return;
      }
      this.f = true;
      this.q = null;
      this.c.onError(paramThrowable);
    }
    
    /* Error */
    public void onNext(T paramT)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 49	io/reactivex/internal/operators/observable/m0$a:f	Z
      //   4: ifne +62 -> 66
      //   7: aload_0
      //   8: getfield 51	io/reactivex/internal/operators/observable/m0$a:q	Ljava/lang/Object;
      //   11: astore_2
      //   12: aload_2
      //   13: ifnonnull +11 -> 24
      //   16: aload_0
      //   17: aload_1
      //   18: putfield 51	io/reactivex/internal/operators/observable/m0$a:q	Ljava/lang/Object;
      //   21: goto +45 -> 66
      //   24: aload_0
      //   25: aload_0
      //   26: getfield 34	io/reactivex/internal/operators/observable/m0$a:d	Lio/reactivex/g0/c;
      //   29: aload_2
      //   30: aload_1
      //   31: invokeinterface 75 3 0
      //   36: ldc 77
      //   38: invokestatic 83	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   41: putfield 51	io/reactivex/internal/operators/observable/m0$a:q	Ljava/lang/Object;
      //   44: goto +22 -> 66
      //   47: astore_1
      //   48: aload_1
      //   49: invokestatic 88	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   52: aload_0
      //   53: getfield 40	io/reactivex/internal/operators/observable/m0$a:x	Lio/reactivex/e0/c;
      //   56: invokeinterface 42 1 0
      //   61: aload_0
      //   62: aload_1
      //   63: invokevirtual 89	io/reactivex/internal/operators/observable/m0$a:onError	(Ljava/lang/Throwable;)V
      //   66: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	67	0	this	a
      //   0	67	1	paramT	T
      //   11	19	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   24	44	47	finally
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      if (DisposableHelper.validate(this.x, paramc))
      {
        this.x = paramc;
        this.c.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\m0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */