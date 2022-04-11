package com.tplink.tpble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BLEStateReceiver
  extends BroadcastReceiver
{
  private y a;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
      if (i != 10)
      {
        if (i == 12)
        {
          paramContext = this.a;
          if (paramContext != null) {
            paramContext.a();
          }
        }
      }
      else
      {
        paramContext = this.a;
        if (paramContext != null) {
          paramContext.b();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tpble\BLEStateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */