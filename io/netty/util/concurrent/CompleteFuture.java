package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

public abstract class CompleteFuture<V>
  extends AbstractFuture<V>
{
  private final EventExecutor executor;
  
  protected CompleteFuture(EventExecutor paramEventExecutor)
  {
    this.executor = paramEventExecutor;
  }
  
  public Future<V> addListener(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener)
  {
    DefaultPromise.notifyListener(executor(), this, (GenericFutureListener)ObjectUtil.checkNotNull(paramGenericFutureListener, "listener"));
    return this;
  }
  
  public Future<V> addListeners(GenericFutureListener<? extends Future<? super V>>... paramVarArgs)
  {
    for (GenericFutureListener<? extends Future<? super V>> localGenericFutureListener : (GenericFutureListener[])ObjectUtil.checkNotNull(paramVarArgs, "listeners"))
    {
      if (localGenericFutureListener == null) {
        break;
      }
      DefaultPromise.notifyListener(executor(), this, localGenericFutureListener);
    }
    return this;
  }
  
  public Future<V> await()
    throws InterruptedException
  {
    if (!Thread.interrupted()) {
      return this;
    }
    throw new InterruptedException();
  }
  
  public boolean await(long paramLong)
    throws InterruptedException
  {
    if (!Thread.interrupted()) {
      return true;
    }
    throw new InterruptedException();
  }
  
  public boolean await(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (!Thread.interrupted()) {
      return true;
    }
    throw new InterruptedException();
  }
  
  public Future<V> awaitUninterruptibly()
  {
    return this;
  }
  
  public boolean awaitUninterruptibly(long paramLong)
  {
    return true;
  }
  
  public boolean awaitUninterruptibly(long paramLong, TimeUnit paramTimeUnit)
  {
    return true;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  protected EventExecutor executor()
  {
    return this.executor;
  }
  
  public boolean isCancellable()
  {
    return false;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return true;
  }
  
  public Future<V> removeListener(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener)
  {
    return this;
  }
  
  public Future<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... paramVarArgs)
  {
    return this;
  }
  
  public Future<V> sync()
    throws InterruptedException
  {
    return this;
  }
  
  public Future<V> syncUninterruptibly()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\CompleteFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */