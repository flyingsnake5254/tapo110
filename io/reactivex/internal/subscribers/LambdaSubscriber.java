package io.reactivex.internal.subscribers;

import io.reactivex.g0.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicReference;

public final class LambdaSubscriber<T>
  extends AtomicReference<e.b.c>
  implements k<T>, e.b.c, io.reactivex.e0.c
{
  private static final long serialVersionUID = -7251123623727029452L;
  final io.reactivex.g0.a onComplete;
  final g<? super Throwable> onError;
  final g<? super T> onNext;
  final g<? super e.b.c> onSubscribe;
  
  public LambdaSubscriber(g<? super T> paramg, g<? super Throwable> paramg1, io.reactivex.g0.a parama, g<? super e.b.c> paramg2)
  {
    this.onNext = paramg;
    this.onError = paramg1;
    this.onComplete = parama;
    this.onSubscribe = paramg2;
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
    //   1: invokevirtual 61	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   4: astore_1
    //   5: getstatic 65	io/reactivex/internal/subscriptions/SubscriptionHelper:CANCELLED	Lio/reactivex/internal/subscriptions/SubscriptionHelper;
    //   8: astore_2
    //   9: aload_1
    //   10: aload_2
    //   11: if_acmpeq +29 -> 40
    //   14: aload_0
    //   15: aload_2
    //   16: invokevirtual 69	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   19: aload_0
    //   20: getfield 35	io/reactivex/internal/subscribers/LambdaSubscriber:onComplete	Lio/reactivex/g0/a;
    //   23: invokeinterface 74 1 0
    //   28: goto +12 -> 40
    //   31: astore_1
    //   32: aload_1
    //   33: invokestatic 80	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   36: aload_1
    //   37: invokestatic 85	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   40: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	LambdaSubscriber
    //   4	6	1	localObject	Object
    //   31	6	1	localThrowable	Throwable
    //   8	8	2	localSubscriptionHelper	SubscriptionHelper
    // Exception table:
    //   from	to	target	type
    //   19	28	31	finally
  }
  
  /* Error */
  public void onError(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 61	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   4: astore_2
    //   5: getstatic 65	io/reactivex/internal/subscriptions/SubscriptionHelper:CANCELLED	Lio/reactivex/internal/subscriptions/SubscriptionHelper;
    //   8: astore_3
    //   9: aload_2
    //   10: aload_3
    //   11: if_acmpeq +51 -> 62
    //   14: aload_0
    //   15: aload_3
    //   16: invokevirtual 69	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   19: aload_0
    //   20: getfield 33	io/reactivex/internal/subscribers/LambdaSubscriber:onError	Lio/reactivex/g0/g;
    //   23: aload_1
    //   24: invokeinterface 90 2 0
    //   29: goto +37 -> 66
    //   32: astore_2
    //   33: aload_2
    //   34: invokestatic 80	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   37: new 92	io/reactivex/exceptions/CompositeException
    //   40: dup
    //   41: iconst_2
    //   42: anewarray 94	java/lang/Throwable
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload_2
    //   52: aastore
    //   53: invokespecial 97	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
    //   56: invokestatic 85	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   59: goto +7 -> 66
    //   62: aload_1
    //   63: invokestatic 85	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   66: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	LambdaSubscriber
    //   0	67	1	paramThrowable	Throwable
    //   4	6	2	localObject	Object
    //   32	20	2	localThrowable	Throwable
    //   8	8	3	localSubscriptionHelper	SubscriptionHelper
    // Exception table:
    //   from	to	target	type
    //   19	29	32	finally
  }
  
  /* Error */
  public void onNext(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 99	io/reactivex/internal/subscribers/LambdaSubscriber:isDisposed	()Z
    //   4: ifne +38 -> 42
    //   7: aload_0
    //   8: getfield 31	io/reactivex/internal/subscribers/LambdaSubscriber:onNext	Lio/reactivex/g0/g;
    //   11: aload_1
    //   12: invokeinterface 90 2 0
    //   17: goto +25 -> 42
    //   20: astore_1
    //   21: aload_1
    //   22: invokestatic 80	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   25: aload_0
    //   26: invokevirtual 61	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   29: checkcast 9	e/b/c
    //   32: invokeinterface 100 1 0
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 102	io/reactivex/internal/subscribers/LambdaSubscriber:onError	(Ljava/lang/Throwable;)V
    //   42: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	LambdaSubscriber
    //   0	43	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   7	17	20	finally
  }
  
  /* Error */
  public void onSubscribe(e.b.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 108	io/reactivex/internal/subscriptions/SubscriptionHelper:setOnce	(Ljava/util/concurrent/atomic/AtomicReference;Le/b/c;)Z
    //   5: ifeq +32 -> 37
    //   8: aload_0
    //   9: getfield 37	io/reactivex/internal/subscribers/LambdaSubscriber:onSubscribe	Lio/reactivex/g0/g;
    //   12: aload_0
    //   13: invokeinterface 90 2 0
    //   18: goto +19 -> 37
    //   21: astore_2
    //   22: aload_2
    //   23: invokestatic 80	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   26: aload_1
    //   27: invokeinterface 100 1 0
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 102	io/reactivex/internal/subscribers/LambdaSubscriber:onError	(Ljava/lang/Throwable;)V
    //   37: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	LambdaSubscriber
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscribers\LambdaSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */