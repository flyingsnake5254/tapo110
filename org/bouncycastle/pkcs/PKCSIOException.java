package org.bouncycastle.pkcs;

import java.io.IOException;

public class PKCSIOException
  extends IOException
{
  private Throwable cause;
  
  public PKCSIOException(String paramString)
  {
    super(paramString);
  }
  
  public PKCSIOException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pkcs\PKCSIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */