package io.netty.handler.codec.compression;

import io.netty.handler.codec.DecoderException;

public class DecompressionException
  extends DecoderException
{
  private static final long serialVersionUID = 3546272712208105199L;
  
  public DecompressionException() {}
  
  public DecompressionException(String paramString)
  {
    super(paramString);
  }
  
  public DecompressionException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public DecompressionException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\DecompressionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */