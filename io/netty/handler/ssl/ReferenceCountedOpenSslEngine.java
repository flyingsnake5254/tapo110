package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLEngineResult.Status;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;

public class ReferenceCountedOpenSslEngine
  extends SSLEngine
  implements ReferenceCounted, ApplicationProtocolAccessor
{
  private static final SSLEngineResult CLOSED_NOT_HANDSHAKING = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
  static final int MAX_PLAINTEXT_LENGTH;
  private static final int MAX_RECORD_SIZE;
  private static final SSLEngineResult NEED_UNWRAP_CLOSED;
  private static final SSLEngineResult NEED_UNWRAP_OK;
  private static final SSLEngineResult NEED_WRAP_CLOSED;
  private static final SSLEngineResult NEED_WRAP_OK;
  private static final int[] OPENSSL_OP_NO_PROTOCOLS;
  private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV2 = 0;
  private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV3 = 1;
  private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1 = 2;
  private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_1 = 3;
  private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_2 = 4;
  private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_3 = 5;
  private static final ResourceLeakDetector<ReferenceCountedOpenSslEngine> leakDetector;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslEngine.class);
  private Object algorithmConstraints;
  final ByteBufAllocator alloc;
  private final OpenSslApplicationProtocolNegotiator apn;
  private volatile String applicationProtocol;
  private volatile ClientAuth clientAuth;
  private final boolean clientMode;
  private volatile boolean destroyed;
  private final boolean enableOcsp;
  private String endPointIdentificationAlgorithm;
  private final OpenSslEngineMap engineMap;
  private HandshakeState handshakeState;
  private boolean isInboundDone;
  final boolean jdkCompatibilityMode;
  private volatile long lastAccessed;
  private final ResourceLeakTracker<ReferenceCountedOpenSslEngine> leak;
  private volatile Certificate[] localCertificateChain;
  private volatile Collection<?> matchers;
  private int maxWrapBufferSize;
  private int maxWrapOverhead;
  private volatile boolean needTask;
  private long networkBIO;
  private boolean outboundClosed;
  private final ReferenceCountedOpenSslContext parentContext;
  private Throwable pendingException;
  private boolean receivedShutdown;
  private final AbstractReferenceCounted refCnt;
  private final OpenSslSession session;
  private final ByteBuffer[] singleDstBuffer;
  private final ByteBuffer[] singleSrcBuffer;
  private List<String> sniHostNames;
  private long ssl;
  
  static
  {
    leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslEngine.class);
    OPENSSL_OP_NO_PROTOCOLS = new int[] { SSL.SSL_OP_NO_SSLv2, SSL.SSL_OP_NO_SSLv3, SSL.SSL_OP_NO_TLSv1, SSL.SSL_OP_NO_TLSv1_1, SSL.SSL_OP_NO_TLSv1_2, SSL.SSL_OP_NO_TLSv1_3 };
    MAX_PLAINTEXT_LENGTH = SSL.SSL_MAX_PLAINTEXT_LENGTH;
    MAX_RECORD_SIZE = SSL.SSL_MAX_RECORD_LENGTH;
    NEED_UNWRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
    NEED_UNWRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
    NEED_WRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
    NEED_WRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
  }
  
  /* Error */
  ReferenceCountedOpenSslEngine(ReferenceCountedOpenSslContext paramReferenceCountedOpenSslContext, ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_3
    //   2: iload 4
    //   4: invokespecial 199	javax/net/ssl/SSLEngine:<init>	(Ljava/lang/String;I)V
    //   7: aload_0
    //   8: getstatic 202	io/netty/handler/ssl/ReferenceCountedOpenSslEngine$HandshakeState:NOT_STARTED	Lio/netty/handler/ssl/ReferenceCountedOpenSslEngine$HandshakeState;
    //   11: putfield 204	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:handshakeState	Lio/netty/handler/ssl/ReferenceCountedOpenSslEngine$HandshakeState;
    //   14: aload_0
    //   15: new 10	io/netty/handler/ssl/ReferenceCountedOpenSslEngine$1
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 207	io/netty/handler/ssl/ReferenceCountedOpenSslEngine$1:<init>	(Lio/netty/handler/ssl/ReferenceCountedOpenSslEngine;)V
    //   23: putfield 209	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:refCnt	Lio/netty/util/AbstractReferenceCounted;
    //   26: getstatic 214	io/netty/handler/ssl/ClientAuth:NONE	Lio/netty/handler/ssl/ClientAuth;
    //   29: astore 7
    //   31: aload_0
    //   32: aload 7
    //   34: putfield 216	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:clientAuth	Lio/netty/handler/ssl/ClientAuth;
    //   37: aload_0
    //   38: ldc2_w 217
    //   41: putfield 220	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:lastAccessed	J
    //   44: iconst_1
    //   45: istore 8
    //   47: aload_0
    //   48: iconst_1
    //   49: anewarray 222	java/nio/ByteBuffer
    //   52: putfield 224	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:singleSrcBuffer	[Ljava/nio/ByteBuffer;
    //   55: aload_0
    //   56: iconst_1
    //   57: anewarray 222	java/nio/ByteBuffer
    //   60: putfield 226	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:singleDstBuffer	[Ljava/nio/ByteBuffer;
    //   63: invokestatic 231	io/netty/handler/ssl/OpenSsl:ensureAvailability	()V
    //   66: aload_0
    //   67: aload_2
    //   68: ldc -24
    //   70: invokestatic 238	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   73: checkcast 240	io/netty/buffer/ByteBufAllocator
    //   76: putfield 242	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:alloc	Lio/netty/buffer/ByteBufAllocator;
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 248	io/netty/handler/ssl/ReferenceCountedOpenSslContext:applicationProtocolNegotiator	()Lio/netty/handler/ssl/ApplicationProtocolNegotiator;
    //   84: checkcast 250	io/netty/handler/ssl/OpenSslApplicationProtocolNegotiator
    //   87: putfield 252	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:apn	Lio/netty/handler/ssl/OpenSslApplicationProtocolNegotiator;
    //   90: aload_1
    //   91: invokevirtual 256	io/netty/handler/ssl/ReferenceCountedOpenSslContext:isClient	()Z
    //   94: istore 9
    //   96: aload_0
    //   97: iload 9
    //   99: putfield 258	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:clientMode	Z
    //   102: invokestatic 264	io/netty/util/internal/PlatformDependent:javaVersion	()I
    //   105: bipush 7
    //   107: if_icmplt +30 -> 137
    //   110: aload_0
    //   111: new 12	io/netty/handler/ssl/ReferenceCountedOpenSslEngine$2
    //   114: dup
    //   115: aload_0
    //   116: new 18	io/netty/handler/ssl/ReferenceCountedOpenSslEngine$DefaultOpenSslSession
    //   119: dup
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 268	io/netty/handler/ssl/ReferenceCountedOpenSslContext:sessionContext	()Lio/netty/handler/ssl/OpenSslSessionContext;
    //   125: invokespecial 271	io/netty/handler/ssl/ReferenceCountedOpenSslEngine$DefaultOpenSslSession:<init>	(Lio/netty/handler/ssl/ReferenceCountedOpenSslEngine;Lio/netty/handler/ssl/OpenSslSessionContext;)V
    //   128: invokespecial 274	io/netty/handler/ssl/ReferenceCountedOpenSslEngine$2:<init>	(Lio/netty/handler/ssl/ReferenceCountedOpenSslEngine;Lio/netty/handler/ssl/OpenSslSession;)V
    //   131: putfield 276	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:session	Lio/netty/handler/ssl/OpenSslSession;
    //   134: goto +19 -> 153
    //   137: aload_0
    //   138: new 18	io/netty/handler/ssl/ReferenceCountedOpenSslEngine$DefaultOpenSslSession
    //   141: dup
    //   142: aload_0
    //   143: aload_1
    //   144: invokevirtual 268	io/netty/handler/ssl/ReferenceCountedOpenSslContext:sessionContext	()Lio/netty/handler/ssl/OpenSslSessionContext;
    //   147: invokespecial 271	io/netty/handler/ssl/ReferenceCountedOpenSslEngine$DefaultOpenSslSession:<init>	(Lio/netty/handler/ssl/ReferenceCountedOpenSslEngine;Lio/netty/handler/ssl/OpenSslSessionContext;)V
    //   150: putfield 276	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:session	Lio/netty/handler/ssl/OpenSslSession;
    //   153: aload_0
    //   154: aload_1
    //   155: getfield 278	io/netty/handler/ssl/ReferenceCountedOpenSslContext:engineMap	Lio/netty/handler/ssl/OpenSslEngineMap;
    //   158: putfield 279	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:engineMap	Lio/netty/handler/ssl/OpenSslEngineMap;
    //   161: aload_1
    //   162: getfield 281	io/netty/handler/ssl/ReferenceCountedOpenSslContext:enableOcsp	Z
    //   165: istore 10
    //   167: aload_0
    //   168: iload 10
    //   170: putfield 282	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:enableOcsp	Z
    //   173: aload_1
    //   174: invokevirtual 268	io/netty/handler/ssl/ReferenceCountedOpenSslContext:sessionContext	()Lio/netty/handler/ssl/OpenSslSessionContext;
    //   177: invokevirtual 287	io/netty/handler/ssl/OpenSslSessionContext:useKeyManager	()Z
    //   180: ifne +11 -> 191
    //   183: aload_0
    //   184: aload_1
    //   185: getfield 290	io/netty/handler/ssl/ReferenceCountedOpenSslContext:keyCertChain	[Ljava/security/cert/Certificate;
    //   188: putfield 292	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:localCertificateChain	[Ljava/security/cert/Certificate;
    //   191: aload_0
    //   192: iload 5
    //   194: putfield 294	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:jdkCompatibilityMode	Z
    //   197: aload_1
    //   198: getfield 298	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctxLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   201: invokeinterface 304 1 0
    //   206: astore_2
    //   207: aload_2
    //   208: invokeinterface 309 1 0
    //   213: aload_1
    //   214: getfield 312	io/netty/handler/ssl/ReferenceCountedOpenSslContext:ctx	J
    //   217: lstore 11
    //   219: aload_1
    //   220: invokevirtual 256	io/netty/handler/ssl/ReferenceCountedOpenSslContext:isClient	()Z
    //   223: ifne +6 -> 229
    //   226: goto +6 -> 232
    //   229: iconst_0
    //   230: istore 8
    //   232: lload 11
    //   234: iload 8
    //   236: invokestatic 316	io/netty/internal/tcnative/SSL:newSSL	(JZ)J
    //   239: lstore 11
    //   241: aload_2
    //   242: invokeinterface 319 1 0
    //   247: aload_0
    //   248: monitorenter
    //   249: aload_0
    //   250: lload 11
    //   252: putfield 321	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:ssl	J
    //   255: aload_0
    //   256: lload 11
    //   258: aload_1
    //   259: invokevirtual 324	io/netty/handler/ssl/ReferenceCountedOpenSslContext:getBioNonApplicationBufferSize	()I
    //   262: invokestatic 328	io/netty/internal/tcnative/SSL:bioNewByteBuffer	(JI)J
    //   265: putfield 330	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:networkBIO	J
    //   268: iload 9
    //   270: ifeq +9 -> 279
    //   273: aload 7
    //   275: astore_2
    //   276: goto +8 -> 284
    //   279: aload_1
    //   280: getfield 331	io/netty/handler/ssl/ReferenceCountedOpenSslContext:clientAuth	Lio/netty/handler/ssl/ClientAuth;
    //   283: astore_2
    //   284: aload_0
    //   285: aload_2
    //   286: invokespecial 335	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:setClientAuth	(Lio/netty/handler/ssl/ClientAuth;)V
    //   289: aload_1
    //   290: getfield 339	io/netty/handler/ssl/ReferenceCountedOpenSslContext:protocols	[Ljava/lang/String;
    //   293: astore_2
    //   294: aload_2
    //   295: ifnull +8 -> 303
    //   298: aload_0
    //   299: aload_2
    //   300: invokevirtual 343	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:setEnabledProtocols	([Ljava/lang/String;)V
    //   303: iload 9
    //   305: ifeq +26 -> 331
    //   308: aload_3
    //   309: invokestatic 349	io/netty/handler/ssl/SslUtils:isValidHostNameForSNI	(Ljava/lang/String;)Z
    //   312: ifeq +19 -> 331
    //   315: aload_0
    //   316: getfield 321	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:ssl	J
    //   319: aload_3
    //   320: invokestatic 353	io/netty/internal/tcnative/SSL:setTlsExtHostName	(JLjava/lang/String;)V
    //   323: aload_0
    //   324: aload_3
    //   325: invokestatic 359	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   328: putfield 361	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:sniHostNames	Ljava/util/List;
    //   331: iload 10
    //   333: ifeq +10 -> 343
    //   336: aload_0
    //   337: getfield 321	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:ssl	J
    //   340: invokestatic 364	io/netty/internal/tcnative/SSL:enableOcsp	(J)V
    //   343: iload 5
    //   345: ifne +24 -> 369
    //   348: aload_0
    //   349: getfield 321	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:ssl	J
    //   352: lstore 11
    //   354: lload 11
    //   356: lload 11
    //   358: invokestatic 368	io/netty/internal/tcnative/SSL:getMode	(J)I
    //   361: getstatic 371	io/netty/internal/tcnative/SSL:SSL_MODE_ENABLE_PARTIAL_WRITE	I
    //   364: ior
    //   365: invokestatic 375	io/netty/internal/tcnative/SSL:setMode	(JI)I
    //   368: pop
    //   369: aload_0
    //   370: invokespecial 378	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:calculateMaxWrapOverhead	()V
    //   373: goto +12 -> 385
    //   376: astore_2
    //   377: aload_0
    //   378: invokevirtual 381	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:shutdown	()V
    //   381: aload_2
    //   382: invokestatic 385	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   385: aload_0
    //   386: monitorexit
    //   387: aload_0
    //   388: aload_1
    //   389: putfield 387	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:parentContext	Lio/netty/handler/ssl/ReferenceCountedOpenSslContext;
    //   392: aload_1
    //   393: invokevirtual 391	io/netty/handler/ssl/ReferenceCountedOpenSslContext:retain	()Lio/netty/util/ReferenceCounted;
    //   396: pop
    //   397: iload 6
    //   399: ifeq +14 -> 413
    //   402: getstatic 125	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:leakDetector	Lio/netty/util/ResourceLeakDetector;
    //   405: aload_0
    //   406: invokevirtual 397	io/netty/util/ResourceLeakDetector:track	(Ljava/lang/Object;)Lio/netty/util/ResourceLeakTracker;
    //   409: astore_1
    //   410: goto +5 -> 415
    //   413: aconst_null
    //   414: astore_1
    //   415: aload_0
    //   416: aload_1
    //   417: putfield 399	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:leak	Lio/netty/util/ResourceLeakTracker;
    //   420: return
    //   421: astore_1
    //   422: aload_0
    //   423: monitorexit
    //   424: aload_1
    //   425: athrow
    //   426: astore_1
    //   427: aload_2
    //   428: invokeinterface 319 1 0
    //   433: aload_1
    //   434: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	ReferenceCountedOpenSslEngine
    //   0	435	1	paramReferenceCountedOpenSslContext	ReferenceCountedOpenSslContext
    //   0	435	2	paramByteBufAllocator	ByteBufAllocator
    //   0	435	3	paramString	String
    //   0	435	4	paramInt	int
    //   0	435	5	paramBoolean1	boolean
    //   0	435	6	paramBoolean2	boolean
    //   29	245	7	localClientAuth	ClientAuth
    //   45	190	8	bool1	boolean
    //   94	210	9	bool2	boolean
    //   165	167	10	bool3	boolean
    //   217	140	11	l	long
    // Exception table:
    //   from	to	target	type
    //   255	268	376	finally
    //   279	284	376	finally
    //   284	294	376	finally
    //   298	303	376	finally
    //   308	331	376	finally
    //   336	343	376	finally
    //   348	369	376	finally
    //   369	373	376	finally
    //   249	255	421	finally
    //   377	385	421	finally
    //   385	387	421	finally
    //   422	424	421	finally
    //   213	226	426	finally
    //   232	241	426	finally
  }
  
  private static long bufferAddress(ByteBuffer paramByteBuffer)
  {
    if (PlatformDependent.hasUnsafe()) {
      return PlatformDependent.directBufferAddress(paramByteBuffer);
    }
    return Buffer.address(paramByteBuffer);
  }
  
  private void calculateMaxWrapOverhead()
  {
    this.maxWrapOverhead = SSL.getMaxWrapOverhead(this.ssl);
    int i;
    if (this.jdkCompatibilityMode) {
      i = maxEncryptedPacketLength0();
    } else {
      i = maxEncryptedPacketLength0() << 4;
    }
    this.maxWrapBufferSize = i;
  }
  
  private void checkEngineClosed()
    throws SSLException
  {
    if (!isDestroyed()) {
      return;
    }
    throw new SSLException("engine closed");
  }
  
  private void closeAll()
    throws SSLException
  {
    this.receivedShutdown = true;
    closeOutbound();
    closeInbound();
  }
  
  private boolean doSSLShutdown()
  {
    if (SSL.isInInit(this.ssl) != 0) {
      return false;
    }
    int i = SSL.shutdownSSL(this.ssl);
    if (i < 0)
    {
      i = SSL.getError(this.ssl, i);
      if ((i != SSL.SSL_ERROR_SYSCALL) && (i != SSL.SSL_ERROR_SSL))
      {
        SSL.clearError();
      }
      else
      {
        InternalLogger localInternalLogger = logger;
        if (localInternalLogger.isDebugEnabled())
        {
          i = SSL.getLastErrorNumber();
          localInternalLogger.debug("SSL_shutdown failed: OpenSSL error: {} {}", Integer.valueOf(i), SSL.getErrorString(i));
        }
        shutdown();
        return false;
      }
    }
    return true;
  }
  
  private SSLEngineResult.HandshakeStatus getHandshakeStatus(int paramInt)
  {
    if (needPendingStatus())
    {
      if (this.needTask) {
        return SSLEngineResult.HandshakeStatus.NEED_TASK;
      }
      return pendingStatus(paramInt);
    }
    return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
  }
  
  private SSLEngineResult.HandshakeStatus handshake()
    throws SSLException
  {
    if (this.needTask) {
      return SSLEngineResult.HandshakeStatus.NEED_TASK;
    }
    if (this.handshakeState == HandshakeState.FINISHED) {
      return SSLEngineResult.HandshakeStatus.FINISHED;
    }
    checkEngineClosed();
    if (this.pendingException != null)
    {
      if (SSL.doHandshake(this.ssl) <= 0) {
        SSL.clearError();
      }
      return handshakeException();
    }
    this.engineMap.add(this);
    if (this.lastAccessed == -1L) {
      this.lastAccessed = System.currentTimeMillis();
    }
    int i = SSL.doHandshake(this.ssl);
    if (i <= 0)
    {
      i = SSL.getError(this.ssl, i);
      if ((i != SSL.SSL_ERROR_WANT_READ) && (i != SSL.SSL_ERROR_WANT_WRITE))
      {
        if ((i != SSL.SSL_ERROR_WANT_X509_LOOKUP) && (i != SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY) && (i != SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION))
        {
          if (this.pendingException != null) {
            return handshakeException();
          }
          throw shutdownWithError("SSL_do_handshake", i);
        }
        return SSLEngineResult.HandshakeStatus.NEED_TASK;
      }
      return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
    }
    if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
      return SSLEngineResult.HandshakeStatus.NEED_WRAP;
    }
    this.session.handshakeFinished();
    return SSLEngineResult.HandshakeStatus.FINISHED;
  }
  
  private SSLEngineResult.HandshakeStatus handshakeException()
    throws SSLException
  {
    if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
      return SSLEngineResult.HandshakeStatus.NEED_WRAP;
    }
    Throwable localThrowable = this.pendingException;
    this.pendingException = null;
    shutdown();
    if ((localThrowable instanceof SSLHandshakeException)) {
      throw ((SSLHandshakeException)localThrowable);
    }
    SSLHandshakeException localSSLHandshakeException = new SSLHandshakeException("General OpenSslEngine problem");
    localSSLHandshakeException.initCause(localThrowable);
    throw localSSLHandshakeException;
  }
  
  private boolean isBytesAvailableEnoughForWrap(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramInt1 - this.maxWrapOverhead * paramInt3 >= paramInt2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean isDestroyed()
  {
    return this.destroyed;
  }
  
  private static boolean isEmpty(byte[] paramArrayOfByte)
  {
    boolean bool;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isEmpty(Object[] paramArrayOfObject)
  {
    boolean bool;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isEndPointVerificationEnabled(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (!paramString.isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isProtocolEnabled(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool;
    if (((paramInt1 & paramInt2) == 0) && (OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus paramHandshakeStatus)
    throws SSLException
  {
    SSLEngineResult.HandshakeStatus localHandshakeStatus = paramHandshakeStatus;
    if (paramHandshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING)
    {
      localHandshakeStatus = paramHandshakeStatus;
      if (this.handshakeState != HandshakeState.FINISHED) {
        localHandshakeStatus = handshake();
      }
    }
    return localHandshakeStatus;
  }
  
  private boolean needPendingStatus()
  {
    boolean bool;
    if ((this.handshakeState != HandshakeState.NOT_STARTED) && (!isDestroyed()) && ((this.handshakeState != HandshakeState.FINISHED) || (isInboundDone()) || (isOutboundDone()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private SSLEngineResult newResult(SSLEngineResult.HandshakeStatus paramHandshakeStatus, int paramInt1, int paramInt2)
  {
    return newResult(SSLEngineResult.Status.OK, paramHandshakeStatus, paramInt1, paramInt2);
  }
  
  private SSLEngineResult newResult(SSLEngineResult.Status paramStatus, SSLEngineResult.HandshakeStatus paramHandshakeStatus, int paramInt1, int paramInt2)
  {
    if (isOutboundDone())
    {
      if (isInboundDone())
      {
        paramHandshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        shutdown();
      }
      return new SSLEngineResult(SSLEngineResult.Status.CLOSED, paramHandshakeStatus, paramInt1, paramInt2);
    }
    if (paramHandshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
      this.needTask = true;
    }
    return new SSLEngineResult(paramStatus, paramHandshakeStatus, paramInt1, paramInt2);
  }
  
  private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus paramHandshakeStatus, int paramInt1, int paramInt2)
    throws SSLException
  {
    SSLEngineResult.HandshakeStatus localHandshakeStatus1 = SSLEngineResult.HandshakeStatus.FINISHED;
    SSLEngineResult.HandshakeStatus localHandshakeStatus2 = localHandshakeStatus1;
    if (paramHandshakeStatus != localHandshakeStatus1) {
      localHandshakeStatus2 = getHandshakeStatus();
    }
    return newResult(mayFinishHandshake(localHandshakeStatus2), paramInt1, paramInt2);
  }
  
  private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.Status paramStatus, SSLEngineResult.HandshakeStatus paramHandshakeStatus, int paramInt1, int paramInt2)
    throws SSLException
  {
    SSLEngineResult.HandshakeStatus localHandshakeStatus1 = SSLEngineResult.HandshakeStatus.FINISHED;
    SSLEngineResult.HandshakeStatus localHandshakeStatus2 = localHandshakeStatus1;
    if (paramHandshakeStatus != localHandshakeStatus1) {
      localHandshakeStatus2 = getHandshakeStatus();
    }
    return newResult(paramStatus, mayFinishHandshake(localHandshakeStatus2), paramInt1, paramInt2);
  }
  
  private static SSLEngineResult.HandshakeStatus pendingStatus(int paramInt)
  {
    SSLEngineResult.HandshakeStatus localHandshakeStatus;
    if (paramInt > 0) {
      localHandshakeStatus = SSLEngineResult.HandshakeStatus.NEED_WRAP;
    } else {
      localHandshakeStatus = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }
    return localHandshakeStatus;
  }
  
  private int readPlaintextData(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j;
    int k;
    ByteBuf localByteBuf;
    if (paramByteBuffer.isDirect())
    {
      j = SSL.readFromSSL(this.ssl, bufferAddress(paramByteBuffer) + i, paramByteBuffer.limit() - i);
      k = j;
      if (j > 0)
      {
        paramByteBuffer.position(i + j);
        k = j;
      }
    }
    else
    {
      j = paramByteBuffer.limit();
      k = Math.min(maxEncryptedPacketLength0(), j - i);
      localByteBuf = this.alloc.directBuffer(k);
    }
    try
    {
      k = SSL.readFromSSL(this.ssl, OpenSsl.memoryAddress(localByteBuf), k);
      if (k > 0)
      {
        paramByteBuffer.limit(i + k);
        localByteBuf.getBytes(localByteBuf.readerIndex(), paramByteBuffer);
        paramByteBuffer.limit(j);
      }
      return k;
    }
    finally
    {
      localByteBuf.release();
    }
  }
  
  private void rejectRemoteInitiatedRenegotiation()
    throws SSLHandshakeException
  {
    if ((!isDestroyed()) && (SSL.getHandshakeCount(this.ssl) > 1) && (!"TLSv1.3".equals(this.session.getProtocol())) && (this.handshakeState == HandshakeState.FINISHED))
    {
      shutdown();
      throw new SSLHandshakeException("remote-initiated renegotiation not allowed");
    }
  }
  
  private void resetSingleDstBuffer()
  {
    this.singleDstBuffer[0] = null;
  }
  
  private void resetSingleSrcBuffer()
  {
    this.singleSrcBuffer[0] = null;
  }
  
  private void setClientAuth(ClientAuth paramClientAuth)
  {
    if (this.clientMode) {
      return;
    }
    try
    {
      if (this.clientAuth == paramClientAuth) {
        return;
      }
      if (!isDestroyed())
      {
        int i = 4.$SwitchMap$io$netty$handler$ssl$ClientAuth[paramClientAuth.ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              SSL.setVerify(this.ssl, 1, 10);
            }
            else
            {
              Error localError = new java/lang/Error;
              localError.<init>(paramClientAuth.toString());
              throw localError;
            }
          }
          else {
            SSL.setVerify(this.ssl, 2, 10);
          }
        }
        else {
          SSL.setVerify(this.ssl, 0, 10);
        }
      }
      this.clientAuth = paramClientAuth;
      return;
    }
    finally {}
  }
  
  private SSLException shutdownWithError(String paramString, int paramInt)
  {
    return shutdownWithError(paramString, paramInt, SSL.getLastErrorNumber());
  }
  
  private SSLException shutdownWithError(String paramString, int paramInt1, int paramInt2)
  {
    String str = SSL.getErrorString(paramInt2);
    Object localObject = logger;
    if (((InternalLogger)localObject).isDebugEnabled()) {
      ((InternalLogger)localObject).debug("{} failed with {}: OpenSSL error: {} {}", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
    }
    shutdown();
    if (this.handshakeState == HandshakeState.FINISHED) {
      return new SSLException(str);
    }
    paramString = new SSLHandshakeException(str);
    localObject = this.pendingException;
    if (localObject != null)
    {
      paramString.initCause((Throwable)localObject);
      this.pendingException = null;
    }
    return paramString;
  }
  
  private ByteBuffer[] singleDstBuffer(ByteBuffer paramByteBuffer)
  {
    ByteBuffer[] arrayOfByteBuffer = this.singleDstBuffer;
    arrayOfByteBuffer[0] = paramByteBuffer;
    return arrayOfByteBuffer;
  }
  
  private ByteBuffer[] singleSrcBuffer(ByteBuffer paramByteBuffer)
  {
    ByteBuffer[] arrayOfByteBuffer = this.singleSrcBuffer;
    arrayOfByteBuffer[0] = paramByteBuffer;
    return arrayOfByteBuffer;
  }
  
  private int sslPending0()
  {
    int i;
    if (this.handshakeState != HandshakeState.FINISHED) {
      i = 0;
    } else {
      i = SSL.sslPending(this.ssl);
    }
    return i;
  }
  
  private SSLEngineResult sslReadErrorResult(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws SSLException
  {
    if (SSL.bioLengthNonApplication(this.networkBIO) > 0)
    {
      Object localObject = SSL.getErrorString(paramInt2);
      if (this.handshakeState == HandshakeState.FINISHED) {
        localObject = new SSLException((String)localObject);
      } else {
        localObject = new SSLHandshakeException((String)localObject);
      }
      Throwable localThrowable = this.pendingException;
      if (localThrowable == null) {
        this.pendingException = ((Throwable)localObject);
      } else {
        ThrowableUtil.addSuppressed(localThrowable, (Throwable)localObject);
      }
      SSL.clearError();
      return new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, paramInt3, paramInt4);
    }
    throw shutdownWithError("SSL_read", paramInt1, paramInt2);
  }
  
  private String toJavaCipherSuite(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return CipherSuiteConverter.toJava(paramString, toJavaCipherSuitePrefix(SSL.getVersion(this.ssl)));
  }
  
  private static String toJavaCipherSuitePrefix(String paramString)
  {
    int i = 0;
    int j = i;
    if (paramString != null) {
      if (paramString.isEmpty()) {
        j = i;
      } else {
        j = paramString.charAt(0);
      }
    }
    if (j != 83)
    {
      if (j != 84) {
        return "UNKNOWN";
      }
      return "TLS";
    }
    return "SSL";
  }
  
  private ByteBuf writeEncryptedData(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i = paramByteBuffer.position();
    if (paramByteBuffer.isDirect())
    {
      SSL.bioSetByteBuffer(this.networkBIO, bufferAddress(paramByteBuffer) + i, paramInt, false);
    }
    else
    {
      ByteBuf localByteBuf = this.alloc.directBuffer(paramInt);
      try
      {
        int j = paramByteBuffer.limit();
        paramByteBuffer.limit(i + paramInt);
        localByteBuf.writeBytes(paramByteBuffer);
        paramByteBuffer.position(i);
        paramByteBuffer.limit(j);
        SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(localByteBuf), paramInt, false);
        return localByteBuf;
      }
      finally
      {
        localByteBuf.release();
        PlatformDependent.throwException(paramByteBuffer);
      }
    }
    return null;
  }
  
  private int writePlaintextData(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i = paramByteBuffer.position();
    int j = paramByteBuffer.limit();
    ByteBuf localByteBuf;
    if (paramByteBuffer.isDirect())
    {
      j = SSL.writeToSSL(this.ssl, bufferAddress(paramByteBuffer) + i, paramInt);
      paramInt = j;
      if (j > 0)
      {
        paramByteBuffer.position(i + j);
        paramInt = j;
      }
    }
    else
    {
      localByteBuf = this.alloc.directBuffer(paramInt);
    }
    try
    {
      paramByteBuffer.limit(i + paramInt);
      localByteBuf.setBytes(0, paramByteBuffer);
      paramByteBuffer.limit(j);
      paramInt = SSL.writeToSSL(this.ssl, OpenSsl.memoryAddress(localByteBuf), paramInt);
      if (paramInt > 0) {
        paramByteBuffer.position(i + paramInt);
      } else {
        paramByteBuffer.position(i);
      }
      return paramInt;
    }
    finally
    {
      localByteBuf.release();
    }
  }
  
  final String[] authMethods()
  {
    try
    {
      if (isDestroyed())
      {
        arrayOfString = EmptyArrays.EMPTY_STRINGS;
        return arrayOfString;
      }
      String[] arrayOfString = SSL.authenticationMethods(this.ssl);
      return arrayOfString;
    }
    finally {}
  }
  
  public final void beginHandshake()
    throws SSLException
  {
    try
    {
      int i = 4.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()];
      if (i != 1)
      {
        Object localObject1;
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              localObject1 = new java/lang/Error;
              ((Error)localObject1).<init>();
              throw ((Throwable)localObject1);
            }
          }
          else
          {
            checkEngineClosed();
            this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
            calculateMaxWrapOverhead();
          }
        }
        else
        {
          localObject1 = new javax/net/ssl/SSLException;
          ((SSLException)localObject1).<init>("renegotiation unsupported");
          throw ((Throwable)localObject1);
        }
      }
      else
      {
        this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
        if (handshake() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
          this.needTask = true;
        }
        calculateMaxWrapOverhead();
      }
      return;
    }
    finally {}
  }
  
  final int calculateMaxLengthForWrap(int paramInt1, int paramInt2)
  {
    return (int)Math.min(this.maxWrapBufferSize, paramInt1 + this.maxWrapOverhead * paramInt2);
  }
  
  final boolean checkSniHostnameMatch(byte[] paramArrayOfByte)
  {
    return Java8SslUtils.checkSniHostnameMatch(this.matchers, paramArrayOfByte);
  }
  
  public final void closeInbound()
    throws SSLException
  {
    try
    {
      boolean bool = this.isInboundDone;
      if (bool) {
        return;
      }
      this.isInboundDone = true;
      if (isOutboundDone()) {
        shutdown();
      }
      if ((this.handshakeState != HandshakeState.NOT_STARTED) && (!this.receivedShutdown))
      {
        SSLException localSSLException = new javax/net/ssl/SSLException;
        localSSLException.<init>("Inbound closed before receiving peer's close_notify: possible truncation attack?");
        throw localSSLException;
      }
      return;
    }
    finally {}
  }
  
  public final void closeOutbound()
  {
    try
    {
      boolean bool = this.outboundClosed;
      if (bool) {
        return;
      }
      this.outboundClosed = true;
      if ((this.handshakeState != HandshakeState.NOT_STARTED) && (!isDestroyed()))
      {
        if ((SSL.getShutdown(this.ssl) & SSL.SSL_SENT_SHUTDOWN) != SSL.SSL_SENT_SHUTDOWN) {
          doSSLShutdown();
        }
      }
      else {
        shutdown();
      }
      return;
    }
    finally {}
  }
  
  public final Runnable getDelegatedTask()
  {
    try
    {
      boolean bool = isDestroyed();
      if (bool) {
        return null;
      }
      final Object localObject1 = SSL.getTask(this.ssl);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = new Runnable()
      {
        public void run()
        {
          if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
            return;
          }
          try
          {
            localObject1.run();
            return;
          }
          finally
          {
            ReferenceCountedOpenSslEngine.access$702(ReferenceCountedOpenSslEngine.this, false);
          }
        }
      };
      return (Runnable)localObject1;
    }
    finally {}
  }
  
  public final boolean getEnableSessionCreation()
  {
    return false;
  }
  
  public final String[] getEnabledCipherSuites()
  {
    try
    {
      if (!isDestroyed())
      {
        String[] arrayOfString1 = SSL.getCiphers(this.ssl);
        String[] arrayOfString2;
        if (isProtocolEnabled(SSL.getOptions(this.ssl), SSL.SSL_OP_NO_TLSv1_3, "TLSv1.3")) {
          arrayOfString2 = OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS;
        } else {
          arrayOfString2 = EmptyArrays.EMPTY_STRINGS;
        }
        if (arrayOfString1 == null) {
          return EmptyArrays.EMPTY_STRINGS;
        }
        LinkedHashSet localLinkedHashSet = new LinkedHashSet(arrayOfString1.length + arrayOfString2.length);
        int i = 0;
        try
        {
          while (i < arrayOfString1.length)
          {
            String str1 = toJavaCipherSuite(arrayOfString1[i]);
            String str2 = str1;
            if (str1 == null) {
              str2 = arrayOfString1[i];
            }
            if ((OpenSsl.isTlsv13Supported()) || (!SslUtils.isTLSv13Cipher(str2))) {
              localLinkedHashSet.add(str2);
            }
            i++;
          }
          Collections.addAll(localLinkedHashSet, arrayOfString2);
          return (String[])localLinkedHashSet.toArray(new String[0]);
        }
        finally {}
      }
      String[] arrayOfString3 = EmptyArrays.EMPTY_STRINGS;
      return arrayOfString3;
    }
    finally {}
  }
  
  public final String[] getEnabledProtocols()
  {
    Object localObject1 = new ArrayList(6);
    ((List)localObject1).add("SSLv2Hello");
    try
    {
      if (!isDestroyed())
      {
        int i = SSL.getOptions(this.ssl);
        if (isProtocolEnabled(i, SSL.SSL_OP_NO_TLSv1, "TLSv1")) {
          ((List)localObject1).add("TLSv1");
        }
        if (isProtocolEnabled(i, SSL.SSL_OP_NO_TLSv1_1, "TLSv1.1")) {
          ((List)localObject1).add("TLSv1.1");
        }
        if (isProtocolEnabled(i, SSL.SSL_OP_NO_TLSv1_2, "TLSv1.2")) {
          ((List)localObject1).add("TLSv1.2");
        }
        if (isProtocolEnabled(i, SSL.SSL_OP_NO_TLSv1_3, "TLSv1.3")) {
          ((List)localObject1).add("TLSv1.3");
        }
        if (isProtocolEnabled(i, SSL.SSL_OP_NO_SSLv2, "SSLv2")) {
          ((List)localObject1).add("SSLv2");
        }
        if (isProtocolEnabled(i, SSL.SSL_OP_NO_SSLv3, "SSLv3")) {
          ((List)localObject1).add("SSLv3");
        }
        return (String[])((List)localObject1).toArray(new String[0]);
      }
      localObject1 = (String[])((List)localObject1).toArray(new String[0]);
      return (String[])localObject1;
    }
    finally {}
  }
  
  public final SSLSession getHandshakeSession()
  {
    try
    {
      int i = 4.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()];
      if ((i != 1) && (i != 2))
      {
        OpenSslSession localOpenSslSession = this.session;
        return localOpenSslSession;
      }
      return null;
    }
    finally {}
  }
  
  public final SSLEngineResult.HandshakeStatus getHandshakeStatus()
  {
    try
    {
      if (needPendingStatus())
      {
        if (this.needTask)
        {
          localHandshakeStatus = SSLEngineResult.HandshakeStatus.NEED_TASK;
          return localHandshakeStatus;
        }
        localHandshakeStatus = pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
        return localHandshakeStatus;
      }
      SSLEngineResult.HandshakeStatus localHandshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
      return localHandshakeStatus;
    }
    finally {}
  }
  
  public final boolean getNeedClientAuth()
  {
    boolean bool;
    if (this.clientAuth == ClientAuth.REQUIRE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String getNegotiatedApplicationProtocol()
  {
    return this.applicationProtocol;
  }
  
  public byte[] getOcspResponse()
  {
    if (this.enableOcsp)
    {
      if (this.clientMode) {
        try
        {
          if (isDestroyed())
          {
            arrayOfByte = EmptyArrays.EMPTY_BYTES;
            return arrayOfByte;
          }
          byte[] arrayOfByte = SSL.getOcspResponse(this.ssl);
          return arrayOfByte;
        }
        finally {}
      }
      throw new IllegalStateException("Not a client SSLEngine");
    }
    throw new IllegalStateException("OCSP stapling is not enabled");
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  public final SSLParameters getSSLParameters()
  {
    try
    {
      SSLParameters localSSLParameters = super.getSSLParameters();
      int i = PlatformDependent.javaVersion();
      if (i >= 7)
      {
        localSSLParameters.setEndpointIdentificationAlgorithm(this.endPointIdentificationAlgorithm);
        Java7SslParametersUtils.setAlgorithmConstraints(localSSLParameters, this.algorithmConstraints);
        if (i >= 8)
        {
          List localList = this.sniHostNames;
          if (localList != null) {
            Java8SslUtils.setSniHostNames(localSSLParameters, localList);
          }
          if (!isDestroyed())
          {
            boolean bool;
            if ((SSL.getOptions(this.ssl) & SSL.SSL_OP_CIPHER_SERVER_PREFERENCE) != 0) {
              bool = true;
            } else {
              bool = false;
            }
            Java8SslUtils.setUseCipherSuitesOrder(localSSLParameters, bool);
          }
          Java8SslUtils.setSNIMatchers(localSSLParameters, this.matchers);
        }
      }
      return localSSLParameters;
    }
    finally {}
  }
  
  public final SSLSession getSession()
  {
    return this.session;
  }
  
  public final String[] getSupportedCipherSuites()
  {
    return (String[])OpenSsl.AVAILABLE_CIPHER_SUITES.toArray(new String[0]);
  }
  
  public final String[] getSupportedProtocols()
  {
    return (String[])OpenSsl.SUPPORTED_PROTOCOLS_SET.toArray(new String[0]);
  }
  
  public final boolean getUseClientMode()
  {
    return this.clientMode;
  }
  
  public final boolean getWantClientAuth()
  {
    boolean bool;
    if (this.clientAuth == ClientAuth.OPTIONAL) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  final void initHandshakeException(Throwable paramThrowable)
  {
    Throwable localThrowable = this.pendingException;
    if (localThrowable == null) {
      this.pendingException = paramThrowable;
    } else {
      ThrowableUtil.addSuppressed(localThrowable, paramThrowable);
    }
  }
  
  public final boolean isInboundDone()
  {
    try
    {
      boolean bool = this.isInboundDone;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean isOutboundDone()
  {
    try
    {
      if (this.outboundClosed)
      {
        long l = this.networkBIO;
        if (l != 0L)
        {
          int i = SSL.bioLengthNonApplication(l);
          if (i != 0) {}
        }
        else
        {
          bool = true;
          break label38;
        }
      }
      boolean bool = false;
      label38:
      return bool;
    }
    finally {}
  }
  
  final SecretKeySpec masterKey()
  {
    try
    {
      boolean bool = isDestroyed();
      if (bool) {
        return null;
      }
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(SSL.getMasterKey(this.ssl), "AES");
      return localSecretKeySpec;
    }
    finally {}
  }
  
  final int maxEncryptedPacketLength()
  {
    try
    {
      int i = maxEncryptedPacketLength0();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final int maxEncryptedPacketLength0()
  {
    return this.maxWrapOverhead + MAX_PLAINTEXT_LENGTH;
  }
  
  final int maxWrapOverhead()
  {
    try
    {
      int i = this.maxWrapOverhead;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
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
  
  public final void setEnableSessionCreation(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final void setEnabledCipherSuites(String[] paramArrayOfString)
  {
    ObjectUtil.checkNotNull(paramArrayOfString, "cipherSuites");
    Object localObject1 = new StringBuilder();
    Object localObject2 = new StringBuilder();
    CipherSuiteConverter.convertToCipherStrings(Arrays.asList(paramArrayOfString), (StringBuilder)localObject1, (StringBuilder)localObject2, OpenSsl.isBoringSSL());
    paramArrayOfString = ((StringBuilder)localObject1).toString();
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((!OpenSsl.isTlsv13Supported()) && (!((String)localObject2).isEmpty())) {
      throw new IllegalArgumentException("TLSv1.3 is not supported by this java version.");
    }
    try
    {
      boolean bool = isDestroyed();
      if (!bool) {
        try
        {
          SSL.setCipherSuites(this.ssl, paramArrayOfString, false);
          if (OpenSsl.isTlsv13Supported()) {
            SSL.setCipherSuites(this.ssl, (String)localObject2, true);
          }
          return;
        }
        catch (Exception localException)
        {
          localObject1 = new java/lang/IllegalStateException;
          StringBuilder localStringBuilder2 = new java/lang/StringBuilder;
          localStringBuilder2.<init>();
          localStringBuilder2.append("failed to enable cipher suites: ");
          localStringBuilder2.append(paramArrayOfString);
          ((IllegalStateException)localObject1).<init>(localStringBuilder2.toString(), localException);
          throw ((Throwable)localObject1);
        }
      }
      localObject1 = new java/lang/IllegalStateException;
      StringBuilder localStringBuilder1 = new java/lang/StringBuilder;
      localStringBuilder1.<init>();
      localStringBuilder1.append("failed to enable cipher suites: ");
      localStringBuilder1.append(paramArrayOfString);
      ((IllegalStateException)localObject1).<init>(localStringBuilder1.toString());
      throw ((Throwable)localObject1);
    }
    finally {}
  }
  
  public final void setEnabledProtocols(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int i = OPENSSL_OP_NO_PROTOCOLS.length;
      int j = paramArrayOfString.length;
      int k = 0;
      int m = 0;
      int n = 0;
      Object localObject;
      int i2;
      int i3;
      while (m < j)
      {
        localObject = paramArrayOfString[m];
        if (OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(localObject))
        {
          int i1;
          if (((String)localObject).equals("SSLv2"))
          {
            i1 = i;
            if (i > 0) {
              i1 = 0;
            }
            i2 = i1;
            i3 = n;
            if (n < 0)
            {
              i3 = 0;
              i2 = i1;
            }
          }
          else if (((String)localObject).equals("SSLv3"))
          {
            i1 = i;
            if (i > 1) {
              i1 = 1;
            }
            i2 = i1;
            i3 = n;
            if (n < 1)
            {
              i3 = 1;
              i2 = i1;
            }
          }
          else if (((String)localObject).equals("TLSv1"))
          {
            i1 = i;
            if (i > 2) {
              i1 = 2;
            }
            i2 = i1;
            i3 = n;
            if (n < 2)
            {
              i3 = 2;
              i2 = i1;
            }
          }
          else if (((String)localObject).equals("TLSv1.1"))
          {
            i1 = i;
            if (i > 3) {
              i1 = 3;
            }
            i2 = i1;
            i3 = n;
            if (n < 3)
            {
              i3 = 3;
              i2 = i1;
            }
          }
          else if (((String)localObject).equals("TLSv1.2"))
          {
            i1 = i;
            if (i > 4) {
              i1 = 4;
            }
            i2 = i1;
            i3 = n;
            if (n < 4)
            {
              i3 = 4;
              i2 = i1;
            }
          }
          else
          {
            i2 = i;
            i3 = n;
            if (((String)localObject).equals("TLSv1.3"))
            {
              i1 = i;
              if (i > 5) {
                i1 = 5;
              }
              i2 = i1;
              i3 = n;
              if (n < 5)
              {
                i3 = 5;
                i2 = i1;
              }
            }
          }
          m++;
          i = i2;
          n = i3;
        }
        else
        {
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("Protocol ");
          paramArrayOfString.append((String)localObject);
          paramArrayOfString.append(" is not supported.");
          throw new IllegalArgumentException(paramArrayOfString.toString());
        }
      }
      try
      {
        if (!isDestroyed())
        {
          SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2 | SSL.SSL_OP_NO_TLSv1_3);
          i2 = 0;
          for (i3 = k; i3 < i; i3++) {
            i2 |= OPENSSL_OP_NO_PROTOCOLS[i3];
          }
          for (i = n + 1;; i++)
          {
            paramArrayOfString = OPENSSL_OP_NO_PROTOCOLS;
            if (i >= paramArrayOfString.length) {
              break;
            }
            i2 |= paramArrayOfString[i];
          }
          SSL.setOptions(this.ssl, i2);
          return;
        }
        localObject = new java/lang/IllegalStateException;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("failed to enable protocols: ");
        localStringBuilder.append(Arrays.asList(paramArrayOfString));
        ((IllegalStateException)localObject).<init>(localStringBuilder.toString());
        throw ((Throwable)localObject);
      }
      finally {}
    }
    throw new IllegalArgumentException();
  }
  
  final boolean setKeyMaterial(OpenSslKeyMaterial paramOpenSslKeyMaterial)
    throws Exception
  {
    try
    {
      if (isDestroyed()) {
        return false;
      }
      SSL.setKeyMaterial(this.ssl, paramOpenSslKeyMaterial.certificateChainAddress(), paramOpenSslKeyMaterial.privateKeyAddress());
      this.localCertificateChain = paramOpenSslKeyMaterial.certificateChain();
      return true;
    }
    finally {}
  }
  
  public final void setNeedClientAuth(boolean paramBoolean)
  {
    ClientAuth localClientAuth;
    if (paramBoolean) {
      localClientAuth = ClientAuth.REQUIRE;
    } else {
      localClientAuth = ClientAuth.NONE;
    }
    setClientAuth(localClientAuth);
  }
  
  public void setOcspResponse(byte[] paramArrayOfByte)
  {
    if (this.enableOcsp)
    {
      if (!this.clientMode) {
        try
        {
          if (!isDestroyed()) {
            SSL.setOcspResponse(this.ssl, paramArrayOfByte);
          }
          return;
        }
        finally {}
      }
      throw new IllegalStateException("Not a server SSLEngine");
    }
    throw new IllegalStateException("OCSP stapling is not enabled");
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  public final void setSSLParameters(SSLParameters paramSSLParameters)
  {
    try
    {
      int i = PlatformDependent.javaVersion();
      if (i >= 7) {
        if (paramSSLParameters.getAlgorithmConstraints() == null)
        {
          boolean bool = isDestroyed();
          if (i >= 8)
          {
            if (!bool)
            {
              if (this.clientMode)
              {
                List localList = Java8SslUtils.getSniHostNames(paramSSLParameters);
                Iterator localIterator = localList.iterator();
                while (localIterator.hasNext())
                {
                  str = (String)localIterator.next();
                  SSL.setTlsExtHostName(this.ssl, str);
                }
                this.sniHostNames = localList;
              }
              if (Java8SslUtils.getUseCipherSuitesOrder(paramSSLParameters)) {
                SSL.setOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
              } else {
                SSL.clearOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
              }
            }
            this.matchers = paramSSLParameters.getSNIMatchers();
          }
          String str = paramSSLParameters.getEndpointIdentificationAlgorithm();
          if ((!bool) && (this.clientMode) && (isEndPointVerificationEnabled(str))) {
            SSL.setVerify(this.ssl, 2, -1);
          }
          this.endPointIdentificationAlgorithm = str;
          this.algorithmConstraints = paramSSLParameters.getAlgorithmConstraints();
        }
        else
        {
          paramSSLParameters = new java/lang/IllegalArgumentException;
          paramSSLParameters.<init>("AlgorithmConstraints are not supported.");
          throw paramSSLParameters;
        }
      }
      super.setSSLParameters(paramSSLParameters);
      return;
    }
    finally {}
  }
  
  public final void setUseClientMode(boolean paramBoolean)
  {
    if (paramBoolean == this.clientMode) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final void setVerify(int paramInt1, int paramInt2)
  {
    try
    {
      if (!isDestroyed()) {
        SSL.setVerify(this.ssl, paramInt1, paramInt2);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void setWantClientAuth(boolean paramBoolean)
  {
    ClientAuth localClientAuth;
    if (paramBoolean) {
      localClientAuth = ClientAuth.OPTIONAL;
    } else {
      localClientAuth = ClientAuth.NONE;
    }
    setClientAuth(localClientAuth);
  }
  
  public final void shutdown()
  {
    try
    {
      if (!this.destroyed)
      {
        this.destroyed = true;
        this.engineMap.remove(this.ssl);
        SSL.freeSSL(this.ssl);
        this.networkBIO = 0L;
        this.ssl = 0L;
        this.outboundClosed = true;
        this.isInboundDone = true;
      }
      SSL.clearError();
      return;
    }
    finally {}
  }
  
  final int sslPending()
  {
    try
    {
      int i = sslPending0();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long sslPointer()
  {
    try
    {
      long l = this.ssl;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
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
  
  /* Error */
  public final SSLEngineResult unwrap(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws SSLException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 1160	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:singleSrcBuffer	(Ljava/nio/ByteBuffer;)[Ljava/nio/ByteBuffer;
    //   8: aload_0
    //   9: aload_2
    //   10: invokespecial 1162	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:singleDstBuffer	(Ljava/nio/ByteBuffer;)[Ljava/nio/ByteBuffer;
    //   13: invokevirtual 1165	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:unwrap	([Ljava/nio/ByteBuffer;[Ljava/nio/ByteBuffer;)Ljavax/net/ssl/SSLEngineResult;
    //   16: astore_1
    //   17: aload_0
    //   18: invokespecial 1167	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:resetSingleSrcBuffer	()V
    //   21: aload_0
    //   22: invokespecial 1169	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:resetSingleDstBuffer	()V
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: astore_1
    //   30: aload_0
    //   31: invokespecial 1167	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:resetSingleSrcBuffer	()V
    //   34: aload_0
    //   35: invokespecial 1169	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:resetSingleDstBuffer	()V
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	ReferenceCountedOpenSslEngine
    //   0	45	1	paramByteBuffer1	ByteBuffer
    //   0	45	2	paramByteBuffer2	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   2	17	29	finally
    //   17	25	40	finally
    //   30	40	40	finally
  }
  
  /* Error */
  public final SSLEngineResult unwrap(ByteBuffer paramByteBuffer, ByteBuffer[] paramArrayOfByteBuffer)
    throws SSLException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 1160	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:singleSrcBuffer	(Ljava/nio/ByteBuffer;)[Ljava/nio/ByteBuffer;
    //   8: aload_2
    //   9: invokevirtual 1165	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:unwrap	([Ljava/nio/ByteBuffer;[Ljava/nio/ByteBuffer;)Ljavax/net/ssl/SSLEngineResult;
    //   12: astore_1
    //   13: aload_0
    //   14: invokespecial 1167	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:resetSingleSrcBuffer	()V
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: astore_1
    //   22: aload_0
    //   23: invokespecial 1167	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:resetSingleSrcBuffer	()V
    //   26: aload_1
    //   27: athrow
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	ReferenceCountedOpenSslEngine
    //   0	33	1	paramByteBuffer	ByteBuffer
    //   0	33	2	paramArrayOfByteBuffer	ByteBuffer[]
    // Exception table:
    //   from	to	target	type
    //   2	13	21	finally
    //   13	17	28	finally
    //   22	28	28	finally
  }
  
  /* Error */
  public final SSLEngineResult unwrap(ByteBuffer paramByteBuffer, ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2)
    throws SSLException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 1160	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:singleSrcBuffer	(Ljava/nio/ByteBuffer;)[Ljava/nio/ByteBuffer;
    //   8: iconst_0
    //   9: iconst_1
    //   10: aload_2
    //   11: iload_3
    //   12: iload 4
    //   14: invokevirtual 1174	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:unwrap	([Ljava/nio/ByteBuffer;II[Ljava/nio/ByteBuffer;II)Ljavax/net/ssl/SSLEngineResult;
    //   17: astore_1
    //   18: aload_0
    //   19: invokespecial 1167	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:resetSingleSrcBuffer	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: astore_1
    //   27: aload_0
    //   28: invokespecial 1167	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:resetSingleSrcBuffer	()V
    //   31: aload_1
    //   32: athrow
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	ReferenceCountedOpenSslEngine
    //   0	38	1	paramByteBuffer	ByteBuffer
    //   0	38	2	paramArrayOfByteBuffer	ByteBuffer[]
    //   0	38	3	paramInt1	int
    //   0	38	4	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	18	26	finally
    //   18	22	33	finally
    //   27	33	33	finally
  }
  
  public final SSLEngineResult unwrap(ByteBuffer[] paramArrayOfByteBuffer1, int paramInt1, int paramInt2, ByteBuffer[] paramArrayOfByteBuffer2, int paramInt3, int paramInt4)
    throws SSLException
  {
    int i = paramInt1;
    ObjectUtil.checkNotNull(paramArrayOfByteBuffer1, "srcs");
    if (i < paramArrayOfByteBuffer1.length)
    {
      int j = i + paramInt2;
      if (j <= paramArrayOfByteBuffer1.length)
      {
        if (paramArrayOfByteBuffer2 != null)
        {
          if (paramInt3 < paramArrayOfByteBuffer2.length)
          {
            int k = paramInt3 + paramInt4;
            if (k <= paramArrayOfByteBuffer2.length)
            {
              paramInt2 = paramInt3;
              long l1 = 0L;
              Object localObject1;
              while (paramInt2 < k)
              {
                localObject1 = paramArrayOfByteBuffer2[paramInt2];
                if (localObject1 != null)
                {
                  if (!((ByteBuffer)localObject1).isReadOnly())
                  {
                    l1 += ((ByteBuffer)localObject1).remaining();
                    paramInt2++;
                  }
                  else
                  {
                    throw new ReadOnlyBufferException();
                  }
                }
                else
                {
                  paramArrayOfByteBuffer1 = new StringBuilder();
                  paramArrayOfByteBuffer1.append("dsts[");
                  paramArrayOfByteBuffer1.append(paramInt2);
                  paramArrayOfByteBuffer1.append("] is null");
                  throw new IllegalArgumentException(paramArrayOfByteBuffer1.toString());
                }
              }
              paramInt2 = i;
              long l2 = 0L;
              while (paramInt2 < j)
              {
                localObject1 = paramArrayOfByteBuffer1[paramInt2];
                if (localObject1 != null)
                {
                  l2 += ((ByteBuffer)localObject1).remaining();
                  paramInt2++;
                }
                else
                {
                  paramArrayOfByteBuffer1 = new StringBuilder();
                  paramArrayOfByteBuffer1.append("srcs[");
                  paramArrayOfByteBuffer1.append(paramInt2);
                  paramArrayOfByteBuffer1.append("] is null");
                  throw new IllegalArgumentException(paramArrayOfByteBuffer1.toString());
                }
              }
              try
              {
                if (isInboundDone())
                {
                  if ((!isOutboundDone()) && (!isDestroyed())) {
                    paramArrayOfByteBuffer1 = NEED_WRAP_CLOSED;
                  } else {
                    paramArrayOfByteBuffer1 = CLOSED_NOT_HANDSHAKING;
                  }
                  return paramArrayOfByteBuffer1;
                }
                localObject1 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                Object localObject2 = this.handshakeState;
                if (localObject2 != HandshakeState.FINISHED)
                {
                  if (localObject2 != HandshakeState.STARTED_EXPLICITLY) {
                    this.handshakeState = HandshakeState.STARTED_IMPLICITLY;
                  }
                  localObject1 = handshake();
                  if (localObject1 == SSLEngineResult.HandshakeStatus.NEED_TASK)
                  {
                    paramArrayOfByteBuffer1 = newResult((SSLEngineResult.HandshakeStatus)localObject1, 0, 0);
                    return paramArrayOfByteBuffer1;
                  }
                  if (localObject1 == SSLEngineResult.HandshakeStatus.NEED_WRAP)
                  {
                    paramArrayOfByteBuffer1 = NEED_WRAP_OK;
                    return paramArrayOfByteBuffer1;
                  }
                  if (this.isInboundDone)
                  {
                    paramArrayOfByteBuffer1 = NEED_WRAP_CLOSED;
                    return paramArrayOfByteBuffer1;
                  }
                }
                int m = sslPending0();
                int n;
                if (this.jdkCompatibilityMode)
                {
                  if (l2 < 5L)
                  {
                    paramArrayOfByteBuffer1 = newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_UNDERFLOW, (SSLEngineResult.HandshakeStatus)localObject1, 0, 0);
                    return paramArrayOfByteBuffer1;
                  }
                  n = SslUtils.getEncryptedPacketLength(paramArrayOfByteBuffer1, paramInt1);
                  if (n != -2)
                  {
                    paramInt1 = n - 5;
                    if (paramInt1 > l1)
                    {
                      if (paramInt1 <= MAX_RECORD_SIZE)
                      {
                        this.session.tryExpandApplicationBufferSize(paramInt1);
                        paramArrayOfByteBuffer1 = newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_OVERFLOW, (SSLEngineResult.HandshakeStatus)localObject1, 0, 0);
                        return paramArrayOfByteBuffer1;
                      }
                      paramArrayOfByteBuffer1 = new javax/net/ssl/SSLException;
                      paramArrayOfByteBuffer2 = new java/lang/StringBuilder;
                      paramArrayOfByteBuffer2.<init>();
                      paramArrayOfByteBuffer2.append("Illegal packet length: ");
                      paramArrayOfByteBuffer2.append(paramInt1);
                      paramArrayOfByteBuffer2.append(" > ");
                      paramArrayOfByteBuffer2.append(this.session.getApplicationBufferSize());
                      paramArrayOfByteBuffer1.<init>(paramArrayOfByteBuffer2.toString());
                      throw paramArrayOfByteBuffer1;
                    }
                    if (l2 < n)
                    {
                      paramArrayOfByteBuffer1 = newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_UNDERFLOW, (SSLEngineResult.HandshakeStatus)localObject1, 0, 0);
                      return paramArrayOfByteBuffer1;
                    }
                  }
                  else
                  {
                    paramArrayOfByteBuffer1 = new io/netty/handler/ssl/NotSslRecordException;
                    paramArrayOfByteBuffer1.<init>("not an SSL/TLS record");
                    throw paramArrayOfByteBuffer1;
                  }
                }
                else
                {
                  if ((l2 == 0L) && (m <= 0))
                  {
                    paramArrayOfByteBuffer1 = newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_UNDERFLOW, (SSLEngineResult.HandshakeStatus)localObject1, 0, 0);
                    return paramArrayOfByteBuffer1;
                  }
                  if (l1 == 0L)
                  {
                    paramArrayOfByteBuffer1 = newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_OVERFLOW, (SSLEngineResult.HandshakeStatus)localObject1, 0, 0);
                    return paramArrayOfByteBuffer1;
                  }
                  l1 = Math.min(2147483647L, l2);
                  n = (int)l1;
                }
                paramInt2 = 0;
                paramInt1 = 0;
                int i1 = paramInt3;
                paramInt4 = i;
                for (;;)
                {
                  ByteBuffer localByteBuffer = paramArrayOfByteBuffer1[paramInt4];
                  try
                  {
                    paramInt3 = localByteBuffer.remaining();
                    int i2;
                    ByteBuf localByteBuf;
                    if (paramInt3 == 0)
                    {
                      if (m <= 0)
                      {
                        paramInt3 = paramInt4 + 1;
                        paramInt4 = paramInt3;
                        if (paramInt3 < j) {
                          continue;
                        }
                        paramArrayOfByteBuffer1 = (ByteBuffer[])localObject1;
                        paramInt3 = paramInt2;
                        paramInt4 = paramInt1;
                        break label1292;
                      }
                      i2 = SSL.bioLengthByteBuffer(this.networkBIO);
                      localByteBuf = null;
                      i = i1;
                      paramInt3 = m;
                    }
                    else
                    {
                      i2 = Math.min(n, paramInt3);
                      localByteBuf = writeEncryptedData(localByteBuffer, i2);
                      paramInt3 = m;
                      i = i1;
                    }
                    label755:
                    localObject2 = paramArrayOfByteBuffer2[i];
                    try
                    {
                      boolean bool = ((ByteBuffer)localObject2).hasRemaining();
                      if (!bool)
                      {
                        m = i + 1;
                        i = m;
                        if (m < k) {
                          break label755;
                        }
                        paramArrayOfByteBuffer1 = (ByteBuffer[])localObject1;
                        paramInt3 = paramInt2;
                        paramInt4 = paramInt1;
                        if (localByteBuf == null) {
                          break label1292;
                        }
                        paramArrayOfByteBuffer1 = (ByteBuffer[])localObject1;
                      }
                      for (;;)
                      {
                        localByteBuf.release();
                        paramInt3 = paramInt2;
                        paramInt4 = paramInt1;
                        break label1292;
                        i1 = readPlaintextData((ByteBuffer)localObject2);
                        m = i2 - SSL.bioLengthByteBuffer(this.networkBIO);
                        paramInt1 += m;
                        n -= m;
                        i2 -= m;
                        localByteBuffer.position(localByteBuffer.position() + m);
                        if (i1 > 0)
                        {
                          paramInt2 += i1;
                          if (!((ByteBuffer)localObject2).hasRemaining())
                          {
                            paramInt3 = sslPending0();
                            i++;
                            if (i >= k)
                            {
                              if (paramInt3 > 0)
                              {
                                paramArrayOfByteBuffer1 = newResult(SSLEngineResult.Status.BUFFER_OVERFLOW, (SSLEngineResult.HandshakeStatus)localObject1, paramInt1, paramInt2);
                              }
                              else
                              {
                                if (isInboundDone()) {
                                  paramArrayOfByteBuffer1 = SSLEngineResult.Status.CLOSED;
                                } else {
                                  paramArrayOfByteBuffer1 = SSLEngineResult.Status.OK;
                                }
                                paramArrayOfByteBuffer1 = newResultMayFinishHandshake(paramArrayOfByteBuffer1, (SSLEngineResult.HandshakeStatus)localObject1, paramInt1, paramInt2);
                              }
                              if (localByteBuf != null) {
                                localByteBuf.release();
                              }
                              SSL.bioClearByteBuffer(this.networkBIO);
                              rejectRemoteInitiatedRenegotiation();
                              return paramArrayOfByteBuffer1;
                            }
                          }
                          else
                          {
                            localObject2 = localObject1;
                            if ((n == 0) || (this.jdkCompatibilityMode)) {
                              break label1013;
                            }
                          }
                          break;
                          label1013:
                          paramArrayOfByteBuffer1 = (ByteBuffer[])localObject2;
                          paramInt3 = paramInt2;
                          paramInt4 = paramInt1;
                          if (localByteBuf == null) {
                            break label1292;
                          }
                          paramArrayOfByteBuffer1 = (ByteBuffer[])localObject2;
                          continue;
                        }
                        m = SSL.getError(this.ssl, i1);
                        if ((m != SSL.SSL_ERROR_WANT_READ) && (m != SSL.SSL_ERROR_WANT_WRITE))
                        {
                          if (m == SSL.SSL_ERROR_ZERO_RETURN)
                          {
                            if (!this.receivedShutdown) {
                              closeAll();
                            }
                            if (isInboundDone()) {
                              paramArrayOfByteBuffer1 = SSLEngineResult.Status.CLOSED;
                            } else {
                              paramArrayOfByteBuffer1 = SSLEngineResult.Status.OK;
                            }
                            paramArrayOfByteBuffer1 = newResultMayFinishHandshake(paramArrayOfByteBuffer1, (SSLEngineResult.HandshakeStatus)localObject1, paramInt1, paramInt2);
                            if (localByteBuf != null) {
                              localByteBuf.release();
                            }
                            SSL.bioClearByteBuffer(this.networkBIO);
                            rejectRemoteInitiatedRenegotiation();
                            return paramArrayOfByteBuffer1;
                          }
                          if ((m != SSL.SSL_ERROR_WANT_X509_LOOKUP) && (m != SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY) && (m != SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION))
                          {
                            paramArrayOfByteBuffer1 = sslReadErrorResult(m, SSL.getLastErrorNumber(), paramInt1, paramInt2);
                            if (localByteBuf != null) {
                              localByteBuf.release();
                            }
                            SSL.bioClearByteBuffer(this.networkBIO);
                            rejectRemoteInitiatedRenegotiation();
                            return paramArrayOfByteBuffer1;
                          }
                          if (isInboundDone()) {
                            paramArrayOfByteBuffer1 = SSLEngineResult.Status.CLOSED;
                          } else {
                            paramArrayOfByteBuffer1 = SSLEngineResult.Status.OK;
                          }
                          paramArrayOfByteBuffer1 = newResult(paramArrayOfByteBuffer1, SSLEngineResult.HandshakeStatus.NEED_TASK, paramInt1, paramInt2);
                          if (localByteBuf != null) {
                            localByteBuf.release();
                          }
                          SSL.bioClearByteBuffer(this.networkBIO);
                          rejectRemoteInitiatedRenegotiation();
                          return paramArrayOfByteBuffer1;
                        }
                        paramInt4++;
                        if (paramInt4 < j) {
                          break label1367;
                        }
                        paramArrayOfByteBuffer1 = (ByteBuffer[])localObject1;
                        paramInt3 = paramInt2;
                        paramInt4 = paramInt1;
                        if (localByteBuf == null) {
                          break label1292;
                        }
                        paramArrayOfByteBuffer1 = (ByteBuffer[])localObject1;
                      }
                      label1292:
                      SSL.bioClearByteBuffer(this.networkBIO);
                      rejectRemoteInitiatedRenegotiation();
                      if ((!this.receivedShutdown) && ((SSL.getShutdown(this.ssl) & SSL.SSL_RECEIVED_SHUTDOWN) == SSL.SSL_RECEIVED_SHUTDOWN)) {
                        closeAll();
                      }
                      if (isInboundDone()) {
                        paramArrayOfByteBuffer2 = SSLEngineResult.Status.CLOSED;
                      } else {
                        paramArrayOfByteBuffer2 = SSLEngineResult.Status.OK;
                      }
                      paramArrayOfByteBuffer1 = newResultMayFinishHandshake(paramArrayOfByteBuffer2, paramArrayOfByteBuffer1, paramInt4, paramInt3);
                      return paramArrayOfByteBuffer1;
                      label1367:
                      if (localByteBuf != null) {
                        localByteBuf.release();
                      }
                      i1 = i;
                      m = paramInt3;
                      continue;
                    }
                    finally
                    {
                      if (localByteBuf != null) {
                        localByteBuf.release();
                      }
                    }
                    paramArrayOfByteBuffer1 = finally;
                  }
                  finally
                  {
                    SSL.bioClearByteBuffer(this.networkBIO);
                    rejectRemoteInitiatedRenegotiation();
                  }
                }
                paramArrayOfByteBuffer1 = new StringBuilder();
              }
              finally {}
            }
          }
          paramArrayOfByteBuffer1.append("offset: ");
          paramArrayOfByteBuffer1.append(paramInt3);
          paramArrayOfByteBuffer1.append(", length: ");
          paramArrayOfByteBuffer1.append(paramInt4);
          paramArrayOfByteBuffer1.append(" (expected: offset <= offset + length <= dsts.length (");
          paramArrayOfByteBuffer1.append(paramArrayOfByteBuffer2.length);
          paramArrayOfByteBuffer1.append("))");
          throw new IndexOutOfBoundsException(paramArrayOfByteBuffer1.toString());
        }
        throw new IllegalArgumentException("dsts is null");
      }
    }
    paramArrayOfByteBuffer2 = new StringBuilder();
    paramArrayOfByteBuffer2.append("offset: ");
    paramArrayOfByteBuffer2.append(i);
    paramArrayOfByteBuffer2.append(", length: ");
    paramArrayOfByteBuffer2.append(paramInt2);
    paramArrayOfByteBuffer2.append(" (expected: offset <= offset + length <= srcs.length (");
    paramArrayOfByteBuffer2.append(paramArrayOfByteBuffer1.length);
    paramArrayOfByteBuffer2.append("))");
    throw new IndexOutOfBoundsException(paramArrayOfByteBuffer2.toString());
  }
  
  public final SSLEngineResult unwrap(ByteBuffer[] paramArrayOfByteBuffer1, ByteBuffer[] paramArrayOfByteBuffer2)
    throws SSLException
  {
    return unwrap(paramArrayOfByteBuffer1, 0, paramArrayOfByteBuffer1.length, paramArrayOfByteBuffer2, 0, paramArrayOfByteBuffer2.length);
  }
  
  /* Error */
  public final SSLEngineResult wrap(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws SSLException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 1160	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:singleSrcBuffer	(Ljava/nio/ByteBuffer;)[Ljava/nio/ByteBuffer;
    //   8: aload_2
    //   9: invokevirtual 1272	javax/net/ssl/SSLEngine:wrap	([Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)Ljavax/net/ssl/SSLEngineResult;
    //   12: astore_1
    //   13: aload_0
    //   14: invokespecial 1167	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:resetSingleSrcBuffer	()V
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: astore_1
    //   22: aload_0
    //   23: invokespecial 1167	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:resetSingleSrcBuffer	()V
    //   26: aload_1
    //   27: athrow
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	ReferenceCountedOpenSslEngine
    //   0	33	1	paramByteBuffer1	ByteBuffer
    //   0	33	2	paramByteBuffer2	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   2	13	21	finally
    //   13	17	28	finally
    //   22	28	28	finally
  }
  
  public final SSLEngineResult wrap(ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer)
    throws SSLException
  {
    if (paramArrayOfByteBuffer != null)
    {
      if (paramByteBuffer != null)
      {
        if (paramInt1 < paramArrayOfByteBuffer.length)
        {
          int i = paramInt1 + paramInt2;
          if (i <= paramArrayOfByteBuffer.length)
          {
            if (!paramByteBuffer.isReadOnly()) {
              try
              {
                if (isOutboundDone())
                {
                  if ((!isInboundDone()) && (!isDestroyed())) {
                    paramArrayOfByteBuffer = NEED_UNWRAP_CLOSED;
                  } else {
                    paramArrayOfByteBuffer = CLOSED_NOT_HANDSHAKING;
                  }
                  return paramArrayOfByteBuffer;
                }
                Object localObject1 = null;
                paramInt2 = 0;
                int j = 0;
                int k = 0;
                Object localObject2;
                try
                {
                  if (paramByteBuffer.isDirect())
                  {
                    SSL.bioSetByteBuffer(this.networkBIO, bufferAddress(paramByteBuffer) + paramByteBuffer.position(), paramByteBuffer.remaining(), true);
                    localObject2 = null;
                  }
                  else
                  {
                    localObject2 = this.alloc.directBuffer(paramByteBuffer.remaining());
                    localObject1 = localObject2;
                  }
                  try
                  {
                    SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress((ByteBuf)localObject2), ((ByteBuf)localObject2).writableBytes(), true);
                    localObject1 = localObject2;
                    int m = SSL.bioLengthByteBuffer(this.networkBIO);
                    localObject1 = localObject2;
                    if (this.outboundClosed)
                    {
                      localObject1 = localObject2;
                      if (!isBytesAvailableEnoughForWrap(paramByteBuffer.remaining(), 2, 1))
                      {
                        localObject1 = localObject2;
                        paramArrayOfByteBuffer = new javax/net/ssl/SSLEngineResult;
                        localObject1 = localObject2;
                        paramArrayOfByteBuffer.<init>(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), 0, 0);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (localObject2 == null)
                        {
                          paramByteBuffer.position(paramByteBuffer.position() + 0);
                        }
                        else
                        {
                          paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), 0));
                          ((ReferenceCounted)localObject2).release();
                        }
                        return paramArrayOfByteBuffer;
                      }
                      localObject1 = localObject2;
                      j = SSL.bioFlushByteBuffer(this.networkBIO);
                      if (j <= 0) {
                        paramInt1 = j;
                      }
                      try
                      {
                        paramArrayOfByteBuffer = newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (localObject2 == null)
                        {
                          paramByteBuffer.position(paramByteBuffer.position() + j);
                        }
                        else
                        {
                          paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), j));
                          ((ReferenceCounted)localObject2).release();
                        }
                        return paramArrayOfByteBuffer;
                      }
                      finally
                      {
                        break label2641;
                      }
                      paramInt1 = j;
                      if (!doSSLShutdown())
                      {
                        paramInt1 = j;
                        paramArrayOfByteBuffer = newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, j);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (localObject2 == null)
                        {
                          paramByteBuffer.position(paramByteBuffer.position() + j);
                        }
                        else
                        {
                          paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), j));
                          ((ReferenceCounted)localObject2).release();
                        }
                        return paramArrayOfByteBuffer;
                      }
                      paramInt1 = j;
                      paramInt2 = SSL.bioLengthByteBuffer(this.networkBIO);
                      paramInt2 = m - paramInt2;
                      paramInt1 = paramInt2;
                      try
                      {
                        paramArrayOfByteBuffer = newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, paramInt2);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (localObject2 == null)
                        {
                          paramByteBuffer.position(paramByteBuffer.position() + paramInt2);
                        }
                        else
                        {
                          paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), paramInt2));
                          ((ReferenceCounted)localObject2).release();
                        }
                        return paramArrayOfByteBuffer;
                      }
                      finally
                      {
                        break label2652;
                      }
                    }
                    localObject1 = localObject2;
                    Object localObject3 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                    localObject1 = localObject2;
                    HandshakeState localHandshakeState = this.handshakeState;
                    localObject1 = localObject2;
                    if (localHandshakeState != HandshakeState.FINISHED)
                    {
                      localObject1 = localObject2;
                      if (localHandshakeState != HandshakeState.STARTED_EXPLICITLY)
                      {
                        localObject1 = localObject2;
                        this.handshakeState = HandshakeState.STARTED_IMPLICITLY;
                      }
                      localObject1 = localObject2;
                      j = SSL.bioFlushByteBuffer(this.networkBIO);
                      paramInt2 = j;
                    }
                    try
                    {
                      if (this.pendingException != null)
                      {
                        if (j > 0)
                        {
                          paramInt2 = j;
                          paramArrayOfByteBuffer = newResult(SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, j);
                          SSL.bioClearByteBuffer(this.networkBIO);
                          if (localObject2 == null)
                          {
                            paramByteBuffer.position(paramByteBuffer.position() + j);
                          }
                          else
                          {
                            paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), j));
                            ((ReferenceCounted)localObject2).release();
                          }
                          return paramArrayOfByteBuffer;
                        }
                        paramInt2 = j;
                        paramArrayOfByteBuffer = newResult(handshakeException(), 0, 0);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (localObject2 == null)
                        {
                          paramByteBuffer.position(paramByteBuffer.position() + j);
                        }
                        else
                        {
                          paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), j));
                          ((ReferenceCounted)localObject2).release();
                        }
                        return paramArrayOfByteBuffer;
                      }
                      paramInt2 = j;
                      localObject3 = handshake();
                      paramInt2 = j;
                      int n = m - SSL.bioLengthByteBuffer(this.networkBIO);
                      paramInt2 = n;
                      if (localObject3 == SSLEngineResult.HandshakeStatus.NEED_TASK)
                      {
                        paramInt2 = n;
                        paramArrayOfByteBuffer = newResult((SSLEngineResult.HandshakeStatus)localObject3, 0, n);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (localObject2 == null)
                        {
                          paramByteBuffer.position(paramByteBuffer.position() + n);
                        }
                        else
                        {
                          paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), n));
                          ((ReferenceCounted)localObject2).release();
                        }
                        return paramArrayOfByteBuffer;
                      }
                      if (n > 0)
                      {
                        paramInt2 = n;
                        localObject1 = SSLEngineResult.HandshakeStatus.FINISHED;
                        paramArrayOfByteBuffer = (ByteBuffer[])localObject1;
                        if (localObject3 != localObject1) {
                          if (n == m)
                          {
                            paramInt2 = n;
                            paramArrayOfByteBuffer = SSLEngineResult.HandshakeStatus.NEED_WRAP;
                          }
                          else
                          {
                            paramInt2 = n;
                            paramArrayOfByteBuffer = getHandshakeStatus(SSL.bioLengthNonApplication(this.networkBIO));
                          }
                        }
                        paramInt2 = n;
                        paramArrayOfByteBuffer = newResult(mayFinishHandshake(paramArrayOfByteBuffer), 0, n);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (localObject2 == null)
                        {
                          paramByteBuffer.position(paramByteBuffer.position() + n);
                        }
                        else
                        {
                          paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), n));
                          ((ReferenceCounted)localObject2).release();
                        }
                        return paramArrayOfByteBuffer;
                      }
                      paramInt2 = n;
                      if (localObject3 == SSLEngineResult.HandshakeStatus.NEED_UNWRAP)
                      {
                        paramInt2 = n;
                        if (isOutboundDone())
                        {
                          paramInt2 = n;
                          paramArrayOfByteBuffer = NEED_UNWRAP_CLOSED;
                        }
                        else
                        {
                          paramInt2 = n;
                          paramArrayOfByteBuffer = NEED_UNWRAP_OK;
                        }
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (localObject2 == null)
                        {
                          paramByteBuffer.position(paramByteBuffer.position() + n);
                        }
                        else
                        {
                          paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), n));
                          ((ReferenceCounted)localObject2).release();
                        }
                        return paramArrayOfByteBuffer;
                      }
                      j = n;
                      localObject1 = localObject3;
                      paramInt2 = n;
                      if (this.outboundClosed)
                      {
                        paramInt2 = n;
                        j = SSL.bioFlushByteBuffer(this.networkBIO);
                        paramInt1 = j;
                        paramArrayOfByteBuffer = newResultMayFinishHandshake((SSLEngineResult.HandshakeStatus)localObject3, 0, j);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (localObject2 == null)
                        {
                          paramByteBuffer.position(paramByteBuffer.position() + j);
                        }
                        else
                        {
                          paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), j));
                          ((ReferenceCounted)localObject2).release();
                        }
                        return paramArrayOfByteBuffer;
                        localObject1 = localObject3;
                        j = 0;
                      }
                      paramInt2 = j;
                      int i1;
                      if (this.jdkCompatibilityMode)
                      {
                        n = paramInt1;
                        i1 = 0;
                        while (n < i)
                        {
                          localObject3 = paramArrayOfByteBuffer[n];
                          if (localObject3 != null)
                          {
                            paramInt2 = j;
                            int i2 = MAX_PLAINTEXT_LENGTH;
                            if (i1 == i2)
                            {
                              paramInt2 = i1;
                            }
                            else
                            {
                              paramInt2 = j;
                              i1 += ((ByteBuffer)localObject3).remaining();
                              if (i1 <= i2)
                              {
                                paramInt2 = i1;
                                if (i1 >= 0) {}
                              }
                              else
                              {
                                paramInt2 = i2;
                              }
                            }
                            n++;
                            i1 = paramInt2;
                          }
                          else
                          {
                            paramInt2 = j;
                            paramArrayOfByteBuffer = new java/lang/IllegalArgumentException;
                            paramInt2 = j;
                            localObject1 = new java/lang/StringBuilder;
                            paramInt2 = j;
                            ((StringBuilder)localObject1).<init>();
                            paramInt2 = j;
                            ((StringBuilder)localObject1).append("srcs[");
                            paramInt2 = j;
                            ((StringBuilder)localObject1).append(n);
                            paramInt2 = j;
                            ((StringBuilder)localObject1).append("] is null");
                            paramInt2 = j;
                            paramArrayOfByteBuffer.<init>(((StringBuilder)localObject1).toString());
                            paramInt2 = j;
                            throw paramArrayOfByteBuffer;
                          }
                        }
                        paramInt2 = j;
                        if (!isBytesAvailableEnoughForWrap(paramByteBuffer.remaining(), i1, 1))
                        {
                          paramInt2 = j;
                          paramArrayOfByteBuffer = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), 0, 0);
                          SSL.bioClearByteBuffer(this.networkBIO);
                          if (localObject2 == null)
                          {
                            paramByteBuffer.position(paramByteBuffer.position() + j);
                          }
                          else
                          {
                            paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), j));
                            ((ReferenceCounted)localObject2).release();
                          }
                          return paramArrayOfByteBuffer;
                        }
                      }
                      paramInt2 = j;
                      n = SSL.bioFlushByteBuffer(this.networkBIO);
                      if (n > 0)
                      {
                        paramInt2 = n;
                        paramArrayOfByteBuffer = newResultMayFinishHandshake((SSLEngineResult.HandshakeStatus)localObject1, 0, n);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (localObject2 == null)
                        {
                          paramByteBuffer.position(paramByteBuffer.position() + n);
                        }
                        else
                        {
                          paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), n));
                          ((ReferenceCounted)localObject2).release();
                        }
                        return paramArrayOfByteBuffer;
                      }
                      paramInt2 = n;
                      localObject3 = this.pendingException;
                      if (localObject3 == null)
                      {
                        j = paramInt1;
                        paramInt1 = n;
                        i1 = m;
                        n = k;
                        while (j < i)
                        {
                          localObject3 = paramArrayOfByteBuffer[j];
                          paramInt2 = paramInt1;
                          m = ((ByteBuffer)localObject3).remaining();
                          if (m != 0)
                          {
                            paramInt2 = paramInt1;
                            if (this.jdkCompatibilityMode)
                            {
                              paramInt2 = paramInt1;
                              m = writePlaintextData((ByteBuffer)localObject3, Math.min(m, MAX_PLAINTEXT_LENGTH - n));
                            }
                            else
                            {
                              paramInt2 = paramInt1;
                              k = paramByteBuffer.remaining() - paramInt1 - this.maxWrapOverhead;
                              if (k <= 0)
                              {
                                paramInt2 = paramInt1;
                                paramArrayOfByteBuffer = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), n, paramInt1);
                                SSL.bioClearByteBuffer(this.networkBIO);
                                if (localObject2 == null)
                                {
                                  paramByteBuffer.position(paramByteBuffer.position() + paramInt1);
                                }
                                else
                                {
                                  paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), paramInt1));
                                  ((ReferenceCounted)localObject2).release();
                                }
                                return paramArrayOfByteBuffer;
                              }
                              paramInt2 = paramInt1;
                              m = writePlaintextData((ByteBuffer)localObject3, Math.min(m, k));
                            }
                            paramInt2 = paramInt1;
                            k = SSL.bioLengthByteBuffer(this.networkBIO);
                            paramInt2 = i1 - k + paramInt1;
                            if (m <= 0) {
                              break label1922;
                            }
                            n += m;
                            paramInt1 = paramInt2;
                            if (!this.jdkCompatibilityMode)
                            {
                              paramInt1 = paramInt2;
                              if (paramInt2 != paramByteBuffer.remaining())
                              {
                                paramInt1 = paramInt2;
                                i1 = k;
                              }
                            }
                          }
                          else
                          {
                            j++;
                            continue;
                          }
                          paramInt1 = paramInt2;
                          paramArrayOfByteBuffer = newResultMayFinishHandshake((SSLEngineResult.HandshakeStatus)localObject1, n, paramInt2);
                          SSL.bioClearByteBuffer(this.networkBIO);
                          if (localObject2 == null)
                          {
                            paramByteBuffer.position(paramByteBuffer.position() + paramInt2);
                          }
                          else
                          {
                            paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), paramInt2));
                            ((ReferenceCounted)localObject2).release();
                          }
                          return paramArrayOfByteBuffer;
                          label1922:
                          paramInt1 = paramInt2;
                          j = SSL.getError(this.ssl, m);
                          paramInt1 = paramInt2;
                          if (j == SSL.SSL_ERROR_ZERO_RETURN)
                          {
                            paramInt1 = paramInt2;
                            if (!this.receivedShutdown)
                            {
                              paramInt1 = paramInt2;
                              closeAll();
                              paramInt1 = paramInt2;
                              j = SSL.bioLengthByteBuffer(this.networkBIO);
                              paramInt2 += k - j;
                              paramInt1 = paramInt2;
                              localObject3 = SSLEngineResult.HandshakeStatus.FINISHED;
                              paramArrayOfByteBuffer = (ByteBuffer[])localObject3;
                              if (localObject1 != localObject3)
                              {
                                paramInt1 = paramInt2;
                                if (paramInt2 == paramByteBuffer.remaining())
                                {
                                  paramInt1 = paramInt2;
                                  paramArrayOfByteBuffer = SSLEngineResult.HandshakeStatus.NEED_WRAP;
                                }
                                else
                                {
                                  paramInt1 = paramInt2;
                                  paramArrayOfByteBuffer = getHandshakeStatus(SSL.bioLengthNonApplication(this.networkBIO));
                                }
                              }
                              paramInt1 = paramInt2;
                              paramArrayOfByteBuffer = newResult(mayFinishHandshake(paramArrayOfByteBuffer), n, paramInt2);
                              SSL.bioClearByteBuffer(this.networkBIO);
                              if (localObject2 == null)
                              {
                                paramByteBuffer.position(paramByteBuffer.position() + paramInt2);
                              }
                              else
                              {
                                paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), paramInt2));
                                ((ReferenceCounted)localObject2).release();
                              }
                              return paramArrayOfByteBuffer;
                            }
                            paramInt1 = paramInt2;
                            paramArrayOfByteBuffer = newResult(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, n, paramInt2);
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (localObject2 == null)
                            {
                              paramByteBuffer.position(paramByteBuffer.position() + paramInt2);
                            }
                            else
                            {
                              paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), paramInt2));
                              ((ReferenceCounted)localObject2).release();
                            }
                            return paramArrayOfByteBuffer;
                          }
                          paramInt1 = paramInt2;
                          if (j == SSL.SSL_ERROR_WANT_READ)
                          {
                            paramInt1 = paramInt2;
                            paramArrayOfByteBuffer = newResult(SSLEngineResult.HandshakeStatus.NEED_UNWRAP, n, paramInt2);
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (localObject2 == null)
                            {
                              paramByteBuffer.position(paramByteBuffer.position() + paramInt2);
                            }
                            else
                            {
                              paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), paramInt2));
                              ((ReferenceCounted)localObject2).release();
                            }
                            return paramArrayOfByteBuffer;
                          }
                          paramInt1 = paramInt2;
                          if (j == SSL.SSL_ERROR_WANT_WRITE)
                          {
                            if (paramInt2 > 0)
                            {
                              paramInt1 = paramInt2;
                              paramArrayOfByteBuffer = newResult(SSLEngineResult.HandshakeStatus.NEED_WRAP, n, paramInt2);
                              SSL.bioClearByteBuffer(this.networkBIO);
                              if (localObject2 == null)
                              {
                                paramByteBuffer.position(paramByteBuffer.position() + paramInt2);
                              }
                              else
                              {
                                paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), paramInt2));
                                ((ReferenceCounted)localObject2).release();
                              }
                              return paramArrayOfByteBuffer;
                            }
                            paramInt1 = paramInt2;
                            paramArrayOfByteBuffer = newResult(SSLEngineResult.Status.BUFFER_OVERFLOW, (SSLEngineResult.HandshakeStatus)localObject1, n, paramInt2);
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (localObject2 == null)
                            {
                              paramByteBuffer.position(paramByteBuffer.position() + paramInt2);
                            }
                            else
                            {
                              paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), paramInt2));
                              ((ReferenceCounted)localObject2).release();
                            }
                            return paramArrayOfByteBuffer;
                          }
                          paramInt1 = paramInt2;
                          if (j != SSL.SSL_ERROR_WANT_X509_LOOKUP)
                          {
                            paramInt1 = paramInt2;
                            if (j != SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY)
                            {
                              paramInt1 = paramInt2;
                              if (j != SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION)
                              {
                                paramInt1 = paramInt2;
                                throw shutdownWithError("SSL_write", j);
                              }
                            }
                          }
                          paramInt1 = paramInt2;
                          paramArrayOfByteBuffer = newResult(SSLEngineResult.HandshakeStatus.NEED_TASK, n, paramInt2);
                          SSL.bioClearByteBuffer(this.networkBIO);
                          if (localObject2 == null)
                          {
                            paramByteBuffer.position(paramByteBuffer.position() + paramInt2);
                          }
                          else
                          {
                            paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), paramInt2));
                            ((ReferenceCounted)localObject2).release();
                          }
                          return paramArrayOfByteBuffer;
                        }
                        paramInt2 = paramInt1;
                        paramArrayOfByteBuffer = newResultMayFinishHandshake((SSLEngineResult.HandshakeStatus)localObject1, n, paramInt1);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (localObject2 == null)
                        {
                          paramByteBuffer.position(paramByteBuffer.position() + paramInt1);
                        }
                        else
                        {
                          paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), paramInt1));
                          ((ReferenceCounted)localObject2).release();
                        }
                        return paramArrayOfByteBuffer;
                      }
                      paramInt2 = n;
                      this.pendingException = null;
                      paramInt2 = n;
                      shutdown();
                      paramInt2 = n;
                      paramArrayOfByteBuffer = new javax/net/ssl/SSLException;
                      paramInt2 = n;
                      paramArrayOfByteBuffer.<init>((Throwable)localObject3);
                      paramInt2 = n;
                      throw paramArrayOfByteBuffer;
                    }
                    finally
                    {
                      paramInt1 = paramInt2;
                    }
                  }
                  finally {}
                  label2641:
                  SSL.bioClearByteBuffer(this.networkBIO);
                }
                finally
                {
                  localObject2 = localObject1;
                  paramInt1 = j;
                }
                label2652:
                if (localObject2 != null)
                {
                  paramByteBuffer.put(((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).readerIndex(), paramInt1));
                  ((ReferenceCounted)localObject2).release();
                }
                else
                {
                  paramByteBuffer.position(paramByteBuffer.position() + paramInt1);
                }
                throw paramArrayOfByteBuffer;
              }
              finally {}
            }
            throw new ReadOnlyBufferException();
          }
        }
        paramByteBuffer = new StringBuilder();
        paramByteBuffer.append("offset: ");
        paramByteBuffer.append(paramInt1);
        paramByteBuffer.append(", length: ");
        paramByteBuffer.append(paramInt2);
        paramByteBuffer.append(" (expected: offset <= offset + length <= srcs.length (");
        paramByteBuffer.append(paramArrayOfByteBuffer.length);
        paramByteBuffer.append("))");
        throw new IndexOutOfBoundsException(paramByteBuffer.toString());
      }
      throw new IllegalArgumentException("dst is null");
    }
    throw new IllegalArgumentException("srcs is null");
  }
  
  private final class DefaultOpenSslSession
    implements OpenSslSession
  {
    private volatile int applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;
    private String cipher;
    private long creationTime;
    private byte[] id;
    private Certificate[] peerCerts;
    private String protocol;
    private final OpenSslSessionContext sessionContext;
    private Map<String, Object> values;
    private javax.security.cert.X509Certificate[] x509PeerCerts;
    
    DefaultOpenSslSession(OpenSslSessionContext paramOpenSslSessionContext)
    {
      this.sessionContext = paramOpenSslSessionContext;
    }
    
    private void initCerts(byte[][] paramArrayOfByte, int paramInt)
    {
      for (int i = 0; i < paramArrayOfByte.length; i++)
      {
        int j = paramInt + i;
        this.peerCerts[j] = new OpenSslX509Certificate(paramArrayOfByte[i]);
        this.x509PeerCerts[j] = new OpenSslJavaxX509Certificate(paramArrayOfByte[i]);
      }
    }
    
    private void initPeerCerts()
    {
      byte[][] arrayOfByte = SSL.getPeerCertChain(ReferenceCountedOpenSslEngine.this.ssl);
      if (ReferenceCountedOpenSslEngine.this.clientMode)
      {
        if (ReferenceCountedOpenSslEngine.isEmpty(arrayOfByte))
        {
          this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
          this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
        }
        else
        {
          this.peerCerts = new Certificate[arrayOfByte.length];
          this.x509PeerCerts = new javax.security.cert.X509Certificate[arrayOfByte.length];
          initCerts(arrayOfByte, 0);
        }
      }
      else
      {
        byte[] arrayOfByte1 = SSL.getPeerCertificate(ReferenceCountedOpenSslEngine.this.ssl);
        if (ReferenceCountedOpenSslEngine.isEmpty(arrayOfByte1))
        {
          this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
          this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
        }
        else if (ReferenceCountedOpenSslEngine.isEmpty(arrayOfByte))
        {
          this.peerCerts = new Certificate[] { new OpenSslX509Certificate(arrayOfByte1) };
          this.x509PeerCerts = new javax.security.cert.X509Certificate[] { new OpenSslJavaxX509Certificate(arrayOfByte1) };
        }
        else
        {
          Certificate[] arrayOfCertificate = new Certificate[arrayOfByte.length + 1];
          this.peerCerts = arrayOfCertificate;
          this.x509PeerCerts = new javax.security.cert.X509Certificate[arrayOfByte.length + 1];
          arrayOfCertificate[0] = new OpenSslX509Certificate(arrayOfByte1);
          this.x509PeerCerts[0] = new OpenSslJavaxX509Certificate(arrayOfByte1);
          initCerts(arrayOfByte, 1);
        }
      }
    }
    
    private SSLSessionBindingEvent newSSLSessionBindingEvent(String paramString)
    {
      return new SSLSessionBindingEvent(ReferenceCountedOpenSslEngine.this.session, paramString);
    }
    
    private void notifyUnbound(Object paramObject, String paramString)
    {
      if ((paramObject instanceof SSLSessionBindingListener)) {
        ((SSLSessionBindingListener)paramObject).valueUnbound(newSSLSessionBindingEvent(paramString));
      }
    }
    
    private String selectApplicationProtocol(List<String> paramList, ApplicationProtocolConfig.SelectedListenerFailureBehavior paramSelectedListenerFailureBehavior, String paramString)
      throws SSLException
    {
      if (paramSelectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT) {
        return paramString;
      }
      int i = paramList.size();
      if (paramList.contains(paramString)) {
        return paramString;
      }
      if (paramSelectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL) {
        return (String)paramList.get(i - 1);
      }
      paramList = new StringBuilder();
      paramList.append("unknown protocol ");
      paramList.append(paramString);
      throw new SSLException(paramList.toString());
    }
    
    private void selectApplicationProtocol()
      throws SSLException
    {
      ApplicationProtocolConfig.SelectedListenerFailureBehavior localSelectedListenerFailureBehavior = ReferenceCountedOpenSslEngine.this.apn.selectedListenerFailureBehavior();
      List localList = ReferenceCountedOpenSslEngine.this.apn.protocols();
      int i = ReferenceCountedOpenSslEngine.4.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ReferenceCountedOpenSslEngine.this.apn.protocol().ordinal()];
      if (i != 1)
      {
        String str2;
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4)
            {
              String str1 = SSL.getAlpnSelected(ReferenceCountedOpenSslEngine.this.ssl);
              str2 = str1;
              if (str1 == null) {
                str2 = SSL.getNextProtoNegotiated(ReferenceCountedOpenSslEngine.this.ssl);
              }
              if (str2 != null) {
                ReferenceCountedOpenSslEngine.access$1602(ReferenceCountedOpenSslEngine.this, selectApplicationProtocol(localList, localSelectedListenerFailureBehavior, str2));
              }
            }
            else
            {
              throw new Error();
            }
          }
          else
          {
            str2 = SSL.getNextProtoNegotiated(ReferenceCountedOpenSslEngine.this.ssl);
            if (str2 != null) {
              ReferenceCountedOpenSslEngine.access$1602(ReferenceCountedOpenSslEngine.this, selectApplicationProtocol(localList, localSelectedListenerFailureBehavior, str2));
            }
          }
        }
        else
        {
          str2 = SSL.getAlpnSelected(ReferenceCountedOpenSslEngine.this.ssl);
          if (str2 != null) {
            ReferenceCountedOpenSslEngine.access$1602(ReferenceCountedOpenSslEngine.this, selectApplicationProtocol(localList, localSelectedListenerFailureBehavior, str2));
          }
        }
      }
    }
    
    public int getApplicationBufferSize()
    {
      return this.applicationBufferSize;
    }
    
    public String getCipherSuite()
    {
      synchronized (ReferenceCountedOpenSslEngine.this)
      {
        String str = this.cipher;
        if (str == null) {
          return "SSL_NULL_WITH_NULL_NULL";
        }
        return str;
      }
    }
    
    public long getCreationTime()
    {
      synchronized (ReferenceCountedOpenSslEngine.this)
      {
        if ((this.creationTime == 0L) && (!ReferenceCountedOpenSslEngine.this.isDestroyed())) {
          this.creationTime = (SSL.getTime(ReferenceCountedOpenSslEngine.this.ssl) * 1000L);
        }
        return this.creationTime;
      }
    }
    
    public byte[] getId()
    {
      synchronized (ReferenceCountedOpenSslEngine.this)
      {
        byte[] arrayOfByte = this.id;
        if (arrayOfByte == null)
        {
          arrayOfByte = EmptyArrays.EMPTY_BYTES;
          return arrayOfByte;
        }
        arrayOfByte = (byte[])arrayOfByte.clone();
        return arrayOfByte;
      }
    }
    
    public long getLastAccessedTime()
    {
      long l1 = ReferenceCountedOpenSslEngine.this.lastAccessed;
      long l2 = l1;
      if (l1 == -1L) {
        l2 = getCreationTime();
      }
      return l2;
    }
    
    public Certificate[] getLocalCertificates()
    {
      Certificate[] arrayOfCertificate = ReferenceCountedOpenSslEngine.this.localCertificateChain;
      if (arrayOfCertificate == null) {
        return null;
      }
      return (Certificate[])arrayOfCertificate.clone();
    }
    
    public Principal getLocalPrincipal()
    {
      Certificate[] arrayOfCertificate = ReferenceCountedOpenSslEngine.this.localCertificateChain;
      if ((arrayOfCertificate != null) && (arrayOfCertificate.length != 0)) {
        return ((java.security.cert.X509Certificate)arrayOfCertificate[0]).getIssuerX500Principal();
      }
      return null;
    }
    
    public int getPacketBufferSize()
    {
      return ReferenceCountedOpenSslEngine.this.maxEncryptedPacketLength();
    }
    
    public javax.security.cert.X509Certificate[] getPeerCertificateChain()
      throws SSLPeerUnverifiedException
    {
      synchronized (ReferenceCountedOpenSslEngine.this)
      {
        if (!ReferenceCountedOpenSslEngine.isEmpty(this.x509PeerCerts))
        {
          localObject1 = (javax.security.cert.X509Certificate[])this.x509PeerCerts.clone();
          return (javax.security.cert.X509Certificate[])localObject1;
        }
        Object localObject1 = new javax/net/ssl/SSLPeerUnverifiedException;
        ((SSLPeerUnverifiedException)localObject1).<init>("peer not verified");
        throw ((Throwable)localObject1);
      }
    }
    
    public Certificate[] getPeerCertificates()
      throws SSLPeerUnverifiedException
    {
      synchronized (ReferenceCountedOpenSslEngine.this)
      {
        if (!ReferenceCountedOpenSslEngine.isEmpty(this.peerCerts))
        {
          localObject1 = (Certificate[])this.peerCerts.clone();
          return (Certificate[])localObject1;
        }
        Object localObject1 = new javax/net/ssl/SSLPeerUnverifiedException;
        ((SSLPeerUnverifiedException)localObject1).<init>("peer not verified");
        throw ((Throwable)localObject1);
      }
    }
    
    public String getPeerHost()
    {
      return ReferenceCountedOpenSslEngine.this.getPeerHost();
    }
    
    public int getPeerPort()
    {
      return ReferenceCountedOpenSslEngine.this.getPeerPort();
    }
    
    public Principal getPeerPrincipal()
      throws SSLPeerUnverifiedException
    {
      return ((java.security.cert.X509Certificate)getPeerCertificates()[0]).getSubjectX500Principal();
    }
    
    public String getProtocol()
    {
      ??? = this.protocol;
      Object localObject2 = ???;
      if (??? == null) {
        synchronized (ReferenceCountedOpenSslEngine.this)
        {
          if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
            localObject2 = SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl);
          } else {
            localObject2 = "";
          }
        }
      }
      return str;
    }
    
    public SSLSessionContext getSessionContext()
    {
      return this.sessionContext;
    }
    
    public Object getValue(String paramString)
    {
      ObjectUtil.checkNotNull(paramString, "name");
      try
      {
        Map localMap = this.values;
        if (localMap == null) {
          return null;
        }
        paramString = localMap.get(paramString);
        return paramString;
      }
      finally {}
    }
    
    public String[] getValueNames()
    {
      try
      {
        Object localObject1 = this.values;
        if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
        {
          localObject1 = (String[])((Map)localObject1).keySet().toArray(new String[0]);
          return (String[])localObject1;
        }
        localObject1 = EmptyArrays.EMPTY_STRINGS;
        return (String[])localObject1;
      }
      finally {}
    }
    
    public void handshakeFinished()
      throws SSLException
    {
      synchronized (ReferenceCountedOpenSslEngine.this)
      {
        if (!ReferenceCountedOpenSslEngine.this.isDestroyed())
        {
          this.id = SSL.getSessionId(ReferenceCountedOpenSslEngine.this.ssl);
          localObject1 = ReferenceCountedOpenSslEngine.this;
          this.cipher = ((ReferenceCountedOpenSslEngine)localObject1).toJavaCipherSuite(SSL.getCipherForSSL(((ReferenceCountedOpenSslEngine)localObject1).ssl));
          this.protocol = SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl);
          initPeerCerts();
          selectApplicationProtocol();
          ReferenceCountedOpenSslEngine.this.calculateMaxWrapOverhead();
          ReferenceCountedOpenSslEngine.access$1202(ReferenceCountedOpenSslEngine.this, ReferenceCountedOpenSslEngine.HandshakeState.FINISHED);
          return;
        }
        Object localObject1 = new javax/net/ssl/SSLException;
        ((SSLException)localObject1).<init>("Already closed");
        throw ((Throwable)localObject1);
      }
    }
    
    public void invalidate()
    {
      synchronized (ReferenceCountedOpenSslEngine.this)
      {
        if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
          SSL.setTimeout(ReferenceCountedOpenSslEngine.this.ssl, 0L);
        }
        return;
      }
    }
    
    public boolean isValid()
    {
      synchronized (ReferenceCountedOpenSslEngine.this)
      {
        boolean bool1 = ReferenceCountedOpenSslEngine.this.isDestroyed();
        boolean bool2 = false;
        if (!bool1)
        {
          if (System.currentTimeMillis() - SSL.getTimeout(ReferenceCountedOpenSslEngine.this.ssl) * 1000L < SSL.getTime(ReferenceCountedOpenSslEngine.this.ssl) * 1000L) {
            bool2 = true;
          }
          return bool2;
        }
        return false;
      }
    }
    
    public void putValue(String paramString, Object paramObject)
    {
      ObjectUtil.checkNotNull(paramString, "name");
      ObjectUtil.checkNotNull(paramObject, "value");
      try
      {
        Map localMap = this.values;
        Object localObject = localMap;
        if (localMap == null)
        {
          localObject = new java/util/HashMap;
          ((HashMap)localObject).<init>(2);
          this.values = ((Map)localObject);
        }
        localObject = ((Map)localObject).put(paramString, paramObject);
        if ((paramObject instanceof SSLSessionBindingListener)) {
          ((SSLSessionBindingListener)paramObject).valueBound(newSSLSessionBindingEvent(paramString));
        }
        notifyUnbound(localObject, paramString);
        return;
      }
      finally {}
    }
    
    public void removeValue(String paramString)
    {
      ObjectUtil.checkNotNull(paramString, "name");
      try
      {
        Object localObject = this.values;
        if (localObject == null) {
          return;
        }
        localObject = ((Map)localObject).remove(paramString);
        notifyUnbound(localObject, paramString);
        return;
      }
      finally {}
    }
    
    public void tryExpandApplicationBufferSize(int paramInt)
    {
      if ((paramInt > ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH) && (this.applicationBufferSize != ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE)) {
        this.applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE;
      }
    }
  }
  
  private static enum HandshakeState
  {
    static
    {
      HandshakeState localHandshakeState1 = new HandshakeState("NOT_STARTED", 0);
      NOT_STARTED = localHandshakeState1;
      HandshakeState localHandshakeState2 = new HandshakeState("STARTED_IMPLICITLY", 1);
      STARTED_IMPLICITLY = localHandshakeState2;
      HandshakeState localHandshakeState3 = new HandshakeState("STARTED_EXPLICITLY", 2);
      STARTED_EXPLICITLY = localHandshakeState3;
      HandshakeState localHandshakeState4 = new HandshakeState("FINISHED", 3);
      FINISHED = localHandshakeState4;
      $VALUES = new HandshakeState[] { localHandshakeState1, localHandshakeState2, localHandshakeState3, localHandshakeState4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\ReferenceCountedOpenSslEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */