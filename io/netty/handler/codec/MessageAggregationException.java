package io.netty.handler.codec;

public class MessageAggregationException
  extends IllegalStateException
{
  private static final long serialVersionUID = -1995826182950310255L;
  
  public MessageAggregationException() {}
  
  public MessageAggregationException(String paramString)
  {
    super(paramString);
  }
  
  public MessageAggregationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MessageAggregationException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\MessageAggregationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */