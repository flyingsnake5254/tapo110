package com.tplink.libtpwifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class TPWifiConnectReceiver
  extends BroadcastReceiver
{
  private a a;
  
  public static IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
    localIntentFilter.addAction("com.tplink.tpm5.wifi.le.ACTION_WIFI_CONNECT_FAIL");
    return localIntentFilter;
  }
  
  public void b(a parama)
  {
    this.a = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.net.wifi.STATE_CHANGE".equals(paramContext))
    {
      paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
      if ((paramContext != null) && (paramContext.getState().equals(NetworkInfo.State.CONNECTED)))
      {
        paramIntent = b.k().m().getConnectionInfo();
        if (paramIntent != null)
        {
          paramContext = paramIntent.getSSID();
          String str = paramIntent.getBSSID();
          paramIntent = this.a;
          if (paramIntent != null) {
            paramIntent.b(paramContext, str);
          }
        }
      }
      else if ((paramContext != null) && (paramContext.getState().equals(NetworkInfo.State.DISCONNECTED)))
      {
        paramIntent = paramIntent.getStringExtra("bssid");
        if (paramIntent != null)
        {
          paramContext = this.a;
          if (paramContext != null) {
            paramContext.c(paramIntent);
          }
        }
      }
    }
    else if ("com.tplink.tpm5.wifi.le.ACTION_WIFI_CONNECT_FAIL".equals(paramContext))
    {
      paramIntent = paramIntent.getStringExtra("tp_wifi_extra_ssid");
      paramContext = this.a;
      if (paramContext != null) {
        paramContext.a(paramIntent);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpwifi\TPWifiConnectReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */