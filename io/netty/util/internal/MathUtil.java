package io.netty.util.internal;

public final class MathUtil
{
  public static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      paramInt1 = -1;
    } else if (paramInt1 > paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    return paramInt1;
  }
  
  public static int compare(long paramLong1, long paramLong2)
  {
    boolean bool = paramLong1 < paramLong2;
    int i;
    if (bool) {
      i = -1;
    } else if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  public static int findNextPositivePowerOfTwo(int paramInt)
  {
    return 1 << 32 - Integer.numberOfLeadingZeros(paramInt - 1);
  }
  
  public static boolean isOutOfBounds(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1 + paramInt2;
    boolean bool;
    if ((paramInt1 | paramInt2 | i | paramInt3 - i) < 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static int safeFindNextPositivePowerOfTwo(int paramInt)
  {
    int i = 1073741824;
    if (paramInt <= 0) {
      paramInt = 1;
    } else if (paramInt >= 1073741824) {
      paramInt = i;
    } else {
      paramInt = findNextPositivePowerOfTwo(paramInt);
    }
    return paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\MathUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */