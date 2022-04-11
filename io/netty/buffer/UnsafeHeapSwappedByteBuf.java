package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

final class UnsafeHeapSwappedByteBuf
  extends AbstractUnsafeSwappedByteBuf
{
  UnsafeHeapSwappedByteBuf(AbstractByteBuf paramAbstractByteBuf)
  {
    super(paramAbstractByteBuf);
  }
  
  private static int idx(ByteBuf paramByteBuf, int paramInt)
  {
    return paramByteBuf.arrayOffset() + paramInt;
  }
  
  protected int _getInt(AbstractByteBuf paramAbstractByteBuf, int paramInt)
  {
    return PlatformDependent.getInt(paramAbstractByteBuf.array(), idx(paramAbstractByteBuf, paramInt));
  }
  
  protected long _getLong(AbstractByteBuf paramAbstractByteBuf, int paramInt)
  {
    return PlatformDependent.getLong(paramAbstractByteBuf.array(), idx(paramAbstractByteBuf, paramInt));
  }
  
  protected short _getShort(AbstractByteBuf paramAbstractByteBuf, int paramInt)
  {
    return PlatformDependent.getShort(paramAbstractByteBuf.array(), idx(paramAbstractByteBuf, paramInt));
  }
  
  protected void _setInt(AbstractByteBuf paramAbstractByteBuf, int paramInt1, int paramInt2)
  {
    PlatformDependent.putInt(paramAbstractByteBuf.array(), idx(paramAbstractByteBuf, paramInt1), paramInt2);
  }
  
  protected void _setLong(AbstractByteBuf paramAbstractByteBuf, int paramInt, long paramLong)
  {
    PlatformDependent.putLong(paramAbstractByteBuf.array(), idx(paramAbstractByteBuf, paramInt), paramLong);
  }
  
  protected void _setShort(AbstractByteBuf paramAbstractByteBuf, int paramInt, short paramShort)
  {
    PlatformDependent.putShort(paramAbstractByteBuf.array(), idx(paramAbstractByteBuf, paramInt), paramShort);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\UnsafeHeapSwappedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */