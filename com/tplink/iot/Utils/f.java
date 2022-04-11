package com.tplink.iot.Utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class f
{
  public static int a(Date paramDate1, Date paramDate2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate1);
    paramDate1 = Calendar.getInstance();
    paramDate1.setTime(paramDate2);
    int i = localCalendar.get(6);
    int j = paramDate1.get(6);
    int k = localCalendar.get(1);
    int m = paramDate1.get(1);
    if (k != m)
    {
      int n = 0;
      while (k < m)
      {
        if (((k % 4 == 0) && (k % 100 != 0)) || (k % 400 == 0)) {
          n += 366;
        } else {
          n += 365;
        }
        k++;
      }
      return n + (j - i);
    }
    return j - i;
  }
  
  public static String b(Context paramContext)
  {
    Object localObject1 = null;
    if (paramContext == null) {
      return null;
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Object localObject2;
    if (localTelephonyManager != null)
    {
      localObject2 = localTelephonyManager.getSimCountryIso();
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((String)localObject2).isEmpty()) {}
      }
      else
      {
        localObject1 = localTelephonyManager.getNetworkCountryIso();
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).isEmpty()) {}
    }
    else
    {
      localObject2 = paramContext.getResources().getConfiguration().locale.getCountry();
    }
    return (String)localObject2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */