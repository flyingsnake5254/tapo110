package okhttp3.internal.ws;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import okio.Buffer;
import okio.Buffer.UnsafeCursor;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

final class WebSocketWriter
{
  boolean activeWriter;
  final Buffer buffer = new Buffer();
  final FrameSink frameSink = new FrameSink();
  final boolean isClient;
  private final Buffer.UnsafeCursor maskCursor;
  private final byte[] maskKey;
  final Random random;
  final BufferedSink sink;
  final Buffer sinkBuffer;
  boolean writerClosed;
  
  WebSocketWriter(boolean paramBoolean, BufferedSink paramBufferedSink, Random paramRandom)
  {
    Objects.requireNonNull(paramBufferedSink, "sink == null");
    Objects.requireNonNull(paramRandom, "random == null");
    this.isClient = paramBoolean;
    this.sink = paramBufferedSink;
    this.sinkBuffer = paramBufferedSink.buffer();
    this.random = paramRandom;
    paramRandom = null;
    if (paramBoolean) {
      paramBufferedSink = new byte[4];
    } else {
      paramBufferedSink = null;
    }
    this.maskKey = paramBufferedSink;
    paramBufferedSink = paramRandom;
    if (paramBoolean) {
      paramBufferedSink = new Buffer.UnsafeCursor();
    }
    this.maskCursor = paramBufferedSink;
  }
  
  private void writeControlFrame(int paramInt, ByteString paramByteString)
    throws IOException
  {
    if (!this.writerClosed)
    {
      int i = paramByteString.size();
      if (i <= 125L)
      {
        this.sinkBuffer.writeByte(paramInt | 0x80);
        if (this.isClient)
        {
          this.sinkBuffer.writeByte(i | 0x80);
          this.random.nextBytes(this.maskKey);
          this.sinkBuffer.write(this.maskKey);
          if (i > 0)
          {
            long l = this.sinkBuffer.size();
            this.sinkBuffer.write(paramByteString);
            this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
            this.maskCursor.seek(l);
            WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
            this.maskCursor.close();
          }
        }
        else
        {
          this.sinkBuffer.writeByte(i);
          this.sinkBuffer.write(paramByteString);
        }
        this.sink.flush();
        return;
      }
      throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    }
    throw new IOException("closed");
  }
  
  Sink newMessageSink(int paramInt, long paramLong)
  {
    if (!this.activeWriter)
    {
      this.activeWriter = true;
      FrameSink localFrameSink = this.frameSink;
      localFrameSink.formatOpcode = paramInt;
      localFrameSink.contentLength = paramLong;
      localFrameSink.isFirstFrame = true;
      localFrameSink.closed = false;
      return localFrameSink;
    }
    throw new IllegalStateException("Another message writer is active. Did you call close()?");
  }
  
  void writeClose(int paramInt, ByteString paramByteString)
    throws IOException
  {
    Object localObject = ByteString.EMPTY;
    if ((paramInt != 0) || (paramByteString != null))
    {
      if (paramInt != 0) {
        WebSocketProtocol.validateCloseCode(paramInt);
      }
      localObject = new Buffer();
      ((Buffer)localObject).writeShort(paramInt);
      if (paramByteString != null) {
        ((Buffer)localObject).write(paramByteString);
      }
      localObject = ((Buffer)localObject).readByteString();
    }
    try
    {
      writeControlFrame(8, (ByteString)localObject);
      return;
    }
    finally
    {
      this.writerClosed = true;
    }
  }
  
  void writeMessageFrame(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    if (!this.writerClosed)
    {
      int i = 0;
      if (!paramBoolean1) {
        paramInt = 0;
      }
      int j = paramInt;
      if (paramBoolean2) {
        j = paramInt | 0x80;
      }
      this.sinkBuffer.writeByte(j);
      paramInt = i;
      if (this.isClient) {
        paramInt = 128;
      }
      if (paramLong <= 125L)
      {
        j = (int)paramLong;
        this.sinkBuffer.writeByte(j | paramInt);
      }
      else if (paramLong <= 65535L)
      {
        this.sinkBuffer.writeByte(paramInt | 0x7E);
        this.sinkBuffer.writeShort((int)paramLong);
      }
      else
      {
        this.sinkBuffer.writeByte(paramInt | 0x7F);
        this.sinkBuffer.writeLong(paramLong);
      }
      if (this.isClient)
      {
        this.random.nextBytes(this.maskKey);
        this.sinkBuffer.write(this.maskKey);
        if (paramLong > 0L)
        {
          long l = this.sinkBuffer.size();
          this.sinkBuffer.write(this.buffer, paramLong);
          this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
          this.maskCursor.seek(l);
          WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
          this.maskCursor.close();
        }
      }
      else
      {
        this.sinkBuffer.write(this.buffer, paramLong);
      }
      this.sink.emit();
      return;
    }
    throw new IOException("closed");
  }
  
  void writePing(ByteString paramByteString)
    throws IOException
  {
    writeControlFrame(9, paramByteString);
  }
  
  void writePong(ByteString paramByteString)
    throws IOException
  {
    writeControlFrame(10, paramByteString);
  }
  
  final class FrameSink
    implements Sink
  {
    boolean closed;
    long contentLength;
    int formatOpcode;
    boolean isFirstFrame;
    
    FrameSink() {}
    
    public void close()
      throws IOException
    {
      if (!this.closed)
      {
        WebSocketWriter localWebSocketWriter = WebSocketWriter.this;
        localWebSocketWriter.writeMessageFrame(this.formatOpcode, localWebSocketWriter.buffer.size(), this.isFirstFrame, true);
        this.closed = true;
        WebSocketWriter.this.activeWriter = false;
        return;
      }
      throw new IOException("closed");
    }
    
    public void flush()
      throws IOException
    {
      if (!this.closed)
      {
        WebSocketWriter localWebSocketWriter = WebSocketWriter.this;
        localWebSocketWriter.writeMessageFrame(this.formatOpcode, localWebSocketWriter.buffer.size(), this.isFirstFrame, false);
        this.isFirstFrame = false;
        return;
      }
      throw new IOException("closed");
    }
    
    public Timeout timeout()
    {
      return WebSocketWriter.this.sink.timeout();
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (!this.closed)
      {
        WebSocketWriter.this.buffer.write(paramBuffer, paramLong);
        int i;
        if ((this.isFirstFrame) && (this.contentLength != -1L) && (WebSocketWriter.this.buffer.size() > this.contentLength - 8192L)) {
          i = 1;
        } else {
          i = 0;
        }
        paramLong = WebSocketWriter.this.buffer.completeSegmentByteCount();
        if ((paramLong > 0L) && (i == 0))
        {
          WebSocketWriter.this.writeMessageFrame(this.formatOpcode, paramLong, this.isFirstFrame, false);
          this.isFirstFrame = false;
        }
        return;
      }
      throw new IOException("closed");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\ws\WebSocketWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */