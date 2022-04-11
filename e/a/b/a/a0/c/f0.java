package e.a.b.a.a0.c;

import e.a.b.c.g;
import e.a.b.c.m;
import java.math.BigInteger;

public class f0
{
  static final int[] a = { 64559, -2, -1, -1, -1, -1, -1, -1 };
  static final int[] b = { 954529, 1954, 1, 0, 0, 0, 0, 0, 63582, -3, -1, -1, -1, -1, -1, -1 };
  private static final int[] c = { -954529, 63581, -2, -1, -1, -1, -1, -1, 1953, 2 };
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((g.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[7] == -1) && (g.s(paramArrayOfInt3, a)))) {
      m.b(8, 977, paramArrayOfInt3);
    }
  }
  
  public static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.s(8, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[7] == -1) && (g.s(paramArrayOfInt2, a)))) {
      m.b(8, 977, paramArrayOfInt2);
    }
  }
  
  public static int[] c(BigInteger paramBigInteger)
  {
    paramBigInteger = g.o(paramBigInteger);
    if (paramBigInteger[7] == -1)
    {
      int[] arrayOfInt = a;
      if (g.s(paramBigInteger, arrayOfInt)) {
        g.I(arrayOfInt, paramBigInteger);
      }
    }
    return paramBigInteger;
  }
  
  public static void d(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = g.j();
    g.y(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    g(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void e(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((g.C(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[15] == -1) && (m.q(16, paramArrayOfInt3, b))))
    {
      paramArrayOfInt1 = c;
      if (m.e(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        m.t(16, paramArrayOfInt3, paramArrayOfInt1.length);
      }
    }
  }
  
  public static void f(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (g.v(paramArrayOfInt1)) {
      g.L(paramArrayOfInt2);
    } else {
      g.H(a, paramArrayOfInt1, paramArrayOfInt2);
    }
  }
  
  public static void g(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((g.A(977, g.z(977, paramArrayOfInt1, 8, paramArrayOfInt1, 0, paramArrayOfInt2, 0), paramArrayOfInt2, 0) != 0) || ((paramArrayOfInt2[7] == -1) && (g.s(paramArrayOfInt2, a)))) {
      m.b(8, 977, paramArrayOfInt2);
    }
  }
  
  public static void h(int paramInt, int[] paramArrayOfInt)
  {
    if (((paramInt != 0) && (g.B(977, paramInt, paramArrayOfInt, 0) != 0)) || ((paramArrayOfInt[7] == -1) && (g.s(paramArrayOfInt, a)))) {
      m.b(8, 977, paramArrayOfInt);
    }
  }
  
  public static void i(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = g.j();
    g.F(paramArrayOfInt1, arrayOfInt);
    g(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void j(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = g.j();
    g.F(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      g(arrayOfInt, paramArrayOfInt2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      g.F(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  public static void k(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (g.H(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      m.L(8, 977, paramArrayOfInt3);
    }
  }
  
  public static void l(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.E(8, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[7] == -1) && (g.s(paramArrayOfInt2, a)))) {
      m.b(8, 977, paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */