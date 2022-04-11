package e.a.b.a.a0.c;

import e.a.b.c.e;
import e.a.b.c.m;
import java.math.BigInteger;

public class t
{
  static final int[] a = { -1, -1, -2, -1, -1, -1 };
  static final int[] b = { 1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1 };
  private static final int[] c = { -1, -1, -3, -1, -2, -1, 1, 0, 2 };
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((e.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[5] == -1) && (e.r(paramArrayOfInt3, a)))) {
      c(paramArrayOfInt3);
    }
  }
  
  public static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.s(6, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[5] == -1) && (e.r(paramArrayOfInt2, a)))) {
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
    l1 += (0xFFFFFFFF & paramArrayOfInt[2]) + 1L;
    paramArrayOfInt[2] = ((int)l1);
    if (l1 >> 32 != 0L) {
      m.t(6, paramArrayOfInt, 3);
    }
  }
  
  public static int[] d(BigInteger paramBigInteger)
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
  
  public static void e(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = e.i();
    e.x(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    h(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void f(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((e.B(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[11] == -1) && (m.q(12, paramArrayOfInt3, b))))
    {
      paramArrayOfInt1 = c;
      if (m.e(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        m.t(12, paramArrayOfInt3, paramArrayOfInt1.length);
      }
    }
  }
  
  public static void g(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (e.u(paramArrayOfInt1)) {
      e.J(paramArrayOfInt2);
    } else {
      e.F(a, paramArrayOfInt1, paramArrayOfInt2);
    }
  }
  
  public static void h(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l1 = paramArrayOfInt1[6] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt1[7] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt1[8];
    long l4 = paramArrayOfInt1[9];
    long l5 = paramArrayOfInt1[10];
    long l6 = paramArrayOfInt1[11];
    l5 = (l5 & 0xFFFFFFFF) + l1;
    long l7 = (l6 & 0xFFFFFFFF) + l2;
    l6 = (paramArrayOfInt1[0] & 0xFFFFFFFF) + l5 + 0L;
    int i = (int)l6;
    l6 = (l6 >> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + l7);
    paramArrayOfInt2[1] = ((int)l6);
    l3 = l5 + (l3 & 0xFFFFFFFF);
    l5 = l7 + (l4 & 0xFFFFFFFF);
    l4 = (l6 >> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) + l3);
    l6 = (l4 >> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + l5);
    paramArrayOfInt2[3] = ((int)l6);
    l1 = (l6 >> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + (l3 - l1));
    paramArrayOfInt2[4] = ((int)l1);
    l2 = (l1 >> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) + (l5 - l2));
    paramArrayOfInt2[5] = ((int)l2);
    l2 >>= 32;
    l1 = (l4 & 0xFFFFFFFF) + l2;
    l2 += (i & 0xFFFFFFFF);
    paramArrayOfInt2[0] = ((int)l2);
    l4 = l2 >> 32;
    l2 = l1;
    if (l4 != 0L)
    {
      l2 = l4 + (0xFFFFFFFF & paramArrayOfInt2[1]);
      paramArrayOfInt2[1] = ((int)l2);
      l2 = l1 + (l2 >> 32);
    }
    paramArrayOfInt2[2] = ((int)l2);
    if (((l2 >> 32 != 0L) && (m.t(6, paramArrayOfInt2, 3) != 0)) || ((paramArrayOfInt2[5] == -1) && (e.r(paramArrayOfInt2, a)))) {
      c(paramArrayOfInt2);
    }
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
      l2 += (0xFFFFFFFF & paramArrayOfInt[2]) + l1;
      paramArrayOfInt[2] = ((int)l2);
      l2 >>= 32;
    }
    else
    {
      l2 = 0L;
    }
    if (((l2 != 0L) && (m.t(6, paramArrayOfInt, 3) != 0)) || ((paramArrayOfInt[5] == -1) && (e.r(paramArrayOfInt, a)))) {
      c(paramArrayOfInt);
    }
  }
  
  public static void j(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = e.i();
    e.D(paramArrayOfInt1, arrayOfInt);
    h(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void k(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = e.i();
    e.D(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      h(arrayOfInt, paramArrayOfInt2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      e.D(paramArrayOfInt2, arrayOfInt);
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
    l1 += (0xFFFFFFFF & paramArrayOfInt[2]) - 1L;
    paramArrayOfInt[2] = ((int)l1);
    if (l1 >> 32 != 0L) {
      m.m(6, paramArrayOfInt, 3);
    }
  }
  
  public static void m(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (e.F(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      l(paramArrayOfInt3);
    }
  }
  
  public static void n(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.E(6, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[5] == -1) && (e.r(paramArrayOfInt2, a)))) {
      c(paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */