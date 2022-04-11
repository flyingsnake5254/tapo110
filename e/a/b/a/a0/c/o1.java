package e.a.b.a.a0.c;

import e.a.b.c.a;
import e.a.b.c.g;
import java.math.BigInteger;

public class o1
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
    long l = paramArrayOfLong1[6];
    paramArrayOfLong2[6] ^= l;
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
    paramArrayOfLong[0] = (l1 ^ l2 << 49);
    paramArrayOfLong[1] = (l2 >>> 15 ^ l3 << 34);
    paramArrayOfLong[2] = (l3 >>> 30 ^ l4 << 19);
    paramArrayOfLong[3] = (l4 >>> 45 ^ l5 << 4 ^ l6 << 53);
    paramArrayOfLong[4] = (l5 >>> 60 ^ l7 << 38 ^ l6 >>> 11);
    paramArrayOfLong[5] = (l7 >>> 26 ^ l8 << 23);
    paramArrayOfLong[6] = (l8 >>> 41);
    paramArrayOfLong[7] = 0L;
  }
  
  protected static void f(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    paramArrayOfLong2[0] = (l1 & 0x1FFFFFFFFFFFF);
    paramArrayOfLong2[1] = ((l1 >>> 49 ^ l2 << 15) & 0x1FFFFFFFFFFFF);
    paramArrayOfLong2[2] = ((l2 >>> 34 ^ l3 << 30) & 0x1FFFFFFFFFFFF);
    paramArrayOfLong2[3] = (l3 >>> 19 ^ l4 << 45);
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
    l2 = paramArrayOfLong1[0];
    l4 = paramArrayOfLong1[1];
    l3 = paramArrayOfLong1[2];
    paramArrayOfLong3[2] ^= l2;
    paramArrayOfLong3[3] = (l2 ^ l4 ^ paramArrayOfLong3[3]);
    paramArrayOfLong3[4] ^= l3 ^ l4;
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
    i = 36;
    int j;
    long l4;
    long l5;
    do
    {
      j = (int)(paramLong1 >>> i);
      long l2 = arrayOfLong[(j & 0x7)];
      long l3 = arrayOfLong[(j >>> 3 & 0x7)];
      l4 = arrayOfLong[(j >>> 6 & 0x7)];
      l5 = arrayOfLong[(j >>> 9 & 0x7)];
      l4 = arrayOfLong[(j >>> 12 & 0x7)] << 12 ^ l2 ^ l3 << 3 ^ l4 << 6 ^ l5 << 9;
      l5 = l1 ^ l4 << i;
      l4 = paramLong2 ^ l4 >>> -i;
      j = i - 15;
      l1 = l5;
      paramLong2 = l4;
      i = j;
    } while (j > 0);
    paramArrayOfLong[paramInt] ^= 0x1FFFFFFFFFFFF & l5;
    paramInt++;
    paramArrayOfLong[paramInt] ^= l5 >>> 49 ^ l4 << 15;
  }
  
  protected static void i(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    a.c(paramArrayOfLong1[0], paramArrayOfLong2, 0);
    a.c(paramArrayOfLong1[1], paramArrayOfLong2, 2);
    a.c(paramArrayOfLong1[2], paramArrayOfLong2, 4);
    paramArrayOfLong2[6] = (paramArrayOfLong1[3] & 1L);
  }
  
  public static void j(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!g.w(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = g.i();
      long[] arrayOfLong2 = g.i();
      p(paramArrayOfLong1, arrayOfLong1);
      r(arrayOfLong1, 1, arrayOfLong2);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      r(arrayOfLong2, 1, arrayOfLong2);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      r(arrayOfLong1, 3, arrayOfLong2);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      r(arrayOfLong1, 6, arrayOfLong2);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      r(arrayOfLong1, 12, arrayOfLong2);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      r(arrayOfLong1, 24, arrayOfLong2);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      r(arrayOfLong1, 48, arrayOfLong2);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      r(arrayOfLong1, 96, arrayOfLong2);
      k(arrayOfLong1, arrayOfLong2, paramArrayOfLong2);
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
    l5 ^= l7 >>> 50;
    long l8 = l4 ^ l7 >>> 1 ^ l7 << 14 ^ l6 >>> 50;
    l4 = l8 >>> 1;
    paramArrayOfLong2[0] = (l1 ^ l5 << 63 ^ l4 ^ l4 << 15);
    paramArrayOfLong2[1] = (l4 >>> 49 ^ l2 ^ l6 << 63 ^ l5 >>> 1 ^ l5 << 14);
    paramArrayOfLong2[2] = (l3 ^ l7 << 63 ^ l6 >>> 1 ^ l6 << 14 ^ l5 >>> 50);
    paramArrayOfLong2[3] = (1L & l8);
  }
  
  public static void n(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 3;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 1;
    paramArrayOfLong[paramInt] ^= l2 << 15 ^ l2;
    paramInt++;
    paramArrayOfLong[paramInt] = (l2 >>> 49 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 1L);
  }
  
  public static void o(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = a.f(paramArrayOfLong1[0]);
    long l2 = a.f(paramArrayOfLong1[1]);
    long l3 = l1 >>> 32 | l2 & 0xFFFFFFFF00000000;
    long l4 = a.f(paramArrayOfLong1[2]);
    long l5 = paramArrayOfLong1[3];
    long l6 = l4 >>> 32;
    paramArrayOfLong2[0] = ((l1 & 0xFFFFFFFF | l2 << 32) ^ l3 << 8);
    paramArrayOfLong2[1] = (l4 & 0xFFFFFFFF ^ l5 << 32 ^ l6 << 8 ^ l3 >>> 56 ^ l3 << 33);
    paramArrayOfLong2[2] = (l3 >>> 31 ^ l6 >>> 56 ^ l6 << 33);
    paramArrayOfLong2[3] = (l6 >>> 31);
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
    return (int)paramArrayOfLong[0] & 0x1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\o1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */