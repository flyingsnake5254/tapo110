package b.d.d.m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import b.d.d.j.b;

public class g
{
  public static String a()
  {
    return b(b.a);
  }
  
  private static String b(Context paramContext)
  {
    String str1 = "other";
    if (paramContext == null) {
      return "other";
    }
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    String str2 = "4G";
    String str3;
    if (localNetworkInfo != null)
    {
      if (localNetworkInfo.getType() == 1)
      {
        paramContext = "wifi";
        break label196;
      }
      if (localNetworkInfo.getType() == 0)
      {
        str3 = localNetworkInfo.getSubtypeName();
        paramContext = str2;
      }
    }
    switch (localNetworkInfo.getSubtype())
    {
    default: 
      if ((!str3.equalsIgnoreCase("TD-SCDMA")) && (!str3.equalsIgnoreCase("WCDMA")) && (!str3.equalsIgnoreCase("CDMA2000"))) {
        break;
      }
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      paramContext = "3G";
      break;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      paramContext = "2G";
      break label196;
      if (str3.contains("LTE")) {
        paramContext = str2;
      } else {
        paramContext = "";
      }
      break;
    }
    label196:
    if (TextUtils.isEmpty(paramContext)) {
      paramContext = str1;
    }
    return paramContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\m\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */