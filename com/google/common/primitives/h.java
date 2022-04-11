package com.google.common.primitives;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final class h
{
  @CanIgnoreReturnValue
  public static byte a(long paramLong)
  {
    boolean bool;
    if (paramLong >> 8 == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    n.h(bool, "out of range: %s", paramLong);
    return (byte)(int)paramLong;
  }
  
  public static int b(byte paramByte)
  {
    return paramByte & 0xFF;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */