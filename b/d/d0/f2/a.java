package b.d.d0.f2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a
{
  public static byte[] a(int paramInt)
  {
    return ByteBuffer.allocate(4).putInt(paramInt).order(ByteOrder.BIG_ENDIAN).array();
  }
  
  public static byte[] b(short paramShort)
  {
    return ByteBuffer.allocate(2).putShort(paramShort).order(ByteOrder.BIG_ENDIAN).array();
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteBuffer.wrap(paramArrayOfByte, paramInt, 4).order(ByteOrder.BIG_ENDIAN).getInt();
  }
  
  public static short d(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteBuffer.wrap(paramArrayOfByte, paramInt, 2).order(ByteOrder.BIG_ENDIAN).getShort();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\f2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */