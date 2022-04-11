package io.netty.handler.ssl;

import java.io.File;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.Objects;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;

@Deprecated
public final class JdkSslServerContext
  extends JdkSslContext
{
  @Deprecated
  public JdkSslServerContext(File paramFile1, File paramFile2)
    throws SSLException
  {
    this(null, paramFile1, paramFile2, null, null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0L, 0L, null);
  }
  
  @Deprecated
  public JdkSslServerContext(File paramFile1, File paramFile2, String paramString)
    throws SSLException
  {
    this(paramFile1, paramFile2, paramString, null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0L, 0L);
  }
  
  @Deprecated
  public JdkSslServerContext(File paramFile1, File paramFile2, String paramString, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(null, paramFile1, paramFile2, paramString, paramIterable, paramCipherSuiteFilter, JdkSslContext.toNegotiator(paramApplicationProtocolConfig, true), paramLong1, paramLong2, KeyStore.getDefaultType());
  }
  
  @Deprecated
  public JdkSslServerContext(File paramFile1, File paramFile2, String paramString, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(null, paramFile1, paramFile2, paramString, paramIterable, paramCipherSuiteFilter, paramJdkApplicationProtocolNegotiator, paramLong1, paramLong2, KeyStore.getDefaultType());
  }
  
  @Deprecated
  public JdkSslServerContext(File paramFile1, File paramFile2, String paramString, Iterable<String> paramIterable1, Iterable<String> paramIterable2, long paramLong1, long paramLong2)
    throws SSLException
  {
    this(null, paramFile1, paramFile2, paramString, paramIterable1, IdentityCipherSuiteFilter.INSTANCE, JdkSslContext.toNegotiator(SslContext.toApplicationProtocolConfig(paramIterable2), true), paramLong1, paramLong2, KeyStore.getDefaultType());
  }
  
  @Deprecated
  public JdkSslServerContext(File paramFile1, TrustManagerFactory paramTrustManagerFactory, File paramFile2, File paramFile3, String paramString, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    super(newSSLContext(null, SslContext.toX509CertificatesInternal(paramFile1), paramTrustManagerFactory, SslContext.toX509CertificatesInternal(paramFile2), SslContext.toPrivateKeyInternal(paramFile3, paramString), paramString, paramKeyManagerFactory, paramLong1, paramLong2, null), false, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, ClientAuth.NONE, null, false);
  }
  
  @Deprecated
  public JdkSslServerContext(File paramFile1, TrustManagerFactory paramTrustManagerFactory, File paramFile2, File paramFile3, String paramString, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, long paramLong1, long paramLong2)
    throws SSLException
  {
    super(newSSLContext(null, SslContext.toX509CertificatesInternal(paramFile1), paramTrustManagerFactory, SslContext.toX509CertificatesInternal(paramFile2), SslContext.toPrivateKeyInternal(paramFile3, paramString), paramString, paramKeyManagerFactory, paramLong1, paramLong2, KeyStore.getDefaultType()), false, paramIterable, paramCipherSuiteFilter, paramJdkApplicationProtocolNegotiator, ClientAuth.NONE, null, false);
  }
  
  JdkSslServerContext(Provider paramProvider, File paramFile1, File paramFile2, String paramString1, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, long paramLong1, long paramLong2, String paramString2)
    throws SSLException
  {
    super(newSSLContext(paramProvider, null, null, SslContext.toX509CertificatesInternal(paramFile1), SslContext.toPrivateKeyInternal(paramFile2, paramString1), paramString1, null, paramLong1, paramLong2, paramString2), false, paramIterable, paramCipherSuiteFilter, paramJdkApplicationProtocolNegotiator, ClientAuth.NONE, null, false);
  }
  
  JdkSslServerContext(Provider paramProvider, X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2, ClientAuth paramClientAuth, String[] paramArrayOfString, boolean paramBoolean, String paramString2)
    throws SSLException
  {
    super(newSSLContext(paramProvider, paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramLong1, paramLong2, paramString2), false, paramIterable, paramCipherSuiteFilter, JdkSslContext.toNegotiator(paramApplicationProtocolConfig, true), paramClientAuth, paramArrayOfString, paramBoolean);
  }
  
  private static SSLContext newSSLContext(Provider paramProvider, X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, long paramLong1, long paramLong2, String paramString2)
    throws SSLException
  {
    if (paramPrivateKey == null) {
      Objects.requireNonNull(paramKeyManagerFactory, "key, keyManagerFactory");
    }
    TrustManagerFactory localTrustManagerFactory = paramTrustManagerFactory;
    if (paramArrayOfX509Certificate1 != null) {
      try
      {
        localTrustManagerFactory = SslContext.buildTrustManagerFactory(paramArrayOfX509Certificate1, paramTrustManagerFactory, paramString2);
      }
      catch (Exception paramProvider)
      {
        break label155;
      }
    }
    paramArrayOfX509Certificate1 = paramKeyManagerFactory;
    if (paramPrivateKey != null) {
      paramArrayOfX509Certificate1 = SslContext.buildKeyManagerFactory(paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, null);
    }
    if (paramProvider == null) {
      paramProvider = SSLContext.getInstance("TLS");
    } else {
      paramProvider = SSLContext.getInstance("TLS", paramProvider);
    }
    paramTrustManagerFactory = paramArrayOfX509Certificate1.getKeyManagers();
    if (localTrustManagerFactory == null) {
      paramArrayOfX509Certificate1 = null;
    } else {
      paramArrayOfX509Certificate1 = localTrustManagerFactory.getTrustManagers();
    }
    paramProvider.init(paramTrustManagerFactory, paramArrayOfX509Certificate1, null);
    paramArrayOfX509Certificate1 = paramProvider.getServerSessionContext();
    if (paramLong1 > 0L) {
      paramArrayOfX509Certificate1.setSessionCacheSize((int)Math.min(paramLong1, 2147483647L));
    }
    if (paramLong2 > 0L) {
      paramArrayOfX509Certificate1.setSessionTimeout((int)Math.min(paramLong2, 2147483647L));
    }
    return paramProvider;
    label155:
    if ((paramProvider instanceof SSLException)) {
      throw ((SSLException)paramProvider);
    }
    throw new SSLException("failed to initialize the server-side SSL context", paramProvider);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JdkSslServerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */