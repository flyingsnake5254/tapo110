package e.a.c.d.a;

import java.io.PrintStream;

public final class j
{
  public static int a(int paramInt)
  {
    int i = -1;
    while (paramInt != 0)
    {
      i++;
      paramInt >>>= 1;
    }
    return i;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    int i;
    for (;;)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt1 == 0) {
        break;
      }
      paramInt2 = e(i, paramInt1);
    }
    return i;
  }
  
  public static boolean c(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    int i = a(paramInt);
    int j = 2;
    for (int k = 0; k < i >>> 1; k++)
    {
      j = d(j, j, paramInt);
      if (b(j ^ 0x2, paramInt) != 1) {
        return false;
      }
    }
    return true;
  }
  
  public static int d(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = e(paramInt1, paramInt3);
    paramInt1 = e(paramInt2, paramInt3);
    int j = 0;
    paramInt2 = 0;
    if (paramInt1 != 0)
    {
      int k = a(paramInt3);
      for (;;)
      {
        j = paramInt2;
        if (i == 0) {
          break;
        }
        j = paramInt2;
        if ((byte)(i & 0x1) == 1) {
          j = paramInt2 ^ paramInt1;
        }
        int m = i >>> 1;
        int n = paramInt1 << 1;
        paramInt2 = j;
        i = m;
        paramInt1 = n;
        if (n >= 1 << k)
        {
          paramInt1 = n ^ paramInt3;
          paramInt2 = j;
          i = m;
        }
      }
    }
    return j;
  }
  
  public static int e(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      System.err.println("Error: to be divided by 0");
      return 0;
    }
    while (a(paramInt1) >= a(paramInt2)) {
      paramInt1 ^= paramInt2 << a(paramInt1) - a(paramInt2);
    }
    return paramInt1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\d\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */