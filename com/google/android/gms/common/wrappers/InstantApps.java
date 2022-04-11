package com.google.android.gms.common.wrappers;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
public class InstantApps
{
  private static Context zzhv;
  private static Boolean zzhw;
  
  @KeepForSdk
  public static boolean isInstantApp(Context paramContext)
  {
    try
    {
      Context localContext1 = paramContext.getApplicationContext();
      Context localContext2 = zzhv;
      if (localContext2 != null)
      {
        Boolean localBoolean = zzhw;
        if ((localBoolean != null) && (localContext2 == localContext1))
        {
          bool = localBoolean.booleanValue();
          return bool;
        }
      }
      zzhw = null;
      if (PlatformVersion.isAtLeastO()) {
        zzhw = Boolean.valueOf(localContext1.getPackageManager().isInstantApp());
      } else {
        try
        {
          paramContext.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
          zzhw = Boolean.TRUE;
        }
        catch (ClassNotFoundException paramContext)
        {
          zzhw = Boolean.FALSE;
        }
      }
      zzhv = localContext1;
      boolean bool = zzhw.booleanValue();
      return bool;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\wrappers\InstantApps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */