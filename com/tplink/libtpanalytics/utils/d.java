package com.tplink.libtpanalytics.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class d
{
  public static String a(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = "";
    if (i < 23)
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if ((paramContext != null) && (paramContext.getMacAddress() != null)) {
        return paramContext.getMacAddress().toUpperCase().replaceAll(":", "-");
      }
      return "";
    }
    try
    {
      Iterator localIterator = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      for (;;)
      {
        paramContext = "";
        label70:
        localObject = paramContext;
        try
        {
          if (!localIterator.hasNext()) {
            break label205;
          }
          localObject = (NetworkInterface)localIterator.next();
          if (!((NetworkInterface)localObject).getName().equalsIgnoreCase("wlan0")) {
            break label70;
          }
          localObject = ((NetworkInterface)localObject).getHardwareAddress();
          if (localObject != null)
          {
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            int j = localObject.length;
            for (i = 0; i < j; i++) {
              localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(localObject[i]) }));
            }
            if (localStringBuilder.length() > 0) {
              localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
            }
            localObject = localStringBuilder.toString();
            paramContext = (Context)localObject;
          }
        }
        catch (Exception localException) {}
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Context localContext;
        paramContext = localContext;
      }
    }
    localContext = paramContext;
    label205:
    return localContext.toUpperCase().replaceAll(":", "-");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */