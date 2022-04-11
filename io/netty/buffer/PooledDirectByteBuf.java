package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

final class PooledDirectByteBuf
  extends PooledByteBuf<ByteBuffer>
{
  private static final ObjectPool<PooledDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
  {
    public PooledDirectByteBuf newObject(ObjectPool.Handle<PooledDirectByteBuf> paramAnonymousHandle)
    {
      return new PooledDirectByteBuf(paramAnonymousHandle, 0, null);
    }
  });
  
  private PooledDirectByteBuf(ObjectPool.Handle<PooledDirectByteBuf> paramHandle, int paramInt)
  {
    super(paramHandle, paramInt);
  }
  
  private void getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    checkIndex(paramInt1, paramInt2);
    if (paramInt2 == 0) {
      return;
    }
    ByteBufAllocator localByteBufAllocator = alloc();
    ByteBuffer localByteBuffer;
    if (paramBoolean) {
      localByteBuffer = internalNioBuffer();
    } else {
      localByteBuffer = ((ByteBuffer)this.memory).duplicate();
    }
    ByteBufUtil.readBytes(localByteBufAllocator, localByteBuffer, idx(paramInt1), paramInt2, paramOutputStream);
  }
  
  static PooledDirectByteBuf newInstance(int paramInt)
  {
    PooledDirectByteBuf localPooledDirectByteBuf = (PooledDirectByteBuf)RECYCLER.get();
    localPooledDirectByteBuf.reuse(paramInt);
    return localPooledDirectByteBuf;
  }
  
  protected byte _getByte(int paramInt)
  {
    return ((ByteBuffer)this.memory).get(idx(paramInt));
  }
  
  protected int _getInt(int paramInt)
  {
    return ((ByteBuffer)this.memory).getInt(idx(paramInt));
  }
  
  protected int _getIntLE(int paramInt)
  {
    return ByteBufUtil.swapInt(_getInt(paramInt));
  }
  
  protected long _getLong(int paramInt)
  {
    return ((ByteBuffer)this.memory).getLong(idx(paramInt));
  }
  
  protected long _getLongLE(int paramInt)
  {
    return ByteBufUtil.swapLong(_getLong(paramInt));
  }
  
  protected short _getShort(int paramInt)
  {
    return ((ByteBuffer)this.memory).getShort(idx(paramInt));
  }
  
  protected short _getShortLE(int paramInt)
  {
    return ByteBufUtil.swapShort(_getShort(paramInt));
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    int i = idx(paramInt);
    paramInt = ((ByteBuffer)this.memory).get(i);
    int j = ((ByteBuffer)this.memory).get(i + 1);
    return ((ByteBuffer)this.memory).get(i + 2) & 0xFF | (paramInt & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    paramInt = idx(paramInt);
    int i = ((ByteBuffer)this.memory).get(paramInt);
    int j = ((ByteBuffer)this.memory).get(paramInt + 1);
    return (((ByteBuffer)this.memory).get(paramInt + 2) & 0xFF) << 16 | i & 0xFF | (j & 0xFF) << 8;
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    ((ByteBuffer)this.memory).put(idx(paramInt1), (byte)paramInt2);
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    ((ByteBuffer)this.memory).putInt(idx(paramInt1), paramInt2);
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    _setInt(paramInt1, ByteBufUtil.swapInt(paramInt2));
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    ((ByteBuffer)this.memory).putLong(idx(paramInt), paramLong);
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    _setLong(paramInt, ByteBufUtil.swapLong(paramLong));
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    paramInt1 = idx(paramInt1);
    ((ByteBuffer)this.memory).put(paramInt1, (byte)(paramInt2 >>> 16));
    ((ByteBuffer)this.memory).put(paramInt1 + 1, (byte)(paramInt2 >>> 8));
    ((ByteBuffer)this.memory).put(paramInt1 + 2, (byte)paramInt2);
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    paramInt1 = idx(paramInt1);
    ((ByteBuffer)this.memory).put(paramInt1, (byte)paramInt2);
    ((ByteBuffer)this.memory).put(paramInt1 + 1, (byte)(paramInt2 >>> 8));
    ((ByteBuffer)this.memory).put(paramInt1 + 2, (byte)(paramInt2 >>> 16));
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    ((ByteBuffer)this.memory).putShort(idx(paramInt1), (short)paramInt2);
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    _setShort(paramInt1, ByteBufUtil.swapShort((short)paramInt2));
  }
  
  public byte[] array()
  {
    throw new UnsupportedOperationException("direct buffer");
  }
  
  public int arrayOffset()
  {
    throw new UnsupportedOperationException("direct buffer");
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return alloc().directBuffer(paramInt2, maxCapacity()).writeBytes(this, paramInt1, paramInt2);
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
        for (paramByteBuf : paramByteBuf.nioBuffers(paramInt2, paramInt3))
        {
          int i = paramByteBuf.remaining();
          getBytes(paramInt1, paramByteBuf);
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
    getBytes(paramInt1, paramOutputStream, paramInt2, false);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put(duplicateInternalNioBuffer(paramInt, paramByteBuffer.remaining()));
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramArrayOfByte.length);
    _internalNioBuffer(paramInt1, paramInt3, true).get(paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public boolean hasArray()
  {
    return false;
  }
  
  public boolean hasMemoryAddress()
  {
    return false;
  }
  
  public boolean isDirect()
  {
    return true;
  }
  
  public long memoryAddress()
  {
    throw new UnsupportedOperationException();
  }
  
  protected ByteBuffer newInternalNioBuffer(ByteBuffer paramByteBuffer)
  {
    return paramByteBuffer.duplicate();
  }
  
  public ByteBuf readBytes(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    checkReadableBytes(paramInt);
    getBytes(this.readerIndex, paramOutputStream, paramInt, true);
    this.readerIndex += paramInt;
    return this;
  }
  
  public ByteBuf readBytes(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    checkReadableBytes(i);
    paramByteBuffer.put(_internalNioBuffer(this.readerIndex, i, false));
    this.readerIndex += i;
    return this;
  }
  
  public ByteBuf readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    checkDstIndex(paramInt2, paramInt1, paramArrayOfByte.length);
    _internalNioBuffer(this.readerIndex, paramInt2, false).get(paramArrayOfByte, paramInt1, paramInt2);
    this.readerIndex += paramInt2;
    return this;
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    checkIndex(paramInt1, paramInt2);
    byte[] arrayOfByte = ByteBufUtil.threadLocalTempArray(paramInt2);
    paramInt2 = paramInputStream.read(arrayOfByte, 0, paramInt2);
    if (paramInt2 <= 0) {
      return paramInt2;
    }
    paramInputStream = internalNioBuffer();
    paramInputStream.position(idx(paramInt1));
    paramInputStream.put(arrayOfByte, 0, paramInt2);
    return paramInt2;
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkSrcIndex(paramInt1, paramInt3, paramInt2, paramByteBuf.capacity());
    if (paramByteBuf.hasArray())
    {
      setBytes(paramInt1, paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt2, paramInt3);
    }
    else
    {
      if (paramByteBuf.nioBufferCount() > 0) {
        for (ByteBuffer localByteBuffer : paramByteBuf.nioBuffers(paramInt2, paramInt3))
        {
          int i = localByteBuffer.remaining();
          setBytes(paramInt1, localByteBuffer);
          paramInt1 += i;
        }
      }
      paramByteBuf.getBytes(paramInt2, this, paramInt1, paramInt3);
    }
    return this;
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    checkIndex(paramInt, i);
    ByteBuffer localByteBuffer1 = internalNioBuffer();
    ByteBuffer localByteBuffer2 = paramByteBuffer;
    if (paramByteBuffer == localByteBuffer1) {
      localByteBuffer2 = paramByteBuffer.duplicate();
    }
    paramInt = idx(paramInt);
    localByteBuffer1.limit(i + paramInt).position(paramInt);
    localByteBuffer1.put(localByteBuffer2);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkSrcIndex(paramInt1, paramInt3, paramInt2, paramArrayOfByte.length);
    _internalNioBuffer(paramInt1, paramInt3, false).put(paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PooledDirectByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */