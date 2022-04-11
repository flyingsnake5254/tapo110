package io.netty.channel;

public class EventLoopException
  extends ChannelException
{
  private static final long serialVersionUID = -8969100344583703616L;
  
  public EventLoopException() {}
  
  public EventLoopException(String paramString)
  {
    super(paramString);
  }
  
  public EventLoopException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public EventLoopException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\EventLoopException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */