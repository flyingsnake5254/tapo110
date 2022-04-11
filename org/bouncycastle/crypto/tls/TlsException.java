package org.bouncycastle.crypto.tls;

import java.io.IOException;

public class TlsException
  extends IOException
{
  protected Throwable cause;
  
  public TlsException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\TlsException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */