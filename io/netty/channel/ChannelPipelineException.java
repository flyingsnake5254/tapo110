package io.netty.channel;

public class ChannelPipelineException
  extends ChannelException
{
  private static final long serialVersionUID = 3379174210419885980L;
  
  public ChannelPipelineException() {}
  
  public ChannelPipelineException(String paramString)
  {
    super(paramString);
  }
  
  public ChannelPipelineException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public ChannelPipelineException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelPipelineException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */