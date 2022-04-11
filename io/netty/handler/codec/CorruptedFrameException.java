package io.netty.handler.codec;

public class CorruptedFrameException
  extends DecoderException
{
  private static final long serialVersionUID = 3918052232492988408L;
  
  public CorruptedFrameException() {}
  
  public CorruptedFrameException(String paramString)
  {
    super(paramString);
  }
  
  public CorruptedFrameException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public CorruptedFrameException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\CorruptedFrameException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */