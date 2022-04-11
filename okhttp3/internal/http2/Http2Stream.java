package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream
{
  long bytesLeftInWriteWindow;
  final Http2Connection connection;
  ErrorCode errorCode;
  private boolean hasResponseHeaders;
  private Header.Listener headersListener;
  private final Deque<Headers> headersQueue;
  final int id;
  final StreamTimeout readTimeout;
  final FramingSink sink;
  private final FramingSource source;
  long unacknowledgedBytesRead = 0L;
  final StreamTimeout writeTimeout;
  
  Http2Stream(int paramInt, Http2Connection paramHttp2Connection, boolean paramBoolean1, boolean paramBoolean2, @Nullable Headers paramHeaders)
  {
    ArrayDeque localArrayDeque = new ArrayDeque();
    this.headersQueue = localArrayDeque;
    this.readTimeout = new StreamTimeout();
    this.writeTimeout = new StreamTimeout();
    this.errorCode = null;
    Objects.requireNonNull(paramHttp2Connection, "connection == null");
    this.id = paramInt;
    this.connection = paramHttp2Connection;
    this.bytesLeftInWriteWindow = paramHttp2Connection.peerSettings.getInitialWindowSize();
    paramHttp2Connection = new FramingSource(paramHttp2Connection.okHttpSettings.getInitialWindowSize());
    this.source = paramHttp2Connection;
    FramingSink localFramingSink = new FramingSink();
    this.sink = localFramingSink;
    paramHttp2Connection.finished = paramBoolean2;
    localFramingSink.finished = paramBoolean1;
    if (paramHeaders != null) {
      localArrayDeque.add(paramHeaders);
    }
    if ((isLocallyInitiated()) && (paramHeaders != null)) {
      throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
    }
    if ((!isLocallyInitiated()) && (paramHeaders == null)) {
      throw new IllegalStateException("remotely-initiated streams should have headers");
    }
  }
  
  private boolean closeInternal(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.errorCode != null) {
        return false;
      }
      if ((this.source.finished) && (this.sink.finished)) {
        return false;
      }
      this.errorCode = paramErrorCode;
      notifyAll();
      this.connection.removeStream(this.id);
      return true;
    }
    finally {}
  }
  
  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  void cancelStreamIfNecessary()
    throws IOException
  {
    try
    {
      Object localObject1 = this.source;
      if ((!((FramingSource)localObject1).finished) && (((FramingSource)localObject1).closed))
      {
        localObject1 = this.sink;
        if ((((FramingSink)localObject1).finished) || (((FramingSink)localObject1).closed))
        {
          i = 1;
          break label47;
        }
      }
      int i = 0;
      label47:
      boolean bool = isOpen();
      if (i != 0) {
        close(ErrorCode.CANCEL);
      } else if (!bool) {
        this.connection.removeStream(this.id);
      }
      return;
    }
    finally {}
  }
  
  void checkOutNotClosed()
    throws IOException
  {
    FramingSink localFramingSink = this.sink;
    if (!localFramingSink.closed)
    {
      if (!localFramingSink.finished)
      {
        if (this.errorCode == null) {
          return;
        }
        throw new StreamResetException(this.errorCode);
      }
      throw new IOException("stream finished");
    }
    throw new IOException("stream closed");
  }
  
  public void close(ErrorCode paramErrorCode)
    throws IOException
  {
    if (!closeInternal(paramErrorCode)) {
      return;
    }
    this.connection.writeSynReset(this.id, paramErrorCode);
  }
  
  public void closeLater(ErrorCode paramErrorCode)
  {
    if (!closeInternal(paramErrorCode)) {
      return;
    }
    this.connection.writeSynResetLater(this.id, paramErrorCode);
  }
  
  public Http2Connection getConnection()
  {
    return this.connection;
  }
  
  public ErrorCode getErrorCode()
  {
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      return localErrorCode;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public Sink getSink()
  {
    try
    {
      if ((!this.hasResponseHeaders) && (!isLocallyInitiated()))
      {
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        localIllegalStateException.<init>("reply before requesting the sink");
        throw localIllegalStateException;
      }
      return this.sink;
    }
    finally {}
  }
  
  public Source getSource()
  {
    return this.source;
  }
  
  public boolean isLocallyInitiated()
  {
    int i = this.id;
    boolean bool1 = true;
    boolean bool2;
    if ((i & 0x1) == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (this.connection.client == bool2) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    return bool2;
  }
  
  public boolean isOpen()
  {
    try
    {
      Object localObject1 = this.errorCode;
      if (localObject1 != null) {
        return false;
      }
      localObject1 = this.source;
      if ((((FramingSource)localObject1).finished) || (((FramingSource)localObject1).closed))
      {
        localObject1 = this.sink;
        if ((((FramingSink)localObject1).finished) || (((FramingSink)localObject1).closed))
        {
          boolean bool = this.hasResponseHeaders;
          if (bool) {
            return false;
          }
        }
      }
      return true;
    }
    finally {}
  }
  
  public Timeout readTimeout()
  {
    return this.readTimeout;
  }
  
  void receiveData(BufferedSource paramBufferedSource, int paramInt)
    throws IOException
  {
    this.source.receive(paramBufferedSource, paramInt);
  }
  
  void receiveFin()
  {
    try
    {
      this.source.finished = true;
      boolean bool = isOpen();
      notifyAll();
      if (!bool) {
        this.connection.removeStream(this.id);
      }
      return;
    }
    finally {}
  }
  
  void receiveHeaders(List<Header> paramList)
  {
    try
    {
      this.hasResponseHeaders = true;
      this.headersQueue.add(Util.toHeaders(paramList));
      boolean bool = isOpen();
      notifyAll();
      if (!bool) {
        this.connection.removeStream(this.id);
      }
      return;
    }
    finally {}
  }
  
  void receiveRstStream(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.errorCode == null)
      {
        this.errorCode = paramErrorCode;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramErrorCode = finally;
      throw paramErrorCode;
    }
  }
  
  public void setHeadersListener(Header.Listener paramListener)
  {
    try
    {
      this.headersListener = paramListener;
      if ((!this.headersQueue.isEmpty()) && (paramListener != null)) {
        notifyAll();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public Headers takeHeaders()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	okhttp3/internal/http2/Http2Stream:readTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
    //   6: invokevirtual 227	okio/AsyncTimeout:enter	()V
    //   9: aload_0
    //   10: getfield 53	okhttp3/internal/http2/Http2Stream:headersQueue	Ljava/util/Deque;
    //   13: invokeinterface 220 1 0
    //   18: ifeq +17 -> 35
    //   21: aload_0
    //   22: getfield 62	okhttp3/internal/http2/Http2Stream:errorCode	Lokhttp3/internal/http2/ErrorCode;
    //   25: ifnonnull +10 -> 35
    //   28: aload_0
    //   29: invokevirtual 230	okhttp3/internal/http2/Http2Stream:waitForIo	()V
    //   32: goto -23 -> 9
    //   35: aload_0
    //   36: getfield 58	okhttp3/internal/http2/Http2Stream:readTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
    //   39: invokevirtual 233	okhttp3/internal/http2/Http2Stream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   42: aload_0
    //   43: getfield 53	okhttp3/internal/http2/Http2Stream:headersQueue	Ljava/util/Deque;
    //   46: invokeinterface 220 1 0
    //   51: ifne +20 -> 71
    //   54: aload_0
    //   55: getfield 53	okhttp3/internal/http2/Http2Stream:headersQueue	Ljava/util/Deque;
    //   58: invokeinterface 237 1 0
    //   63: checkcast 239	okhttp3/Headers
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: new 163	okhttp3/internal/http2/StreamResetException
    //   74: astore_1
    //   75: aload_1
    //   76: aload_0
    //   77: getfield 62	okhttp3/internal/http2/Http2Stream:errorCode	Lokhttp3/internal/http2/ErrorCode;
    //   80: invokespecial 165	okhttp3/internal/http2/StreamResetException:<init>	(Lokhttp3/internal/http2/ErrorCode;)V
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: getfield 58	okhttp3/internal/http2/Http2Stream:readTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
    //   90: invokevirtual 233	okhttp3/internal/http2/Http2Stream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	Http2Stream
    //   66	18	1	localObject1	Object
    //   85	9	1	localObject2	Object
    //   95	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	32	85	finally
    //   2	9	95	finally
    //   35	67	95	finally
    //   71	85	95	finally
    //   86	95	95	finally
  }
  
  void waitForIo()
    throws InterruptedIOException
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      throw new InterruptedIOException();
    }
  }
  
  public void writeHeaders(List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    Objects.requireNonNull(paramList, "headers == null");
    int i = 1;
    try
    {
      this.hasResponseHeaders = true;
      int j;
      if (!paramBoolean)
      {
        this.sink.finished = true;
        j = 1;
        paramBoolean = true;
      }
      else
      {
        j = 0;
        paramBoolean = false;
      }
      int k = j;
      if (j == 0) {
        synchronized (this.connection)
        {
          if (this.connection.bytesLeftInWriteWindow == 0L) {
            j = i;
          } else {
            j = 0;
          }
          k = j;
        }
      }
      this.connection.writeSynReply(this.id, paramBoolean, paramList);
      if (k != 0) {
        this.connection.flush();
      }
      return;
    }
    finally {}
  }
  
  public Timeout writeTimeout()
  {
    return this.writeTimeout;
  }
  
  final class FramingSink
    implements Sink
  {
    private static final long EMIT_BUFFER_SIZE = 16384L;
    boolean closed;
    boolean finished;
    private final Buffer sendBuffer = new Buffer();
    
    FramingSink() {}
    
    private void emitFrame(boolean paramBoolean)
      throws IOException
    {
      synchronized (Http2Stream.this)
      {
        Http2Stream.this.writeTimeout.enter();
        try
        {
          for (;;)
          {
            localObject2 = Http2Stream.this;
            if ((((Http2Stream)localObject2).bytesLeftInWriteWindow > 0L) || (this.finished) || (this.closed) || (((Http2Stream)localObject2).errorCode != null)) {
              break;
            }
            ((Http2Stream)localObject2).waitForIo();
          }
          ((Http2Stream)localObject2).writeTimeout.exitAndThrowIfTimedOut();
          Http2Stream.this.checkOutNotClosed();
          long l = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
          Object localObject2 = Http2Stream.this;
          ((Http2Stream)localObject2).bytesLeftInWriteWindow -= l;
          ((Http2Stream)localObject2).writeTimeout.enter();
          try
          {
            ??? = Http2Stream.this;
            localObject2 = ???.connection;
            int i = ???.id;
            if ((paramBoolean) && (l == this.sendBuffer.size())) {
              paramBoolean = true;
            } else {
              paramBoolean = false;
            }
            ((Http2Connection)localObject2).writeData(i, paramBoolean, this.sendBuffer, l);
            return;
          }
          finally
          {
            Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
          }
          localObject4 = finally;
        }
        finally
        {
          Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
        }
      }
    }
    
    public void close()
      throws IOException
    {
      synchronized (Http2Stream.this)
      {
        if (this.closed) {
          return;
        }
        if (!Http2Stream.this.sink.finished)
        {
          if (this.sendBuffer.size() > 0L) {
            while (this.sendBuffer.size() > 0L) {
              emitFrame(true);
            }
          }
          Http2Stream localHttp2Stream2 = Http2Stream.this;
          localHttp2Stream2.connection.writeData(localHttp2Stream2.id, true, null, 0L);
        }
        synchronized (Http2Stream.this)
        {
          this.closed = true;
          Http2Stream.this.connection.flush();
          Http2Stream.this.cancelStreamIfNecessary();
          return;
        }
      }
    }
    
    public void flush()
      throws IOException
    {
      synchronized (Http2Stream.this)
      {
        Http2Stream.this.checkOutNotClosed();
        while (this.sendBuffer.size() > 0L)
        {
          emitFrame(false);
          Http2Stream.this.connection.flush();
        }
        return;
      }
    }
    
    public Timeout timeout()
    {
      return Http2Stream.this.writeTimeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      this.sendBuffer.write(paramBuffer, paramLong);
      while (this.sendBuffer.size() >= 16384L) {
        emitFrame(false);
      }
    }
  }
  
  private final class FramingSource
    implements Source
  {
    boolean closed;
    boolean finished;
    private final long maxByteCount;
    private final Buffer readBuffer = new Buffer();
    private final Buffer receiveBuffer = new Buffer();
    
    FramingSource(long paramLong)
    {
      this.maxByteCount = paramLong;
    }
    
    private void updateConnectionFlowControl(long paramLong)
    {
      Http2Stream.this.connection.updateConnectionFlowControl(paramLong);
    }
    
    public void close()
      throws IOException
    {
      synchronized (Http2Stream.this)
      {
        this.closed = true;
        long l = this.readBuffer.size();
        this.readBuffer.clear();
        boolean bool = Http2Stream.this.headersQueue.isEmpty();
        Header.Listener localListener = null;
        Object localObject2;
        if ((!bool) && (Http2Stream.this.headersListener != null))
        {
          localObject2 = new java/util/ArrayList;
          ((ArrayList)localObject2).<init>(Http2Stream.this.headersQueue);
          Http2Stream.this.headersQueue.clear();
          localListener = Http2Stream.this.headersListener;
        }
        else
        {
          localObject2 = null;
        }
        Http2Stream.this.notifyAll();
        if (l > 0L) {
          updateConnectionFlowControl(l);
        }
        Http2Stream.this.cancelStreamIfNecessary();
        if (localListener != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            localListener.onHeaders((Headers)((Iterator)localObject2).next());
          }
        }
        return;
      }
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong >= 0L) {
        synchronized (Http2Stream.this)
        {
          for (;;)
          {
            Http2Stream.this.readTimeout.enter();
            try
            {
              Object localObject = Http2Stream.this;
              ErrorCode localErrorCode = ((Http2Stream)localObject).errorCode;
              if (localErrorCode == null) {
                localErrorCode = null;
              }
              if (!this.closed)
              {
                Header.Listener localListener;
                if ((!((Http2Stream)localObject).headersQueue.isEmpty()) && (Http2Stream.this.headersListener != null))
                {
                  localObject = (Headers)Http2Stream.this.headersQueue.removeFirst();
                  localListener = Http2Stream.this.headersListener;
                }
                else
                {
                  if (this.readBuffer.size() > 0L)
                  {
                    localObject = this.readBuffer;
                    l1 = ((Buffer)localObject).read(paramBuffer, Math.min(paramLong, ((Buffer)localObject).size()));
                    localObject = Http2Stream.this;
                    long l2 = ((Http2Stream)localObject).unacknowledgedBytesRead + l1;
                    ((Http2Stream)localObject).unacknowledgedBytesRead = l2;
                    if ((localErrorCode == null) && (l2 >= ((Http2Stream)localObject).connection.okHttpSettings.getInitialWindowSize() / 2))
                    {
                      localObject = Http2Stream.this;
                      ((Http2Stream)localObject).connection.writeWindowUpdateLater(((Http2Stream)localObject).id, ((Http2Stream)localObject).unacknowledgedBytesRead);
                      Http2Stream.this.unacknowledgedBytesRead = 0L;
                    }
                    localObject = null;
                    localListener = null;
                    break label278;
                  }
                  if ((!this.finished) && (localErrorCode == null))
                  {
                    Http2Stream.this.waitForIo();
                    Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                    continue;
                  }
                  localObject = null;
                  localListener = null;
                }
                long l1 = -1L;
                label278:
                Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                if ((localObject != null) && (localListener != null))
                {
                  localListener.onHeaders((Headers)localObject);
                }
                else
                {
                  if (l1 != -1L)
                  {
                    updateConnectionFlowControl(l1);
                    return l1;
                  }
                  if (localErrorCode == null) {
                    return -1L;
                  }
                  throw new StreamResetException(localErrorCode);
                }
              }
              else
              {
                paramBuffer = new java/io/IOException;
                paramBuffer.<init>("stream closed");
                throw paramBuffer;
              }
            }
            finally
            {
              Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
            }
          }
        }
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      throw new IllegalArgumentException(paramBuffer.toString());
    }
    
    void receive(BufferedSource paramBufferedSource, long paramLong)
      throws IOException
    {
      while (paramLong > 0L) {
        synchronized (Http2Stream.this)
        {
          boolean bool = this.finished;
          long l1 = this.readBuffer.size();
          long l2 = this.maxByteCount;
          int i = 1;
          int j;
          if (l1 + paramLong > l2) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0)
          {
            paramBufferedSource.skip(paramLong);
            Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
            return;
          }
          if (bool)
          {
            paramBufferedSource.skip(paramLong);
            return;
          }
          l1 = paramBufferedSource.read(this.receiveBuffer, paramLong);
          if (l1 != -1L)
          {
            l2 = paramLong - l1;
            synchronized (Http2Stream.this)
            {
              if (this.closed)
              {
                l1 = this.receiveBuffer.size();
                this.receiveBuffer.clear();
              }
              else
              {
                if (this.readBuffer.size() == 0L) {
                  j = i;
                } else {
                  j = 0;
                }
                this.readBuffer.writeAll(this.receiveBuffer);
                if (j != 0) {
                  Http2Stream.this.notifyAll();
                }
                l1 = 0L;
              }
              paramLong = l2;
              if (l1 <= 0L) {
                continue;
              }
              updateConnectionFlowControl(l1);
              paramLong = l2;
            }
          }
          throw new EOFException();
        }
      }
    }
    
    public Timeout timeout()
    {
      return Http2Stream.this.readTimeout;
    }
  }
  
  class StreamTimeout
    extends AsyncTimeout
  {
    StreamTimeout() {}
    
    public void exitAndThrowIfTimedOut()
      throws IOException
    {
      if (!exit()) {
        return;
      }
      throw newTimeoutException(null);
    }
    
    protected IOException newTimeoutException(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      return localSocketTimeoutException;
    }
    
    protected void timedOut()
    {
      Http2Stream.this.closeLater(ErrorCode.CANCEL);
      Http2Stream.this.connection.sendDegradedPingLater();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\http2\Http2Stream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */