package io.netty.handler.timeout;

import io.netty.channel.ChannelException;

public class TimeoutException
  extends ChannelException
{
  private static final long serialVersionUID = 4673641882869672533L;
  
  TimeoutException() {}
  
  TimeoutException(boolean paramBoolean)
  {
    super(null, null, paramBoolean);
  }
  
  public Throwable fillInStackTrace()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\timeout\TimeoutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */