package e.a.b.c;

import java.math.BigInteger;
import org.bouncycastle.util.f;

public abstract class d
{
  public static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = (paramArrayOfInt1[0] & 0xFFFFFFFF) + (paramArrayOfInt2[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[0] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + (paramArrayOfInt2[1] & 0xFFFFFFFF));
    paramArrayOfInt3[1] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) + (paramArrayOfInt2[2] & 0xFFFFFFFF));
    paramArrayOfInt3[2] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + (paramArrayOfInt2[3] & 0xFFFFFFFF));
    paramArrayOfInt3[3] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + (paramArrayOfInt2[4] & 0xFFFFFFFF));
    paramArrayOfInt3[4] = ((int)l);
    return (int)(l >>> 32);
  }
  
  public static int b(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = (paramArrayOfInt1[0] & 0xFFFFFFFF) + (paramArrayOfInt2[0] & 0xFFFFFFFF) + (paramArrayOfInt3[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[0] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + (paramArrayOfInt2[1] & 0xFFFFFFFF) + (paramArrayOfInt3[1] & 0xFFFFFFFF));
    paramArrayOfInt3[1] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) + (paramArrayOfInt2[2] & 0xFFFFFFFF) + (paramArrayOfInt3[2] & 0xFFFFFFFF));
    paramArrayOfInt3[2] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + (paramArrayOfInt2[3] & 0xFFFFFFFF) + (paramArrayOfInt3[3] & 0xFFFFFFFF));
    paramArrayOfInt3[3] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + (paramArrayOfInt2[4] & 0xFFFFFFFF) + (paramArrayOfInt3[4] & 0xFFFFFFFF));
    paramArrayOfInt3[4] = ((int)l);
    return (int)(l >>> 32);
  }
  
  public static void c(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    paramArrayOfInt2[(paramInt2 + 0)] = paramArrayOfInt1[(paramInt1 + 0)];
    paramArrayOfInt2[(paramInt2 + 1)] = paramArrayOfInt1[(paramInt1 + 1)];
    paramArrayOfInt2[(paramInt2 + 2)] = paramArrayOfInt1[(paramInt1 + 2)];
    paramArrayOfInt2[(paramInt2 + 3)] = paramArrayOfInt1[(paramInt1 + 3)];
    paramArrayOfInt2[(paramInt2 + 4)] = paramArrayOfInt1[(paramInt1 + 4)];
  }
  
  public static int[] d()
  {
    return new int[5];
  }
  
  public static int[] e()
  {
    return new int[10];
  }
  
  public static boolean f(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    for (int i = 4; i >= 0; i--) {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
    }
    return true;
  }
  
  public static int[] g(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 160))
    {
      int[] arrayOfInt = d();
      for (int i = 0; paramBigInteger.signum() != 0; i++)
      {
        arrayOfInt[i] = paramBigInteger.intValue();
        paramBigInteger = paramBigInteger.shiftRight(32);
      }
      return arrayOfInt;
    }
    throw new IllegalArgumentException();
  }
  
  public static int h(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0) {}
    int i;
    for (paramInt = paramArrayOfInt[0];; paramInt = paramArrayOfInt[i] >>> (paramInt & 0x1F))
    {
      return paramInt & 0x1;
      i = paramInt >> 5;
      if ((i < 0) || (i >= 5)) {
        break;
      }
    }
    return 0;
  }
  
  public static boolean i(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    for (int i = 4; i >= 0; i--)
    {
      int j = paramArrayOfInt1[i] ^ 0x80000000;
      int k = 0x80000000 ^ paramArrayOfInt2[i];
      if (j < k) {
        return false;
      }
      if (j > k) {
        return true;
      }
    }
    return true;
  }
  
  public static boolean j(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] != 1) {
      return false;
    }
    for (int i = 1; i < 5; i++) {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean k(int[] paramArrayOfInt)
  {
    for (int i = 0; i < 5; i++) {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
    }
    return true;
  }
  
  public static void l(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l1 = paramArrayOfInt2[0] & 0xFFFFFFFF;
    int i = 1;
    long l2 = paramArrayOfInt2[1] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt2[2] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt2[3] & 0xFFFFFFFF;
    long l5 = paramArrayOfInt2[4] & 0xFFFFFFFF;
    long l6 = paramArrayOfInt1[0] & 0xFFFFFFFF;
    long l7 = l6 * l1 + 0L;
    paramArrayOfInt3[0] = ((int)l7);
    l7 = (l7 >>> 32) + l6 * l2;
    paramArrayOfInt3[1] = ((int)l7);
    l7 = (l7 >>> 32) + l6 * l3;
    paramArrayOfInt3[2] = ((int)l7);
    l7 = (l7 >>> 32) + l6 * l4;
    paramArrayOfInt3[3] = ((int)l7);
    l6 = (l7 >>> 32) + l6 * l5;
    paramArrayOfInt3[4] = ((int)l6);
    paramArrayOfInt3[5] = ((int)(l6 >>> 32));
    while (i < 5)
    {
      l6 = paramArrayOfInt1[i] & 0xFFFFFFFF;
      int j = i + 0;
      l7 = l6 * l1 + (paramArrayOfInt3[j] & 0xFFFFFFFF) + 0L;
      paramArrayOfInt3[j] = ((int)l7);
      j = i + 1;
      l7 = (l7 >>> 32) + (l6 * l2 + (paramArrayOfInt3[j] & 0xFFFFFFFF));
      paramArrayOfInt3[j] = ((int)l7);
      int k = i + 2;
      l7 = (l7 >>> 32) + (l6 * l3 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l7);
      k = i + 3;
      l7 = (l7 >>> 32) + (l6 * l4 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l7);
      k = i + 4;
      l6 = (l7 >>> 32) + (l6 * l5 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l6);
      paramArrayOfInt3[(i + 5)] = ((int)(l6 >>> 32));
      i = j;
    }
  }
  
  public static long m(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3, int[] paramArrayOfInt3, int paramInt4)
  {
    long l1 = paramInt1 & 0xFFFFFFFF;
    long l2 = paramArrayOfInt1[(paramInt2 + 0)] & 0xFFFFFFFF;
    long l3 = l1 * l2 + (paramArrayOfInt2[(paramInt3 + 0)] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[(paramInt4 + 0)] = ((int)l3);
    long l4 = paramArrayOfInt1[(paramInt2 + 1)] & 0xFFFFFFFF;
    l3 = (l3 >>> 32) + (l1 * l4 + l2 + (paramArrayOfInt2[(paramInt3 + 1)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 1)] = ((int)l3);
    l2 = paramArrayOfInt1[(paramInt2 + 2)] & 0xFFFFFFFF;
    l3 = (l3 >>> 32) + (l1 * l2 + l4 + (paramArrayOfInt2[(paramInt3 + 2)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 2)] = ((int)l3);
    l4 = paramArrayOfInt1[(paramInt2 + 3)] & 0xFFFFFFFF;
    l3 = (l3 >>> 32) + (l1 * l4 + l2 + (paramArrayOfInt2[(paramInt3 + 3)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 3)] = ((int)l3);
    l2 = paramArrayOfInt1[(paramInt2 + 4)] & 0xFFFFFFFF;
    l1 = (l3 >>> 32) + (l1 * l2 + l4 + (0xFFFFFFFF & paramArrayOfInt2[(paramInt3 + 4)]));
    paramArrayOfInt3[(paramInt4 + 4)] = ((int)l1);
    return (l1 >>> 32) + l2;
  }
  
  public static int n(int paramInt1, long paramLong, int[] paramArrayOfInt, int paramInt2)
  {
    long l1 = paramInt1 & 0xFFFFFFFF;
    long l2 = paramLong & 0xFFFFFFFF;
    paramInt1 = paramInt2 + 0;
    long l3 = l1 * l2 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt[paramInt1] = ((int)l3);
    paramLong >>>= 32;
    paramInt1 = paramInt2 + 1;
    l1 = (l3 >>> 32) + (l1 * paramLong + l2 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt[paramInt1] = ((int)l1);
    paramInt1 = paramInt2 + 2;
    paramLong = (l1 >>> 32) + (paramLong + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt[paramInt1] = ((int)paramLong);
    paramInt1 = paramInt2 + 3;
    paramLong = (paramLong >>> 32) + (0xFFFFFFFF & paramArrayOfInt[paramInt1]);
    paramArrayOfInt[paramInt1] = ((int)paramLong);
    if (paramLong >>> 32 == 0L) {
      paramInt1 = 0;
    } else {
      paramInt1 = m.u(5, paramArrayOfInt, paramInt2, 4);
    }
    return paramInt1;
  }
  
  public static int o(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    long l1 = paramInt1;
    long l2 = paramInt2 & 0xFFFFFFFF;
    paramInt1 = paramInt3 + 0;
    l1 = (l1 & 0xFFFFFFFF) * l2 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt[paramInt1] = ((int)l1);
    paramInt1 = paramInt3 + 1;
    l2 = (l1 >>> 32) + (l2 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt[paramInt1] = ((int)l2);
    paramInt1 = paramInt3 + 2;
    l2 = (l2 >>> 32) + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF);
    paramArrayOfInt[paramInt1] = ((int)l2);
    if (l2 >>> 32 == 0L) {
      paramInt1 = 0;
    } else {
      paramInt1 = m.u(5, paramArrayOfInt, paramInt3, 3);
    }
    return paramInt1;
  }
  
  public static int p(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int i = 0;
    long l1 = paramArrayOfInt2[0] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt2[1] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt2[2] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt2[3];
    long l5 = paramArrayOfInt2[4];
    long l6 = 0L;
    while (i < 5)
    {
      long l7 = paramArrayOfInt1[i] & 0xFFFFFFFF;
      int j = i + 0;
      long l8 = l7 * l1 + (paramArrayOfInt3[j] & 0xFFFFFFFF) + 0L;
      paramArrayOfInt3[j] = ((int)l8);
      j = i + 1;
      l8 = (l8 >>> 32) + (l7 * l2 + (paramArrayOfInt3[j] & 0xFFFFFFFF));
      paramArrayOfInt3[j] = ((int)l8);
      int k = i + 2;
      l8 = (l8 >>> 32) + (l7 * l3 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l8);
      k = i + 3;
      l8 = (l8 >>> 32) + (l7 * (l4 & 0xFFFFFFFF) + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l8);
      k = i + 4;
      l7 = (l8 >>> 32) + (l7 * (l5 & 0xFFFFFFFF) + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l7);
      i += 5;
      l6 = (l7 >>> 32) + (l6 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l6);
      l6 >>>= 32;
      i = j;
    }
    return (int)l6;
  }
  
  public static int q(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    long l1 = paramInt1;
    long l2 = paramInt2;
    paramInt1 = paramInt3 + 0;
    l2 = (l2 & 0xFFFFFFFF) * (l1 & 0xFFFFFFFF) + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt[paramInt1] = ((int)l2);
    paramInt1 = paramInt3 + 1;
    l2 = (l2 >>> 32) + (0xFFFFFFFF & paramArrayOfInt[paramInt1]);
    paramArrayOfInt[paramInt1] = ((int)l2);
    if (l2 >>> 32 == 0L) {
      paramInt1 = 0;
    } else {
      paramInt1 = m.u(5, paramArrayOfInt, paramInt3, 2);
    }
    return paramInt1;
  }
  
  public static void r(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l1 = paramArrayOfInt1[0] & 0xFFFFFFFF;
    int i = 10;
    int j = 4;
    int k = 0;
    for (;;)
    {
      int m = j - 1;
      long l2 = paramArrayOfInt1[j] & 0xFFFFFFFF;
      l2 *= l2;
      i--;
      paramArrayOfInt2[i] = (k << 31 | (int)(l2 >>> 33));
      i--;
      paramArrayOfInt2[i] = ((int)(l2 >>> 1));
      k = (int)l2;
      if (m <= 0)
      {
        long l3 = l1 * l1;
        long l4 = k << 31;
        paramArrayOfInt2[0] = ((int)l3);
        i = (int)(l3 >>> 32);
        l2 = paramArrayOfInt1[1] & 0xFFFFFFFF;
        long l5 = paramArrayOfInt2[2];
        long l6 = (l4 & 0xFFFFFFFF | l3 >>> 33) + l2 * l1;
        k = (int)l6;
        paramArrayOfInt2[1] = (k << 1 | i & 0x1);
        l3 = paramArrayOfInt1[2] & 0xFFFFFFFF;
        long l7 = paramArrayOfInt2[3];
        l4 = paramArrayOfInt2[4];
        l5 = (l5 & 0xFFFFFFFF) + (l6 >>> 32) + l3 * l1;
        i = (int)l5;
        paramArrayOfInt2[2] = (i << 1 | k >>> 31);
        long l8 = (l7 & 0xFFFFFFFF) + ((l5 >>> 32) + l3 * l2);
        l6 = (l4 & 0xFFFFFFFF) + (l8 >>> 32);
        l4 = paramArrayOfInt1[3] & 0xFFFFFFFF;
        l7 = (paramArrayOfInt2[5] & 0xFFFFFFFF) + (l6 >>> 32);
        l5 = paramArrayOfInt2[6];
        l8 = (l8 & 0xFFFFFFFF) + l4 * l1;
        k = (int)l8;
        paramArrayOfInt2[3] = (k << 1 | i >>> 31);
        long l9 = (l6 & 0xFFFFFFFF) + ((l8 >>> 32) + l4 * l2);
        l6 = (l7 & 0xFFFFFFFF) + ((l9 >>> 32) + l4 * l3);
        long l10 = (l5 & 0xFFFFFFFF) + (l7 >>> 32) + (l6 >>> 32);
        l8 = paramArrayOfInt1[4] & 0xFFFFFFFF;
        l5 = (paramArrayOfInt2[7] & 0xFFFFFFFF) + (l10 >>> 32);
        l7 = paramArrayOfInt2[8];
        l1 = (l9 & 0xFFFFFFFF) + l8 * l1;
        j = (int)l1;
        paramArrayOfInt2[4] = (k >>> 31 | j << 1);
        l1 = (l6 & 0xFFFFFFFF) + ((l1 >>> 32) + l2 * l8);
        l2 = (l10 & 0xFFFFFFFF) + ((l1 >>> 32) + l8 * l3);
        l3 = (0xFFFFFFFF & l5) + ((l2 >>> 32) + l8 * l4);
        l4 = (l7 & 0xFFFFFFFF) + (l5 >>> 32) + (l3 >>> 32);
        i = (int)l1;
        paramArrayOfInt2[5] = (j >>> 31 | i << 1);
        k = (int)l2;
        paramArrayOfInt2[6] = (k << 1 | i >>> 31);
        i = (int)l3;
        paramArrayOfInt2[7] = (k >>> 31 | i << 1);
        k = (int)l4;
        paramArrayOfInt2[8] = (i >>> 31 | k << 1);
        paramArrayOfInt2[9] = (k >>> 31 | paramArrayOfInt2[9] + (int)(l4 >>> 32) << 1);
        return;
      }
      j = m;
    }
  }
  
  public static int s(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = (paramArrayOfInt1[0] & 0xFFFFFFFF) - (paramArrayOfInt2[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[0] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) - (paramArrayOfInt2[1] & 0xFFFFFFFF));
    paramArrayOfInt3[1] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) - (paramArrayOfInt2[2] & 0xFFFFFFFF));
    paramArrayOfInt3[2] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) - (paramArrayOfInt2[3] & 0xFFFFFFFF));
    paramArrayOfInt3[3] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) - (paramArrayOfInt2[4] & 0xFFFFFFFF));
    paramArrayOfInt3[4] = ((int)l);
    return (int)(l >> 32);
  }
  
  public static int t(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l = (paramArrayOfInt2[0] & 0xFFFFFFFF) - (paramArrayOfInt1[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt2[0] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[1] & 0xFFFFFFFF) - (paramArrayOfInt1[1] & 0xFFFFFFFF));
    paramArrayOfInt2[1] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[2] & 0xFFFFFFFF) - (paramArrayOfInt1[2] & 0xFFFFFFFF));
    paramArrayOfInt2[2] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[3] & 0xFFFFFFFF) - (paramArrayOfInt1[3] & 0xFFFFFFFF));
    paramArrayOfInt2[3] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[4] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt1[4]));
    paramArrayOfInt2[4] = ((int)l);
    return (int)(l >> 32);
  }
  
  public static BigInteger u(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[20];
    for (int i = 0; i < 5; i++)
    {
      int j = paramArrayOfInt[i];
      if (j != 0) {
        f.d(j, arrayOfByte, 4 - i << 2);
      }
    }
    return new BigInteger(1, arrayOfByte);
  }
  
  public static void v(int[] paramArrayOfInt)
  {
    paramArrayOfInt[0] = 0;
    paramArrayOfInt[1] = 0;
    paramArrayOfInt[2] = 0;
    paramArrayOfInt[3] = 0;
    paramArrayOfInt[4] = 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */