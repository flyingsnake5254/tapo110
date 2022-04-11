package e.a.b.a.a0.c;

import e.a.b.c.a;
import e.a.b.c.l;
import e.a.b.c.m;
import java.math.BigInteger;

public class q2
{
  private static final long[] a = { 3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L };
  
  private static void a(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, long[] paramArrayOfLong3, int paramInt3)
  {
    for (int i = 0; i < 9; i++) {
      paramArrayOfLong1[(paramInt1 + i)] ^= paramArrayOfLong2[(paramInt2 + i)];
    }
  }
  
  public static void b(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    for (int i = 0; i < 9; i++) {
      paramArrayOfLong1[i] ^= paramArrayOfLong2[i];
    }
  }
  
  private static void c(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, long[] paramArrayOfLong3, int paramInt3)
  {
    for (int i = 0; i < 9; i++)
    {
      int j = paramInt3 + i;
      paramArrayOfLong3[j] ^= paramArrayOfLong1[(paramInt1 + i)] ^ paramArrayOfLong2[(paramInt2 + i)];
    }
  }
  
  public static void d(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    for (int i = 0; i < 9; i++) {
      paramArrayOfLong3[i] ^= paramArrayOfLong1[i] ^ paramArrayOfLong2[i];
    }
  }
  
  public static void e(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    for (int i = 0; i < 18; i++) {
      paramArrayOfLong1[i] ^= paramArrayOfLong2[i];
    }
  }
  
  public static void f(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= 1L;
    for (int i = 1; i < 9; i++) {
      paramArrayOfLong2[i] = paramArrayOfLong1[i];
    }
  }
  
  public static long[] g(BigInteger paramBigInteger)
  {
    paramBigInteger = l.e(paramBigInteger);
    r(paramBigInteger, 0);
    return paramBigInteger;
  }
  
  protected static void h(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    i(paramArrayOfLong1, p(paramArrayOfLong2), paramArrayOfLong3);
  }
  
  protected static void i(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    int i = 56;
    int k;
    for (int j = 56;; j -= 8)
    {
      k = i;
      if (j < 0) {
        break;
      }
      for (k = 1; k < 9; k += 2)
      {
        int m = (int)(paramArrayOfLong1[k] >>> j);
        c(paramArrayOfLong2, (m & 0xF) * 9, paramArrayOfLong2, ((m >>> 4 & 0xF) + 16) * 9, paramArrayOfLong3, k - 1);
      }
      m.I(16, paramArrayOfLong3, 0, 8, 0L);
    }
    while (k >= 0)
    {
      for (j = 0; j < 9; j += 2)
      {
        i = (int)(paramArrayOfLong1[j] >>> k);
        c(paramArrayOfLong2, (i & 0xF) * 9, paramArrayOfLong2, ((i >>> 4 & 0xF) + 16) * 9, paramArrayOfLong3, j);
      }
      if (k > 0) {
        m.I(18, paramArrayOfLong3, 0, 8, 0L);
      }
      k -= 8;
    }
  }
  
  protected static void j(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    for (int i = 0; i < 9; i++) {
      a.c(paramArrayOfLong1[i], paramArrayOfLong2, i << 1);
    }
  }
  
  public static void k(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!l.g(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = l.b();
      long[] arrayOfLong2 = l.b();
      long[] arrayOfLong3 = l.b();
      t(paramArrayOfLong1, arrayOfLong3);
      t(arrayOfLong3, arrayOfLong1);
      t(arrayOfLong1, arrayOfLong2);
      l(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      v(arrayOfLong1, 2, arrayOfLong2);
      l(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      l(arrayOfLong1, arrayOfLong3, arrayOfLong1);
      v(arrayOfLong1, 5, arrayOfLong2);
      l(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      v(arrayOfLong2, 5, arrayOfLong2);
      l(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      v(arrayOfLong1, 15, arrayOfLong2);
      l(arrayOfLong1, arrayOfLong2, arrayOfLong3);
      v(arrayOfLong3, 30, arrayOfLong1);
      v(arrayOfLong1, 30, arrayOfLong2);
      l(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      v(arrayOfLong1, 60, arrayOfLong2);
      l(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      v(arrayOfLong2, 60, arrayOfLong2);
      l(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      v(arrayOfLong1, 180, arrayOfLong2);
      l(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      v(arrayOfLong2, 180, arrayOfLong2);
      l(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      l(arrayOfLong1, arrayOfLong3, paramArrayOfLong2);
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void l(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = l.c();
    h(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    q(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void m(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = l.c();
    h(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    e(paramArrayOfLong3, arrayOfLong, paramArrayOfLong3);
  }
  
  public static void n(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = l.c();
    i(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    q(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void o(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = l.c();
    i(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    e(paramArrayOfLong3, arrayOfLong, paramArrayOfLong3);
  }
  
  public static long[] p(long[] paramArrayOfLong)
  {
    long[] arrayOfLong = new long['Ġ'];
    int i = 0;
    System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 9, 9);
    for (int j = 7; j > 0; j--)
    {
      i += 18;
      m.F(9, arrayOfLong, i >>> 1, 0L, arrayOfLong, i);
      r(arrayOfLong, i);
      a(arrayOfLong, 9, arrayOfLong, i, arrayOfLong, i + 9);
    }
    m.J(144, arrayOfLong, 0, 4, 0L, arrayOfLong, 144);
    return arrayOfLong;
  }
  
  public static void q(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[9];
    long l2 = paramArrayOfLong1[17];
    l1 = l1 ^ l2 >>> 59 ^ l2 >>> 57 ^ l2 >>> 54 ^ l2 >>> 49;
    l2 = l2 << 15 ^ paramArrayOfLong1[8] ^ l2 << 5 ^ l2 << 7 ^ l2 << 10;
    for (int i = 16; i >= 10; i--)
    {
      l3 = paramArrayOfLong1[i];
      paramArrayOfLong2[(i - 8)] = (l2 ^ l3 >>> 59 ^ l3 >>> 57 ^ l3 >>> 54 ^ l3 >>> 49);
      l2 = paramArrayOfLong1[(i - 9)] ^ l3 << 5 ^ l3 << 7 ^ l3 << 10 ^ l3 << 15;
    }
    paramArrayOfLong2[1] = (l2 ^ l1 >>> 59 ^ l1 >>> 57 ^ l1 >>> 54 ^ l1 >>> 49);
    l2 = paramArrayOfLong1[0];
    long l4 = paramArrayOfLong2[8];
    long l3 = l4 >>> 59;
    paramArrayOfLong2[0] = (l1 << 15 ^ l2 ^ l1 << 5 ^ l1 << 7 ^ l1 << 10 ^ l3 ^ l3 << 2 ^ l3 << 5 ^ l3 << 10);
    paramArrayOfLong2[8] = (0x7FFFFFFFFFFFFFF & l4);
  }
  
  public static void r(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 8;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 59;
    paramArrayOfLong[paramInt] = (l2 << 10 ^ l2 << 2 ^ l2 ^ l2 << 5 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x7FFFFFFFFFFFFFF);
  }
  
  public static void s(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong1 = l.b();
    long[] arrayOfLong2 = l.b();
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      int k = j + 1;
      l1 = a.f(paramArrayOfLong1[j]);
      j = k + 1;
      long l2 = a.f(paramArrayOfLong1[k]);
      arrayOfLong1[i] = (0xFFFFFFFF & l1 | l2 << 32);
      arrayOfLong2[i] = (l1 >>> 32 | 0xFFFFFFFF00000000 & l2);
      i++;
    }
    long l1 = a.f(paramArrayOfLong1[j]);
    arrayOfLong1[4] = (0xFFFFFFFF & l1);
    arrayOfLong2[4] = (l1 >>> 32);
    l(arrayOfLong2, a, paramArrayOfLong2);
    b(paramArrayOfLong2, arrayOfLong1, paramArrayOfLong2);
  }
  
  public static void t(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = l.c();
    j(paramArrayOfLong1, arrayOfLong);
    q(arrayOfLong, paramArrayOfLong2);
  }
  
  public static void u(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = l.c();
    j(paramArrayOfLong1, arrayOfLong);
    e(paramArrayOfLong2, arrayOfLong, paramArrayOfLong2);
  }
  
  public static void v(long[] paramArrayOfLong1, int paramInt, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = l.c();
    j(paramArrayOfLong1, arrayOfLong);
    for (;;)
    {
      q(arrayOfLong, paramArrayOfLong2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      j(paramArrayOfLong2, arrayOfLong);
    }
  }
  
  public static int w(long[] paramArrayOfLong)
  {
    return (int)(paramArrayOfLong[0] ^ paramArrayOfLong[8] >>> 49 ^ paramArrayOfLong[8] >>> 57) & 0x1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\q2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */