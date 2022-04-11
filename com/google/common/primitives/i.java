package com.google.common.primitives;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final class i
{
  public static int a(int paramInt1, int paramInt2)
  {
    return d.d(c(paramInt1), c(paramInt2));
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return (int)(f(paramInt1) / f(paramInt2));
  }
  
  static int c(int paramInt)
  {
    return paramInt ^ 0x80000000;
  }
  
  @CanIgnoreReturnValue
  public static int d(String paramString, int paramInt)
  {
    n.o(paramString);
    long l = Long.parseLong(paramString, paramInt);
    if ((0xFFFFFFFF & l) == l) {
      return (int)l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Input ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" in base ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is not in the range of an unsigned integer");
    throw new NumberFormatException(localStringBuilder.toString());
  }
  
  public static int e(int paramInt1, int paramInt2)
  {
    return (int)(f(paramInt1) % f(paramInt2));
  }
  
  public static long f(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  public static String g(int paramInt1, int paramInt2)
  {
    return Long.toString(paramInt1 & 0xFFFFFFFF, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */