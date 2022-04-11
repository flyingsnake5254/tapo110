package e.a.b.a.a0.c;

import e.a.b.c.k;
import e.a.b.c.m;
import java.math.BigInteger;

public class r0
{
  static final int[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 511 };
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int i = m.a(16, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) + paramArrayOfInt1[16] + paramArrayOfInt2[16];
    int j;
    if (i <= 511)
    {
      j = i;
      if (i == 511)
      {
        j = i;
        if (!m.n(16, paramArrayOfInt3, a)) {}
      }
    }
    else
    {
      j = i + m.r(16, paramArrayOfInt3) & 0x1FF;
    }
    paramArrayOfInt3[16] = j;
  }
  
  public static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = m.s(16, paramArrayOfInt1, paramArrayOfInt2) + paramArrayOfInt1[16];
    int j;
    if (i <= 511)
    {
      j = i;
      if (i == 511)
      {
        j = i;
        if (!m.n(16, paramArrayOfInt2, a)) {}
      }
    }
    else
    {
      j = i + m.r(16, paramArrayOfInt2) & 0x1FF;
    }
    paramArrayOfInt2[16] = j;
  }
  
  public static int[] c(BigInteger paramBigInteger)
  {
    paramBigInteger = m.o(521, paramBigInteger);
    if (m.n(17, paramBigInteger, a)) {
      m.Q(17, paramBigInteger);
    }
    return paramBigInteger;
  }
  
  protected static void d(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    k.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    int i = paramArrayOfInt1[16];
    int j = paramArrayOfInt2[16];
    paramArrayOfInt3[32] = (m.x(16, i, paramArrayOfInt2, j, paramArrayOfInt1, paramArrayOfInt3, 16) + i * j);
  }
  
  protected static void e(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    k.b(paramArrayOfInt1, paramArrayOfInt2);
    int i = paramArrayOfInt1[16];
    paramArrayOfInt2[32] = (m.y(16, i << 1, paramArrayOfInt1, 0, paramArrayOfInt2, 16) + i * i);
  }
  
  public static void f(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = m.j(33);
    d(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    h(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void g(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (m.w(17, paramArrayOfInt1)) {
      m.Q(17, paramArrayOfInt2);
    } else {
      m.K(17, a, paramArrayOfInt1, paramArrayOfInt2);
    }
  }
  
  public static void h(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = paramArrayOfInt1[32];
    int j = (m.B(16, paramArrayOfInt1, 16, 9, i, paramArrayOfInt2, 0) >>> 23) + (i >>> 9) + m.e(16, paramArrayOfInt1, paramArrayOfInt2);
    if (j <= 511)
    {
      i = j;
      if (j == 511)
      {
        i = j;
        if (!m.n(16, paramArrayOfInt2, a)) {}
      }
    }
    else
    {
      i = j + m.r(16, paramArrayOfInt2) & 0x1FF;
    }
    paramArrayOfInt2[16] = i;
  }
  
  public static void i(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[16];
    int j = m.g(16, i >>> 9, paramArrayOfInt) + (i & 0x1FF);
    if (j <= 511)
    {
      i = j;
      if (j == 511)
      {
        i = j;
        if (!m.n(16, paramArrayOfInt, a)) {}
      }
    }
    else
    {
      i = j + m.r(16, paramArrayOfInt) & 0x1FF;
    }
    paramArrayOfInt[16] = i;
  }
  
  public static void j(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = m.j(33);
    e(paramArrayOfInt1, arrayOfInt);
    h(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void k(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = m.j(33);
    e(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      h(arrayOfInt, paramArrayOfInt2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      e(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  public static void l(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int i = m.K(16, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) + paramArrayOfInt1[16] - paramArrayOfInt2[16];
    int j = i;
    if (i < 0) {
      j = i + m.l(16, paramArrayOfInt3) & 0x1FF;
    }
    paramArrayOfInt3[16] = j;
  }
  
  public static void m(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = paramArrayOfInt1[16];
    paramArrayOfInt2[16] = ((m.E(16, paramArrayOfInt1, i << 23, paramArrayOfInt2) | i << 1) & 0x1FF);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\r0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */