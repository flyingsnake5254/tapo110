package e.a.b.a.a0.c;

import e.a.b.c.a;
import e.a.b.c.g;
import java.math.BigInteger;

public class a2
{
  public static void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
    paramArrayOfLong1[2] ^= paramArrayOfLong2[2];
    long l = paramArrayOfLong1[3];
    paramArrayOfLong2[3] ^= l;
  }
  
  public static void b(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
    paramArrayOfLong1[2] ^= paramArrayOfLong2[2];
    paramArrayOfLong1[3] ^= paramArrayOfLong2[3];
    paramArrayOfLong1[4] ^= paramArrayOfLong2[4];
    paramArrayOfLong1[5] ^= paramArrayOfLong2[5];
    paramArrayOfLong1[6] ^= paramArrayOfLong2[6];
    long l = paramArrayOfLong1[7];
    paramArrayOfLong2[7] ^= l;
  }
  
  public static void c(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= 1L;
    paramArrayOfLong2[1] = paramArrayOfLong1[1];
    paramArrayOfLong2[2] = paramArrayOfLong1[2];
    paramArrayOfLong2[3] = paramArrayOfLong1[3];
  }
  
  public static long[] d(BigInteger paramBigInteger)
  {
    paramBigInteger = g.p(paramBigInteger);
    n(paramBigInteger, 0);
    return paramBigInteger;
  }
  
  protected static void e(long[] paramArrayOfLong)
  {
    long l1 = paramArrayOfLong[0];
    long l2 = paramArrayOfLong[1];
    long l3 = paramArrayOfLong[2];
    long l4 = paramArrayOfLong[3];
    long l5 = paramArrayOfLong[4];
    long l6 = paramArrayOfLong[5];
    long l7 = paramArrayOfLong[6];
    long l8 = paramArrayOfLong[7];
    paramArrayOfLong[0] = (l1 ^ l2 << 60);
    paramArrayOfLong[1] = (l2 >>> 4 ^ l3 << 56);
    paramArrayOfLong[2] = (l3 >>> 8 ^ l4 << 52);
    paramArrayOfLong[3] = (l4 >>> 12 ^ l5 << 48);
    paramArrayOfLong[4] = (l5 >>> 16 ^ l6 << 44);
    paramArrayOfLong[5] = (l6 >>> 20 ^ l7 << 40);
    paramArrayOfLong[6] = (l7 >>> 24 ^ l8 << 36);
    paramArrayOfLong[7] = (l8 >>> 28);
  }
  
  protected static void f(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    paramArrayOfLong2[0] = (l1 & 0xFFFFFFFFFFFFFFF);
    paramArrayOfLong2[1] = ((l1 >>> 60 ^ l2 << 4) & 0xFFFFFFFFFFFFFFF);
    paramArrayOfLong2[2] = ((l2 >>> 56 ^ l3 << 8) & 0xFFFFFFFFFFFFFFF);
    paramArrayOfLong2[3] = (l3 >>> 52 ^ l4 << 12);
  }
  
  protected static void g(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong1 = new long[4];
    long[] arrayOfLong2 = new long[4];
    f(paramArrayOfLong1, arrayOfLong1);
    f(paramArrayOfLong2, arrayOfLong2);
    h(arrayOfLong1[0], arrayOfLong2[0], paramArrayOfLong3, 0);
    h(arrayOfLong1[1], arrayOfLong2[1], paramArrayOfLong3, 1);
    h(arrayOfLong1[2], arrayOfLong2[2], paramArrayOfLong3, 2);
    h(arrayOfLong1[3], arrayOfLong2[3], paramArrayOfLong3, 3);
    for (int i = 5; i > 0; i--) {
      paramArrayOfLong3[i] ^= paramArrayOfLong3[(i - 1)];
    }
    h(arrayOfLong1[0] ^ arrayOfLong1[1], arrayOfLong2[0] ^ arrayOfLong2[1], paramArrayOfLong3, 1);
    h(arrayOfLong1[2] ^ arrayOfLong1[3], arrayOfLong2[2] ^ arrayOfLong2[3], paramArrayOfLong3, 3);
    for (i = 7; i > 1; i--) {
      paramArrayOfLong3[i] ^= paramArrayOfLong3[(i - 2)];
    }
    long l1 = arrayOfLong1[0] ^ arrayOfLong1[2];
    long l2 = arrayOfLong1[1] ^ arrayOfLong1[3];
    long l3 = arrayOfLong2[0] ^ arrayOfLong2[2];
    long l4 = arrayOfLong2[1] ^ arrayOfLong2[3];
    h(l1 ^ l2, l3 ^ l4, paramArrayOfLong3, 3);
    paramArrayOfLong1 = new long[3];
    h(l1, l3, paramArrayOfLong1, 0);
    h(l2, l4, paramArrayOfLong1, 1);
    l4 = paramArrayOfLong1[0];
    l3 = paramArrayOfLong1[1];
    l1 = paramArrayOfLong1[2];
    paramArrayOfLong3[2] ^= l4;
    paramArrayOfLong3[3] = (l4 ^ l3 ^ paramArrayOfLong3[3]);
    paramArrayOfLong3[4] ^= l1 ^ l3;
    paramArrayOfLong3[5] ^= l1;
    e(paramArrayOfLong3);
  }
  
  protected static void h(long paramLong1, long paramLong2, long[] paramArrayOfLong, int paramInt)
  {
    long[] arrayOfLong = new long[8];
    arrayOfLong[1] = paramLong2;
    arrayOfLong[2] = (arrayOfLong[1] << 1);
    arrayOfLong[3] = (arrayOfLong[2] ^ paramLong2);
    arrayOfLong[4] = (arrayOfLong[2] << 1);
    arrayOfLong[5] = (arrayOfLong[4] ^ paramLong2);
    arrayOfLong[6] = (arrayOfLong[3] << 1);
    arrayOfLong[7] = (arrayOfLong[6] ^ paramLong2);
    int i = (int)paramLong1;
    long l1 = arrayOfLong[(i & 0x7)];
    long l2 = arrayOfLong[(i >>> 3 & 0x7)] << 3 ^ l1;
    l1 = 0L;
    i = 54;
    int j;
    long l3;
    long l4;
    do
    {
      j = (int)(paramLong1 >>> i);
      l3 = arrayOfLong[(j & 0x7)];
      l4 = arrayOfLong[(j >>> 3 & 0x7)] << 3 ^ l3;
      l3 = l2 ^ l4 << i;
      l4 = l1 ^ l4 >>> -i;
      j = i - 6;
      l2 = l3;
      l1 = l4;
      i = j;
    } while (j > 0);
    paramArrayOfLong[paramInt] ^= 0xFFFFFFFFFFFFFFF & l3;
    paramInt++;
    paramArrayOfLong[paramInt] = (((paramLong1 & 0x820820820820820 & paramLong2 << 4 >> 63) >>> 5 ^ l4) << 4 ^ l3 >>> 60 ^ paramArrayOfLong[paramInt]);
  }
  
  protected static void i(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    a.c(paramArrayOfLong1[0], paramArrayOfLong2, 0);
    a.c(paramArrayOfLong1[1], paramArrayOfLong2, 2);
    a.c(paramArrayOfLong1[2], paramArrayOfLong2, 4);
    long l = paramArrayOfLong1[3];
    paramArrayOfLong2[6] = a.b((int)l);
    paramArrayOfLong2[7] = (a.a((int)(l >>> 32)) & 0xFFFFFFFF);
  }
  
  public static void j(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!g.w(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = g.i();
      long[] arrayOfLong2 = g.i();
      p(paramArrayOfLong1, arrayOfLong1);
      k(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      p(arrayOfLong1, arrayOfLong1);
      k(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      r(arrayOfLong1, 3, arrayOfLong2);
      k(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      p(arrayOfLong2, arrayOfLong2);
      k(arrayOfLong2, paramArrayOfLong1, arrayOfLong2);
      r(arrayOfLong2, 7, arrayOfLong1);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      r(arrayOfLong1, 14, arrayOfLong2);
      k(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      p(arrayOfLong2, arrayOfLong2);
      k(arrayOfLong2, paramArrayOfLong1, arrayOfLong2);
      r(arrayOfLong2, 29, arrayOfLong1);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      p(arrayOfLong1, arrayOfLong1);
      k(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      r(arrayOfLong1, 59, arrayOfLong2);
      k(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      p(arrayOfLong2, arrayOfLong2);
      k(arrayOfLong2, paramArrayOfLong1, arrayOfLong2);
      r(arrayOfLong2, 119, arrayOfLong1);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      p(arrayOfLong1, paramArrayOfLong2);
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void k(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = g.k();
    g(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    m(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void l(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = g.k();
    g(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    b(paramArrayOfLong3, arrayOfLong, paramArrayOfLong3);
  }
  
  public static void m(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    long l5 = paramArrayOfLong1[4];
    long l6 = paramArrayOfLong1[5];
    long l7 = paramArrayOfLong1[6];
    long l8 = paramArrayOfLong1[7];
    l7 ^= l8 >>> 17;
    l6 = l6 ^ l8 << 47 ^ l7 >>> 17;
    l5 = l5 ^ l8 >>> 47 ^ l7 << 47 ^ l6 >>> 17;
    l8 = l4 ^ l8 << 17 ^ l7 >>> 47 ^ l6 << 47 ^ l5 >>> 17;
    l4 = l8 >>> 47;
    paramArrayOfLong2[0] = (l1 ^ l5 << 17 ^ l4);
    paramArrayOfLong2[1] = (l2 ^ l6 << 17 ^ l5 >>> 47);
    paramArrayOfLong2[2] = (l4 << 30 ^ l3 ^ l7 << 17 ^ l6 >>> 47 ^ l5 << 47);
    paramArrayOfLong2[3] = (0x7FFFFFFFFFFF & l8);
  }
  
  public static void n(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 3;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 47;
    paramArrayOfLong[paramInt] ^= l2;
    paramInt += 2;
    paramArrayOfLong[paramInt] = (l2 << 30 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x7FFFFFFFFFFF);
  }
  
  public static void o(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int i = 0;
    long l1 = a.f(paramArrayOfLong1[0]);
    long l2 = a.f(paramArrayOfLong1[1]);
    long l3 = l1 >>> 32 | l2 & 0xFFFFFFFF00000000;
    long l4 = a.f(paramArrayOfLong1[2]);
    long l5 = a.f(paramArrayOfLong1[3]);
    long l6 = l5 & 0xFFFFFFFF00000000 | l4 >>> 32;
    long l7 = l6 >>> 49;
    long l8 = l3 >>> 49 | l6 << 15;
    l6 ^= l3 << 15;
    long[] arrayOfLong = g.k();
    paramArrayOfLong1 = new int[2];
    paramArrayOfLong1[0] = 39;
    paramArrayOfLong1[1] = 120;
    paramArrayOfLong1;
    while (i < 2)
    {
      int j = paramArrayOfLong1[i] >>> 6;
      int k = paramArrayOfLong1[i] & 0x3F;
      arrayOfLong[j] ^= l3 << k;
      int m = j + 1;
      long l9 = arrayOfLong[m];
      int n = -k;
      arrayOfLong[m] = (l9 ^ (l6 << k | l3 >>> n));
      m = j + 2;
      arrayOfLong[m] ^= (l8 << k | l6 >>> n);
      m = j + 3;
      arrayOfLong[m] ^= (l7 << k | l8 >>> n);
      j += 4;
      arrayOfLong[j] ^= l7 >>> n;
      i++;
    }
    m(arrayOfLong, paramArrayOfLong2);
    paramArrayOfLong2[0] ^= (l1 & 0xFFFFFFFF | l2 << 32);
    paramArrayOfLong2[1] ^= (l4 & 0xFFFFFFFF | l5 << 32);
  }
  
  public static void p(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = g.k();
    i(paramArrayOfLong1, arrayOfLong);
    m(arrayOfLong, paramArrayOfLong2);
  }
  
  public static void q(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = g.k();
    i(paramArrayOfLong1, arrayOfLong);
    b(paramArrayOfLong2, arrayOfLong, paramArrayOfLong2);
  }
  
  public static void r(long[] paramArrayOfLong1, int paramInt, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = g.k();
    i(paramArrayOfLong1, arrayOfLong);
    for (;;)
    {
      m(arrayOfLong, paramArrayOfLong2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      i(paramArrayOfLong2, arrayOfLong);
    }
  }
  
  public static int s(long[] paramArrayOfLong)
  {
    return (int)(paramArrayOfLong[0] ^ paramArrayOfLong[1] >>> 17 ^ paramArrayOfLong[2] >>> 34) & 0x1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\a2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */