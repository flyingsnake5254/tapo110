package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public final class SslContextBuilder
{
  private ApplicationProtocolConfig apn;
  private CipherSuiteFilter cipherFilter = IdentityCipherSuiteFilter.INSTANCE;
  private Iterable<String> ciphers;
  private ClientAuth clientAuth = ClientAuth.NONE;
  private boolean enableOcsp;
  private final boolean forServer;
  private PrivateKey key;
  private X509Certificate[] keyCertChain;
  private KeyManagerFactory keyManagerFactory;
  private String keyPassword;
  private String keyStoreType = KeyStore.getDefaultType();
  private String[] protocols;
  private SslProvider provider;
  private long sessionCacheSize;
  private long sessionTimeout;
  private Provider sslContextProvider;
  private boolean startTls;
  private X509Certificate[] trustCertCollection;
  private TrustManagerFactory trustManagerFactory;
  
  private SslContextBuilder(boolean paramBoolean)
  {
    this.forServer = paramBoolean;
  }
  
  public static SslContextBuilder forClient()
  {
    return new SslContextBuilder(false);
  }
  
  public static SslContextBuilder forServer(File paramFile1, File paramFile2)
  {
    return new SslContextBuilder(true).keyManager(paramFile1, paramFile2);
  }
  
  public static SslContextBuilder forServer(File paramFile1, File paramFile2, String paramString)
  {
    return new SslContextBuilder(true).keyManager(paramFile1, paramFile2, paramString);
  }
  
  public static SslContextBuilder forServer(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    return new SslContextBuilder(true).keyManager(paramInputStream1, paramInputStream2);
  }
  
  public static SslContextBuilder forServer(InputStream paramInputStream1, InputStream paramInputStream2, String paramString)
  {
    return new SslContextBuilder(true).keyManager(paramInputStream1, paramInputStream2, paramString);
  }
  
  public static SslContextBuilder forServer(PrivateKey paramPrivateKey, Iterable<? extends X509Certificate> paramIterable)
  {
    return forServer(paramPrivateKey, (X509Certificate[])toArray(paramIterable, EmptyArrays.EMPTY_X509_CERTIFICATES));
  }
  
  public static SslContextBuilder forServer(PrivateKey paramPrivateKey, String paramString, Iterable<? extends X509Certificate> paramIterable)
  {
    return forServer(paramPrivateKey, paramString, (X509Certificate[])toArray(paramIterable, EmptyArrays.EMPTY_X509_CERTIFICATES));
  }
  
  public static SslContextBuilder forServer(PrivateKey paramPrivateKey, String paramString, X509Certificate... paramVarArgs)
  {
    return new SslContextBuilder(true).keyManager(paramPrivateKey, paramString, paramVarArgs);
  }
  
  public static SslContextBuilder forServer(PrivateKey paramPrivateKey, X509Certificate... paramVarArgs)
  {
    return new SslContextBuilder(true).keyManager(paramPrivateKey, paramVarArgs);
  }
  
  public static SslContextBuilder forServer(KeyManager paramKeyManager)
  {
    return new SslContextBuilder(true).keyManager(paramKeyManager);
  }
  
  public static SslContextBuilder forServer(KeyManagerFactory paramKeyManagerFactory)
  {
    return new SslContextBuilder(true).keyManager(paramKeyManagerFactory);
  }
  
  private static <T> T[] toArray(Iterable<? extends T> paramIterable, T[] paramArrayOfT)
  {
    if (paramIterable == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(paramIterable.next());
    }
    return localArrayList.toArray(paramArrayOfT);
  }
  
  public SslContextBuilder applicationProtocolConfig(ApplicationProtocolConfig paramApplicationProtocolConfig)
  {
    this.apn = paramApplicationProtocolConfig;
    return this;
  }
  
  public SslContext build()
    throws SSLException
  {
    if (this.forServer) {
      return SslContext.newServerContextInternal(this.provider, this.sslContextProvider, this.trustCertCollection, this.trustManagerFactory, this.keyCertChain, this.key, this.keyPassword, this.keyManagerFactory, this.ciphers, this.cipherFilter, this.apn, this.sessionCacheSize, this.sessionTimeout, this.clientAuth, this.protocols, this.startTls, this.enableOcsp, this.keyStoreType);
    }
    return SslContext.newClientContextInternal(this.provider, this.sslContextProvider, this.trustCertCollection, this.trustManagerFactory, this.keyCertChain, this.key, this.keyPassword, this.keyManagerFactory, this.ciphers, this.cipherFilter, this.apn, this.protocols, this.sessionCacheSize, this.sessionTimeout, this.enableOcsp, this.keyStoreType);
  }
  
  public SslContextBuilder ciphers(Iterable<String> paramIterable)
  {
    return ciphers(paramIterable, IdentityCipherSuiteFilter.INSTANCE);
  }
  
  public SslContextBuilder ciphers(Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter)
  {
    this.cipherFilter = ((CipherSuiteFilter)ObjectUtil.checkNotNull(paramCipherSuiteFilter, "cipherFilter"));
    this.ciphers = paramIterable;
    return this;
  }
  
  public SslContextBuilder clientAuth(ClientAuth paramClientAuth)
  {
    this.clientAuth = ((ClientAuth)ObjectUtil.checkNotNull(paramClientAuth, "clientAuth"));
    return this;
  }
  
  public SslContextBuilder enableOcsp(boolean paramBoolean)
  {
    this.enableOcsp = paramBoolean;
    return this;
  }
  
  public SslContextBuilder keyManager(File paramFile1, File paramFile2)
  {
    return keyManager(paramFile1, paramFile2, null);
  }
  
  /* Error */
  public SslContextBuilder keyManager(File paramFile1, File paramFile2, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 217	io/netty/handler/ssl/SslContext:toX509Certificates	(Ljava/io/File;)[Ljava/security/cert/X509Certificate;
    //   4: astore 4
    //   6: aload_2
    //   7: aload_3
    //   8: invokestatic 221	io/netty/handler/ssl/SslContext:toPrivateKey	(Ljava/io/File;Ljava/lang/String;)Ljava/security/PrivateKey;
    //   11: astore_1
    //   12: aload_0
    //   13: aload_1
    //   14: aload_3
    //   15: aload 4
    //   17: invokevirtual 109	io/netty/handler/ssl/SslContextBuilder:keyManager	(Ljava/security/PrivateKey;Ljava/lang/String;[Ljava/security/cert/X509Certificate;)Lio/netty/handler/ssl/SslContextBuilder;
    //   20: areturn
    //   21: astore_1
    //   22: new 223	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   29: astore_3
    //   30: aload_3
    //   31: ldc -30
    //   33: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: aload_2
    //   39: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: new 235	java/lang/IllegalArgumentException
    //   46: dup
    //   47: aload_3
    //   48: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: aload_1
    //   52: invokespecial 241	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   55: athrow
    //   56: astore_2
    //   57: new 223	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   64: astore_3
    //   65: aload_3
    //   66: ldc -13
    //   68: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_3
    //   73: aload_1
    //   74: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: new 235	java/lang/IllegalArgumentException
    //   81: dup
    //   82: aload_3
    //   83: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: aload_2
    //   87: invokespecial 241	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	SslContextBuilder
    //   0	91	1	paramFile1	File
    //   0	91	2	paramFile2	File
    //   0	91	3	paramString	String
    //   4	12	4	arrayOfX509Certificate	X509Certificate[]
    // Exception table:
    //   from	to	target	type
    //   6	12	21	java/lang/Exception
    //   0	6	56	java/lang/Exception
  }
  
  public SslContextBuilder keyManager(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    return keyManager(paramInputStream1, paramInputStream2, null);
  }
  
  /* Error */
  public SslContextBuilder keyManager(InputStream paramInputStream1, InputStream paramInputStream2, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 246	io/netty/handler/ssl/SslContext:toX509Certificates	(Ljava/io/InputStream;)[Ljava/security/cert/X509Certificate;
    //   4: astore_1
    //   5: aload_2
    //   6: aload_3
    //   7: invokestatic 249	io/netty/handler/ssl/SslContext:toPrivateKey	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/security/PrivateKey;
    //   10: astore_2
    //   11: aload_0
    //   12: aload_2
    //   13: aload_3
    //   14: aload_1
    //   15: invokevirtual 109	io/netty/handler/ssl/SslContextBuilder:keyManager	(Ljava/security/PrivateKey;Ljava/lang/String;[Ljava/security/cert/X509Certificate;)Lio/netty/handler/ssl/SslContextBuilder;
    //   18: areturn
    //   19: astore_1
    //   20: new 235	java/lang/IllegalArgumentException
    //   23: dup
    //   24: ldc -5
    //   26: aload_1
    //   27: invokespecial 241	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   30: athrow
    //   31: astore_1
    //   32: new 235	java/lang/IllegalArgumentException
    //   35: dup
    //   36: ldc -3
    //   38: aload_1
    //   39: invokespecial 241	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	SslContextBuilder
    //   0	43	1	paramInputStream1	InputStream
    //   0	43	2	paramInputStream2	InputStream
    //   0	43	3	paramString	String
    // Exception table:
    //   from	to	target	type
    //   5	11	19	java/lang/Exception
    //   0	5	31	java/lang/Exception
  }
  
  public SslContextBuilder keyManager(PrivateKey paramPrivateKey, Iterable<? extends X509Certificate> paramIterable)
  {
    return keyManager(paramPrivateKey, (X509Certificate[])toArray(paramIterable, EmptyArrays.EMPTY_X509_CERTIFICATES));
  }
  
  public SslContextBuilder keyManager(PrivateKey paramPrivateKey, String paramString, Iterable<? extends X509Certificate> paramIterable)
  {
    return keyManager(paramPrivateKey, paramString, (X509Certificate[])toArray(paramIterable, EmptyArrays.EMPTY_X509_CERTIFICATES));
  }
  
  public SslContextBuilder keyManager(PrivateKey paramPrivateKey, String paramString, X509Certificate... paramVarArgs)
  {
    if (this.forServer)
    {
      ObjectUtil.checkNotNull(paramVarArgs, "keyCertChain required for servers");
      if (paramVarArgs.length != 0) {
        ObjectUtil.checkNotNull(paramPrivateKey, "key required for servers");
      } else {
        throw new IllegalArgumentException("keyCertChain must be non-empty");
      }
    }
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      int i = paramVarArgs.length;
      int j = 0;
      while (j < i) {
        if (paramVarArgs[j] != null) {
          j++;
        } else {
          throw new IllegalArgumentException("keyCertChain contains null entry");
        }
      }
      this.keyCertChain = ((X509Certificate[])paramVarArgs.clone());
    }
    else
    {
      this.keyCertChain = null;
    }
    this.key = paramPrivateKey;
    this.keyPassword = paramString;
    this.keyManagerFactory = null;
    return this;
  }
  
  public SslContextBuilder keyManager(PrivateKey paramPrivateKey, X509Certificate... paramVarArgs)
  {
    return keyManager(paramPrivateKey, null, paramVarArgs);
  }
  
  public SslContextBuilder keyManager(KeyManager paramKeyManager)
  {
    if (this.forServer) {
      ObjectUtil.checkNotNull(paramKeyManager, "keyManager required for servers");
    }
    if (paramKeyManager != null) {
      this.keyManagerFactory = new KeyManagerFactoryWrapper(paramKeyManager);
    } else {
      this.keyManagerFactory = null;
    }
    this.keyCertChain = null;
    this.key = null;
    this.keyPassword = null;
    return this;
  }
  
  public SslContextBuilder keyManager(KeyManagerFactory paramKeyManagerFactory)
  {
    if (this.forServer) {
      ObjectUtil.checkNotNull(paramKeyManagerFactory, "keyManagerFactory required for servers");
    }
    this.keyCertChain = null;
    this.key = null;
    this.keyPassword = null;
    this.keyManagerFactory = paramKeyManagerFactory;
    return this;
  }
  
  public SslContextBuilder keyStoreType(String paramString)
  {
    this.keyStoreType = paramString;
    return this;
  }
  
  public SslContextBuilder protocols(Iterable<String> paramIterable)
  {
    return protocols((String[])toArray(paramIterable, EmptyArrays.EMPTY_STRINGS));
  }
  
  public SslContextBuilder protocols(String... paramVarArgs)
  {
    if (paramVarArgs == null) {
      paramVarArgs = null;
    } else {
      paramVarArgs = (String[])paramVarArgs.clone();
    }
    this.protocols = paramVarArgs;
    return this;
  }
  
  public SslContextBuilder sessionCacheSize(long paramLong)
  {
    this.sessionCacheSize = paramLong;
    return this;
  }
  
  public SslContextBuilder sessionTimeout(long paramLong)
  {
    this.sessionTimeout = paramLong;
    return this;
  }
  
  public SslContextBuilder sslContextProvider(Provider paramProvider)
  {
    this.sslContextProvider = paramProvider;
    return this;
  }
  
  public SslContextBuilder sslProvider(SslProvider paramSslProvider)
  {
    this.provider = paramSslProvider;
    return this;
  }
  
  public SslContextBuilder startTls(boolean paramBoolean)
  {
    this.startTls = paramBoolean;
    return this;
  }
  
  public SslContextBuilder trustManager(File paramFile)
  {
    try
    {
      localObject = trustManager(SslContext.toX509Certificates(paramFile));
      return (SslContextBuilder)localObject;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("File does not contain valid certificates: ");
      ((StringBuilder)localObject).append(paramFile);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString(), localException);
    }
  }
  
  public SslContextBuilder trustManager(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = trustManager(SslContext.toX509Certificates(paramInputStream));
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      throw new IllegalArgumentException("Input stream does not contain valid certificates.", paramInputStream);
    }
  }
  
  public SslContextBuilder trustManager(Iterable<? extends X509Certificate> paramIterable)
  {
    return trustManager((X509Certificate[])toArray(paramIterable, EmptyArrays.EMPTY_X509_CERTIFICATES));
  }
  
  public SslContextBuilder trustManager(TrustManager paramTrustManager)
  {
    this.trustManagerFactory = new TrustManagerFactoryWrapper(paramTrustManager);
    this.trustCertCollection = null;
    return this;
  }
  
  public SslContextBuilder trustManager(TrustManagerFactory paramTrustManagerFactory)
  {
    this.trustCertCollection = null;
    this.trustManagerFactory = paramTrustManagerFactory;
    return this;
  }
  
  public SslContextBuilder trustManager(X509Certificate... paramVarArgs)
  {
    if (paramVarArgs != null) {
      paramVarArgs = (X509Certificate[])paramVarArgs.clone();
    } else {
      paramVarArgs = null;
    }
    this.trustCertCollection = paramVarArgs;
    this.trustManagerFactory = null;
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SslContextBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */