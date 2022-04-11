package com.google.common.collect;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class y0
{
  static int a(int paramInt, double paramDouble)
  {
    paramInt = Math.max(paramInt, 2);
    int i = Integer.highestOneBit(paramInt);
    if (paramInt > (int)(paramDouble * i))
    {
      paramInt = i << 1;
      if (paramInt <= 0) {
        paramInt = 1073741824;
      }
      return paramInt;
    }
    return i;
  }
  
  static boolean b(int paramInt1, int paramInt2, double paramDouble)
  {
    boolean bool;
    if ((paramInt1 > paramDouble * paramInt2) && (paramInt2 < 1073741824)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static int c(int paramInt)
  {
    return (int)(Integer.rotateLeft((int)(paramInt * -862048943L), 15) * 461845907L);
  }
  
  static int d(@NullableDecl Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.hashCode();
    }
    return c(i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\y0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */