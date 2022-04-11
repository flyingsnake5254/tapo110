package e.a.b.c;

import java.util.Random;

public abstract class b
{
  private static int a(int paramInt)
  {
    int i = 0;
    int j = paramInt;
    for (paramInt = i; (j & 0x1) == 0; paramInt++) {
      j >>>= 1;
    }
    return paramInt;
  }
  
  private static void b(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (paramInt < 0) {
      m.a(paramArrayOfInt1.length, paramArrayOfInt2, paramArrayOfInt1, paramArrayOfInt3);
    } else {
      System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt3, 0, paramArrayOfInt1.length);
    }
  }
  
  private static int c(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int[] paramArrayOfInt3, int paramInt2)
  {
    int i = paramArrayOfInt1.length;
    for (int j = 0; paramArrayOfInt2[0] == 0; j += 32) {
      m.C(paramInt1, paramArrayOfInt2, 0);
    }
    int k = a(paramArrayOfInt2[0]);
    int m = j;
    if (k > 0)
    {
      m.A(paramInt1, paramArrayOfInt2, k, 0);
      m = j + k;
    }
    paramInt1 = 0;
    while (paramInt1 < m)
    {
      j = paramInt2;
      if ((paramArrayOfInt3[0] & 0x1) != 0)
      {
        if (paramInt2 < 0) {
          j = m.e(i, paramArrayOfInt1, paramArrayOfInt3);
        } else {
          j = m.N(i, paramArrayOfInt1, paramArrayOfInt3);
        }
        j = paramInt2 + j;
      }
      m.z(i, paramArrayOfInt3, j);
      paramInt1++;
      paramInt2 = j;
    }
    return paramInt2;
  }
  
  public static void d(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int i = paramArrayOfInt1.length;
    if (!m.w(i, paramArrayOfInt2))
    {
      boolean bool = m.v(i, paramArrayOfInt2);
      int j = 0;
      if (bool)
      {
        System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt3, 0, i);
        return;
      }
      int[] arrayOfInt1 = m.i(i, paramArrayOfInt2);
      int[] arrayOfInt2 = m.j(i);
      arrayOfInt2[0] = 1;
      int k;
      if ((0x1 & arrayOfInt1[0]) == 0) {
        k = c(paramArrayOfInt1, arrayOfInt1, i, arrayOfInt2, 0);
      } else {
        k = 0;
      }
      if (m.v(i, arrayOfInt1))
      {
        b(paramArrayOfInt1, k, arrayOfInt2, paramArrayOfInt3);
        return;
      }
      int[] arrayOfInt3 = m.i(i, paramArrayOfInt1);
      paramArrayOfInt2 = m.j(i);
      int m = i;
      int n;
      do
      {
        do
        {
          for (;;)
          {
            n = m - 1;
            if ((arrayOfInt1[n] != 0) || (arrayOfInt3[n] != 0)) {
              break;
            }
            m--;
          }
          if (!m.q(m, arrayOfInt1, arrayOfInt3)) {
            break;
          }
          m.N(m, arrayOfInt3, arrayOfInt1);
          n = c(paramArrayOfInt1, arrayOfInt1, m, arrayOfInt2, k + (m.N(i, paramArrayOfInt2, arrayOfInt2) - j));
          k = n;
        } while (!m.v(m, arrayOfInt1));
        b(paramArrayOfInt1, n, arrayOfInt2, paramArrayOfInt3);
        return;
        m.N(m, arrayOfInt1, arrayOfInt3);
        n = c(paramArrayOfInt1, arrayOfInt3, m, paramArrayOfInt2, j + (m.N(i, arrayOfInt2, paramArrayOfInt2) - k));
        j = n;
      } while (!m.v(m, arrayOfInt3));
      b(paramArrayOfInt1, n, paramArrayOfInt2, paramArrayOfInt3);
      return;
    }
    throw new IllegalArgumentException("'x' cannot be 0");
  }
  
  public static int[] e(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    Random localRandom = new Random();
    int[] arrayOfInt = m.j(i);
    int j = i - 1;
    int k = paramArrayOfInt[j];
    k |= k >>> 1;
    k |= k >>> 2;
    k |= k >>> 4;
    int m = k | k >>> 8;
    do
    {
      for (k = 0; k != i; k++) {
        arrayOfInt[k] = localRandom.nextInt();
      }
      arrayOfInt[j] &= (m | m >>> 16);
    } while (m.q(i, arrayOfInt, paramArrayOfInt));
    return arrayOfInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */