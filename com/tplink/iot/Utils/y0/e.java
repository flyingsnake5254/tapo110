package com.tplink.iot.Utils.y0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import io.reactivex.q;

public class e
{
  public static q<Bitmap> a(Context paramContext, String paramString)
  {
    return q.f0(paramString).L0(io.reactivex.l0.a.c()).g0(new b(paramContext, paramString));
  }
  
  public static q<Drawable> b(Context paramContext, String paramString)
  {
    return q.f0(paramString).L0(io.reactivex.l0.a.c()).g0(new a(paramContext, paramString));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\y0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */