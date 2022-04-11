package e.a.b.c;

import java.math.BigInteger;
import org.bouncycastle.util.f;

public abstract class m
{
  public static int A(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      
      if (paramInt1 < 0) {
        break;
      }
      int i = paramArrayOfInt[paramInt1];
      paramArrayOfInt[paramInt1] = (paramInt3 << -paramInt2 | i >>> paramInt2);
      paramInt3 = i;
    }
    return paramInt3 << -paramInt2;
  }
  
  public static int B(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt2, int paramInt5)
  {
    for (;;)
    {
      
      if (paramInt1 < 0) {
        break;
      }
      int i = paramArrayOfInt1[(paramInt2 + paramInt1)];
      paramArrayOfInt2[(paramInt5 + paramInt1)] = (paramInt4 << -paramInt3 | i >>> paramInt3);
      paramInt4 = i;
    }
    return paramInt4 << -paramInt3;
  }
  
  public static int C(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    for (;;)
    {
      
      if (paramInt1 < 0) {
        break;
      }
      int i = paramArrayOfInt[paramInt1];
      paramArrayOfInt[paramInt1] = paramInt2;
      paramInt2 = i;
    }
    return paramInt2;
  }
  
  public static int D(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2, int paramInt4)
  {
    int i = 0;
    while (i < paramInt1)
    {
      int j = paramArrayOfInt1[(paramInt2 + i)];
      paramArrayOfInt2[(paramInt4 + i)] = (paramInt3 >>> 31 | j << 1);
      i++;
      paramInt3 = j;
    }
    return paramInt3 >>> 31;
  }
  
  public static int E(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2)
  {
    int i = 0;
    int j = paramInt2;
    paramInt2 = i;
    while (paramInt2 < paramInt1)
    {
      i = paramArrayOfInt1[paramInt2];
      paramArrayOfInt2[paramInt2] = (j >>> 31 | i << 1);
      paramInt2++;
      j = i;
    }
    return j >>> 31;
  }
  
  public static long F(int paramInt1, long[] paramArrayOfLong1, int paramInt2, long paramLong, long[] paramArrayOfLong2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt1)
    {
      long l = paramArrayOfLong1[(paramInt2 + i)];
      paramArrayOfLong2[(paramInt3 + i)] = (paramLong >>> 63 | l << 1);
      i++;
      paramLong = l;
    }
    return paramLong >>> 63;
  }
  
  public static int G(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt1)
    {
      int j = paramArrayOfInt[i];
      paramArrayOfInt[i] = (paramInt3 >>> -paramInt2 | j << paramInt2);
      i++;
      paramInt3 = j;
    }
    return paramInt3 >>> -paramInt2;
  }
  
  public static int H(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2)
  {
    int i = 0;
    int j = paramInt3;
    paramInt3 = i;
    while (paramInt3 < paramInt1)
    {
      i = paramArrayOfInt1[paramInt3];
      paramArrayOfInt2[paramInt3] = (j >>> -paramInt2 | i << paramInt2);
      paramInt3++;
      j = i;
    }
    return j >>> -paramInt2;
  }
  
  public static long I(int paramInt1, long[] paramArrayOfLong, int paramInt2, int paramInt3, long paramLong)
  {
    int i = 0;
    while (i < paramInt1)
    {
      int j = paramInt2 + i;
      long l = paramArrayOfLong[j];
      paramArrayOfLong[j] = (paramLong >>> -paramInt3 | l << paramInt3);
      i++;
      paramLong = l;
    }
    return paramLong >>> -paramInt3;
  }
  
  public static long J(int paramInt1, long[] paramArrayOfLong1, int paramInt2, int paramInt3, long paramLong, long[] paramArrayOfLong2, int paramInt4)
  {
    int i = 0;
    while (i < paramInt1)
    {
      long l = paramArrayOfLong1[(paramInt2 + i)];
      paramArrayOfLong2[(paramInt4 + i)] = (paramLong >>> -paramInt3 | l << paramInt3);
      i++;
      paramLong = l;
    }
    return paramLong >>> -paramInt3;
  }
  
  public static int K(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = 0L;
    for (int i = 0; i < paramInt; i++)
    {
      l += (paramArrayOfInt1[i] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt2[i]);
      paramArrayOfInt3[i] = ((int)l);
      l >>= 32;
    }
    return (int)l;
  }
  
  public static int L(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = 0;
    long l = (paramArrayOfInt[0] & 0xFFFFFFFF) - (paramInt2 & 0xFFFFFFFF);
    paramArrayOfInt[0] = ((int)l);
    l = (l >> 32) + ((0xFFFFFFFF & paramArrayOfInt[1]) - 1L);
    paramArrayOfInt[1] = ((int)l);
    if (l >> 32 == 0L) {
      paramInt1 = i;
    } else {
      paramInt1 = m(paramInt1, paramArrayOfInt, 2);
    }
    return paramInt1;
  }
  
  public static int M(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3)
  {
    long l = 0L;
    for (int i = 0; i < paramInt1; i++)
    {
      int j = paramInt3 + i;
      l += (paramArrayOfInt2[j] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt1[(paramInt2 + i)]);
      paramArrayOfInt2[j] = ((int)l);
      l >>= 32;
    }
    return (int)l;
  }
  
  public static int N(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l = 0L;
    for (int i = 0; i < paramInt; i++)
    {
      l += (paramArrayOfInt2[i] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt1[i]);
      paramArrayOfInt2[i] = ((int)l);
      l >>= 32;
    }
    return (int)l;
  }
  
  public static int O(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = 0;
    long l = (paramArrayOfInt[0] & 0xFFFFFFFF) - (0xFFFFFFFF & paramInt2);
    paramArrayOfInt[0] = ((int)l);
    if (l >> 32 == 0L) {
      paramInt1 = i;
    } else {
      paramInt1 = m(paramInt1, paramArrayOfInt, 1);
    }
    return paramInt1;
  }
  
  public static BigInteger P(int paramInt, int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[paramInt << 2];
    for (int i = 0; i < paramInt; i++)
    {
      int j = paramArrayOfInt[i];
      if (j != 0) {
        f.d(j, arrayOfByte, paramInt - 1 - i << 2);
      }
    }
    return new BigInteger(1, arrayOfByte);
  }
  
  public static void Q(int paramInt, int[] paramArrayOfInt)
  {
    for (int i = 0; i < paramInt; i++) {
      paramArrayOfInt[i] = 0;
    }
  }
  
  public static void R(int paramInt, long[] paramArrayOfLong)
  {
    for (int i = 0; i < paramInt; i++) {
      paramArrayOfLong[i] = 0L;
    }
  }
  
  public static int a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = 0L;
    for (int i = 0; i < paramInt; i++)
    {
      l += (paramArrayOfInt1[i] & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[i]);
      paramArrayOfInt3[i] = ((int)l);
      l >>>= 32;
    }
    return (int)l;
  }
  
  public static int b(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = 0;
    long l = (paramArrayOfInt[0] & 0xFFFFFFFF) + (paramInt2 & 0xFFFFFFFF);
    paramArrayOfInt[0] = ((int)l);
    l = (l >>> 32) + ((0xFFFFFFFF & paramArrayOfInt[1]) + 1L);
    paramArrayOfInt[1] = ((int)l);
    if (l >>> 32 == 0L) {
      paramInt1 = i;
    } else {
      paramInt1 = t(paramInt1, paramArrayOfInt, 2);
    }
    return paramInt1;
  }
  
  public static int c(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = 0L;
    for (int i = 0; i < paramInt; i++)
    {
      l += (paramArrayOfInt1[i] & 0xFFFFFFFF) + (paramArrayOfInt2[i] & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt3[i]);
      paramArrayOfInt3[i] = ((int)l);
      l >>>= 32;
    }
    return (int)l;
  }
  
  public static int d(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3)
  {
    long l1 = 0L;
    for (int i = 0; i < paramInt1; i++)
    {
      long l2 = paramArrayOfInt1[(paramInt2 + i)];
      int j = paramInt3 + i;
      l1 += (l2 & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[j]);
      paramArrayOfInt2[j] = ((int)l1);
      l1 >>>= 32;
    }
    return (int)l1;
  }
  
  public static int e(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l = 0L;
    for (int i = 0; i < paramInt; i++)
    {
      l += (paramArrayOfInt1[i] & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[i]);
      paramArrayOfInt2[i] = ((int)l);
      l >>>= 32;
    }
    return (int)l;
  }
  
  public static int f(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    long l = (paramInt2 & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt[paramInt3]);
    paramArrayOfInt[paramInt3] = ((int)l);
    if (l >>> 32 == 0L) {
      paramInt1 = 0;
    } else {
      paramInt1 = t(paramInt1, paramArrayOfInt, paramInt3 + 1);
    }
    return paramInt1;
  }
  
  public static int g(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    long l = paramInt2;
    paramInt2 = 0;
    l = (l & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt[0]);
    paramArrayOfInt[0] = ((int)l);
    if (l >>> 32 == 0L) {
      paramInt1 = paramInt2;
    } else {
      paramInt1 = t(paramInt1, paramArrayOfInt, 1);
    }
    return paramInt1;
  }
  
  public static void h(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3)
  {
    System.arraycopy(paramArrayOfInt1, paramInt2, paramArrayOfInt2, paramInt3, paramInt1);
  }
  
  public static int[] i(int paramInt, int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[paramInt];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt);
    return arrayOfInt;
  }
  
  public static int[] j(int paramInt)
  {
    return new int[paramInt];
  }
  
  public static long[] k(int paramInt)
  {
    return new long[paramInt];
  }
  
  public static int l(int paramInt, int[] paramArrayOfInt)
  {
    for (int i = 0; i < paramInt; i++)
    {
      int j = paramArrayOfInt[i] - 1;
      paramArrayOfInt[i] = j;
      if (j != -1) {
        return 0;
      }
    }
    return -1;
  }
  
  public static int m(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    while (paramInt2 < paramInt1)
    {
      int i = paramArrayOfInt[paramInt2] - 1;
      paramArrayOfInt[paramInt2] = i;
      if (i != -1) {
        return 0;
      }
      paramInt2++;
    }
    return -1;
  }
  
  public static boolean n(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    
    while (paramInt >= 0)
    {
      if (paramArrayOfInt1[paramInt] != paramArrayOfInt2[paramInt]) {
        return false;
      }
      paramInt--;
    }
    return true;
  }
  
  public static int[] o(int paramInt, BigInteger paramBigInteger)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= paramInt))
    {
      int[] arrayOfInt = j(paramInt + 31 >> 5);
      for (paramInt = 0; paramBigInteger.signum() != 0; paramInt++)
      {
        arrayOfInt[paramInt] = paramBigInteger.intValue();
        paramBigInteger = paramBigInteger.shiftRight(32);
      }
      return arrayOfInt;
    }
    throw new IllegalArgumentException();
  }
  
  public static int p(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0) {}
    int i;
    for (paramInt = paramArrayOfInt[0];; paramInt = paramArrayOfInt[i] >>> (paramInt & 0x1F))
    {
      return paramInt & 0x1;
      i = paramInt >> 5;
      if ((i < 0) || (i >= paramArrayOfInt.length)) {
        break;
      }
    }
    return 0;
  }
  
  public static boolean q(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    
    while (paramInt >= 0)
    {
      int i = paramArrayOfInt1[paramInt] ^ 0x80000000;
      int j = 0x80000000 ^ paramArrayOfInt2[paramInt];
      if (i < j) {
        return false;
      }
      if (i > j) {
        return true;
      }
      paramInt--;
    }
    return true;
  }
  
  public static int r(int paramInt, int[] paramArrayOfInt)
  {
    for (int i = 0; i < paramInt; i++)
    {
      int j = paramArrayOfInt[i] + 1;
      paramArrayOfInt[i] = j;
      if (j != 0) {
        return 0;
      }
    }
    return 1;
  }
  
  public static int s(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = paramArrayOfInt1[i] + 1;
      paramArrayOfInt2[i] = j;
      int k = i + 1;
      i = k;
      if (j != 0)
      {
        while (k < paramInt)
        {
          paramArrayOfInt2[k] = paramArrayOfInt1[k];
          k++;
        }
        return 0;
      }
    }
    return 1;
  }
  
  public static int t(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    while (paramInt2 < paramInt1)
    {
      int i = paramArrayOfInt[paramInt2] + 1;
      paramArrayOfInt[paramInt2] = i;
      if (i != 0) {
        return 0;
      }
      paramInt2++;
    }
    return 1;
  }
  
  public static int u(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    while (paramInt3 < paramInt1)
    {
      int i = paramInt2 + paramInt3;
      int j = paramArrayOfInt[i] + 1;
      paramArrayOfInt[i] = j;
      if (j != 0) {
        return 0;
      }
      paramInt3++;
    }
    return 1;
  }
  
  public static boolean v(int paramInt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] != 1) {
      return false;
    }
    for (int i = 1; i < paramInt; i++) {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean w(int paramInt, int[] paramArrayOfInt)
  {
    for (int i = 0; i < paramInt; i++) {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
    }
    return true;
  }
  
  public static int x(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int paramInt4)
  {
    long l1 = paramInt2;
    long l2 = paramInt3;
    long l3 = 0L;
    paramInt2 = 0;
    long l4;
    do
    {
      l4 = paramArrayOfInt1[paramInt2];
      long l5 = paramArrayOfInt2[paramInt2];
      paramInt3 = paramInt4 + paramInt2;
      l3 += (l4 & 0xFFFFFFFF) * (l1 & 0xFFFFFFFF) + (l5 & 0xFFFFFFFF) * (l2 & 0xFFFFFFFF) + (paramArrayOfInt3[paramInt3] & 0xFFFFFFFF);
      paramArrayOfInt3[paramInt3] = ((int)l3);
      l4 = l3 >>> 32;
      paramInt3 = paramInt2 + 1;
      l3 = l4;
      paramInt2 = paramInt3;
    } while (paramInt3 < paramInt1);
    return (int)l4;
  }
  
  public static int y(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int paramInt4)
  {
    long l1 = paramInt2;
    long l2 = 0L;
    paramInt2 = 0;
    long l3;
    int i;
    do
    {
      l3 = paramArrayOfInt1[(paramInt3 + paramInt2)];
      i = paramInt4 + paramInt2;
      l2 += (l3 & 0xFFFFFFFF) * (l1 & 0xFFFFFFFF) + (paramArrayOfInt2[i] & 0xFFFFFFFF);
      paramArrayOfInt2[i] = ((int)l2);
      l3 = l2 >>> 32;
      i = paramInt2 + 1;
      l2 = l3;
      paramInt2 = i;
    } while (i < paramInt1);
    return (int)l3;
  }
  
  public static int z(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    for (;;)
    {
      
      if (paramInt1 < 0) {
        break;
      }
      int i = paramArrayOfInt[paramInt1];
      paramArrayOfInt[paramInt1] = (paramInt2 << 31 | i >>> 1);
      paramInt2 = i;
    }
    return paramInt2 << 31;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */