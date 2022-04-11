package io.netty.handler.codec;

public class TooLongFrameException
  extends DecoderException
{
  private static final long serialVersionUID = -1995801950698951640L;
  
  public TooLongFrameException() {}
  
  public TooLongFrameException(String paramString)
  {
    super(paramString);
  }
  
  public TooLongFrameException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public TooLongFrameException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\TooLongFrameException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */