package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSessionContext;

public class JdkSslContext
  extends SslContext
{
  private static final List<String> DEFAULT_CIPHERS;
  private static final List<String> DEFAULT_CIPHERS_NON_TLSV13;
  private static final String[] DEFAULT_PROTOCOLS;
  private static final Provider DEFAULT_PROVIDER;
  static final String PROTOCOL = "TLS";
  private static final Set<String> SUPPORTED_CIPHERS;
  private static final Set<String> SUPPORTED_CIPHERS_NON_TLSV13;
  private static final InternalLogger logger;
  private final JdkApplicationProtocolNegotiator apn;
  private final String[] cipherSuites;
  private final ClientAuth clientAuth;
  private final boolean isClient;
  private final String[] protocols;
  private final SSLContext sslContext;
  private final List<String> unmodifiableCipherSuites;
  
  static
  {
    InternalLogger localInternalLogger = InternalLoggerFactory.getInstance(JdkSslContext.class);
    logger = localInternalLogger;
    try
    {
      Object localObject1 = SSLContext.getInstance("TLS");
      ((SSLContext)localObject1).init(null, null, null);
      DEFAULT_PROVIDER = ((SSLContext)localObject1).getProvider();
      Object localObject2 = ((SSLContext)localObject1).createSSLEngine();
      localObject1 = defaultProtocols((SSLContext)localObject1, (SSLEngine)localObject2);
      DEFAULT_PROTOCOLS = (String[])localObject1;
      Object localObject3 = Collections.unmodifiableSet(supportedCiphers((SSLEngine)localObject2));
      SUPPORTED_CIPHERS = (Set)localObject3;
      List localList = Collections.unmodifiableList(defaultCiphers((SSLEngine)localObject2, (Set)localObject3));
      DEFAULT_CIPHERS = localList;
      ArrayList localArrayList = new ArrayList(localList);
      localObject2 = SslUtils.DEFAULT_TLSV13_CIPHER_SUITES;
      localArrayList.removeAll(Arrays.asList((Object[])localObject2));
      DEFAULT_CIPHERS_NON_TLSV13 = Collections.unmodifiableList(localArrayList);
      localObject3 = new LinkedHashSet((Collection)localObject3);
      ((Set)localObject3).removeAll(Arrays.asList((Object[])localObject2));
      SUPPORTED_CIPHERS_NON_TLSV13 = Collections.unmodifiableSet((Set)localObject3);
      if (localInternalLogger.isDebugEnabled())
      {
        localInternalLogger.debug("Default protocols (JDK): {} ", Arrays.asList((Object[])localObject1));
        localInternalLogger.debug("Default cipher suites (JDK): {}", localList);
      }
      return;
    }
    catch (Exception localException)
    {
      throw new Error("failed to initialize the default SSL context", localException);
    }
  }
  
  @Deprecated
  public JdkSslContext(SSLContext paramSSLContext, boolean paramBoolean, ClientAuth paramClientAuth)
  {
    this(paramSSLContext, paramBoolean, null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, paramClientAuth, null, false);
  }
  
  @Deprecated
  public JdkSslContext(SSLContext paramSSLContext, boolean paramBoolean, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, ClientAuth paramClientAuth)
  {
    this(paramSSLContext, paramBoolean, paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramClientAuth, null, false);
  }
  
  public JdkSslContext(SSLContext paramSSLContext, boolean paramBoolean1, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, ClientAuth paramClientAuth, String[] paramArrayOfString, boolean paramBoolean2)
  {
    this(paramSSLContext, paramBoolean1, paramIterable, paramCipherSuiteFilter, localJdkApplicationProtocolNegotiator, paramClientAuth, paramApplicationProtocolConfig, paramBoolean2);
  }
  
  JdkSslContext(SSLContext paramSSLContext, boolean paramBoolean1, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, ClientAuth paramClientAuth, String[] paramArrayOfString, boolean paramBoolean2)
  {
    super(paramBoolean2);
    this.apn = ((JdkApplicationProtocolNegotiator)ObjectUtil.checkNotNull(paramJdkApplicationProtocolNegotiator, "apn"));
    this.clientAuth = ((ClientAuth)ObjectUtil.checkNotNull(paramClientAuth, "clientAuth"));
    this.sslContext = ((SSLContext)ObjectUtil.checkNotNull(paramSSLContext, "sslContext"));
    if (DEFAULT_PROVIDER.equals(paramSSLContext.getProvider()))
    {
      paramSSLContext = paramArrayOfString;
      if (paramArrayOfString == null) {
        paramSSLContext = DEFAULT_PROTOCOLS;
      }
      this.protocols = paramSSLContext;
      if (isTlsV13Supported(paramSSLContext))
      {
        paramSSLContext = SUPPORTED_CIPHERS;
        paramJdkApplicationProtocolNegotiator = DEFAULT_CIPHERS;
      }
      else
      {
        paramSSLContext = SUPPORTED_CIPHERS_NON_TLSV13;
        paramJdkApplicationProtocolNegotiator = DEFAULT_CIPHERS_NON_TLSV13;
      }
    }
    else
    {
      paramClientAuth = paramSSLContext.createSSLEngine();
      if (paramArrayOfString != null) {}
    }
    try
    {
      this.protocols = defaultProtocols(paramSSLContext, paramClientAuth);
      break label138;
      this.protocols = paramArrayOfString;
      label138:
      paramSSLContext = supportedCiphers(paramClientAuth);
      paramJdkApplicationProtocolNegotiator = defaultCiphers(paramClientAuth, paramSSLContext);
      if (!isTlsV13Supported(this.protocols)) {
        for (paramArrayOfString : SslUtils.DEFAULT_TLSV13_CIPHER_SUITES)
        {
          paramSSLContext.remove(paramArrayOfString);
          paramJdkApplicationProtocolNegotiator.remove(paramArrayOfString);
        }
      }
      ReferenceCountUtil.release(paramClientAuth);
      paramSSLContext = ((CipherSuiteFilter)ObjectUtil.checkNotNull(paramCipherSuiteFilter, "cipherFilter")).filterCipherSuites(paramIterable, paramJdkApplicationProtocolNegotiator, paramSSLContext);
      this.cipherSuites = paramSSLContext;
      this.unmodifiableCipherSuites = Collections.unmodifiableList(Arrays.asList(paramSSLContext));
      this.isClient = paramBoolean1;
      return;
    }
    finally
    {
      ReferenceCountUtil.release(paramClientAuth);
    }
  }
  
  @Deprecated
  protected static KeyManagerFactory buildKeyManagerFactory(File paramFile1, File paramFile2, String paramString, KeyManagerFactory paramKeyManagerFactory)
    throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, CertificateException, KeyException, IOException
  {
    return buildKeyManagerFactory(paramFile1, paramFile2, paramString, paramKeyManagerFactory, KeyStore.getDefaultType());
  }
  
  static KeyManagerFactory buildKeyManagerFactory(File paramFile1, File paramFile2, String paramString1, KeyManagerFactory paramKeyManagerFactory, String paramString2)
    throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, CertificateException, KeyException, IOException
  {
    String str1 = Security.getProperty("ssl.KeyManagerFactory.algorithm");
    String str2 = str1;
    if (str1 == null) {
      str2 = "SunX509";
    }
    return buildKeyManagerFactory(paramFile1, str2, paramFile2, paramString1, paramKeyManagerFactory, paramString2);
  }
  
  @Deprecated
  protected static KeyManagerFactory buildKeyManagerFactory(File paramFile1, String paramString1, File paramFile2, String paramString2, KeyManagerFactory paramKeyManagerFactory)
    throws KeyStoreException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, IOException, CertificateException, KeyException, UnrecoverableKeyException
  {
    return SslContext.buildKeyManagerFactory(SslContext.toX509Certificates(paramFile1), paramString1, SslContext.toPrivateKey(paramFile2, paramString2), paramString2, paramKeyManagerFactory, KeyStore.getDefaultType());
  }
  
  static KeyManagerFactory buildKeyManagerFactory(File paramFile1, String paramString1, File paramFile2, String paramString2, KeyManagerFactory paramKeyManagerFactory, String paramString3)
    throws KeyStoreException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, IOException, CertificateException, KeyException, UnrecoverableKeyException
  {
    return SslContext.buildKeyManagerFactory(SslContext.toX509Certificates(paramFile1), paramString1, SslContext.toPrivateKey(paramFile2, paramString2), paramString2, paramKeyManagerFactory, paramString3);
  }
  
  private SSLEngine configureAndWrapEngine(SSLEngine paramSSLEngine, ByteBufAllocator paramByteBufAllocator)
  {
    paramSSLEngine.setEnabledCipherSuites(this.cipherSuites);
    paramSSLEngine.setEnabledProtocols(this.protocols);
    paramSSLEngine.setUseClientMode(isClient());
    if (isServer())
    {
      int i = 1.$SwitchMap$io$netty$handler$ssl$ClientAuth[this.clientAuth.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            paramSSLEngine = new StringBuilder();
            paramSSLEngine.append("Unknown auth ");
            paramSSLEngine.append(this.clientAuth);
            throw new Error(paramSSLEngine.toString());
          }
        }
        else {
          paramSSLEngine.setNeedClientAuth(true);
        }
      }
      else {
        paramSSLEngine.setWantClientAuth(true);
      }
    }
    JdkApplicationProtocolNegotiator.SslEngineWrapperFactory localSslEngineWrapperFactory = this.apn.wrapperFactory();
    if ((localSslEngineWrapperFactory instanceof JdkApplicationProtocolNegotiator.AllocatorAwareSslEngineWrapperFactory)) {
      return ((JdkApplicationProtocolNegotiator.AllocatorAwareSslEngineWrapperFactory)localSslEngineWrapperFactory).wrapSslEngine(paramSSLEngine, paramByteBufAllocator, this.apn, isServer());
    }
    return localSslEngineWrapperFactory.wrapSslEngine(paramSSLEngine, this.apn, isServer());
  }
  
  private static List<String> defaultCiphers(SSLEngine paramSSLEngine, Set<String> paramSet)
  {
    ArrayList localArrayList = new ArrayList();
    SslUtils.addIfSupported(paramSet, localArrayList, SslUtils.DEFAULT_CIPHER_SUITES);
    SslUtils.useFallbackCiphersIfDefaultIsEmpty(localArrayList, paramSSLEngine.getEnabledCipherSuites());
    return localArrayList;
  }
  
  private static String[] defaultProtocols(SSLContext paramSSLContext, SSLEngine paramSSLEngine)
  {
    Object localObject = paramSSLContext.getDefaultSSLParameters().getProtocols();
    paramSSLContext = new HashSet(localObject.length);
    Collections.addAll(paramSSLContext, (Object[])localObject);
    localObject = new ArrayList();
    SslUtils.addIfSupported(paramSSLContext, (List)localObject, new String[] { "TLSv1.2", "TLSv1.1", "TLSv1" });
    if (!((List)localObject).isEmpty()) {
      return (String[])((List)localObject).toArray(new String[0]);
    }
    return paramSSLEngine.getEnabledProtocols();
  }
  
  private static boolean isTlsV13Supported(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++) {
      if ("TLSv1.3".equals(paramArrayOfString[j])) {
        return true;
      }
    }
    return false;
  }
  
  private static Set<String> supportedCiphers(SSLEngine paramSSLEngine)
  {
    String[] arrayOfString = paramSSLEngine.getSupportedCipherSuites();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(arrayOfString.length);
    int i = 0;
    for (;;)
    {
      String str;
      if (i < arrayOfString.length)
      {
        str = arrayOfString[i];
        localLinkedHashSet.add(str);
        if (str.startsWith("SSL_"))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("TLS_");
          localStringBuilder.append(str.substring(4));
          str = localStringBuilder.toString();
        }
      }
      try
      {
        paramSSLEngine.setEnabledCipherSuites(new String[] { str });
        localLinkedHashSet.add(str);
        i++;
        continue;
        return localLinkedHashSet;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;) {}
      }
    }
  }
  
  static JdkApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig paramApplicationProtocolConfig, boolean paramBoolean)
  {
    if (paramApplicationProtocolConfig == null) {
      return JdkDefaultApplicationProtocolNegotiator.INSTANCE;
    }
    int i = 1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[paramApplicationProtocolConfig.protocol().ordinal()];
    if (i != 1)
    {
      StringBuilder localStringBuilder;
      if (i != 2)
      {
        if (i == 3)
        {
          if (paramBoolean)
          {
            i = 1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[paramApplicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
            if (i != 1)
            {
              if (i == 2) {
                return new JdkNpnApplicationProtocolNegotiator(true, paramApplicationProtocolConfig.supportedProtocols());
              }
              localStringBuilder = new StringBuilder("JDK provider does not support ");
              localStringBuilder.append(paramApplicationProtocolConfig.selectedListenerFailureBehavior());
              localStringBuilder.append(" failure behavior");
              throw new UnsupportedOperationException(localStringBuilder.toString());
            }
            return new JdkNpnApplicationProtocolNegotiator(false, paramApplicationProtocolConfig.supportedProtocols());
          }
          i = 1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[paramApplicationProtocolConfig.selectorFailureBehavior().ordinal()];
          if (i != 1)
          {
            if (i == 2) {
              return new JdkNpnApplicationProtocolNegotiator(false, paramApplicationProtocolConfig.supportedProtocols());
            }
            localStringBuilder = new StringBuilder("JDK provider does not support ");
            localStringBuilder.append(paramApplicationProtocolConfig.selectorFailureBehavior());
            localStringBuilder.append(" failure behavior");
            throw new UnsupportedOperationException(localStringBuilder.toString());
          }
          return new JdkNpnApplicationProtocolNegotiator(true, paramApplicationProtocolConfig.supportedProtocols());
        }
        localStringBuilder = new StringBuilder("JDK provider does not support ");
        localStringBuilder.append(paramApplicationProtocolConfig.protocol());
        localStringBuilder.append(" protocol");
        throw new UnsupportedOperationException(localStringBuilder.toString());
      }
      if (paramBoolean)
      {
        i = 1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[paramApplicationProtocolConfig.selectorFailureBehavior().ordinal()];
        if (i != 1)
        {
          if (i == 2) {
            return new JdkAlpnApplicationProtocolNegotiator(false, paramApplicationProtocolConfig.supportedProtocols());
          }
          localStringBuilder = new StringBuilder("JDK provider does not support ");
          localStringBuilder.append(paramApplicationProtocolConfig.selectorFailureBehavior());
          localStringBuilder.append(" failure behavior");
          throw new UnsupportedOperationException(localStringBuilder.toString());
        }
        return new JdkAlpnApplicationProtocolNegotiator(true, paramApplicationProtocolConfig.supportedProtocols());
      }
      i = 1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[paramApplicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          return new JdkAlpnApplicationProtocolNegotiator(true, paramApplicationProtocolConfig.supportedProtocols());
        }
        localStringBuilder = new StringBuilder("JDK provider does not support ");
        localStringBuilder.append(paramApplicationProtocolConfig.selectedListenerFailureBehavior());
        localStringBuilder.append(" failure behavior");
        throw new UnsupportedOperationException(localStringBuilder.toString());
      }
      return new JdkAlpnApplicationProtocolNegotiator(false, paramApplicationProtocolConfig.supportedProtocols());
    }
    return JdkDefaultApplicationProtocolNegotiator.INSTANCE;
  }
  
  public final JdkApplicationProtocolNegotiator applicationProtocolNegotiator()
  {
    return this.apn;
  }
  
  public final List<String> cipherSuites()
  {
    return this.unmodifiableCipherSuites;
  }
  
  public final SSLContext context()
  {
    return this.sslContext;
  }
  
  public final boolean isClient()
  {
    return this.isClient;
  }
  
  public final SSLEngine newEngine(ByteBufAllocator paramByteBufAllocator)
  {
    return configureAndWrapEngine(context().createSSLEngine(), paramByteBufAllocator);
  }
  
  public final SSLEngine newEngine(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt)
  {
    return configureAndWrapEngine(context().createSSLEngine(paramString, paramInt), paramByteBufAllocator);
  }
  
  public final long sessionCacheSize()
  {
    return sessionContext().getSessionCacheSize();
  }
  
  public final SSLSessionContext sessionContext()
  {
    if (isServer()) {
      return context().getServerSessionContext();
    }
    return context().getClientSessionContext();
  }
  
  public final long sessionTimeout()
  {
    return sessionContext().getSessionTimeout();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JdkSslContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */