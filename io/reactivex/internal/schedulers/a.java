package io.reactivex.internal.schedulers;

import io.reactivex.e0.c;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class a
  extends AtomicReference<Future<?>>
  implements c
{
  protected static final FutureTask<Void> DISPOSED;
  protected static final FutureTask<Void> FINISHED;
  private static final long serialVersionUID = 1811839108042568751L;
  protected final Runnable runnable;
  protected Thread runner;
  
  static
  {
    Runnable localRunnable = io.reactivex.h0.a.a.b;
    FINISHED = new FutureTask(localRunnable, null);
    DISPOSED = new FutureTask(localRunnable, null);
  }
  
  a(Runnable paramRunnable)
  {
    this.runnable = paramRunnable;
  }
  
  public final void dispose()
  {
    Future localFuture = (Future)get();
    if (localFuture != FINISHED)
    {
      FutureTask localFutureTask = DISPOSED;
      if ((localFuture != localFutureTask) && (compareAndSet(localFuture, localFutureTask)) && (localFuture != null))
      {
        boolean bool;
        if (this.runner != Thread.currentThread()) {
          bool = true;
        } else {
          bool = false;
        }
        localFuture.cancel(bool);
      }
    }
  }
  
  public Runnable getWrappedRunnable()
  {
    return this.runnable;
  }
  
  public final boolean isDisposed()
  {
    Future localFuture = (Future)get();
    boolean bool;
    if ((localFuture != FINISHED) && (localFuture != DISPOSED)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public final void setFuture(Future<?> paramFuture)
  {
    Future localFuture;
    do
    {
      localFuture = (Future)get();
      if (localFuture == FINISHED) {
        break;
      }
      if (localFuture == DISPOSED)
      {
        boolean bool;
        if (this.runner != Thread.currentThread()) {
          bool = true;
        } else {
          bool = false;
        }
        paramFuture.cancel(bool);
        break;
      }
    } while (!compareAndSet(localFuture, paramFuture));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */