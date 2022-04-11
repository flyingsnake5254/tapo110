package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1Codec
  implements HttpCodec
{
  private static final int HEADER_LIMIT = 262144;
  private static final int STATE_CLOSED = 6;
  private static final int STATE_IDLE = 0;
  private static final int STATE_OPEN_REQUEST_BODY = 1;
  private static final int STATE_OPEN_RESPONSE_BODY = 4;
  private static final int STATE_READING_RESPONSE_BODY = 5;
  private static final int STATE_READ_RESPONSE_HEADERS = 3;
  private static final int STATE_WRITING_REQUEST_BODY = 2;
  final OkHttpClient client;
  private long headerLimit = 262144L;
  final BufferedSink sink;
  final BufferedSource source;
  int state = 0;
  final StreamAllocation streamAllocation;
  
  public Http1Codec(OkHttpClient paramOkHttpClient, StreamAllocation paramStreamAllocation, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    this.client = paramOkHttpClient;
    this.streamAllocation = paramStreamAllocation;
    this.source = paramBufferedSource;
    this.sink = paramBufferedSink;
  }
  
  private String readHeaderLine()
    throws IOException
  {
    String str = this.source.readUtf8LineStrict(this.headerLimit);
    this.headerLimit -= str.length();
    return str;
  }
  
  public void cancel()
  {
    RealConnection localRealConnection = this.streamAllocation.connection();
    if (localRealConnection != null) {
      localRealConnection.cancel();
    }
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramRequest.header("Transfer-Encoding"))) {
      return newChunkedSink();
    }
    if (paramLong != -1L) {
      return newFixedLengthSink(paramLong);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  void detachTimeout(ForwardingTimeout paramForwardingTimeout)
  {
    Timeout localTimeout = paramForwardingTimeout.delegate();
    paramForwardingTimeout.setDelegate(Timeout.NONE);
    localTimeout.clearDeadline();
    localTimeout.clearTimeout();
  }
  
  public void finishRequest()
    throws IOException
  {
    this.sink.flush();
  }
  
  public void flushRequest()
    throws IOException
  {
    this.sink.flush();
  }
  
  public boolean isClosed()
  {
    boolean bool;
    if (this.state == 6) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Sink newChunkedSink()
  {
    if (this.state == 1)
    {
      this.state = 2;
      return new ChunkedSink();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.state);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public Source newChunkedSource(HttpUrl paramHttpUrl)
    throws IOException
  {
    if (this.state == 4)
    {
      this.state = 5;
      return new ChunkedSource(paramHttpUrl);
    }
    paramHttpUrl = new StringBuilder();
    paramHttpUrl.append("state: ");
    paramHttpUrl.append(this.state);
    throw new IllegalStateException(paramHttpUrl.toString());
  }
  
  public Sink newFixedLengthSink(long paramLong)
  {
    if (this.state == 1)
    {
      this.state = 2;
      return new FixedLengthSink(paramLong);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.state);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public Source newFixedLengthSource(long paramLong)
    throws IOException
  {
    if (this.state == 4)
    {
      this.state = 5;
      return new FixedLengthSource(paramLong);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.state);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public Source newUnknownLengthSource()
    throws IOException
  {
    if (this.state == 4)
    {
      localObject = this.streamAllocation;
      if (localObject != null)
      {
        this.state = 5;
        ((StreamAllocation)localObject).noNewStreams();
        return new UnknownLengthSource();
      }
      throw new IllegalStateException("streamAllocation == null");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("state: ");
    ((StringBuilder)localObject).append(this.state);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public ResponseBody openResponseBody(Response paramResponse)
    throws IOException
  {
    Object localObject = this.streamAllocation;
    ((StreamAllocation)localObject).eventListener.responseBodyStart(((StreamAllocation)localObject).call);
    localObject = paramResponse.header("Content-Type");
    if (!HttpHeaders.hasBody(paramResponse)) {
      return new RealResponseBody((String)localObject, 0L, Okio.buffer(newFixedLengthSource(0L)));
    }
    if ("chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"))) {
      return new RealResponseBody((String)localObject, -1L, Okio.buffer(newChunkedSource(paramResponse.request().url())));
    }
    long l = HttpHeaders.contentLength(paramResponse);
    if (l != -1L) {
      return new RealResponseBody((String)localObject, l, Okio.buffer(newFixedLengthSource(l)));
    }
    return new RealResponseBody((String)localObject, -1L, Okio.buffer(newUnknownLengthSource()));
  }
  
  public Headers readHeaders()
    throws IOException
  {
    Headers.Builder localBuilder = new Headers.Builder();
    for (;;)
    {
      String str = readHeaderLine();
      if (str.length() == 0) {
        break;
      }
      Internal.instance.addLenient(localBuilder, str);
    }
    return localBuilder.build();
  }
  
  public Response.Builder readResponseHeaders(boolean paramBoolean)
    throws IOException
  {
    int i = this.state;
    Object localObject1;
    if ((i != 1) && (i != 3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("state: ");
      ((StringBuilder)localObject1).append(this.state);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = StatusLine.parse(readHeaderLine());
      localObject2 = new okhttp3/Response$Builder;
      ((Response.Builder)localObject2).<init>();
      localObject2 = ((Response.Builder)localObject2).protocol(((StatusLine)localObject1).protocol).code(((StatusLine)localObject1).code).message(((StatusLine)localObject1).message).headers(readHeaders());
      if ((paramBoolean) && (((StatusLine)localObject1).code == 100)) {
        return null;
      }
      if (((StatusLine)localObject1).code == 100)
      {
        this.state = 3;
        return (Response.Builder)localObject2;
      }
      this.state = 4;
      return (Response.Builder)localObject2;
    }
    catch (EOFException localEOFException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("unexpected end of stream on ");
      ((StringBuilder)localObject2).append(this.streamAllocation);
      localObject2 = new IOException(((StringBuilder)localObject2).toString());
      ((IOException)localObject2).initCause(localEOFException);
      throw ((Throwable)localObject2);
    }
  }
  
  public void writeRequest(Headers paramHeaders, String paramString)
    throws IOException
  {
    if (this.state == 0)
    {
      this.sink.writeUtf8(paramString).writeUtf8("\r\n");
      int i = 0;
      int j = paramHeaders.size();
      while (i < j)
      {
        this.sink.writeUtf8(paramHeaders.name(i)).writeUtf8(": ").writeUtf8(paramHeaders.value(i)).writeUtf8("\r\n");
        i++;
      }
      this.sink.writeUtf8("\r\n");
      this.state = 1;
      return;
    }
    paramHeaders = new StringBuilder();
    paramHeaders.append("state: ");
    paramHeaders.append(this.state);
    throw new IllegalStateException(paramHeaders.toString());
  }
  
  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    String str = RequestLine.get(paramRequest, this.streamAllocation.connection().route().proxy().type());
    writeRequest(paramRequest.headers(), str);
  }
  
  private abstract class AbstractSource
    implements Source
  {
    protected long bytesRead = 0L;
    protected boolean closed;
    protected final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.source.timeout());
    
    private AbstractSource() {}
    
    protected final void endOfInput(boolean paramBoolean, IOException paramIOException)
      throws IOException
    {
      Http1Codec localHttp1Codec = Http1Codec.this;
      int i = localHttp1Codec.state;
      if (i == 6) {
        return;
      }
      if (i == 5)
      {
        localHttp1Codec.detachTimeout(this.timeout);
        localHttp1Codec = Http1Codec.this;
        localHttp1Codec.state = 6;
        StreamAllocation localStreamAllocation = localHttp1Codec.streamAllocation;
        if (localStreamAllocation != null) {
          localStreamAllocation.streamFinished(paramBoolean ^ true, localHttp1Codec, this.bytesRead, paramIOException);
        }
        return;
      }
      paramIOException = new StringBuilder();
      paramIOException.append("state: ");
      paramIOException.append(Http1Codec.this.state);
      throw new IllegalStateException(paramIOException.toString());
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      try
      {
        paramLong = Http1Codec.this.source.read(paramBuffer, paramLong);
        if (paramLong > 0L) {
          this.bytesRead += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramBuffer)
      {
        endOfInput(false, paramBuffer);
        throw paramBuffer;
      }
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
  }
  
  private final class ChunkedSink
    implements Sink
  {
    private boolean closed;
    private final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.sink.timeout());
    
    ChunkedSink() {}
    
    public void close()
      throws IOException
    {
      try
      {
        boolean bool = this.closed;
        if (bool) {
          return;
        }
        this.closed = true;
        Http1Codec.this.sink.writeUtf8("0\r\n\r\n");
        Http1Codec.this.detachTimeout(this.timeout);
        Http1Codec.this.state = 3;
        return;
      }
      finally {}
    }
    
    public void flush()
      throws IOException
    {
      try
      {
        boolean bool = this.closed;
        if (bool) {
          return;
        }
        Http1Codec.this.sink.flush();
        return;
      }
      finally {}
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (!this.closed)
      {
        if (paramLong == 0L) {
          return;
        }
        Http1Codec.this.sink.writeHexadecimalUnsignedLong(paramLong);
        Http1Codec.this.sink.writeUtf8("\r\n");
        Http1Codec.this.sink.write(paramBuffer, paramLong);
        Http1Codec.this.sink.writeUtf8("\r\n");
        return;
      }
      throw new IllegalStateException("closed");
    }
  }
  
  private class ChunkedSource
    extends Http1Codec.AbstractSource
  {
    private static final long NO_CHUNK_YET = -1L;
    private long bytesRemainingInChunk = -1L;
    private boolean hasMoreChunks = true;
    private final HttpUrl url;
    
    ChunkedSource(HttpUrl paramHttpUrl)
    {
      super(null);
      this.url = paramHttpUrl;
    }
    
    private void readChunkSize()
      throws IOException
    {
      if (this.bytesRemainingInChunk != -1L) {
        Http1Codec.this.source.readUtf8LineStrict();
      }
      try
      {
        this.bytesRemainingInChunk = Http1Codec.this.source.readHexadecimalUnsignedLong();
        String str = Http1Codec.this.source.readUtf8LineStrict().trim();
        if (this.bytesRemainingInChunk >= 0L) {
          if (!str.isEmpty())
          {
            boolean bool = str.startsWith(";");
            if (!bool) {}
          }
          else
          {
            if (this.bytesRemainingInChunk == 0L)
            {
              this.hasMoreChunks = false;
              HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.url, Http1Codec.this.readHeaders());
              endOfInput(true, null);
            }
            return;
          }
        }
        ProtocolException localProtocolException = new java/net/ProtocolException;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("expected chunk size and optional extensions but was \"");
        localStringBuilder.append(this.bytesRemainingInChunk);
        localStringBuilder.append(str);
        localStringBuilder.append("\"");
        localProtocolException.<init>(localStringBuilder.toString());
        throw localProtocolException;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException(localNumberFormatException.getMessage());
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      if ((this.hasMoreChunks) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
        endOfInput(false, null);
      }
      this.closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong >= 0L)
      {
        if (!this.closed)
        {
          if (!this.hasMoreChunks) {
            return -1L;
          }
          long l = this.bytesRemainingInChunk;
          if ((l == 0L) || (l == -1L))
          {
            readChunkSize();
            if (!this.hasMoreChunks) {
              return -1L;
            }
          }
          paramLong = super.read(paramBuffer, Math.min(paramLong, this.bytesRemainingInChunk));
          if (paramLong != -1L)
          {
            this.bytesRemainingInChunk -= paramLong;
            return paramLong;
          }
          paramBuffer = new ProtocolException("unexpected end of stream");
          endOfInput(false, paramBuffer);
          throw paramBuffer;
        }
        throw new IllegalStateException("closed");
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      throw new IllegalArgumentException(paramBuffer.toString());
    }
  }
  
  private final class FixedLengthSink
    implements Sink
  {
    private long bytesRemaining;
    private boolean closed;
    private final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.sink.timeout());
    
    FixedLengthSink(long paramLong)
    {
      this.bytesRemaining = paramLong;
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      this.closed = true;
      if (this.bytesRemaining <= 0L)
      {
        Http1Codec.this.detachTimeout(this.timeout);
        Http1Codec.this.state = 3;
        return;
      }
      throw new ProtocolException("unexpected end of stream");
    }
    
    public void flush()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      Http1Codec.this.sink.flush();
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (!this.closed)
      {
        Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
        if (paramLong <= this.bytesRemaining)
        {
          Http1Codec.this.sink.write(paramBuffer, paramLong);
          this.bytesRemaining -= paramLong;
          return;
        }
        paramBuffer = new StringBuilder();
        paramBuffer.append("expected ");
        paramBuffer.append(this.bytesRemaining);
        paramBuffer.append(" bytes but received ");
        paramBuffer.append(paramLong);
        throw new ProtocolException(paramBuffer.toString());
      }
      throw new IllegalStateException("closed");
    }
  }
  
  private class FixedLengthSource
    extends Http1Codec.AbstractSource
  {
    private long bytesRemaining;
    
    FixedLengthSource(long paramLong)
      throws IOException
    {
      super(null);
      this.bytesRemaining = paramLong;
      if (paramLong == 0L) {
        endOfInput(true, null);
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      if ((this.bytesRemaining != 0L) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
        endOfInput(false, null);
      }
      this.closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong >= 0L)
      {
        if (!this.closed)
        {
          long l = this.bytesRemaining;
          if (l == 0L) {
            return -1L;
          }
          l = super.read(paramBuffer, Math.min(l, paramLong));
          if (l != -1L)
          {
            paramLong = this.bytesRemaining - l;
            this.bytesRemaining = paramLong;
            if (paramLong == 0L) {
              endOfInput(true, null);
            }
            return l;
          }
          paramBuffer = new ProtocolException("unexpected end of stream");
          endOfInput(false, paramBuffer);
          throw paramBuffer;
        }
        throw new IllegalStateException("closed");
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      throw new IllegalArgumentException(paramBuffer.toString());
    }
  }
  
  private class UnknownLengthSource
    extends Http1Codec.AbstractSource
  {
    private boolean inputExhausted;
    
    UnknownLengthSource()
    {
      super(null);
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      if (!this.inputExhausted) {
        endOfInput(false, null);
      }
      this.closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong >= 0L)
      {
        if (!this.closed)
        {
          if (this.inputExhausted) {
            return -1L;
          }
          paramLong = super.read(paramBuffer, paramLong);
          if (paramLong == -1L)
          {
            this.inputExhausted = true;
            endOfInput(true, null);
            return -1L;
          }
          return paramLong;
        }
        throw new IllegalStateException("closed");
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      throw new IllegalArgumentException(paramBuffer.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\http1\Http1Codec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */