package com.tplink.iot.view.ipcamera.base;

import android.content.Context;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class e
{
  public static boolean a(Context paramContext)
  {
    WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
    paramContext = localWifiManager.getConnectionInfo();
    boolean bool;
    if ((localWifiManager.getWifiState() == 3) && (paramContext != null) && (paramContext.getSupplicantState() == SupplicantState.COMPLETED)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\base\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */