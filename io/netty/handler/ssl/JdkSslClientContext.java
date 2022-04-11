package io.netty.handler.ssl;

import java.io.File;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;

@Deprecated
public final class JdkSslClientContext
  extends JdkSslContext
{
  @Deprecated
  public JdkSslClientContext()
    throws SSLException
  {
    this(null, null);
  }
  
  @Deprecated
  public JdkSslClientContext(File paramFile)
    throws SSLException
  {
    this(paramFile, null);
  }
  
  @Deprecated
  public JdkSslClientContext(File paramFile, TrustManagerFactory paramTrustManagerFactory)
    throws SSLException
  {
    this(paramFile, paramTrustManagerFactory, null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0L, 0L);
  }
  
  @Deprecated
  public JdkSslClientContext(File paramFile1, TrustManagerFactory paramTrustManagerFactory, File paramFile2, File paramFile3, String paramString, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(paramFile1, paramTrustManagerFactory, paramFile2, paramFile3, paramString, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, JdkSslContext.toNegotiator(paramApplicationProtocolConfig, false), paramLong1, paramLong2);
  }
  
  @Deprecated
  public JdkSslClientContext(File paramFile1, TrustManagerFactory paramTrustManagerFactory, File paramFile2, File paramFile3, String paramString, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, long paramLong1, long paramLong2)
    throws SSLException
  {
    super(newSSLContext(null, SslContext.toX509CertificatesInternal(paramFile1), paramTrustManagerFactory, SslContext.toX509CertificatesInternal(paramFile2), SslContext.toPrivateKeyInternal(paramFile3, paramString), paramString, paramKeyManagerFactory, paramLong1, paramLong2, KeyStore.getDefaultType()), true, paramIterable, paramCipherSuiteFilter, paramJdkApplicationProtocolNegotiator, ClientAuth.NONE, null, false);
  }
  
  @Deprecated
  public JdkSslClientContext(File paramFile, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(paramFile, paramTrustManagerFactory, paramIterable, paramCipherSuiteFilter, JdkSslContext.toNegotiator(paramApplicationProtocolConfig, false), paramLong1, paramLong2);
  }
  
  @Deprecated
  public JdkSslClientContext(File paramFile, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(null, paramFile, paramTrustManagerFactory, paramIterable, paramCipherSuiteFilter, paramJdkApplicationProtocolNegotiator, paramLong1, paramLong2);
  }
  
  @Deprecated
  public JdkSslClientContext(File paramFile, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable1, Iterable<String> paramIterable2, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(paramFile, paramTrustManagerFactory, paramIterable1, IdentityCipherSuiteFilter.INSTANCE, JdkSslContext.toNegotiator(SslContext.toApplicationProtocolConfig(paramIterable2), false), paramLong1, paramLong2);
  }
  
  JdkSslClientContext(Provider paramProvider, File paramFile, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, long paramLong1, long paramLong2)
    throws SSLException
  {
    super(newSSLContext(paramProvider, SslContext.toX509CertificatesInternal(paramFile), paramTrustManagerFactory, null, null, null, null, paramLong1, paramLong2, KeyStore.getDefaultType()), true, paramIterable, paramCipherSuiteFilter, paramJdkApplicationProtocolNegotiator, ClientAuth.NONE, null, false);
  }
  
  JdkSslClientContext(Provider paramProvider, X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, String[] paramArrayOfString, long paramLong1, long paramLong2, String paramString2)
    throws SSLException
  {
    super(newSSLContext(paramProvider, paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramLong1, paramLong2, paramString2), true, paramIterable, paramCipherSuiteFilter, JdkSslContext.toNegotiator(paramApplicationProtocolConfig, false), ClientAuth.NONE, paramArrayOfString, false);
  }
  
  @Deprecated
  public JdkSslClientContext(TrustManagerFactory paramTrustManagerFactory)
    throws SSLException
  {
    this(null, paramTrustManagerFactory);
  }
  
  private static SSLContext newSSLContext(Provider paramProvider, X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, long paramLong1, long paramLong2, String paramString2)
    throws SSLException
  {
    TrustManagerFactory localTrustManagerFactory = paramTrustManagerFactory;
    if (paramArrayOfX509Certificate1 != null) {
      try
      {
        localTrustManagerFactory = SslContext.buildTrustManagerFactory(paramArrayOfX509Certificate1, paramTrustManagerFactory, paramString2);
      }
      catch (Exception paramProvider)
      {
        break label151;
      }
    }
    paramArrayOfX509Certificate1 = paramKeyManagerFactory;
    if (paramArrayOfX509Certificate2 != null) {
      paramArrayOfX509Certificate1 = SslContext.buildKeyManagerFactory(paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramString2);
    }
    if (paramProvider == null) {
      paramProvider = SSLContext.getInstance("TLS");
    } else {
      paramProvider = SSLContext.getInstance("TLS", paramProvider);
    }
    if (paramArrayOfX509Certificate1 == null) {
      paramArrayOfX509Certificate1 = null;
    } else {
      paramArrayOfX509Certificate1 = paramArrayOfX509Certificate1.getKeyManagers();
    }
    if (localTrustManagerFactory == null) {
      paramTrustManagerFactory = null;
    } else {
      paramTrustManagerFactory = localTrustManagerFactory.getTrustManagers();
    }
    paramProvider.init(paramArrayOfX509Certificate1, paramTrustManagerFactory, null);
    paramArrayOfX509Certificate1 = paramProvider.getClientSessionContext();
    if (paramLong1 > 0L) {
      paramArrayOfX509Certificate1.setSessionCacheSize((int)Math.min(paramLong1, 2147483647L));
    }
    if (paramLong2 > 0L) {
      paramArrayOfX509Certificate1.setSessionTimeout((int)Math.min(paramLong2, 2147483647L));
    }
    return paramProvider;
    label151:
    if ((paramProvider instanceof SSLException)) {
      throw ((SSLException)paramProvider);
    }
    throw new SSLException("failed to initialize the client-side SSL context", paramProvider);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JdkSslClientContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */