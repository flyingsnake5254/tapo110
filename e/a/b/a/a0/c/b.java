package e.a.b.a.a0.c;

import e.a.b.c.c;
import e.a.b.c.g;
import e.a.b.c.m;
import java.math.BigInteger;

public class b
{
  static final int[] a = { -1, -1, -1, -3 };
  static final int[] b = { 1, 0, 0, 4, -2, -1, 3, -4 };
  private static final int[] c = { -1, -1, -1, -5, 1, 0, -4, 3 };
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((c.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[3] >>> 1 >= 2147483646) && (c.n(paramArrayOfInt3, a)))) {
      c(paramArrayOfInt3);
    }
  }
  
  public static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.s(4, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[3] >>> 1 >= 2147483646) && (c.n(paramArrayOfInt2, a)))) {
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
      l1 = (l1 >> 32) + (paramArrayOfInt[2] & 0xFFFFFFFF);
      paramArrayOfInt[2] = ((int)l1);
      l1 >>= 32;
    }
    paramArrayOfInt[3] = ((int)(l1 + ((0xFFFFFFFF & paramArrayOfInt[3]) + 2L)));
  }
  
  public static int[] d(BigInteger paramBigInteger)
  {
    int[] arrayOfInt = c.k(paramBigInteger);
    if (arrayOfInt[3] >>> 1 >= 2147483646)
    {
      paramBigInteger = a;
      if (c.n(arrayOfInt, paramBigInteger)) {
        c.w(paramBigInteger, arrayOfInt);
      }
    }
    return arrayOfInt;
  }
  
  public static void e(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = c.g();
    c.s(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    h(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void f(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((c.t(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[7] >>> 1 >= 2147483646) && (g.s(paramArrayOfInt3, b))))
    {
      paramArrayOfInt1 = c;
      m.e(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3);
    }
  }
  
  public static void g(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (c.q(paramArrayOfInt1)) {
      c.z(paramArrayOfInt2);
    } else {
      c.v(a, paramArrayOfInt1, paramArrayOfInt2);
    }
  }
  
  public static void h(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l1 = paramArrayOfInt1[0];
    long l2 = paramArrayOfInt1[1];
    long l3 = paramArrayOfInt1[2];
    long l4 = paramArrayOfInt1[3];
    long l5 = paramArrayOfInt1[4];
    long l6 = paramArrayOfInt1[5];
    long l7 = paramArrayOfInt1[6];
    long l8 = paramArrayOfInt1[7] & 0xFFFFFFFF;
    l7 = (l7 & 0xFFFFFFFF) + (l8 << 1);
    l6 = (l6 & 0xFFFFFFFF) + (l7 << 1);
    l5 = (l5 & 0xFFFFFFFF) + (l6 << 1);
    l1 = (l1 & 0xFFFFFFFF) + l5;
    paramArrayOfInt2[0] = ((int)l1);
    l2 = (l2 & 0xFFFFFFFF) + l6 + (l1 >>> 32);
    paramArrayOfInt2[1] = ((int)l2);
    l3 = (l3 & 0xFFFFFFFF) + l7 + (l2 >>> 32);
    paramArrayOfInt2[2] = ((int)l3);
    l4 = (l4 & 0xFFFFFFFF) + l8 + (l5 << 1) + (l3 >>> 32);
    paramArrayOfInt2[3] = ((int)l4);
    i((int)(l4 >>> 32), paramArrayOfInt2);
  }
  
  public static void i(int paramInt, int[] paramArrayOfInt)
  {
    while (paramInt != 0)
    {
      long l1 = paramInt & 0xFFFFFFFF;
      long l2 = (paramArrayOfInt[0] & 0xFFFFFFFF) + l1;
      paramArrayOfInt[0] = ((int)l2);
      long l3 = l2 >> 32;
      l2 = l3;
      if (l3 != 0L)
      {
        l2 = l3 + (paramArrayOfInt[1] & 0xFFFFFFFF);
        paramArrayOfInt[1] = ((int)l2);
        l2 = (l2 >> 32) + (paramArrayOfInt[2] & 0xFFFFFFFF);
        paramArrayOfInt[2] = ((int)l2);
        l2 >>= 32;
      }
      l2 += (0xFFFFFFFF & paramArrayOfInt[3]) + (l1 << 1);
      paramArrayOfInt[3] = ((int)l2);
      paramInt = (int)(l2 >> 32);
    }
  }
  
  public static void j(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = c.g();
    c.u(paramArrayOfInt1, arrayOfInt);
    h(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void k(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = c.g();
    c.u(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      h(arrayOfInt, paramArrayOfInt2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      c.u(paramArrayOfInt2, arrayOfInt);
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
      l1 = (l1 >> 32) + (paramArrayOfInt[2] & 0xFFFFFFFF);
      paramArrayOfInt[2] = ((int)l1);
      l1 >>= 32;
    }
    paramArrayOfInt[3] = ((int)(l1 + ((0xFFFFFFFF & paramArrayOfInt[3]) - 2L)));
  }
  
  public static void m(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (c.v(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      l(paramArrayOfInt3);
    }
  }
  
  public static void n(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.E(4, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[3] >>> 1 >= 2147483646) && (c.n(paramArrayOfInt2, a)))) {
      c(paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */