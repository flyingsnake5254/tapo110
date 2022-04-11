package e.a.b.a.a0.c;

import e.a.b.c.e;
import e.a.b.c.m;
import java.math.BigInteger;

public class p
{
  static final int[] a = { 60983, -2, -1, -1, -1, -1 };
  static final int[] b = { 20729809, 9106, 1, 0, 0, 0, 56430, -3, -1, -1, -1, -1 };
  private static final int[] c = { -20729809, 56429, -2, -1, -1, -1, 9105, 2 };
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((e.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[5] == -1) && (e.r(paramArrayOfInt3, a)))) {
      m.b(6, 4553, paramArrayOfInt3);
    }
  }
  
  public static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.s(6, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[5] == -1) && (e.r(paramArrayOfInt2, a)))) {
      m.b(6, 4553, paramArrayOfInt2);
    }
  }
  
  public static int[] c(BigInteger paramBigInteger)
  {
    int[] arrayOfInt = e.n(paramBigInteger);
    if (arrayOfInt[5] == -1)
    {
      paramBigInteger = a;
      if (e.r(arrayOfInt, paramBigInteger)) {
        e.G(paramBigInteger, arrayOfInt);
      }
    }
    return arrayOfInt;
  }
  
  public static void d(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = e.i();
    e.x(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    g(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void e(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((e.B(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[11] == -1) && (m.q(12, paramArrayOfInt3, b))))
    {
      paramArrayOfInt1 = c;
      if (m.e(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        m.t(12, paramArrayOfInt3, paramArrayOfInt1.length);
      }
    }
  }
  
  public static void f(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (e.u(paramArrayOfInt1)) {
      e.J(paramArrayOfInt2);
    } else {
      e.F(a, paramArrayOfInt1, paramArrayOfInt2);
    }
  }
  
  public static void g(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((e.z(4553, e.y(4553, paramArrayOfInt1, 6, paramArrayOfInt1, 0, paramArrayOfInt2, 0), paramArrayOfInt2, 0) != 0) || ((paramArrayOfInt2[5] == -1) && (e.r(paramArrayOfInt2, a)))) {
      m.b(6, 4553, paramArrayOfInt2);
    }
  }
  
  public static void h(int paramInt, int[] paramArrayOfInt)
  {
    if (((paramInt != 0) && (e.A(4553, paramInt, paramArrayOfInt, 0) != 0)) || ((paramArrayOfInt[5] == -1) && (e.r(paramArrayOfInt, a)))) {
      m.b(6, 4553, paramArrayOfInt);
    }
  }
  
  public static void i(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = e.i();
    e.D(paramArrayOfInt1, arrayOfInt);
    g(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void j(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = e.i();
    e.D(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      g(arrayOfInt, paramArrayOfInt2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      e.D(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  public static void k(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (e.F(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      m.L(6, 4553, paramArrayOfInt3);
    }
  }
  
  public static void l(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.E(6, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[5] == -1) && (e.r(paramArrayOfInt2, a)))) {
      m.b(6, 4553, paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */