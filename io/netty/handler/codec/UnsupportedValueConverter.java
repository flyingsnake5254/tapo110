package io.netty.handler.codec;

public final class UnsupportedValueConverter<V>
  implements ValueConverter<V>
{
  private static final UnsupportedValueConverter INSTANCE = new UnsupportedValueConverter();
  
  public static <V> UnsupportedValueConverter<V> instance()
  {
    return INSTANCE;
  }
  
  public V convertBoolean(boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  public V convertByte(byte paramByte)
  {
    throw new UnsupportedOperationException();
  }
  
  public V convertChar(char paramChar)
  {
    throw new UnsupportedOperationException();
  }
  
  public V convertDouble(double paramDouble)
  {
    throw new UnsupportedOperationException();
  }
  
  public V convertFloat(float paramFloat)
  {
    throw new UnsupportedOperationException();
  }
  
  public V convertInt(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public V convertLong(long paramLong)
  {
    throw new UnsupportedOperationException();
  }
  
  public V convertObject(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public V convertShort(short paramShort)
  {
    throw new UnsupportedOperationException();
  }
  
  public V convertTimeMillis(long paramLong)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean convertToBoolean(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public byte convertToByte(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public char convertToChar(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public double convertToDouble(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public float convertToFloat(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public int convertToInt(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public long convertToLong(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public short convertToShort(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public long convertToTimeMillis(V paramV)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\UnsupportedValueConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */