package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.annotation.DrawableRes;
import java.util.Locale;

public class z4
{
  private static int[] a = { 2131953273, 2131953274, 2131953275, 2131953276, 2131953277, 2131953278, 2131953279, 2131953280, 2131953281, 2131953282, 2131953283, 2131953284, 2131953286, 2131953287, 2131953288, 2131953289, 2131953290, 2131953291, 2131953292, 2131953293, 2131953294, 2131953296, 2131953297, 2131953286 };
  private static int[] b = { 2131689498, 2131690437, 2131689502, 2131689505, 2131689564, 2131689582, 2131689638, 2131689641, 2131689662, 2131689671, 2131689678, 2131689687, 2131690018, 2131690113, 2131690165, 2131690232, 2131690238, 2131690348, 2131690369, 2131690404, 2131690415, 2131690447, 2131690460, 2131690018 };
  
  @DrawableRes
  public static int a(Context paramContext, String paramString)
  {
    e(paramContext);
    int i = a.length;
    for (int j = 0; j < i; j++) {
      if (paramString.equals(paramContext.getString(a[j])))
      {
        j = b[j];
        break label50;
      }
    }
    j = 2131690018;
    label50:
    d(paramContext);
    return j;
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    e(paramContext);
    String str = paramContext.getString(a[paramInt]);
    d(paramContext);
    return str;
  }
  
  public static String c(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramString;
    }
    e(paramContext);
    int i = 0;
    int j = a.length;
    while (i < j)
    {
      if (paramContext.getString(a[i]).equals(paramString)) {
        break label51;
      }
      i++;
    }
    i = -1;
    label51:
    d(paramContext);
    if (i != -1) {
      paramString = paramContext.getString(a[i]);
    }
    return paramString;
  }
  
  public static void d(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = localResources.getConfiguration();
    paramContext.setLocale(Locale.getDefault());
    localResources.updateConfiguration(paramContext, localResources.getDisplayMetrics());
  }
  
  public static void e(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = localResources.getConfiguration();
    paramContext.setLocale(Locale.ENGLISH);
    localResources.updateConfiguration(paramContext, localResources.getDisplayMetrics());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\z4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */