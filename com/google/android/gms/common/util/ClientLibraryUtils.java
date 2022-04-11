package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
public class ClientLibraryUtils
{
  @KeepForSdk
  public static int getClientVersion(Context paramContext, String paramString)
  {
    paramContext = zzb(paramContext, paramString);
    if (paramContext != null)
    {
      paramContext = paramContext.applicationInfo;
      if (paramContext != null)
      {
        paramContext = paramContext.metaData;
        if (paramContext == null) {
          return -1;
        }
        return paramContext.getInt("com.google.android.gms.version", -1);
      }
    }
    return -1;
  }
  
  @KeepForSdk
  public static boolean isPackageSide()
  {
    return false;
  }
  
  @Nullable
  private static PackageInfo zzb(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 128);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static boolean zzc(Context paramContext, String paramString)
  {
    "com.google.android.gms".equals(paramString);
    try
    {
      int i = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0).flags;
      if ((i & 0x200000) != 0) {
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\ClientLibraryUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */