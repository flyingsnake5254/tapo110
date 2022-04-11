package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;

final class SucceededChannelFuture
  extends CompleteChannelFuture
{
  SucceededChannelFuture(Channel paramChannel, EventExecutor paramEventExecutor)
  {
    super(paramChannel, paramEventExecutor);
  }
  
  public Throwable cause()
  {
    return null;
  }
  
  public boolean isSuccess()
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\SucceededChannelFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */