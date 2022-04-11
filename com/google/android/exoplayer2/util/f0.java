package com.google.android.exoplayer2.util;

public final class f0
{
  public static int a(int paramInt1, int paramInt2)
  {
    for (int i = 1; i <= 2; i++)
    {
      int j = (paramInt1 + i) % 3;
      if (b(j, paramInt2)) {
        return j;
      }
    }
    return paramInt1;
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = bool1;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return false;
        }
        if ((paramInt2 & 0x2) != 0) {
          bool3 = bool2;
        } else {
          bool3 = false;
        }
        return bool3;
      }
      if ((paramInt2 & 0x1) != 0) {
        bool3 = bool1;
      } else {
        bool3 = false;
      }
    }
    return bool3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */