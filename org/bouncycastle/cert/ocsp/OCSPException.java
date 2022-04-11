package org.bouncycastle.cert.ocsp;

public class OCSPException
  extends Exception
{
  private Throwable cause;
  
  public OCSPException(String paramString)
  {
    super(paramString);
  }
  
  public OCSPException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\ocsp\OCSPException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */