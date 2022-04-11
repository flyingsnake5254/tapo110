package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;

abstract class AbstractUnsafeSwappedByteBuf
  extends SwappedByteBuf
{
  private final boolean nativeByteOrder;
  private final AbstractByteBuf wrapped;
  
  AbstractUnsafeSwappedByteBuf(AbstractByteBuf paramAbstractByteBuf)
  {
    super(paramAbstractByteBuf);
    this.wrapped = paramAbstractByteBuf;
    boolean bool1 = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER;
    ByteOrder localByteOrder = order();
    paramAbstractByteBuf = ByteOrder.BIG_ENDIAN;
    boolean bool2 = true;
    boolean bool3;
    if (localByteOrder == paramAbstractByteBuf) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    if (bool1 == bool3) {
      bool3 = bool2;
    } else {
      bool3 = false;
    }
    this.nativeByteOrder = bool3;
  }
  
  protected abstract int _getInt(AbstractByteBuf paramAbstractByteBuf, int paramInt);
  
  protected abstract long _getLong(AbstractByteBuf paramAbstractByteBuf, int paramInt);
  
  protected abstract short _getShort(AbstractByteBuf paramAbstractByteBuf, int paramInt);
  
  protected abstract void _setInt(AbstractByteBuf paramAbstractByteBuf, int paramInt1, int paramInt2);
  
  protected abstract void _setLong(AbstractByteBuf paramAbstractByteBuf, int paramInt, long paramLong);
  
  protected abstract void _setShort(AbstractByteBuf paramAbstractByteBuf, int paramInt, short paramShort);
  
  public final char getChar(int paramInt)
  {
    return (char)getShort(paramInt);
  }
  
  public final double getDouble(int paramInt)
  {
    return Double.longBitsToDouble(getLong(paramInt));
  }
  
  public final float getFloat(int paramInt)
  {
    return Float.intBitsToFloat(getInt(paramInt));
  }
  
  public final int getInt(int paramInt)
  {
    this.wrapped.checkIndex(paramInt, 4);
    paramInt = _getInt(this.wrapped, paramInt);
    if (!this.nativeByteOrder) {
      paramInt = Integer.reverseBytes(paramInt);
    }
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    this.wrapped.checkIndex(paramInt, 8);
    long l = _getLong(this.wrapped, paramInt);
    if (!this.nativeByteOrder) {
      l = Long.reverseBytes(l);
    }
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    this.wrapped.checkIndex(paramInt, 2);
    short s = _getShort(this.wrapped, paramInt);
    int i;
    if (!this.nativeByteOrder)
    {
      paramInt = Short.reverseBytes(s);
      i = paramInt;
    }
    return i;
  }
  
  public final long getUnsignedInt(int paramInt)
  {
    return getInt(paramInt) & 0xFFFFFFFF;
  }
  
  public final int getUnsignedShort(int paramInt)
  {
    return getShort(paramInt) & 0xFFFF;
  }
  
  public final ByteBuf setChar(int paramInt1, int paramInt2)
  {
    setShort(paramInt1, paramInt2);
    return this;
  }
  
  public final ByteBuf setDouble(int paramInt, double paramDouble)
  {
    setLong(paramInt, Double.doubleToRawLongBits(paramDouble));
    return this;
  }
  
  public final ByteBuf setFloat(int paramInt, float paramFloat)
  {
    setInt(paramInt, Float.floatToRawIntBits(paramFloat));
    return this;
  }
  
  public final ByteBuf setInt(int paramInt1, int paramInt2)
  {
    this.wrapped.checkIndex(paramInt1, 4);
    AbstractByteBuf localAbstractByteBuf = this.wrapped;
    if (!this.nativeByteOrder) {
      paramInt2 = Integer.reverseBytes(paramInt2);
    }
    _setInt(localAbstractByteBuf, paramInt1, paramInt2);
    return this;
  }
  
  public final ByteBuf setLong(int paramInt, long paramLong)
  {
    this.wrapped.checkIndex(paramInt, 8);
    AbstractByteBuf localAbstractByteBuf = this.wrapped;
    if (!this.nativeByteOrder) {
      paramLong = Long.reverseBytes(paramLong);
    }
    _setLong(localAbstractByteBuf, paramInt, paramLong);
    return this;
  }
  
  public final ByteBuf setShort(int paramInt1, int paramInt2)
  {
    this.wrapped.checkIndex(paramInt1, 2);
    AbstractByteBuf localAbstractByteBuf = this.wrapped;
    boolean bool = this.nativeByteOrder;
    short s = (short)paramInt2;
    int i;
    if (!bool)
    {
      paramInt2 = Short.reverseBytes(s);
      i = paramInt2;
    }
    _setShort(localAbstractByteBuf, paramInt1, i);
    return this;
  }
  
  public final ByteBuf writeChar(int paramInt)
  {
    writeShort(paramInt);
    return this;
  }
  
  public final ByteBuf writeDouble(double paramDouble)
  {
    writeLong(Double.doubleToRawLongBits(paramDouble));
    return this;
  }
  
  public final ByteBuf writeFloat(float paramFloat)
  {
    writeInt(Float.floatToRawIntBits(paramFloat));
    return this;
  }
  
  public final ByteBuf writeInt(int paramInt)
  {
    this.wrapped.ensureWritable0(4);
    AbstractByteBuf localAbstractByteBuf = this.wrapped;
    int i = localAbstractByteBuf.writerIndex;
    if (!this.nativeByteOrder) {
      paramInt = Integer.reverseBytes(paramInt);
    }
    _setInt(localAbstractByteBuf, i, paramInt);
    localAbstractByteBuf = this.wrapped;
    localAbstractByteBuf.writerIndex += 4;
    return this;
  }
  
  public final ByteBuf writeLong(long paramLong)
  {
    this.wrapped.ensureWritable0(8);
    AbstractByteBuf localAbstractByteBuf = this.wrapped;
    int i = localAbstractByteBuf.writerIndex;
    if (!this.nativeByteOrder) {
      paramLong = Long.reverseBytes(paramLong);
    }
    _setLong(localAbstractByteBuf, i, paramLong);
    localAbstractByteBuf = this.wrapped;
    localAbstractByteBuf.writerIndex += 8;
    return this;
  }
  
  public final ByteBuf writeShort(int paramInt)
  {
    this.wrapped.ensureWritable0(2);
    AbstractByteBuf localAbstractByteBuf = this.wrapped;
    int i = localAbstractByteBuf.writerIndex;
    boolean bool = this.nativeByteOrder;
    short s = (short)paramInt;
    int j;
    if (!bool)
    {
      paramInt = Short.reverseBytes(s);
      j = paramInt;
    }
    _setShort(localAbstractByteBuf, i, j);
    localAbstractByteBuf = this.wrapped;
    localAbstractByteBuf.writerIndex += 2;
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\AbstractUnsafeSwappedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */