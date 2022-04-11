package io.reactivex.internal.subscribers;

import io.reactivex.g0.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicReference;

public final class BoundedSubscriber<T>
  extends AtomicReference<e.b.c>
  implements k<T>, e.b.c, io.reactivex.e0.c
{
  private static final long serialVersionUID = -7251123623727029452L;
  final int bufferSize;
  int consumed;
  final int limit;
  final io.reactivex.g0.a onComplete;
  final g<? super Throwable> onError;
  final g<? super T> onNext;
  final g<? super e.b.c> onSubscribe;
  
  public BoundedSubscriber(g<? super T> paramg, g<? super Throwable> paramg1, io.reactivex.g0.a parama, g<? super e.b.c> paramg2, int paramInt)
  {
    this.onNext = paramg;
    this.onError = paramg1;
    this.onComplete = parama;
    this.onSubscribe = paramg2;
    this.bufferSize = paramInt;
    this.limit = (paramInt - (paramInt >> 2));
  }
  
  public void cancel()
  {
    SubscriptionHelper.cancel(this);
  }
  
  public void dispose()
  {
    cancel();
  }
  
  public boolean hasCustomOnError()
  {
    boolean bool;
    if (this.onError != io.reactivex.h0.a.a.f) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isDisposed()
  {
    boolean bool;
    if (get() == SubscriptionHelper.CANCELLED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public void onComplete()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 69	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   4: astore_1
    //   5: getstatic 73	io/reactivex/internal/subscriptions/SubscriptionHelper:CANCELLED	Lio/reactivex/internal/subscriptions/SubscriptionHelper;
    //   8: astore_2
    //   9: aload_1
    //   10: aload_2
    //   11: if_acmpeq +29 -> 40
    //   14: aload_0
    //   15: aload_2
    //   16: invokevirtual 77	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   19: aload_0
    //   20: getfield 39	io/reactivex/internal/subscribers/BoundedSubscriber:onComplete	Lio/reactivex/g0/a;
    //   23: invokeinterface 82 1 0
    //   28: goto +12 -> 40
    //   31: astore_2
    //   32: aload_2
    //   33: invokestatic 88	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   36: aload_2
    //   37: invokestatic 93	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   40: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	BoundedSubscriber
    //   4	6	1	localObject	Object
    //   8	8	2	localSubscriptionHelper	SubscriptionHelper
    //   31	6	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   19	28	31	finally
  }
  
  /* Error */
  public void onError(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 69	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   4: astore_2
    //   5: getstatic 73	io/reactivex/internal/subscriptions/SubscriptionHelper:CANCELLED	Lio/reactivex/internal/subscriptions/SubscriptionHelper;
    //   8: astore_3
    //   9: aload_2
    //   10: aload_3
    //   11: if_acmpeq +51 -> 62
    //   14: aload_0
    //   15: aload_3
    //   16: invokevirtual 77	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   19: aload_0
    //   20: getfield 37	io/reactivex/internal/subscribers/BoundedSubscriber:onError	Lio/reactivex/g0/g;
    //   23: aload_1
    //   24: invokeinterface 98 2 0
    //   29: goto +37 -> 66
    //   32: astore_3
    //   33: aload_3
    //   34: invokestatic 88	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   37: new 100	io/reactivex/exceptions/CompositeException
    //   40: dup
    //   41: iconst_2
    //   42: anewarray 102	java/lang/Throwable
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload_3
    //   52: aastore
    //   53: invokespecial 105	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
    //   56: invokestatic 93	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   59: goto +7 -> 66
    //   62: aload_1
    //   63: invokestatic 93	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   66: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	BoundedSubscriber
    //   0	67	1	paramThrowable	Throwable
    //   4	6	2	localObject	Object
    //   8	8	3	localSubscriptionHelper	SubscriptionHelper
    //   32	20	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   19	29	32	finally
  }
  
  public void onNext(T paramT)
  {
    if (!isDisposed()) {
      try
      {
        this.onNext.accept(paramT);
        int i = this.consumed + 1;
        if (i == this.limit)
        {
          this.consumed = 0;
          ((e.b.c)get()).request(this.limit);
        }
        else
        {
          this.consumed = i;
        }
      }
      finally
      {
        io.reactivex.exceptions.a.b(paramT);
        ((e.b.c)get()).cancel();
        onError(paramT);
      }
    }
  }
  
  /* Error */
  public void onSubscribe(e.b.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 122	io/reactivex/internal/subscriptions/SubscriptionHelper:setOnce	(Ljava/util/concurrent/atomic/AtomicReference;Le/b/c;)Z
    //   5: ifeq +32 -> 37
    //   8: aload_0
    //   9: getfield 41	io/reactivex/internal/subscribers/BoundedSubscriber:onSubscribe	Lio/reactivex/g0/g;
    //   12: aload_0
    //   13: invokeinterface 98 2 0
    //   18: goto +19 -> 37
    //   21: astore_2
    //   22: aload_2
    //   23: invokestatic 88	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   26: aload_1
    //   27: invokeinterface 114 1 0
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 116	io/reactivex/internal/subscribers/BoundedSubscriber:onError	(Ljava/lang/Throwable;)V
    //   37: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	BoundedSubscriber
    //   0	38	1	paramc	e.b.c
    //   21	13	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	18	21	finally
  }
  
  public void request(long paramLong)
  {
    ((e.b.c)get()).request(paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscribers\BoundedSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */