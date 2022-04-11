package org.bouncycastle.crypto;

public class CryptoException
  extends Exception
{
  private Throwable cause;
  
  public CryptoException() {}
  
  public CryptoException(String paramString)
  {
    super(paramString);
  }
  
  public CryptoException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\CryptoException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */