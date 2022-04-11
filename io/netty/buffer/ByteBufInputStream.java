package io.netty.buffer;

import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class ByteBufInputStream
  extends InputStream
  implements DataInput
{
  private final ByteBuf buffer;
  private boolean closed;
  private final int endIndex;
  private StringBuilder lineBuf;
  private final boolean releaseOnClose;
  private final int startIndex;
  
  public ByteBufInputStream(ByteBuf paramByteBuf)
  {
    this(paramByteBuf, paramByteBuf.readableBytes());
  }
  
  public ByteBufInputStream(ByteBuf paramByteBuf, int paramInt)
  {
    this(paramByteBuf, paramInt, false);
  }
  
  public ByteBufInputStream(ByteBuf paramByteBuf, int paramInt, boolean paramBoolean)
  {
    ObjectUtil.checkNotNull(paramByteBuf, "buffer");
    if (paramInt < 0)
    {
      if (paramBoolean) {
        paramByteBuf.release();
      }
      paramByteBuf = new StringBuilder();
      paramByteBuf.append("length: ");
      paramByteBuf.append(paramInt);
      throw new IllegalArgumentException(paramByteBuf.toString());
    }
    if (paramInt > paramByteBuf.readableBytes())
    {
      if (paramBoolean) {
        paramByteBuf.release();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Too many bytes to be read - Needs ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", maximum is ");
      localStringBuilder.append(paramByteBuf.readableBytes());
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    this.releaseOnClose = paramBoolean;
    this.buffer = paramByteBuf;
    int i = paramByteBuf.readerIndex();
    this.startIndex = i;
    this.endIndex = (i + paramInt);
    paramByteBuf.markReaderIndex();
  }
  
  public ByteBufInputStream(ByteBuf paramByteBuf, boolean paramBoolean)
  {
    this(paramByteBuf, paramByteBuf.readableBytes(), paramBoolean);
  }
  
  private void checkAvailable(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      if (paramInt <= available()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fieldSize is too long! Length is ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", but maximum is ");
      localStringBuilder.append(available());
      throw new EOFException(localStringBuilder.toString());
    }
    throw new IndexOutOfBoundsException("fieldSize cannot be a negative number");
  }
  
  public int available()
    throws IOException
  {
    return this.endIndex - this.buffer.readerIndex();
  }
  
  public void close()
    throws IOException
  {
    try
    {
      super.close();
      return;
    }
    finally
    {
      if ((this.releaseOnClose) && (!this.closed))
      {
        this.closed = true;
        this.buffer.release();
      }
    }
  }
  
  public void mark(int paramInt)
  {
    this.buffer.markReaderIndex();
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
    throws IOException
  {
    if (available() == 0) {
      return -1;
    }
    return this.buffer.readByte() & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = available();
    if (i == 0) {
      return -1;
    }
    paramInt2 = Math.min(i, paramInt2);
    this.buffer.readBytes(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  public boolean readBoolean()
    throws IOException
  {
    boolean bool = true;
    checkAvailable(1);
    if (read() == 0) {
      bool = false;
    }
    return bool;
  }
  
  public byte readByte()
    throws IOException
  {
    if (available() != 0) {
      return this.buffer.readByte();
    }
    throw new EOFException();
  }
  
  public int readBytes()
  {
    return this.buffer.readerIndex() - this.startIndex;
  }
  
  public char readChar()
    throws IOException
  {
    return (char)readShort();
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(readLong());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(readInt());
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws IOException
  {
    readFully(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    checkAvailable(paramInt2);
    this.buffer.readBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int readInt()
    throws IOException
  {
    checkAvailable(4);
    return this.buffer.readInt();
  }
  
  public String readLine()
    throws IOException
  {
    int i = available();
    if (i == 0) {
      return null;
    }
    Object localObject = this.lineBuf;
    int j = i;
    if (localObject != null)
    {
      ((StringBuilder)localObject).setLength(0);
      j = i;
    }
    do
    {
      int k = this.buffer.readUnsignedByte();
      i = j - 1;
      if (k == 10) {
        break label126;
      }
      if (k == 13) {
        break;
      }
      if (this.lineBuf == null) {
        this.lineBuf = new StringBuilder();
      }
      this.lineBuf.append((char)k);
      j = i;
    } while (i > 0);
    break label126;
    if (i > 0)
    {
      localObject = this.buffer;
      if ((char)((ByteBuf)localObject).getUnsignedByte(((ByteBuf)localObject).readerIndex()) == '\n') {
        this.buffer.skipBytes(1);
      }
    }
    label126:
    localObject = this.lineBuf;
    if ((localObject != null) && (((StringBuilder)localObject).length() > 0)) {
      localObject = this.lineBuf.toString();
    } else {
      localObject = "";
    }
    return (String)localObject;
  }
  
  public long readLong()
    throws IOException
  {
    checkAvailable(8);
    return this.buffer.readLong();
  }
  
  public short readShort()
    throws IOException
  {
    checkAvailable(2);
    return this.buffer.readShort();
  }
  
  public String readUTF()
    throws IOException
  {
    return DataInputStream.readUTF(this);
  }
  
  public int readUnsignedByte()
    throws IOException
  {
    return readByte() & 0xFF;
  }
  
  public int readUnsignedShort()
    throws IOException
  {
    return readShort() & 0xFFFF;
  }
  
  public void reset()
    throws IOException
  {
    this.buffer.resetReaderIndex();
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    if (paramLong > 2147483647L) {}
    for (int i = skipBytes(Integer.MAX_VALUE);; i = skipBytes((int)paramLong)) {
      return i;
    }
  }
  
  public int skipBytes(int paramInt)
    throws IOException
  {
    paramInt = Math.min(available(), paramInt);
    this.buffer.skipBytes(paramInt);
    return paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\ByteBufInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */