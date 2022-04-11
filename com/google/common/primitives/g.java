package com.google.common.primitives;

import com.google.common.base.n;

public final class g
{
  public static byte a(long paramLong)
  {
    byte b = (byte)(int)paramLong;
    boolean bool;
    if (b == paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    n.h(bool, "Out of range: %s", paramLong);
    return b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */