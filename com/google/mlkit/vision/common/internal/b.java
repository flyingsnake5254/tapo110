package com.google.mlkit.vision.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class b
{
  @KeepForSdk
  public static int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 90)
      {
        if (paramInt != 180)
        {
          if (paramInt == 270) {
            return 3;
          }
          StringBuilder localStringBuilder = new StringBuilder(29);
          localStringBuilder.append("Invalid rotation: ");
          localStringBuilder.append(paramInt);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        return 2;
      }
      return 1;
    }
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\common\internal\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */