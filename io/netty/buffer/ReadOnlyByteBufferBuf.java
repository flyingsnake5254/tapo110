package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

class ReadOnlyByteBufferBuf
  extends AbstractReferenceCountedByteBuf
{
  private final ByteBufAllocator allocator;
  protected final ByteBuffer buffer;
  private ByteBuffer tmpNioBuf;
  
  ReadOnlyByteBufferBuf(ByteBufAllocator paramByteBufAllocator, ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer.remaining());
    if (paramByteBuffer.isReadOnly())
    {
      this.allocator = paramByteBufAllocator;
      paramByteBufAllocator = paramByteBuffer.slice().order(ByteOrder.BIG_ENDIAN);
      this.buffer = paramByteBufAllocator;
      writerIndex(paramByteBufAllocator.limit());
      return;
    }
    paramByteBufAllocator = new StringBuilder();
    paramByteBufAllocator.append("must be a readonly buffer: ");
    paramByteBufAllocator.append(StringUtil.simpleClassName(paramByteBuffer));
    throw new IllegalArgumentException(paramByteBufAllocator.toString());
  }
  
  protected byte _getByte(int paramInt)
  {
    return this.buffer.get(paramInt);
  }
  
  protected int _getInt(int paramInt)
  {
    return this.buffer.getInt(paramInt);
  }
  
  protected int _getIntLE(int paramInt)
  {
    return ByteBufUtil.swapInt(this.buffer.getInt(paramInt));
  }
  
  protected long _getLong(int paramInt)
  {
    return this.buffer.getLong(paramInt);
  }
  
  protected long _getLongLE(int paramInt)
  {
    return ByteBufUtil.swapLong(this.buffer.getLong(paramInt));
  }
  
  protected short _getShort(int paramInt)
  {
    return this.buffer.getShort(paramInt);
  }
  
  protected short _getShortLE(int paramInt)
  {
    return ByteBufUtil.swapShort(this.buffer.getShort(paramInt));
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    int i = getByte(paramInt);
    int j = getByte(paramInt + 1);
    return getByte(paramInt + 2) & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    int i = getByte(paramInt);
    int j = getByte(paramInt + 1);
    return (getByte(paramInt + 2) & 0xFF) << 16 | i & 0xFF | (j & 0xFF) << 8;
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBufAllocator alloc()
  {
    return this.allocator;
  }
  
  public byte[] array()
  {
    return this.buffer.array();
  }
  
  public int arrayOffset()
  {
    return this.buffer.arrayOffset();
  }
  
  public int capacity()
  {
    return maxCapacity();
  }
  
  public ByteBuf capacity(int paramInt)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)internalNioBuffer().clear().position(paramInt1).limit(paramInt1 + paramInt2);
      ByteBuf localByteBuf;
      if (localByteBuffer.isDirect()) {
        localByteBuf = alloc().directBuffer(paramInt2);
      } else {
        localByteBuf = alloc().heapBuffer(paramInt2);
      }
      localByteBuf.writeBytes(localByteBuffer);
      return localByteBuf;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Too many bytes to read - Need ");
      localStringBuilder.append(paramInt1 + paramInt2);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
  }
  
  protected void deallocate() {}
  
  public int ensureWritable(int paramInt, boolean paramBoolean)
  {
    return 1;
  }
  
  public ByteBuf ensureWritable(int paramInt)
  {
    throw new ReadOnlyBufferException();
  }
  
  public byte getByte(int paramInt)
  {
    ensureAccessible();
    return _getByte(paramInt);
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    ensureAccessible();
    if (paramInt2 == 0) {
      return 0;
    }
    ByteBuffer localByteBuffer = internalNioBuffer();
    localByteBuffer.clear().position(paramInt1).limit(paramInt1 + paramInt2);
    return paramFileChannel.write(localByteBuffer, paramLong);
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException
  {
    ensureAccessible();
    if (paramInt2 == 0) {
      return 0;
    }
    ByteBuffer localByteBuffer = internalNioBuffer();
    localByteBuffer.clear().position(paramInt1).limit(paramInt1 + paramInt2);
    return paramGatheringByteChannel.write(localByteBuffer);
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramByteBuf.capacity());
    if (paramByteBuf.hasArray())
    {
      getBytes(paramInt1, paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt2, paramInt3);
    }
    else
    {
      if (paramByteBuf.nioBufferCount() > 0) {
        for (ByteBuffer localByteBuffer : paramByteBuf.nioBuffers(paramInt2, paramInt3))
        {
          int i = localByteBuffer.remaining();
          getBytes(paramInt1, localByteBuffer);
          paramInt1 += i;
        }
      }
      paramByteBuf.setBytes(paramInt2, this, paramInt1, paramInt3);
    }
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    ensureAccessible();
    if (paramInt2 == 0) {
      return this;
    }
    if (this.buffer.hasArray())
    {
      paramOutputStream.write(this.buffer.array(), paramInt1 + this.buffer.arrayOffset(), paramInt2);
    }
    else
    {
      byte[] arrayOfByte = ByteBufUtil.threadLocalTempArray(paramInt2);
      ByteBuffer localByteBuffer = internalNioBuffer();
      localByteBuffer.clear().position(paramInt1);
      localByteBuffer.get(arrayOfByte, 0, paramInt2);
      paramOutputStream.write(arrayOfByte, 0, paramInt2);
    }
    return this;
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    checkIndex(paramInt, paramByteBuffer.remaining());
    ByteBuffer localByteBuffer = internalNioBuffer();
    localByteBuffer.clear().position(paramInt).limit(paramInt + paramByteBuffer.remaining());
    paramByteBuffer.put(localByteBuffer);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramArrayOfByte.length);
    ByteBuffer localByteBuffer = internalNioBuffer();
    localByteBuffer.clear().position(paramInt1).limit(paramInt1 + paramInt3);
    localByteBuffer.get(paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public int getInt(int paramInt)
  {
    ensureAccessible();
    return _getInt(paramInt);
  }
  
  public int getIntLE(int paramInt)
  {
    ensureAccessible();
    return _getIntLE(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    ensureAccessible();
    return _getLong(paramInt);
  }
  
  public long getLongLE(int paramInt)
  {
    ensureAccessible();
    return _getLongLE(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    ensureAccessible();
    return _getShort(paramInt);
  }
  
  public short getShortLE(int paramInt)
  {
    ensureAccessible();
    return _getShortLE(paramInt);
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    ensureAccessible();
    return _getUnsignedMedium(paramInt);
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    ensureAccessible();
    return _getUnsignedMediumLE(paramInt);
  }
  
  public boolean hasArray()
  {
    return this.buffer.hasArray();
  }
  
  public boolean hasMemoryAddress()
  {
    return false;
  }
  
  protected final ByteBuffer internalNioBuffer()
  {
    ByteBuffer localByteBuffer1 = this.tmpNioBuf;
    ByteBuffer localByteBuffer2 = localByteBuffer1;
    if (localByteBuffer1 == null)
    {
      localByteBuffer2 = this.buffer.duplicate();
      this.tmpNioBuf = localByteBuffer2;
    }
    return localByteBuffer2;
  }
  
  public ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    return (ByteBuffer)internalNioBuffer().clear().position(paramInt1).limit(paramInt1 + paramInt2);
  }
  
  public final boolean isContiguous()
  {
    return true;
  }
  
  public boolean isDirect()
  {
    return this.buffer.isDirect();
  }
  
  public boolean isReadOnly()
  {
    return this.buffer.isReadOnly();
  }
  
  public boolean isWritable()
  {
    return false;
  }
  
  public boolean isWritable(int paramInt)
  {
    return false;
  }
  
  public long memoryAddress()
  {
    throw new UnsupportedOperationException();
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return (ByteBuffer)this.buffer.duplicate().position(paramInt1).limit(paramInt1 + paramInt2);
  }
  
  public int nioBufferCount()
  {
    return 1;
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    return new ByteBuffer[] { nioBuffer(paramInt1, paramInt2) };
  }
  
  public ByteOrder order()
  {
    return ByteOrder.BIG_ENDIAN;
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    throw new ReadOnlyBufferException();
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    throw new ReadOnlyBufferException();
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
    throws IOException
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf unwrap()
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\ReadOnlyByteBufferBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */