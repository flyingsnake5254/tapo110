package org.bouncycastle.cert.path;

public class CertPathValidationException
  extends Exception
{
  private final Exception cause;
  
  public CertPathValidationException(String paramString)
  {
    this(paramString, null);
  }
  
  public CertPathValidationException(String paramString, Exception paramException)
  {
    super(paramString);
    this.cause = paramException;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\path\CertPathValidationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */