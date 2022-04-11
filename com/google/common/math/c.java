package com.google.common.math;

import com.google.common.primitives.d;

public final class c
{
  static final byte[] a = { 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0 };
  static final int[] b = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
  static final int[] c = { 3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE };
  private static final int[] d = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600 };
  static int[] e = { Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33 };
  
  public static int a(int paramInt1, int paramInt2)
  {
    long l = paramInt1 + paramInt2;
    int i = (int)l;
    boolean bool;
    if (l == i) {
      bool = true;
    } else {
      bool = false;
    }
    f.b(bool, "checkedAdd", paramInt1, paramInt2);
    return i;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return d.i(paramInt1 + paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\math\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */