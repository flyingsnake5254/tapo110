package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

final class PooledUnsafeDirectByteBuf
  extends PooledByteBuf<ByteBuffer>
{
  private static final ObjectPool<PooledUnsafeDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
  {
    public PooledUnsafeDirectByteBuf newObject(ObjectPool.Handle<PooledUnsafeDirectByteBuf> paramAnonymousHandle)
    {
      return new PooledUnsafeDirectByteBuf(paramAnonymousHandle, 0, null);
    }
  });
  private long memoryAddress;
  
  private PooledUnsafeDirectByteBuf(ObjectPool.Handle<PooledUnsafeDirectByteBuf> paramHandle, int paramInt)
  {
    super(paramHandle, paramInt);
  }
  
  private long addr(int paramInt)
  {
    return this.memoryAddress + paramInt;
  }
  
  private void initMemoryAddress()
  {
    this.memoryAddress = (PlatformDependent.directBufferAddress((ByteBuffer)this.memory) + this.offset);
  }
  
  static PooledUnsafeDirectByteBuf newInstance(int paramInt)
  {
    PooledUnsafeDirectByteBuf localPooledUnsafeDirectByteBuf = (PooledUnsafeDirectByteBuf)RECYCLER.get();
    localPooledUnsafeDirectByteBuf.reuse(paramInt);
    return localPooledUnsafeDirectByteBuf;
  }
  
  protected byte _getByte(int paramInt)
  {
    return UnsafeByteBufUtil.getByte(addr(paramInt));
  }
  
  protected int _getInt(int paramInt)
  {
    return UnsafeByteBufUtil.getInt(addr(paramInt));
  }
  
  protected int _getIntLE(int paramInt)
  {
    return UnsafeByteBufUtil.getIntLE(addr(paramInt));
  }
  
  protected long _getLong(int paramInt)
  {
    return UnsafeByteBufUtil.getLong(addr(paramInt));
  }
  
  protected long _getLongLE(int paramInt)
  {
    return UnsafeByteBufUtil.getLongLE(addr(paramInt));
  }
  
  protected short _getShort(int paramInt)
  {
    return UnsafeByteBufUtil.getShort(addr(paramInt));
  }
  
  protected short _getShortLE(int paramInt)
  {
    return UnsafeByteBufUtil.getShortLE(addr(paramInt));
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    return UnsafeByteBufUtil.getUnsignedMedium(addr(paramInt));
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    return UnsafeByteBufUtil.getUnsignedMediumLE(addr(paramInt));
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setByte(addr(paramInt1), (byte)paramInt2);
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setInt(addr(paramInt1), paramInt2);
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setIntLE(addr(paramInt1), paramInt2);
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    UnsafeByteBufUtil.setLong(addr(paramInt), paramLong);
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    UnsafeByteBufUtil.setLongLE(addr(paramInt), paramLong);
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setMedium(addr(paramInt1), paramInt2);
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setMediumLE(addr(paramInt1), paramInt2);
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setShort(addr(paramInt1), paramInt2);
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setShortLE(addr(paramInt1), paramInt2);
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
    return UnsafeByteBufUtil.copy(this, addr(paramInt1), paramInt1, paramInt2);
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    UnsafeByteBufUtil.getBytes(this, addr(paramInt1), paramInt1, paramByteBuf, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    UnsafeByteBufUtil.getBytes(this, addr(paramInt1), paramInt1, paramOutputStream, paramInt2);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    UnsafeByteBufUtil.getBytes(this, addr(paramInt), paramInt, paramByteBuffer);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    UnsafeByteBufUtil.getBytes(this, addr(paramInt1), paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public boolean hasArray()
  {
    return false;
  }
  
  public boolean hasMemoryAddress()
  {
    return true;
  }
  
  void init(PoolChunk<ByteBuffer> paramPoolChunk, ByteBuffer paramByteBuffer, long paramLong, int paramInt1, int paramInt2, int paramInt3, PoolThreadCache paramPoolThreadCache)
  {
    super.init(paramPoolChunk, paramByteBuffer, paramLong, paramInt1, paramInt2, paramInt3, paramPoolThreadCache);
    initMemoryAddress();
  }
  
  void initUnpooled(PoolChunk<ByteBuffer> paramPoolChunk, int paramInt)
  {
    super.initUnpooled(paramPoolChunk, paramInt);
    initMemoryAddress();
  }
  
  public boolean isDirect()
  {
    return true;
  }
  
  public long memoryAddress()
  {
    ensureAccessible();
    return this.memoryAddress;
  }
  
  protected ByteBuffer newInternalNioBuffer(ByteBuffer paramByteBuffer)
  {
    return paramByteBuffer.duplicate();
  }
  
  protected SwappedByteBuf newSwappedByteBuf()
  {
    if (PlatformDependent.isUnaligned()) {
      return new UnsafeDirectSwappedByteBuf(this);
    }
    return super.newSwappedByteBuf();
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    return UnsafeByteBufUtil.setBytes(this, addr(paramInt1), paramInt1, paramInputStream, paramInt2);
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    UnsafeByteBufUtil.setBytes(this, addr(paramInt1), paramInt1, paramByteBuf, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    UnsafeByteBufUtil.setBytes(this, addr(paramInt), paramInt, paramByteBuffer);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    UnsafeByteBufUtil.setBytes(this, addr(paramInt1), paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf setZero(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    UnsafeByteBufUtil.setZero(addr(paramInt1), paramInt2);
    return this;
  }
  
  public ByteBuf writeZero(int paramInt)
  {
    ensureWritable(paramInt);
    int i = this.writerIndex;
    UnsafeByteBufUtil.setZero(addr(i), paramInt);
    this.writerIndex = (i + paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PooledUnsafeDirectByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */