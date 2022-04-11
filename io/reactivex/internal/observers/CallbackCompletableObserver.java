package io.reactivex.internal.observers;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.g0.g;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CallbackCompletableObserver
  extends AtomicReference<io.reactivex.e0.c>
  implements io.reactivex.c, io.reactivex.e0.c, g<Throwable>
{
  private static final long serialVersionUID = -4361286194466301354L;
  final io.reactivex.g0.a onComplete;
  final g<? super Throwable> onError;
  
  public CallbackCompletableObserver(io.reactivex.g0.a parama)
  {
    this.onError = this;
    this.onComplete = parama;
  }
  
  public CallbackCompletableObserver(g<? super Throwable> paramg, io.reactivex.g0.a parama)
  {
    this.onError = paramg;
    this.onComplete = parama;
  }
  
  public void accept(Throwable paramThrowable)
  {
    io.reactivex.j0.a.r(new OnErrorNotImplementedException(paramThrowable));
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
  }
  
  public boolean hasCustomOnError()
  {
    boolean bool;
    if (this.onError != this) {
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
  public void onComplete()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	io/reactivex/internal/observers/CallbackCompletableObserver:onComplete	Lio/reactivex/g0/a;
    //   4: invokeinterface 74 1 0
    //   9: goto +12 -> 21
    //   12: astore_1
    //   13: aload_1
    //   14: invokestatic 79	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   17: aload_1
    //   18: invokestatic 52	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   21: aload_0
    //   22: getstatic 69	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
    //   25: invokevirtual 82	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   28: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	CallbackCompletableObserver
    //   12	6	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	9	12	finally
  }
  
  /* Error */
  public void onError(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	io/reactivex/internal/observers/CallbackCompletableObserver:onError	Lio/reactivex/g0/g;
    //   4: aload_1
    //   5: invokeinterface 84 2 0
    //   10: goto +12 -> 22
    //   13: astore_1
    //   14: aload_1
    //   15: invokestatic 79	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   18: aload_1
    //   19: invokestatic 52	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   22: aload_0
    //   23: getstatic 69	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
    //   26: invokevirtual 82	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   29: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	CallbackCompletableObserver
    //   0	30	1	paramThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	10	13	finally
  }
  
  public void onSubscribe(io.reactivex.e0.c paramc)
  {
    DisposableHelper.setOnce(this, paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\CallbackCompletableObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */