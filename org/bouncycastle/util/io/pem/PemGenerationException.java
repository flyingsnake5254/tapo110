package org.bouncycastle.util.io.pem;

import java.io.IOException;

public class PemGenerationException
  extends IOException
{
  private Throwable cause;
  
  public PemGenerationException(String paramString)
  {
    super(paramString);
  }
  
  public PemGenerationException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\io\pem\PemGenerationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */