package org.bouncycastle.openssl;

public class EncryptionException
  extends PEMException
{
  private Throwable cause;
  
  public EncryptionException(String paramString)
  {
    super(paramString);
  }
  
  public EncryptionException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\openssl\EncryptionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */