package b.d.e;

public class c
{
  private static final short[] a = { 255, 511, 1023, 2047, 4095, 8191, 16383, 32767 };
  private static final short[] b = { 63, 127, 255, 511, 1023, 2047, 4095, 8191 };
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt << 1];
    for (int i = 0; i < paramInt; i++)
    {
      int j = c(paramArrayOfByte[i]);
      int k = i * 2;
      arrayOfByte[k] = ((byte)(byte)j);
      arrayOfByte[(k + 1)] = ((byte)(byte)(j >> 8));
    }
    return arrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt / 2;
    byte[] arrayOfByte = new byte[i];
    for (paramInt = 0; paramInt < i; paramInt++)
    {
      int j = paramInt * 2;
      int k = paramArrayOfByte[j];
      arrayOfByte[paramInt] = d((short)((paramArrayOfByte[(j + 1)] & 0xFF) << 8 | k & 0xFF));
    }
    return arrayOfByte;
  }
  
  private static short c(byte paramByte)
  {
    int i = (byte)(paramByte ^ 0x55);
    paramByte = (short)((i & 0xF) << 4);
    int j = (short)((i & 0x70) >> 4);
    if (j != 0)
    {
      if (j != 1) {
        paramByte = (short)(paramByte + 264) << j - 1;
      } else {
        paramByte += 264;
      }
    }
    else {
      paramByte += 8;
    }
    paramByte = (short)paramByte;
    short s;
    if ((i & 0x80) != 0)
    {
      s = paramByte;
    }
    else
    {
      paramByte = (short)-paramByte;
      s = paramByte;
    }
    return s;
  }
  
  private static byte d(short paramShort)
  {
    int i;
    int j;
    int k;
    if (paramShort >= 0)
    {
      i = 213;
      j = paramShort;
    }
    else
    {
      k = 85;
      paramShort = (short)(-paramShort - 1);
      i = k;
      j = paramShort;
      if (paramShort < 0)
      {
        paramShort = Short.MAX_VALUE;
        j = paramShort;
        i = k;
      }
    }
    paramShort = e(j, a, (short)8);
    if (paramShort >= 8) {}
    for (paramShort = i ^ 0x7F;; paramShort = (char)(paramShort & 0xF | k) ^ i)
    {
      return (byte)paramShort;
      k = (char)(paramShort << 4);
      if (paramShort < 2) {
        paramShort = j >> 4;
      } else {
        paramShort = j >> paramShort + 3;
      }
    }
  }
  
  private static short e(short paramShort1, short[] paramArrayOfShort, short paramShort2)
  {
    short s1 = 0;
    for (short s2 = s1; s2 < paramShort2; s2 = s1)
    {
      if (paramShort1 <= paramArrayOfShort[s2]) {
        return s2;
      }
      s1 = (short)(s2 + 1);
    }
    return paramShort2;
  }
  
  public static byte[] f(short[] paramArrayOfShort)
  {
    int i = paramArrayOfShort.length;
    byte[] arrayOfByte = new byte[i << 1];
    for (int j = 0; j < i; j++)
    {
      int k = j * 2;
      arrayOfByte[k] = ((byte)(byte)paramArrayOfShort[j]);
      arrayOfByte[(k + 1)] = ((byte)(byte)(paramArrayOfShort[j] >> 8));
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */