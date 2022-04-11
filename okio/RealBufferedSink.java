package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

final class RealBufferedSink
  implements BufferedSink
{
  public final Buffer buffer = new Buffer();
  boolean closed;
  public final Sink sink;
  
  RealBufferedSink(Sink paramSink)
  {
    Objects.requireNonNull(paramSink, "sink == null");
    this.sink = paramSink;
  }
  
  public Buffer buffer()
  {
    return this.buffer;
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	okio/RealBufferedSink:closed	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 24	okio/RealBufferedSink:buffer	Lokio/Buffer;
    //   14: astore_2
    //   15: aload_2
    //   16: getfield 45	okio/Buffer:size	J
    //   19: lstore_3
    //   20: aload_1
    //   21: astore 5
    //   23: lload_3
    //   24: lconst_0
    //   25: lcmp
    //   26: ifle +22 -> 48
    //   29: aload_0
    //   30: getfield 34	okio/RealBufferedSink:sink	Lokio/Sink;
    //   33: aload_2
    //   34: lload_3
    //   35: invokeinterface 51 4 0
    //   40: aload_1
    //   41: astore 5
    //   43: goto +5 -> 48
    //   46: astore 5
    //   48: aload_0
    //   49: getfield 34	okio/RealBufferedSink:sink	Lokio/Sink;
    //   52: invokeinterface 53 1 0
    //   57: aload 5
    //   59: astore_1
    //   60: goto +14 -> 74
    //   63: astore_2
    //   64: aload 5
    //   66: astore_1
    //   67: aload 5
    //   69: ifnonnull +5 -> 74
    //   72: aload_2
    //   73: astore_1
    //   74: aload_0
    //   75: iconst_1
    //   76: putfield 41	okio/RealBufferedSink:closed	Z
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokestatic 59	okio/Util:sneakyRethrow	(Ljava/lang/Throwable;)V
    //   87: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	RealBufferedSink
    //   9	75	1	localObject1	Object
    //   14	20	2	localBuffer	Buffer
    //   63	10	2	localObject2	Object
    //   19	16	3	l	long
    //   21	21	5	localObject3	Object
    //   46	22	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   10	20	46	finally
    //   29	40	46	finally
    //   48	57	63	finally
  }
  
  public BufferedSink emit()
    throws IOException
  {
    if (!this.closed)
    {
      long l = this.buffer.size();
      if (l > 0L) {
        this.sink.write(this.buffer, l);
      }
      return this;
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink emitCompleteSegments()
    throws IOException
  {
    if (!this.closed)
    {
      long l = this.buffer.completeSegmentByteCount();
      if (l > 0L) {
        this.sink.write(this.buffer, l);
      }
      return this;
    }
    throw new IllegalStateException("closed");
  }
  
  public void flush()
    throws IOException
  {
    if (!this.closed)
    {
      Buffer localBuffer = this.buffer;
      long l = localBuffer.size;
      if (l > 0L) {
        this.sink.write(localBuffer, l);
      }
      this.sink.flush();
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public boolean isOpen()
  {
    return this.closed ^ true;
  }
  
  public OutputStream outputStream()
  {
    new OutputStream()
    {
      public void close()
        throws IOException
      {
        RealBufferedSink.this.close();
      }
      
      public void flush()
        throws IOException
      {
        RealBufferedSink localRealBufferedSink = RealBufferedSink.this;
        if (!localRealBufferedSink.closed) {
          localRealBufferedSink.flush();
        }
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(RealBufferedSink.this);
        localStringBuilder.append(".outputStream()");
        return localStringBuilder.toString();
      }
      
      public void write(int paramAnonymousInt)
        throws IOException
      {
        RealBufferedSink localRealBufferedSink = RealBufferedSink.this;
        if (!localRealBufferedSink.closed)
        {
          localRealBufferedSink.buffer.writeByte((byte)paramAnonymousInt);
          RealBufferedSink.this.emitCompleteSegments();
          return;
        }
        throw new IOException("closed");
      }
      
      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        RealBufferedSink localRealBufferedSink = RealBufferedSink.this;
        if (!localRealBufferedSink.closed)
        {
          localRealBufferedSink.buffer.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          RealBufferedSink.this.emitCompleteSegments();
          return;
        }
        throw new IOException("closed");
      }
    };
  }
  
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(this.sink);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (!this.closed)
    {
      int i = this.buffer.write(paramByteBuffer);
      emitCompleteSegments();
      return i;
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink write(ByteString paramByteString)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.write(paramByteString);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink write(Source paramSource, long paramLong)
    throws IOException
  {
    while (paramLong > 0L)
    {
      long l = paramSource.read(this.buffer, paramLong);
      if (l != -1L)
      {
        paramLong -= l;
        emitCompleteSegments();
      }
      else
      {
        throw new EOFException();
      }
    }
    return this;
  }
  
  public BufferedSink write(byte[] paramArrayOfByte)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.write(paramArrayOfByte);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.write(paramArrayOfByte, paramInt1, paramInt2);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.write(paramBuffer, paramLong);
      emitCompleteSegments();
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public long writeAll(Source paramSource)
    throws IOException
  {
    if (paramSource != null)
    {
      long l1 = 0L;
      for (;;)
      {
        long l2 = paramSource.read(this.buffer, 8192L);
        if (l2 == -1L) {
          break;
        }
        l1 += l2;
        emitCompleteSegments();
      }
      return l1;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public BufferedSink writeByte(int paramInt)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeByte(paramInt);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeDecimalLong(long paramLong)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeDecimalLong(paramLong);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeHexadecimalUnsignedLong(long paramLong)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeHexadecimalUnsignedLong(paramLong);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeInt(int paramInt)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeInt(paramInt);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeIntLe(int paramInt)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeIntLe(paramInt);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeLong(long paramLong)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeLong(paramLong);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeLongLe(long paramLong)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeLongLe(paramLong);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeShort(int paramInt)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeShort(paramInt);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeShortLe(int paramInt)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeShortLe(paramInt);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeString(paramString, paramInt1, paramInt2, paramCharset);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeString(String paramString, Charset paramCharset)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeString(paramString, paramCharset);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeUtf8(String paramString)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeUtf8(paramString);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeUtf8(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeUtf8(paramString, paramInt1, paramInt2);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeUtf8CodePoint(int paramInt)
    throws IOException
  {
    if (!this.closed)
    {
      this.buffer.writeUtf8CodePoint(paramInt);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\RealBufferedSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */