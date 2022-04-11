package com.tplink.libtpnetwork.cameranetwork.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

public final class e
{
  public static int a(int paramInt, Context paramContext)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int[] b(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getMetrics(localDisplayMetrics);
    return new int[] { localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels };
  }
  
  public static int[] c(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    return new int[] { paramContext.widthPixels, paramContext.heightPixels };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */