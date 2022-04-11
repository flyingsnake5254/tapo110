package com.tplink.libtpwifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.ArrayList;
import java.util.List;

public class TPWifiScanReceiver
  extends BroadcastReceiver
{
  private String a = TPWifiScanReceiver.class.getSimpleName();
  private List<ScanResult> b = new ArrayList();
  
  public static IntentFilter b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
    return localIntentFilter;
  }
  
  public List<ScanResult> a()
  {
    return this.b;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.net.wifi.SCAN_RESULTS")))
    {
      paramContext = b.k().m();
      this.b.clear();
      try
      {
        paramContext = paramContext.getScanResults();
        if ((paramContext != null) && (paramContext.size() > 0)) {
          this.b.addAll(paramContext);
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpwifi\TPWifiScanReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */