package com.tplink.iot.view.quicksetup.base.broadcast.ble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class BLEStateOnReceiver
  extends BroadcastReceiver
{
  private a a;
  
  public static IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    return localIntentFilter;
  }
  
  public void b(a parama)
  {
    this.a = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction())) {
      switch (paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE))
      {
      default: 
        break;
      case 12: 
        paramContext = this.a;
        if (paramContext != null) {
          paramContext.a();
        }
        break;
      case 11: 
        paramContext = this.a;
        if (paramContext != null) {
          paramContext.c();
        }
        break;
      case 10: 
        paramContext = this.a;
        if (paramContext != null) {
          paramContext.b();
        }
        break;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\broadcast\ble\BLEStateOnReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */