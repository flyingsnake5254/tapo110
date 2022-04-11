package io.netty.handler.ssl;

import io.netty.internal.tcnative.CertificateVerifier;
import java.security.cert.CertificateException;

public final class OpenSslCertificateException
  extends CertificateException
{
  private static final long serialVersionUID = 5542675253797129798L;
  private final int errorCode;
  
  public OpenSslCertificateException(int paramInt)
  {
    this(null, paramInt);
  }
  
  public OpenSslCertificateException(String paramString, int paramInt)
  {
    super(paramString);
    this.errorCode = checkErrorCode(paramInt);
  }
  
  public OpenSslCertificateException(String paramString, Throwable paramThrowable, int paramInt)
  {
    super(paramString, paramThrowable);
    this.errorCode = checkErrorCode(paramInt);
  }
  
  public OpenSslCertificateException(Throwable paramThrowable, int paramInt)
  {
    this(null, paramThrowable, paramInt);
  }
  
  private static int checkErrorCode(int paramInt)
  {
    if ((OpenSsl.isAvailable()) && (!CertificateVerifier.isValid(paramInt)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorCode '");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("' invalid, see https://www.openssl.org/docs/man1.0.2/apps/verify.html.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public int errorCode()
  {
    return this.errorCode;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslCertificateException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */