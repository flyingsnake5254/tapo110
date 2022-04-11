package io.netty.handler.codec;

public abstract interface ValueConverter<T>
{
  public abstract T convertBoolean(boolean paramBoolean);
  
  public abstract T convertByte(byte paramByte);
  
  public abstract T convertChar(char paramChar);
  
  public abstract T convertDouble(double paramDouble);
  
  public abstract T convertFloat(float paramFloat);
  
  public abstract T convertInt(int paramInt);
  
  public abstract T convertLong(long paramLong);
  
  public abstract T convertObject(Object paramObject);
  
  public abstract T convertShort(short paramShort);
  
  public abstract T convertTimeMillis(long paramLong);
  
  public abstract boolean convertToBoolean(T paramT);
  
  public abstract byte convertToByte(T paramT);
  
  public abstract char convertToChar(T paramT);
  
  public abstract double convertToDouble(T paramT);
  
  public abstract float convertToFloat(T paramT);
  
  public abstract int convertToInt(T paramT);
  
  public abstract long convertToLong(T paramT);
  
  public abstract short convertToShort(T paramT);
  
  public abstract long convertToTimeMillis(T paramT);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\ValueConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */