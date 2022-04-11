package io.netty.handler.ssl;

import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public final class ReferenceCountedOpenSslClientContext
  extends ReferenceCountedOpenSslContext
{
  private static final boolean ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.client.enableSessionTicketExtension", false);
  private static final Set<String> SUPPORTED_KEY_TYPES;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslClientContext.class);
  private final OpenSslSessionContext sessionContext;
  
  static
  {
    SUPPORTED_KEY_TYPES = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(new String[] { "RSA", "DH_RSA", "EC", "EC_RSA", "EC_EC" })));
  }
  
  ReferenceCountedOpenSslClientContext(X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, String[] paramArrayOfString, long paramLong1, long paramLong2, boolean paramBoolean, String paramString2)
    throws SSLException
  {
    super(paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2, 0, paramArrayOfX509Certificate2, ClientAuth.NONE, paramArrayOfString, false, paramBoolean, true);
    try
    {
      paramArrayOfX509Certificate1 = newSessionContext(this, this.ctx, this.engineMap, paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramString2);
      this.sessionContext = paramArrayOfX509Certificate1;
      if (ENABLE_SESSION_TICKET) {
        paramArrayOfX509Certificate1.setTicketKeys(new OpenSslSessionTicketKey[0]);
      }
      return;
    }
    finally
    {
      release();
    }
  }
  
  /* Error */
  static OpenSslSessionContext newSessionContext(ReferenceCountedOpenSslContext paramReferenceCountedOpenSslContext, long paramLong, OpenSslEngineMap paramOpenSslEngineMap, X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, String paramString2)
    throws SSLException
  {
    // Byte code:
    //   0: aload 7
    //   2: ifnonnull +8 -> 10
    //   5: aload 6
    //   7: ifnonnull +16 -> 23
    //   10: aload 7
    //   12: ifnull +21 -> 33
    //   15: aload 6
    //   17: ifnull +6 -> 23
    //   20: goto +13 -> 33
    //   23: new 127	java/lang/IllegalArgumentException
    //   26: dup
    //   27: ldc -127
    //   29: invokespecial 132	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   32: athrow
    //   33: aconst_null
    //   34: astore 11
    //   36: aconst_null
    //   37: astore 12
    //   39: aload 12
    //   41: astore 13
    //   43: invokestatic 137	io/netty/handler/ssl/OpenSsl:useKeyManagerFactory	()Z
    //   46: ifne +57 -> 103
    //   49: aload 9
    //   51: ifnonnull +28 -> 79
    //   54: aload 6
    //   56: ifnull +17 -> 73
    //   59: aload 12
    //   61: astore 13
    //   63: lload_1
    //   64: aload 6
    //   66: aload 7
    //   68: aload 8
    //   70: invokestatic 141	io/netty/handler/ssl/ReferenceCountedOpenSslContext:setKeyMaterial	(J[Ljava/security/cert/X509Certificate;Ljava/security/PrivateKey;Ljava/lang/String;)V
    //   73: aconst_null
    //   74: astore 8
    //   76: goto +257 -> 333
    //   79: aload 12
    //   81: astore 13
    //   83: new 127	java/lang/IllegalArgumentException
    //   86: astore_0
    //   87: aload 12
    //   89: astore 13
    //   91: aload_0
    //   92: ldc -113
    //   94: invokespecial 132	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   97: aload 12
    //   99: astore 13
    //   101: aload_0
    //   102: athrow
    //   103: aload 9
    //   105: ifnonnull +122 -> 227
    //   108: aload 6
    //   110: ifnull +117 -> 227
    //   113: aload 12
    //   115: astore 13
    //   117: aload 8
    //   119: invokestatic 149	io/netty/handler/ssl/SslContext:keyStorePassword	(Ljava/lang/String;)[C
    //   122: astore 9
    //   124: aload 12
    //   126: astore 13
    //   128: aload 6
    //   130: aload 7
    //   132: aload 9
    //   134: aload 10
    //   136: invokestatic 153	io/netty/handler/ssl/SslContext:buildKeyStore	([Ljava/security/cert/X509Certificate;Ljava/security/PrivateKey;[CLjava/lang/String;)Ljava/security/KeyStore;
    //   139: astore 7
    //   141: aload 12
    //   143: astore 13
    //   145: aload 7
    //   147: invokevirtual 159	java/security/KeyStore:aliases	()Ljava/util/Enumeration;
    //   150: invokeinterface 164 1 0
    //   155: ifeq +24 -> 179
    //   158: aload 12
    //   160: astore 13
    //   162: new 166	io/netty/handler/ssl/OpenSslX509KeyManagerFactory
    //   165: astore 6
    //   167: aload 12
    //   169: astore 13
    //   171: aload 6
    //   173: invokespecial 168	io/netty/handler/ssl/OpenSslX509KeyManagerFactory:<init>	()V
    //   176: goto +22 -> 198
    //   179: aload 12
    //   181: astore 13
    //   183: new 170	io/netty/handler/ssl/OpenSslCachingX509KeyManagerFactory
    //   186: dup
    //   187: invokestatic 176	javax/net/ssl/KeyManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   190: invokestatic 179	javax/net/ssl/KeyManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/KeyManagerFactory;
    //   193: invokespecial 182	io/netty/handler/ssl/OpenSslCachingX509KeyManagerFactory:<init>	(Ljavax/net/ssl/KeyManagerFactory;)V
    //   196: astore 6
    //   198: aload 12
    //   200: astore 13
    //   202: aload 6
    //   204: aload 7
    //   206: aload 9
    //   208: invokevirtual 186	javax/net/ssl/KeyManagerFactory:init	(Ljava/security/KeyStore;[C)V
    //   211: aload 12
    //   213: astore 13
    //   215: aload 6
    //   217: aload 8
    //   219: invokestatic 190	io/netty/handler/ssl/ReferenceCountedOpenSslContext:providerFor	(Ljavax/net/ssl/KeyManagerFactory;Ljava/lang/String;)Lio/netty/handler/ssl/OpenSslKeyMaterialProvider;
    //   222: astore 6
    //   224: goto +27 -> 251
    //   227: aload 9
    //   229: ifnull +19 -> 248
    //   232: aload 12
    //   234: astore 13
    //   236: aload 9
    //   238: aload 8
    //   240: invokestatic 190	io/netty/handler/ssl/ReferenceCountedOpenSslContext:providerFor	(Ljavax/net/ssl/KeyManagerFactory;Ljava/lang/String;)Lio/netty/handler/ssl/OpenSslKeyMaterialProvider;
    //   243: astore 6
    //   245: goto +6 -> 251
    //   248: aconst_null
    //   249: astore 6
    //   251: aload 6
    //   253: astore 8
    //   255: aload 6
    //   257: ifnull +76 -> 333
    //   260: aload 6
    //   262: astore 7
    //   264: new 192	io/netty/handler/ssl/OpenSslKeyMaterialManager
    //   267: astore 8
    //   269: aload 6
    //   271: astore 7
    //   273: aload 8
    //   275: aload 6
    //   277: invokespecial 195	io/netty/handler/ssl/OpenSslKeyMaterialManager:<init>	(Lio/netty/handler/ssl/OpenSslKeyMaterialProvider;)V
    //   280: aload 6
    //   282: astore 7
    //   284: new 9	io/netty/handler/ssl/ReferenceCountedOpenSslClientContext$OpenSslClientCertificateCallback
    //   287: astore 9
    //   289: aload 6
    //   291: astore 7
    //   293: aload 9
    //   295: aload_3
    //   296: aload 8
    //   298: invokespecial 198	io/netty/handler/ssl/ReferenceCountedOpenSslClientContext$OpenSslClientCertificateCallback:<init>	(Lio/netty/handler/ssl/OpenSslEngineMap;Lio/netty/handler/ssl/OpenSslKeyMaterialManager;)V
    //   301: aload 6
    //   303: astore 7
    //   305: lload_1
    //   306: aload 9
    //   308: invokestatic 204	io/netty/internal/tcnative/SSLContext:setCertificateCallback	(JLio/netty/internal/tcnative/CertificateCallback;)V
    //   311: aload 6
    //   313: astore 8
    //   315: goto +18 -> 333
    //   318: astore_0
    //   319: aload 7
    //   321: astore 13
    //   323: goto +183 -> 506
    //   326: astore_3
    //   327: aload 6
    //   329: astore_0
    //   330: goto +151 -> 481
    //   333: aload 8
    //   335: astore 7
    //   337: lload_1
    //   338: iconst_1
    //   339: bipush 10
    //   341: invokestatic 208	io/netty/internal/tcnative/SSLContext:setVerify	(JII)V
    //   344: aload 4
    //   346: ifnull +25 -> 371
    //   349: aload 8
    //   351: astore 7
    //   353: aload 4
    //   355: aload 5
    //   357: aload 10
    //   359: invokestatic 212	io/netty/handler/ssl/SslContext:buildTrustManagerFactory	([Ljava/security/cert/X509Certificate;Ljavax/net/ssl/TrustManagerFactory;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   362: astore 4
    //   364: goto +38 -> 402
    //   367: astore_3
    //   368: goto +66 -> 434
    //   371: aload 5
    //   373: astore 4
    //   375: aload 5
    //   377: ifnonnull +25 -> 402
    //   380: aload 8
    //   382: astore 7
    //   384: invokestatic 215	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   387: invokestatic 218	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   390: astore 4
    //   392: aload 8
    //   394: astore 7
    //   396: aload 4
    //   398: aconst_null
    //   399: invokevirtual 221	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   402: aload 8
    //   404: astore 7
    //   406: lload_1
    //   407: aload_3
    //   408: aload 4
    //   410: invokevirtual 225	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   413: invokestatic 229	io/netty/handler/ssl/ReferenceCountedOpenSslContext:chooseTrustManager	([Ljavax/net/ssl/TrustManager;)Ljavax/net/ssl/X509TrustManager;
    //   416: invokestatic 233	io/netty/handler/ssl/ReferenceCountedOpenSslClientContext:setVerifyCallback	(JLio/netty/handler/ssl/OpenSslEngineMap;Ljavax/net/ssl/X509TrustManager;)V
    //   419: aload 8
    //   421: astore 7
    //   423: new 12	io/netty/handler/ssl/ReferenceCountedOpenSslClientContext$OpenSslClientSessionContext
    //   426: dup
    //   427: aload_0
    //   428: aload 8
    //   430: invokespecial 236	io/netty/handler/ssl/ReferenceCountedOpenSslClientContext$OpenSslClientSessionContext:<init>	(Lio/netty/handler/ssl/ReferenceCountedOpenSslContext;Lio/netty/handler/ssl/OpenSslKeyMaterialProvider;)V
    //   433: areturn
    //   434: aload 8
    //   436: ifnull +12 -> 448
    //   439: aload 8
    //   441: astore 7
    //   443: aload 8
    //   445: invokevirtual 241	io/netty/handler/ssl/OpenSslKeyMaterialProvider:destroy	()V
    //   448: aload 8
    //   450: astore 7
    //   452: new 81	javax/net/ssl/SSLException
    //   455: astore_0
    //   456: aload 8
    //   458: astore 7
    //   460: aload_0
    //   461: ldc -13
    //   463: aload_3
    //   464: invokespecial 246	javax/net/ssl/SSLException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   467: aload 8
    //   469: astore 7
    //   471: aload_0
    //   472: athrow
    //   473: astore_0
    //   474: goto +32 -> 506
    //   477: astore_3
    //   478: aload 11
    //   480: astore_0
    //   481: aload_0
    //   482: astore 13
    //   484: new 81	javax/net/ssl/SSLException
    //   487: astore 4
    //   489: aload_0
    //   490: astore 13
    //   492: aload 4
    //   494: ldc -8
    //   496: aload_3
    //   497: invokespecial 246	javax/net/ssl/SSLException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   500: aload_0
    //   501: astore 13
    //   503: aload 4
    //   505: athrow
    //   506: aload 13
    //   508: ifnull +8 -> 516
    //   511: aload 13
    //   513: invokevirtual 241	io/netty/handler/ssl/OpenSslKeyMaterialProvider:destroy	()V
    //   516: aload_0
    //   517: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	paramReferenceCountedOpenSslContext	ReferenceCountedOpenSslContext
    //   0	518	1	paramLong	long
    //   0	518	3	paramOpenSslEngineMap	OpenSslEngineMap
    //   0	518	4	paramArrayOfX509Certificate1	X509Certificate[]
    //   0	518	5	paramTrustManagerFactory	TrustManagerFactory
    //   0	518	6	paramArrayOfX509Certificate2	X509Certificate[]
    //   0	518	7	paramPrivateKey	PrivateKey
    //   0	518	8	paramString1	String
    //   0	518	9	paramKeyManagerFactory	KeyManagerFactory
    //   0	518	10	paramString2	String
    //   34	445	11	localObject1	Object
    //   37	196	12	localObject2	Object
    //   41	471	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   264	269	318	finally
    //   273	280	318	finally
    //   284	289	318	finally
    //   293	301	318	finally
    //   305	311	318	finally
    //   337	344	318	finally
    //   353	364	318	finally
    //   384	392	318	finally
    //   396	402	318	finally
    //   406	419	318	finally
    //   423	434	318	finally
    //   443	448	318	finally
    //   452	456	318	finally
    //   460	467	318	finally
    //   471	473	318	finally
    //   264	269	326	java/lang/Exception
    //   273	280	326	java/lang/Exception
    //   284	289	326	java/lang/Exception
    //   293	301	326	java/lang/Exception
    //   305	311	326	java/lang/Exception
    //   353	364	367	java/lang/Exception
    //   384	392	367	java/lang/Exception
    //   396	402	367	java/lang/Exception
    //   406	419	367	java/lang/Exception
    //   43	49	473	finally
    //   63	73	473	finally
    //   83	87	473	finally
    //   91	97	473	finally
    //   101	103	473	finally
    //   117	124	473	finally
    //   128	141	473	finally
    //   145	158	473	finally
    //   162	167	473	finally
    //   171	176	473	finally
    //   183	198	473	finally
    //   202	211	473	finally
    //   215	224	473	finally
    //   236	245	473	finally
    //   484	489	473	finally
    //   492	500	473	finally
    //   503	506	473	finally
    //   43	49	477	java/lang/Exception
    //   63	73	477	java/lang/Exception
    //   83	87	477	java/lang/Exception
    //   91	97	477	java/lang/Exception
    //   101	103	477	java/lang/Exception
    //   117	124	477	java/lang/Exception
    //   128	141	477	java/lang/Exception
    //   145	158	477	java/lang/Exception
    //   162	167	477	java/lang/Exception
    //   171	176	477	java/lang/Exception
    //   183	198	477	java/lang/Exception
    //   202	211	477	java/lang/Exception
    //   215	224	477	java/lang/Exception
    //   236	245	477	java/lang/Exception
  }
  
  @SuppressJava6Requirement(reason="Guarded by java version check")
  private static void setVerifyCallback(long paramLong, OpenSslEngineMap paramOpenSslEngineMap, X509TrustManager paramX509TrustManager)
  {
    if (ReferenceCountedOpenSslContext.useExtendedTrustManager(paramX509TrustManager)) {
      SSLContext.setCertVerifyCallback(paramLong, new ExtendedTrustManagerVerifyCallback(paramOpenSslEngineMap, (X509ExtendedTrustManager)paramX509TrustManager));
    } else {
      SSLContext.setCertVerifyCallback(paramLong, new TrustManagerVerifyCallback(paramOpenSslEngineMap, paramX509TrustManager));
    }
  }
  
  public OpenSslSessionContext sessionContext()
  {
    return this.sessionContext;
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  private static final class ExtendedTrustManagerVerifyCallback
    extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier
  {
    private final X509ExtendedTrustManager manager;
    
    ExtendedTrustManagerVerifyCallback(OpenSslEngineMap paramOpenSslEngineMap, X509ExtendedTrustManager paramX509ExtendedTrustManager)
    {
      super();
      this.manager = OpenSslTlsv13X509ExtendedTrustManager.wrap(paramX509ExtendedTrustManager);
    }
    
    void verify(ReferenceCountedOpenSslEngine paramReferenceCountedOpenSslEngine, X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws Exception
    {
      this.manager.checkServerTrusted(paramArrayOfX509Certificate, paramString, paramReferenceCountedOpenSslEngine);
    }
  }
  
  private static final class OpenSslClientCertificateCallback
    implements CertificateCallback
  {
    private final OpenSslEngineMap engineMap;
    private final OpenSslKeyMaterialManager keyManagerHolder;
    
    OpenSslClientCertificateCallback(OpenSslEngineMap paramOpenSslEngineMap, OpenSslKeyMaterialManager paramOpenSslKeyMaterialManager)
    {
      this.engineMap = paramOpenSslEngineMap;
      this.keyManagerHolder = paramOpenSslKeyMaterialManager;
    }
    
    private static String clientKeyType(byte paramByte)
    {
      if (paramByte != 1)
      {
        if (paramByte != 3)
        {
          switch (paramByte)
          {
          default: 
            return null;
          case 66: 
            return "EC_EC";
          case 65: 
            return "EC_RSA";
          }
          return "EC";
        }
        return "DH_RSA";
      }
      return "RSA";
    }
    
    private static Set<String> supportedClientKeyTypes(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        return ReferenceCountedOpenSslClientContext.SUPPORTED_KEY_TYPES;
      }
      HashSet localHashSet = new HashSet(paramArrayOfByte.length);
      int i = paramArrayOfByte.length;
      for (int j = 0; j < i; j++)
      {
        String str = clientKeyType(paramArrayOfByte[j]);
        if (str != null) {
          localHashSet.add(str);
        }
      }
      return localHashSet;
    }
    
    public void handle(long paramLong, byte[] paramArrayOfByte, byte[][] paramArrayOfByte1)
      throws Exception
    {
      ReferenceCountedOpenSslEngine localReferenceCountedOpenSslEngine = this.engineMap.get(paramLong);
      if (localReferenceCountedOpenSslEngine == null) {
        return;
      }
      try
      {
        paramArrayOfByte = supportedClientKeyTypes(paramArrayOfByte);
        int i = 0;
        String[] arrayOfString = (String[])paramArrayOfByte.toArray(new String[0]);
        if (paramArrayOfByte1 == null)
        {
          paramArrayOfByte = null;
        }
        else
        {
          paramArrayOfByte = new X500Principal[paramArrayOfByte1.length];
          while (i < paramArrayOfByte1.length)
          {
            paramArrayOfByte[i] = new X500Principal(paramArrayOfByte1[i]);
            i++;
          }
        }
        this.keyManagerHolder.setKeyMaterialClientSide(localReferenceCountedOpenSslEngine, arrayOfString, paramArrayOfByte);
      }
      finally
      {
        ReferenceCountedOpenSslClientContext.logger.debug("request of key failed", paramArrayOfByte);
        localReferenceCountedOpenSslEngine.initHandshakeException(paramArrayOfByte);
      }
    }
  }
  
  static final class OpenSslClientSessionContext
    extends OpenSslSessionContext
  {
    OpenSslClientSessionContext(ReferenceCountedOpenSslContext paramReferenceCountedOpenSslContext, OpenSslKeyMaterialProvider paramOpenSslKeyMaterialProvider)
    {
      super(paramOpenSslKeyMaterialProvider);
    }
    
    public int getSessionCacheSize()
    {
      return 0;
    }
    
    public int getSessionTimeout()
    {
      return 0;
    }
    
    public boolean isSessionCacheEnabled()
    {
      return false;
    }
    
    public void setSessionCacheEnabled(boolean paramBoolean) {}
    
    public void setSessionCacheSize(int paramInt)
    {
      if (paramInt >= 0) {
        return;
      }
      throw new IllegalArgumentException();
    }
    
    public void setSessionTimeout(int paramInt)
    {
      if (paramInt >= 0) {
        return;
      }
      throw new IllegalArgumentException();
    }
  }
  
  private static final class TrustManagerVerifyCallback
    extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier
  {
    private final X509TrustManager manager;
    
    TrustManagerVerifyCallback(OpenSslEngineMap paramOpenSslEngineMap, X509TrustManager paramX509TrustManager)
    {
      super();
      this.manager = paramX509TrustManager;
    }
    
    void verify(ReferenceCountedOpenSslEngine paramReferenceCountedOpenSslEngine, X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws Exception
    {
      this.manager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\ReferenceCountedOpenSslClientContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */