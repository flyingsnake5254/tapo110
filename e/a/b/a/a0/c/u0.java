package e.a.b.a.a0.c;

import e.a.b.c.a;
import e.a.b.c.c;
import java.math.BigInteger;

public class u0
{
  public static void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    long l = paramArrayOfLong1[1];
    paramArrayOfLong2[1] ^= l;
  }
  
  public static void b(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
    paramArrayOfLong1[2] ^= paramArrayOfLong2[2];
    long l = paramArrayOfLong1[3];
    paramArrayOfLong2[3] ^= l;
  }
  
  public static void c(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= 1L;
    paramArrayOfLong2[1] = paramArrayOfLong1[1];
  }
  
  public static long[] d(BigInteger paramBigInteger)
  {
    paramBigInteger = c.l(paramBigInteger);
    l(paramBigInteger, 0);
    return paramBigInteger;
  }
  
  protected static void e(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = (paramArrayOfLong1[1] << 7 ^ l1 >>> 57) & 0x1FFFFFFFFFFFFFF;
    l1 &= 0x1FFFFFFFFFFFFFF;
    long l3 = paramArrayOfLong2[0];
    long l4 = (paramArrayOfLong2[1] << 7 ^ l3 >>> 57) & 0x1FFFFFFFFFFFFFF;
    l3 = 0x1FFFFFFFFFFFFFF & l3;
    paramArrayOfLong1 = new long[6];
    f(l1, l3, paramArrayOfLong1, 0);
    f(l2, l4, paramArrayOfLong1, 2);
    f(l1 ^ l2, l3 ^ l4, paramArrayOfLong1, 4);
    l3 = paramArrayOfLong1[1] ^ paramArrayOfLong1[2];
    l4 = paramArrayOfLong1[0];
    l1 = paramArrayOfLong1[3];
    l2 = paramArrayOfLong1[4] ^ l4 ^ l3;
    l3 ^= paramArrayOfLong1[5] ^ l1;
    paramArrayOfLong3[0] = (l4 ^ l2 << 57);
    paramArrayOfLong3[1] = (l2 >>> 7 ^ l3 << 50);
    paramArrayOfLong3[2] = (l3 >>> 14 ^ l1 << 43);
    paramArrayOfLong3[3] = (l1 >>> 21);
  }
  
  protected static void f(long paramLong1, long paramLong2, long[] paramArrayOfLong, int paramInt)
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
  
  protected static void g(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    a.c(paramArrayOfLong1[0], paramArrayOfLong2, 0);
    a.c(paramArrayOfLong1[1], paramArrayOfLong2, 2);
  }
  
  public static void h(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!c.r(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = c.f();
      long[] arrayOfLong2 = c.f();
      n(paramArrayOfLong1, arrayOfLong1);
      i(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      n(arrayOfLong1, arrayOfLong1);
      i(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      p(arrayOfLong1, 3, arrayOfLong2);
      i(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      n(arrayOfLong2, arrayOfLong2);
      i(arrayOfLong2, paramArrayOfLong1, arrayOfLong2);
      p(arrayOfLong2, 7, arrayOfLong1);
      i(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      p(arrayOfLong1, 14, arrayOfLong2);
      i(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      p(arrayOfLong2, 28, arrayOfLong1);
      i(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      p(arrayOfLong1, 56, arrayOfLong2);
      i(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      n(arrayOfLong2, paramArrayOfLong2);
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void i(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = c.h();
    e(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    k(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void j(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = c.h();
    e(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    b(paramArrayOfLong3, arrayOfLong, paramArrayOfLong3);
  }
  
  public static void k(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    l3 ^= l4 >>> 40 ^ l4 >>> 49;
    l2 = l2 ^ l4 << 15 ^ l4 << 24 ^ l3 >>> 40 ^ l3 >>> 49;
    l4 = l2 >>> 49;
    paramArrayOfLong2[0] = (l1 ^ l3 << 15 ^ l3 << 24 ^ l4 ^ l4 << 9);
    paramArrayOfLong2[1] = (0x1FFFFFFFFFFFF & l2);
  }
  
  public static void l(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 1;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 49;
    paramArrayOfLong[paramInt] = (l2 ^ l2 << 9 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x1FFFFFFFFFFFF);
  }
  
  public static void m(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = a.f(paramArrayOfLong1[0]);
    long l2 = a.f(paramArrayOfLong1[1]);
    long l3 = l1 >>> 32 | l2 & 0xFFFFFFFF00000000;
    paramArrayOfLong2[0] = (l3 << 57 ^ (0xFFFFFFFF & l1 | l2 << 32) ^ l3 << 5);
    paramArrayOfLong2[1] = (l3 >>> 59 ^ l3 >>> 7);
  }
  
  public static void n(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = c.h();
    g(paramArrayOfLong1, arrayOfLong);
    k(arrayOfLong, paramArrayOfLong2);
  }
  
  public static void o(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = c.h();
    g(paramArrayOfLong1, arrayOfLong);
    b(paramArrayOfLong2, arrayOfLong, paramArrayOfLong2);
  }
  
  public static void p(long[] paramArrayOfLong1, int paramInt, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = c.h();
    g(paramArrayOfLong1, arrayOfLong);
    for (;;)
    {
      k(arrayOfLong, paramArrayOfLong2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      g(paramArrayOfLong2, arrayOfLong);
    }
  }
  
  public static int q(long[] paramArrayOfLong)
  {
    return (int)paramArrayOfLong[0] & 0x1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\u0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */