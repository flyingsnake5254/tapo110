package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

@SuppressJava6Requirement(reason="Usage guarded by java version check")
final class X509TrustManagerWrapper
  extends X509ExtendedTrustManager
{
  private final X509TrustManager delegate;
  
  X509TrustManagerWrapper(X509TrustManager paramX509TrustManager)
  {
    this.delegate = ((X509TrustManager)ObjectUtil.checkNotNull(paramX509TrustManager, "delegate"));
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    this.delegate.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString, Socket paramSocket)
    throws CertificateException
  {
    this.delegate.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString, SSLEngine paramSSLEngine)
    throws CertificateException
  {
    this.delegate.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    this.delegate.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString, Socket paramSocket)
    throws CertificateException
  {
    this.delegate.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString, SSLEngine paramSSLEngine)
    throws CertificateException
  {
    this.delegate.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.delegate.getAcceptedIssuers();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\util\X509TrustManagerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */