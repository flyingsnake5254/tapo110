package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

public final class ObserverResourceWrapper<T>
  extends AtomicReference<c>
  implements v<T>, c
{
  private static final long serialVersionUID = -8612022020200669122L;
  final v<? super T> downstream;
  final AtomicReference<c> upstream = new AtomicReference();
  
  public ObserverResourceWrapper(v<? super T> paramv)
  {
    this.downstream = paramv;
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this.upstream);
    DisposableHelper.dispose(this);
  }
  
  public boolean isDisposed()
  {
    boolean bool;
    if (this.upstream.get() == DisposableHelper.DISPOSED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onComplete()
  {
    dispose();
    this.downstream.onComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    dispose();
    this.downstream.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.downstream.onNext(paramT);
  }
  
  public void onSubscribe(c paramc)
  {
    if (DisposableHelper.setOnce(this.upstream, paramc)) {
      this.downstream.onSubscribe(this);
    }
  }
  
  public void setResource(c paramc)
  {
    DisposableHelper.set(this, paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\ObserverResourceWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */