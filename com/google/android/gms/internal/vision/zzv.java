package com.google.android.gms.internal.vision;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public final class zzv
{
  public static Bitmap zzb(Bitmap paramBitmap, zzu paramzzu)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Object localObject = paramBitmap;
    if (paramzzu.rotation != 0)
    {
      localObject = new Matrix();
      k = paramzzu.rotation;
      if (k != 0)
      {
        if (k != 1)
        {
          if (k != 2)
          {
            if (k == 3) {
              k = 270;
            } else {
              throw new IllegalArgumentException("Unsupported rotation degree.");
            }
          }
          else {
            k = 180;
          }
        }
        else {
          k = 90;
        }
      }
      else {
        k = 0;
      }
      ((Matrix)localObject).postRotate(k);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
    }
    int k = paramzzu.rotation;
    if ((k == 1) || (k == 3))
    {
      paramzzu.width = j;
      paramzzu.height = i;
    }
    return (Bitmap)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */