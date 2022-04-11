package com.tplink.iot.view.welcome;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import b.d.w.c.a;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

public class b
{
  public static boolean a(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool4 = bool1;
    try
    {
      Object localObject = paramContext.getPackageInfo("com.android.vending", 1);
      bool5 = bool2;
      if (localObject != null)
      {
        bool4 = bool1;
        localObject = ((PackageInfo)localObject).applicationInfo;
        bool5 = bool2;
        if (localObject != null)
        {
          bool4 = bool1;
          localObject = (String)((ApplicationInfo)localObject).loadLabel(paramContext);
          if (localObject != null)
          {
            bool4 = bool1;
            bool5 = ((String)localObject).equals("Market");
            if (!bool5)
            {
              bool5 = bool3;
              break label94;
            }
          }
          bool5 = false;
          label94:
          if (bool5) {
            try
            {
              localObject = new android/content/Intent;
              ((Intent)localObject).<init>("android.intent.action.VIEW");
              ((Intent)localObject).setData(Uri.parse("https://play.google.com/store/apps/details?id=com.tplink.iot"));
              ((Intent)localObject).setPackage("com.android.vending");
              paramContext = ((Intent)localObject).resolveActivity(paramContext);
              if (paramContext == null) {
                bool5 = bool2;
              }
            }
            catch (Exception paramContext)
            {
              bool4 = bool5;
              break label209;
            }
          }
        }
      }
      bool4 = bool5;
      paramContext = new java/lang/StringBuilder;
      bool4 = bool5;
      paramContext.<init>();
      bool4 = bool5;
      paramContext.append("googlePlay is installed=");
      bool4 = bool5;
      paramContext.append(bool5);
      bool4 = bool5;
      a.c("GoogleSuitCheck", paramContext.toString());
    }
    catch (Exception paramContext)
    {
      boolean bool5;
      label209:
      for (;;) {}
    }
    a.c("GoogleSuitCheck", "not install googlePlay");
    bool5 = bool4;
    return bool5;
  }
  
  public static boolean b(Context paramContext)
  {
    if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext) == 0)
    {
      a.c("GoogleSuitCheck", "google service ok");
      return true;
    }
    a.c("GoogleSuitCheck", "google service error");
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\welcome\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */