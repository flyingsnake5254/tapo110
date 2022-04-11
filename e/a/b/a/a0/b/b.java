package e.a.b.a.a0.b;

import e.a.b.c.g;
import e.a.b.c.m;
import java.math.BigInteger;

public class b
{
  static final int[] a = { -1, -1, 0, -1, -1, -1, -1, -2 };
  static final int[] b = { 1, 0, -2, 1, 1, -2, 0, 2, -2, -3, 3, -2, -1, -1, 0, -2 };
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((g.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[7] >>> 1 >= Integer.MAX_VALUE) && (g.s(paramArrayOfInt3, a)))) {
      c(paramArrayOfInt3);
    }
  }
  
  public static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.s(8, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[7] >>> 1 >= Integer.MAX_VALUE) && (g.s(paramArrayOfInt2, a)))) {
      c(paramArrayOfInt2);
    }
  }
  
  private static void c(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) + 1L;
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[1] & 0xFFFFFFFF);
      paramArrayOfInt[1] = ((int)l1);
      l1 >>= 32;
    }
    l1 += (paramArrayOfInt[2] & 0xFFFFFFFF) - 1L;
    paramArrayOfInt[2] = ((int)l1);
    l1 = (l1 >> 32) + ((paramArrayOfInt[3] & 0xFFFFFFFF) + 1L);
    paramArrayOfInt[3] = ((int)l1);
    l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[4] & 0xFFFFFFFF);
      paramArrayOfInt[4] = ((int)l1);
      l1 = (l1 >> 32) + (paramArrayOfInt[5] & 0xFFFFFFFF);
      paramArrayOfInt[5] = ((int)l1);
      l1 = (l1 >> 32) + (paramArrayOfInt[6] & 0xFFFFFFFF);
      paramArrayOfInt[6] = ((int)l1);
      l1 >>= 32;
    }
    paramArrayOfInt[7] = ((int)(l1 + ((0xFFFFFFFF & paramArrayOfInt[7]) + 1L)));
  }
  
  public static int[] d(BigInteger paramBigInteger)
  {
    paramBigInteger = g.o(paramBigInteger);
    if (paramBigInteger[7] >>> 1 >= Integer.MAX_VALUE)
    {
      int[] arrayOfInt = a;
      if (g.s(paramBigInteger, arrayOfInt)) {
        g.I(arrayOfInt, paramBigInteger);
      }
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
    if ((g.C(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[15] >>> 1 >= Integer.MAX_VALUE) && (m.q(16, paramArrayOfInt3, b)))) {
      m.N(16, b, paramArrayOfInt3);
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
    long l1 = paramArrayOfInt1[8] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt1[9] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt1[10] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt1[11] & 0xFFFFFFFF;
    long l5 = paramArrayOfInt1[12] & 0xFFFFFFFF;
    long l6 = paramArrayOfInt1[13] & 0xFFFFFFFF;
    long l7 = paramArrayOfInt1[14] & 0xFFFFFFFF;
    long l8 = paramArrayOfInt1[15] & 0xFFFFFFFF;
    long l9 = l3 + l4;
    long l10 = l6 + l7;
    long l11 = l10 + (l8 << 1);
    long l12 = l1 + l2 + l10;
    l10 = l9 + (l5 + l8) + l12;
    long l13 = (paramArrayOfInt1[0] & 0xFFFFFFFF) + l10 + l6 + l7 + l8 + 0L;
    paramArrayOfInt2[0] = ((int)l13);
    l13 = (l13 >> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + l10 - l1 + l7 + l8);
    paramArrayOfInt2[1] = ((int)l13);
    l12 = (l13 >> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) - l12);
    paramArrayOfInt2[2] = ((int)l12);
    l6 = (l12 >> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + l10 - l2 - l3 + l6);
    paramArrayOfInt2[3] = ((int)l6);
    l1 = (l6 >> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + l10 - l9 - l1 + l7);
    paramArrayOfInt2[4] = ((int)l1);
    l3 = (l1 >> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) + l11 + l3);
    paramArrayOfInt2[5] = ((int)l3);
    l8 = (l3 >> 32) + ((paramArrayOfInt1[6] & 0xFFFFFFFF) + l4 + l7 + l8);
    paramArrayOfInt2[6] = ((int)l8);
    l5 = (l8 >> 32) + ((0xFFFFFFFF & paramArrayOfInt1[7]) + l10 + l11 + l5);
    paramArrayOfInt2[7] = ((int)l5);
    i((int)(l5 >> 32), paramArrayOfInt2);
  }
  
  public static void i(int paramInt, int[] paramArrayOfInt)
  {
    long l2;
    if (paramInt != 0)
    {
      long l1 = paramInt & 0xFFFFFFFF;
      l2 = (paramArrayOfInt[0] & 0xFFFFFFFF) + l1 + 0L;
      paramArrayOfInt[0] = ((int)l2);
      long l3 = l2 >> 32;
      l2 = l3;
      if (l3 != 0L)
      {
        l2 = l3 + (paramArrayOfInt[1] & 0xFFFFFFFF);
        paramArrayOfInt[1] = ((int)l2);
        l2 >>= 32;
      }
      l2 += (paramArrayOfInt[2] & 0xFFFFFFFF) - l1;
      paramArrayOfInt[2] = ((int)l2);
      l2 = (l2 >> 32) + ((paramArrayOfInt[3] & 0xFFFFFFFF) + l1);
      paramArrayOfInt[3] = ((int)l2);
      l3 = l2 >> 32;
      l2 = l3;
      if (l3 != 0L)
      {
        l2 = l3 + (paramArrayOfInt[4] & 0xFFFFFFFF);
        paramArrayOfInt[4] = ((int)l2);
        l2 = (l2 >> 32) + (paramArrayOfInt[5] & 0xFFFFFFFF);
        paramArrayOfInt[5] = ((int)l2);
        l2 = (l2 >> 32) + (paramArrayOfInt[6] & 0xFFFFFFFF);
        paramArrayOfInt[6] = ((int)l2);
        l2 >>= 32;
      }
      l2 += (0xFFFFFFFF & paramArrayOfInt[7]) + l1;
      paramArrayOfInt[7] = ((int)l2);
      l2 >>= 32;
    }
    else
    {
      l2 = 0L;
    }
    if ((l2 != 0L) || ((paramArrayOfInt[7] >>> 1 >= Integer.MAX_VALUE) && (g.s(paramArrayOfInt, a)))) {
      c(paramArrayOfInt);
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
  
  private static void l(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) - 1L;
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[1] & 0xFFFFFFFF);
      paramArrayOfInt[1] = ((int)l1);
      l1 >>= 32;
    }
    l1 += (paramArrayOfInt[2] & 0xFFFFFFFF) + 1L;
    paramArrayOfInt[2] = ((int)l1);
    l1 = (l1 >> 32) + ((paramArrayOfInt[3] & 0xFFFFFFFF) - 1L);
    paramArrayOfInt[3] = ((int)l1);
    l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[4] & 0xFFFFFFFF);
      paramArrayOfInt[4] = ((int)l1);
      l1 = (l1 >> 32) + (paramArrayOfInt[5] & 0xFFFFFFFF);
      paramArrayOfInt[5] = ((int)l1);
      l1 = (l1 >> 32) + (paramArrayOfInt[6] & 0xFFFFFFFF);
      paramArrayOfInt[6] = ((int)l1);
      l1 >>= 32;
    }
    paramArrayOfInt[7] = ((int)(l1 + ((0xFFFFFFFF & paramArrayOfInt[7]) - 1L)));
  }
  
  public static void m(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (g.H(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      l(paramArrayOfInt3);
    }
  }
  
  public static void n(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.E(8, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[7] >>> 1 >= Integer.MAX_VALUE) && (g.s(paramArrayOfInt2, a)))) {
      c(paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */