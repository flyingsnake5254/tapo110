package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;

final class RealBufferedSource
  implements BufferedSource
{
  public final Buffer buffer = new Buffer();
  boolean closed;
  public final Source source;
  
  RealBufferedSource(Source paramSource)
  {
    Objects.requireNonNull(paramSource, "source == null");
    this.source = paramSource;
  }
  
  public Buffer buffer()
  {
    return this.buffer;
  }
  
  public void close()
    throws IOException
  {
    if (this.closed) {
      return;
    }
    this.closed = true;
    this.source.close();
    this.buffer.clear();
  }
  
  public boolean exhausted()
    throws IOException
  {
    if (!this.closed)
    {
      boolean bool;
      if ((this.buffer.exhausted()) && (this.source.read(this.buffer, 8192L) == -1L)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    throw new IllegalStateException("closed");
  }
  
  public Buffer getBuffer()
  {
    return this.buffer;
  }
  
  public long indexOf(byte paramByte)
    throws IOException
  {
    return indexOf(paramByte, 0L, Long.MAX_VALUE);
  }
  
  public long indexOf(byte paramByte, long paramLong)
    throws IOException
  {
    return indexOf(paramByte, paramLong, Long.MAX_VALUE);
  }
  
  public long indexOf(byte paramByte, long paramLong1, long paramLong2)
    throws IOException
  {
    if (!this.closed)
    {
      if ((paramLong1 >= 0L) && (paramLong2 >= paramLong1))
      {
        while (paramLong1 < paramLong2)
        {
          long l = this.buffer.indexOf(paramByte, paramLong1, paramLong2);
          if (l != -1L) {
            return l;
          }
          Buffer localBuffer = this.buffer;
          l = localBuffer.size;
          if ((l >= paramLong2) || (this.source.read(localBuffer, 8192L) == -1L)) {
            break;
          }
          paramLong1 = Math.max(paramLong1, l);
        }
        return -1L;
      }
      throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    throw new IllegalStateException("closed");
  }
  
  public long indexOf(ByteString paramByteString)
    throws IOException
  {
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong)
    throws IOException
  {
    if (!this.closed) {
      for (;;)
      {
        long l = this.buffer.indexOf(paramByteString, paramLong);
        if (l != -1L) {
          return l;
        }
        Buffer localBuffer = this.buffer;
        l = localBuffer.size;
        if (this.source.read(localBuffer, 8192L) == -1L) {
          return -1L;
        }
        paramLong = Math.max(paramLong, l - paramByteString.size() + 1L);
      }
    }
    throw new IllegalStateException("closed");
  }
  
  public long indexOfElement(ByteString paramByteString)
    throws IOException
  {
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(ByteString paramByteString, long paramLong)
    throws IOException
  {
    if (!this.closed) {
      for (;;)
      {
        long l = this.buffer.indexOfElement(paramByteString, paramLong);
        if (l != -1L) {
          return l;
        }
        Buffer localBuffer = this.buffer;
        l = localBuffer.size;
        if (this.source.read(localBuffer, 8192L) == -1L) {
          return -1L;
        }
        paramLong = Math.max(paramLong, l);
      }
    }
    throw new IllegalStateException("closed");
  }
  
  public InputStream inputStream()
  {
    new InputStream()
    {
      public int available()
        throws IOException
      {
        RealBufferedSource localRealBufferedSource = RealBufferedSource.this;
        if (!localRealBufferedSource.closed) {
          return (int)Math.min(localRealBufferedSource.buffer.size, 2147483647L);
        }
        throw new IOException("closed");
      }
      
      public void close()
        throws IOException
      {
        RealBufferedSource.this.close();
      }
      
      public int read()
        throws IOException
      {
        RealBufferedSource localRealBufferedSource = RealBufferedSource.this;
        if (!localRealBufferedSource.closed)
        {
          Buffer localBuffer = localRealBufferedSource.buffer;
          if ((localBuffer.size == 0L) && (localRealBufferedSource.source.read(localBuffer, 8192L) == -1L)) {
            return -1;
          }
          return RealBufferedSource.this.buffer.readByte() & 0xFF;
        }
        throw new IOException("closed");
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        if (!RealBufferedSource.this.closed)
        {
          Util.checkOffsetAndCount(paramAnonymousArrayOfByte.length, paramAnonymousInt1, paramAnonymousInt2);
          RealBufferedSource localRealBufferedSource = RealBufferedSource.this;
          Buffer localBuffer = localRealBufferedSource.buffer;
          if ((localBuffer.size == 0L) && (localRealBufferedSource.source.read(localBuffer, 8192L) == -1L)) {
            return -1;
          }
          return RealBufferedSource.this.buffer.read(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        }
        throw new IOException("closed");
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(RealBufferedSource.this);
        localStringBuilder.append(".inputStream()");
        return localStringBuilder.toString();
      }
    };
  }
  
  public boolean isOpen()
  {
    return this.closed ^ true;
  }
  
  public BufferedSource peek()
  {
    return Okio.buffer(new PeekSource(this));
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString)
    throws IOException
  {
    return rangeEquals(paramLong, paramByteString, 0, paramByteString.size());
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.closed)
    {
      if ((paramLong >= 0L) && (paramInt1 >= 0) && (paramInt2 >= 0) && (paramByteString.size() - paramInt1 >= paramInt2))
      {
        for (int i = 0; i < paramInt2; i++)
        {
          long l = i + paramLong;
          if (!request(1L + l)) {
            return false;
          }
          if (this.buffer.getByte(l) != paramByteString.getByte(paramInt1 + i)) {
            return false;
          }
        }
        return true;
      }
      return false;
    }
    throw new IllegalStateException("closed");
  }
  
  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    Buffer localBuffer = this.buffer;
    if ((localBuffer.size == 0L) && (this.source.read(localBuffer, 8192L) == -1L)) {
      return -1;
    }
    return this.buffer.read(paramByteBuffer);
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    long l1 = paramArrayOfByte.length;
    long l2 = paramInt1;
    long l3 = paramInt2;
    Util.checkOffsetAndCount(l1, l2, l3);
    Buffer localBuffer = this.buffer;
    if ((localBuffer.size == 0L) && (this.source.read(localBuffer, 8192L) == -1L)) {
      return -1;
    }
    paramInt2 = (int)Math.min(l3, this.buffer.size);
    return this.buffer.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (paramBuffer != null)
    {
      if (paramLong >= 0L)
      {
        if (!this.closed)
        {
          Buffer localBuffer = this.buffer;
          if ((localBuffer.size == 0L) && (this.source.read(localBuffer, 8192L) == -1L)) {
            return -1L;
          }
          paramLong = Math.min(paramLong, this.buffer.size);
          return this.buffer.read(paramBuffer, paramLong);
        }
        throw new IllegalStateException("closed");
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      throw new IllegalArgumentException(paramBuffer.toString());
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public long readAll(Sink paramSink)
    throws IOException
  {
    if (paramSink != null)
    {
      long l1 = 0L;
      while (this.source.read(this.buffer, 8192L) != -1L)
      {
        l2 = this.buffer.completeSegmentByteCount();
        if (l2 > 0L)
        {
          l1 += l2;
          paramSink.write(this.buffer, l2);
        }
      }
      long l2 = l1;
      if (this.buffer.size() > 0L)
      {
        l2 = l1 + this.buffer.size();
        Buffer localBuffer = this.buffer;
        paramSink.write(localBuffer, localBuffer.size());
      }
      return l2;
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public byte readByte()
    throws IOException
  {
    require(1L);
    return this.buffer.readByte();
  }
  
  public byte[] readByteArray()
    throws IOException
  {
    this.buffer.writeAll(this.source);
    return this.buffer.readByteArray();
  }
  
  public byte[] readByteArray(long paramLong)
    throws IOException
  {
    require(paramLong);
    return this.buffer.readByteArray(paramLong);
  }
  
  public ByteString readByteString()
    throws IOException
  {
    this.buffer.writeAll(this.source);
    return this.buffer.readByteString();
  }
  
  public ByteString readByteString(long paramLong)
    throws IOException
  {
    require(paramLong);
    return this.buffer.readByteString(paramLong);
  }
  
  public long readDecimalLong()
    throws IOException
  {
    require(1L);
    int j;
    byte b;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (!request(j)) {
        break label91;
      }
      b = this.buffer.getByte(i);
      if (((b < 48) || (b > 57)) && ((i != 0) || (b != 45))) {
        break;
      }
    }
    if (i == 0) {
      throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[] { Byte.valueOf(b) }));
    }
    label91:
    return this.buffer.readDecimalLong();
  }
  
  public void readFully(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    try
    {
      require(paramLong);
      this.buffer.readFully(paramBuffer, paramLong);
      return;
    }
    catch (EOFException localEOFException)
    {
      paramBuffer.writeAll(this.buffer);
      throw localEOFException;
    }
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      require(paramArrayOfByte.length);
      this.buffer.readFully(paramArrayOfByte);
      return;
    }
    catch (EOFException localEOFException)
    {
      int i = 0;
      for (;;)
      {
        Buffer localBuffer = this.buffer;
        long l = localBuffer.size;
        if (l <= 0L) {
          break label73;
        }
        int j = localBuffer.read(paramArrayOfByte, i, (int)l);
        if (j == -1) {
          break;
        }
        i += j;
      }
      throw new AssertionError();
      label73:
      throw localEOFException;
    }
  }
  
  public long readHexadecimalUnsignedLong()
    throws IOException
  {
    require(1L);
    int j;
    byte b;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (!request(j)) {
        break label105;
      }
      b = this.buffer.getByte(i);
      if (((b < 48) || (b > 57)) && ((b < 97) || (b > 102)) && ((b < 65) || (b > 70))) {
        break;
      }
    }
    if (i == 0) {
      throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[] { Byte.valueOf(b) }));
    }
    label105:
    return this.buffer.readHexadecimalUnsignedLong();
  }
  
  public int readInt()
    throws IOException
  {
    require(4L);
    return this.buffer.readInt();
  }
  
  public int readIntLe()
    throws IOException
  {
    require(4L);
    return this.buffer.readIntLe();
  }
  
  public long readLong()
    throws IOException
  {
    require(8L);
    return this.buffer.readLong();
  }
  
  public long readLongLe()
    throws IOException
  {
    require(8L);
    return this.buffer.readLongLe();
  }
  
  public short readShort()
    throws IOException
  {
    require(2L);
    return this.buffer.readShort();
  }
  
  public short readShortLe()
    throws IOException
  {
    require(2L);
    return this.buffer.readShortLe();
  }
  
  public String readString(long paramLong, Charset paramCharset)
    throws IOException
  {
    require(paramLong);
    if (paramCharset != null) {
      return this.buffer.readString(paramLong, paramCharset);
    }
    throw new IllegalArgumentException("charset == null");
  }
  
  public String readString(Charset paramCharset)
    throws IOException
  {
    if (paramCharset != null)
    {
      this.buffer.writeAll(this.source);
      return this.buffer.readString(paramCharset);
    }
    throw new IllegalArgumentException("charset == null");
  }
  
  public String readUtf8()
    throws IOException
  {
    this.buffer.writeAll(this.source);
    return this.buffer.readUtf8();
  }
  
  public String readUtf8(long paramLong)
    throws IOException
  {
    require(paramLong);
    return this.buffer.readUtf8(paramLong);
  }
  
  public int readUtf8CodePoint()
    throws IOException
  {
    require(1L);
    int i = this.buffer.getByte(0L);
    if ((i & 0xE0) == 192) {
      require(2L);
    } else if ((i & 0xF0) == 224) {
      require(3L);
    } else if ((i & 0xF8) == 240) {
      require(4L);
    }
    return this.buffer.readUtf8CodePoint();
  }
  
  @Nullable
  public String readUtf8Line()
    throws IOException
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      l = this.buffer.size;
      String str;
      if (l != 0L) {
        str = readUtf8(l);
      } else {
        str = null;
      }
      return str;
    }
    return this.buffer.readUtf8Line(l);
  }
  
  public String readUtf8LineStrict()
    throws IOException
  {
    return readUtf8LineStrict(Long.MAX_VALUE);
  }
  
  public String readUtf8LineStrict(long paramLong)
    throws IOException
  {
    if (paramLong >= 0L)
    {
      long l1;
      if (paramLong == Long.MAX_VALUE) {
        l1 = Long.MAX_VALUE;
      } else {
        l1 = paramLong + 1L;
      }
      long l2 = indexOf((byte)10, 0L, l1);
      if (l2 != -1L) {
        return this.buffer.readUtf8Line(l2);
      }
      if ((l1 < Long.MAX_VALUE) && (request(l1)) && (this.buffer.getByte(l1 - 1L) == 13) && (request(1L + l1)) && (this.buffer.getByte(l1) == 10)) {
        return this.buffer.readUtf8Line(l1);
      }
      localObject1 = new Buffer();
      Object localObject2 = this.buffer;
      ((Buffer)localObject2).copyTo((Buffer)localObject1, 0L, Math.min(32L, ((Buffer)localObject2).size()));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("\\n not found: limit=");
      ((StringBuilder)localObject2).append(Math.min(this.buffer.size(), paramLong));
      ((StringBuilder)localObject2).append(" content=");
      ((StringBuilder)localObject2).append(((Buffer)localObject1).readByteString().hex());
      ((StringBuilder)localObject2).append('…');
      throw new EOFException(((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("limit < 0: ");
    ((StringBuilder)localObject1).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public boolean request(long paramLong)
    throws IOException
  {
    if (paramLong >= 0L)
    {
      if (!this.closed)
      {
        do
        {
          localObject = this.buffer;
          if (((Buffer)localObject).size >= paramLong) {
            break;
          }
        } while (this.source.read((Buffer)localObject, 8192L) != -1L);
        return false;
        return true;
      }
      throw new IllegalStateException("closed");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteCount < 0: ");
    ((StringBuilder)localObject).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void require(long paramLong)
    throws IOException
  {
    if (request(paramLong)) {
      return;
    }
    throw new EOFException();
  }
  
  public int select(Options paramOptions)
    throws IOException
  {
    if (!this.closed)
    {
      int i;
      do
      {
        i = this.buffer.selectPrefix(paramOptions, true);
        if (i == -1) {
          return -1;
        }
        if (i != -2) {
          break;
        }
      } while (this.source.read(this.buffer, 8192L) != -1L);
      return -1;
      int j = paramOptions.byteStrings[i].size();
      this.buffer.skip(j);
      return i;
    }
    throw new IllegalStateException("closed");
  }
  
  public void skip(long paramLong)
    throws IOException
  {
    if (!this.closed)
    {
      while (paramLong > 0L)
      {
        Buffer localBuffer = this.buffer;
        if ((localBuffer.size == 0L) && (this.source.read(localBuffer, 8192L) == -1L)) {
          throw new EOFException();
        }
        long l = Math.min(paramLong, this.buffer.size());
        this.buffer.skip(l);
        paramLong -= l;
      }
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(this.source);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\RealBufferedSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */