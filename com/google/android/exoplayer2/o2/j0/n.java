package com.google.android.exoplayer2.o2.j0;

import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.util.d0;
import java.io.IOException;

final class n
{
  private static final int[] a = { 1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686 };
  
  private static boolean a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >>> 8 == 3368816) {
      return true;
    }
    if ((paramInt == 1751476579) && (paramBoolean)) {
      return true;
    }
    int[] arrayOfInt = a;
    int i = arrayOfInt.length;
    for (int j = 0; j < i; j++) {
      if (arrayOfInt[j] == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b(k paramk)
    throws IOException
  {
    return c(paramk, true, false);
  }
  
  private static boolean c(k paramk, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    long l1 = paramk.a();
    long l2 = 4096L;
    boolean bool = l1 < -1L;
    long l3 = l2;
    if (bool) {
      if (l1 > 4096L) {
        l3 = l2;
      } else {
        l3 = l1;
      }
    }
    int i = (int)l3;
    d0 locald0 = new d0(64);
    int j = 0;
    int k = 0;
    while (j < i)
    {
      locald0.L(8);
      if (paramk.c(locald0.d(), 0, 8, true))
      {
        l2 = locald0.F();
        int m = locald0.n();
        int n = 16;
        if (l2 == 1L)
        {
          paramk.n(locald0.d(), 8, 8);
          locald0.O(16);
          l3 = locald0.w();
        }
        else
        {
          l3 = l2;
          if (l2 == 0L)
          {
            long l4 = paramk.a();
            l3 = l2;
            if (l4 != -1L) {
              l3 = l4 - paramk.g() + 8;
            }
          }
          n = 8;
        }
        l2 = n;
        if (l3 < l2) {
          return false;
        }
        n = j + n;
        if (m == 1836019574)
        {
          i += (int)l3;
          j = i;
          if (bool)
          {
            j = i;
            if (i > l1) {
              j = (int)l1;
            }
          }
          i = j;
          j = n;
        }
        else if ((m != 1836019558) && (m != 1836475768))
        {
          if (n + l3 - l2 < i)
          {
            j = (int)(l3 - l2);
            int i1 = n + j;
            if (m == 1718909296)
            {
              if (j < 8) {
                return false;
              }
              locald0.L(j);
              paramk.n(locald0.d(), 0, j);
              n = j / 4;
              for (j = 0; j < n; j++) {
                if (j == 1)
                {
                  locald0.Q(4);
                }
                else if (a(locald0.n(), paramBoolean2))
                {
                  k = 1;
                  break;
                }
              }
              if (k == 0) {
                return false;
              }
              n = k;
            }
            else
            {
              n = k;
              if (j != 0)
              {
                paramk.h(j);
                n = k;
              }
            }
            j = i1;
            k = n;
          }
        }
        else
        {
          paramBoolean2 = true;
          break label480;
        }
      }
    }
    paramBoolean2 = false;
    label480:
    if ((k != 0) && (paramBoolean1 == paramBoolean2)) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    return paramBoolean1;
  }
  
  public static boolean d(k paramk, boolean paramBoolean)
    throws IOException
  {
    return c(paramk, false, paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */