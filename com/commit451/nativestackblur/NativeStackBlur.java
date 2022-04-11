package com.commit451.nativestackblur;

import android.graphics.Bitmap;
import com.enrique.stackblur.NativeBlurProcess;

public class NativeStackBlur
{
  public static Bitmap process(Bitmap paramBitmap, int paramInt)
  {
    return new NativeBlurProcess().blur(paramBitmap, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\commit451\nativestackblur\NativeStackBlur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */