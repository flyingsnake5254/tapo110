package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.h0.a.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

public final class ConsumerSingleObserver<T>
  extends AtomicReference<c>
  implements z<T>, c
{
  private static final long serialVersionUID = -7012088219455310787L;
  final g<? super Throwable> onError;
  final g<? super T> onSuccess;
  
  public ConsumerSingleObserver(g<? super T> paramg, g<? super Throwable> paramg1)
  {
    this.onSuccess = paramg;
    this.onError = paramg1;
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
  }
  
  public boolean hasCustomOnError()
  {
    boolean bool;
    if (this.onError != a.f) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isDisposed()
  {
    boolean bool;
    if (get() == DisposableHelper.DISPOSED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public void onError(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 52	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
    //   4: invokevirtual 57	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   7: aload_0
    //   8: getfield 27	io/reactivex/internal/observers/ConsumerSingleObserver:onError	Lio/reactivex/g0/g;
    //   11: aload_1
    //   12: invokeinterface 62 2 0
    //   17: goto +30 -> 47
    //   20: astore_2
    //   21: aload_2
    //   22: invokestatic 67	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   25: new 69	io/reactivex/exceptions/CompositeException
    //   28: dup
    //   29: iconst_2
    //   30: anewarray 71	java/lang/Throwable
    //   33: dup
    //   34: iconst_0
    //   35: aload_1
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: aload_2
    //   40: aastore
    //   41: invokespecial 74	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
    //   44: invokestatic 79	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   47: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	ConsumerSingleObserver
    //   0	48	1	paramThrowable	Throwable
    //   20	20	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	17	20	finally
  }
  
  public void onSubscribe(c paramc)
  {
    DisposableHelper.setOnce(this, paramc);
  }
  
  /* Error */
  public void onSuccess(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 52	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
    //   4: invokevirtual 57	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   7: aload_0
    //   8: getfield 25	io/reactivex/internal/observers/ConsumerSingleObserver:onSuccess	Lio/reactivex/g0/g;
    //   11: aload_1
    //   12: invokeinterface 62 2 0
    //   17: goto +12 -> 29
    //   20: astore_1
    //   21: aload_1
    //   22: invokestatic 67	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   25: aload_1
    //   26: invokestatic 79	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   29: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	ConsumerSingleObserver
    //   0	30	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   7	17	20	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\ConsumerSingleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */