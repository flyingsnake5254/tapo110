package io.netty.handler.codec;

public class CodecException
  extends RuntimeException
{
  private static final long serialVersionUID = -1464830400709348473L;
  
  public CodecException() {}
  
  public CodecException(String paramString)
  {
    super(paramString);
  }
  
  public CodecException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public CodecException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\CodecException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */