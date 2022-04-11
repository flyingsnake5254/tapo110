package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

public final class FailedFuture<V>
  extends CompleteFuture<V>
{
  private final Throwable cause;
  
  public FailedFuture(EventExecutor paramEventExecutor, Throwable paramThrowable)
  {
    super(paramEventExecutor);
    this.cause = ((Throwable)ObjectUtil.checkNotNull(paramThrowable, "cause"));
  }
  
  public Throwable cause()
  {
    return this.cause;
  }
  
  public V getNow()
  {
    return null;
  }
  
  public boolean isSuccess()
  {
    return false;
  }
  
  public Future<V> sync()
  {
    PlatformDependent.throwException(this.cause);
    return this;
  }
  
  public Future<V> syncUninterruptibly()
  {
    PlatformDependent.throwException(this.cause);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\FailedFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */