package e.a.b.a.a0.c;

import e.a.b.c.a;
import e.a.b.c.g;
import java.math.BigInteger;

public class u1
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
    paramArrayOfLong[0] = (l1 ^ l2 << 59);
    paramArrayOfLong[1] = (l2 >>> 5 ^ l3 << 54);
    paramArrayOfLong[2] = (l3 >>> 10 ^ l4 << 49);
    paramArrayOfLong[3] = (l4 >>> 15 ^ l5 << 44);
    paramArrayOfLong[4] = (l5 >>> 20 ^ l6 << 39);
    paramArrayOfLong[5] = (l6 >>> 25 ^ l7 << 34);
    paramArrayOfLong[6] = (l7 >>> 30 ^ l8 << 29);
    paramArrayOfLong[7] = (l8 >>> 35);
  }
  
  protected static void f(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    paramArrayOfLong2[0] = (l1 & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[1] = ((l1 >>> 59 ^ l2 << 5) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[2] = ((l2 >>> 54 ^ l3 << 10) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[3] = (l3 >>> 49 ^ l4 << 15);
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
    l2 = paramArrayOfLong1[1];
    l3 = paramArrayOfLong1[2];
    paramArrayOfLong3[2] ^= l4;
    paramArrayOfLong3[3] = (l4 ^ l2 ^ paramArrayOfLong3[3]);
    paramArrayOfLong3[4] ^= l3 ^ l2;
    paramArrayOfLong3[5] ^= l3;
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
    paramLong2 = arrayOfLong[(i & 0x7)];
    long l1 = arrayOfLong[(i >>> 3 & 0x7)] << 3 ^ paramLong2;
    paramLong2 = 0L;
    i = 54;
    int j;
    long l2;
    long l3;
    do
    {
      j = (int)(paramLong1 >>> i);
      l2 = arrayOfLong[(j & 0x7)];
      l3 = arrayOfLong[(j >>> 3 & 0x7)] << 3 ^ l2;
      l2 = l1 ^ l3 << i;
      l3 = paramLong2 ^ l3 >>> -i;
      j = i - 6;
      l1 = l2;
      paramLong2 = l3;
      i = j;
    } while (j > 0);
    paramArrayOfLong[paramInt] ^= 0x7FFFFFFFFFFFFFF & l2;
    paramInt++;
    paramArrayOfLong[paramInt] ^= l2 >>> 59 ^ l3 << 5;
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
      r(arrayOfLong1, 58, arrayOfLong2);
      k(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      r(arrayOfLong2, 116, arrayOfLong1);
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
    l6 ^= l8 >>> 31;
    l5 = l5 ^ l8 >>> 41 ^ l8 << 33 ^ l7 >>> 31;
    l8 = l4 ^ l8 << 23 ^ l7 >>> 41 ^ l7 << 33 ^ l6 >>> 31;
    l4 = l8 >>> 41;
    paramArrayOfLong2[0] = (l1 ^ l5 << 23 ^ l4);
    paramArrayOfLong2[1] = (l4 << 10 ^ l2 ^ l6 << 23 ^ l5 >>> 41 ^ l5 << 33);
    paramArrayOfLong2[2] = (l3 ^ l7 << 23 ^ l6 >>> 41 ^ l6 << 33 ^ l5 >>> 31);
    paramArrayOfLong2[3] = (0x1FFFFFFFFFF & l8);
  }
  
  public static void n(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 3;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 41;
    paramArrayOfLong[paramInt] ^= l2;
    paramInt++;
    paramArrayOfLong[paramInt] = (l2 << 10 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x1FFFFFFFFFF);
  }
  
  public static void o(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = a.f(paramArrayOfLong1[0]);
    long l2 = a.f(paramArrayOfLong1[1]);
    long l3 = l1 >>> 32 | l2 & 0xFFFFFFFF00000000;
    long l4 = a.f(paramArrayOfLong1[2]);
    long l5 = a.f(paramArrayOfLong1[3]);
    long l6 = l4 >>> 32 | l5 & 0xFFFFFFFF00000000;
    long l7 = l6 >>> 27;
    l6 ^= (l3 >>> 27 | l6 << 37);
    l3 ^= l3 << 37;
    long[] arrayOfLong = g.k();
    paramArrayOfLong1 = new int[3];
    paramArrayOfLong1[0] = 32;
    paramArrayOfLong1[1] = 117;
    paramArrayOfLong1[2] = '¿';
    paramArrayOfLong1;
    for (int i = 0; i < 3; i++)
    {
      int j = paramArrayOfLong1[i] >>> 6;
      int k = paramArrayOfLong1[i] & 0x3F;
      arrayOfLong[j] ^= l3 << k;
      int m = j + 1;
      long l8 = arrayOfLong[m];
      int n = -k;
      arrayOfLong[m] = (l8 ^ (l6 << k | l3 >>> n));
      m = j + 2;
      arrayOfLong[m] ^= (l7 << k | l6 >>> n);
      k = j + 3;
      arrayOfLong[k] ^= l7 >>> n;
    }
    m(arrayOfLong, paramArrayOfLong2);
    paramArrayOfLong2[0] ^= (l1 & 0xFFFFFFFF | l2 << 32);
    paramArrayOfLong2[1] ^= (0xFFFFFFFF & l4 | l5 << 32);
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
    return (int)(paramArrayOfLong[0] ^ paramArrayOfLong[2] >>> 31) & 0x1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\u1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */