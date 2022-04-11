package e.a.b.a.a0.c;

import e.a.b.c.a;
import e.a.b.c.j;
import e.a.b.c.m;
import java.math.BigInteger;

public class k2
{
  public static void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
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
  
  public static void b(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    for (int i = 0; i < 13; i++) {
      paramArrayOfLong1[i] ^= paramArrayOfLong2[i];
    }
  }
  
  public static void c(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= 1L;
    paramArrayOfLong2[1] = paramArrayOfLong1[1];
    paramArrayOfLong2[2] = paramArrayOfLong1[2];
    paramArrayOfLong2[3] = paramArrayOfLong1[3];
    paramArrayOfLong2[4] = paramArrayOfLong1[4];
    paramArrayOfLong2[5] = paramArrayOfLong1[5];
    paramArrayOfLong2[6] = paramArrayOfLong1[6];
  }
  
  public static long[] d(BigInteger paramBigInteger)
  {
    paramBigInteger = j.e(paramBigInteger);
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
    long l11 = paramArrayOfLong[10];
    long l12 = paramArrayOfLong[11];
    long l13 = paramArrayOfLong[12];
    long l14 = paramArrayOfLong[13];
    paramArrayOfLong[0] = (l1 ^ l2 << 59);
    paramArrayOfLong[1] = (l2 >>> 5 ^ l3 << 54);
    paramArrayOfLong[2] = (l3 >>> 10 ^ l4 << 49);
    paramArrayOfLong[3] = (l4 >>> 15 ^ l5 << 44);
    paramArrayOfLong[4] = (l5 >>> 20 ^ l6 << 39);
    paramArrayOfLong[5] = (l6 >>> 25 ^ l7 << 34);
    paramArrayOfLong[6] = (l7 >>> 30 ^ l8 << 29);
    paramArrayOfLong[7] = (l8 >>> 35 ^ l9 << 24);
    paramArrayOfLong[8] = (l9 >>> 40 ^ l10 << 19);
    paramArrayOfLong[9] = (l10 >>> 45 ^ l11 << 14);
    paramArrayOfLong[10] = (l11 >>> 50 ^ l12 << 9);
    paramArrayOfLong[11] = (l12 >>> 55 ^ l13 << 4 ^ l14 << 63);
    paramArrayOfLong[12] = (l13 >>> 60 ^ l14 >>> 1);
    paramArrayOfLong[13] = 0L;
  }
  
  protected static void f(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    long l5 = paramArrayOfLong1[4];
    long l6 = paramArrayOfLong1[5];
    long l7 = paramArrayOfLong1[6];
    paramArrayOfLong2[0] = (l1 & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[1] = ((l1 >>> 59 ^ l2 << 5) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[2] = ((l2 >>> 54 ^ l3 << 10) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[3] = ((l3 >>> 49 ^ l4 << 15) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[4] = ((l4 >>> 44 ^ l5 << 20) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[5] = ((l5 >>> 39 ^ l6 << 25) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[6] = (l6 >>> 34 ^ l7 << 30);
  }
  
  protected static void g(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong1 = new long[7];
    long[] arrayOfLong2 = new long[7];
    f(paramArrayOfLong1, arrayOfLong1);
    f(paramArrayOfLong2, arrayOfLong2);
    for (int i = 0; i < 7; i++) {
      h(arrayOfLong1, arrayOfLong2[i], paramArrayOfLong3, i);
    }
    e(paramArrayOfLong3);
  }
  
  protected static void h(long[] paramArrayOfLong1, long paramLong, long[] paramArrayOfLong2, int paramInt)
  {
    long[] arrayOfLong = new long[8];
    arrayOfLong[1] = paramLong;
    arrayOfLong[2] = (arrayOfLong[1] << 1);
    arrayOfLong[3] = (arrayOfLong[2] ^ paramLong);
    arrayOfLong[4] = (arrayOfLong[2] << 1);
    arrayOfLong[5] = (arrayOfLong[4] ^ paramLong);
    arrayOfLong[6] = (arrayOfLong[3] << 1);
    arrayOfLong[7] = (arrayOfLong[6] ^ paramLong);
    for (int i = 0; i < 7; i++)
    {
      long l1 = paramArrayOfLong1[i];
      int j = (int)l1;
      long l2 = 0L;
      paramLong = arrayOfLong[(j & 0x7)] ^ arrayOfLong[(j >>> 3 & 0x7)] << 3;
      j = 54;
      int k;
      long l3;
      long l4;
      do
      {
        k = (int)(l1 >>> j);
        l3 = arrayOfLong[(k & 0x7)];
        l4 = arrayOfLong[(k >>> 3 & 0x7)] << 3 ^ l3;
        l3 = paramLong ^ l4 << j;
        l4 = l2 ^ l4 >>> -j;
        k = j - 6;
        j = k;
        l2 = l4;
        paramLong = l3;
      } while (k > 0);
      j = paramInt + i;
      paramArrayOfLong2[j] ^= 0x7FFFFFFFFFFFFFF & l3;
      j++;
      paramArrayOfLong2[j] ^= l4 << 5 ^ l3 >>> 59;
    }
  }
  
  protected static void i(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    for (int i = 0; i < 6; i++) {
      a.c(paramArrayOfLong1[i], paramArrayOfLong2, i << 1);
    }
    paramArrayOfLong2[12] = a.b((int)paramArrayOfLong1[6]);
  }
  
  public static void j(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!j.g(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = j.b();
      long[] arrayOfLong2 = j.b();
      long[] arrayOfLong3 = j.b();
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
      k(arrayOfLong1, arrayOfLong2, arrayOfLong3);
      r(arrayOfLong3, 24, arrayOfLong1);
      r(arrayOfLong1, 24, arrayOfLong2);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      r(arrayOfLong1, 48, arrayOfLong2);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      r(arrayOfLong1, 96, arrayOfLong2);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      r(arrayOfLong1, 192, arrayOfLong2);
      k(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      k(arrayOfLong1, arrayOfLong3, paramArrayOfLong2);
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void k(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = j.c();
    g(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    m(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void l(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = j.c();
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
    long l9 = paramArrayOfLong1[12];
    l8 ^= l9 >>> 2;
    long l10 = paramArrayOfLong1[11];
    l7 = l7 ^ l9 >>> 25 ^ l9 << 62 ^ l10 >>> 2;
    long l11 = paramArrayOfLong1[10];
    long l12 = paramArrayOfLong1[9];
    long l13 = paramArrayOfLong1[8];
    long l14 = l7 >>> 25;
    paramArrayOfLong2[0] = (l1 ^ l8 << 39 ^ l14);
    paramArrayOfLong2[1] = (l14 << 23 ^ l2 ^ l13 << 39 ^ l8 >>> 25 ^ l8 << 62);
    paramArrayOfLong2[2] = (l3 ^ l12 << 39 ^ l13 >>> 25 ^ l13 << 62 ^ l8 >>> 2);
    paramArrayOfLong2[3] = (l4 ^ l11 << 39 ^ l12 >>> 25 ^ l12 << 62 ^ l13 >>> 2);
    paramArrayOfLong2[4] = (l5 ^ l10 << 39 ^ l11 >>> 25 ^ l11 << 62 ^ l12 >>> 2);
    paramArrayOfLong2[5] = (l6 ^ l9 << 39 ^ l10 >>> 25 ^ l10 << 62 ^ l11 >>> 2);
    paramArrayOfLong2[6] = (l7 & 0x1FFFFFF);
  }
  
  public static void n(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 6;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 25;
    paramArrayOfLong[paramInt] ^= l2;
    paramInt++;
    paramArrayOfLong[paramInt] = (l2 << 23 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x1FFFFFF);
  }
  
  public static void o(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = a.f(paramArrayOfLong1[0]);
    long l2 = a.f(paramArrayOfLong1[1]);
    long l3 = l1 >>> 32 | l2 & 0xFFFFFFFF00000000;
    long l4 = a.f(paramArrayOfLong1[2]);
    long l5 = a.f(paramArrayOfLong1[3]);
    long l6 = l4 >>> 32 | l5 & 0xFFFFFFFF00000000;
    long l7 = a.f(paramArrayOfLong1[4]);
    long l8 = a.f(paramArrayOfLong1[5]);
    long l9 = l7 >>> 32 | l8 & 0xFFFFFFFF00000000;
    long l10 = a.f(paramArrayOfLong1[6]);
    long l11 = l10 >>> 32;
    paramArrayOfLong2[0] = ((l1 & 0xFFFFFFFF | l2 << 32) ^ l3 << 44);
    paramArrayOfLong2[1] = ((l4 & 0xFFFFFFFF | l5 << 32) ^ l6 << 44 ^ l3 >>> 20);
    paramArrayOfLong2[2] = ((l7 & 0xFFFFFFFF | l8 << 32) ^ l9 << 44 ^ l6 >>> 20);
    paramArrayOfLong2[3] = (l11 << 44 ^ l10 & 0xFFFFFFFF ^ l9 >>> 20 ^ l3 << 13);
    paramArrayOfLong2[4] = (l3 >>> 51 ^ l11 >>> 20 ^ l6 << 13);
    paramArrayOfLong2[5] = (l9 << 13 ^ l6 >>> 51);
    paramArrayOfLong2[6] = (l11 << 13 ^ l9 >>> 51);
  }
  
  public static void p(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = m.k(13);
    i(paramArrayOfLong1, arrayOfLong);
    m(arrayOfLong, paramArrayOfLong2);
  }
  
  public static void q(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = m.k(13);
    i(paramArrayOfLong1, arrayOfLong);
    b(paramArrayOfLong2, arrayOfLong, paramArrayOfLong2);
  }
  
  public static void r(long[] paramArrayOfLong1, int paramInt, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = m.k(13);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\k2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */