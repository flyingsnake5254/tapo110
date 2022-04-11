package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufInputStream;
import io.netty.util.AttributeMap;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;

public abstract class SslContext
{
  static final String ALIAS = "key";
  static final CertificateFactory X509_CERT_FACTORY;
  private final AttributeMap attributes = new DefaultAttributeMap();
  private final boolean startTls;
  
  static
  {
    try
    {
      X509_CERT_FACTORY = CertificateFactory.getInstance("X.509");
      return;
    }
    catch (CertificateException localCertificateException)
    {
      throw new IllegalStateException("unable to instance X.509 CertificateFactory", localCertificateException);
    }
  }
  
  protected SslContext()
  {
    this(false);
  }
  
  protected SslContext(boolean paramBoolean)
  {
    this.startTls = paramBoolean;
  }
  
  static KeyManagerFactory buildKeyManagerFactory(KeyStore paramKeyStore, String paramString, char[] paramArrayOfChar, KeyManagerFactory paramKeyManagerFactory)
    throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
  {
    KeyManagerFactory localKeyManagerFactory = paramKeyManagerFactory;
    if (paramKeyManagerFactory == null) {
      localKeyManagerFactory = KeyManagerFactory.getInstance(paramString);
    }
    localKeyManagerFactory.init(paramKeyStore, paramArrayOfChar);
    return localKeyManagerFactory;
  }
  
  static KeyManagerFactory buildKeyManagerFactory(X509Certificate[] paramArrayOfX509Certificate, String paramString1, PrivateKey paramPrivateKey, String paramString2, KeyManagerFactory paramKeyManagerFactory)
    throws KeyStoreException, NoSuchAlgorithmException, IOException, CertificateException, UnrecoverableKeyException
  {
    paramString2 = keyStorePassword(paramString2);
    return buildKeyManagerFactory(buildKeyStore(paramArrayOfX509Certificate, paramPrivateKey, paramString2, KeyStore.getDefaultType()), paramString1, paramString2, paramKeyManagerFactory);
  }
  
  static KeyManagerFactory buildKeyManagerFactory(X509Certificate[] paramArrayOfX509Certificate, String paramString1, PrivateKey paramPrivateKey, String paramString2, KeyManagerFactory paramKeyManagerFactory, String paramString3)
    throws KeyStoreException, NoSuchAlgorithmException, IOException, CertificateException, UnrecoverableKeyException
  {
    paramString2 = keyStorePassword(paramString2);
    return buildKeyManagerFactory(buildKeyStore(paramArrayOfX509Certificate, paramPrivateKey, paramString2, paramString3), paramString1, paramString2, paramKeyManagerFactory);
  }
  
  static KeyManagerFactory buildKeyManagerFactory(X509Certificate[] paramArrayOfX509Certificate, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, String paramString2)
    throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException
  {
    return buildKeyManagerFactory(paramArrayOfX509Certificate, KeyManagerFactory.getDefaultAlgorithm(), paramPrivateKey, paramString1, paramKeyManagerFactory, paramString2);
  }
  
  static KeyStore buildKeyStore(X509Certificate[] paramArrayOfX509Certificate, PrivateKey paramPrivateKey, char[] paramArrayOfChar, String paramString)
    throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException
  {
    String str = paramString;
    if (paramString == null) {
      str = KeyStore.getDefaultType();
    }
    paramString = KeyStore.getInstance(str);
    paramString.load(null, null);
    paramString.setKeyEntry("key", paramPrivateKey, paramArrayOfChar, paramArrayOfX509Certificate);
    return paramString;
  }
  
  @Deprecated
  protected static TrustManagerFactory buildTrustManagerFactory(File paramFile, TrustManagerFactory paramTrustManagerFactory)
    throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException
  {
    return buildTrustManagerFactory(paramFile, paramTrustManagerFactory, KeyStore.getDefaultType());
  }
  
  static TrustManagerFactory buildTrustManagerFactory(File paramFile, TrustManagerFactory paramTrustManagerFactory, String paramString)
    throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException
  {
    return buildTrustManagerFactory(toX509Certificates(paramFile), paramTrustManagerFactory, paramString);
  }
  
  static TrustManagerFactory buildTrustManagerFactory(X509Certificate[] paramArrayOfX509Certificate, TrustManagerFactory paramTrustManagerFactory, String paramString)
    throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = KeyStore.getDefaultType();
    }
    paramString = KeyStore.getInstance((String)localObject);
    paramString.load(null, null);
    int i = paramArrayOfX509Certificate.length;
    int j = 0;
    int k = 1;
    while (j < i)
    {
      localObject = paramArrayOfX509Certificate[j];
      paramString.setCertificateEntry(Integer.toString(k), (Certificate)localObject);
      k++;
      j++;
    }
    paramArrayOfX509Certificate = paramTrustManagerFactory;
    if (paramTrustManagerFactory == null) {
      paramArrayOfX509Certificate = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    }
    paramArrayOfX509Certificate.init(paramString);
    return paramArrayOfX509Certificate;
  }
  
  public static SslProvider defaultClientProvider()
  {
    return defaultProvider();
  }
  
  private static SslProvider defaultProvider()
  {
    if (OpenSsl.isAvailable()) {
      return SslProvider.OPENSSL;
    }
    return SslProvider.JDK;
  }
  
  public static SslProvider defaultServerProvider()
  {
    return defaultProvider();
  }
  
  protected static PKCS8EncodedKeySpec generateKeySpec(char[] paramArrayOfChar, byte[] paramArrayOfByte)
    throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, InvalidAlgorithmParameterException
  {
    if (paramArrayOfChar == null) {
      return new PKCS8EncodedKeySpec(paramArrayOfByte);
    }
    paramArrayOfByte = new EncryptedPrivateKeyInfo(paramArrayOfByte);
    SecretKey localSecretKey = SecretKeyFactory.getInstance(paramArrayOfByte.getAlgName()).generateSecret(new PBEKeySpec(paramArrayOfChar));
    paramArrayOfChar = Cipher.getInstance(paramArrayOfByte.getAlgName());
    paramArrayOfChar.init(2, localSecretKey, paramArrayOfByte.getAlgParameters());
    return paramArrayOfByte.getKeySpec(paramArrayOfChar);
  }
  
  private static X509Certificate[] getCertificatesFromBuffers(ByteBuf[] paramArrayOfByteBuf)
    throws CertificateException
  {
    CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
    X509Certificate[] arrayOfX509Certificate = new X509Certificate[paramArrayOfByteBuf.length];
    int i = 0;
    int j = 0;
    int k = 0;
    try
    {
      while (k < paramArrayOfByteBuf.length)
      {
        Object localObject2 = new io/netty/buffer/ByteBufInputStream;
        ((ByteBufInputStream)localObject2).<init>(paramArrayOfByteBuf[k], false);
        try
        {
          arrayOfX509Certificate[k] = ((X509Certificate)localCertificateFactory.generateCertificate((InputStream)localObject2));
          try
          {
            ((InputStream)localObject2).close();
            k++;
          }
          catch (IOException localIOException1)
          {
            localObject2 = new java/lang/RuntimeException;
            ((RuntimeException)localObject2).<init>(localIOException1);
            throw ((Throwable)localObject2);
          }
          RuntimeException localRuntimeException;
          i = paramArrayOfByteBuf.length;
        }
        finally {}
      }
      for (k = j; k < i; k++) {
        paramArrayOfByteBuf[k].release();
      }
      return arrayOfX509Certificate;
    }
    finally
    {
      j = paramArrayOfByteBuf.length;
      for (k = i; k < j; k++) {
        paramArrayOfByteBuf[k].release();
      }
    }
  }
  
  private static PrivateKey getPrivateKeyFromByteBuffer(ByteBuf paramByteBuf, String paramString)
    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, KeyException, IOException
  {
    byte[] arrayOfByte = new byte[paramByteBuf.readableBytes()];
    paramByteBuf.readBytes(arrayOfByte).release();
    if (paramString == null) {
      paramByteBuf = null;
    } else {
      paramByteBuf = paramString.toCharArray();
    }
    paramByteBuf = generateKeySpec(paramByteBuf, arrayOfByte);
    try
    {
      paramString = KeyFactory.getInstance("RSA").generatePrivate(paramByteBuf);
      return paramString;
    }
    catch (InvalidKeySpecException paramString)
    {
      try
      {
        paramString = KeyFactory.getInstance("DSA").generatePrivate(paramByteBuf);
        return paramString;
      }
      catch (InvalidKeySpecException paramString)
      {
        try
        {
          paramByteBuf = KeyFactory.getInstance("EC").generatePrivate(paramByteBuf);
          return paramByteBuf;
        }
        catch (InvalidKeySpecException paramByteBuf)
        {
          throw new InvalidKeySpecException("Neither RSA, DSA nor EC worked", paramByteBuf);
        }
      }
    }
  }
  
  static char[] keyStorePassword(String paramString)
  {
    if (paramString == null) {
      paramString = EmptyArrays.EMPTY_CHARS;
    } else {
      paramString = paramString.toCharArray();
    }
    return paramString;
  }
  
  @Deprecated
  public static SslContext newClientContext()
    throws SSLException
  {
    return newClientContext(null, null, null);
  }
  
  @Deprecated
  public static SslContext newClientContext(SslProvider paramSslProvider)
    throws SSLException
  {
    return newClientContext(paramSslProvider, null, null);
  }
  
  @Deprecated
  public static SslContext newClientContext(SslProvider paramSslProvider, File paramFile)
    throws SSLException
  {
    return newClientContext(paramSslProvider, paramFile, null);
  }
  
  @Deprecated
  public static SslContext newClientContext(SslProvider paramSslProvider, File paramFile, TrustManagerFactory paramTrustManagerFactory)
    throws SSLException
  {
    return newClientContext(paramSslProvider, paramFile, paramTrustManagerFactory, null, IdentityCipherSuiteFilter.INSTANCE, null, 0L, 0L);
  }
  
  @Deprecated
  public static SslContext newClientContext(SslProvider paramSslProvider, File paramFile1, TrustManagerFactory paramTrustManagerFactory, File paramFile2, File paramFile3, String paramString, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    try
    {
      paramSslProvider = newClientContextInternal(paramSslProvider, null, toX509Certificates(paramFile1), paramTrustManagerFactory, toX509Certificates(paramFile2), toPrivateKey(paramFile3, paramString), paramString, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, null, paramLong1, paramLong2, false, KeyStore.getDefaultType());
      return paramSslProvider;
    }
    catch (Exception paramSslProvider)
    {
      if ((paramSslProvider instanceof SSLException)) {
        throw ((SSLException)paramSslProvider);
      }
      throw new SSLException("failed to initialize the client-side SSL context", paramSslProvider);
    }
  }
  
  @Deprecated
  public static SslContext newClientContext(SslProvider paramSslProvider, File paramFile, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    return newClientContext(paramSslProvider, paramFile, paramTrustManagerFactory, null, null, null, null, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2);
  }
  
  @Deprecated
  public static SslContext newClientContext(SslProvider paramSslProvider, File paramFile, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable1, Iterable<String> paramIterable2, long paramLong1, long paramLong2)
    throws SSLException
  {
    return newClientContext(paramSslProvider, paramFile, paramTrustManagerFactory, null, null, null, null, paramIterable1, IdentityCipherSuiteFilter.INSTANCE, toApplicationProtocolConfig(paramIterable2), paramLong1, paramLong2);
  }
  
  @Deprecated
  public static SslContext newClientContext(SslProvider paramSslProvider, TrustManagerFactory paramTrustManagerFactory)
    throws SSLException
  {
    return newClientContext(paramSslProvider, null, paramTrustManagerFactory);
  }
  
  @Deprecated
  public static SslContext newClientContext(File paramFile)
    throws SSLException
  {
    return newClientContext(null, paramFile);
  }
  
  @Deprecated
  public static SslContext newClientContext(File paramFile, TrustManagerFactory paramTrustManagerFactory)
    throws SSLException
  {
    return newClientContext(null, paramFile, paramTrustManagerFactory);
  }
  
  @Deprecated
  public static SslContext newClientContext(File paramFile, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    return newClientContext(null, paramFile, paramTrustManagerFactory, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2);
  }
  
  @Deprecated
  public static SslContext newClientContext(File paramFile, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable1, Iterable<String> paramIterable2, long paramLong1, long paramLong2)
    throws SSLException
  {
    return newClientContext(null, paramFile, paramTrustManagerFactory, paramIterable1, paramIterable2, paramLong1, paramLong2);
  }
  
  @Deprecated
  public static SslContext newClientContext(TrustManagerFactory paramTrustManagerFactory)
    throws SSLException
  {
    return newClientContext(null, null, paramTrustManagerFactory);
  }
  
  static SslContext newClientContextInternal(SslProvider paramSslProvider, Provider paramProvider, X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, String[] paramArrayOfString, long paramLong1, long paramLong2, boolean paramBoolean, String paramString2)
    throws SSLException
  {
    if (paramSslProvider == null) {
      paramSslProvider = defaultClientProvider();
    }
    int i = 1.$SwitchMap$io$netty$handler$ssl$SslProvider[paramSslProvider.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          verifyNullSslContextProvider(paramSslProvider, paramProvider);
          return new ReferenceCountedOpenSslClientContext(paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramArrayOfString, paramLong1, paramLong2, paramBoolean, paramString2);
        }
        throw new Error(paramSslProvider.toString());
      }
      verifyNullSslContextProvider(paramSslProvider, paramProvider);
      return new OpenSslClientContext(paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramArrayOfString, paramLong1, paramLong2, paramBoolean, paramString2);
    }
    if (!paramBoolean) {
      return new JdkSslClientContext(paramProvider, paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramArrayOfString, paramLong1, paramLong2, paramString2);
    }
    paramProvider = new StringBuilder();
    paramProvider.append("OCSP is not supported with this SslProvider: ");
    paramProvider.append(paramSslProvider);
    throw new IllegalArgumentException(paramProvider.toString());
  }
  
  @Deprecated
  public static SslContext newServerContext(SslProvider paramSslProvider, File paramFile1, File paramFile2)
    throws SSLException
  {
    return newServerContext(paramSslProvider, paramFile1, paramFile2, null);
  }
  
  @Deprecated
  public static SslContext newServerContext(SslProvider paramSslProvider, File paramFile1, File paramFile2, String paramString)
    throws SSLException
  {
    return newServerContext(paramSslProvider, paramFile1, paramFile2, paramString, null, IdentityCipherSuiteFilter.INSTANCE, null, 0L, 0L);
  }
  
  @Deprecated
  public static SslContext newServerContext(SslProvider paramSslProvider, File paramFile1, File paramFile2, String paramString, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    return newServerContext(paramSslProvider, null, null, paramFile1, paramFile2, paramString, null, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2, KeyStore.getDefaultType());
  }
  
  @Deprecated
  public static SslContext newServerContext(SslProvider paramSslProvider, File paramFile1, File paramFile2, String paramString, Iterable<String> paramIterable1, Iterable<String> paramIterable2, long paramLong1, long paramLong2)
    throws SSLException
  {
    return newServerContext(paramSslProvider, paramFile1, paramFile2, paramString, paramIterable1, IdentityCipherSuiteFilter.INSTANCE, toApplicationProtocolConfig(paramIterable2), paramLong1, paramLong2);
  }
  
  @Deprecated
  public static SslContext newServerContext(SslProvider paramSslProvider, File paramFile1, File paramFile2, String paramString, TrustManagerFactory paramTrustManagerFactory, Iterable<String> paramIterable1, Iterable<String> paramIterable2, long paramLong1, long paramLong2)
    throws SSLException
  {
    return newServerContext(paramSslProvider, null, paramTrustManagerFactory, paramFile1, paramFile2, paramString, null, paramIterable1, IdentityCipherSuiteFilter.INSTANCE, toApplicationProtocolConfig(paramIterable2), paramLong1, paramLong2);
  }
  
  @Deprecated
  public static SslContext newServerContext(SslProvider paramSslProvider, File paramFile1, TrustManagerFactory paramTrustManagerFactory, File paramFile2, File paramFile3, String paramString, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    return newServerContext(paramSslProvider, paramFile1, paramTrustManagerFactory, paramFile2, paramFile3, paramString, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2, KeyStore.getDefaultType());
  }
  
  static SslContext newServerContext(SslProvider paramSslProvider, File paramFile1, TrustManagerFactory paramTrustManagerFactory, File paramFile2, File paramFile3, String paramString1, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2, String paramString2)
    throws SSLException
  {
    try
    {
      paramSslProvider = newServerContextInternal(paramSslProvider, null, toX509Certificates(paramFile1), paramTrustManagerFactory, toX509Certificates(paramFile2), toPrivateKey(paramFile3, paramString1), paramString1, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2, ClientAuth.NONE, null, false, false, paramString2);
      return paramSslProvider;
    }
    catch (Exception paramSslProvider)
    {
      if ((paramSslProvider instanceof SSLException)) {
        throw ((SSLException)paramSslProvider);
      }
      throw new SSLException("failed to initialize the server-side SSL context", paramSslProvider);
    }
  }
  
  @Deprecated
  public static SslContext newServerContext(File paramFile1, File paramFile2)
    throws SSLException
  {
    return newServerContext(paramFile1, paramFile2, null);
  }
  
  @Deprecated
  public static SslContext newServerContext(File paramFile1, File paramFile2, String paramString)
    throws SSLException
  {
    return newServerContext(null, paramFile1, paramFile2, paramString);
  }
  
  @Deprecated
  public static SslContext newServerContext(File paramFile1, File paramFile2, String paramString, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2)
    throws SSLException
  {
    return newServerContext(null, paramFile1, paramFile2, paramString, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2);
  }
  
  @Deprecated
  public static SslContext newServerContext(File paramFile1, File paramFile2, String paramString, Iterable<String> paramIterable1, Iterable<String> paramIterable2, long paramLong1, long paramLong2)
    throws SSLException
  {
    return newServerContext(null, paramFile1, paramFile2, paramString, paramIterable1, paramIterable2, paramLong1, paramLong2);
  }
  
  static SslContext newServerContextInternal(SslProvider paramSslProvider, Provider paramProvider, X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2, ClientAuth paramClientAuth, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
    throws SSLException
  {
    if (paramSslProvider == null) {
      paramSslProvider = defaultServerProvider();
    }
    int i = 1.$SwitchMap$io$netty$handler$ssl$SslProvider[paramSslProvider.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          verifyNullSslContextProvider(paramSslProvider, paramProvider);
          return new ReferenceCountedOpenSslServerContext(paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2, paramClientAuth, paramArrayOfString, paramBoolean1, paramBoolean2, paramString2);
        }
        throw new Error(paramSslProvider.toString());
      }
      verifyNullSslContextProvider(paramSslProvider, paramProvider);
      return new OpenSslServerContext(paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2, paramClientAuth, paramArrayOfString, paramBoolean1, paramBoolean2, paramString2);
    }
    if (!paramBoolean2) {
      return new JdkSslServerContext(paramProvider, paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2, paramClientAuth, paramArrayOfString, paramBoolean1, paramString2);
    }
    paramProvider = new StringBuilder();
    paramProvider.append("OCSP is not supported with this SslProvider: ");
    paramProvider.append(paramSslProvider);
    throw new IllegalArgumentException(paramProvider.toString());
  }
  
  static ApplicationProtocolConfig toApplicationProtocolConfig(Iterable<String> paramIterable)
  {
    if (paramIterable == null) {
      paramIterable = ApplicationProtocolConfig.DISABLED;
    } else {
      paramIterable = new ApplicationProtocolConfig(ApplicationProtocolConfig.Protocol.NPN_AND_ALPN, ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL, ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT, paramIterable);
    }
    return paramIterable;
  }
  
  static PrivateKey toPrivateKey(File paramFile, String paramString)
    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, KeyException, IOException
  {
    if (paramFile == null) {
      return null;
    }
    return getPrivateKeyFromByteBuffer(PemReader.readPrivateKey(paramFile), paramString);
  }
  
  static PrivateKey toPrivateKey(InputStream paramInputStream, String paramString)
    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, KeyException, IOException
  {
    if (paramInputStream == null) {
      return null;
    }
    return getPrivateKeyFromByteBuffer(PemReader.readPrivateKey(paramInputStream), paramString);
  }
  
  static PrivateKey toPrivateKeyInternal(File paramFile, String paramString)
    throws SSLException
  {
    try
    {
      paramFile = toPrivateKey(paramFile, paramString);
      return paramFile;
    }
    catch (Exception paramFile)
    {
      throw new SSLException(paramFile);
    }
  }
  
  static X509Certificate[] toX509Certificates(File paramFile)
    throws CertificateException
  {
    if (paramFile == null) {
      return null;
    }
    return getCertificatesFromBuffers(PemReader.readCertificates(paramFile));
  }
  
  static X509Certificate[] toX509Certificates(InputStream paramInputStream)
    throws CertificateException
  {
    if (paramInputStream == null) {
      return null;
    }
    return getCertificatesFromBuffers(PemReader.readCertificates(paramInputStream));
  }
  
  static X509Certificate[] toX509CertificatesInternal(File paramFile)
    throws SSLException
  {
    try
    {
      paramFile = toX509Certificates(paramFile);
      return paramFile;
    }
    catch (CertificateException paramFile)
    {
      throw new SSLException(paramFile);
    }
  }
  
  private static void verifyNullSslContextProvider(SslProvider paramSslProvider, Provider paramProvider)
  {
    if (paramProvider == null) {
      return;
    }
    paramProvider = new StringBuilder();
    paramProvider.append("Java Security Provider unsupported for SslProvider: ");
    paramProvider.append(paramSslProvider);
    throw new IllegalArgumentException(paramProvider.toString());
  }
  
  public abstract ApplicationProtocolNegotiator applicationProtocolNegotiator();
  
  public final AttributeMap attributes()
  {
    return this.attributes;
  }
  
  public abstract List<String> cipherSuites();
  
  public abstract boolean isClient();
  
  public final boolean isServer()
  {
    return isClient() ^ true;
  }
  
  public abstract SSLEngine newEngine(ByteBufAllocator paramByteBufAllocator);
  
  public abstract SSLEngine newEngine(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt);
  
  public final SslHandler newHandler(ByteBufAllocator paramByteBufAllocator)
  {
    return newHandler(paramByteBufAllocator, this.startTls);
  }
  
  public final SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt)
  {
    return newHandler(paramByteBufAllocator, paramString, paramInt, this.startTls);
  }
  
  public SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt, Executor paramExecutor)
  {
    return newHandler(paramByteBufAllocator, paramString, paramInt, this.startTls, paramExecutor);
  }
  
  protected SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt, boolean paramBoolean)
  {
    return new SslHandler(newEngine(paramByteBufAllocator, paramString, paramInt), paramBoolean);
  }
  
  protected SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt, boolean paramBoolean, Executor paramExecutor)
  {
    return new SslHandler(newEngine(paramByteBufAllocator, paramString, paramInt), paramBoolean, paramExecutor);
  }
  
  public SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, Executor paramExecutor)
  {
    return newHandler(paramByteBufAllocator, this.startTls, paramExecutor);
  }
  
  protected SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean)
  {
    return new SslHandler(newEngine(paramByteBufAllocator), paramBoolean);
  }
  
  protected SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, Executor paramExecutor)
  {
    return new SslHandler(newEngine(paramByteBufAllocator), paramBoolean, paramExecutor);
  }
  
  @Deprecated
  public final List<String> nextProtocols()
  {
    return applicationProtocolNegotiator().protocols();
  }
  
  public abstract long sessionCacheSize();
  
  public abstract SSLSessionContext sessionContext();
  
  public abstract long sessionTimeout();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SslContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */