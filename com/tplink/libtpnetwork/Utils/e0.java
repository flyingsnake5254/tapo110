package com.tplink.libtpnetwork.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.util.Log;
import b.d.w.c.a;
import b.d.w.f.b;

public class e0
{
  public static void a(Context paramContext)
  {
    b(paramContext, null);
  }
  
  public static void b(Context paramContext, Network paramNetwork)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bindProcessToNetwork network =");
    localStringBuilder.append(paramNetwork);
    a.c("WifiNetworkUtils", localStringBuilder.toString());
    if (paramContext == null) {
      return;
    }
    try
    {
      a.c("WifiNetworkUtils", "bindProcessToNetwork bindProcessToNetwork");
      int i = Build.VERSION.SDK_INT;
      if (i >= 23)
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext == null) {
          return;
        }
        paramContext.bindProcessToNetwork(paramNetwork);
      }
      else if (i >= 21)
      {
        ConnectivityManager.setProcessDefaultNetwork(paramNetwork);
      }
    }
    catch (Exception paramContext)
    {
      a.e("WifiNetworkUtils", Log.getStackTraceString(paramContext));
    }
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool1 = false;
    if (paramContext == null) {
      return false;
    }
    Object localObject = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    boolean bool2 = bool1;
    if (localObject != null) {
      if (!((WifiManager)localObject).isWifiEnabled())
      {
        bool2 = bool1;
      }
      else
      {
        localObject = ((WifiManager)localObject).getConnectionInfo();
        if ((localObject == null) || (((WifiInfo)localObject).getNetworkId() == -1))
        {
          bool2 = bool1;
          if (b.j(paramContext))
          {
            bool2 = bool1;
            if (!b.i(paramContext)) {}
          }
        }
        else
        {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */