package org.bouncycastle.jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;

public class ExtCertPathValidatorException
  extends CertPathValidatorException
{
  private Throwable cause;
  
  public ExtCertPathValidatorException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public ExtCertPathValidatorException(String paramString, Throwable paramThrowable, CertPath paramCertPath, int paramInt)
  {
    super(paramString, paramThrowable, paramCertPath, paramInt);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\exception\ExtCertPathValidatorException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */