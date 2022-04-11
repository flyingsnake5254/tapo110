package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.internal.tcnative.CertificateVerifier;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SSLPrivateKeyMethod;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorException.BasicReason;
import java.security.cert.CertPathValidatorException.Reason;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateRevokedException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

public abstract class ReferenceCountedOpenSslContext
  extends SslContext
  implements ReferenceCounted
{
  private static final int DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE;
  private static final Integer DH_KEY_LENGTH;
  static final OpenSslApplicationProtocolNegotiator NONE_PROTOCOL_NEGOTIATOR;
  static final boolean USE_TASKS;
  protected static final int VERIFY_DEPTH = 10;
  private static final ResourceLeakDetector<ReferenceCountedOpenSslContext> leakDetector;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslContext.class);
  private final OpenSslApplicationProtocolNegotiator apn;
  private volatile int bioNonApplicationBufferSize;
  final ClientAuth clientAuth;
  protected long ctx;
  final ReadWriteLock ctxLock;
  final boolean enableOcsp;
  final OpenSslEngineMap engineMap;
  final Certificate[] keyCertChain;
  private final ResourceLeakTracker<ReferenceCountedOpenSslContext> leak;
  private final int mode;
  final String[] protocols;
  private final AbstractReferenceCounted refCnt;
  private final long sessionCacheSize;
  private final long sessionTimeout;
  private final List<String> unmodifiableCiphers;
  
  static
  {
    DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE = Math.max(1, SystemPropertyUtil.getInt("io.netty.handler.ssl.openssl.bioNonApplicationBufferSize", 2048));
    USE_TASKS = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.useTasks", false);
    leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslContext.class);
    NONE_PROTOCOL_NEGOTIATOR = new OpenSslApplicationProtocolNegotiator()
    {
      public ApplicationProtocolConfig.Protocol protocol()
      {
        return ApplicationProtocolConfig.Protocol.NONE;
      }
      
      public List<String> protocols()
      {
        return Collections.emptyList();
      }
      
      public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior()
      {
        return ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT;
      }
      
      public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior()
      {
        return ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
      }
    };
    localObject1 = null;
    try
    {
      String str = SystemPropertyUtil.get("jdk.tls.ephemeralDHKeySize");
      Object localObject2 = localObject1;
      if (str != null) {
        try
        {
          localObject2 = Integer.valueOf(str);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localObject3 = logger;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("ReferenceCountedOpenSslContext supports -Djdk.tls.ephemeralDHKeySize={int}, but got: ");
          localStringBuilder.append(str);
          ((InternalLogger)localObject3).debug(localStringBuilder.toString());
          localObject3 = localObject1;
        }
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject3;
        Object localObject5 = localObject1;
      }
    }
    DH_KEY_LENGTH = (Integer)localObject3;
  }
  
  ReferenceCountedOpenSslContext(Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2, int paramInt, Certificate[] paramArrayOfCertificate, ClientAuth paramClientAuth, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws SSLException
  {
    this(paramIterable, paramCipherSuiteFilter, toNegotiator(paramApplicationProtocolConfig), paramLong1, paramLong2, paramInt, paramArrayOfCertificate, paramClientAuth, paramArrayOfString, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  /* Error */
  ReferenceCountedOpenSslContext(Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, OpenSslApplicationProtocolNegotiator paramOpenSslApplicationProtocolNegotiator, long paramLong1, long paramLong2, int paramInt, Certificate[] paramArrayOfCertificate, ClientAuth paramClientAuth, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws SSLException
  {
    // Byte code:
    //   0: aload_0
    //   1: iload 12
    //   3: invokespecial 167	io/netty/handler/ssl/SslContext:<init>	(Z)V
    //   6: aload_0
    //   7: new 8	io/netty/handler/ssl/ReferenceCountedOpenSslContext$1
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 170	io/netty/handler/ssl/ReferenceCountedOpenSslContext$1:<init>	(Lio/netty/handler/ssl/ReferenceCountedOpenSslContext;)V
    //   15: putfield 172	io/netty/handler/ssl/ReferenceCountedOpenSslContext:refCnt	Lio/netty/util/AbstractReferenceCounted;
    //   18: aconst_null
    //   19: astore 15
    //   21: aload_0
    //   22: new 17	io/netty/handler/ssl/ReferenceCountedOpenSslContext$DefaultOpenSslEngineMap
    //   25: dup
    //   26: aconst_null
    //   27: invokespecial 175	io/netty/handler/ssl/ReferenceCountedOpenSslContext$DefaultOpenSslEngineMap:<init>	(Lio/netty/handler/ssl/ReferenceCountedOpenSslContext$1;)V
    //   30: putfield 177	io/netty/handler/ssl/ReferenceCountedOpenSslContext:engineMap	Lio/netty/handler/ssl/OpenSslEngineMap;
    //   33: aload_0
    //   34: new 179	java/util/concurrent/locks/ReentrantReadWriteLock
    //   37: dup
    //   38: invokespecial 180	java/util/concurrent/locks/ReentrantReadWriteLock:<init>	()V
    //   41: putfield 182	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctxLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   44: aload_0
    //   45: getstatic 90	io/netty/handler/ssl/ReferenceCountedOpenSslContext:DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE	I
    //   48: putfield 184	io/netty/handler/ssl/ReferenceCountedOpenSslContext:bioNonApplicationBufferSize	I
    //   51: invokestatic 189	io/netty/handler/ssl/OpenSsl:ensureAvailability	()V
    //   54: iload 13
    //   56: ifeq +22 -> 78
    //   59: invokestatic 193	io/netty/handler/ssl/OpenSsl:isOcspSupported	()Z
    //   62: ifeq +6 -> 68
    //   65: goto +13 -> 78
    //   68: new 195	java/lang/IllegalStateException
    //   71: dup
    //   72: ldc -59
    //   74: invokespecial 199	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: iload 8
    //   80: iconst_1
    //   81: if_icmpeq +21 -> 102
    //   84: iload 8
    //   86: ifne +6 -> 92
    //   89: goto +13 -> 102
    //   92: new 201	java/lang/IllegalArgumentException
    //   95: dup
    //   96: ldc -53
    //   98: invokespecial 204	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   101: athrow
    //   102: iload 14
    //   104: ifeq +15 -> 119
    //   107: getstatic 110	io/netty/handler/ssl/ReferenceCountedOpenSslContext:leakDetector	Lio/netty/util/ResourceLeakDetector;
    //   110: aload_0
    //   111: invokevirtual 210	io/netty/util/ResourceLeakDetector:track	(Ljava/lang/Object;)Lio/netty/util/ResourceLeakTracker;
    //   114: astore 16
    //   116: goto +6 -> 122
    //   119: aconst_null
    //   120: astore 16
    //   122: aload_0
    //   123: aload 16
    //   125: putfield 212	io/netty/handler/ssl/ReferenceCountedOpenSslContext:leak	Lio/netty/util/ResourceLeakTracker;
    //   128: aload_0
    //   129: iload 8
    //   131: putfield 214	io/netty/handler/ssl/ReferenceCountedOpenSslContext:mode	I
    //   134: aload_0
    //   135: invokevirtual 217	io/netty/handler/ssl/SslContext:isServer	()Z
    //   138: ifeq +18 -> 156
    //   141: aload 10
    //   143: ldc -38
    //   145: invokestatic 224	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   148: checkcast 226	io/netty/handler/ssl/ClientAuth
    //   151: astore 10
    //   153: goto +8 -> 161
    //   156: getstatic 229	io/netty/handler/ssl/ClientAuth:NONE	Lio/netty/handler/ssl/ClientAuth;
    //   159: astore 10
    //   161: aload_0
    //   162: aload 10
    //   164: putfield 231	io/netty/handler/ssl/ReferenceCountedOpenSslContext:clientAuth	Lio/netty/handler/ssl/ClientAuth;
    //   167: aload_0
    //   168: aload 11
    //   170: putfield 233	io/netty/handler/ssl/ReferenceCountedOpenSslContext:protocols	[Ljava/lang/String;
    //   173: aload_0
    //   174: iload 13
    //   176: putfield 235	io/netty/handler/ssl/ReferenceCountedOpenSslContext:enableOcsp	Z
    //   179: aload 9
    //   181: ifnonnull +10 -> 191
    //   184: aload 15
    //   186: astore 9
    //   188: goto +13 -> 201
    //   191: aload 9
    //   193: invokevirtual 240	[Ljava/security/cert/Certificate;:clone	()Ljava/lang/Object;
    //   196: checkcast 236	[Ljava/security/cert/Certificate;
    //   199: astore 9
    //   201: aload_0
    //   202: aload 9
    //   204: putfield 242	io/netty/handler/ssl/ReferenceCountedOpenSslContext:keyCertChain	[Ljava/security/cert/Certificate;
    //   207: aload_2
    //   208: ldc -12
    //   210: invokestatic 224	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   213: checkcast 246	io/netty/handler/ssl/CipherSuiteFilter
    //   216: aload_1
    //   217: getstatic 249	io/netty/handler/ssl/OpenSsl:DEFAULT_CIPHERS	Ljava/util/List;
    //   220: invokestatic 253	io/netty/handler/ssl/OpenSsl:availableJavaCipherSuites	()Ljava/util/Set;
    //   223: invokeinterface 257 4 0
    //   228: invokestatic 263	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   231: astore_2
    //   232: aload_0
    //   233: aload_2
    //   234: putfield 265	io/netty/handler/ssl/ReferenceCountedOpenSslContext:unmodifiableCiphers	Ljava/util/List;
    //   237: aload_0
    //   238: aload_3
    //   239: ldc_w 266
    //   242: invokestatic 224	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   245: checkcast 268	io/netty/handler/ssl/OpenSslApplicationProtocolNegotiator
    //   248: putfield 270	io/netty/handler/ssl/ReferenceCountedOpenSslContext:apn	Lio/netty/handler/ssl/OpenSslApplicationProtocolNegotiator;
    //   251: bipush 30
    //   253: istore 17
    //   255: invokestatic 273	io/netty/handler/ssl/OpenSsl:isTlsv13Supported	()Z
    //   258: ifeq +7 -> 265
    //   261: bipush 62
    //   263: istore 17
    //   265: aload_0
    //   266: iload 17
    //   268: iload 8
    //   270: invokestatic 279	io/netty/internal/tcnative/SSLContext:make	(II)J
    //   273: putfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   276: invokestatic 273	io/netty/handler/ssl/OpenSsl:isTlsv13Supported	()Z
    //   279: istore 12
    //   281: new 129	java/lang/StringBuilder
    //   284: astore 9
    //   286: aload 9
    //   288: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   291: new 129	java/lang/StringBuilder
    //   294: astore_1
    //   295: aload_1
    //   296: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   299: aload_2
    //   300: invokeinterface 286 1 0
    //   305: ifeq +35 -> 340
    //   308: aload_0
    //   309: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   312: ldc_w 288
    //   315: iconst_0
    //   316: invokestatic 292	io/netty/internal/tcnative/SSLContext:setCipherSuite	(JLjava/lang/String;Z)Z
    //   319: pop
    //   320: iload 12
    //   322: ifeq +60 -> 382
    //   325: aload_0
    //   326: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   329: ldc_w 288
    //   332: iconst_1
    //   333: invokestatic 292	io/netty/internal/tcnative/SSLContext:setCipherSuite	(JLjava/lang/String;Z)Z
    //   336: pop
    //   337: goto +45 -> 382
    //   340: aload_2
    //   341: aload 9
    //   343: aload_1
    //   344: invokestatic 295	io/netty/handler/ssl/OpenSsl:isBoringSSL	()Z
    //   347: invokestatic 301	io/netty/handler/ssl/CipherSuiteConverter:convertToCipherStrings	(Ljava/lang/Iterable;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Z)V
    //   350: aload_0
    //   351: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   354: aload 9
    //   356: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: iconst_0
    //   360: invokestatic 292	io/netty/internal/tcnative/SSLContext:setCipherSuite	(JLjava/lang/String;Z)Z
    //   363: pop
    //   364: iload 12
    //   366: ifeq +16 -> 382
    //   369: aload_0
    //   370: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   373: aload_1
    //   374: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: iconst_1
    //   378: invokestatic 292	io/netty/internal/tcnative/SSLContext:setCipherSuite	(JLjava/lang/String;Z)Z
    //   381: pop
    //   382: aload_0
    //   383: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   386: invokestatic 305	io/netty/internal/tcnative/SSLContext:getOptions	(J)I
    //   389: getstatic 310	io/netty/internal/tcnative/SSL:SSL_OP_NO_SSLv2	I
    //   392: ior
    //   393: getstatic 313	io/netty/internal/tcnative/SSL:SSL_OP_NO_SSLv3	I
    //   396: ior
    //   397: getstatic 316	io/netty/internal/tcnative/SSL:SSL_OP_NO_TLSv1_3	I
    //   400: ior
    //   401: getstatic 319	io/netty/internal/tcnative/SSL:SSL_OP_CIPHER_SERVER_PREFERENCE	I
    //   404: ior
    //   405: getstatic 322	io/netty/internal/tcnative/SSL:SSL_OP_NO_COMPRESSION	I
    //   408: ior
    //   409: getstatic 325	io/netty/internal/tcnative/SSL:SSL_OP_NO_TICKET	I
    //   412: ior
    //   413: istore 17
    //   415: iload 17
    //   417: istore 8
    //   419: aload 9
    //   421: invokevirtual 329	java/lang/StringBuilder:length	()I
    //   424: ifne +27 -> 451
    //   427: iload 17
    //   429: getstatic 310	io/netty/internal/tcnative/SSL:SSL_OP_NO_SSLv2	I
    //   432: getstatic 313	io/netty/internal/tcnative/SSL:SSL_OP_NO_SSLv3	I
    //   435: ior
    //   436: getstatic 332	io/netty/internal/tcnative/SSL:SSL_OP_NO_TLSv1	I
    //   439: ior
    //   440: getstatic 335	io/netty/internal/tcnative/SSL:SSL_OP_NO_TLSv1_1	I
    //   443: ior
    //   444: getstatic 338	io/netty/internal/tcnative/SSL:SSL_OP_NO_TLSv1_2	I
    //   447: ior
    //   448: ior
    //   449: istore 8
    //   451: aload_0
    //   452: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   455: iload 8
    //   457: invokestatic 342	io/netty/internal/tcnative/SSLContext:setOptions	(JI)V
    //   460: aload_0
    //   461: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   464: lstore 18
    //   466: lload 18
    //   468: lload 18
    //   470: invokestatic 345	io/netty/internal/tcnative/SSLContext:getMode	(J)I
    //   473: getstatic 348	io/netty/internal/tcnative/SSL:SSL_MODE_ACCEPT_MOVING_WRITE_BUFFER	I
    //   476: ior
    //   477: invokestatic 352	io/netty/internal/tcnative/SSLContext:setMode	(JI)I
    //   480: pop
    //   481: getstatic 148	io/netty/handler/ssl/ReferenceCountedOpenSslContext:DH_KEY_LENGTH	Ljava/lang/Integer;
    //   484: astore_1
    //   485: aload_1
    //   486: ifnull +14 -> 500
    //   489: aload_0
    //   490: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   493: aload_1
    //   494: invokevirtual 355	java/lang/Integer:intValue	()I
    //   497: invokestatic 358	io/netty/internal/tcnative/SSLContext:setTmpDHLength	(JI)V
    //   500: aload_3
    //   501: invokeinterface 363 1 0
    //   506: astore_1
    //   507: aload_1
    //   508: invokeinterface 286 1 0
    //   513: ifne +117 -> 630
    //   516: aload_1
    //   517: iconst_0
    //   518: anewarray 365	java/lang/String
    //   521: invokeinterface 369 2 0
    //   526: checkcast 370	[Ljava/lang/String;
    //   529: astore_1
    //   530: aload_3
    //   531: invokeinterface 374 1 0
    //   536: invokestatic 378	io/netty/handler/ssl/ReferenceCountedOpenSslContext:opensslSelectorFailureBehavior	(Lio/netty/handler/ssl/ApplicationProtocolConfig$SelectorFailureBehavior;)I
    //   539: istore 17
    //   541: getstatic 382	io/netty/handler/ssl/ReferenceCountedOpenSslContext$3:$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol	[I
    //   544: aload_3
    //   545: invokeinterface 386 1 0
    //   550: invokevirtual 391	java/lang/Enum:ordinal	()I
    //   553: iaload
    //   554: istore 8
    //   556: iload 8
    //   558: iconst_1
    //   559: if_icmpeq +61 -> 620
    //   562: iload 8
    //   564: iconst_2
    //   565: if_icmpeq +42 -> 607
    //   568: iload 8
    //   570: iconst_3
    //   571: if_icmpne +26 -> 597
    //   574: aload_0
    //   575: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   578: aload_1
    //   579: iload 17
    //   581: invokestatic 395	io/netty/internal/tcnative/SSLContext:setNpnProtos	(J[Ljava/lang/String;I)V
    //   584: aload_0
    //   585: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   588: aload_1
    //   589: iload 17
    //   591: invokestatic 398	io/netty/internal/tcnative/SSLContext:setAlpnProtos	(J[Ljava/lang/String;I)V
    //   594: goto +36 -> 630
    //   597: new 400	java/lang/Error
    //   600: astore_1
    //   601: aload_1
    //   602: invokespecial 401	java/lang/Error:<init>	()V
    //   605: aload_1
    //   606: athrow
    //   607: aload_0
    //   608: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   611: aload_1
    //   612: iload 17
    //   614: invokestatic 398	io/netty/internal/tcnative/SSLContext:setAlpnProtos	(J[Ljava/lang/String;I)V
    //   617: goto +13 -> 630
    //   620: aload_0
    //   621: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   624: aload_1
    //   625: iload 17
    //   627: invokestatic 395	io/netty/internal/tcnative/SSLContext:setNpnProtos	(J[Ljava/lang/String;I)V
    //   630: lload 4
    //   632: lconst_0
    //   633: lcmp
    //   634: ifgt +18 -> 652
    //   637: aload_0
    //   638: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   641: ldc2_w 402
    //   644: invokestatic 407	io/netty/internal/tcnative/SSLContext:setSessionCacheSize	(JJ)J
    //   647: lstore 4
    //   649: goto +3 -> 652
    //   652: aload_0
    //   653: lload 4
    //   655: putfield 409	io/netty/handler/ssl/ReferenceCountedOpenSslContext:sessionCacheSize	J
    //   658: aload_0
    //   659: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   662: lload 4
    //   664: invokestatic 407	io/netty/internal/tcnative/SSLContext:setSessionCacheSize	(JJ)J
    //   667: pop2
    //   668: lload 6
    //   670: lconst_0
    //   671: lcmp
    //   672: ifgt +18 -> 690
    //   675: aload_0
    //   676: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   679: ldc2_w 410
    //   682: invokestatic 414	io/netty/internal/tcnative/SSLContext:setSessionCacheTimeout	(JJ)J
    //   685: lstore 4
    //   687: goto +7 -> 694
    //   690: lload 6
    //   692: lstore 4
    //   694: aload_0
    //   695: lload 4
    //   697: putfield 416	io/netty/handler/ssl/ReferenceCountedOpenSslContext:sessionTimeout	J
    //   700: aload_0
    //   701: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   704: lload 4
    //   706: invokestatic 414	io/netty/internal/tcnative/SSLContext:setSessionCacheTimeout	(JJ)J
    //   709: pop2
    //   710: iload 13
    //   712: ifeq +14 -> 726
    //   715: aload_0
    //   716: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   719: aload_0
    //   720: invokevirtual 419	io/netty/handler/ssl/ReferenceCountedOpenSslContext:isClient	()Z
    //   723: invokestatic 422	io/netty/internal/tcnative/SSLContext:enableOcsp	(JZ)V
    //   726: aload_0
    //   727: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   730: getstatic 98	io/netty/handler/ssl/ReferenceCountedOpenSslContext:USE_TASKS	Z
    //   733: invokestatic 425	io/netty/internal/tcnative/SSLContext:setUseTasks	(JZ)V
    //   736: return
    //   737: astore_1
    //   738: new 152	javax/net/ssl/SSLException
    //   741: astore_2
    //   742: new 129	java/lang/StringBuilder
    //   745: astore_3
    //   746: aload_3
    //   747: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   750: aload_3
    //   751: ldc_w 427
    //   754: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: pop
    //   758: aload_3
    //   759: aload_0
    //   760: getfield 265	io/netty/handler/ssl/ReferenceCountedOpenSslContext:unmodifiableCiphers	Ljava/util/List;
    //   763: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: aload_2
    //   768: aload_3
    //   769: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: aload_1
    //   773: invokespecial 433	javax/net/ssl/SSLException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   776: aload_2
    //   777: athrow
    //   778: astore_1
    //   779: aload_1
    //   780: athrow
    //   781: astore_1
    //   782: goto +18 -> 800
    //   785: astore_1
    //   786: new 152	javax/net/ssl/SSLException
    //   789: astore_2
    //   790: aload_2
    //   791: ldc_w 435
    //   794: aload_1
    //   795: invokespecial 433	javax/net/ssl/SSLException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   798: aload_2
    //   799: athrow
    //   800: aload_0
    //   801: invokevirtual 438	io/netty/handler/ssl/ReferenceCountedOpenSslContext:release	()Z
    //   804: pop
    //   805: aload_1
    //   806: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	807	0	this	ReferenceCountedOpenSslContext
    //   0	807	1	paramIterable	Iterable<String>
    //   0	807	2	paramCipherSuiteFilter	CipherSuiteFilter
    //   0	807	3	paramOpenSslApplicationProtocolNegotiator	OpenSslApplicationProtocolNegotiator
    //   0	807	4	paramLong1	long
    //   0	807	6	paramLong2	long
    //   0	807	8	paramInt	int
    //   0	807	9	paramArrayOfCertificate	Certificate[]
    //   0	807	10	paramClientAuth	ClientAuth
    //   0	807	11	paramArrayOfString	String[]
    //   0	807	12	paramBoolean1	boolean
    //   0	807	13	paramBoolean2	boolean
    //   0	807	14	paramBoolean3	boolean
    //   19	166	15	localObject	Object
    //   114	10	16	localResourceLeakTracker	ResourceLeakTracker
    //   253	373	17	i	int
    //   464	5	18	l	long
    // Exception table:
    //   from	to	target	type
    //   299	320	737	java/lang/Exception
    //   325	337	737	java/lang/Exception
    //   340	364	737	java/lang/Exception
    //   369	382	737	java/lang/Exception
    //   299	320	778	javax/net/ssl/SSLException
    //   325	337	778	javax/net/ssl/SSLException
    //   340	364	778	javax/net/ssl/SSLException
    //   369	382	778	javax/net/ssl/SSLException
    //   255	261	781	finally
    //   265	276	781	finally
    //   276	299	781	finally
    //   299	320	781	finally
    //   325	337	781	finally
    //   340	364	781	finally
    //   369	382	781	finally
    //   382	415	781	finally
    //   419	451	781	finally
    //   451	485	781	finally
    //   489	500	781	finally
    //   500	556	781	finally
    //   574	594	781	finally
    //   597	607	781	finally
    //   607	617	781	finally
    //   620	630	781	finally
    //   637	649	781	finally
    //   652	668	781	finally
    //   675	687	781	finally
    //   694	710	781	finally
    //   715	726	781	finally
    //   726	736	781	finally
    //   738	778	781	finally
    //   779	781	781	finally
    //   786	800	781	finally
    //   255	261	785	java/lang/Exception
    //   265	276	785	java/lang/Exception
  }
  
  protected static X509Certificate[] certificates(byte[][] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    X509Certificate[] arrayOfX509Certificate = new X509Certificate[i];
    for (int j = 0; j < i; j++) {
      arrayOfX509Certificate[j] = new OpenSslX509Certificate(paramArrayOfByte[j]);
    }
    return arrayOfX509Certificate;
  }
  
  protected static X509TrustManager chooseTrustManager(TrustManager[] paramArrayOfTrustManager)
  {
    int i = paramArrayOfTrustManager.length;
    for (int j = 0; j < i; j++)
    {
      TrustManager localTrustManager = paramArrayOfTrustManager[j];
      if ((localTrustManager instanceof X509TrustManager))
      {
        if (PlatformDependent.javaVersion() >= 7) {
          return OpenSslX509TrustManagerWrapper.wrapIfNeeded((X509TrustManager)localTrustManager);
        }
        return (X509TrustManager)localTrustManager;
      }
    }
    throw new IllegalStateException("no X509TrustManager found");
  }
  
  protected static X509KeyManager chooseX509KeyManager(KeyManager[] paramArrayOfKeyManager)
  {
    int i = paramArrayOfKeyManager.length;
    for (int j = 0; j < i; j++)
    {
      KeyManager localKeyManager = paramArrayOfKeyManager[j];
      if ((localKeyManager instanceof X509KeyManager)) {
        return (X509KeyManager)localKeyManager;
      }
    }
    throw new IllegalStateException("no X509KeyManager found");
  }
  
  private void destroy()
  {
    Lock localLock = this.ctxLock.writeLock();
    localLock.lock();
    try
    {
      long l = this.ctx;
      if (l != 0L)
      {
        if (this.enableOcsp) {
          SSLContext.disableOcsp(l);
        }
        SSLContext.free(this.ctx);
        this.ctx = 0L;
        OpenSslSessionContext localOpenSslSessionContext = sessionContext();
        if (localOpenSslSessionContext != null) {
          localOpenSslSessionContext.destroy();
        }
      }
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  static void freeBio(long paramLong)
  {
    if (paramLong != 0L) {
      SSL.freeBIO(paramLong);
    }
  }
  
  private static long newBIO(ByteBuf paramByteBuf)
    throws Exception
  {
    try
    {
      long l = SSL.newMemBIO();
      int i = paramByteBuf.readableBytes();
      int j = SSL.bioWrite(l, OpenSsl.memoryAddress(paramByteBuf) + paramByteBuf.readerIndex(), i);
      if (j == i) {
        return l;
      }
      SSL.freeBIO(l);
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("Could not write data to memory BIO");
      throw localIllegalStateException;
    }
    finally
    {
      paramByteBuf.release();
    }
  }
  
  private static int opensslSelectorFailureBehavior(ApplicationProtocolConfig.SelectorFailureBehavior paramSelectorFailureBehavior)
  {
    int i = 3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[paramSelectorFailureBehavior.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return 1;
      }
      throw new Error();
    }
    return 0;
  }
  
  static OpenSslKeyMaterialProvider providerFor(KeyManagerFactory paramKeyManagerFactory, String paramString)
  {
    if ((paramKeyManagerFactory instanceof OpenSslX509KeyManagerFactory)) {
      return ((OpenSslX509KeyManagerFactory)paramKeyManagerFactory).newProvider();
    }
    if ((paramKeyManagerFactory instanceof OpenSslCachingX509KeyManagerFactory)) {
      return ((OpenSslCachingX509KeyManagerFactory)paramKeyManagerFactory).newProvider(paramString);
    }
    return new OpenSslKeyMaterialProvider(chooseX509KeyManager(paramKeyManagerFactory.getKeyManagers()), paramString);
  }
  
  /* Error */
  static void setKeyMaterial(long paramLong, X509Certificate[] paramArrayOfX509Certificate, PrivateKey paramPrivateKey, String paramString)
    throws SSLException
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 9
    //   12: aload 9
    //   14: astore 10
    //   16: aload 7
    //   18: astore 11
    //   20: aload 8
    //   22: astore 12
    //   24: getstatic 572	io/netty/buffer/ByteBufAllocator:DEFAULT	Lio/netty/buffer/ByteBufAllocator;
    //   27: astore 13
    //   29: aload 9
    //   31: astore 10
    //   33: aload 7
    //   35: astore 11
    //   37: aload 8
    //   39: astore 12
    //   41: aload 13
    //   43: iconst_1
    //   44: aload_2
    //   45: invokestatic 578	io/netty/handler/ssl/PemX509Certificate:toPEM	(Lio/netty/buffer/ByteBufAllocator;Z[Ljava/security/cert/X509Certificate;)Lio/netty/handler/ssl/PemEncoded;
    //   48: astore_2
    //   49: aload_2
    //   50: astore 10
    //   52: aload_2
    //   53: astore 11
    //   55: aload_2
    //   56: astore 12
    //   58: aload 13
    //   60: aload_2
    //   61: invokeinterface 584 1 0
    //   66: invokestatic 588	io/netty/handler/ssl/ReferenceCountedOpenSslContext:toBIO	(Lio/netty/buffer/ByteBufAllocator;Lio/netty/handler/ssl/PemEncoded;)J
    //   69: lstore 14
    //   71: aload 13
    //   73: aload_2
    //   74: invokeinterface 584 1 0
    //   79: invokestatic 588	io/netty/handler/ssl/ReferenceCountedOpenSslContext:toBIO	(Lio/netty/buffer/ByteBufAllocator;Lio/netty/handler/ssl/PemEncoded;)J
    //   82: lstore 16
    //   84: lload 5
    //   86: lstore 18
    //   88: aload_3
    //   89: ifnull +34 -> 123
    //   92: lload 5
    //   94: lstore 20
    //   96: lload 5
    //   98: lstore 22
    //   100: aload_2
    //   101: astore 10
    //   103: lload 16
    //   105: lstore 18
    //   107: lload 14
    //   109: lstore 24
    //   111: aload 13
    //   113: aload_3
    //   114: invokestatic 591	io/netty/handler/ssl/ReferenceCountedOpenSslContext:toBIO	(Lio/netty/buffer/ByteBufAllocator;Ljava/security/PrivateKey;)J
    //   117: lstore 26
    //   119: lload 26
    //   121: lstore 18
    //   123: aload 4
    //   125: ifnonnull +25 -> 150
    //   128: ldc_w 288
    //   131: astore_3
    //   132: goto +21 -> 153
    //   135: astore_3
    //   136: lload 20
    //   138: lstore_0
    //   139: goto +134 -> 273
    //   142: astore_3
    //   143: lload 22
    //   145: lstore 5
    //   147: goto +196 -> 343
    //   150: aload 4
    //   152: astore_3
    //   153: lload_0
    //   154: lload 14
    //   156: lload 18
    //   158: aload_3
    //   159: invokestatic 595	io/netty/internal/tcnative/SSLContext:setCertificateBio	(JJJLjava/lang/String;)Z
    //   162: pop
    //   163: lload_0
    //   164: lload 16
    //   166: iconst_1
    //   167: invokestatic 599	io/netty/internal/tcnative/SSLContext:setCertificateChainBio	(JJZ)Z
    //   170: pop
    //   171: lload 18
    //   173: invokestatic 601	io/netty/handler/ssl/ReferenceCountedOpenSslContext:freeBio	(J)V
    //   176: lload 14
    //   178: invokestatic 601	io/netty/handler/ssl/ReferenceCountedOpenSslContext:freeBio	(J)V
    //   181: lload 16
    //   183: invokestatic 601	io/netty/handler/ssl/ReferenceCountedOpenSslContext:freeBio	(J)V
    //   186: aload_2
    //   187: invokeinterface 533 1 0
    //   192: pop
    //   193: return
    //   194: astore_3
    //   195: lload 18
    //   197: lstore 5
    //   199: lload 16
    //   201: lstore 18
    //   203: goto +161 -> 364
    //   206: astore_3
    //   207: lload 18
    //   209: lstore_0
    //   210: goto +63 -> 273
    //   213: astore_3
    //   214: lload 18
    //   216: lstore 5
    //   218: goto +125 -> 343
    //   221: astore_3
    //   222: lconst_0
    //   223: lstore 18
    //   225: goto +139 -> 364
    //   228: astore_3
    //   229: lconst_0
    //   230: lstore 16
    //   232: lload 5
    //   234: lstore_0
    //   235: goto +38 -> 273
    //   238: astore_3
    //   239: lconst_0
    //   240: lstore 16
    //   242: goto +101 -> 343
    //   245: astore_3
    //   246: lconst_0
    //   247: lstore 18
    //   249: lload 18
    //   251: lstore 14
    //   253: aload 10
    //   255: astore_2
    //   256: goto +108 -> 364
    //   259: astore_3
    //   260: lconst_0
    //   261: lstore 16
    //   263: lload 16
    //   265: lstore 14
    //   267: aload 11
    //   269: astore_2
    //   270: lload 5
    //   272: lstore_0
    //   273: lload_0
    //   274: lstore 5
    //   276: aload_2
    //   277: astore 10
    //   279: lload 16
    //   281: lstore 18
    //   283: lload 14
    //   285: lstore 24
    //   287: new 152	javax/net/ssl/SSLException
    //   290: astore 4
    //   292: lload_0
    //   293: lstore 5
    //   295: aload_2
    //   296: astore 10
    //   298: lload 16
    //   300: lstore 18
    //   302: lload 14
    //   304: lstore 24
    //   306: aload 4
    //   308: ldc_w 603
    //   311: aload_3
    //   312: invokespecial 433	javax/net/ssl/SSLException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   315: lload_0
    //   316: lstore 5
    //   318: aload_2
    //   319: astore 10
    //   321: lload 16
    //   323: lstore 18
    //   325: lload 14
    //   327: lstore 24
    //   329: aload 4
    //   331: athrow
    //   332: astore_3
    //   333: lconst_0
    //   334: lstore 16
    //   336: lload 16
    //   338: lstore 14
    //   340: aload 12
    //   342: astore_2
    //   343: aload_2
    //   344: astore 10
    //   346: lload 16
    //   348: lstore 18
    //   350: lload 14
    //   352: lstore 24
    //   354: aload_3
    //   355: athrow
    //   356: astore_3
    //   357: lload 24
    //   359: lstore 14
    //   361: aload 10
    //   363: astore_2
    //   364: lload 5
    //   366: invokestatic 601	io/netty/handler/ssl/ReferenceCountedOpenSslContext:freeBio	(J)V
    //   369: lload 14
    //   371: invokestatic 601	io/netty/handler/ssl/ReferenceCountedOpenSslContext:freeBio	(J)V
    //   374: lload 18
    //   376: invokestatic 601	io/netty/handler/ssl/ReferenceCountedOpenSslContext:freeBio	(J)V
    //   379: aload_2
    //   380: ifnull +10 -> 390
    //   383: aload_2
    //   384: invokeinterface 533 1 0
    //   389: pop
    //   390: aload_3
    //   391: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramLong	long
    //   0	392	2	paramArrayOfX509Certificate	X509Certificate[]
    //   0	392	3	paramPrivateKey	PrivateKey
    //   0	392	4	paramString	String
    //   1	364	5	l1	long
    //   4	30	7	localObject1	Object
    //   7	31	8	localObject2	Object
    //   10	20	9	localObject3	Object
    //   14	348	10	localObject4	Object
    //   18	250	11	localObject5	Object
    //   22	319	12	localObject6	Object
    //   27	85	13	localByteBufAllocator	ByteBufAllocator
    //   69	301	14	l2	long
    //   82	265	16	l3	long
    //   86	289	18	l4	long
    //   94	43	20	l5	long
    //   98	46	22	l6	long
    //   109	249	24	l7	long
    //   117	3	26	l8	long
    // Exception table:
    //   from	to	target	type
    //   111	119	135	java/lang/Exception
    //   111	119	142	javax/net/ssl/SSLException
    //   153	171	194	finally
    //   153	171	206	java/lang/Exception
    //   153	171	213	javax/net/ssl/SSLException
    //   71	84	221	finally
    //   71	84	228	java/lang/Exception
    //   71	84	238	javax/net/ssl/SSLException
    //   24	29	245	finally
    //   41	49	245	finally
    //   58	71	245	finally
    //   24	29	259	java/lang/Exception
    //   41	49	259	java/lang/Exception
    //   58	71	259	java/lang/Exception
    //   24	29	332	javax/net/ssl/SSLException
    //   41	49	332	javax/net/ssl/SSLException
    //   58	71	332	javax/net/ssl/SSLException
    //   111	119	356	finally
    //   287	292	356	finally
    //   306	315	356	finally
    //   329	332	356	finally
    //   354	356	356	finally
  }
  
  /* Error */
  static long toBIO(ByteBufAllocator paramByteBufAllocator, PemEncoded paramPemEncoded)
    throws Exception
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 609 1 0
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 612	io/netty/buffer/ByteBuf:isDirect	()Z
    //   11: ifeq +20 -> 31
    //   14: aload_2
    //   15: invokevirtual 615	io/netty/buffer/ByteBuf:retainedSlice	()Lio/netty/buffer/ByteBuf;
    //   18: invokestatic 617	io/netty/handler/ssl/ReferenceCountedOpenSslContext:newBIO	(Lio/netty/buffer/ByteBuf;)J
    //   21: lstore_3
    //   22: aload_1
    //   23: invokeinterface 533 1 0
    //   28: pop
    //   29: lload_3
    //   30: lreturn
    //   31: aload_0
    //   32: aload_2
    //   33: invokevirtual 522	io/netty/buffer/ByteBuf:readableBytes	()I
    //   36: invokeinterface 621 2 0
    //   41: astore_0
    //   42: aload_0
    //   43: aload_2
    //   44: aload_2
    //   45: invokevirtual 528	io/netty/buffer/ByteBuf:readerIndex	()I
    //   48: aload_2
    //   49: invokevirtual 522	io/netty/buffer/ByteBuf:readableBytes	()I
    //   52: invokevirtual 625	io/netty/buffer/ByteBuf:writeBytes	(Lio/netty/buffer/ByteBuf;II)Lio/netty/buffer/ByteBuf;
    //   55: pop
    //   56: aload_0
    //   57: invokevirtual 615	io/netty/buffer/ByteBuf:retainedSlice	()Lio/netty/buffer/ByteBuf;
    //   60: invokestatic 617	io/netty/handler/ssl/ReferenceCountedOpenSslContext:newBIO	(Lio/netty/buffer/ByteBuf;)J
    //   63: lstore_3
    //   64: aload_1
    //   65: invokeinterface 628 1 0
    //   70: ifeq +7 -> 77
    //   73: aload_0
    //   74: invokestatic 634	io/netty/handler/ssl/SslUtils:zeroout	(Lio/netty/buffer/ByteBuf;)V
    //   77: aload_0
    //   78: invokeinterface 533 1 0
    //   83: pop
    //   84: aload_1
    //   85: invokeinterface 533 1 0
    //   90: pop
    //   91: lload_3
    //   92: lreturn
    //   93: astore_2
    //   94: aload_0
    //   95: invokeinterface 533 1 0
    //   100: pop
    //   101: aload_2
    //   102: athrow
    //   103: astore_2
    //   104: aload_1
    //   105: invokeinterface 628 1 0
    //   110: ifeq +7 -> 117
    //   113: aload_0
    //   114: invokestatic 634	io/netty/handler/ssl/SslUtils:zeroout	(Lio/netty/buffer/ByteBuf;)V
    //   117: aload_0
    //   118: invokeinterface 533 1 0
    //   123: pop
    //   124: aload_2
    //   125: athrow
    //   126: astore_2
    //   127: aload_0
    //   128: invokeinterface 533 1 0
    //   133: pop
    //   134: aload_2
    //   135: athrow
    //   136: astore_0
    //   137: aload_1
    //   138: invokeinterface 533 1 0
    //   143: pop
    //   144: aload_0
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramByteBufAllocator	ByteBufAllocator
    //   0	146	1	paramPemEncoded	PemEncoded
    //   6	43	2	localByteBuf	ByteBuf
    //   93	9	2	localObject1	Object
    //   103	22	2	localObject2	Object
    //   126	9	2	localObject3	Object
    //   21	71	3	l	long
    // Exception table:
    //   from	to	target	type
    //   64	77	93	finally
    //   42	64	103	finally
    //   104	117	126	finally
    //   0	22	136	finally
    //   31	42	136	finally
    //   77	84	136	finally
    //   94	103	136	finally
    //   117	126	136	finally
    //   127	136	136	finally
  }
  
  static long toBIO(ByteBufAllocator paramByteBufAllocator, PrivateKey paramPrivateKey)
    throws Exception
  {
    if (paramPrivateKey == null) {
      return 0L;
    }
    paramPrivateKey = PemPrivateKey.toPEM(paramByteBufAllocator, true, paramPrivateKey);
    try
    {
      long l = toBIO(paramByteBufAllocator, paramPrivateKey.retain());
      return l;
    }
    finally
    {
      paramPrivateKey.release();
    }
  }
  
  static long toBIO(ByteBufAllocator paramByteBufAllocator, X509Certificate... paramVarArgs)
    throws Exception
  {
    if (paramVarArgs == null) {
      return 0L;
    }
    if (paramVarArgs.length != 0)
    {
      paramVarArgs = PemX509Certificate.toPEM(paramByteBufAllocator, true, paramVarArgs);
      try
      {
        long l = toBIO(paramByteBufAllocator, paramVarArgs.retain());
        return l;
      }
      finally
      {
        paramVarArgs.release();
      }
    }
    throw new IllegalArgumentException("certChain can't be empty");
  }
  
  static OpenSslApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig paramApplicationProtocolConfig)
  {
    if (paramApplicationProtocolConfig == null) {
      return NONE_PROTOCOL_NEGOTIATOR;
    }
    int i = 3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[paramApplicationProtocolConfig.protocol().ordinal()];
    if ((i != 1) && (i != 2) && (i != 3))
    {
      if (i == 4) {
        return NONE_PROTOCOL_NEGOTIATOR;
      }
      throw new Error();
    }
    i = 3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[paramApplicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
    StringBuilder localStringBuilder;
    if ((i != 1) && (i != 2))
    {
      localStringBuilder = new StringBuilder("OpenSSL provider does not support ");
      localStringBuilder.append(paramApplicationProtocolConfig.selectedListenerFailureBehavior());
      localStringBuilder.append(" behavior");
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
    i = 3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[paramApplicationProtocolConfig.selectorFailureBehavior().ordinal()];
    if ((i != 1) && (i != 2))
    {
      localStringBuilder = new StringBuilder("OpenSSL provider does not support ");
      localStringBuilder.append(paramApplicationProtocolConfig.selectorFailureBehavior());
      localStringBuilder.append(" behavior");
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
    return new OpenSslDefaultApplicationProtocolNegotiator(paramApplicationProtocolConfig);
  }
  
  @SuppressJava6Requirement(reason="Guarded by java version check")
  static boolean useExtendedTrustManager(X509TrustManager paramX509TrustManager)
  {
    boolean bool;
    if ((PlatformDependent.javaVersion() >= 7) && ((paramX509TrustManager instanceof X509ExtendedTrustManager))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public ApplicationProtocolNegotiator applicationProtocolNegotiator()
  {
    return this.apn;
  }
  
  public final List<String> cipherSuites()
  {
    return this.unmodifiableCiphers;
  }
  
  @Deprecated
  public final long context()
  {
    return sslCtxPointer();
  }
  
  public int getBioNonApplicationBufferSize()
  {
    return this.bioNonApplicationBufferSize;
  }
  
  @Deprecated
  public boolean getRejectRemoteInitiatedRenegotiation()
  {
    return true;
  }
  
  public final boolean isClient()
  {
    boolean bool;
    if (this.mode == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final SSLEngine newEngine(ByteBufAllocator paramByteBufAllocator)
  {
    return newEngine(paramByteBufAllocator, null, -1);
  }
  
  public final SSLEngine newEngine(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt)
  {
    return newEngine0(paramByteBufAllocator, paramString, paramInt, true);
  }
  
  SSLEngine newEngine0(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt, boolean paramBoolean)
  {
    return new ReferenceCountedOpenSslEngine(this, paramByteBufAllocator, paramString, paramInt, paramBoolean, true);
  }
  
  protected final SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt, boolean paramBoolean)
  {
    return new SslHandler(newEngine0(paramByteBufAllocator, paramString, paramInt, false), paramBoolean);
  }
  
  protected SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt, boolean paramBoolean, Executor paramExecutor)
  {
    return new SslHandler(newEngine0(paramByteBufAllocator, paramString, paramInt, false), paramExecutor);
  }
  
  protected final SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean)
  {
    return new SslHandler(newEngine0(paramByteBufAllocator, null, -1, false), paramBoolean);
  }
  
  protected SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, Executor paramExecutor)
  {
    return new SslHandler(newEngine0(paramByteBufAllocator, null, -1, false), paramBoolean, paramExecutor);
  }
  
  public final int refCnt()
  {
    return this.refCnt.refCnt();
  }
  
  public final boolean release()
  {
    return this.refCnt.release();
  }
  
  public final boolean release(int paramInt)
  {
    return this.refCnt.release(paramInt);
  }
  
  public final ReferenceCounted retain()
  {
    this.refCnt.retain();
    return this;
  }
  
  public final ReferenceCounted retain(int paramInt)
  {
    this.refCnt.retain(paramInt);
    return this;
  }
  
  public final long sessionCacheSize()
  {
    return this.sessionCacheSize;
  }
  
  public abstract OpenSslSessionContext sessionContext();
  
  public final long sessionTimeout()
  {
    return this.sessionTimeout;
  }
  
  public void setBioNonApplicationBufferSize(int paramInt)
  {
    this.bioNonApplicationBufferSize = ObjectUtil.checkPositiveOrZero(paramInt, "bioNonApplicationBufferSize");
  }
  
  public final void setPrivateKeyMethod(OpenSslPrivateKeyMethod paramOpenSslPrivateKeyMethod)
  {
    ObjectUtil.checkNotNull(paramOpenSslPrivateKeyMethod, "method");
    Lock localLock = this.ctxLock.writeLock();
    localLock.lock();
    try
    {
      long l = this.ctx;
      PrivateKeyMethod localPrivateKeyMethod = new io/netty/handler/ssl/ReferenceCountedOpenSslContext$PrivateKeyMethod;
      localPrivateKeyMethod.<init>(this.engineMap, paramOpenSslPrivateKeyMethod);
      SSLContext.setPrivateKeyMethod(l, localPrivateKeyMethod);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @Deprecated
  public void setRejectRemoteInitiatedRenegotiation(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new UnsupportedOperationException("Renegotiation is not supported");
  }
  
  @Deprecated
  public final void setTicketKeys(byte[] paramArrayOfByte)
  {
    sessionContext().setTicketKeys(paramArrayOfByte);
  }
  
  public final void setUseTasks(boolean paramBoolean)
  {
    Lock localLock = this.ctxLock.writeLock();
    localLock.lock();
    try
    {
      SSLContext.setUseTasks(this.ctx, paramBoolean);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @Deprecated
  public final long sslCtxPointer()
  {
    Lock localLock = this.ctxLock.readLock();
    localLock.lock();
    try
    {
      long l = SSLContext.getSslCtx(this.ctx);
      return l;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @Deprecated
  public final OpenSslSessionStats stats()
  {
    return sessionContext().stats();
  }
  
  public final ReferenceCounted touch()
  {
    this.refCnt.touch();
    return this;
  }
  
  public final ReferenceCounted touch(Object paramObject)
  {
    this.refCnt.touch(paramObject);
    return this;
  }
  
  static abstract class AbstractCertificateVerifier
    extends CertificateVerifier
  {
    private final OpenSslEngineMap engineMap;
    
    AbstractCertificateVerifier(OpenSslEngineMap paramOpenSslEngineMap)
    {
      this.engineMap = paramOpenSslEngineMap;
    }
    
    @SuppressJava6Requirement(reason="Usage guarded by java version check")
    private static int translateToError(Throwable paramThrowable)
    {
      if ((paramThrowable instanceof CertificateRevokedException)) {
        return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
      }
      for (paramThrowable = paramThrowable.getCause(); paramThrowable != null; paramThrowable = paramThrowable.getCause()) {
        if ((paramThrowable instanceof CertPathValidatorException))
        {
          CertPathValidatorException.Reason localReason = ((CertPathValidatorException)paramThrowable).getReason();
          if (localReason == CertPathValidatorException.BasicReason.EXPIRED) {
            return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
          }
          if (localReason == CertPathValidatorException.BasicReason.NOT_YET_VALID) {
            return CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID;
          }
          if (localReason == CertPathValidatorException.BasicReason.REVOKED) {
            return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
          }
        }
      }
      return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
    }
    
    public final int verify(long paramLong, byte[][] paramArrayOfByte, String paramString)
    {
      ReferenceCountedOpenSslEngine localReferenceCountedOpenSslEngine = this.engineMap.get(paramLong);
      if (localReferenceCountedOpenSslEngine == null) {
        return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
      }
      paramArrayOfByte = ReferenceCountedOpenSslContext.certificates(paramArrayOfByte);
      try
      {
        verify(localReferenceCountedOpenSslEngine, paramArrayOfByte, paramString);
        int i = CertificateVerifier.X509_V_OK;
        return i;
      }
      finally
      {
        ReferenceCountedOpenSslContext.logger.debug("verification of certificate failed", paramArrayOfByte);
        localReferenceCountedOpenSslEngine.initHandshakeException(paramArrayOfByte);
        if ((paramArrayOfByte instanceof OpenSslCertificateException)) {
          return ((OpenSslCertificateException)paramArrayOfByte).errorCode();
        }
        if ((paramArrayOfByte instanceof CertificateExpiredException)) {
          return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
        }
        if ((paramArrayOfByte instanceof CertificateNotYetValidException)) {
          return CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID;
        }
        if (PlatformDependent.javaVersion() >= 7) {
          return translateToError(paramArrayOfByte);
        }
      }
      return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
    }
    
    abstract void verify(ReferenceCountedOpenSslEngine paramReferenceCountedOpenSslEngine, X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws Exception;
  }
  
  private static final class DefaultOpenSslEngineMap
    implements OpenSslEngineMap
  {
    private final Map<Long, ReferenceCountedOpenSslEngine> engines = PlatformDependent.newConcurrentHashMap();
    
    public void add(ReferenceCountedOpenSslEngine paramReferenceCountedOpenSslEngine)
    {
      this.engines.put(Long.valueOf(paramReferenceCountedOpenSslEngine.sslPointer()), paramReferenceCountedOpenSslEngine);
    }
    
    public ReferenceCountedOpenSslEngine get(long paramLong)
    {
      return (ReferenceCountedOpenSslEngine)this.engines.get(Long.valueOf(paramLong));
    }
    
    public ReferenceCountedOpenSslEngine remove(long paramLong)
    {
      return (ReferenceCountedOpenSslEngine)this.engines.remove(Long.valueOf(paramLong));
    }
  }
  
  private static final class PrivateKeyMethod
    implements SSLPrivateKeyMethod
  {
    private final OpenSslEngineMap engineMap;
    private final OpenSslPrivateKeyMethod keyMethod;
    
    PrivateKeyMethod(OpenSslEngineMap paramOpenSslEngineMap, OpenSslPrivateKeyMethod paramOpenSslPrivateKeyMethod)
    {
      this.engineMap = paramOpenSslEngineMap;
      this.keyMethod = paramOpenSslPrivateKeyMethod;
    }
    
    private ReferenceCountedOpenSslEngine retrieveEngine(long paramLong)
      throws SSLException
    {
      Object localObject = this.engineMap.get(paramLong);
      if (localObject != null) {
        return (ReferenceCountedOpenSslEngine)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not find a ");
      ((StringBuilder)localObject).append(StringUtil.simpleClassName(ReferenceCountedOpenSslEngine.class));
      ((StringBuilder)localObject).append(" for sslPointer ");
      ((StringBuilder)localObject).append(paramLong);
      throw new SSLException(((StringBuilder)localObject).toString());
    }
    
    private static byte[] verifyResult(byte[] paramArrayOfByte)
      throws SignatureException
    {
      if (paramArrayOfByte != null) {
        return paramArrayOfByte;
      }
      throw new SignatureException();
    }
    
    public byte[] decrypt(long paramLong, byte[] paramArrayOfByte)
      throws Exception
    {
      ReferenceCountedOpenSslEngine localReferenceCountedOpenSslEngine = retrieveEngine(paramLong);
      try
      {
        paramArrayOfByte = verifyResult(this.keyMethod.decrypt(localReferenceCountedOpenSslEngine, paramArrayOfByte));
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        localReferenceCountedOpenSslEngine.initHandshakeException(paramArrayOfByte);
        throw paramArrayOfByte;
      }
    }
    
    public byte[] sign(long paramLong, int paramInt, byte[] paramArrayOfByte)
      throws Exception
    {
      ReferenceCountedOpenSslEngine localReferenceCountedOpenSslEngine = retrieveEngine(paramLong);
      try
      {
        paramArrayOfByte = verifyResult(this.keyMethod.sign(localReferenceCountedOpenSslEngine, paramInt, paramArrayOfByte));
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        localReferenceCountedOpenSslEngine.initHandshakeException(paramArrayOfByte);
        throw paramArrayOfByte;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\ReferenceCountedOpenSslContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */