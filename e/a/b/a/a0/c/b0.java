package e.a.b.a.a0.c;

import e.a.b.c.f;
import e.a.b.c.m;
import java.math.BigInteger;

public class b0
{
  static final int[] a = { 1, 0, 0, -1, -1, -1, -1 };
  static final int[] b = { 1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1 };
  private static final int[] c = { -1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1 };
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((f.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[6] == -1) && (f.j(paramArrayOfInt3, a)))) {
      c(paramArrayOfInt3);
    }
  }
  
  public static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.s(7, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[6] == -1) && (f.j(paramArrayOfInt2, a)))) {
      c(paramArrayOfInt2);
    }
  }
  
  private static void c(int[] paramArrayOfInt)
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
    l1 += (0xFFFFFFFF & paramArrayOfInt[3]) + 1L;
    paramArrayOfInt[3] = ((int)l1);
    if (l1 >> 32 != 0L) {
      m.t(7, paramArrayOfInt, 4);
    }
  }
  
  public static int[] d(BigInteger paramBigInteger)
  {
    paramBigInteger = f.h(paramBigInteger);
    if (paramBigInteger[6] == -1)
    {
      int[] arrayOfInt = a;
      if (f.j(paramBigInteger, arrayOfInt)) {
        f.t(arrayOfInt, paramBigInteger);
      }
    }
    return paramBigInteger;
  }
  
  public static void e(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = f.f();
    f.m(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    h(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void f(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((f.q(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[13] == -1) && (m.q(14, paramArrayOfInt3, b))))
    {
      paramArrayOfInt1 = c;
      if (m.e(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        m.t(14, paramArrayOfInt3, paramArrayOfInt1.length);
      }
    }
  }
  
  public static void g(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (f.l(paramArrayOfInt1)) {
      f.v(paramArrayOfInt2);
    } else {
      f.s(a, paramArrayOfInt1, paramArrayOfInt2);
    }
  }
  
  public static void h(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l1 = paramArrayOfInt1[10] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt1[11] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt1[12] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt1[13] & 0xFFFFFFFF;
    long l5 = (paramArrayOfInt1[7] & 0xFFFFFFFF) + l2 - 1L;
    long l6 = (paramArrayOfInt1[8] & 0xFFFFFFFF) + l3;
    long l7 = (paramArrayOfInt1[9] & 0xFFFFFFFF) + l4;
    long l8 = (paramArrayOfInt1[0] & 0xFFFFFFFF) - l5 + 0L;
    long l9 = (l8 >> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) - l6);
    paramArrayOfInt2[1] = ((int)l9);
    l9 = (l9 >> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) - l7);
    paramArrayOfInt2[2] = ((int)l9);
    l5 = (l9 >> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + l5 - l1);
    l2 = (l5 >> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + l6 - l2);
    paramArrayOfInt2[4] = ((int)l2);
    l7 = (l2 >> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) + l7 - l3);
    paramArrayOfInt2[5] = ((int)l7);
    l4 = (l7 >> 32) + ((paramArrayOfInt1[6] & 0xFFFFFFFF) + l1 - l4);
    paramArrayOfInt2[6] = ((int)l4);
    l1 = (l4 >> 32) + 1L;
    l4 = (l5 & 0xFFFFFFFF) + l1;
    l8 = (l8 & 0xFFFFFFFF) - l1;
    paramArrayOfInt2[0] = ((int)l8);
    l1 = l8 >> 32;
    l8 = l4;
    if (l1 != 0L)
    {
      l8 = l1 + (paramArrayOfInt2[1] & 0xFFFFFFFF);
      paramArrayOfInt2[1] = ((int)l8);
      l8 = (l8 >> 32) + (0xFFFFFFFF & paramArrayOfInt2[2]);
      paramArrayOfInt2[2] = ((int)l8);
      l8 = l4 + (l8 >> 32);
    }
    paramArrayOfInt2[3] = ((int)l8);
    if (((l8 >> 32 != 0L) && (m.t(7, paramArrayOfInt2, 4) != 0)) || ((paramArrayOfInt2[6] == -1) && (f.j(paramArrayOfInt2, a)))) {
      c(paramArrayOfInt2);
    }
  }
  
  public static void i(int paramInt, int[] paramArrayOfInt)
  {
    long l2;
    if (paramInt != 0)
    {
      long l1 = paramInt & 0xFFFFFFFF;
      l2 = (paramArrayOfInt[0] & 0xFFFFFFFF) - l1 + 0L;
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
      l2 += (0xFFFFFFFF & paramArrayOfInt[3]) + l1;
      paramArrayOfInt[3] = ((int)l2);
      l2 >>= 32;
    }
    else
    {
      l2 = 0L;
    }
    if (((l2 != 0L) && (m.t(7, paramArrayOfInt, 4) != 0)) || ((paramArrayOfInt[6] == -1) && (f.j(paramArrayOfInt, a)))) {
      c(paramArrayOfInt);
    }
  }
  
  public static void j(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = f.f();
    f.r(paramArrayOfInt1, arrayOfInt);
    h(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void k(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = f.f();
    f.r(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      h(arrayOfInt, paramArrayOfInt2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      f.r(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  private static void l(int[] paramArrayOfInt)
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
    l1 += (0xFFFFFFFF & paramArrayOfInt[3]) - 1L;
    paramArrayOfInt[3] = ((int)l1);
    if (l1 >> 32 != 0L) {
      m.m(7, paramArrayOfInt, 4);
    }
  }
  
  public static void m(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (f.s(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      l(paramArrayOfInt3);
    }
  }
  
  public static void n(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.E(7, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[6] == -1) && (f.j(paramArrayOfInt2, a)))) {
      c(paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */