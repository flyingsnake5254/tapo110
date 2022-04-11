package b.d.c0.m;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class b
{
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt & 0xFF);
    return localStringBuilder.toString();
  }
  
  public static char b(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte, 0, 2).order(ByteOrder.BIG_ENDIAN).getChar();
  }
  
  public static double c(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte, 0, 8).order(ByteOrder.BIG_ENDIAN).getDouble();
  }
  
  public static float d(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte, 0, 4).order(ByteOrder.BIG_ENDIAN).getFloat();
  }
  
  public static int e(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte, 0, 4).order(ByteOrder.BIG_ENDIAN).getInt();
  }
  
  public static long f(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte, 0, 8).order(ByteOrder.BIG_ENDIAN).getLong();
  }
  
  public static short g(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte, 0, 2).order(ByteOrder.BIG_ENDIAN).getShort();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c0\m\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */