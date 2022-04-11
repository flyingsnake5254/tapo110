package io.netty.channel.socket;

import java.io.IOException;

public final class ChannelOutputShutdownException
  extends IOException
{
  private static final long serialVersionUID = 6712549938359321378L;
  
  public ChannelOutputShutdownException(String paramString)
  {
    super(paramString);
  }
  
  public ChannelOutputShutdownException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\ChannelOutputShutdownException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */