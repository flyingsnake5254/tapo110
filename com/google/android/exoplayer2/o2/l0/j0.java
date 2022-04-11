package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.util.d0;

public final class j0
{
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (paramArrayOfByte[paramInt1] != 71)) {
      paramInt1++;
    }
    return paramInt1;
  }
  
  public static boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = -4;
    int j = 0;
    while (i <= 4)
    {
      int k = i * 188 + paramInt3;
      if ((k >= paramInt1) && (k < paramInt2) && (paramArrayOfByte[k] == 71))
      {
        k = j + 1;
        j = k;
        if (k == 5) {
          return true;
        }
      }
      else
      {
        j = 0;
      }
      i++;
    }
    return false;
  }
  
  public static long c(d0 paramd0, int paramInt1, int paramInt2)
  {
    paramd0.P(paramInt1);
    if (paramd0.a() < 5) {
      return -9223372036854775807L;
    }
    paramInt1 = paramd0.n();
    if ((0x800000 & paramInt1) != 0) {
      return -9223372036854775807L;
    }
    if ((0x1FFF00 & paramInt1) >> 8 != paramInt2) {
      return -9223372036854775807L;
    }
    paramInt2 = 1;
    if ((paramInt1 & 0x20) != 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0) {
      return -9223372036854775807L;
    }
    if ((paramd0.D() >= 7) && (paramd0.a() >= 7))
    {
      if ((paramd0.D() & 0x10) == 16) {
        paramInt1 = paramInt2;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0)
      {
        byte[] arrayOfByte = new byte[6];
        paramd0.j(arrayOfByte, 0, 6);
        return d(arrayOfByte);
      }
    }
    return -9223372036854775807L;
  }
  
  private static long d(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) << 25 | (paramArrayOfByte[1] & 0xFF) << 17 | (paramArrayOfByte[2] & 0xFF) << 9 | (paramArrayOfByte[3] & 0xFF) << 1 | (0xFF & paramArrayOfByte[4]) >> 7;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\j0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */