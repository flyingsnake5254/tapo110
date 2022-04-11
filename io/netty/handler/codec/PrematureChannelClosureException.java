package io.netty.handler.codec;

public class PrematureChannelClosureException
  extends CodecException
{
  private static final long serialVersionUID = 4907642202594703094L;
  
  public PrematureChannelClosureException() {}
  
  public PrematureChannelClosureException(String paramString)
  {
    super(paramString);
  }
  
  public PrematureChannelClosureException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public PrematureChannelClosureException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\PrematureChannelClosureException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */