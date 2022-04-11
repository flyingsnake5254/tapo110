package b.d.w.e;

import java.nio.ByteOrder;

public class a
{
  public static int a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    return paramArrayOfByte[3] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public static short b(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    return (short)(paramArrayOfByte[1] & 0xFF | (i & 0xFF) << 8);
  }
  
  public static byte[] c(int paramInt)
  {
    if (ByteOrder.LITTLE_ENDIAN == ByteOrder.nativeOrder()) {
      return i(paramInt);
    }
    return k(paramInt);
  }
  
  public static byte[] d(short paramShort)
  {
    if (ByteOrder.LITTLE_ENDIAN == ByteOrder.nativeOrder()) {
      return j(paramShort);
    }
    return l(paramShort);
  }
  
  public static int e(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    return (paramArrayOfByte[3] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public static short f(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    return (short)((paramArrayOfByte[1] & 0xFF) << 8 | i & 0xFF);
  }
  
  public static int g(byte[] paramArrayOfByte)
  {
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
      return e(paramArrayOfByte);
    }
    return a(paramArrayOfByte);
  }
  
  public static short h(byte[] paramArrayOfByte)
  {
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
      return f(paramArrayOfByte);
    }
    return b(paramArrayOfByte);
  }
  
  public static byte[] i(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), k, j, i };
  }
  
  public static byte[] j(short paramShort)
  {
    int i = (byte)(paramShort & 0xFF);
    return new byte[] { (byte)(paramShort >> 8 & 0xFF), i };
  }
  
  public static byte[] k(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 24 & 0xFF) };
  }
  
  public static byte[] l(short paramShort)
  {
    return new byte[] { (byte)(paramShort & 0xFF), (byte)(paramShort >> 8 & 0xFF) };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */