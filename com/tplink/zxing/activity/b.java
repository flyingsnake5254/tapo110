package com.tplink.zxing.activity;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import b.d.e0.a;

public class b
{
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    a.c = localDisplayMetrics.density;
    a.d = localDisplayMetrics.densityDpi;
    int i = localDisplayMetrics.widthPixels;
    a.a = i;
    a.b = localDisplayMetrics.heightPixels;
    a.e = a.a(paramContext, i);
    a.f = a.a(paramContext, localDisplayMetrics.heightPixels);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\zxing\activity\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */