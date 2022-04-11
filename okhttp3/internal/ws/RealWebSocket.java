package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Timeout;

public final class RealWebSocket
  implements WebSocket, WebSocketReader.FrameCallback
{
  private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000L;
  private static final long MAX_QUEUE_SIZE = 16777216L;
  private static final List<Protocol> ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
  private boolean awaitingPong;
  private Call call;
  private ScheduledFuture<?> cancelFuture;
  private boolean enqueuedClose;
  private ScheduledExecutorService executor;
  private boolean failed;
  private final String key;
  final WebSocketListener listener;
  private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque();
  private final Request originalRequest;
  private final long pingIntervalMillis;
  private final ArrayDeque<ByteString> pongQueue = new ArrayDeque();
  private long queueSize;
  private final Random random;
  private WebSocketReader reader;
  private int receivedCloseCode = -1;
  private String receivedCloseReason;
  private int receivedPingCount;
  private int receivedPongCount;
  private int sentPingCount;
  private Streams streams;
  private WebSocketWriter writer;
  private final Runnable writerRunnable;
  
  public RealWebSocket(Request paramRequest, WebSocketListener paramWebSocketListener, Random paramRandom, long paramLong)
  {
    if ("GET".equals(paramRequest.method()))
    {
      this.originalRequest = paramRequest;
      this.listener = paramWebSocketListener;
      this.random = paramRandom;
      this.pingIntervalMillis = paramLong;
      paramRequest = new byte[16];
      paramRandom.nextBytes(paramRequest);
      this.key = ByteString.of(paramRequest).base64();
      this.writerRunnable = new Runnable()
      {
        public void run()
        {
          try
          {
            boolean bool;
            do
            {
              bool = RealWebSocket.this.writeOneFrame();
            } while (bool);
            return;
          }
          catch (IOException localIOException)
          {
            RealWebSocket.this.failWebSocket(localIOException, null);
          }
        }
      };
      return;
    }
    paramWebSocketListener = new StringBuilder();
    paramWebSocketListener.append("Request must be GET: ");
    paramWebSocketListener.append(paramRequest.method());
    throw new IllegalArgumentException(paramWebSocketListener.toString());
  }
  
  private void runWriter()
  {
    ScheduledExecutorService localScheduledExecutorService = this.executor;
    if (localScheduledExecutorService != null) {
      localScheduledExecutorService.execute(this.writerRunnable);
    }
  }
  
  private boolean send(ByteString paramByteString, int paramInt)
  {
    try
    {
      if ((!this.failed) && (!this.enqueuedClose))
      {
        if (this.queueSize + paramByteString.size() > 16777216L)
        {
          close(1001, null);
          return false;
        }
        this.queueSize += paramByteString.size();
        ArrayDeque localArrayDeque = this.messageAndCloseQueue;
        Message localMessage = new okhttp3/internal/ws/RealWebSocket$Message;
        localMessage.<init>(paramInt, paramByteString);
        localArrayDeque.add(localMessage);
        runWriter();
        return true;
      }
      return false;
    }
    finally {}
  }
  
  void awaitTermination(int paramInt, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    this.executor.awaitTermination(paramInt, paramTimeUnit);
  }
  
  public void cancel()
  {
    this.call.cancel();
  }
  
  void checkResponse(Response paramResponse)
    throws ProtocolException
  {
    if (paramResponse.code() == 101)
    {
      localObject = paramResponse.header("Connection");
      if ("Upgrade".equalsIgnoreCase((String)localObject))
      {
        localObject = paramResponse.header("Upgrade");
        if ("websocket".equalsIgnoreCase((String)localObject))
        {
          paramResponse = paramResponse.header("Sec-WebSocket-Accept");
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.key);
          ((StringBuilder)localObject).append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
          String str = ByteString.encodeUtf8(((StringBuilder)localObject).toString()).sha1().base64();
          if (str.equals(paramResponse)) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Expected 'Sec-WebSocket-Accept' header value '");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append("' but was '");
          ((StringBuilder)localObject).append(paramResponse);
          ((StringBuilder)localObject).append("'");
          throw new ProtocolException(((StringBuilder)localObject).toString());
        }
        paramResponse = new StringBuilder();
        paramResponse.append("Expected 'Upgrade' header value 'websocket' but was '");
        paramResponse.append((String)localObject);
        paramResponse.append("'");
        throw new ProtocolException(paramResponse.toString());
      }
      paramResponse = new StringBuilder();
      paramResponse.append("Expected 'Connection' header value 'Upgrade' but was '");
      paramResponse.append((String)localObject);
      paramResponse.append("'");
      throw new ProtocolException(paramResponse.toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected HTTP 101 response but was '");
    ((StringBuilder)localObject).append(paramResponse.code());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramResponse.message());
    ((StringBuilder)localObject).append("'");
    throw new ProtocolException(((StringBuilder)localObject).toString());
  }
  
  public boolean close(int paramInt, String paramString)
  {
    return close(paramInt, paramString, 60000L);
  }
  
  boolean close(int paramInt, String paramString, long paramLong)
  {
    try
    {
      WebSocketProtocol.validateCloseCode(paramInt);
      Object localObject1 = null;
      Object localObject2;
      if (paramString != null)
      {
        localObject1 = ByteString.encodeUtf8(paramString);
        if (((ByteString)localObject1).size() > 123L)
        {
          localObject2 = new java/lang/IllegalArgumentException;
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          ((StringBuilder)localObject1).append("reason.size() > 123: ");
          ((StringBuilder)localObject1).append(paramString);
          ((IllegalArgumentException)localObject2).<init>(((StringBuilder)localObject1).toString());
          throw ((Throwable)localObject2);
        }
      }
      if ((!this.failed) && (!this.enqueuedClose))
      {
        this.enqueuedClose = true;
        localObject2 = this.messageAndCloseQueue;
        paramString = new okhttp3/internal/ws/RealWebSocket$Close;
        paramString.<init>(paramInt, (ByteString)localObject1, paramLong);
        ((ArrayDeque)localObject2).add(paramString);
        runWriter();
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public void connect(final OkHttpClient paramOkHttpClient)
  {
    Object localObject = paramOkHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
    paramOkHttpClient = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
    localObject = Internal.instance.newWebSocketCall((OkHttpClient)localObject, paramOkHttpClient);
    this.call = ((Call)localObject);
    ((Call)localObject).timeout().clearTimeout();
    this.call.enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        RealWebSocket.this.failWebSocket(paramAnonymousIOException, null);
      }
      
      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
      {
        try
        {
          RealWebSocket.this.checkResponse(paramAnonymousResponse);
          StreamAllocation localStreamAllocation = Internal.instance.streamAllocation(paramAnonymousCall);
          localStreamAllocation.noNewStreams();
          paramAnonymousCall = localStreamAllocation.connection().newWebSocketStreams(localStreamAllocation);
          try
          {
            RealWebSocket localRealWebSocket = RealWebSocket.this;
            localRealWebSocket.listener.onOpen(localRealWebSocket, paramAnonymousResponse);
            paramAnonymousResponse = new java/lang/StringBuilder;
            paramAnonymousResponse.<init>();
            paramAnonymousResponse.append("OkHttp WebSocket ");
            paramAnonymousResponse.append(paramOkHttpClient.url().redact());
            paramAnonymousResponse = paramAnonymousResponse.toString();
            RealWebSocket.this.initReaderAndWriter(paramAnonymousResponse, paramAnonymousCall);
            localStreamAllocation.connection().socket().setSoTimeout(0);
            RealWebSocket.this.loopReader();
          }
          catch (Exception paramAnonymousCall)
          {
            RealWebSocket.this.failWebSocket(paramAnonymousCall, null);
          }
          return;
        }
        catch (ProtocolException paramAnonymousCall)
        {
          RealWebSocket.this.failWebSocket(paramAnonymousCall, paramAnonymousResponse);
          Util.closeQuietly(paramAnonymousResponse);
        }
      }
    });
  }
  
  /* Error */
  public void failWebSocket(Exception paramException, @javax.annotation.Nullable Response paramResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 183	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 183	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   17: aload_0
    //   18: getfield 366	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   21: astore_3
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 366	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   27: aload_0
    //   28: getfield 368	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnull +12 -> 47
    //   38: aload 4
    //   40: iconst_0
    //   41: invokeinterface 373 2 0
    //   46: pop
    //   47: aload_0
    //   48: getfield 173	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   51: astore 4
    //   53: aload 4
    //   55: ifnull +10 -> 65
    //   58: aload 4
    //   60: invokeinterface 376 1 0
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_0
    //   68: getfield 127	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
    //   71: aload_0
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 382	okhttp3/WebSocketListener:onFailure	(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V
    //   77: aload_3
    //   78: invokestatic 388	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   81: return
    //   82: astore_1
    //   83: aload_3
    //   84: invokestatic 388	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   87: aload_1
    //   88: athrow
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	RealWebSocket
    //   0	94	1	paramException	Exception
    //   0	94	2	paramResponse	Response
    //   21	63	3	localStreams	Streams
    //   31	28	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   67	77	82	finally
    //   2	11	89	finally
    //   12	33	89	finally
    //   38	47	89	finally
    //   47	53	89	finally
    //   58	65	89	finally
    //   65	67	89	finally
    //   90	92	89	finally
  }
  
  public void initReaderAndWriter(String paramString, Streams paramStreams)
    throws IOException
  {
    try
    {
      this.streams = paramStreams;
      Object localObject = new okhttp3/internal/ws/WebSocketWriter;
      ((WebSocketWriter)localObject).<init>(paramStreams.client, paramStreams.sink, this.random);
      this.writer = ((WebSocketWriter)localObject);
      localObject = new java/util/concurrent/ScheduledThreadPoolExecutor;
      ((ScheduledThreadPoolExecutor)localObject).<init>(1, Util.threadFactory(paramString, false));
      this.executor = ((ScheduledExecutorService)localObject);
      if (this.pingIntervalMillis != 0L)
      {
        paramString = new okhttp3/internal/ws/RealWebSocket$PingRunnable;
        paramString.<init>(this);
        long l = this.pingIntervalMillis;
        ((ScheduledExecutorService)localObject).scheduleAtFixedRate(paramString, l, l, TimeUnit.MILLISECONDS);
      }
      if (!this.messageAndCloseQueue.isEmpty()) {
        runWriter();
      }
      this.reader = new WebSocketReader(paramStreams.client, paramStreams.source, this);
      return;
    }
    finally {}
  }
  
  public void loopReader()
    throws IOException
  {
    while (this.receivedCloseCode == -1) {
      this.reader.processNextFrame();
    }
  }
  
  public void onReadClose(int paramInt, String paramString)
  {
    if (paramInt != -1) {
      try
      {
        if (this.receivedCloseCode == -1)
        {
          this.receivedCloseCode = paramInt;
          this.receivedCloseReason = paramString;
          boolean bool = this.enqueuedClose;
          ScheduledFuture localScheduledFuture = null;
          Object localObject = localScheduledFuture;
          if (bool)
          {
            localObject = localScheduledFuture;
            if (this.messageAndCloseQueue.isEmpty())
            {
              localObject = this.streams;
              this.streams = null;
              localScheduledFuture = this.cancelFuture;
              if (localScheduledFuture != null) {
                localScheduledFuture.cancel(false);
              }
              this.executor.shutdown();
            }
          }
          try
          {
            this.listener.onClosing(this, paramInt, paramString);
            if (localObject != null) {
              this.listener.onClosed(this, paramInt, paramString);
            }
            return;
          }
          finally
          {
            Util.closeQuietly((Closeable)localObject);
          }
        }
        paramString = new java/lang/IllegalStateException;
        paramString.<init>("already closed");
        throw paramString;
      }
      finally {}
    }
    throw new IllegalArgumentException();
  }
  
  public void onReadMessage(String paramString)
    throws IOException
  {
    this.listener.onMessage(this, paramString);
  }
  
  public void onReadMessage(ByteString paramByteString)
    throws IOException
  {
    this.listener.onMessage(this, paramByteString);
  }
  
  public void onReadPing(ByteString paramByteString)
  {
    try
    {
      if ((!this.failed) && ((!this.enqueuedClose) || (!this.messageAndCloseQueue.isEmpty())))
      {
        this.pongQueue.add(paramByteString);
        runWriter();
        this.receivedPingCount += 1;
        return;
      }
      return;
    }
    finally {}
  }
  
  public void onReadPong(ByteString paramByteString)
  {
    try
    {
      this.receivedPongCount += 1;
      this.awaitingPong = false;
      return;
    }
    finally
    {
      paramByteString = finally;
      throw paramByteString;
    }
  }
  
  boolean pong(ByteString paramByteString)
  {
    try
    {
      if ((!this.failed) && ((!this.enqueuedClose) || (!this.messageAndCloseQueue.isEmpty())))
      {
        this.pongQueue.add(paramByteString);
        runWriter();
        return true;
      }
      return false;
    }
    finally {}
  }
  
  boolean processNextFrame()
    throws IOException
  {
    boolean bool = false;
    try
    {
      this.reader.processNextFrame();
      int i = this.receivedCloseCode;
      if (i == -1) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      failWebSocket(localException, null);
    }
    return false;
  }
  
  public long queueSize()
  {
    try
    {
      long l = this.queueSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  int receivedPingCount()
  {
    try
    {
      int i = this.receivedPingCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  int receivedPongCount()
  {
    try
    {
      int i = this.receivedPongCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Request request()
  {
    return this.originalRequest;
  }
  
  public boolean send(String paramString)
  {
    Objects.requireNonNull(paramString, "text == null");
    return send(ByteString.encodeUtf8(paramString), 1);
  }
  
  public boolean send(ByteString paramByteString)
  {
    Objects.requireNonNull(paramByteString, "bytes == null");
    return send(paramByteString, 2);
  }
  
  int sentPingCount()
  {
    try
    {
      int i = this.sentPingCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void tearDown()
    throws InterruptedException
  {
    ScheduledFuture localScheduledFuture = this.cancelFuture;
    if (localScheduledFuture != null) {
      localScheduledFuture.cancel(false);
    }
    this.executor.shutdown();
    this.executor.awaitTermination(10L, TimeUnit.SECONDS);
  }
  
  /* Error */
  boolean writeOneFrame()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 183	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   6: ifeq +7 -> 13
    //   9: aload_0
    //   10: monitorexit
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: getfield 407	okhttp3/internal/ws/RealWebSocket:writer	Lokhttp3/internal/ws/WebSocketWriter;
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 105	okhttp3/internal/ws/RealWebSocket:pongQueue	Ljava/util/ArrayDeque;
    //   22: invokevirtual 513	java/util/ArrayDeque:poll	()Ljava/lang/Object;
    //   25: checkcast 139	okio/ByteString
    //   28: astore_2
    //   29: iconst_m1
    //   30: istore_3
    //   31: aconst_null
    //   32: astore 4
    //   34: aload_2
    //   35: ifnonnull +137 -> 172
    //   38: aload_0
    //   39: getfield 107	okhttp3/internal/ws/RealWebSocket:messageAndCloseQueue	Ljava/util/ArrayDeque;
    //   42: invokevirtual 513	java/util/ArrayDeque:poll	()Ljava/lang/Object;
    //   45: astore 5
    //   47: aload 5
    //   49: instanceof 17
    //   52: ifeq +94 -> 146
    //   55: aload_0
    //   56: getfield 109	okhttp3/internal/ws/RealWebSocket:receivedCloseCode	I
    //   59: istore_3
    //   60: aload_0
    //   61: getfield 450	okhttp3/internal/ws/RealWebSocket:receivedCloseReason	Ljava/lang/String;
    //   64: astore 6
    //   66: iload_3
    //   67: iconst_m1
    //   68: if_icmpeq +34 -> 102
    //   71: aload_0
    //   72: getfield 366	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   75: astore 7
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 366	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   82: aload_0
    //   83: getfield 173	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   86: invokeinterface 376 1 0
    //   91: aload 5
    //   93: astore 4
    //   95: aload 7
    //   97: astore 5
    //   99: goto +80 -> 179
    //   102: aload_0
    //   103: getfield 173	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   106: astore 7
    //   108: new 14	okhttp3/internal/ws/RealWebSocket$CancelRunnable
    //   111: astore 4
    //   113: aload 4
    //   115: aload_0
    //   116: invokespecial 514	okhttp3/internal/ws/RealWebSocket$CancelRunnable:<init>	(Lokhttp3/internal/ws/RealWebSocket;)V
    //   119: aload_0
    //   120: aload 7
    //   122: aload 4
    //   124: aload 5
    //   126: checkcast 17	okhttp3/internal/ws/RealWebSocket$Close
    //   129: getfield 517	okhttp3/internal/ws/RealWebSocket$Close:cancelAfterCloseMillis	J
    //   132: getstatic 423	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   135: invokeinterface 521 5 0
    //   140: putfield 368	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   143: goto +15 -> 158
    //   146: aload 5
    //   148: ifnonnull +7 -> 155
    //   151: aload_0
    //   152: monitorexit
    //   153: iconst_0
    //   154: ireturn
    //   155: aconst_null
    //   156: astore 6
    //   158: aconst_null
    //   159: astore 7
    //   161: aload 5
    //   163: astore 4
    //   165: aload 7
    //   167: astore 5
    //   169: goto +10 -> 179
    //   172: aconst_null
    //   173: astore 5
    //   175: aload 5
    //   177: astore 6
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_2
    //   182: ifnull +11 -> 193
    //   185: aload_1
    //   186: aload_2
    //   187: invokevirtual 524	okhttp3/internal/ws/WebSocketWriter:writePong	(Lokio/ByteString;)V
    //   190: goto +135 -> 325
    //   193: aload 4
    //   195: instanceof 20
    //   198: ifeq +82 -> 280
    //   201: aload 4
    //   203: checkcast 20	okhttp3/internal/ws/RealWebSocket$Message
    //   206: getfield 528	okhttp3/internal/ws/RealWebSocket$Message:data	Lokio/ByteString;
    //   209: astore 6
    //   211: aload_1
    //   212: aload 4
    //   214: checkcast 20	okhttp3/internal/ws/RealWebSocket$Message
    //   217: getfield 531	okhttp3/internal/ws/RealWebSocket$Message:formatOpcode	I
    //   220: aload 6
    //   222: invokevirtual 191	okio/ByteString:size	()I
    //   225: i2l
    //   226: invokevirtual 535	okhttp3/internal/ws/WebSocketWriter:newMessageSink	(IJ)Lokio/Sink;
    //   229: invokestatic 541	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   232: astore 4
    //   234: aload 4
    //   236: aload 6
    //   238: invokeinterface 547 2 0
    //   243: pop
    //   244: aload 4
    //   246: invokeinterface 551 1 0
    //   251: aload_0
    //   252: monitorenter
    //   253: aload_0
    //   254: aload_0
    //   255: getfield 187	okhttp3/internal/ws/RealWebSocket:queueSize	J
    //   258: aload 6
    //   260: invokevirtual 191	okio/ByteString:size	()I
    //   263: i2l
    //   264: lsub
    //   265: putfield 187	okhttp3/internal/ws/RealWebSocket:queueSize	J
    //   268: aload_0
    //   269: monitorexit
    //   270: goto +55 -> 325
    //   273: astore 4
    //   275: aload_0
    //   276: monitorexit
    //   277: aload 4
    //   279: athrow
    //   280: aload 4
    //   282: instanceof 17
    //   285: ifeq +47 -> 332
    //   288: aload 4
    //   290: checkcast 17	okhttp3/internal/ws/RealWebSocket$Close
    //   293: astore 4
    //   295: aload_1
    //   296: aload 4
    //   298: getfield 553	okhttp3/internal/ws/RealWebSocket$Close:code	I
    //   301: aload 4
    //   303: getfield 556	okhttp3/internal/ws/RealWebSocket$Close:reason	Lokio/ByteString;
    //   306: invokevirtual 559	okhttp3/internal/ws/WebSocketWriter:writeClose	(ILokio/ByteString;)V
    //   309: aload 5
    //   311: ifnull +14 -> 325
    //   314: aload_0
    //   315: getfield 127	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
    //   318: aload_0
    //   319: iload_3
    //   320: aload 6
    //   322: invokevirtual 457	okhttp3/WebSocketListener:onClosed	(Lokhttp3/WebSocket;ILjava/lang/String;)V
    //   325: aload 5
    //   327: invokestatic 388	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   330: iconst_1
    //   331: ireturn
    //   332: new 561	java/lang/AssertionError
    //   335: astore 4
    //   337: aload 4
    //   339: invokespecial 562	java/lang/AssertionError:<init>	()V
    //   342: aload 4
    //   344: athrow
    //   345: astore 4
    //   347: aload 5
    //   349: invokestatic 388	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   352: aload 4
    //   354: athrow
    //   355: astore 5
    //   357: aload_0
    //   358: monitorexit
    //   359: aload 5
    //   361: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	RealWebSocket
    //   17	279	1	localWebSocketWriter	WebSocketWriter
    //   28	159	2	localByteString	ByteString
    //   30	290	3	i	int
    //   32	213	4	localObject1	Object
    //   273	16	4	localObject2	Object
    //   293	50	4	localObject3	Object
    //   345	8	4	localObject4	Object
    //   45	303	5	localObject5	Object
    //   355	5	5	localObject6	Object
    //   64	257	6	localObject7	Object
    //   75	91	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   253	270	273	finally
    //   275	277	273	finally
    //   185	190	345	finally
    //   193	253	345	finally
    //   277	280	345	finally
    //   280	309	345	finally
    //   314	325	345	finally
    //   332	345	345	finally
    //   2	11	355	finally
    //   13	29	355	finally
    //   38	66	355	finally
    //   71	91	355	finally
    //   102	143	355	finally
    //   151	153	355	finally
    //   179	181	355	finally
    //   357	359	355	finally
  }
  
  void writePingFrame()
  {
    try
    {
      if (this.failed) {
        return;
      }
      Object localObject1 = this.writer;
      int i;
      if (this.awaitingPong) {
        i = this.sentPingCount;
      } else {
        i = -1;
      }
      this.sentPingCount += 1;
      this.awaitingPong = true;
      if (i != -1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sent ping but didn't receive pong within ");
        ((StringBuilder)localObject1).append(this.pingIntervalMillis);
        ((StringBuilder)localObject1).append("ms (after ");
        ((StringBuilder)localObject1).append(i - 1);
        ((StringBuilder)localObject1).append(" successful ping/pongs)");
        failWebSocket(new SocketTimeoutException(((StringBuilder)localObject1).toString()), null);
        return;
      }
      try
      {
        ((WebSocketWriter)localObject1).writePing(ByteString.EMPTY);
      }
      catch (IOException localIOException)
      {
        failWebSocket(localIOException, null);
      }
      return;
    }
    finally {}
  }
  
  final class CancelRunnable
    implements Runnable
  {
    CancelRunnable() {}
    
    public void run()
    {
      RealWebSocket.this.cancel();
    }
  }
  
  static final class Close
  {
    final long cancelAfterCloseMillis;
    final int code;
    final ByteString reason;
    
    Close(int paramInt, ByteString paramByteString, long paramLong)
    {
      this.code = paramInt;
      this.reason = paramByteString;
      this.cancelAfterCloseMillis = paramLong;
    }
  }
  
  static final class Message
  {
    final ByteString data;
    final int formatOpcode;
    
    Message(int paramInt, ByteString paramByteString)
    {
      this.formatOpcode = paramInt;
      this.data = paramByteString;
    }
  }
  
  private final class PingRunnable
    implements Runnable
  {
    PingRunnable() {}
    
    public void run()
    {
      RealWebSocket.this.writePingFrame();
    }
  }
  
  public static abstract class Streams
    implements Closeable
  {
    public final boolean client;
    public final BufferedSink sink;
    public final BufferedSource source;
    
    public Streams(boolean paramBoolean, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
    {
      this.client = paramBoolean;
      this.source = paramBufferedSource;
      this.sink = paramBufferedSink;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\ws\RealWebSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */