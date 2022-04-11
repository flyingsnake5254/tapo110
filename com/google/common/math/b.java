package com.google.common.math;

import com.google.common.base.n;

final class b
{
  static double a(double paramDouble)
  {
    n.d(Double.isNaN(paramDouble) ^ true);
    if (paramDouble > 0.0D) {
      return paramDouble;
    }
    return 0.0D;
  }
  
  static long b(double paramDouble)
  {
    n.e(c(paramDouble), "not a normal value");
    int i = Math.getExponent(paramDouble);
    long l = Double.doubleToRawLongBits(paramDouble) & 0xFFFFFFFFFFFFF;
    if (i == 64513) {
      l <<= 1;
    } else {
      l |= 0x10000000000000;
    }
    return l;
  }
  
  static boolean c(double paramDouble)
  {
    boolean bool;
    if (Math.getExponent(paramDouble) <= 1023) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\math\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */