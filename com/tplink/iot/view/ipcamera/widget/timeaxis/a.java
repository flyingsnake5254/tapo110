package com.tplink.iot.view.ipcamera.widget.timeaxis;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class a
{
  public static int a(int paramInt, Context paramContext)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int[] b(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    return new int[] { paramContext.widthPixels, paramContext.heightPixels };
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool;
    if (paramContext.getResources().getConfiguration().orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static int d(int paramInt, Context paramContext)
  {
    return (int)TypedValue.applyDimension(2, paramInt, paramContext.getResources().getDisplayMetrics());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\timeaxis\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */