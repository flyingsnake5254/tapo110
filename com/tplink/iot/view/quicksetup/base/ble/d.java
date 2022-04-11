package com.tplink.iot.view.quicksetup.base.ble;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import androidx.core.content.ContextCompat;

public class d
{
  private static BluetoothAdapter a(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null) {
      return null;
    }
    BluetoothManager localBluetoothManager = (BluetoothManager)paramContext.getSystemService("bluetooth");
    paramContext = (Context)localObject;
    if (localBluetoothManager != null) {
      paramContext = localBluetoothManager.getAdapter();
    }
    return paramContext;
  }
  
  public static boolean b(Activity paramActivity)
  {
    boolean bool;
    if ((d(paramActivity)) && (c(paramActivity)) && (f(paramActivity))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean c(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return e(paramActivity);
    }
    return true;
  }
  
  public static boolean d(Activity paramActivity)
  {
    paramActivity = a(paramActivity);
    boolean bool;
    if ((paramActivity != null) && (paramActivity.isEnabled())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean e(Activity paramActivity)
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
  
  public static boolean f(Activity paramActivity)
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
  
  public static boolean g(Activity paramActivity)
  {
    paramActivity = a(paramActivity);
    if (paramActivity != null) {
      return paramActivity.enable();
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\ble\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */