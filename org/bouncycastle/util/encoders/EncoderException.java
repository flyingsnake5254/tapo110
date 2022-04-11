package org.bouncycastle.util.encoders;

public class EncoderException
  extends IllegalStateException
{
  private Throwable cause;
  
  EncoderException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\encoders\EncoderException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */