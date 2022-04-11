package e.a.b.a.a0.c;

import e.a.b.c.i;
import e.a.b.c.m;
import java.math.BigInteger;

public class n0
{
  static final int[] a = { -1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1 };
  static final int[] b = { 1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1 };
  private static final int[] c = { -1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2 };
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((m.a(12, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[11] == -1) && (m.q(12, paramArrayOfInt3, a)))) {
      d(paramArrayOfInt3);
    }
  }
  
  public static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((m.a(24, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[23] == -1) && (m.q(24, paramArrayOfInt3, b))))
    {
      paramArrayOfInt1 = c;
      if (m.e(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        m.t(24, paramArrayOfInt3, paramArrayOfInt1.length);
      }
    }
  }
  
  public static void c(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.s(12, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[11] == -1) && (m.q(12, paramArrayOfInt2, a)))) {
      d(paramArrayOfInt2);
    }
  }
  
  private static void d(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) + 1L;
    paramArrayOfInt[0] = ((int)l1);
    l1 = (l1 >> 32) + ((paramArrayOfInt[1] & 0xFFFFFFFF) - 1L);
    paramArrayOfInt[1] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[2] & 0xFFFFFFFF);
      paramArrayOfInt[2] = ((int)l1);
      l1 >>= 32;
    }
    l1 += (paramArrayOfInt[3] & 0xFFFFFFFF) + 1L;
    paramArrayOfInt[3] = ((int)l1);
    l1 = (l1 >> 32) + ((0xFFFFFFFF & paramArrayOfInt[4]) + 1L);
    paramArrayOfInt[4] = ((int)l1);
    if (l1 >> 32 != 0L) {
      m.t(12, paramArrayOfInt, 5);
    }
  }
  
  public static int[] e(BigInteger paramBigInteger)
  {
    paramBigInteger = m.o(384, paramBigInteger);
    if (paramBigInteger[11] == -1)
    {
      int[] arrayOfInt = a;
      if (m.q(12, paramBigInteger, arrayOfInt)) {
        m.N(12, arrayOfInt, paramBigInteger);
      }
    }
    return paramBigInteger;
  }
  
  public static void f(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = m.j(24);
    i.a(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    h(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void g(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (m.w(12, paramArrayOfInt1)) {
      m.Q(12, paramArrayOfInt2);
    } else {
      m.K(12, a, paramArrayOfInt1, paramArrayOfInt2);
    }
  }
  
  public static void h(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l1 = paramArrayOfInt1[16] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt1[17] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt1[18] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt1[19] & 0xFFFFFFFF;
    long l5 = paramArrayOfInt1[20] & 0xFFFFFFFF;
    long l6 = paramArrayOfInt1[21] & 0xFFFFFFFF;
    long l7 = paramArrayOfInt1[22] & 0xFFFFFFFF;
    long l8 = paramArrayOfInt1[23] & 0xFFFFFFFF;
    long l9 = (paramArrayOfInt1[12] & 0xFFFFFFFF) + l5 - 1L;
    long l10 = (paramArrayOfInt1[13] & 0xFFFFFFFF) + l7;
    long l11 = (paramArrayOfInt1[14] & 0xFFFFFFFF) + l7 + l8;
    long l12 = (paramArrayOfInt1[15] & 0xFFFFFFFF) + l8;
    long l13 = l2 + l6;
    long l14 = l6 - l8;
    l7 -= l8;
    long l15 = l9 + l14;
    long l16 = (paramArrayOfInt1[0] & 0xFFFFFFFF) + l15 + 0L;
    paramArrayOfInt2[0] = ((int)l16);
    l8 = (l16 >> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + l8 - l9 + l10);
    paramArrayOfInt2[1] = ((int)l8);
    l8 = (l8 >> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) - l6 - l10 + l11);
    paramArrayOfInt2[2] = ((int)l8);
    l8 = (l8 >> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) - l11 + l12 + l15);
    paramArrayOfInt2[3] = ((int)l8);
    l6 = (l8 >> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + l1 + l6 + l10 - l12 + l15);
    paramArrayOfInt2[4] = ((int)l6);
    l10 = (l6 >> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) - l1 + l10 + l11 + l13);
    paramArrayOfInt2[5] = ((int)l10);
    l11 = (l10 >> 32) + ((paramArrayOfInt1[6] & 0xFFFFFFFF) + l3 - l2 + l11 + l12);
    paramArrayOfInt2[6] = ((int)l11);
    l12 = (l11 >> 32) + ((paramArrayOfInt1[7] & 0xFFFFFFFF) + l1 + l4 - l3 + l12);
    paramArrayOfInt2[7] = ((int)l12);
    l1 = (l12 >> 32) + ((paramArrayOfInt1[8] & 0xFFFFFFFF) + l1 + l2 + l5 - l4);
    paramArrayOfInt2[8] = ((int)l1);
    l13 = (l1 >> 32) + ((paramArrayOfInt1[9] & 0xFFFFFFFF) + l3 - l5 + l13);
    paramArrayOfInt2[9] = ((int)l13);
    l3 = (l13 >> 32) + ((paramArrayOfInt1[10] & 0xFFFFFFFF) + l3 + l4 - l14 + l7);
    paramArrayOfInt2[10] = ((int)l3);
    l5 = (l3 >> 32) + ((paramArrayOfInt1[11] & 0xFFFFFFFF) + l4 + l5 - l7);
    paramArrayOfInt2[11] = ((int)l5);
    i((int)((l5 >> 32) + 1L), paramArrayOfInt2);
  }
  
  public static void i(int paramInt, int[] paramArrayOfInt)
  {
    long l2;
    if (paramInt != 0)
    {
      long l1 = paramInt & 0xFFFFFFFF;
      l2 = (paramArrayOfInt[0] & 0xFFFFFFFF) + l1 + 0L;
      paramArrayOfInt[0] = ((int)l2);
      l2 = (l2 >> 32) + ((paramArrayOfInt[1] & 0xFFFFFFFF) - l1);
      paramArrayOfInt[1] = ((int)l2);
      long l3 = l2 >> 32;
      l2 = l3;
      if (l3 != 0L)
      {
        l2 = l3 + (paramArrayOfInt[2] & 0xFFFFFFFF);
        paramArrayOfInt[2] = ((int)l2);
        l2 >>= 32;
      }
      l2 += (paramArrayOfInt[3] & 0xFFFFFFFF) + l1;
      paramArrayOfInt[3] = ((int)l2);
      l2 = (l2 >> 32) + ((0xFFFFFFFF & paramArrayOfInt[4]) + l1);
      paramArrayOfInt[4] = ((int)l2);
      l2 >>= 32;
    }
    else
    {
      l2 = 0L;
    }
    if (((l2 != 0L) && (m.t(12, paramArrayOfInt, 5) != 0)) || ((paramArrayOfInt[11] == -1) && (m.q(12, paramArrayOfInt, a)))) {
      d(paramArrayOfInt);
    }
  }
  
  public static void j(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = m.j(24);
    i.b(paramArrayOfInt1, arrayOfInt);
    h(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void k(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = m.j(24);
    i.b(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      h(arrayOfInt, paramArrayOfInt2);
      paramInt--;
      if (paramInt <= 0) {
        break;
      }
      i.b(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  private static void l(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) - 1L;
    paramArrayOfInt[0] = ((int)l1);
    l1 = (l1 >> 32) + ((paramArrayOfInt[1] & 0xFFFFFFFF) + 1L);
    paramArrayOfInt[1] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[2] & 0xFFFFFFFF);
      paramArrayOfInt[2] = ((int)l1);
      l1 >>= 32;
    }
    l1 += (paramArrayOfInt[3] & 0xFFFFFFFF) - 1L;
    paramArrayOfInt[3] = ((int)l1);
    l1 = (l1 >> 32) + ((0xFFFFFFFF & paramArrayOfInt[4]) - 1L);
    paramArrayOfInt[4] = ((int)l1);
    if (l1 >> 32 != 0L) {
      m.m(12, paramArrayOfInt, 5);
    }
  }
  
  public static void m(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (m.K(12, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      l(paramArrayOfInt3);
    }
  }
  
  public static void n(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((m.E(12, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[11] == -1) && (m.q(12, paramArrayOfInt2, a)))) {
      d(paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\n0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */