package e.a.b.a.a0.c;

import e.a.b.c.a;
import e.a.b.c.e;
import java.math.BigInteger;

public class g1
{
  private static final long[] a = { -5270498306774157648L, 5270498306774195053L, 19634136210L };
  
  public static void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
    long l = paramArrayOfLong1[2];
    paramArrayOfLong2[2] ^= l;
  }
  
  public static void b(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
    paramArrayOfLong1[2] ^= paramArrayOfLong2[2];
    paramArrayOfLong1[3] ^= paramArrayOfLong2[3];
    paramArrayOfLong1[4] ^= paramArrayOfLong2[4];
    long l = paramArrayOfLong1[5];
    paramArrayOfLong2[5] ^= l;
  }
  
  public static void c(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= 1L;
    paramArrayOfLong2[1] = paramArrayOfLong1[1];
    paramArrayOfLong2[2] = paramArrayOfLong1[2];
  }
  
  public static long[] d(BigInteger paramBigInteger)
  {
    paramBigInteger = e.o(paramBigInteger);
    m(paramBigInteger, 0);
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
    paramArrayOfLong[0] = (l1 ^ l2 << 55);
    paramArrayOfLong[1] = (l2 >>> 9 ^ l3 << 46);
    paramArrayOfLong[2] = (l3 >>> 18 ^ l4 << 37);
    paramArrayOfLong[3] = (l4 >>> 27 ^ l5 << 28);
    paramArrayOfLong[4] = (l5 >>> 36 ^ l6 << 19);
    paramArrayOfLong[5] = (l6 >>> 45);
  }
  
  protected static void f(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2] << 18 ^ l2 >>> 46;
    long l4 = (l2 << 9 ^ l1 >>> 55) & 0x7FFFFFFFFFFFFF;
    l1 &= 0x7FFFFFFFFFFFFF;
    long l5 = paramArrayOfLong2[0];
    long l6 = paramArrayOfLong2[1];
    l2 = l6 >>> 46 ^ paramArrayOfLong2[2] << 18;
    l6 = (l5 >>> 55 ^ l6 << 9) & 0x7FFFFFFFFFFFFF;
    long l7 = l5 & 0x7FFFFFFFFFFFFF;
    paramArrayOfLong1 = new long[10];
    g(l1, l7, paramArrayOfLong1, 0);
    g(l3, l2, paramArrayOfLong1, 2);
    long l8 = l1 ^ l4 ^ l3;
    l5 = l7 ^ l6 ^ l2;
    g(l8, l5, paramArrayOfLong1, 4);
    l3 = l4 << 1 ^ l3 << 2;
    l2 = l6 << 1 ^ l2 << 2;
    g(l1 ^ l3, l7 ^ l2, paramArrayOfLong1, 6);
    g(l8 ^ l3, l5 ^ l2, paramArrayOfLong1, 8);
    l7 = paramArrayOfLong1[6] ^ paramArrayOfLong1[8];
    l4 = paramArrayOfLong1[7] ^ paramArrayOfLong1[9];
    l5 = paramArrayOfLong1[6];
    l6 = paramArrayOfLong1[7];
    l3 = paramArrayOfLong1[0];
    l2 = paramArrayOfLong1[1] ^ paramArrayOfLong1[0] ^ paramArrayOfLong1[4];
    l1 = paramArrayOfLong1[1] ^ paramArrayOfLong1[5];
    l5 = l7 << 1 ^ l5 ^ l3 ^ paramArrayOfLong1[2] << 4 ^ paramArrayOfLong1[2] << 1;
    l6 = l7 ^ l4 << 1 ^ l6 ^ l2 ^ paramArrayOfLong1[3] << 4 ^ paramArrayOfLong1[3] << 1 ^ l5 >>> 55;
    l4 = l1 ^ l4 ^ l6 >>> 55;
    l6 &= 0x7FFFFFFFFFFFFF;
    l5 = (l5 & 0x7FFFFFFFFFFFFF) >>> 1 ^ (l6 & 1L) << 54;
    l5 ^= l5 << 1;
    l5 ^= l5 << 2;
    l5 ^= l5 << 4;
    l5 ^= l5 << 8;
    l5 ^= l5 << 16;
    l5 = (l5 ^ l5 << 32) & 0x7FFFFFFFFFFFFF;
    l6 = l6 >>> 1 ^ (l4 & 1L) << 54 ^ l5 >>> 54;
    l6 ^= l6 << 1;
    l6 ^= l6 << 2;
    l6 ^= l6 << 4;
    l6 ^= l6 << 8;
    l6 ^= l6 << 16;
    l6 = (l6 ^ l6 << 32) & 0x7FFFFFFFFFFFFF;
    l4 = l4 >>> 1 ^ l6 >>> 54;
    l4 ^= l4 << 1;
    l4 ^= l4 << 2;
    l4 ^= l4 << 4;
    l4 ^= l4 << 8;
    l4 ^= l4 << 16;
    l4 ^= l4 << 32;
    paramArrayOfLong3[0] = l3;
    paramArrayOfLong3[1] = (l2 ^ l5 ^ paramArrayOfLong1[2]);
    paramArrayOfLong3[2] = (l1 ^ l6 ^ l5 ^ paramArrayOfLong1[3]);
    paramArrayOfLong3[3] = (l4 ^ l6);
    paramArrayOfLong3[4] = (paramArrayOfLong1[2] ^ l4);
    paramArrayOfLong3[5] = paramArrayOfLong1[3];
    e(paramArrayOfLong3);
  }
  
  protected static void g(long paramLong1, long paramLong2, long[] paramArrayOfLong, int paramInt)
  {
    long[] arrayOfLong = new long[8];
    arrayOfLong[1] = paramLong2;
    arrayOfLong[2] = (arrayOfLong[1] << 1);
    arrayOfLong[3] = (arrayOfLong[2] ^ paramLong2);
    arrayOfLong[4] = (arrayOfLong[2] << 1);
    arrayOfLong[5] = (arrayOfLong[4] ^ paramLong2);
    arrayOfLong[6] = (arrayOfLong[3] << 1);
    arrayOfLong[7] = (arrayOfLong[6] ^ paramLong2);
    long l1 = arrayOfLong[((int)paramLong1 & 0x3)];
    paramLong2 = 0L;
    int i = 47;
    int j;
    long l2;
    long l3;
    do
    {
      j = (int)(paramLong1 >>> i);
      l2 = arrayOfLong[(j & 0x7)];
      l3 = arrayOfLong[(j >>> 3 & 0x7)];
      l3 = arrayOfLong[(j >>> 6 & 0x7)] << 6 ^ l2 ^ l3 << 3;
      l2 = l1 ^ l3 << i;
      l3 = paramLong2 ^ l3 >>> -i;
      j = i - 9;
      l1 = l2;
      paramLong2 = l3;
      i = j;
    } while (j > 0);
    paramArrayOfLong[paramInt] = (0x7FFFFFFFFFFFFF & l2);
    paramArrayOfLong[(paramInt + 1)] = (l2 >>> 55 ^ l3 << 9);
  }
  
  protected static void h(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    a.c(paramArrayOfLong1[0], paramArrayOfLong2, 0);
    a.c(paramArrayOfLong1[1], paramArrayOfLong2, 2);
    long l = paramArrayOfLong1[2];
    paramArrayOfLong2[4] = a.b((int)l);
    paramArrayOfLong2[5] = (a.e((int)(l >>> 32)) & 0xFFFFFFFF);
  }
  
  public static void i(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!e.v(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = e.h();
      long[] arrayOfLong2 = e.h();
      o(paramArrayOfLong1, arrayOfLong1);
      q(arrayOfLong1, 1, arrayOfLong2);
      j(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      q(arrayOfLong2, 1, arrayOfLong2);
      j(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      q(arrayOfLong1, 3, arrayOfLong2);
      j(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      q(arrayOfLong2, 3, arrayOfLong2);
      j(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      q(arrayOfLong1, 9, arrayOfLong2);
      j(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      q(arrayOfLong2, 9, arrayOfLong2);
      j(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      q(arrayOfLong1, 27, arrayOfLong2);
      j(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      q(arrayOfLong2, 27, arrayOfLong2);
      j(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      q(arrayOfLong1, 81, arrayOfLong2);
      j(arrayOfLong1, arrayOfLong2, paramArrayOfLong2);
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void j(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = e.j();
    f(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    l(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void k(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = e.j();
    f(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    b(paramArrayOfLong3, arrayOfLong, paramArrayOfLong3);
  }
  
  public static void l(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    long l5 = paramArrayOfLong1[4];
    long l6 = paramArrayOfLong1[5];
    l4 ^= l6 >>> 35 ^ l6 >>> 32 ^ l6 >>> 29 ^ l6 >>> 28;
    l3 = l3 ^ l6 << 29 ^ l6 << 32 ^ l6 << 35 ^ l6 << 36 ^ l5 >>> 28 ^ l5 >>> 35 ^ l5 >>> 32 ^ l5 >>> 29;
    l6 = l3 >>> 35;
    paramArrayOfLong2[0] = (l1 ^ l4 << 29 ^ l4 << 32 ^ l4 << 35 ^ l4 << 36 ^ l6 ^ l6 << 3 ^ l6 << 6 ^ l6 << 7);
    paramArrayOfLong2[1] = (l2 ^ l5 << 29 ^ l5 << 32 ^ l5 << 35 ^ l5 << 36 ^ l4 >>> 28 ^ l4 >>> 35 ^ l4 >>> 32 ^ l4 >>> 29);
    paramArrayOfLong2[2] = (0x7FFFFFFFF & l3);
  }
  
  public static void m(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 2;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 35;
    paramArrayOfLong[paramInt] = (l2 << 7 ^ l2 << 3 ^ l2 ^ l2 << 6 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x7FFFFFFFF);
  }
  
  public static void n(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = e.h();
    long l1 = a.f(paramArrayOfLong1[0]);
    long l2 = a.f(paramArrayOfLong1[1]);
    arrayOfLong[0] = (l1 >>> 32 | l2 & 0xFFFFFFFF00000000);
    long l3 = a.f(paramArrayOfLong1[2]);
    arrayOfLong[1] = (l3 >>> 32);
    j(arrayOfLong, a, paramArrayOfLong2);
    paramArrayOfLong2[0] ^= (l1 & 0xFFFFFFFF | l2 << 32);
    paramArrayOfLong2[1] ^= l3 & 0xFFFFFFFF;
  }
  
  public static void o(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = e.j();
    h(paramArrayOfLong1, arrayOfLong);
    l(arrayOfLong, paramArrayOfLong2);
  }
  
  public static void p(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = e.j();
    h(paramArrayOfLong1, arrayOfLong);
    b(paramArrayOfLong2, arrayOfLong, paramArrayOfLong2);
  }
  
  public static void q(long[] paramArrayOfLong1, int paramInt, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = e.j();
    h(paramArrayOfLong1, arrayOfLong);
    for (;;)
    {
      l(arrayOfLong, paramArrayOfLong2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      h(paramArrayOfLong2, arrayOfLong);
    }
  }
  
  public static int r(long[] paramArrayOfLong)
  {
    return (int)(paramArrayOfLong[0] ^ paramArrayOfLong[2] >>> 29) & 0x1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\g1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */