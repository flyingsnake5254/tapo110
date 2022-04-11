package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.g0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

public final class BiConsumerSingleObserver<T>
  extends AtomicReference<c>
  implements z<T>, c
{
  private static final long serialVersionUID = 4943102778943297569L;
  final b<? super T, ? super Throwable> onCallback;
  
  public BiConsumerSingleObserver(b<? super T, ? super Throwable> paramb)
  {
    this.onCallback = paramb;
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
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
    //   1: getstatic 42	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
    //   4: invokevirtual 48	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   7: aload_0
    //   8: getfield 23	io/reactivex/internal/observers/BiConsumerSingleObserver:onCallback	Lio/reactivex/g0/b;
    //   11: aconst_null
    //   12: aload_1
    //   13: invokeinterface 54 3 0
    //   18: goto +30 -> 48
    //   21: astore_2
    //   22: aload_2
    //   23: invokestatic 59	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   26: new 61	io/reactivex/exceptions/CompositeException
    //   29: dup
    //   30: iconst_2
    //   31: anewarray 63	java/lang/Throwable
    //   34: dup
    //   35: iconst_0
    //   36: aload_1
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: aload_2
    //   41: aastore
    //   42: invokespecial 66	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
    //   45: invokestatic 71	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   48: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	BiConsumerSingleObserver
    //   0	49	1	paramThrowable	Throwable
    //   21	20	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	18	21	finally
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
    //   1: getstatic 42	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
    //   4: invokevirtual 48	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   7: aload_0
    //   8: getfield 23	io/reactivex/internal/observers/BiConsumerSingleObserver:onCallback	Lio/reactivex/g0/b;
    //   11: aload_1
    //   12: aconst_null
    //   13: invokeinterface 54 3 0
    //   18: goto +12 -> 30
    //   21: astore_1
    //   22: aload_1
    //   23: invokestatic 59	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   26: aload_1
    //   27: invokestatic 71	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   30: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	BiConsumerSingleObserver
    //   0	31	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   0	18	21	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\BiConsumerSingleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */