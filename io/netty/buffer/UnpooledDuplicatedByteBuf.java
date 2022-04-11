package io.netty.buffer;

class UnpooledDuplicatedByteBuf
  extends DuplicatedByteBuf
{
  UnpooledDuplicatedByteBuf(AbstractByteBuf paramAbstractByteBuf)
  {
    super(paramAbstractByteBuf);
  }
  
  protected byte _getByte(int paramInt)
  {
    return unwrap()._getByte(paramInt);
  }
  
  protected int _getInt(int paramInt)
  {
    return unwrap()._getInt(paramInt);
  }
  
  protected int _getIntLE(int paramInt)
  {
    return unwrap()._getIntLE(paramInt);
  }
  
  protected long _getLong(int paramInt)
  {
    return unwrap()._getLong(paramInt);
  }
  
  protected long _getLongLE(int paramInt)
  {
    return unwrap()._getLongLE(paramInt);
  }
  
  protected short _getShort(int paramInt)
  {
    return unwrap()._getShort(paramInt);
  }
  
  protected short _getShortLE(int paramInt)
  {
    return unwrap()._getShortLE(paramInt);
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    return unwrap()._getUnsignedMedium(paramInt);
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    return unwrap()._getUnsignedMediumLE(paramInt);
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    unwrap()._setByte(paramInt1, paramInt2);
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    unwrap()._setInt(paramInt1, paramInt2);
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    unwrap()._setIntLE(paramInt1, paramInt2);
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    unwrap()._setLong(paramInt, paramLong);
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    unwrap()._setLongLE(paramInt, paramLong);
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    unwrap()._setMedium(paramInt1, paramInt2);
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    unwrap()._setMediumLE(paramInt1, paramInt2);
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    unwrap()._setShort(paramInt1, paramInt2);
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    unwrap()._setShortLE(paramInt1, paramInt2);
  }
  
  public AbstractByteBuf unwrap()
  {
    return (AbstractByteBuf)super.unwrap();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\UnpooledDuplicatedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */