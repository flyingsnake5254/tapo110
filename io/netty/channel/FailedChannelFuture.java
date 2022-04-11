package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

final class FailedChannelFuture
  extends CompleteChannelFuture
{
  private final Throwable cause;
  
  FailedChannelFuture(Channel paramChannel, EventExecutor paramEventExecutor, Throwable paramThrowable)
  {
    super(paramChannel, paramEventExecutor);
    this.cause = ((Throwable)ObjectUtil.checkNotNull(paramThrowable, "cause"));
  }
  
  public Throwable cause()
  {
    return this.cause;
  }
  
  public boolean isSuccess()
  {
    return false;
  }
  
  public ChannelFuture sync()
  {
    PlatformDependent.throwException(this.cause);
    return this;
  }
  
  public ChannelFuture syncUninterruptibly()
  {
    PlatformDependent.throwException(this.cause);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\FailedChannelFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */