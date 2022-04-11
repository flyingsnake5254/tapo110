package com.tplink.libtpwifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TPWifiStateReceiver
  extends BroadcastReceiver
{
  private c a;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.net.wifi.WIFI_STATE_CHANGED")))
    {
      int i = paramIntent.getIntExtra("wifi_state", 1);
      if (i != 1)
      {
        if (i == 3)
        {
          paramContext = this.a;
          if (paramContext != null) {
            paramContext.b();
          }
        }
      }
      else
      {
        paramContext = this.a;
        if (paramContext != null) {
          paramContext.a();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpwifi\TPWifiStateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */