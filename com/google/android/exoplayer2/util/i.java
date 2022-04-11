package com.google.android.exoplayer2.util;

import android.util.Pair;
import java.util.Collections;
import java.util.List;

public final class i
{
  private static final byte[] a = { 0, 0, 0, 1 };
  private static final String[] b = { "", "A", "B", "C" };
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    return String.format("avc1.%02X%02X%02X", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public static List<byte[]> b(boolean paramBoolean)
  {
    byte[] arrayOfByte;
    if (paramBoolean)
    {
      arrayOfByte = new byte[1];
      arrayOfByte[0] = ((byte)1);
    }
    else
    {
      arrayOfByte = new byte[1];
      arrayOfByte[0] = ((byte)0);
    }
    return Collections.singletonList(arrayOfByte);
  }
  
  public static String c(e0 parame0)
  {
    parame0.l(24);
    int i = parame0.e(2);
    boolean bool = parame0.d();
    int j = parame0.e(5);
    int k = 0;
    for (int m = 0; k < 32; m = n)
    {
      n = m;
      if (parame0.d()) {
        n = m | 1 << k;
      }
      k++;
    }
    int n = 6;
    int[] arrayOfInt = new int[6];
    for (k = 0; k < 6; k++) {
      arrayOfInt[k] = parame0.e(8);
    }
    k = parame0.e(8);
    parame0 = b[i];
    int i1;
    if (bool)
    {
      i = 72;
      i1 = i;
    }
    else
    {
      i = 76;
      i1 = i;
    }
    parame0 = new StringBuilder(o0.A("hvc1.%s%d.%X.%c%d", new Object[] { parame0, Integer.valueOf(j), Integer.valueOf(m), Character.valueOf(i1), Integer.valueOf(k) }));
    for (m = n; (m > 0) && (arrayOfInt[(m - 1)] == 0); m--) {}
    for (k = 0; k < m; k++) {
      parame0.append(String.format(".%02X", new Object[] { Integer.valueOf(arrayOfInt[k]) }));
    }
    return parame0.toString();
  }
  
  public static byte[] d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte1 = a;
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramInt2];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte2, arrayOfByte1.length, paramInt2);
    return arrayOfByte2;
  }
  
  public static Pair<Integer, Integer> e(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new d0(paramArrayOfByte);
    paramArrayOfByte.P(9);
    int i = paramArrayOfByte.D();
    paramArrayOfByte.P(20);
    return Pair.create(Integer.valueOf(paramArrayOfByte.H()), Integer.valueOf(i));
  }
  
  public static boolean f(List<byte[]> paramList)
  {
    int i = paramList.size();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i == 1)
    {
      bool2 = bool1;
      if (((byte[])paramList.get(0)).length == 1)
      {
        bool2 = bool1;
        if (((byte[])paramList.get(0))[0] == 1) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */