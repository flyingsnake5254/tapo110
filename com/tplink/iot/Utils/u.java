package com.tplink.iot.Utils;

import android.app.NotificationManager;
import android.content.Context;

public class u
{
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      if (paramContext != null) {
        paramContext.cancelAll();
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */