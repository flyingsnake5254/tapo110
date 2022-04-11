package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class UnpooledUnsafeDirectByteBuf
  extends UnpooledDirectByteBuf
{
  long memoryAddress;
  
  public UnpooledUnsafeDirectByteBuf(ByteBufAllocator paramByteBufAllocator, int paramInt1, int paramInt2)
  {
    super(paramByteBufAllocator, paramInt1, paramInt2);
  }
  
  protected UnpooledUnsafeDirectByteBuf(ByteBufAllocator paramByteBufAllocator, ByteBuffer paramByteBuffer, int paramInt)
  {
    super(paramByteBufAllocator, paramByteBuffer, paramInt, false, true);
  }
  
  UnpooledUnsafeDirectByteBuf(ByteBufAllocator paramByteBufAllocator, ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean)
  {
    super(paramByteBufAllocator, paramByteBuffer, paramInt, paramBoolean, false);
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
    UnsafeByteBufUtil.setByte(addr(paramInt1), paramInt2);
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
  
  final long addr(int paramInt)
  {
    return this.memoryAddress + paramInt;
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    return UnsafeByteBufUtil.copy(this, addr(paramInt1), paramInt1, paramInt2);
  }
  
  public byte getByte(int paramInt)
  {
    checkIndex(paramInt);
    return _getByte(paramInt);
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    UnsafeByteBufUtil.getBytes(this, addr(paramInt1), paramInt1, paramByteBuf, paramInt2, paramInt3);
    return this;
  }
  
  void getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    UnsafeByteBufUtil.getBytes(this, addr(paramInt1), paramInt1, paramOutputStream, paramInt2);
  }
  
  void getBytes(int paramInt, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    UnsafeByteBufUtil.getBytes(this, addr(paramInt), paramInt, paramByteBuffer);
  }
  
  void getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    UnsafeByteBufUtil.getBytes(this, addr(paramInt1), paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public int getInt(int paramInt)
  {
    checkIndex(paramInt, 4);
    return _getInt(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    checkIndex(paramInt, 8);
    return _getLong(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    checkIndex(paramInt, 2);
    return _getShort(paramInt);
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    checkIndex(paramInt, 3);
    return _getUnsignedMedium(paramInt);
  }
  
  public boolean hasMemoryAddress()
  {
    return true;
  }
  
  public long memoryAddress()
  {
    ensureAccessible();
    return this.memoryAddress;
  }
  
  protected SwappedByteBuf newSwappedByteBuf()
  {
    if (PlatformDependent.isUnaligned()) {
      return new UnsafeDirectSwappedByteBuf(this);
    }
    return super.newSwappedByteBuf();
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1);
    _setByte(paramInt1, paramInt2);
    return this;
  }
  
  final void setByteBuffer(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    super.setByteBuffer(paramByteBuffer, paramBoolean);
    this.memoryAddress = PlatformDependent.directBufferAddress(paramByteBuffer);
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
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 4);
    _setInt(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    checkIndex(paramInt, 8);
    _setLong(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 3);
    _setMedium(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 2);
    _setShort(paramInt1, paramInt2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\UnpooledUnsafeDirectByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */