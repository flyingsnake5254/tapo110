package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

public class UnpooledUnsafeHeapByteBuf
  extends UnpooledHeapByteBuf
{
  public UnpooledUnsafeHeapByteBuf(ByteBufAllocator paramByteBufAllocator, int paramInt1, int paramInt2)
  {
    super(paramByteBufAllocator, paramInt1, paramInt2);
  }
  
  protected byte _getByte(int paramInt)
  {
    return UnsafeByteBufUtil.getByte(this.array, paramInt);
  }
  
  protected int _getInt(int paramInt)
  {
    return UnsafeByteBufUtil.getInt(this.array, paramInt);
  }
  
  protected int _getIntLE(int paramInt)
  {
    return UnsafeByteBufUtil.getIntLE(this.array, paramInt);
  }
  
  protected long _getLong(int paramInt)
  {
    return UnsafeByteBufUtil.getLong(this.array, paramInt);
  }
  
  protected long _getLongLE(int paramInt)
  {
    return UnsafeByteBufUtil.getLongLE(this.array, paramInt);
  }
  
  protected short _getShort(int paramInt)
  {
    return UnsafeByteBufUtil.getShort(this.array, paramInt);
  }
  
  protected short _getShortLE(int paramInt)
  {
    return UnsafeByteBufUtil.getShortLE(this.array, paramInt);
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    return UnsafeByteBufUtil.getUnsignedMedium(this.array, paramInt);
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    return UnsafeByteBufUtil.getUnsignedMediumLE(this.array, paramInt);
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setByte(this.array, paramInt1, paramInt2);
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setInt(this.array, paramInt1, paramInt2);
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setIntLE(this.array, paramInt1, paramInt2);
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    UnsafeByteBufUtil.setLong(this.array, paramInt, paramLong);
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    UnsafeByteBufUtil.setLongLE(this.array, paramInt, paramLong);
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setMedium(this.array, paramInt1, paramInt2);
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setMediumLE(this.array, paramInt1, paramInt2);
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setShort(this.array, paramInt1, paramInt2);
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setShortLE(this.array, paramInt1, paramInt2);
  }
  
  protected byte[] allocateArray(int paramInt)
  {
    return PlatformDependent.allocateUninitializedArray(paramInt);
  }
  
  public byte getByte(int paramInt)
  {
    checkIndex(paramInt);
    return _getByte(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    checkIndex(paramInt, 4);
    return _getInt(paramInt);
  }
  
  public int getIntLE(int paramInt)
  {
    checkIndex(paramInt, 4);
    return _getIntLE(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    checkIndex(paramInt, 8);
    return _getLong(paramInt);
  }
  
  public long getLongLE(int paramInt)
  {
    checkIndex(paramInt, 8);
    return _getLongLE(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    checkIndex(paramInt, 2);
    return _getShort(paramInt);
  }
  
  public short getShortLE(int paramInt)
  {
    checkIndex(paramInt, 2);
    return _getShortLE(paramInt);
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    checkIndex(paramInt, 3);
    return _getUnsignedMedium(paramInt);
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    checkIndex(paramInt, 3);
    return _getUnsignedMediumLE(paramInt);
  }
  
  @Deprecated
  protected SwappedByteBuf newSwappedByteBuf()
  {
    if (PlatformDependent.isUnaligned()) {
      return new UnsafeHeapSwappedByteBuf(this);
    }
    return super.newSwappedByteBuf();
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1);
    _setByte(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 4);
    _setInt(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 4);
    _setIntLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    checkIndex(paramInt, 8);
    _setLong(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    checkIndex(paramInt, 8);
    _setLongLE(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 3);
    _setMedium(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 3);
    _setMediumLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 2);
    _setShort(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 2);
    _setShortLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setZero(int paramInt1, int paramInt2)
  {
    if (PlatformDependent.javaVersion() >= 7)
    {
      checkIndex(paramInt1, paramInt2);
      UnsafeByteBufUtil.setZero(this.array, paramInt1, paramInt2);
      return this;
    }
    return super.setZero(paramInt1, paramInt2);
  }
  
  public ByteBuf writeZero(int paramInt)
  {
    if (PlatformDependent.javaVersion() >= 7)
    {
      ensureWritable(paramInt);
      int i = this.writerIndex;
      UnsafeByteBufUtil.setZero(this.array, i, paramInt);
      this.writerIndex = (i + paramInt);
      return this;
    }
    return super.writeZero(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\UnpooledUnsafeHeapByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */