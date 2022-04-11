package org.bouncycastle.pkcs;

public class PKCSException
  extends Exception
{
  private Throwable cause;
  
  public PKCSException(String paramString)
  {
    super(paramString);
  }
  
  public PKCSException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pkcs\PKCSException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */