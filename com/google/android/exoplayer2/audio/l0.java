package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.o0;

public final class l0
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      int i = 0;
      if (paramInt1 != 3)
      {
        if (paramInt1 != 65534) {
          return 0;
        }
      }
      else
      {
        paramInt1 = i;
        if (paramInt2 == 32) {
          paramInt1 = 4;
        }
        return paramInt1;
      }
    }
    return o0.U(paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\l0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */