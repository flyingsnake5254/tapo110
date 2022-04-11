package io.reactivex.internal.operators.flowable;

import e.b.c;
import io.reactivex.g0.g;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicLong;

public final class s<T>
  extends a<T, T>
  implements g<T>
{
  final g<? super T> f = this;
  
  public s(h<T> paramh)
  {
    super(paramh);
  }
  
  protected void H(e.b.b<? super T> paramb)
  {
    this.d.G(new a(paramb, this.f));
  }
  
  public void accept(T paramT) {}
  
  static final class a<T>
    extends AtomicLong
    implements k<T>, c
  {
    final e.b.b<? super T> c;
    final g<? super T> d;
    c f;
    boolean q;
    
    a(e.b.b<? super T> paramb, g<? super T> paramg)
    {
      this.c = paramb;
      this.d = paramg;
    }
    
    public void cancel()
    {
      this.f.cancel();
    }
    
    public void onComplete()
    {
      if (this.q) {
        return;
      }
      this.q = true;
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.q)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      this.q = true;
      this.c.onError(paramThrowable);
    }
    
    /* Error */
    public void onNext(T paramT)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 42	io/reactivex/internal/operators/flowable/s$a:q	Z
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: invokevirtual 61	java/util/concurrent/atomic/AtomicLong:get	()J
      //   12: lconst_0
      //   13: lcmp
      //   14: ifeq +22 -> 36
      //   17: aload_0
      //   18: getfield 29	io/reactivex/internal/operators/flowable/s$a:c	Le/b/b;
      //   21: aload_1
      //   22: invokeinterface 63 2 0
      //   27: aload_0
      //   28: lconst_1
      //   29: invokestatic 68	io/reactivex/internal/util/b:c	(Ljava/util/concurrent/atomic/AtomicLong;J)J
      //   32: pop2
      //   33: goto +30 -> 63
      //   36: aload_0
      //   37: getfield 31	io/reactivex/internal/operators/flowable/s$a:d	Lio/reactivex/g0/g;
      //   40: aload_1
      //   41: invokeinterface 73 2 0
      //   46: goto +17 -> 63
      //   49: astore_1
      //   50: aload_1
      //   51: invokestatic 78	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   54: aload_0
      //   55: invokevirtual 79	io/reactivex/internal/operators/flowable/s$a:cancel	()V
      //   58: aload_0
      //   59: aload_1
      //   60: invokevirtual 80	io/reactivex/internal/operators/flowable/s$a:onError	(Ljava/lang/Throwable;)V
      //   63: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	64	0	this	a
      //   0	64	1	paramT	T
      // Exception table:
      //   from	to	target	type
      //   36	46	49	finally
    }
    
    public void onSubscribe(c paramc)
    {
      if (SubscriptionHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        this.c.onSubscribe(this);
        paramc.request(Long.MAX_VALUE);
      }
    }
    
    public void request(long paramLong)
    {
      if (SubscriptionHelper.validate(paramLong)) {
        io.reactivex.internal.util.b.a(this, paramLong);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */