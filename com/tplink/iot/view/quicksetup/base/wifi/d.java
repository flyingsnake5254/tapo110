package com.tplink.iot.view.quicksetup.base.wifi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import androidx.core.content.ContextCompat;

public class d
{
  public static boolean a(Activity paramActivity)
  {
    boolean bool;
    if ((e(paramActivity)) && (d(paramActivity)) && (c(paramActivity))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean b(Activity paramActivity)
  {
    boolean bool1 = false;
    if (paramActivity == null) {
      return false;
    }
    paramActivity = (LocationManager)paramActivity.getSystemService("location");
    if (paramActivity == null) {
      return false;
    }
    boolean bool2 = paramActivity.isProviderEnabled("gps");
    boolean bool3 = paramActivity.isProviderEnabled("network");
    if ((bool2) || (bool3)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean c(Activity paramActivity)
  {
    boolean bool1 = false;
    if (paramActivity == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool2 = bool1;
      if (ContextCompat.checkSelfPermission(paramActivity, "android.permission.ACCESS_COARSE_LOCATION") == 0)
      {
        bool2 = bool1;
        if (ContextCompat.checkSelfPermission(paramActivity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
          bool2 = true;
        }
      }
      return bool2;
    }
    return true;
  }
  
  public static boolean d(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return b(paramActivity);
    }
    return true;
  }
  
  public static boolean e(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    paramActivity = (WifiManager)paramActivity.getApplicationContext().getSystemService("wifi");
    if (paramActivity == null) {
      return false;
    }
    return paramActivity.isWifiEnabled();
  }
  
  public static void f(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    WifiManager localWifiManager = (WifiManager)paramActivity.getApplicationContext().getSystemService("wifi");
    if (localWifiManager == null) {
      return;
    }
    if (!localWifiManager.isWifiEnabled()) {
      if (Build.VERSION.SDK_INT >= 29) {
        paramActivity.startActivityForResult(new Intent("android.settings.panel.action.WIFI"), 0);
      } else {
        localWifiManager.setWifiEnabled(true);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\wifi\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */