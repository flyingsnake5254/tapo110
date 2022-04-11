package e.a.b.a.a0.a;

import e.a.b.c.g;
import e.a.b.c.m;
import java.math.BigInteger;

public class b
{
  static final int[] a = { -19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE };
  private static final int[] b = { 361, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, 1073741823 };
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    g.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    if (g.s(paramArrayOfInt3, a)) {
      m(paramArrayOfInt3);
    }
  }
  
  public static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    m.s(8, paramArrayOfInt1, paramArrayOfInt2);
    if (g.s(paramArrayOfInt2, a)) {
      m(paramArrayOfInt2);
    }
  }
  
  private static int c(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) - 19L;
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L) {
      l1 = m.m(7, paramArrayOfInt, 1);
    }
    l1 += (0xFFFFFFFF & paramArrayOfInt[7]) + 2147483648L;
    paramArrayOfInt[7] = ((int)l1);
    return (int)(l1 >> 32);
  }
  
  public static int[] d(BigInteger paramBigInteger)
  {
    paramBigInteger = g.o(paramBigInteger);
    for (;;)
    {
      int[] arrayOfInt = a;
      if (!g.s(paramBigInteger, arrayOfInt)) {
        break;
      }
      g.I(arrayOfInt, paramBigInteger);
    }
    return paramBigInteger;
  }
  
  public static void e(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = g.j();
    g.y(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    h(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void f(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    g.C(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    if (m.q(16, paramArrayOfInt3, b)) {
      l(paramArrayOfInt3);
    }
  }
  
  public static void g(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (g.v(paramArrayOfInt1)) {
      g.L(paramArrayOfInt2);
    } else {
      g.H(a, paramArrayOfInt1, paramArrayOfInt2);
    }
  }
  
  public static void h(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = paramArrayOfInt1[7];
    m.D(8, paramArrayOfInt1, 8, i, paramArrayOfInt2, 0);
    int j = g.D(19, paramArrayOfInt1, paramArrayOfInt2);
    int k = paramArrayOfInt2[7];
    paramArrayOfInt2[7] = ((k & 0x7FFFFFFF) + m.g(7, ((j << 1) + ((k >>> 31) - (i >>> 31))) * 19, paramArrayOfInt2));
    if (g.s(paramArrayOfInt2, a)) {
      m(paramArrayOfInt2);
    }
  }
  
  public static void i(int paramInt, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[7];
    paramArrayOfInt[7] = ((i & 0x7FFFFFFF) + m.g(7, (paramInt << 1 | i >>> 31) * 19, paramArrayOfInt));
    if (g.s(paramArrayOfInt, a)) {
      m(paramArrayOfInt);
    }
  }
  
  public static void j(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = g.j();
    g.F(paramArrayOfInt1, arrayOfInt);
    h(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void k(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = g.j();
    g.F(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      h(arrayOfInt, paramArrayOfInt2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      g.F(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  private static int l(int[] paramArrayOfInt)
  {
    long l1 = paramArrayOfInt[0];
    int[] arrayOfInt = b;
    l1 = (l1 & 0xFFFFFFFF) - (arrayOfInt[0] & 0xFFFFFFFF);
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L) {
      l1 = m.m(8, paramArrayOfInt, 1);
    }
    l1 += (paramArrayOfInt[8] & 0xFFFFFFFF) + 19L;
    paramArrayOfInt[8] = ((int)l1);
    l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L) {
      l1 = m.t(15, paramArrayOfInt, 9);
    }
    l1 += (paramArrayOfInt[15] & 0xFFFFFFFF) - (0xFFFFFFFF & arrayOfInt[15] + 1);
    paramArrayOfInt[15] = ((int)l1);
    return (int)(l1 >> 32);
  }
  
  private static int m(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) + 19L;
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L) {
      l1 = m.t(7, paramArrayOfInt, 1);
    }
    l1 += (0xFFFFFFFF & paramArrayOfInt[7]) - 2147483648L;
    paramArrayOfInt[7] = ((int)l1);
    return (int)(l1 >> 32);
  }
  
  public static void n(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (g.H(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      c(paramArrayOfInt3);
    }
  }
  
  public static void o(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    m.E(8, paramArrayOfInt1, 0, paramArrayOfInt2);
    if (g.s(paramArrayOfInt2, a)) {
      m(paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */