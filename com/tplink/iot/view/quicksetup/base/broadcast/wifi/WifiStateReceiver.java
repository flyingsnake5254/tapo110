package com.tplink.iot.view.quicksetup.base.broadcast.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class WifiStateReceiver
  extends BroadcastReceiver
{
  private a a;
  
  public static IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    return localIntentFilter;
  }
  
  public void b(a parama)
  {
    this.a = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.net.wifi.WIFI_STATE_CHANGED")))
    {
      int i = paramIntent.getIntExtra("wifi_state", 1);
      if (i != 1)
      {
        if (i != 2)
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
            paramContext.c();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\broadcast\wifi\WifiStateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */