package org.bouncycastle.eac;

import java.io.IOException;

public class EACIOException
  extends IOException
{
  private Throwable cause;
  
  public EACIOException(String paramString)
  {
    super(paramString);
  }
  
  public EACIOException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\eac\EACIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */