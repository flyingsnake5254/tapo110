package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.spec.InvalidKeySpecException;

public class ExtendedInvalidKeySpecException
  extends InvalidKeySpecException
{
  private Throwable cause;
  
  public ExtendedInvalidKeySpecException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\util\ExtendedInvalidKeySpecException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */