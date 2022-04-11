package io.netty.buffer;

class UnpooledSlicedByteBuf
  extends AbstractUnpooledSlicedByteBuf
{
  UnpooledSlicedByteBuf(AbstractByteBuf paramAbstractByteBuf, int paramInt1, int paramInt2)
  {
    super(paramAbstractByteBuf, paramInt1, paramInt2);
  }
  
  protected byte _getByte(int paramInt)
  {
    return unwrap()._getByte(idx(paramInt));
  }
  
  protected int _getInt(int paramInt)
  {
    return unwrap()._getInt(idx(paramInt));
  }
  
  protected int _getIntLE(int paramInt)
  {
    return unwrap()._getIntLE(idx(paramInt));
  }
  
  protected long _getLong(int paramInt)
  {
    return unwrap()._getLong(idx(paramInt));
  }
  
  protected long _getLongLE(int paramInt)
  {
    return unwrap()._getLongLE(idx(paramInt));
  }
  
  protected short _getShort(int paramInt)
  {
    return unwrap()._getShort(idx(paramInt));
  }
  
  protected short _getShortLE(int paramInt)
  {
    return unwrap()._getShortLE(idx(paramInt));
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    return unwrap()._getUnsignedMedium(idx(paramInt));
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    return unwrap()._getUnsignedMediumLE(idx(paramInt));
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    unwrap()._setByte(idx(paramInt1), paramInt2);
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    unwrap()._setInt(idx(paramInt1), paramInt2);
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    unwrap()._setIntLE(idx(paramInt1), paramInt2);
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    unwrap()._setLong(idx(paramInt), paramLong);
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    unwrap()._setLongLE(idx(paramInt), paramLong);
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    unwrap()._setMedium(idx(paramInt1), paramInt2);
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    unwrap()._setMediumLE(idx(paramInt1), paramInt2);
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    unwrap()._setShort(idx(paramInt1), paramInt2);
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    unwrap()._setShortLE(idx(paramInt1), paramInt2);
  }
  
  public int capacity()
  {
    return maxCapacity();
  }
  
  public AbstractByteBuf unwrap()
  {
    return (AbstractByteBuf)super.unwrap();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\UnpooledSlicedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */