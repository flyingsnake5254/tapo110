package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.g0.g;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class f<T>
  extends a<T, T>
{
  private final g<? super c> f;
  private final io.reactivex.g0.k q;
  private final io.reactivex.g0.a x;
  
  public f(h<T> paramh, g<? super c> paramg, io.reactivex.g0.k paramk, io.reactivex.g0.a parama)
  {
    super(paramh);
    this.f = paramg;
    this.q = paramk;
    this.x = parama;
  }
  
  protected void H(b<? super T> paramb)
  {
    this.d.G(new a(paramb, this.f, this.q, this.x));
  }
  
  static final class a<T>
    implements io.reactivex.k<T>, c
  {
    final b<? super T> c;
    final g<? super c> d;
    final io.reactivex.g0.k f;
    final io.reactivex.g0.a q;
    c x;
    
    a(b<? super T> paramb, g<? super c> paramg, io.reactivex.g0.k paramk, io.reactivex.g0.a parama)
    {
      this.c = paramb;
      this.d = paramg;
      this.q = parama;
      this.f = paramk;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 43	io/reactivex/internal/operators/flowable/f$a:x	Le/b/c;
      //   4: astore_1
      //   5: getstatic 49	io/reactivex/internal/subscriptions/SubscriptionHelper:CANCELLED	Lio/reactivex/internal/subscriptions/SubscriptionHelper;
      //   8: astore_2
      //   9: aload_1
      //   10: aload_2
      //   11: if_acmpeq +35 -> 46
      //   14: aload_0
      //   15: aload_2
      //   16: putfield 43	io/reactivex/internal/operators/flowable/f$a:x	Le/b/c;
      //   19: aload_0
      //   20: getfield 35	io/reactivex/internal/operators/flowable/f$a:q	Lio/reactivex/g0/a;
      //   23: invokeinterface 54 1 0
      //   28: goto +12 -> 40
      //   31: astore_2
      //   32: aload_2
      //   33: invokestatic 60	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   36: aload_2
      //   37: invokestatic 65	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   40: aload_1
      //   41: invokeinterface 67 1 0
      //   46: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	47	0	this	a
      //   4	37	1	localc	c
      //   8	8	2	localSubscriptionHelper	SubscriptionHelper
      //   31	6	2	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   19	28	31	finally
    }
    
    public void onComplete()
    {
      if (this.x != SubscriptionHelper.CANCELLED) {
        this.c.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.x != SubscriptionHelper.CANCELLED) {
        this.c.onError(paramThrowable);
      } else {
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
        if (SubscriptionHelper.validate(this.x, paramc))
        {
          this.x = paramc;
          this.c.onSubscribe(this);
        }
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(localThrowable);
        paramc.cancel();
        this.x = SubscriptionHelper.CANCELLED;
        EmptySubscription.error(localThrowable, this.c);
      }
    }
    
    /* Error */
    public void request(long paramLong)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 37	io/reactivex/internal/operators/flowable/f$a:f	Lio/reactivex/g0/k;
      //   4: lload_1
      //   5: invokeinterface 105 3 0
      //   10: goto +12 -> 22
      //   13: astore_3
      //   14: aload_3
      //   15: invokestatic 60	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   18: aload_3
      //   19: invokestatic 65	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   22: aload_0
      //   23: getfield 43	io/reactivex/internal/operators/flowable/f$a:x	Le/b/c;
      //   26: lload_1
      //   27: invokeinterface 107 3 0
      //   32: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	33	0	this	a
      //   0	33	1	paramLong	long
      //   13	6	3	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	10	13	finally
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */