package e.a.b.a.a0.c;

import e.a.b.c.f;
import e.a.b.c.m;
import java.math.BigInteger;

public class x
{
  static final int[] a = { 58733, -2, -1, -1, -1, -1, -1 };
  static final int[] b = { 46280809, 13606, 1, 0, 0, 0, 0, 51930, -3, -1, -1, -1, -1, -1 };
  private static final int[] c = { -46280809, 51929, -2, -1, -1, -1, -1, 13605, 2 };
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((f.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[6] == -1) && (f.j(paramArrayOfInt3, a)))) {
      m.b(7, 6803, paramArrayOfInt3);
    }
  }
  
  public static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.s(7, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[6] == -1) && (f.j(paramArrayOfInt2, a)))) {
      m.b(7, 6803, paramArrayOfInt2);
    }
  }
  
  public static int[] c(BigInteger paramBigInteger)
  {
    paramBigInteger = f.h(paramBigInteger);
    if ((paramBigInteger[6] == -1) && (f.j(paramBigInteger, a))) {
      m.b(7, 6803, paramBigInteger);
    }
    return paramBigInteger;
  }
  
  public static void d(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = f.f();
    f.m(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    g(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void e(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((f.q(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[13] == -1) && (m.q(14, paramArrayOfInt3, b))))
    {
      paramArrayOfInt1 = c;
      if (m.e(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        m.t(14, paramArrayOfInt3, paramArrayOfInt1.length);
      }
    }
  }
  
  public static void f(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (f.l(paramArrayOfInt1)) {
      f.v(paramArrayOfInt2);
    } else {
      f.s(a, paramArrayOfInt1, paramArrayOfInt2);
    }
  }
  
  public static void g(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((f.o(6803, f.n(6803, paramArrayOfInt1, 7, paramArrayOfInt1, 0, paramArrayOfInt2, 0), paramArrayOfInt2, 0) != 0) || ((paramArrayOfInt2[6] == -1) && (f.j(paramArrayOfInt2, a)))) {
      m.b(7, 6803, paramArrayOfInt2);
    }
  }
  
  public static void h(int paramInt, int[] paramArrayOfInt)
  {
    if (((paramInt != 0) && (f.p(6803, paramInt, paramArrayOfInt, 0) != 0)) || ((paramArrayOfInt[6] == -1) && (f.j(paramArrayOfInt, a)))) {
      m.b(7, 6803, paramArrayOfInt);
    }
  }
  
  public static void i(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = f.f();
    f.r(paramArrayOfInt1, arrayOfInt);
    g(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void j(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = f.f();
    f.r(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      g(arrayOfInt, paramArrayOfInt2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      f.r(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  public static void k(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (f.s(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      m.L(7, 6803, paramArrayOfInt3);
    }
  }
  
  public static void l(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.E(7, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[6] == -1) && (f.j(paramArrayOfInt2, a)))) {
      m.b(7, 6803, paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */