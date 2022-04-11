package io.netty.handler.ssl;

import java.io.File;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;

public final class OpenSslClientContext
  extends OpenSslContext
{
  private final OpenSslSessionContext sessionContext;
  
  @Deprecated
  public OpenSslClientContext()
    throws SSLException
  {
    this(null, null, null, null, null, null, null, IdentityCipherSuiteFilter.INSTANCE, null, 0L, 0L);
  }
  
  @Deprecated
  public OpenSslClientContext(File paramFile)
    throws SSLException
  {
    this(paramFile, null);
  }
  
  @Deprecated
  public OpenSslClientContext(File paramFile, TrustManagerFactory paramTrustManagerFactory)
    throws SSLException
  {
    this(paramFile, paramTrustManagerFactory, null, null, null, null, null, IdentityCipherSuiteFilter.INSTANCE, null, 0L, 0L);
  }
  
  @Deprecated
  public OpenSslClientContext(File paramFile1, TrustManagerFactory paramTrustManagerFactory, File paramFile2, File paramFile3, String paramString, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(SslContext.toX509CertificatesInternal(paramFile1), paramTrustManagerFactory, SslContext.toX509CertificatesInternal(paramFile2), SslContext.toPrivateKeyInternal(paramFile3, paramString), paramString, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, null, paramLong1, paramLong2, false, KeyStore.getDefaultType());
  }
  
  @Deprecated
  public OpenSslClientContext(File paramFile, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(paramFile, paramTrustManagerFactory, null, null, null, null, paramIterable, IdentityCipherSuiteFilter.INSTANCE, paramApplicationProtocolConfig, paramLong1, paramLong2);
  }
  
  @Deprecated
  public OpenSslClientContext(File paramFile, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(paramFile, paramTrustManagerFactory, null, null, null, null, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2);
  }
  
  @Deprecated
  public OpenSslClientContext(TrustManagerFactory paramTrustManagerFactory)
    throws SSLException
  {
    this(null, paramTrustManagerFactory);
  }
  
  OpenSslClientContext(X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, String[] paramArrayOfString, long paramLong1, long paramLong2, boolean paramBoolean, String paramString2)
    throws SSLException
  {
    super(paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2, 0, paramArrayOfX509Certificate2, ClientAuth.NONE, paramArrayOfString, false, paramBoolean);
    try
    {
      OpenSslKeyMaterialProvider.validateKeyMaterialSupported(paramArrayOfX509Certificate2, paramPrivateKey, paramString1);
      this.sessionContext = ReferenceCountedOpenSslClientContext.newSessionContext(this, this.ctx, this.engineMap, paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramString2);
      return;
    }
    finally
    {
      release();
    }
  }
  
  public OpenSslSessionContext sessionContext()
  {
    return this.sessionContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslClientContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */