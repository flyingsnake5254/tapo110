package io.netty.handler.ssl;

import java.io.File;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;

public final class OpenSslServerContext
  extends OpenSslContext
{
  private final OpenSslServerSessionContext sessionContext;
  
  @Deprecated
  public OpenSslServerContext(File paramFile1, File paramFile2)
    throws SSLException
  {
    this(paramFile1, paramFile2, null);
  }
  
  @Deprecated
  public OpenSslServerContext(File paramFile1, File paramFile2, String paramString)
    throws SSLException
  {
    this(paramFile1, paramFile2, paramString, null, IdentityCipherSuiteFilter.INSTANCE, ApplicationProtocolConfig.DISABLED, 0L, 0L);
  }
  
  @Deprecated
  public OpenSslServerContext(File paramFile1, File paramFile2, String paramString, Iterable<String> paramIterable, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(paramFile1, paramFile2, paramString, paramIterable, IdentityCipherSuiteFilter.INSTANCE, paramApplicationProtocolConfig, paramLong1, paramLong2);
  }
  
  @Deprecated
  public OpenSslServerContext(File paramFile1, File paramFile2, String paramString, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(null, null, paramFile1, paramFile2, paramString, null, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2);
  }
  
  @Deprecated
  public OpenSslServerContext(File paramFile1, File paramFile2, String paramString, Iterable<String> paramIterable1, Iterable<String> paramIterable2, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(paramFile1, paramFile2, paramString, paramIterable1, SslContext.toApplicationProtocolConfig(paramIterable2), paramLong1, paramLong2);
  }
  
  @Deprecated
  public OpenSslServerContext(File paramFile1, File paramFile2, String paramString, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(paramFile1, paramFile2, paramString, paramTrustManagerFactory, paramIterable, ReferenceCountedOpenSslContext.toNegotiator(paramApplicationProtocolConfig), paramLong1, paramLong2);
  }
  
  @Deprecated
  public OpenSslServerContext(File paramFile1, File paramFile2, String paramString, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(null, paramTrustManagerFactory, paramFile1, paramFile2, paramString, null, paramIterable, paramCipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(paramApplicationProtocolConfig), paramLong1, paramLong2);
  }
  
  @Deprecated
  public OpenSslServerContext(File paramFile1, File paramFile2, String paramString, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, OpenSslApplicationProtocolNegotiator paramOpenSslApplicationProtocolNegotiator, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(null, paramTrustManagerFactory, paramFile1, paramFile2, paramString, null, paramIterable, paramCipherSuiteFilter, paramOpenSslApplicationProtocolNegotiator, paramLong1, paramLong2);
  }
  
  @Deprecated
  public OpenSslServerContext(File paramFile1, File paramFile2, String paramString, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable, OpenSslApplicationProtocolNegotiator paramOpenSslApplicationProtocolNegotiator, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(null, paramTrustManagerFactory, paramFile1, paramFile2, paramString, null, paramIterable, null, paramOpenSslApplicationProtocolNegotiator, paramLong1, paramLong2);
  }
  
  @Deprecated
  public OpenSslServerContext(File paramFile1, TrustManagerFactory paramTrustManagerFactory, File paramFile2, File paramFile3, String paramString, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(paramFile1, paramTrustManagerFactory, paramFile2, paramFile3, paramString, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(paramApplicationProtocolConfig), paramLong1, paramLong2);
  }
  
  @Deprecated
  public OpenSslServerContext(File paramFile1, TrustManagerFactory paramTrustManagerFactory, File paramFile2, File paramFile3, String paramString, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, OpenSslApplicationProtocolNegotiator paramOpenSslApplicationProtocolNegotiator, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(SslContext.toX509CertificatesInternal(paramFile1), paramTrustManagerFactory, SslContext.toX509CertificatesInternal(paramFile2), SslContext.toPrivateKeyInternal(paramFile3, paramString), paramString, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, paramOpenSslApplicationProtocolNegotiator, paramLong1, paramLong2, ClientAuth.NONE, null, false, false, KeyStore.getDefaultType());
  }
  
  OpenSslServerContext(X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2, ClientAuth paramClientAuth, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
    throws SSLException
  {
    this(paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(paramApplicationProtocolConfig), paramLong1, paramLong2, paramClientAuth, paramArrayOfString, paramBoolean1, paramBoolean2, paramString2);
  }
  
  private OpenSslServerContext(X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, OpenSslApplicationProtocolNegotiator paramOpenSslApplicationProtocolNegotiator, long paramLong1, long paramLong2, ClientAuth paramClientAuth, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
    throws SSLException
  {
    super(paramIterable, paramCipherSuiteFilter, paramOpenSslApplicationProtocolNegotiator, paramLong1, paramLong2, 1, paramArrayOfX509Certificate2, paramClientAuth, paramArrayOfString, paramBoolean1, paramBoolean2);
    try
    {
      OpenSslKeyMaterialProvider.validateKeyMaterialSupported(paramArrayOfX509Certificate2, paramPrivateKey, paramString1);
      this.sessionContext = ReferenceCountedOpenSslServerContext.newSessionContext(this, this.ctx, this.engineMap, paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramString2);
      return;
    }
    finally
    {
      release();
    }
  }
  
  public OpenSslServerSessionContext sessionContext()
  {
    return this.sessionContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslServerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */