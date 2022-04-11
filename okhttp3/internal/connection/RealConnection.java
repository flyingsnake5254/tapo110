package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Connection.Builder;
import okhttp3.internal.http2.Http2Connection.Listener;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket.Streams;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class RealConnection
  extends Http2Connection.Listener
  implements Connection
{
  private static final int MAX_TUNNEL_ATTEMPTS = 21;
  private static final String NPE_THROW_WITH_NULL = "throw with null exception";
  public int allocationLimit = 1;
  public final List<Reference<StreamAllocation>> allocations = new ArrayList();
  private final ConnectionPool connectionPool;
  private Handshake handshake;
  private Http2Connection http2Connection;
  public long idleAtNanos = Long.MAX_VALUE;
  public boolean noNewStreams;
  private Protocol protocol;
  private Socket rawSocket;
  private final Route route;
  private BufferedSink sink;
  private Socket socket;
  private BufferedSource source;
  public int successCount;
  
  public RealConnection(ConnectionPool paramConnectionPool, Route paramRoute)
  {
    this.connectionPool = paramConnectionPool;
    this.route = paramRoute;
  }
  
  private void connectSocket(int paramInt1, int paramInt2, Call paramCall, EventListener paramEventListener)
    throws IOException
  {
    Proxy localProxy = this.route.proxy();
    Object localObject = this.route.address();
    if ((localProxy.type() != Proxy.Type.DIRECT) && (localProxy.type() != Proxy.Type.HTTP)) {
      localObject = new Socket(localProxy);
    } else {
      localObject = ((Address)localObject).socketFactory().createSocket();
    }
    this.rawSocket = ((Socket)localObject);
    paramEventListener.connectStart(paramCall, this.route.socketAddress(), localProxy);
    this.rawSocket.setSoTimeout(paramInt2);
    try
    {
      Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), paramInt1);
      try
      {
        this.source = Okio.buffer(Okio.source(this.rawSocket));
        this.sink = Okio.buffer(Okio.sink(this.rawSocket));
      }
      catch (NullPointerException paramCall)
      {
        if ("throw with null exception".equals(paramCall.getMessage())) {
          break label159;
        }
      }
      return;
    }
    catch (ConnectException paramCall)
    {
      label159:
      paramEventListener = new StringBuilder();
      paramEventListener.append("Failed to connect to ");
      paramEventListener.append(this.route.socketAddress());
      paramEventListener = new ConnectException(paramEventListener.toString());
      paramEventListener.initCause(paramCall);
      throw paramEventListener;
    }
    throw new IOException(paramCall);
  }
  
  /* Error */
  private void connectTls(ConnectionSpecSelector paramConnectionSpecSelector)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   4: invokevirtual 80	okhttp3/Route:address	()Lokhttp3/Address;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 200	okhttp3/Address:sslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   12: astore_3
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 6
    //   22: aload_3
    //   23: aload_0
    //   24: getfield 114	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   27: aload_2
    //   28: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   31: invokevirtual 209	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   34: aload_2
    //   35: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   38: invokevirtual 213	okhttp3/HttpUrl:port	()I
    //   41: iconst_1
    //   42: invokevirtual 218	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   45: checkcast 220	javax/net/ssl/SSLSocket
    //   48: astore_3
    //   49: aload_1
    //   50: aload_3
    //   51: invokevirtual 226	okhttp3/internal/connection/ConnectionSpecSelector:configureSecureSocket	(Ljavax/net/ssl/SSLSocket;)Lokhttp3/ConnectionSpec;
    //   54: astore 5
    //   56: aload 5
    //   58: invokevirtual 232	okhttp3/ConnectionSpec:supportsTlsExtensions	()Z
    //   61: ifeq +21 -> 82
    //   64: invokestatic 134	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   67: aload_3
    //   68: aload_2
    //   69: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   72: invokevirtual 209	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   75: aload_2
    //   76: invokevirtual 236	okhttp3/Address:protocols	()Ljava/util/List;
    //   79: invokevirtual 240	okhttp3/internal/platform/Platform:configureTlsExtensions	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   82: aload_3
    //   83: invokevirtual 243	javax/net/ssl/SSLSocket:startHandshake	()V
    //   86: aload_3
    //   87: invokevirtual 247	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   90: astore_1
    //   91: aload_1
    //   92: invokestatic 252	okhttp3/Handshake:get	(Ljavax/net/ssl/SSLSession;)Lokhttp3/Handshake;
    //   95: astore 4
    //   97: aload_2
    //   98: invokevirtual 256	okhttp3/Address:hostnameVerifier	()Ljavax/net/ssl/HostnameVerifier;
    //   101: aload_2
    //   102: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   105: invokevirtual 209	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   108: aload_1
    //   109: invokeinterface 262 3 0
    //   114: ifne +191 -> 305
    //   117: aload 4
    //   119: invokevirtual 265	okhttp3/Handshake:peerCertificates	()Ljava/util/List;
    //   122: astore_1
    //   123: aload_1
    //   124: invokeinterface 270 1 0
    //   129: istore 7
    //   131: iload 7
    //   133: ifne +119 -> 252
    //   136: aload_1
    //   137: iconst_0
    //   138: invokeinterface 273 2 0
    //   143: checkcast 275	java/security/cert/X509Certificate
    //   146: astore 4
    //   148: new 277	javax/net/ssl/SSLPeerUnverifiedException
    //   151: astore 6
    //   153: new 171	java/lang/StringBuilder
    //   156: astore_1
    //   157: aload_1
    //   158: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   161: aload_1
    //   162: ldc_w 279
    //   165: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: aload_2
    //   171: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   174: invokevirtual 209	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   177: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_1
    //   182: ldc_w 281
    //   185: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_1
    //   190: aload 4
    //   192: invokestatic 287	okhttp3/CertificatePinner:pin	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   195: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_1
    //   200: ldc_w 289
    //   203: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_1
    //   208: aload 4
    //   210: invokevirtual 293	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   213: invokeinterface 298 1 0
    //   218: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_1
    //   223: ldc_w 300
    //   226: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_1
    //   231: aload 4
    //   233: invokestatic 306	okhttp3/internal/tls/OkHostnameVerifier:allSubjectAltNames	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   236: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 6
    //   242: aload_1
    //   243: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokespecial 307	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   249: aload 6
    //   251: athrow
    //   252: new 277	javax/net/ssl/SSLPeerUnverifiedException
    //   255: astore 4
    //   257: new 171	java/lang/StringBuilder
    //   260: astore_1
    //   261: aload_1
    //   262: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   265: aload_1
    //   266: ldc_w 279
    //   269: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload_1
    //   274: aload_2
    //   275: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   278: invokevirtual 209	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   281: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_1
    //   286: ldc_w 309
    //   289: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 4
    //   295: aload_1
    //   296: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokespecial 307	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   302: aload 4
    //   304: athrow
    //   305: aload_2
    //   306: invokevirtual 313	okhttp3/Address:certificatePinner	()Lokhttp3/CertificatePinner;
    //   309: aload_2
    //   310: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   313: invokevirtual 209	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   316: aload 4
    //   318: invokevirtual 265	okhttp3/Handshake:peerCertificates	()Ljava/util/List;
    //   321: invokevirtual 317	okhttp3/CertificatePinner:check	(Ljava/lang/String;Ljava/util/List;)V
    //   324: aload 6
    //   326: astore_1
    //   327: aload 5
    //   329: invokevirtual 232	okhttp3/ConnectionSpec:supportsTlsExtensions	()Z
    //   332: ifeq +11 -> 343
    //   335: invokestatic 134	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   338: aload_3
    //   339: invokevirtual 321	okhttp3/internal/platform/Platform:getSelectedProtocol	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   342: astore_1
    //   343: aload_0
    //   344: aload_3
    //   345: putfield 323	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   348: aload_0
    //   349: aload_3
    //   350: invokestatic 142	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
    //   353: invokestatic 146	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   356: putfield 148	okhttp3/internal/connection/RealConnection:source	Lokio/BufferedSource;
    //   359: aload_0
    //   360: aload_0
    //   361: getfield 323	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   364: invokestatic 151	okio/Okio:sink	(Ljava/net/Socket;)Lokio/Sink;
    //   367: invokestatic 154	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   370: putfield 156	okhttp3/internal/connection/RealConnection:sink	Lokio/BufferedSink;
    //   373: aload_0
    //   374: aload 4
    //   376: putfield 325	okhttp3/internal/connection/RealConnection:handshake	Lokhttp3/Handshake;
    //   379: aload_1
    //   380: ifnull +11 -> 391
    //   383: aload_1
    //   384: invokestatic 330	okhttp3/Protocol:get	(Ljava/lang/String;)Lokhttp3/Protocol;
    //   387: astore_1
    //   388: goto +7 -> 395
    //   391: getstatic 333	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
    //   394: astore_1
    //   395: aload_0
    //   396: aload_1
    //   397: putfield 335	okhttp3/internal/connection/RealConnection:protocol	Lokhttp3/Protocol;
    //   400: invokestatic 134	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   403: aload_3
    //   404: invokevirtual 339	okhttp3/internal/platform/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   407: return
    //   408: astore_1
    //   409: aload_3
    //   410: astore 4
    //   412: goto +59 -> 471
    //   415: astore 4
    //   417: aload_3
    //   418: astore_1
    //   419: aload 4
    //   421: astore_3
    //   422: goto +11 -> 433
    //   425: astore_1
    //   426: goto +45 -> 471
    //   429: astore_3
    //   430: aload 5
    //   432: astore_1
    //   433: aload_1
    //   434: astore 4
    //   436: aload_3
    //   437: invokestatic 345	okhttp3/internal/Util:isAndroidGetsocknameError	(Ljava/lang/AssertionError;)Z
    //   440: ifeq +26 -> 466
    //   443: aload_1
    //   444: astore 4
    //   446: new 66	java/io/IOException
    //   449: astore 6
    //   451: aload_1
    //   452: astore 4
    //   454: aload 6
    //   456: aload_3
    //   457: invokespecial 169	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   460: aload_1
    //   461: astore 4
    //   463: aload 6
    //   465: athrow
    //   466: aload_1
    //   467: astore 4
    //   469: aload_3
    //   470: athrow
    //   471: aload 4
    //   473: ifnull +11 -> 484
    //   476: invokestatic 134	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   479: aload 4
    //   481: invokevirtual 339	okhttp3/internal/platform/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   484: aload 4
    //   486: invokestatic 349	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   489: aload_1
    //   490: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	this	RealConnection
    //   0	491	1	paramConnectionSpecSelector	ConnectionSpecSelector
    //   7	303	2	localAddress	Address
    //   12	410	3	localObject1	Object
    //   429	41	3	localAssertionError1	AssertionError
    //   14	397	4	localObject2	Object
    //   415	5	4	localAssertionError2	AssertionError
    //   434	51	4	localConnectionSpecSelector	ConnectionSpecSelector
    //   17	414	5	localConnectionSpec	okhttp3.ConnectionSpec
    //   20	444	6	localObject3	Object
    //   129	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   49	82	408	finally
    //   82	131	408	finally
    //   136	252	408	finally
    //   252	305	408	finally
    //   305	324	408	finally
    //   327	343	408	finally
    //   343	379	408	finally
    //   383	388	408	finally
    //   391	395	408	finally
    //   395	400	408	finally
    //   49	82	415	java/lang/AssertionError
    //   82	131	415	java/lang/AssertionError
    //   136	252	415	java/lang/AssertionError
    //   252	305	415	java/lang/AssertionError
    //   305	324	415	java/lang/AssertionError
    //   327	343	415	java/lang/AssertionError
    //   343	379	415	java/lang/AssertionError
    //   383	388	415	java/lang/AssertionError
    //   391	395	415	java/lang/AssertionError
    //   395	400	415	java/lang/AssertionError
    //   22	49	425	finally
    //   436	443	425	finally
    //   446	451	425	finally
    //   454	460	425	finally
    //   463	466	425	finally
    //   469	471	425	finally
    //   22	49	429	java/lang/AssertionError
  }
  
  private void connectTunnel(int paramInt1, int paramInt2, int paramInt3, Call paramCall, EventListener paramEventListener)
    throws IOException
  {
    Request localRequest = createTunnelRequest();
    HttpUrl localHttpUrl = localRequest.url();
    for (int i = 0; i < 21; i++)
    {
      connectSocket(paramInt1, paramInt2, paramCall, paramEventListener);
      localRequest = createTunnel(paramInt2, paramInt3, localRequest, localHttpUrl);
      if (localRequest == null) {
        break;
      }
      Util.closeQuietly(this.rawSocket);
      this.rawSocket = null;
      this.sink = null;
      this.source = null;
      paramEventListener.connectEnd(paramCall, this.route.socketAddress(), this.route.proxy(), null);
    }
  }
  
  private Request createTunnel(int paramInt1, int paramInt2, Request paramRequest, HttpUrl paramHttpUrl)
    throws IOException
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("CONNECT ");
    ((StringBuilder)localObject1).append(Util.hostHeader(paramHttpUrl, true));
    ((StringBuilder)localObject1).append(" HTTP/1.1");
    paramHttpUrl = ((StringBuilder)localObject1).toString();
    Object localObject2;
    for (;;)
    {
      Http1Codec localHttp1Codec = new Http1Codec(null, null, this.source, this.sink);
      localObject2 = this.source.timeout();
      long l1 = paramInt1;
      localObject1 = TimeUnit.MILLISECONDS;
      ((Timeout)localObject2).timeout(l1, (TimeUnit)localObject1);
      this.sink.timeout().timeout(paramInt2, (TimeUnit)localObject1);
      localHttp1Codec.writeRequest(paramRequest.headers(), paramHttpUrl);
      localHttp1Codec.finishRequest();
      localObject2 = localHttp1Codec.readResponseHeaders(false).request(paramRequest).build();
      long l2 = HttpHeaders.contentLength((Response)localObject2);
      l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      paramRequest = localHttp1Codec.newFixedLengthSource(l1);
      Util.skipAll(paramRequest, Integer.MAX_VALUE, (TimeUnit)localObject1);
      paramRequest.close();
      int i = ((Response)localObject2).code();
      if (i == 200) {
        break label310;
      }
      if (i != 407) {
        break label272;
      }
      paramRequest = this.route.address().proxyAuthenticator().authenticate(this.route, (Response)localObject2);
      if (paramRequest == null) {
        break;
      }
      if ("close".equalsIgnoreCase(((Response)localObject2).header("Connection"))) {
        return paramRequest;
      }
    }
    throw new IOException("Failed to authenticate with proxy");
    label272:
    paramRequest = new StringBuilder();
    paramRequest.append("Unexpected response code for CONNECT: ");
    paramRequest.append(((Response)localObject2).code());
    throw new IOException(paramRequest.toString());
    label310:
    if ((this.source.buffer().exhausted()) && (this.sink.buffer().exhausted())) {
      return null;
    }
    throw new IOException("TLS tunnel buffered too many bytes!");
  }
  
  private Request createTunnelRequest()
    throws IOException
  {
    Object localObject1 = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
    Object localObject2 = new Response.Builder().request((Request)localObject1).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build();
    localObject2 = this.route.address().proxyAuthenticator().authenticate(this.route, (Response)localObject2);
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    return (Request)localObject1;
  }
  
  private void establishProtocol(ConnectionSpecSelector paramConnectionSpecSelector, int paramInt, Call paramCall, EventListener paramEventListener)
    throws IOException
  {
    if (this.route.address().sslSocketFactory() == null)
    {
      paramConnectionSpecSelector = this.route.address().protocols();
      paramCall = Protocol.H2_PRIOR_KNOWLEDGE;
      if (paramConnectionSpecSelector.contains(paramCall))
      {
        this.socket = this.rawSocket;
        this.protocol = paramCall;
        startHttp2(paramInt);
        return;
      }
      this.socket = this.rawSocket;
      this.protocol = Protocol.HTTP_1_1;
      return;
    }
    paramEventListener.secureConnectStart(paramCall);
    connectTls(paramConnectionSpecSelector);
    paramEventListener.secureConnectEnd(paramCall, this.handshake);
    if (this.protocol == Protocol.HTTP_2) {
      startHttp2(paramInt);
    }
  }
  
  private void startHttp2(int paramInt)
    throws IOException
  {
    this.socket.setSoTimeout(0);
    Http2Connection localHttp2Connection = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(paramInt).build();
    this.http2Connection = localHttp2Connection;
    localHttp2Connection.start();
  }
  
  public static RealConnection testConnection(ConnectionPool paramConnectionPool, Route paramRoute, Socket paramSocket, long paramLong)
  {
    paramConnectionPool = new RealConnection(paramConnectionPool, paramRoute);
    paramConnectionPool.socket = paramSocket;
    paramConnectionPool.idleAtNanos = paramLong;
    return paramConnectionPool;
  }
  
  public void cancel()
  {
    Util.closeQuietly(this.rawSocket);
  }
  
  /* Error */
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Call paramCall, EventListener arg7)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 335	okhttp3/internal/connection/RealConnection:protocol	Lokhttp3/Protocol;
    //   4: ifnonnull +493 -> 497
    //   7: aload_0
    //   8: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   11: invokevirtual 80	okhttp3/Route:address	()Lokhttp3/Address;
    //   14: invokevirtual 620	okhttp3/Address:connectionSpecs	()Ljava/util/List;
    //   17: astore 8
    //   19: new 222	okhttp3/internal/connection/ConnectionSpecSelector
    //   22: dup
    //   23: aload 8
    //   25: invokespecial 623	okhttp3/internal/connection/ConnectionSpecSelector:<init>	(Ljava/util/List;)V
    //   28: astore 9
    //   30: aload_0
    //   31: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   34: invokevirtual 80	okhttp3/Route:address	()Lokhttp3/Address;
    //   37: invokevirtual 200	okhttp3/Address:sslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   40: ifnonnull +118 -> 158
    //   43: aload 8
    //   45: getstatic 627	okhttp3/ConnectionSpec:CLEARTEXT	Lokhttp3/ConnectionSpec;
    //   48: invokeinterface 568 2 0
    //   53: ifeq +87 -> 140
    //   56: aload_0
    //   57: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   60: invokevirtual 80	okhttp3/Route:address	()Lokhttp3/Address;
    //   63: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   66: invokevirtual 209	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   69: astore 8
    //   71: invokestatic 134	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   74: aload 8
    //   76: invokevirtual 630	okhttp3/internal/platform/Platform:isCleartextTrafficPermitted	(Ljava/lang/String;)Z
    //   79: ifeq +6 -> 85
    //   82: goto +97 -> 179
    //   85: new 171	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   92: astore 6
    //   94: aload 6
    //   96: ldc_w 632
    //   99: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 6
    //   105: aload 8
    //   107: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 6
    //   113: ldc_w 634
    //   116: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: new 636	okhttp3/internal/connection/RouteException
    //   123: dup
    //   124: new 638	java/net/UnknownServiceException
    //   127: dup
    //   128: aload 6
    //   130: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokespecial 639	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   136: invokespecial 642	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   139: athrow
    //   140: new 636	okhttp3/internal/connection/RouteException
    //   143: dup
    //   144: new 638	java/net/UnknownServiceException
    //   147: dup
    //   148: ldc_w 644
    //   151: invokespecial 639	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   154: invokespecial 642	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   157: athrow
    //   158: aload_0
    //   159: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   162: invokevirtual 80	okhttp3/Route:address	()Lokhttp3/Address;
    //   165: invokevirtual 236	okhttp3/Address:protocols	()Ljava/util/List;
    //   168: getstatic 565	okhttp3/Protocol:H2_PRIOR_KNOWLEDGE	Lokhttp3/Protocol;
    //   171: invokeinterface 568 2 0
    //   176: ifne +303 -> 479
    //   179: aconst_null
    //   180: astore 10
    //   182: aload_0
    //   183: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   186: invokevirtual 647	okhttp3/Route:requiresTunnel	()Z
    //   189: ifeq +31 -> 220
    //   192: aload_0
    //   193: iload_1
    //   194: iload_2
    //   195: iload_3
    //   196: aload 6
    //   198: aload 7
    //   200: invokespecial 649	okhttp3/internal/connection/RealConnection:connectTunnel	(IIILokhttp3/Call;Lokhttp3/EventListener;)V
    //   203: aload_0
    //   204: getfield 114	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   207: astore 8
    //   209: aload 8
    //   211: ifnonnull +6 -> 217
    //   214: goto +53 -> 267
    //   217: goto +13 -> 230
    //   220: aload_0
    //   221: iload_1
    //   222: iload_2
    //   223: aload 6
    //   225: aload 7
    //   227: invokespecial 360	okhttp3/internal/connection/RealConnection:connectSocket	(IILokhttp3/Call;Lokhttp3/EventListener;)V
    //   230: aload_0
    //   231: aload 9
    //   233: iload 4
    //   235: aload 6
    //   237: aload 7
    //   239: invokespecial 651	okhttp3/internal/connection/RealConnection:establishProtocol	(Lokhttp3/internal/connection/ConnectionSpecSelector;ILokhttp3/Call;Lokhttp3/EventListener;)V
    //   242: aload 7
    //   244: aload 6
    //   246: aload_0
    //   247: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   250: invokevirtual 118	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   253: aload_0
    //   254: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   257: invokevirtual 76	okhttp3/Route:proxy	()Ljava/net/Proxy;
    //   260: aload_0
    //   261: getfield 335	okhttp3/internal/connection/RealConnection:protocol	Lokhttp3/Protocol;
    //   264: invokevirtual 368	okhttp3/EventListener:connectEnd	(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;)V
    //   267: aload_0
    //   268: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   271: invokevirtual 647	okhttp3/Route:requiresTunnel	()Z
    //   274: ifeq +31 -> 305
    //   277: aload_0
    //   278: getfield 114	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   281: ifnull +6 -> 287
    //   284: goto +21 -> 305
    //   287: new 636	okhttp3/internal/connection/RouteException
    //   290: dup
    //   291: new 653	java/net/ProtocolException
    //   294: dup
    //   295: ldc_w 655
    //   298: invokespecial 656	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   301: invokespecial 642	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   304: athrow
    //   305: aload_0
    //   306: getfield 605	okhttp3/internal/connection/RealConnection:http2Connection	Lokhttp3/internal/http2/Http2Connection;
    //   309: ifnull +37 -> 346
    //   312: aload_0
    //   313: getfield 59	okhttp3/internal/connection/RealConnection:connectionPool	Lokhttp3/ConnectionPool;
    //   316: astore 7
    //   318: aload 7
    //   320: monitorenter
    //   321: aload_0
    //   322: aload_0
    //   323: getfield 605	okhttp3/internal/connection/RealConnection:http2Connection	Lokhttp3/internal/http2/Http2Connection;
    //   326: invokevirtual 659	okhttp3/internal/http2/Http2Connection:maxConcurrentStreams	()I
    //   329: putfield 48	okhttp3/internal/connection/RealConnection:allocationLimit	I
    //   332: aload 7
    //   334: monitorexit
    //   335: goto +11 -> 346
    //   338: astore 6
    //   340: aload 7
    //   342: monitorexit
    //   343: aload 6
    //   345: athrow
    //   346: return
    //   347: astore 8
    //   349: goto +10 -> 359
    //   352: astore 8
    //   354: goto +5 -> 359
    //   357: astore 8
    //   359: aload_0
    //   360: getfield 323	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   363: invokestatic 349	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   366: aload_0
    //   367: getfield 114	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   370: invokestatic 349	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   373: aload_0
    //   374: aconst_null
    //   375: putfield 323	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   378: aload_0
    //   379: aconst_null
    //   380: putfield 114	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   383: aload_0
    //   384: aconst_null
    //   385: putfield 148	okhttp3/internal/connection/RealConnection:source	Lokio/BufferedSource;
    //   388: aload_0
    //   389: aconst_null
    //   390: putfield 156	okhttp3/internal/connection/RealConnection:sink	Lokio/BufferedSink;
    //   393: aload_0
    //   394: aconst_null
    //   395: putfield 325	okhttp3/internal/connection/RealConnection:handshake	Lokhttp3/Handshake;
    //   398: aload_0
    //   399: aconst_null
    //   400: putfield 335	okhttp3/internal/connection/RealConnection:protocol	Lokhttp3/Protocol;
    //   403: aload_0
    //   404: aconst_null
    //   405: putfield 605	okhttp3/internal/connection/RealConnection:http2Connection	Lokhttp3/internal/http2/Http2Connection;
    //   408: aload 7
    //   410: aload 6
    //   412: aload_0
    //   413: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   416: invokevirtual 118	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   419: aload_0
    //   420: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   423: invokevirtual 76	okhttp3/Route:proxy	()Ljava/net/Proxy;
    //   426: aconst_null
    //   427: aload 8
    //   429: invokevirtual 663	okhttp3/EventListener:connectFailed	(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;Ljava/io/IOException;)V
    //   432: aload 10
    //   434: ifnonnull +17 -> 451
    //   437: new 636	okhttp3/internal/connection/RouteException
    //   440: dup
    //   441: aload 8
    //   443: invokespecial 642	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   446: astore 10
    //   448: goto +10 -> 458
    //   451: aload 10
    //   453: aload 8
    //   455: invokevirtual 666	okhttp3/internal/connection/RouteException:addConnectException	(Ljava/io/IOException;)V
    //   458: iload 5
    //   460: ifeq +16 -> 476
    //   463: aload 9
    //   465: aload 8
    //   467: invokevirtual 670	okhttp3/internal/connection/ConnectionSpecSelector:connectionFailed	(Ljava/io/IOException;)Z
    //   470: ifeq +6 -> 476
    //   473: goto -291 -> 182
    //   476: aload 10
    //   478: athrow
    //   479: new 636	okhttp3/internal/connection/RouteException
    //   482: dup
    //   483: new 638	java/net/UnknownServiceException
    //   486: dup
    //   487: ldc_w 672
    //   490: invokespecial 639	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   493: invokespecial 642	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   496: athrow
    //   497: new 674	java/lang/IllegalStateException
    //   500: dup
    //   501: ldc_w 676
    //   504: invokespecial 677	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   507: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	508	0	this	RealConnection
    //   0	508	1	paramInt1	int
    //   0	508	2	paramInt2	int
    //   0	508	3	paramInt3	int
    //   0	508	4	paramInt4	int
    //   0	508	5	paramBoolean	boolean
    //   0	508	6	paramCall	Call
    //   17	193	8	localObject	Object
    //   347	1	8	localIOException1	IOException
    //   352	1	8	localIOException2	IOException
    //   357	109	8	localIOException3	IOException
    //   28	436	9	localConnectionSpecSelector	ConnectionSpecSelector
    //   180	297	10	localRouteException	RouteException
    // Exception table:
    //   from	to	target	type
    //   321	335	338	finally
    //   340	343	338	finally
    //   230	267	347	java/io/IOException
    //   220	230	352	java/io/IOException
    //   182	209	357	java/io/IOException
  }
  
  public Handshake handshake()
  {
    return this.handshake;
  }
  
  public boolean isEligible(Address paramAddress, @Nullable Route paramRoute)
  {
    if ((this.allocations.size() < this.allocationLimit) && (!this.noNewStreams))
    {
      if (!Internal.instance.equalsNonHost(this.route.address(), paramAddress)) {
        return false;
      }
      if (paramAddress.url().host().equals(route().address().url().host())) {
        return true;
      }
      if (this.http2Connection == null) {
        return false;
      }
      if (paramRoute == null) {
        return false;
      }
      if (paramRoute.proxy().type() != Proxy.Type.DIRECT) {
        return false;
      }
      if (this.route.proxy().type() != Proxy.Type.DIRECT) {
        return false;
      }
      if (!this.route.socketAddress().equals(paramRoute.socketAddress())) {
        return false;
      }
      if (paramRoute.address().hostnameVerifier() != OkHostnameVerifier.INSTANCE) {
        return false;
      }
      if (!supportsUrl(paramAddress.url())) {
        return false;
      }
    }
    try
    {
      paramAddress.certificatePinner().check(paramAddress.url().host(), handshake().peerCertificates());
      return true;
    }
    catch (SSLPeerUnverifiedException paramAddress)
    {
      for (;;) {}
    }
    return false;
  }
  
  /* Error */
  public boolean isHealthy(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 323	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   4: invokevirtual 720	java/net/Socket:isClosed	()Z
    //   7: ifne +113 -> 120
    //   10: aload_0
    //   11: getfield 323	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   14: invokevirtual 723	java/net/Socket:isInputShutdown	()Z
    //   17: ifne +103 -> 120
    //   20: aload_0
    //   21: getfield 323	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   24: invokevirtual 726	java/net/Socket:isOutputShutdown	()Z
    //   27: ifeq +6 -> 33
    //   30: goto +90 -> 120
    //   33: aload_0
    //   34: getfield 605	okhttp3/internal/connection/RealConnection:http2Connection	Lokhttp3/internal/http2/Http2Connection;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +11 -> 50
    //   42: aload_2
    //   43: invokestatic 732	java/lang/System:nanoTime	()J
    //   46: invokevirtual 735	okhttp3/internal/http2/Http2Connection:isHealthy	(J)Z
    //   49: ireturn
    //   50: iload_1
    //   51: ifeq +67 -> 118
    //   54: aload_0
    //   55: getfield 323	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   58: invokevirtual 738	java/net/Socket:getSoTimeout	()I
    //   61: istore_3
    //   62: aload_0
    //   63: getfield 323	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   66: iconst_1
    //   67: invokevirtual 128	java/net/Socket:setSoTimeout	(I)V
    //   70: aload_0
    //   71: getfield 148	okhttp3/internal/connection/RealConnection:source	Lokio/BufferedSource;
    //   74: invokeinterface 739 1 0
    //   79: istore_1
    //   80: iload_1
    //   81: ifeq +13 -> 94
    //   84: aload_0
    //   85: getfield 323	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   88: iload_3
    //   89: invokevirtual 128	java/net/Socket:setSoTimeout	(I)V
    //   92: iconst_0
    //   93: ireturn
    //   94: aload_0
    //   95: getfield 323	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   98: iload_3
    //   99: invokevirtual 128	java/net/Socket:setSoTimeout	(I)V
    //   102: iconst_1
    //   103: ireturn
    //   104: astore_2
    //   105: aload_0
    //   106: getfield 323	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   109: iload_3
    //   110: invokevirtual 128	java/net/Socket:setSoTimeout	(I)V
    //   113: aload_2
    //   114: athrow
    //   115: astore_2
    //   116: iconst_0
    //   117: ireturn
    //   118: iconst_1
    //   119: ireturn
    //   120: iconst_0
    //   121: ireturn
    //   122: astore_2
    //   123: goto -5 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	RealConnection
    //   0	126	1	paramBoolean	boolean
    //   37	6	2	localHttp2Connection	Http2Connection
    //   104	10	2	localObject	Object
    //   115	1	2	localIOException	IOException
    //   122	1	2	localSocketTimeoutException	java.net.SocketTimeoutException
    //   61	49	3	i	int
    // Exception table:
    //   from	to	target	type
    //   62	80	104	finally
    //   54	62	115	java/io/IOException
    //   84	92	115	java/io/IOException
    //   94	102	115	java/io/IOException
    //   105	115	115	java/io/IOException
    //   54	62	122	java/net/SocketTimeoutException
    //   84	92	122	java/net/SocketTimeoutException
    //   94	102	122	java/net/SocketTimeoutException
    //   105	115	122	java/net/SocketTimeoutException
  }
  
  public boolean isMultiplexed()
  {
    boolean bool;
    if (this.http2Connection != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public HttpCodec newCodec(OkHttpClient paramOkHttpClient, Interceptor.Chain paramChain, StreamAllocation paramStreamAllocation)
    throws SocketException
  {
    if (this.http2Connection != null) {
      return new Http2Codec(paramOkHttpClient, paramChain, paramStreamAllocation, this.http2Connection);
    }
    this.socket.setSoTimeout(paramChain.readTimeoutMillis());
    Timeout localTimeout = this.source.timeout();
    long l = paramChain.readTimeoutMillis();
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    localTimeout.timeout(l, localTimeUnit);
    this.sink.timeout().timeout(paramChain.writeTimeoutMillis(), localTimeUnit);
    return new Http1Codec(paramOkHttpClient, paramStreamAllocation, this.source, this.sink);
  }
  
  public RealWebSocket.Streams newWebSocketStreams(final StreamAllocation paramStreamAllocation)
  {
    new RealWebSocket.Streams(true, this.source, this.sink)
    {
      public void close()
        throws IOException
      {
        StreamAllocation localStreamAllocation = paramStreamAllocation;
        localStreamAllocation.streamFinished(true, localStreamAllocation.codec(), -1L, null);
      }
    };
  }
  
  public void onSettings(Http2Connection paramHttp2Connection)
  {
    synchronized (this.connectionPool)
    {
      this.allocationLimit = paramHttp2Connection.maxConcurrentStreams();
      return;
    }
  }
  
  public void onStream(Http2Stream paramHttp2Stream)
    throws IOException
  {
    paramHttp2Stream.close(ErrorCode.REFUSED_STREAM);
  }
  
  public Protocol protocol()
  {
    return this.protocol;
  }
  
  public Route route()
  {
    return this.route;
  }
  
  public Socket socket()
  {
    return this.socket;
  }
  
  public boolean supportsUrl(HttpUrl paramHttpUrl)
  {
    int i = paramHttpUrl.port();
    int j = this.route.address().url().port();
    boolean bool1 = false;
    if (i != j) {
      return false;
    }
    if (!paramHttpUrl.host().equals(this.route.address().url().host()))
    {
      boolean bool2 = bool1;
      if (this.handshake != null)
      {
        bool2 = bool1;
        if (OkHostnameVerifier.INSTANCE.verify(paramHttpUrl.host(), (X509Certificate)this.handshake.peerCertificates().get(0))) {
          bool2 = true;
        }
      }
      return bool2;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Connection{");
    localStringBuilder.append(this.route.address().url().host());
    localStringBuilder.append(":");
    localStringBuilder.append(this.route.address().url().port());
    localStringBuilder.append(", proxy=");
    localStringBuilder.append(this.route.proxy());
    localStringBuilder.append(" hostAddress=");
    localStringBuilder.append(this.route.socketAddress());
    localStringBuilder.append(" cipherSuite=");
    Object localObject = this.handshake;
    if (localObject != null) {
      localObject = ((Handshake)localObject).cipherSuite();
    } else {
      localObject = "none";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(" protocol=");
    localStringBuilder.append(this.protocol);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\connection\RealConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */