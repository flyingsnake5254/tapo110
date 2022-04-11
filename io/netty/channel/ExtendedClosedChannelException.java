package io.netty.channel;

import java.nio.channels.ClosedChannelException;

final class ExtendedClosedChannelException
  extends ClosedChannelException
{
  ExtendedClosedChannelException(Throwable paramThrowable)
  {
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
  }
  
  public Throwable fillInStackTrace()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ExtendedClosedChannelException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */