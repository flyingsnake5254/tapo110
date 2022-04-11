package io.reactivex.internal.observers;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j0.a;
import java.util.concurrent.atomic.AtomicReference;

public final class EmptyCompletableObserver
  extends AtomicReference<io.reactivex.e0.c>
  implements io.reactivex.c, io.reactivex.e0.c
{
  private static final long serialVersionUID = -7545121636549663526L;
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
  }
  
  public boolean hasCustomOnError()
  {
    return false;
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
  
  public void onComplete()
  {
    lazySet(DisposableHelper.DISPOSED);
  }
  
  public void onError(Throwable paramThrowable)
  {
    lazySet(DisposableHelper.DISPOSED);
    a.r(new OnErrorNotImplementedException(paramThrowable));
  }
  
  public void onSubscribe(io.reactivex.e0.c paramc)
  {
    DisposableHelper.setOnce(this, paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\EmptyCompletableObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */