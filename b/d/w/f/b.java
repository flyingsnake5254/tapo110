package b.d.w.f;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import b.d.w.c.a;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class b
{
  @SuppressLint({"HardwareIds"})
  @RequiresPermission("android.permission.ACCESS_WIFI_STATE")
  public static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return b();
    }
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext != null)
    {
      paramContext = paramContext.getConnectionInfo();
      if (paramContext != null) {
        return paramContext.getMacAddress();
      }
    }
    return null;
  }
  
  public static String b()
  {
    Object localObject1 = null;
    Object localObject4;
    try
    {
      Object localObject2 = NetworkInterface.getNetworkInterfaces();
      NetworkInterface localNetworkInterface;
      do
      {
        do
        {
          localObject3 = localObject1;
          if (!((Enumeration)localObject2).hasMoreElements()) {
            break;
          }
          localNetworkInterface = (NetworkInterface)((Enumeration)localObject2).nextElement();
        } while (!localNetworkInterface.getName().equalsIgnoreCase("wlan0"));
        localObject3 = localNetworkInterface.getHardwareAddress();
      } while ((localObject3 == null) || (localObject3.length == 0));
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      int i = localObject3.length;
      for (int j = 0; j < i; j++) {
        ((StringBuilder)localObject2).append(String.format("%02X:", new Object[] { Byte.valueOf(localObject3[j]) }));
      }
      if (((StringBuilder)localObject2).length() > 0) {
        ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
      }
      Object localObject3 = ((StringBuilder)localObject2).toString();
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append("interfaceName=");
      ((StringBuilder)localObject2).append(localNetworkInterface.getName());
      ((StringBuilder)localObject2).append(", mac=");
      ((StringBuilder)localObject2).append((String)localObject3);
      a.c("mac", ((StringBuilder)localObject2).toString());
    }
    catch (SocketException localSocketException)
    {
      a.d(localSocketException.toString());
      localObject4 = localObject1;
    }
    return (String)localObject4;
  }
  
  private static int c(int paramInt)
  {
    if (paramInt != 20)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 13: 
        return 3;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        return 2;
      }
      return 1;
    }
    return 4;
  }
  
  @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
  public static String d(Context paramContext)
  {
    Object localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (((NetworkInfo)localObject1).isAvailable()))
    {
      int i = c(((NetworkInfo)localObject1).getSubtype());
      if (((NetworkInfo)localObject1).getType() == 1) {
        return "wifi";
      }
      if (i == 1)
      {
        try
        {
          localObject1 = ((NetworkInfo)localObject1).getExtraInfo();
          boolean bool = ((String)localObject1).equals("cmwap");
          if ((!bool) && (!((String)localObject1).equals("3gwap")) && (!((String)localObject1).equals("uniwap")))
          {
            localObject1 = paramContext.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
            paramContext = (Context)localObject2;
            if (localObject1 != null)
            {
              ((Cursor)localObject1).moveToFirst();
              paramContext = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("user"));
              ((Cursor)localObject1).close();
            }
            if (paramContext != null)
            {
              bool = paramContext.startsWith("ctwap");
              if (!bool) {}
            }
          }
          else
          {
            return "2g_wap";
          }
        }
        catch (Exception paramContext)
        {
          a.d(paramContext.toString());
        }
        return "2g_net";
      }
      if (i == 2) {
        return "3g";
      }
      if (i == 3) {
        return "4g";
      }
      if (i == 4) {
        return "5g";
      }
      paramContext = ((NetworkInfo)localObject1).getSubtypeName();
      if ((!"TD-SCDMA".equalsIgnoreCase(paramContext)) && (!"WCDMA".equalsIgnoreCase(paramContext)) && (!"CDMA2000".equalsIgnoreCase(paramContext))) {
        return "other";
      }
      return "3g";
    }
    return "none";
  }
  
  public static int e(@NonNull Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    int i;
    if (paramContext != null) {
      try
      {
        i = paramContext.getPackageInfo(paramString, 0).versionCode;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        a.d(paramContext.toString());
      }
    } else {
      i = -1;
    }
    return i;
  }
  
  public static String f(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    if (paramContext != null) {
      try
      {
        paramContext = paramContext.getPackageInfo(paramString, 0).versionName;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        a.d(paramContext.toString());
      }
    } else {
      paramContext = "";
    }
    return paramContext;
  }
  
  public static boolean g()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
  public static boolean h(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null) {
      paramContext = paramContext.getActiveNetworkInfo();
    } else {
      paramContext = null;
    }
    boolean bool;
    if ((paramContext != null) && (paramContext.isConnected())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
  public static boolean i(Context paramContext)
  {
    return "wifi".equals(d(paramContext));
  }
  
  @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
  public static boolean j(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool = true;
    if (paramContext != null) {
      paramContext = paramContext.getNetworkInfo(1);
    } else {
      paramContext = null;
    }
    if ((paramContext == null) || (!paramContext.isConnectedOrConnecting())) {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */