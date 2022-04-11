package com.tplink.iot.view.quicksetup.base.f;

import android.content.Context;
import android.location.LocationManager;
import androidx.core.content.ContextCompat;

public class a
{
  public static boolean a(Context paramContext)
  {
    boolean bool;
    if ((b(paramContext)) && (c(paramContext))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool1 = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = (LocationManager)paramContext.getSystemService("location");
    if (paramContext == null) {
      return false;
    }
    boolean bool2 = paramContext.isProviderEnabled("gps");
    boolean bool3 = paramContext.isProviderEnabled("network");
    if ((bool2) || (bool3)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool1 = false;
    if (paramContext == null) {
      return false;
    }
    boolean bool2 = bool1;
    if (ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_COARSE_LOCATION") == 0)
    {
      bool2 = bool1;
      if (ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        bool2 = true;
      }
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */