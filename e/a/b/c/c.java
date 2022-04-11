package e.a.b.c;

import java.math.BigInteger;
import org.bouncycastle.util.f;

public abstract class c
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
    return (int)(l >>> 32);
  }
  
  public static void c(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    paramArrayOfInt2[(paramInt2 + 0)] = paramArrayOfInt1[(paramInt1 + 0)];
    paramArrayOfInt2[(paramInt2 + 1)] = paramArrayOfInt1[(paramInt1 + 1)];
    paramArrayOfInt2[(paramInt2 + 2)] = paramArrayOfInt1[(paramInt1 + 2)];
    paramArrayOfInt2[(paramInt2 + 3)] = paramArrayOfInt1[(paramInt1 + 3)];
  }
  
  public static void d(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2)
  {
    paramArrayOfLong2[(paramInt2 + 0)] = paramArrayOfLong1[(paramInt1 + 0)];
    paramArrayOfLong2[(paramInt2 + 1)] = paramArrayOfLong1[(paramInt1 + 1)];
  }
  
  public static int[] e()
  {
    return new int[4];
  }
  
  public static long[] f()
  {
    return new long[2];
  }
  
  public static int[] g()
  {
    return new int[8];
  }
  
  public static long[] h()
  {
    return new long[4];
  }
  
  public static boolean i(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    for (int i = 3; i >= 0; i--) {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean j(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    for (int i = 1; i >= 0; i--) {
      if (paramArrayOfLong1[i] != paramArrayOfLong2[i]) {
        return false;
      }
    }
    return true;
  }
  
  public static int[] k(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 128))
    {
      int[] arrayOfInt = e();
      for (int i = 0; paramBigInteger.signum() != 0; i++)
      {
        arrayOfInt[i] = paramBigInteger.intValue();
        paramBigInteger = paramBigInteger.shiftRight(32);
      }
      return arrayOfInt;
    }
    throw new IllegalArgumentException();
  }
  
  public static long[] l(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 128))
    {
      long[] arrayOfLong = f();
      for (int i = 0; paramBigInteger.signum() != 0; i++)
      {
        arrayOfLong[i] = paramBigInteger.longValue();
        paramBigInteger = paramBigInteger.shiftRight(64);
      }
      return arrayOfLong;
    }
    throw new IllegalArgumentException();
  }
  
  public static int m(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0) {}
    int i;
    for (paramInt = paramArrayOfInt[0];; paramInt = paramArrayOfInt[i] >>> (paramInt & 0x1F))
    {
      return paramInt & 0x1;
      i = paramInt >> 5;
      if ((i < 0) || (i >= 4)) {
        break;
      }
    }
    return 0;
  }
  
  public static boolean n(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    for (int i = 3; i >= 0; i--)
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
  
  public static boolean o(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] != 1) {
      return false;
    }
    for (int i = 1; i < 4; i++) {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean p(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong[0] != 1L) {
      return false;
    }
    for (int i = 1; i < 2; i++) {
      if (paramArrayOfLong[i] != 0L) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean q(int[] paramArrayOfInt)
  {
    for (int i = 0; i < 4; i++) {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean r(long[] paramArrayOfLong)
  {
    for (int i = 0; i < 2; i++) {
      if (paramArrayOfLong[i] != 0L) {
        return false;
      }
    }
    return true;
  }
  
  public static void s(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l1 = paramArrayOfInt2[0] & 0xFFFFFFFF;
    int i = 1;
    long l2 = paramArrayOfInt2[1] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt2[2] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt2[3] & 0xFFFFFFFF;
    long l5 = paramArrayOfInt1[0] & 0xFFFFFFFF;
    long l6 = l5 * l1 + 0L;
    paramArrayOfInt3[0] = ((int)l6);
    l6 = (l6 >>> 32) + l5 * l2;
    paramArrayOfInt3[1] = ((int)l6);
    l6 = (l6 >>> 32) + l5 * l3;
    paramArrayOfInt3[2] = ((int)l6);
    l5 = (l6 >>> 32) + l5 * l4;
    paramArrayOfInt3[3] = ((int)l5);
    paramArrayOfInt3[4] = ((int)(l5 >>> 32));
    while (i < 4)
    {
      l5 = paramArrayOfInt1[i] & 0xFFFFFFFF;
      int j = i + 0;
      l6 = l5 * l1 + (paramArrayOfInt3[j] & 0xFFFFFFFF) + 0L;
      paramArrayOfInt3[j] = ((int)l6);
      j = i + 1;
      l6 = (l6 >>> 32) + (l5 * l2 + (paramArrayOfInt3[j] & 0xFFFFFFFF));
      paramArrayOfInt3[j] = ((int)l6);
      int k = i + 2;
      l6 = (l6 >>> 32) + (l5 * l3 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l6);
      k = i + 3;
      l5 = (l6 >>> 32) + (l5 * l4 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l5);
      paramArrayOfInt3[(i + 4)] = ((int)(l5 >>> 32));
      i = j;
    }
  }
  
  public static int t(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int i = 0;
    long l1 = paramArrayOfInt2[0] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt2[1] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt2[2];
    long l4 = paramArrayOfInt2[3];
    long l5 = 0L;
    while (i < 4)
    {
      long l6 = paramArrayOfInt1[i] & 0xFFFFFFFF;
      int j = i + 0;
      long l7 = l6 * l1 + (paramArrayOfInt3[j] & 0xFFFFFFFF) + 0L;
      paramArrayOfInt3[j] = ((int)l7);
      j = i + 1;
      l7 = (l7 >>> 32) + (l6 * l2 + (paramArrayOfInt3[j] & 0xFFFFFFFF));
      paramArrayOfInt3[j] = ((int)l7);
      int k = i + 2;
      l7 = (l7 >>> 32) + (l6 * (l3 & 0xFFFFFFFF) + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l7);
      k = i + 3;
      l6 = (l7 >>> 32) + (l6 * (l4 & 0xFFFFFFFF) + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l6);
      i += 4;
      l5 = (l6 >>> 32) + (l5 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l5);
      l5 >>>= 32;
      i = j;
    }
    return (int)l5;
  }
  
  public static void u(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l1 = paramArrayOfInt1[0] & 0xFFFFFFFF;
    int i = 8;
    int j = 3;
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
        l4 = paramArrayOfInt1[2] & 0xFFFFFFFF;
        long l7 = paramArrayOfInt2[3];
        l3 = paramArrayOfInt2[4];
        l5 = (l5 & 0xFFFFFFFF) + (l6 >>> 32) + l4 * l1;
        j = (int)l5;
        paramArrayOfInt2[2] = (j << 1 | k >>> 31);
        long l8 = (l7 & 0xFFFFFFFF) + ((l5 >>> 32) + l4 * l2);
        l6 = (l3 & 0xFFFFFFFF) + (l8 >>> 32);
        l7 = paramArrayOfInt1[3] & 0xFFFFFFFF;
        l5 = (paramArrayOfInt2[5] & 0xFFFFFFFF) + (l6 >>> 32);
        l3 = paramArrayOfInt2[6];
        l1 = (l8 & 0xFFFFFFFF) + l1 * l7;
        i = (int)l1;
        paramArrayOfInt2[3] = (i << 1 | j >>> 31);
        l1 = (l6 & 0xFFFFFFFF) + ((l1 >>> 32) + l2 * l7);
        l2 = (l5 & 0xFFFFFFFF) + ((l1 >>> 32) + l7 * l4);
        l4 = (l3 & 0xFFFFFFFF) + (l5 >>> 32) + (l2 >>> 32);
        k = (int)l1;
        paramArrayOfInt2[4] = (i >>> 31 | k << 1);
        i = (int)(l2 & 0xFFFFFFFF);
        paramArrayOfInt2[5] = (k >>> 31 | i << 1);
        k = (int)l4;
        paramArrayOfInt2[6] = (i >>> 31 | k << 1);
        paramArrayOfInt2[7] = (paramArrayOfInt2[7] + (int)(l4 >>> 32) << 1 | k >>> 31);
        return;
      }
      j = m;
    }
  }
  
  public static int v(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = (paramArrayOfInt1[0] & 0xFFFFFFFF) - (paramArrayOfInt2[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[0] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) - (paramArrayOfInt2[1] & 0xFFFFFFFF));
    paramArrayOfInt3[1] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) - (paramArrayOfInt2[2] & 0xFFFFFFFF));
    paramArrayOfInt3[2] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) - (paramArrayOfInt2[3] & 0xFFFFFFFF));
    paramArrayOfInt3[3] = ((int)l);
    return (int)(l >> 32);
  }
  
  public static int w(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l = (paramArrayOfInt2[0] & 0xFFFFFFFF) - (paramArrayOfInt1[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt2[0] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[1] & 0xFFFFFFFF) - (paramArrayOfInt1[1] & 0xFFFFFFFF));
    paramArrayOfInt2[1] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[2] & 0xFFFFFFFF) - (paramArrayOfInt1[2] & 0xFFFFFFFF));
    paramArrayOfInt2[2] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[3] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt1[3]));
    paramArrayOfInt2[3] = ((int)l);
    return (int)(l >> 32);
  }
  
  public static BigInteger x(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[16];
    for (int i = 0; i < 4; i++)
    {
      int j = paramArrayOfInt[i];
      if (j != 0) {
        f.d(j, arrayOfByte, 3 - i << 2);
      }
    }
    return new BigInteger(1, arrayOfByte);
  }
  
  public static BigInteger y(long[] paramArrayOfLong)
  {
    byte[] arrayOfByte = new byte[16];
    for (int i = 0; i < 2; i++)
    {
      long l = paramArrayOfLong[i];
      if (l != 0L) {
        f.l(l, arrayOfByte, 1 - i << 3);
      }
    }
    return new BigInteger(1, arrayOfByte);
  }
  
  public static void z(int[] paramArrayOfInt)
  {
    paramArrayOfInt[0] = 0;
    paramArrayOfInt[1] = 0;
    paramArrayOfInt[2] = 0;
    paramArrayOfInt[3] = 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */