package org.bouncycastle.jce.exception;

import java.security.cert.CertificateEncodingException;

public class ExtCertificateEncodingException
  extends CertificateEncodingException
{
  private Throwable cause;
  
  public ExtCertificateEncodingException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\exception\ExtCertificateEncodingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */