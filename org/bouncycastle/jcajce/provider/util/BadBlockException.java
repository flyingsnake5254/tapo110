package org.bouncycastle.jcajce.provider.util;

import javax.crypto.BadPaddingException;

public class BadBlockException
  extends BadPaddingException
{
  private final Throwable cause;
  
  public BadBlockException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\util\BadBlockException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */