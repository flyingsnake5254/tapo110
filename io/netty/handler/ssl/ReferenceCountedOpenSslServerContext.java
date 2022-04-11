package io.netty.handler.ssl;

import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SniHostNameMatcher;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

public final class ReferenceCountedOpenSslServerContext
  extends ReferenceCountedOpenSslContext
{
  private static final boolean ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.server.enableSessionTicketExtension", false);
  private static final byte[] ID;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslServerContext.class);
  private final OpenSslServerSessionContext sessionContext;
  
  static
  {
    ID = new byte[] { 110, 101, 116, 116, 121 };
  }
  
  ReferenceCountedOpenSslServerContext(X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2, ClientAuth paramClientAuth, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
    throws SSLException
  {
    this(paramArrayOfX509Certificate1, paramTrustManagerFactory, paramArrayOfX509Certificate2, paramPrivateKey, paramString1, paramKeyManagerFactory, paramIterable, paramCipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(paramApplicationProtocolConfig), paramLong1, paramLong2, paramClientAuth, paramArrayOfString, paramBoolean1, paramBoolean2, paramString2);
  }
  
  ReferenceCountedOpenSslServerContext(X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, OpenSslApplicationProtocolNegotiator paramOpenSslApplicationProtocolNegotiator, long paramLong1, long paramLong2, ClientAuth paramClientAuth, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
    throws SSLException
  {
    super(paramIterable, paramCipherSuiteFilter, paramOpenSslApplicationProtocolNegotiator, paramLong1, paramLong2, 1, paramArrayOfX509Certificate2, paramClientAuth, paramArrayOfString, paramBoolean1, paramBoolean2, true);
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
  static OpenSslServerSessionContext newSessionContext(ReferenceCountedOpenSslContext paramReferenceCountedOpenSslContext, long paramLong, OpenSslEngineMap paramOpenSslEngineMap, X509Certificate[] paramArrayOfX509Certificate1, TrustManagerFactory paramTrustManagerFactory, X509Certificate[] paramArrayOfX509Certificate2, PrivateKey paramPrivateKey, String paramString1, KeyManagerFactory paramKeyManagerFactory, String paramString2)
    throws SSLException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: aload 12
    //   8: astore 13
    //   10: lload_1
    //   11: iconst_0
    //   12: bipush 10
    //   14: invokestatic 105	io/netty/internal/tcnative/SSLContext:setVerify	(JII)V
    //   17: aload 12
    //   19: astore 13
    //   21: invokestatic 110	io/netty/handler/ssl/OpenSsl:useKeyManagerFactory	()Z
    //   24: ifne +64 -> 88
    //   27: aload 9
    //   29: ifnonnull +35 -> 64
    //   32: aload 12
    //   34: astore 13
    //   36: aload 6
    //   38: ldc 112
    //   40: invokestatic 118	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   43: pop
    //   44: aload 12
    //   46: astore 13
    //   48: lload_1
    //   49: aload 6
    //   51: aload 7
    //   53: aload 8
    //   55: invokestatic 122	io/netty/handler/ssl/ReferenceCountedOpenSslContext:setKeyMaterial	(J[Ljava/security/cert/X509Certificate;Ljava/security/PrivateKey;Ljava/lang/String;)V
    //   58: aconst_null
    //   59: astore 7
    //   61: goto +202 -> 263
    //   64: aload 12
    //   66: astore 13
    //   68: new 124	java/lang/IllegalArgumentException
    //   71: astore_0
    //   72: aload 12
    //   74: astore 13
    //   76: aload_0
    //   77: ldc 126
    //   79: invokespecial 129	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   82: aload 12
    //   84: astore 13
    //   86: aload_0
    //   87: athrow
    //   88: aload 9
    //   90: astore 14
    //   92: aload 9
    //   94: ifnonnull +105 -> 199
    //   97: aload 12
    //   99: astore 13
    //   101: aload 8
    //   103: invokestatic 135	io/netty/handler/ssl/SslContext:keyStorePassword	(Ljava/lang/String;)[C
    //   106: astore 9
    //   108: aload 12
    //   110: astore 13
    //   112: aload 6
    //   114: aload 7
    //   116: aload 9
    //   118: aload 10
    //   120: invokestatic 139	io/netty/handler/ssl/SslContext:buildKeyStore	([Ljava/security/cert/X509Certificate;Ljava/security/PrivateKey;[CLjava/lang/String;)Ljava/security/KeyStore;
    //   123: astore 7
    //   125: aload 12
    //   127: astore 13
    //   129: aload 7
    //   131: invokevirtual 145	java/security/KeyStore:aliases	()Ljava/util/Enumeration;
    //   134: invokeinterface 150 1 0
    //   139: ifeq +24 -> 163
    //   142: aload 12
    //   144: astore 13
    //   146: new 152	io/netty/handler/ssl/OpenSslX509KeyManagerFactory
    //   149: astore 6
    //   151: aload 12
    //   153: astore 13
    //   155: aload 6
    //   157: invokespecial 154	io/netty/handler/ssl/OpenSslX509KeyManagerFactory:<init>	()V
    //   160: goto +22 -> 182
    //   163: aload 12
    //   165: astore 13
    //   167: new 156	io/netty/handler/ssl/OpenSslCachingX509KeyManagerFactory
    //   170: dup
    //   171: invokestatic 162	javax/net/ssl/KeyManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   174: invokestatic 165	javax/net/ssl/KeyManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/KeyManagerFactory;
    //   177: invokespecial 168	io/netty/handler/ssl/OpenSslCachingX509KeyManagerFactory:<init>	(Ljavax/net/ssl/KeyManagerFactory;)V
    //   180: astore 6
    //   182: aload 12
    //   184: astore 13
    //   186: aload 6
    //   188: aload 7
    //   190: aload 9
    //   192: invokevirtual 172	javax/net/ssl/KeyManagerFactory:init	(Ljava/security/KeyStore;[C)V
    //   195: aload 6
    //   197: astore 14
    //   199: aload 12
    //   201: astore 13
    //   203: aload 14
    //   205: aload 8
    //   207: invokestatic 176	io/netty/handler/ssl/ReferenceCountedOpenSslContext:providerFor	(Ljavax/net/ssl/KeyManagerFactory;Ljava/lang/String;)Lio/netty/handler/ssl/OpenSslKeyMaterialProvider;
    //   210: astore 7
    //   212: aload 7
    //   214: astore 6
    //   216: new 9	io/netty/handler/ssl/ReferenceCountedOpenSslServerContext$OpenSslServerCertificateCallback
    //   219: astore 8
    //   221: aload 7
    //   223: astore 6
    //   225: new 178	io/netty/handler/ssl/OpenSslKeyMaterialManager
    //   228: astore 9
    //   230: aload 7
    //   232: astore 6
    //   234: aload 9
    //   236: aload 7
    //   238: invokespecial 181	io/netty/handler/ssl/OpenSslKeyMaterialManager:<init>	(Lio/netty/handler/ssl/OpenSslKeyMaterialProvider;)V
    //   241: aload 7
    //   243: astore 6
    //   245: aload 8
    //   247: aload_3
    //   248: aload 9
    //   250: invokespecial 184	io/netty/handler/ssl/ReferenceCountedOpenSslServerContext$OpenSslServerCertificateCallback:<init>	(Lio/netty/handler/ssl/OpenSslEngineMap;Lio/netty/handler/ssl/OpenSslKeyMaterialManager;)V
    //   253: aload 7
    //   255: astore 6
    //   257: lload_1
    //   258: aload 8
    //   260: invokestatic 188	io/netty/internal/tcnative/SSLContext:setCertificateCallback	(JLio/netty/internal/tcnative/CertificateCallback;)V
    //   263: aload 4
    //   265: ifnull +29 -> 294
    //   268: aload 7
    //   270: astore 6
    //   272: aload 4
    //   274: aload 5
    //   276: aload 10
    //   278: invokestatic 192	io/netty/handler/ssl/SslContext:buildTrustManagerFactory	([Ljava/security/cert/X509Certificate;Ljavax/net/ssl/TrustManagerFactory;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   281: astore 4
    //   283: goto +42 -> 325
    //   286: astore_0
    //   287: goto +291 -> 578
    //   290: astore_0
    //   291: goto +313 -> 604
    //   294: aload 5
    //   296: astore 4
    //   298: aload 5
    //   300: ifnonnull +25 -> 325
    //   303: aload 7
    //   305: astore 6
    //   307: invokestatic 195	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   310: invokestatic 198	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   313: astore 4
    //   315: aload 7
    //   317: astore 6
    //   319: aload 4
    //   321: aconst_null
    //   322: invokevirtual 201	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   325: aload 7
    //   327: astore 6
    //   329: aload 4
    //   331: invokevirtual 205	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   334: invokestatic 209	io/netty/handler/ssl/ReferenceCountedOpenSslContext:chooseTrustManager	([Ljavax/net/ssl/TrustManager;)Ljavax/net/ssl/X509TrustManager;
    //   337: astore 4
    //   339: aload 7
    //   341: astore 6
    //   343: lload_1
    //   344: aload_3
    //   345: aload 4
    //   347: invokestatic 213	io/netty/handler/ssl/ReferenceCountedOpenSslServerContext:setVerifyCallback	(JLio/netty/handler/ssl/OpenSslEngineMap;Ljavax/net/ssl/X509TrustManager;)V
    //   350: aload 7
    //   352: astore 6
    //   354: aload 4
    //   356: invokeinterface 219 1 0
    //   361: astore 5
    //   363: aload 5
    //   365: ifnull +139 -> 504
    //   368: aload 7
    //   370: astore 6
    //   372: aload 5
    //   374: arraylength
    //   375: istore 15
    //   377: iload 15
    //   379: ifle +125 -> 504
    //   382: lconst_0
    //   383: lstore 16
    //   385: getstatic 225	io/netty/buffer/ByteBufAllocator:DEFAULT	Lio/netty/buffer/ByteBufAllocator;
    //   388: aload 5
    //   390: invokestatic 229	io/netty/handler/ssl/ReferenceCountedOpenSslContext:toBIO	(Lio/netty/buffer/ByteBufAllocator;[Ljava/security/cert/X509Certificate;)J
    //   393: lstore 18
    //   395: lload 18
    //   397: lstore 16
    //   399: lload_1
    //   400: lload 18
    //   402: invokestatic 233	io/netty/internal/tcnative/SSLContext:setCACertificateBio	(JJ)Z
    //   405: istore 20
    //   407: iload 20
    //   409: ifeq +15 -> 424
    //   412: aload 7
    //   414: astore 6
    //   416: lload 18
    //   418: invokestatic 237	io/netty/handler/ssl/ReferenceCountedOpenSslContext:freeBio	(J)V
    //   421: goto +83 -> 504
    //   424: lload 18
    //   426: lstore 16
    //   428: new 55	javax/net/ssl/SSLException
    //   431: astore_3
    //   432: lload 18
    //   434: lstore 16
    //   436: new 239	java/lang/StringBuilder
    //   439: astore_0
    //   440: lload 18
    //   442: lstore 16
    //   444: aload_0
    //   445: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   448: lload 18
    //   450: lstore 16
    //   452: aload_0
    //   453: ldc -14
    //   455: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: lload 18
    //   461: lstore 16
    //   463: aload_0
    //   464: aload 4
    //   466: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: lload 18
    //   472: lstore 16
    //   474: aload_3
    //   475: aload_0
    //   476: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokespecial 253	javax/net/ssl/SSLException:<init>	(Ljava/lang/String;)V
    //   482: lload 18
    //   484: lstore 16
    //   486: aload_3
    //   487: athrow
    //   488: astore_0
    //   489: aload 7
    //   491: astore 6
    //   493: lload 16
    //   495: invokestatic 237	io/netty/handler/ssl/ReferenceCountedOpenSslContext:freeBio	(J)V
    //   498: aload 7
    //   500: astore 6
    //   502: aload_0
    //   503: athrow
    //   504: aload 7
    //   506: astore 6
    //   508: invokestatic 259	io/netty/util/internal/PlatformDependent:javaVersion	()I
    //   511: bipush 8
    //   513: if_icmplt +32 -> 545
    //   516: aload 7
    //   518: astore 6
    //   520: new 12	io/netty/handler/ssl/ReferenceCountedOpenSslServerContext$OpenSslSniHostnameMatcher
    //   523: astore 4
    //   525: aload 7
    //   527: astore 6
    //   529: aload 4
    //   531: aload_3
    //   532: invokespecial 262	io/netty/handler/ssl/ReferenceCountedOpenSslServerContext$OpenSslSniHostnameMatcher:<init>	(Lio/netty/handler/ssl/OpenSslEngineMap;)V
    //   535: aload 7
    //   537: astore 6
    //   539: lload_1
    //   540: aload 4
    //   542: invokestatic 266	io/netty/internal/tcnative/SSLContext:setSniHostnameMatcher	(JLio/netty/internal/tcnative/SniHostNameMatcher;)V
    //   545: aload 7
    //   547: astore 6
    //   549: new 268	io/netty/handler/ssl/OpenSslServerSessionContext
    //   552: astore_3
    //   553: aload 7
    //   555: astore 6
    //   557: aload_3
    //   558: aload_0
    //   559: aload 7
    //   561: invokespecial 271	io/netty/handler/ssl/OpenSslServerSessionContext:<init>	(Lio/netty/handler/ssl/ReferenceCountedOpenSslContext;Lio/netty/handler/ssl/OpenSslKeyMaterialProvider;)V
    //   564: aload 7
    //   566: astore 6
    //   568: aload_3
    //   569: getstatic 40	io/netty/handler/ssl/ReferenceCountedOpenSslServerContext:ID	[B
    //   572: invokevirtual 275	io/netty/handler/ssl/OpenSslServerSessionContext:setSessionIdContext	([B)Z
    //   575: pop
    //   576: aload_3
    //   577: areturn
    //   578: aload 7
    //   580: astore 6
    //   582: new 55	javax/net/ssl/SSLException
    //   585: astore_3
    //   586: aload 7
    //   588: astore 6
    //   590: aload_3
    //   591: ldc_w 277
    //   594: aload_0
    //   595: invokespecial 280	javax/net/ssl/SSLException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   598: aload 7
    //   600: astore 6
    //   602: aload_3
    //   603: athrow
    //   604: aload 7
    //   606: astore 6
    //   608: aload_0
    //   609: athrow
    //   610: astore_0
    //   611: aload 6
    //   613: astore 13
    //   615: goto +44 -> 659
    //   618: astore_3
    //   619: aload 7
    //   621: astore_0
    //   622: goto +11 -> 633
    //   625: astore_0
    //   626: goto +33 -> 659
    //   629: astore_3
    //   630: aload 11
    //   632: astore_0
    //   633: aload_0
    //   634: astore 13
    //   636: new 55	javax/net/ssl/SSLException
    //   639: astore 4
    //   641: aload_0
    //   642: astore 13
    //   644: aload 4
    //   646: ldc_w 282
    //   649: aload_3
    //   650: invokespecial 280	javax/net/ssl/SSLException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   653: aload_0
    //   654: astore 13
    //   656: aload 4
    //   658: athrow
    //   659: aload 13
    //   661: ifnull +8 -> 669
    //   664: aload 13
    //   666: invokevirtual 287	io/netty/handler/ssl/OpenSslKeyMaterialProvider:destroy	()V
    //   669: aload_0
    //   670: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	paramReferenceCountedOpenSslContext	ReferenceCountedOpenSslContext
    //   0	671	1	paramLong	long
    //   0	671	3	paramOpenSslEngineMap	OpenSslEngineMap
    //   0	671	4	paramArrayOfX509Certificate1	X509Certificate[]
    //   0	671	5	paramTrustManagerFactory	TrustManagerFactory
    //   0	671	6	paramArrayOfX509Certificate2	X509Certificate[]
    //   0	671	7	paramPrivateKey	PrivateKey
    //   0	671	8	paramString1	String
    //   0	671	9	paramKeyManagerFactory	KeyManagerFactory
    //   0	671	10	paramString2	String
    //   1	630	11	localObject1	Object
    //   4	196	12	localObject2	Object
    //   8	657	13	localObject3	Object
    //   90	114	14	localObject4	Object
    //   375	3	15	i	int
    //   383	111	16	l1	long
    //   393	90	18	l2	long
    //   405	3	20	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   272	283	286	java/lang/Exception
    //   307	315	286	java/lang/Exception
    //   319	325	286	java/lang/Exception
    //   329	339	286	java/lang/Exception
    //   343	350	286	java/lang/Exception
    //   354	363	286	java/lang/Exception
    //   372	377	286	java/lang/Exception
    //   416	421	286	java/lang/Exception
    //   493	498	286	java/lang/Exception
    //   502	504	286	java/lang/Exception
    //   508	516	286	java/lang/Exception
    //   520	525	286	java/lang/Exception
    //   529	535	286	java/lang/Exception
    //   539	545	286	java/lang/Exception
    //   272	283	290	javax/net/ssl/SSLException
    //   307	315	290	javax/net/ssl/SSLException
    //   319	325	290	javax/net/ssl/SSLException
    //   329	339	290	javax/net/ssl/SSLException
    //   343	350	290	javax/net/ssl/SSLException
    //   354	363	290	javax/net/ssl/SSLException
    //   372	377	290	javax/net/ssl/SSLException
    //   416	421	290	javax/net/ssl/SSLException
    //   493	498	290	javax/net/ssl/SSLException
    //   502	504	290	javax/net/ssl/SSLException
    //   508	516	290	javax/net/ssl/SSLException
    //   520	525	290	javax/net/ssl/SSLException
    //   529	535	290	javax/net/ssl/SSLException
    //   539	545	290	javax/net/ssl/SSLException
    //   385	395	488	finally
    //   399	407	488	finally
    //   428	432	488	finally
    //   436	440	488	finally
    //   444	448	488	finally
    //   452	459	488	finally
    //   463	470	488	finally
    //   474	482	488	finally
    //   486	488	488	finally
    //   216	221	610	finally
    //   225	230	610	finally
    //   234	241	610	finally
    //   245	253	610	finally
    //   257	263	610	finally
    //   272	283	610	finally
    //   307	315	610	finally
    //   319	325	610	finally
    //   329	339	610	finally
    //   343	350	610	finally
    //   354	363	610	finally
    //   372	377	610	finally
    //   416	421	610	finally
    //   493	498	610	finally
    //   502	504	610	finally
    //   508	516	610	finally
    //   520	525	610	finally
    //   529	535	610	finally
    //   539	545	610	finally
    //   549	553	610	finally
    //   557	564	610	finally
    //   568	576	610	finally
    //   582	586	610	finally
    //   590	598	610	finally
    //   602	604	610	finally
    //   608	610	610	finally
    //   216	221	618	java/lang/Exception
    //   225	230	618	java/lang/Exception
    //   234	241	618	java/lang/Exception
    //   245	253	618	java/lang/Exception
    //   257	263	618	java/lang/Exception
    //   10	17	625	finally
    //   21	27	625	finally
    //   36	44	625	finally
    //   48	58	625	finally
    //   68	72	625	finally
    //   76	82	625	finally
    //   86	88	625	finally
    //   101	108	625	finally
    //   112	125	625	finally
    //   129	142	625	finally
    //   146	151	625	finally
    //   155	160	625	finally
    //   167	182	625	finally
    //   186	195	625	finally
    //   203	212	625	finally
    //   636	641	625	finally
    //   644	653	625	finally
    //   656	659	625	finally
    //   10	17	629	java/lang/Exception
    //   21	27	629	java/lang/Exception
    //   36	44	629	java/lang/Exception
    //   48	58	629	java/lang/Exception
    //   68	72	629	java/lang/Exception
    //   76	82	629	java/lang/Exception
    //   86	88	629	java/lang/Exception
    //   101	108	629	java/lang/Exception
    //   112	125	629	java/lang/Exception
    //   129	142	629	java/lang/Exception
    //   146	151	629	java/lang/Exception
    //   155	160	629	java/lang/Exception
    //   167	182	629	java/lang/Exception
    //   186	195	629	java/lang/Exception
    //   203	212	629	java/lang/Exception
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
  
  public OpenSslServerSessionContext sessionContext()
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
      this.manager.checkClientTrusted(paramArrayOfX509Certificate, paramString, paramReferenceCountedOpenSslEngine);
    }
  }
  
  private static final class OpenSslServerCertificateCallback
    implements CertificateCallback
  {
    private final OpenSslEngineMap engineMap;
    private final OpenSslKeyMaterialManager keyManagerHolder;
    
    OpenSslServerCertificateCallback(OpenSslEngineMap paramOpenSslEngineMap, OpenSslKeyMaterialManager paramOpenSslKeyMaterialManager)
    {
      this.engineMap = paramOpenSslEngineMap;
      this.keyManagerHolder = paramOpenSslKeyMaterialManager;
    }
    
    /* Error */
    public void handle(long paramLong, byte[] paramArrayOfByte, byte[][] paramArrayOfByte1)
      throws Exception
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	io/netty/handler/ssl/ReferenceCountedOpenSslServerContext$OpenSslServerCertificateCallback:engineMap	Lio/netty/handler/ssl/OpenSslEngineMap;
      //   4: lload_1
      //   5: invokeinterface 33 3 0
      //   10: astore 4
      //   12: aload 4
      //   14: ifnonnull +4 -> 18
      //   17: return
      //   18: aload_0
      //   19: getfield 22	io/netty/handler/ssl/ReferenceCountedOpenSslServerContext$OpenSslServerCertificateCallback:keyManagerHolder	Lio/netty/handler/ssl/OpenSslKeyMaterialManager;
      //   22: aload 4
      //   24: invokevirtual 39	io/netty/handler/ssl/OpenSslKeyMaterialManager:setKeyMaterialServerSide	(Lio/netty/handler/ssl/ReferenceCountedOpenSslEngine;)V
      //   27: goto +21 -> 48
      //   30: astore_3
      //   31: invokestatic 43	io/netty/handler/ssl/ReferenceCountedOpenSslServerContext:access$000	()Lio/netty/util/internal/logging/InternalLogger;
      //   34: ldc 45
      //   36: aload_3
      //   37: invokeinterface 51 3 0
      //   42: aload 4
      //   44: aload_3
      //   45: invokevirtual 57	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:initHandshakeException	(Ljava/lang/Throwable;)V
      //   48: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	49	0	this	OpenSslServerCertificateCallback
      //   0	49	1	paramLong	long
      //   0	49	3	paramArrayOfByte	byte[]
      //   0	49	4	paramArrayOfByte1	byte[][]
      // Exception table:
      //   from	to	target	type
      //   18	27	30	finally
    }
  }
  
  private static final class OpenSslSniHostnameMatcher
    implements SniHostNameMatcher
  {
    private final OpenSslEngineMap engineMap;
    
    OpenSslSniHostnameMatcher(OpenSslEngineMap paramOpenSslEngineMap)
    {
      this.engineMap = paramOpenSslEngineMap;
    }
    
    public boolean match(long paramLong, String paramString)
    {
      ReferenceCountedOpenSslEngine localReferenceCountedOpenSslEngine = this.engineMap.get(paramLong);
      if (localReferenceCountedOpenSslEngine != null) {
        return localReferenceCountedOpenSslEngine.checkSniHostnameMatch(paramString.getBytes(CharsetUtil.UTF_8));
      }
      ReferenceCountedOpenSslServerContext.logger.warn("No ReferenceCountedOpenSslEngine found for SSL pointer: {}", Long.valueOf(paramLong));
      return false;
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
      this.manager.checkClientTrusted(paramArrayOfX509Certificate, paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\ReferenceCountedOpenSslServerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */