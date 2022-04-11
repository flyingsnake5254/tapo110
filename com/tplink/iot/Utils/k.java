package com.tplink.iot.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class k
{
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */