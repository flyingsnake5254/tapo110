package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.h0.b.d;
import io.reactivex.h0.b.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.j;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

public final class InnerQueuedObserver<T>
  extends AtomicReference<c>
  implements v<T>, c
{
  private static final long serialVersionUID = -5417183359794346637L;
  volatile boolean done;
  int fusionMode;
  final e<T> parent;
  final int prefetch;
  i<T> queue;
  
  public InnerQueuedObserver(e<T> parame, int paramInt)
  {
    this.parent = parame;
    this.prefetch = paramInt;
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
  }
  
  public int fusionMode()
  {
    return this.fusionMode;
  }
  
  public boolean isDisposed()
  {
    return DisposableHelper.isDisposed((c)get());
  }
  
  public boolean isDone()
  {
    return this.done;
  }
  
  public void onComplete()
  {
    this.parent.c(this);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.parent.b(this, paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (this.fusionMode == 0) {
      this.parent.d(this, paramT);
    } else {
      this.parent.a();
    }
  }
  
  public void onSubscribe(c paramc)
  {
    if (DisposableHelper.setOnce(this, paramc))
    {
      if ((paramc instanceof d))
      {
        paramc = (d)paramc;
        int i = paramc.requestFusion(3);
        if (i == 1)
        {
          this.fusionMode = i;
          this.queue = paramc;
          this.done = true;
          this.parent.c(this);
          return;
        }
        if (i == 2)
        {
          this.fusionMode = i;
          this.queue = paramc;
          return;
        }
      }
      this.queue = j.b(-this.prefetch);
    }
  }
  
  public i<T> queue()
  {
    return this.queue;
  }
  
  public void setDone()
  {
    this.done = true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\InnerQueuedObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */