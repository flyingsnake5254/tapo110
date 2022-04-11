package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public final class Http2Connection
  implements Closeable
{
  static final int AWAIT_PING = 3;
  static final int DEGRADED_PING = 2;
  static final long DEGRADED_PONG_TIMEOUT_NS = 1000000000L;
  static final int INTERVAL_PING = 1;
  static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  private static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
  private long awaitPingsSent = 0L;
  private long awaitPongsReceived = 0L;
  long bytesLeftInWriteWindow;
  final boolean client;
  final Set<Integer> currentPushRequests;
  private long degradedPingsSent = 0L;
  private long degradedPongDeadlineNs = 0L;
  private long degradedPongsReceived = 0L;
  final String hostname;
  private long intervalPingsSent = 0L;
  private long intervalPongsReceived = 0L;
  int lastGoodStreamId;
  final Listener listener;
  int nextStreamId;
  Settings okHttpSettings = new Settings();
  final Settings peerSettings;
  private final ExecutorService pushExecutor;
  final PushObserver pushObserver;
  final ReaderRunnable readerRunnable;
  private boolean shutdown;
  final Socket socket;
  final Map<Integer, Http2Stream> streams = new LinkedHashMap();
  long unacknowledgedBytesRead = 0L;
  final Http2Writer writer;
  private final ScheduledExecutorService writerExecutor;
  
  Http2Connection(Builder paramBuilder)
  {
    Settings localSettings = new Settings();
    this.peerSettings = localSettings;
    this.currentPushRequests = new LinkedHashSet();
    this.pushObserver = paramBuilder.pushObserver;
    boolean bool = paramBuilder.client;
    this.client = bool;
    this.listener = paramBuilder.listener;
    int i;
    if (bool) {
      i = 1;
    } else {
      i = 2;
    }
    this.nextStreamId = i;
    if (bool) {
      this.nextStreamId = (i + 2);
    }
    if (bool) {
      this.okHttpSettings.set(7, 16777216);
    }
    String str = paramBuilder.hostname;
    this.hostname = str;
    ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", new Object[] { str }), false));
    this.writerExecutor = localScheduledThreadPoolExecutor;
    if (paramBuilder.pingIntervalMillis != 0)
    {
      IntervalPingRunnable localIntervalPingRunnable = new IntervalPingRunnable();
      i = paramBuilder.pingIntervalMillis;
      localScheduledThreadPoolExecutor.scheduleAtFixedRate(localIntervalPingRunnable, i, i, TimeUnit.MILLISECONDS);
    }
    this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", new Object[] { str }), true));
    localSettings.set(7, 65535);
    localSettings.set(5, 16384);
    this.bytesLeftInWriteWindow = localSettings.getInitialWindowSize();
    this.socket = paramBuilder.socket;
    this.writer = new Http2Writer(paramBuilder.sink, bool);
    this.readerRunnable = new ReaderRunnable(new Http2Reader(paramBuilder.source, bool));
  }
  
  private void failConnection()
  {
    try
    {
      ErrorCode localErrorCode = ErrorCode.PROTOCOL_ERROR;
      close(localErrorCode, localErrorCode);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  private Http2Stream newStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    boolean bool = paramBoolean ^ true;
    synchronized (this.writer)
    {
      try
      {
        if (this.nextStreamId > 1073741823) {
          shutdown(ErrorCode.REFUSED_STREAM);
        }
        if (!this.shutdown)
        {
          int i = this.nextStreamId;
          this.nextStreamId = (i + 2);
          Http2Stream localHttp2Stream = new okhttp3/internal/http2/Http2Stream;
          localHttp2Stream.<init>(i, this, bool, false, null);
          int j;
          if ((paramBoolean) && (this.bytesLeftInWriteWindow != 0L) && (localHttp2Stream.bytesLeftInWriteWindow != 0L)) {
            j = 0;
          } else {
            j = 1;
          }
          if (localHttp2Stream.isOpen()) {
            this.streams.put(Integer.valueOf(i), localHttp2Stream);
          }
          if (paramInt == 0)
          {
            this.writer.synStream(bool, i, paramInt, paramList);
          }
          else
          {
            if (this.client) {
              break label189;
            }
            this.writer.pushPromise(paramInt, i, paramList);
          }
          if (j != 0) {
            this.writer.flush();
          }
          return localHttp2Stream;
          label189:
          paramList = new java/lang/IllegalArgumentException;
          paramList.<init>("client streams shouldn't have associated stream IDs");
          throw paramList;
        }
        paramList = new okhttp3/internal/http2/ConnectionShutdownException;
        paramList.<init>();
        throw paramList;
      }
      finally {}
    }
  }
  
  private void pushExecutorExecute(NamedRunnable paramNamedRunnable)
  {
    try
    {
      if (!this.shutdown) {
        this.pushExecutor.execute(paramNamedRunnable);
      }
      return;
    }
    finally
    {
      paramNamedRunnable = finally;
      throw paramNamedRunnable;
    }
  }
  
  void awaitPong()
    throws InterruptedException
  {
    try
    {
      while (this.awaitPongsReceived < this.awaitPingsSent) {
        wait();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void close()
    throws IOException
  {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }
  
  void close(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2)
    throws IOException
  {
    Http2Stream[] arrayOfHttp2Stream = null;
    try
    {
      shutdown(paramErrorCode1);
      paramErrorCode1 = null;
    }
    catch (IOException paramErrorCode1) {}
    try
    {
      if (!this.streams.isEmpty())
      {
        arrayOfHttp2Stream = (Http2Stream[])this.streams.values().toArray(new Http2Stream[this.streams.size()]);
        this.streams.clear();
      }
      Object localObject = paramErrorCode1;
      if (arrayOfHttp2Stream != null)
      {
        int i = arrayOfHttp2Stream.length;
        int j = 0;
        for (;;)
        {
          localObject = paramErrorCode1;
          if (j >= i) {
            break;
          }
          localObject = arrayOfHttp2Stream[j];
          try
          {
            ((Http2Stream)localObject).close(paramErrorCode2);
            localObject = paramErrorCode1;
          }
          catch (IOException localIOException)
          {
            localObject = paramErrorCode1;
            if (paramErrorCode1 != null) {
              localObject = localIOException;
            }
          }
          j++;
          paramErrorCode1 = (ErrorCode)localObject;
        }
      }
      try
      {
        this.writer.close();
        paramErrorCode1 = (ErrorCode)localObject;
      }
      catch (IOException paramErrorCode2)
      {
        paramErrorCode1 = (ErrorCode)localObject;
        if (localObject == null) {
          paramErrorCode1 = paramErrorCode2;
        }
      }
      try
      {
        this.socket.close();
      }
      catch (IOException paramErrorCode1) {}
      this.writerExecutor.shutdown();
      this.pushExecutor.shutdown();
      if (paramErrorCode1 == null) {
        return;
      }
      throw paramErrorCode1;
    }
    finally {}
  }
  
  public void flush()
    throws IOException
  {
    this.writer.flush();
  }
  
  public Protocol getProtocol()
  {
    return Protocol.HTTP_2;
  }
  
  Http2Stream getStream(int paramInt)
  {
    try
    {
      Http2Stream localHttp2Stream = (Http2Stream)this.streams.get(Integer.valueOf(paramInt));
      return localHttp2Stream;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isHealthy(long paramLong)
  {
    try
    {
      boolean bool = this.shutdown;
      if (bool) {
        return false;
      }
      if (this.degradedPongsReceived < this.degradedPingsSent)
      {
        long l = this.degradedPongDeadlineNs;
        if (paramLong >= l) {
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  public int maxConcurrentStreams()
  {
    try
    {
      int i = this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Http2Stream newStream(List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    return newStream(0, paramList, paramBoolean);
  }
  
  public int openStreamCount()
  {
    try
    {
      int i = this.streams.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void pushDataLater(final int paramInt1, BufferedSource paramBufferedSource, final int paramInt2, final boolean paramBoolean)
    throws IOException
  {
    final Buffer localBuffer = new Buffer();
    long l = paramInt2;
    paramBufferedSource.require(l);
    paramBufferedSource.read(localBuffer, l);
    if (localBuffer.size() == l)
    {
      pushExecutorExecute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt1) })
      {
        public void execute()
        {
          try
          {
            boolean bool = Http2Connection.this.pushObserver.onData(paramInt1, localBuffer, paramInt2, paramBoolean);
            if (bool) {
              Http2Connection.this.writer.rstStream(paramInt1, ErrorCode.CANCEL);
            }
            if ((bool) || (paramBoolean)) {
              synchronized (Http2Connection.this)
              {
                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(paramInt1));
              }
            }
            return;
          }
          catch (IOException localIOException)
          {
            for (;;) {}
          }
        }
      });
      return;
    }
    paramBufferedSource = new StringBuilder();
    paramBufferedSource.append(localBuffer.size());
    paramBufferedSource.append(" != ");
    paramBufferedSource.append(paramInt2);
    throw new IOException(paramBufferedSource.toString());
  }
  
  void pushHeadersLater(int paramInt, List<Header> paramList, boolean paramBoolean)
  {
    try
    {
      NamedRunnable local5 = new okhttp3/internal/http2/Http2Connection$5;
      local5.<init>(this, "OkHttp %s Push Headers[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramList, paramBoolean);
      pushExecutorExecute(local5);
      return;
    }
    catch (RejectedExecutionException paramList)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  void pushRequestLater(int paramInt, List<Header> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 165	okhttp3/internal/http2/Http2Connection:currentPushRequests	Ljava/util/Set;
    //   6: iload_1
    //   7: invokestatic 311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 483 2 0
    //   15: ifeq +14 -> 29
    //   18: aload_0
    //   19: iload_1
    //   20: getstatic 282	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   23: invokevirtual 487	okhttp3/internal/http2/Http2Connection:writeSynResetLater	(ILokhttp3/internal/http2/ErrorCode;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 165	okhttp3/internal/http2/Http2Connection:currentPushRequests	Ljava/util/Set;
    //   33: iload_1
    //   34: invokestatic 311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: invokeinterface 490 2 0
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: new 14	okhttp3/internal/http2/Http2Connection$4
    //   48: astore_3
    //   49: aload_3
    //   50: aload_0
    //   51: ldc_w 492
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 183	okhttp3/internal/http2/Http2Connection:hostname	Ljava/lang/String;
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: iload_1
    //   68: invokestatic 311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: aastore
    //   72: iload_1
    //   73: aload_2
    //   74: invokespecial 495	okhttp3/internal/http2/Http2Connection$4:<init>	(Lokhttp3/internal/http2/Http2Connection;Ljava/lang/String;[Ljava/lang/Object;ILjava/util/List;)V
    //   77: aload_0
    //   78: aload_3
    //   79: invokespecial 445	okhttp3/internal/http2/Http2Connection:pushExecutorExecute	(Lokhttp3/internal/NamedRunnable;)V
    //   82: return
    //   83: astore_2
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_2
    //   87: athrow
    //   88: astore_2
    //   89: goto -7 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	Http2Connection
    //   0	92	1	paramInt	int
    //   0	92	2	paramList	List<Header>
    //   48	31	3	local4	4
    // Exception table:
    //   from	to	target	type
    //   2	28	83	finally
    //   29	45	83	finally
    //   84	86	83	finally
    //   45	82	88	java/util/concurrent/RejectedExecutionException
  }
  
  void pushResetLater(final int paramInt, final ErrorCode paramErrorCode)
  {
    pushExecutorExecute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt) })
    {
      public void execute()
      {
        Http2Connection.this.pushObserver.onReset(paramInt, paramErrorCode);
        synchronized (Http2Connection.this)
        {
          Http2Connection.this.currentPushRequests.remove(Integer.valueOf(paramInt));
          return;
        }
      }
    });
  }
  
  public Http2Stream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    if (!this.client) {
      return newStream(paramInt, paramList, paramBoolean);
    }
    throw new IllegalStateException("Client cannot push requests.");
  }
  
  boolean pushedStream(int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 0) || ((paramInt & 0x1) != 0)) {
      bool = false;
    }
    return bool;
  }
  
  Http2Stream removeStream(int paramInt)
  {
    try
    {
      Http2Stream localHttp2Stream = (Http2Stream)this.streams.remove(Integer.valueOf(paramInt));
      notifyAll();
      return localHttp2Stream;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  void sendDegradedPingLater()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	okhttp3/internal/http2/Http2Connection:degradedPongsReceived	J
    //   6: lstore_1
    //   7: aload_0
    //   8: getfield 143	okhttp3/internal/http2/Http2Connection:degradedPingsSent	J
    //   11: lstore_3
    //   12: lload_1
    //   13: lload_3
    //   14: lcmp
    //   15: ifge +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: lload_3
    //   23: lconst_1
    //   24: ladd
    //   25: putfield 143	okhttp3/internal/http2/Http2Connection:degradedPingsSent	J
    //   28: aload_0
    //   29: invokestatic 523	java/lang/System:nanoTime	()J
    //   32: ldc2_w 54
    //   35: ladd
    //   36: putfield 151	okhttp3/internal/http2/Http2Connection:degradedPongDeadlineNs	J
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_0
    //   42: getfield 196	okhttp3/internal/http2/Http2Connection:writerExecutor	Ljava/util/concurrent/ScheduledExecutorService;
    //   45: astore 5
    //   47: new 12	okhttp3/internal/http2/Http2Connection$3
    //   50: astore 6
    //   52: aload 6
    //   54: aload_0
    //   55: ldc_w 525
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: getfield 183	okhttp3/internal/http2/Http2Connection:hostname	Ljava/lang/String;
    //   68: aastore
    //   69: invokespecial 528	okhttp3/internal/http2/Http2Connection$3:<init>	(Lokhttp3/internal/http2/Http2Connection;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload 5
    //   74: aload 6
    //   76: invokeinterface 529 2 0
    //   81: return
    //   82: astore 6
    //   84: aload_0
    //   85: monitorexit
    //   86: aload 6
    //   88: athrow
    //   89: astore 6
    //   91: goto -10 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	Http2Connection
    //   6	7	1	l1	long
    //   11	12	3	l2	long
    //   45	28	5	localScheduledExecutorService	ScheduledExecutorService
    //   50	25	6	local3	3
    //   82	5	6	localObject	Object
    //   89	1	6	localRejectedExecutionException	RejectedExecutionException
    // Exception table:
    //   from	to	target	type
    //   2	12	82	finally
    //   18	20	82	finally
    //   21	41	82	finally
    //   84	86	82	finally
    //   41	81	89	java/util/concurrent/RejectedExecutionException
  }
  
  public void setSettings(Settings paramSettings)
    throws IOException
  {
    synchronized (this.writer)
    {
      try
      {
        if (!this.shutdown)
        {
          this.okHttpSettings.merge(paramSettings);
          this.writer.settings(paramSettings);
          return;
        }
        paramSettings = new okhttp3/internal/http2/ConnectionShutdownException;
        paramSettings.<init>();
        throw paramSettings;
      }
      finally {}
    }
  }
  
  public void shutdown(ErrorCode paramErrorCode)
    throws IOException
  {
    synchronized (this.writer)
    {
      try
      {
        if (this.shutdown) {
          return;
        }
        this.shutdown = true;
        int i = this.lastGoodStreamId;
        this.writer.goAway(i, paramErrorCode, Util.EMPTY_BYTE_ARRAY);
        return;
      }
      finally {}
    }
  }
  
  public void start()
    throws IOException
  {
    start(true);
  }
  
  void start(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      this.writer.connectionPreface();
      this.writer.settings(this.okHttpSettings);
      int i = this.okHttpSettings.getInitialWindowSize();
      if (i != 65535) {
        this.writer.windowUpdate(0, i - 65535);
      }
    }
    new Thread(this.readerRunnable).start();
  }
  
  void updateConnectionFlowControl(long paramLong)
  {
    try
    {
      paramLong = this.unacknowledgedBytesRead + paramLong;
      this.unacknowledgedBytesRead = paramLong;
      if (paramLong >= this.okHttpSettings.getInitialWindowSize() / 2)
      {
        writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
        this.unacknowledgedBytesRead = 0L;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void writeData(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong)
    throws IOException
  {
    // Byte code:
    //   0: lload 4
    //   2: lstore 6
    //   4: lload 4
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +15 -> 23
    //   11: aload_0
    //   12: getfield 239	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   15: iload_2
    //   16: iload_1
    //   17: aload_3
    //   18: iconst_0
    //   19: invokevirtual 574	okhttp3/internal/http2/Http2Writer:data	(ZILokio/Buffer;I)V
    //   22: return
    //   23: lload 6
    //   25: lconst_0
    //   26: lcmp
    //   27: ifle +168 -> 195
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 225	okhttp3/internal/http2/Http2Connection:bytesLeftInWriteWindow	J
    //   36: lstore 4
    //   38: lload 4
    //   40: lconst_0
    //   41: lcmp
    //   42: ifgt +39 -> 81
    //   45: aload_0
    //   46: getfield 137	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   49: iload_1
    //   50: invokestatic 311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: invokeinterface 577 2 0
    //   58: ifeq +10 -> 68
    //   61: aload_0
    //   62: invokevirtual 355	java/lang/Object:wait	()V
    //   65: goto -33 -> 32
    //   68: new 276	java/io/IOException
    //   71: astore_3
    //   72: aload_3
    //   73: ldc_w 579
    //   76: invokespecial 465	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   79: aload_3
    //   80: athrow
    //   81: lload 6
    //   83: lload 4
    //   85: invokestatic 585	java/lang/Math:min	(JJ)J
    //   88: l2i
    //   89: aload_0
    //   90: getfield 239	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   93: invokevirtual 588	okhttp3/internal/http2/Http2Writer:maxDataLength	()I
    //   96: invokestatic 591	java/lang/Math:min	(II)I
    //   99: istore 8
    //   101: aload_0
    //   102: getfield 225	okhttp3/internal/http2/Http2Connection:bytesLeftInWriteWindow	J
    //   105: lstore 4
    //   107: iload 8
    //   109: i2l
    //   110: lstore 9
    //   112: aload_0
    //   113: lload 4
    //   115: lload 9
    //   117: lsub
    //   118: putfield 225	okhttp3/internal/http2/Http2Connection:bytesLeftInWriteWindow	J
    //   121: aload_0
    //   122: monitorexit
    //   123: lload 6
    //   125: lload 9
    //   127: lsub
    //   128: lstore 6
    //   130: aload_0
    //   131: getfield 239	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   134: astore 11
    //   136: iload_2
    //   137: ifeq +16 -> 153
    //   140: lload 6
    //   142: lconst_0
    //   143: lcmp
    //   144: ifne +9 -> 153
    //   147: iconst_1
    //   148: istore 12
    //   150: goto +6 -> 156
    //   153: iconst_0
    //   154: istore 12
    //   156: aload 11
    //   158: iload 12
    //   160: iload_1
    //   161: aload_3
    //   162: iload 8
    //   164: invokevirtual 574	okhttp3/internal/http2/Http2Writer:data	(ZILokio/Buffer;I)V
    //   167: goto -144 -> 23
    //   170: astore_3
    //   171: goto +20 -> 191
    //   174: astore_3
    //   175: invokestatic 595	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   178: invokevirtual 598	java/lang/Thread:interrupt	()V
    //   181: new 600	java/io/InterruptedIOException
    //   184: astore_3
    //   185: aload_3
    //   186: invokespecial 601	java/io/InterruptedIOException:<init>	()V
    //   189: aload_3
    //   190: athrow
    //   191: aload_0
    //   192: monitorexit
    //   193: aload_3
    //   194: athrow
    //   195: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	Http2Connection
    //   0	196	1	paramInt	int
    //   0	196	2	paramBoolean	boolean
    //   0	196	3	paramBuffer	Buffer
    //   0	196	4	paramLong	long
    //   2	139	6	l1	long
    //   99	64	8	i	int
    //   110	16	9	l2	long
    //   134	23	11	localHttp2Writer	Http2Writer
    //   148	11	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   32	38	170	finally
    //   45	65	170	finally
    //   68	81	170	finally
    //   81	107	170	finally
    //   112	123	170	finally
    //   175	191	170	finally
    //   191	193	170	finally
    //   32	38	174	java/lang/InterruptedException
    //   45	65	174	java/lang/InterruptedException
    //   68	81	174	java/lang/InterruptedException
  }
  
  void writePing()
  {
    try
    {
      this.awaitPingsSent += 1L;
      writePing(false, 3, 1330343787);
      return;
    }
    finally {}
  }
  
  void writePing(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      this.writer.ping(paramBoolean, paramInt1, paramInt2);
    }
    catch (IOException localIOException)
    {
      failConnection();
    }
  }
  
  void writePingAndAwaitPong()
    throws InterruptedException
  {
    writePing();
    awaitPong();
  }
  
  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList)
    throws IOException
  {
    this.writer.synReply(paramBoolean, paramInt, paramList);
  }
  
  void writeSynReset(int paramInt, ErrorCode paramErrorCode)
    throws IOException
  {
    this.writer.rstStream(paramInt, paramErrorCode);
  }
  
  void writeSynResetLater(int paramInt, ErrorCode paramErrorCode)
  {
    try
    {
      ScheduledExecutorService localScheduledExecutorService = this.writerExecutor;
      NamedRunnable local1 = new okhttp3/internal/http2/Http2Connection$1;
      local1.<init>(this, "OkHttp %s stream %d", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramErrorCode);
      localScheduledExecutorService.execute(local1);
      return;
    }
    catch (RejectedExecutionException paramErrorCode)
    {
      for (;;) {}
    }
  }
  
  void writeWindowUpdateLater(int paramInt, long paramLong)
  {
    try
    {
      ScheduledExecutorService localScheduledExecutorService = this.writerExecutor;
      NamedRunnable local2 = new okhttp3/internal/http2/Http2Connection$2;
      local2.<init>(this, "OkHttp Window Update %s stream %d", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramLong);
      localScheduledExecutorService.execute(local2);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      for (;;) {}
    }
  }
  
  public static class Builder
  {
    boolean client;
    String hostname;
    Http2Connection.Listener listener = Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
    int pingIntervalMillis;
    PushObserver pushObserver = PushObserver.CANCEL;
    BufferedSink sink;
    Socket socket;
    BufferedSource source;
    
    public Builder(boolean paramBoolean)
    {
      this.client = paramBoolean;
    }
    
    public Http2Connection build()
    {
      return new Http2Connection(this);
    }
    
    public Builder listener(Http2Connection.Listener paramListener)
    {
      this.listener = paramListener;
      return this;
    }
    
    public Builder pingIntervalMillis(int paramInt)
    {
      this.pingIntervalMillis = paramInt;
      return this;
    }
    
    public Builder pushObserver(PushObserver paramPushObserver)
    {
      this.pushObserver = paramPushObserver;
      return this;
    }
    
    public Builder socket(Socket paramSocket)
      throws IOException
    {
      return socket(paramSocket, ((InetSocketAddress)paramSocket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(paramSocket)), Okio.buffer(Okio.sink(paramSocket)));
    }
    
    public Builder socket(Socket paramSocket, String paramString, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
    {
      this.socket = paramSocket;
      this.hostname = paramString;
      this.source = paramBufferedSource;
      this.sink = paramBufferedSink;
      return this;
    }
  }
  
  final class IntervalPingRunnable
    extends NamedRunnable
  {
    IntervalPingRunnable()
    {
      super(new Object[] { Http2Connection.this.hostname });
    }
    
    public void execute()
    {
      synchronized (Http2Connection.this)
      {
        int i;
        if (Http2Connection.this.intervalPongsReceived < Http2Connection.this.intervalPingsSent)
        {
          i = 1;
        }
        else
        {
          Http2Connection.access$208(Http2Connection.this);
          i = 0;
        }
        if (i != 0) {
          Http2Connection.this.failConnection();
        } else {
          Http2Connection.this.writePing(false, 1, 0);
        }
        return;
      }
    }
  }
  
  public static abstract class Listener
  {
    public static final Listener REFUSE_INCOMING_STREAMS = new Listener()
    {
      public void onStream(Http2Stream paramAnonymousHttp2Stream)
        throws IOException
      {
        paramAnonymousHttp2Stream.close(ErrorCode.REFUSED_STREAM);
      }
    };
    
    public void onSettings(Http2Connection paramHttp2Connection) {}
    
    public abstract void onStream(Http2Stream paramHttp2Stream)
      throws IOException;
  }
  
  final class PingRunnable
    extends NamedRunnable
  {
    final int payload1;
    final int payload2;
    final boolean reply;
    
    PingRunnable(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      super(new Object[] { Http2Connection.this.hostname, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.reply = paramBoolean;
      this.payload1 = paramInt1;
      this.payload2 = paramInt2;
    }
    
    public void execute()
    {
      Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
    }
  }
  
  class ReaderRunnable
    extends NamedRunnable
    implements Http2Reader.Handler
  {
    final Http2Reader reader;
    
    ReaderRunnable(Http2Reader paramHttp2Reader)
    {
      super(new Object[] { Http2Connection.this.hostname });
      this.reader = paramHttp2Reader;
    }
    
    public void ackSettings() {}
    
    public void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong) {}
    
    void applyAndAckSettings(boolean paramBoolean, Settings paramSettings)
    {
      synchronized (Http2Connection.this.writer)
      {
        synchronized (Http2Connection.this)
        {
          int i = Http2Connection.this.peerSettings.getInitialWindowSize();
          if (paramBoolean) {
            Http2Connection.this.peerSettings.clear();
          }
          Http2Connection.this.peerSettings.merge(paramSettings);
          int j = Http2Connection.this.peerSettings.getInitialWindowSize();
          paramSettings = null;
          long l2;
          if ((j != -1) && (j != i))
          {
            long l1 = j - i;
            l2 = l1;
            if (!Http2Connection.this.streams.isEmpty())
            {
              paramSettings = (Http2Stream[])Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
              l2 = l1;
            }
          }
          else
          {
            l2 = 0L;
          }
          try
          {
            ??? = Http2Connection.this;
            ???.writer.applyAndAckSettings(???.peerSettings);
          }
          catch (IOException localIOException)
          {
            Http2Connection.this.failConnection();
          }
          if (paramSettings != null)
          {
            j = paramSettings.length;
            i = 0;
            while (i < j) {
              synchronized (paramSettings[i])
              {
                ???.addBytesToWriteWindow(l2);
                i++;
              }
            }
          }
          Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s settings", new Object[] { Http2Connection.this.hostname })
          {
            public void execute()
            {
              Http2Connection localHttp2Connection = Http2Connection.this;
              localHttp2Connection.listener.onSettings(localHttp2Connection);
            }
          });
          return;
        }
      }
    }
    
    public void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
      throws IOException
    {
      if (Http2Connection.this.pushedStream(paramInt1))
      {
        Http2Connection.this.pushDataLater(paramInt1, paramBufferedSource, paramInt2, paramBoolean);
        return;
      }
      Object localObject = Http2Connection.this.getStream(paramInt1);
      if (localObject == null)
      {
        Http2Connection.this.writeSynResetLater(paramInt1, ErrorCode.PROTOCOL_ERROR);
        localObject = Http2Connection.this;
        long l = paramInt2;
        ((Http2Connection)localObject).updateConnectionFlowControl(l);
        paramBufferedSource.skip(l);
        return;
      }
      ((Http2Stream)localObject).receiveData(paramBufferedSource, paramInt2);
      if (paramBoolean) {
        ((Http2Stream)localObject).receiveFin();
      }
    }
    
    /* Error */
    protected void execute()
    {
      // Byte code:
      //   0: getstatic 163	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   3: astore_1
      //   4: aload_0
      //   5: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   8: aload_0
      //   9: invokevirtual 169	okhttp3/internal/http2/Http2Reader:readConnectionPreface	(Lokhttp3/internal/http2/Http2Reader$Handler;)V
      //   12: aload_0
      //   13: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   16: iconst_0
      //   17: aload_0
      //   18: invokevirtual 173	okhttp3/internal/http2/Http2Reader:nextFrame	(ZLokhttp3/internal/http2/Http2Reader$Handler;)Z
      //   21: ifeq +6 -> 27
      //   24: goto -12 -> 12
      //   27: getstatic 176	okhttp3/internal/http2/ErrorCode:NO_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   30: astore_2
      //   31: aload_2
      //   32: astore_3
      //   33: getstatic 179	okhttp3/internal/http2/ErrorCode:CANCEL	Lokhttp3/internal/http2/ErrorCode;
      //   36: astore 4
      //   38: aload_0
      //   39: getfield 23	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   42: aload_2
      //   43: aload 4
      //   45: invokevirtual 183	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   48: goto +25 -> 73
      //   51: astore_2
      //   52: aload_1
      //   53: astore_3
      //   54: goto +28 -> 82
      //   57: astore_3
      //   58: aload_1
      //   59: astore_3
      //   60: getstatic 140	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   63: astore_2
      //   64: aload_0
      //   65: getfield 23	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   68: aload_2
      //   69: aload_2
      //   70: invokevirtual 183	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   73: aload_0
      //   74: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   77: invokestatic 189	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   80: return
      //   81: astore_2
      //   82: aload_0
      //   83: getfield 23	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   86: aload_3
      //   87: aload_1
      //   88: invokevirtual 183	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   91: aload_0
      //   92: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   95: invokestatic 189	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   98: aload_2
      //   99: athrow
      //   100: astore_3
      //   101: aload_2
      //   102: astore_3
      //   103: goto -43 -> 60
      //   106: astore_3
      //   107: goto -34 -> 73
      //   110: astore_3
      //   111: goto -20 -> 91
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	114	0	this	ReaderRunnable
      //   3	85	1	localErrorCode1	ErrorCode
      //   30	13	2	localErrorCode2	ErrorCode
      //   51	1	2	localObject1	Object
      //   63	7	2	localErrorCode3	ErrorCode
      //   81	21	2	localObject2	Object
      //   32	22	3	localErrorCode4	ErrorCode
      //   57	1	3	localIOException1	IOException
      //   59	28	3	localErrorCode5	ErrorCode
      //   100	1	3	localIOException2	IOException
      //   102	1	3	localObject3	Object
      //   106	1	3	localIOException3	IOException
      //   110	1	3	localIOException4	IOException
      //   36	8	4	localErrorCode6	ErrorCode
      // Exception table:
      //   from	to	target	type
      //   4	12	51	finally
      //   12	24	51	finally
      //   27	31	51	finally
      //   4	12	57	java/io/IOException
      //   12	24	57	java/io/IOException
      //   27	31	57	java/io/IOException
      //   33	38	81	finally
      //   60	64	81	finally
      //   33	38	100	java/io/IOException
      //   38	48	106	java/io/IOException
      //   64	73	106	java/io/IOException
      //   82	91	110	java/io/IOException
    }
    
    public void goAway(int paramInt, ErrorCode arg2, ByteString paramByteString)
    {
      paramByteString.size();
      synchronized (Http2Connection.this)
      {
        paramByteString = (Http2Stream[])Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
        Http2Connection.access$302(Http2Connection.this, true);
        int i = paramByteString.length;
        for (int j = 0; j < i; j++)
        {
          ??? = paramByteString[j];
          if ((???.getId() > paramInt) && (???.isLocallyInitiated()))
          {
            ???.receiveRstStream(ErrorCode.REFUSED_STREAM);
            Http2Connection.this.removeStream(???.getId());
          }
        }
        return;
      }
    }
    
    public void headers(boolean paramBoolean, int paramInt1, int paramInt2, List<Header> paramList)
    {
      if (Http2Connection.this.pushedStream(paramInt1))
      {
        Http2Connection.this.pushHeadersLater(paramInt1, paramList, paramBoolean);
        return;
      }
      synchronized (Http2Connection.this)
      {
        Object localObject = Http2Connection.this.getStream(paramInt1);
        if (localObject == null)
        {
          if (Http2Connection.this.shutdown) {
            return;
          }
          localObject = Http2Connection.this;
          if (paramInt1 <= ((Http2Connection)localObject).lastGoodStreamId) {
            return;
          }
          if (paramInt1 % 2 == ((Http2Connection)localObject).nextStreamId % 2) {
            return;
          }
          localObject = Util.toHeaders(paramList);
          paramList = new okhttp3/internal/http2/Http2Stream;
          paramList.<init>(paramInt1, Http2Connection.this, false, paramBoolean, (Headers)localObject);
          localObject = Http2Connection.this;
          ((Http2Connection)localObject).lastGoodStreamId = paramInt1;
          ((Http2Connection)localObject).streams.put(Integer.valueOf(paramInt1), paramList);
          localObject = Http2Connection.listenerExecutor;
          NamedRunnable local1 = new okhttp3/internal/http2/Http2Connection$ReaderRunnable$1;
          local1.<init>(this, "OkHttp %s stream %d", new Object[] { Http2Connection.this.hostname, Integer.valueOf(paramInt1) }, paramList);
          ((ExecutorService)localObject).execute(local1);
          return;
        }
        ((Http2Stream)localObject).receiveHeaders(paramList);
        if (paramBoolean) {
          ((Http2Stream)localObject).receiveFin();
        }
        return;
      }
    }
    
    public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      Object localObject1;
      if (paramBoolean)
      {
        localObject1 = Http2Connection.this;
        if (paramInt1 == 1)
        {
          try
          {
            Http2Connection.access$108(Http2Connection.this);
          }
          finally
          {
            break label76;
          }
        }
        else if (paramInt1 == 2)
        {
          Http2Connection.access$608(Http2Connection.this);
        }
        else if (paramInt1 == 3)
        {
          Http2Connection.access$708(Http2Connection.this);
          Http2Connection.this.notifyAll();
        }
        break label117;
        label76:
        throw ((Throwable)localObject2);
      }
      try
      {
        ScheduledExecutorService localScheduledExecutorService = Http2Connection.this.writerExecutor;
        localObject1 = new okhttp3/internal/http2/Http2Connection$PingRunnable;
        ((Http2Connection.PingRunnable)localObject1).<init>(Http2Connection.this, true, paramInt1, paramInt2);
        localScheduledExecutorService.execute((Runnable)localObject1);
        label117:
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        for (;;) {}
      }
    }
    
    public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    {
      Http2Connection.this.pushRequestLater(paramInt2, paramList);
    }
    
    public void rstStream(int paramInt, ErrorCode paramErrorCode)
    {
      if (Http2Connection.this.pushedStream(paramInt))
      {
        Http2Connection.this.pushResetLater(paramInt, paramErrorCode);
        return;
      }
      Http2Stream localHttp2Stream = Http2Connection.this.removeStream(paramInt);
      if (localHttp2Stream != null) {
        localHttp2Stream.receiveRstStream(paramErrorCode);
      }
    }
    
    public void settings(boolean paramBoolean, Settings paramSettings)
    {
      try
      {
        ScheduledExecutorService localScheduledExecutorService = Http2Connection.this.writerExecutor;
        NamedRunnable local2 = new okhttp3/internal/http2/Http2Connection$ReaderRunnable$2;
        local2.<init>(this, "OkHttp %s ACK Settings", new Object[] { Http2Connection.this.hostname }, paramBoolean, paramSettings);
        localScheduledExecutorService.execute(local2);
        return;
      }
      catch (RejectedExecutionException paramSettings)
      {
        for (;;) {}
      }
    }
    
    public void windowUpdate(int paramInt, long paramLong)
    {
      if (paramInt == 0) {
        synchronized (Http2Connection.this)
        {
          Http2Connection localHttp2Connection = Http2Connection.this;
          localHttp2Connection.bytesLeftInWriteWindow += paramLong;
          localHttp2Connection.notifyAll();
        }
      }
      ??? = Http2Connection.this.getStream(paramInt);
      if (??? != null) {
        try
        {
          ((Http2Stream)???).addBytesToWriteWindow(paramLong);
        }
        finally {}
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\http2\Http2Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */