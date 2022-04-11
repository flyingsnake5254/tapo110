package e.a.b.a.a0.c;

import e.a.b.c.a;
import e.a.b.c.h;
import e.a.b.c.m;
import java.math.BigInteger;

public class e2
{
  private static final long[] a = { 878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042L };
  
  public static void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
    paramArrayOfLong1[2] ^= paramArrayOfLong2[2];
    paramArrayOfLong1[3] ^= paramArrayOfLong2[3];
    long l = paramArrayOfLong1[4];
    paramArrayOfLong2[4] ^= l;
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
    paramArrayOfLong1[7] ^= paramArrayOfLong2[7];
    long l = paramArrayOfLong1[8];
    paramArrayOfLong2[8] ^= l;
  }
  
  public static void c(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= 1L;
    paramArrayOfLong2[1] = paramArrayOfLong1[1];
    paramArrayOfLong2[2] = paramArrayOfLong1[2];
    paramArrayOfLong2[3] = paramArrayOfLong1[3];
    paramArrayOfLong2[4] = paramArrayOfLong1[4];
  }
  
  public static long[] d(BigInteger paramBigInteger)
  {
    paramBigInteger = h.e(paramBigInteger);
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
    long l9 = paramArrayOfLong[8];
    long l10 = paramArrayOfLong[9];
    paramArrayOfLong[0] = (l1 ^ l2 << 57);
    paramArrayOfLong[1] = (l2 >>> 7 ^ l3 << 50);
    paramArrayOfLong[2] = (l3 >>> 14 ^ l4 << 43);
    paramArrayOfLong[3] = (l4 >>> 21 ^ l5 << 36);
    paramArrayOfLong[4] = (l5 >>> 28 ^ l6 << 29);
    paramArrayOfLong[5] = (l6 >>> 35 ^ l7 << 22);
    paramArrayOfLong[6] = (l7 >>> 42 ^ l8 << 15);
    paramArrayOfLong[7] = (l8 >>> 49 ^ l9 << 8);
    paramArrayOfLong[8] = (l9 >>> 56 ^ l10 << 1);
    paramArrayOfLong[9] = (l10 >>> 63);
  }
  
  protected static void f(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    long l5 = paramArrayOfLong1[4];
    paramArrayOfLong2[0] = (l1 & 0x1FFFFFFFFFFFFFF);
    paramArrayOfLong2[1] = ((l1 >>> 57 ^ l2 << 7) & 0x1FFFFFFFFFFFFFF);
    paramArrayOfLong2[2] = ((l2 >>> 50 ^ l3 << 14) & 0x1FFFFFFFFFFFFFF);
    paramArrayOfLong2[3] = ((l3 >>> 43 ^ l4 << 21) & 0x1FFFFFFFFFFFFFF);
    paramArrayOfLong2[4] = (l4 >>> 36 ^ l5 << 28);
  }
  
  protected static void g(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong1 = new long[5];
    long[] arrayOfLong2 = new long[5];
    f(paramArrayOfLong1, arrayOfLong1);
    f(paramArrayOfLong2, arrayOfLong2);
    paramArrayOfLong1 = new long[26];
    h(arrayOfLong1[0], arrayOfLong2[0], paramArrayOfLong1, 0);
    h(arrayOfLong1[1], arrayOfLong2[1], paramArrayOfLong1, 2);
    h(arrayOfLong1[2], arrayOfLong2[2], paramArrayOfLong1, 4);
    h(arrayOfLong1[3], arrayOfLong2[3], paramArrayOfLong1, 6);
    h(arrayOfLong1[4], arrayOfLong2[4], paramArrayOfLong1, 8);
    long l1 = arrayOfLong1[0] ^ arrayOfLong1[1];
    long l2 = arrayOfLong2[0] ^ arrayOfLong2[1];
    long l3 = arrayOfLong1[0] ^ arrayOfLong1[2];
    long l4 = arrayOfLong2[0] ^ arrayOfLong2[2];
    long l5 = arrayOfLong1[2] ^ arrayOfLong1[4];
    long l6 = arrayOfLong2[2] ^ arrayOfLong2[4];
    long l7 = arrayOfLong1[3] ^ arrayOfLong1[4];
    long l8 = arrayOfLong2[3] ^ arrayOfLong2[4];
    h(l3 ^ arrayOfLong1[3], l4 ^ arrayOfLong2[3], paramArrayOfLong1, 18);
    h(l5 ^ arrayOfLong1[1], l6 ^ arrayOfLong2[1], paramArrayOfLong1, 20);
    long l9 = l1 ^ l7;
    long l10 = l2 ^ l8;
    long l11 = arrayOfLong1[2];
    long l12 = arrayOfLong2[2];
    h(l9, l10, paramArrayOfLong1, 22);
    h(l9 ^ l11, l12 ^ l10, paramArrayOfLong1, 24);
    h(l1, l2, paramArrayOfLong1, 10);
    h(l3, l4, paramArrayOfLong1, 12);
    h(l5, l6, paramArrayOfLong1, 14);
    h(l7, l8, paramArrayOfLong1, 16);
    paramArrayOfLong3[0] = paramArrayOfLong1[0];
    paramArrayOfLong3[9] = paramArrayOfLong1[9];
    l12 = paramArrayOfLong1[0] ^ paramArrayOfLong1[1];
    l9 = paramArrayOfLong1[2] ^ l12;
    l4 = paramArrayOfLong1[10] ^ l9;
    paramArrayOfLong3[1] = l4;
    l10 = paramArrayOfLong1[3] ^ paramArrayOfLong1[4];
    l9 ^= l10 ^ paramArrayOfLong1[11] ^ paramArrayOfLong1[12];
    paramArrayOfLong3[2] = l9;
    l6 = paramArrayOfLong1[5] ^ paramArrayOfLong1[6];
    l10 = l12 ^ l10 ^ l6 ^ paramArrayOfLong1[8];
    l12 = paramArrayOfLong1[13] ^ paramArrayOfLong1[14];
    paramArrayOfLong3[3] = (l10 ^ l12 ^ paramArrayOfLong1[18] ^ paramArrayOfLong1[22] ^ paramArrayOfLong1[24]);
    l7 = paramArrayOfLong1[7] ^ paramArrayOfLong1[8] ^ paramArrayOfLong1[9];
    l11 = l7 ^ paramArrayOfLong1[17];
    paramArrayOfLong3[8] = l11;
    l7 = l7 ^ l6 ^ paramArrayOfLong1[15] ^ paramArrayOfLong1[16];
    paramArrayOfLong3[7] = l7;
    l3 = paramArrayOfLong1[19];
    l2 = paramArrayOfLong1[20];
    l8 = paramArrayOfLong1[25];
    l5 = paramArrayOfLong1[24];
    l1 = paramArrayOfLong1[18];
    l6 = paramArrayOfLong1[23];
    l8 = l3 ^ l2 ^ l8 ^ l5;
    paramArrayOfLong3[4] = (l8 ^ l1 ^ l6 ^ l4 ^ l7);
    paramArrayOfLong3[5] = (l9 ^ l11 ^ l8 ^ paramArrayOfLong1[21] ^ paramArrayOfLong1[22]);
    l4 = paramArrayOfLong1[0];
    paramArrayOfLong3[6] = (paramArrayOfLong1[9] ^ l10 ^ l4 ^ l12 ^ paramArrayOfLong1[21] ^ paramArrayOfLong1[23] ^ paramArrayOfLong1[25]);
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
    long l1 = arrayOfLong[((int)paramLong1 & 0x7)];
    long l2 = 0L;
    int i = 48;
    int j;
    long l3;
    long l4;
    do
    {
      j = (int)(paramLong1 >>> i);
      l3 = arrayOfLong[(j & 0x7)];
      l4 = arrayOfLong[(j >>> 3 & 0x7)];
      l4 = arrayOfLong[(j >>> 6 & 0x7)] << 6 ^ l3 ^ l4 << 3;
      l3 = l1 ^ l4 << i;
      l4 = l2 ^ l4 >>> -i;
      j = i - 9;
      l1 = l3;
      l2 = l4;
      i = j;
    } while (j > 0);
    paramArrayOfLong[paramInt] = (0x1FFFFFFFFFFFFFF & l3);
    paramArrayOfLong[(paramInt + 1)] = (((paramLong1 & 0x100804020100800 & paramLong2 << 7 >> 63) >>> 8 ^ l4) << 7 ^ l3 >>> 57);
  }
  
  protected static void i(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    for (int i = 0; i < 4; i++) {
      a.c(paramArrayOfLong1[i], paramArrayOfLong2, i << 1);
    }
    paramArrayOfLong2[8] = a.b((int)paramArrayOfLong1[4]);
  }
  
  public static void j(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!h.g(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = h.b();
      long[] arrayOfLong2 = h.b();
      p(paramArrayOfLong1, arrayOfLong1);
      k(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      r(arrayOfLong1, 2, arrayOfLong2);
      k(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      r(arrayOfLong2, 4, arrayOfLong1);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      r(arrayOfLong1, 8, arrayOfLong2);
      k(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      p(arrayOfLong2, arrayOfLong2);
      k(arrayOfLong2, paramArrayOfLong1, arrayOfLong2);
      r(arrayOfLong2, 17, arrayOfLong1);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      p(arrayOfLong1, arrayOfLong1);
      k(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      r(arrayOfLong1, 35, arrayOfLong2);
      k(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      r(arrayOfLong2, 70, arrayOfLong1);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      p(arrayOfLong1, arrayOfLong1);
      k(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      r(arrayOfLong1, 141, arrayOfLong2);
      k(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      p(arrayOfLong2, paramArrayOfLong2);
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void k(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = h.c();
    g(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    m(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void l(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = h.c();
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
    long l9 = paramArrayOfLong1[8];
    l5 ^= l9 >>> 27 ^ l9 >>> 22 ^ l9 >>> 20 ^ l9 >>> 15;
    long l10 = l5 >>> 27;
    paramArrayOfLong2[0] = (l1 ^ l6 << 37 ^ l6 << 42 ^ l6 << 44 ^ l6 << 49 ^ l10 ^ l10 << 5 ^ l10 << 7 ^ l10 << 12);
    paramArrayOfLong2[1] = (l2 ^ l7 << 37 ^ l7 << 42 ^ l7 << 44 ^ l7 << 49 ^ l6 >>> 27 ^ l6 >>> 22 ^ l6 >>> 20 ^ l6 >>> 15);
    paramArrayOfLong2[2] = (l3 ^ l8 << 37 ^ l8 << 42 ^ l8 << 44 ^ l8 << 49 ^ l7 >>> 27 ^ l7 >>> 22 ^ l7 >>> 20 ^ l7 >>> 15);
    paramArrayOfLong2[3] = (l4 ^ l9 << 37 ^ l9 << 42 ^ l9 << 44 ^ l9 << 49 ^ l8 >>> 27 ^ l8 >>> 22 ^ l8 >>> 20 ^ l8 >>> 15);
    paramArrayOfLong2[4] = (0x7FFFFFF & l5);
  }
  
  public static void n(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 4;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 27;
    paramArrayOfLong[paramInt] = (l2 << 12 ^ l2 << 5 ^ l2 ^ l2 << 7 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x7FFFFFF);
  }
  
  public static void o(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = h.b();
    long l1 = a.f(paramArrayOfLong1[0]);
    long l2 = a.f(paramArrayOfLong1[1]);
    arrayOfLong[0] = (l1 >>> 32 | l2 & 0xFFFFFFFF00000000);
    long l3 = a.f(paramArrayOfLong1[2]);
    long l4 = a.f(paramArrayOfLong1[3]);
    arrayOfLong[1] = (l3 >>> 32 | 0xFFFFFFFF00000000 & l4);
    long l5 = a.f(paramArrayOfLong1[4]);
    arrayOfLong[2] = (l5 >>> 32);
    k(arrayOfLong, a, paramArrayOfLong2);
    paramArrayOfLong2[0] ^= (l1 & 0xFFFFFFFF | l2 << 32);
    paramArrayOfLong2[1] ^= (l3 & 0xFFFFFFFF | l4 << 32);
    paramArrayOfLong2[2] ^= 0xFFFFFFFF & l5;
  }
  
  public static void p(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = m.k(9);
    i(paramArrayOfLong1, arrayOfLong);
    m(arrayOfLong, paramArrayOfLong2);
  }
  
  public static void q(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = m.k(9);
    i(paramArrayOfLong1, arrayOfLong);
    b(paramArrayOfLong2, arrayOfLong, paramArrayOfLong2);
  }
  
  public static void r(long[] paramArrayOfLong1, int paramInt, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = m.k(9);
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
    return (int)(paramArrayOfLong[0] ^ paramArrayOfLong[4] >>> 15) & 0x1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\e2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */