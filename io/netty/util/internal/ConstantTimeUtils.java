package io.netty.util.internal;

public final class ConstantTimeUtils
{
  public static int equalsConstantTime(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt1 ^ paramInt2 ^ 0xFFFFFFFF;
    paramInt1 &= paramInt1 >> 16;
    paramInt1 &= paramInt1 >> 8;
    paramInt1 &= paramInt1 >> 4;
    paramInt1 &= paramInt1 >> 2;
    return paramInt1 & paramInt1 >> 1 & 0x1;
  }
  
  public static int equalsConstantTime(long paramLong1, long paramLong2)
  {
    paramLong1 = paramLong1 ^ paramLong2 ^ 0xFFFFFFFFFFFFFFFF;
    paramLong1 &= paramLong1 >> 32;
    paramLong1 &= paramLong1 >> 16;
    paramLong1 &= paramLong1 >> 8;
    paramLong1 &= paramLong1 >> 4;
    paramLong1 &= paramLong1 >> 2;
    return (int)(paramLong1 & paramLong1 >> 1 & 1L);
  }
  
  public static int equalsConstantTime(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1.length() != paramCharSequence2.length()) {
      return 0;
    }
    int i = 0;
    int j = 0;
    while (i < paramCharSequence1.length())
    {
      j |= paramCharSequence1.charAt(i) ^ paramCharSequence2.charAt(i);
      i++;
    }
    return equalsConstantTime(j, 0);
  }
  
  public static int equalsConstantTime(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    int i = 0;
    int j = paramInt2;
    paramInt2 = paramInt1;
    while (paramInt2 < paramInt3 + paramInt1)
    {
      i |= paramArrayOfByte1[paramInt2] ^ paramArrayOfByte2[j];
      paramInt2++;
      j++;
    }
    return equalsConstantTime(i, 0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\ConstantTimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */