package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

final class UnsafeDirectSwappedByteBuf
  extends AbstractUnsafeSwappedByteBuf
{
  UnsafeDirectSwappedByteBuf(AbstractByteBuf paramAbstractByteBuf)
  {
    super(paramAbstractByteBuf);
  }
  
  private static long addr(AbstractByteBuf paramAbstractByteBuf, int paramInt)
  {
    return paramAbstractByteBuf.memoryAddress() + paramInt;
  }
  
  protected int _getInt(AbstractByteBuf paramAbstractByteBuf, int paramInt)
  {
    return PlatformDependent.getInt(addr(paramAbstractByteBuf, paramInt));
  }
  
  protected long _getLong(AbstractByteBuf paramAbstractByteBuf, int paramInt)
  {
    return PlatformDependent.getLong(addr(paramAbstractByteBuf, paramInt));
  }
  
  protected short _getShort(AbstractByteBuf paramAbstractByteBuf, int paramInt)
  {
    return PlatformDependent.getShort(addr(paramAbstractByteBuf, paramInt));
  }
  
  protected void _setInt(AbstractByteBuf paramAbstractByteBuf, int paramInt1, int paramInt2)
  {
    PlatformDependent.putInt(addr(paramAbstractByteBuf, paramInt1), paramInt2);
  }
  
  protected void _setLong(AbstractByteBuf paramAbstractByteBuf, int paramInt, long paramLong)
  {
    PlatformDependent.putLong(addr(paramAbstractByteBuf, paramInt), paramLong);
  }
  
  protected void _setShort(AbstractByteBuf paramAbstractByteBuf, int paramInt, short paramShort)
  {
    PlatformDependent.putShort(addr(paramAbstractByteBuf, paramInt), paramShort);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\UnsafeDirectSwappedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */