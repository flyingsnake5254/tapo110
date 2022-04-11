package com.tplink.iot.Utils.y0;

import android.content.Context;
import android.os.Looper;
import com.bumptech.glide.c;

public class d
{
  public static void a(Context paramContext)
  {
    try
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        c.c(paramContext).b();
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\y0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */