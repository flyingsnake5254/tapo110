package io.netty.handler.codec.compression;

import io.netty.handler.codec.EncoderException;

public class CompressionException
  extends EncoderException
{
  private static final long serialVersionUID = 5603413481274811897L;
  
  public CompressionException() {}
  
  public CompressionException(String paramString)
  {
    super(paramString);
  }
  
  public CompressionException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public CompressionException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\CompressionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */