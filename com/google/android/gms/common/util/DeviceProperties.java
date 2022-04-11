package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class DeviceProperties
{
  private static Boolean zzgn;
  private static Boolean zzgo;
  private static Boolean zzgp;
  private static Boolean zzgq;
  private static Boolean zzgr;
  private static Boolean zzgs;
  private static Boolean zzgt;
  private static Boolean zzgu;
  
  @KeepForSdk
  public static boolean isAuto(Context paramContext)
  {
    if (zzgt == null)
    {
      boolean bool;
      if ((PlatformVersion.isAtLeastO()) && (paramContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive"))) {
        bool = true;
      } else {
        bool = false;
      }
      zzgt = Boolean.valueOf(bool);
    }
    return zzgt.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isLatchsky(Context paramContext)
  {
    if (zzgr == null)
    {
      paramContext = paramContext.getPackageManager();
      boolean bool;
      if ((paramContext.hasSystemFeature("com.google.android.feature.services_updater")) && (paramContext.hasSystemFeature("cn.google.services"))) {
        bool = true;
      } else {
        bool = false;
      }
      zzgr = Boolean.valueOf(bool);
    }
    return zzgr.booleanValue();
  }
  
  @TargetApi(21)
  @KeepForSdk
  public static boolean isSidewinder(Context paramContext)
  {
    if (zzgq == null)
    {
      boolean bool;
      if ((PlatformVersion.isAtLeastLollipop()) && (paramContext.getPackageManager().hasSystemFeature("cn.google"))) {
        bool = true;
      } else {
        bool = false;
      }
      zzgq = Boolean.valueOf(bool);
    }
    return zzgq.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isTablet(Resources paramResources)
  {
    boolean bool1 = false;
    if (paramResources == null) {
      return false;
    }
    if (zzgn == null)
    {
      int i;
      if ((paramResources.getConfiguration().screenLayout & 0xF) > 3) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool2;
      if (i == 0)
      {
        if (zzgo == null)
        {
          paramResources = paramResources.getConfiguration();
          if (((paramResources.screenLayout & 0xF) <= 3) && (paramResources.smallestScreenWidthDp >= 600)) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          zzgo = Boolean.valueOf(bool2);
        }
        bool2 = bool1;
        if (!zzgo.booleanValue()) {}
      }
      else
      {
        bool2 = true;
      }
      zzgn = Boolean.valueOf(bool2);
    }
    return zzgn.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isTv(Context paramContext)
  {
    if (zzgu == null)
    {
      paramContext = paramContext.getPackageManager();
      boolean bool;
      if ((!paramContext.hasSystemFeature("com.google.android.tv")) && (!paramContext.hasSystemFeature("android.hardware.type.television")) && (!paramContext.hasSystemFeature("android.software.leanback"))) {
        bool = false;
      } else {
        bool = true;
      }
      zzgu = Boolean.valueOf(bool);
    }
    return zzgu.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isUserBuild()
  {
    return "user".equals(Build.TYPE);
  }
  
  @TargetApi(20)
  @KeepForSdk
  public static boolean isWearable(Context paramContext)
  {
    if (zzgp == null)
    {
      boolean bool;
      if ((PlatformVersion.isAtLeastKitKatWatch()) && (paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"))) {
        bool = true;
      } else {
        bool = false;
      }
      zzgp = Boolean.valueOf(bool);
    }
    return zzgp.booleanValue();
  }
  
  @TargetApi(26)
  @KeepForSdk
  public static boolean isWearableWithoutPlayStore(Context paramContext)
  {
    return (isWearable(paramContext)) && ((!PlatformVersion.isAtLeastN()) || ((isSidewinder(paramContext)) && (!PlatformVersion.isAtLeastO())));
  }
  
  public static boolean zzf(Context paramContext)
  {
    if (zzgs == null)
    {
      boolean bool;
      if ((!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.iot")) && (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.embedded"))) {
        bool = false;
      } else {
        bool = true;
      }
      zzgs = Boolean.valueOf(bool);
    }
    return zzgs.booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\DeviceProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */