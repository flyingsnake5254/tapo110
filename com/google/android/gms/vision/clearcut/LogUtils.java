package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.vision.zzef.zza;
import com.google.android.gms.internal.vision.zzef.zza.zza;
import com.google.android.gms.internal.vision.zzgx.zza;
import com.google.android.gms.vision.L;

@Keep
public class LogUtils
{
  public static zzef.zza zza(Context paramContext)
  {
    zzef.zza.zza localzza = zzef.zza.zzck().zzl(paramContext.getPackageName());
    paramContext = zzb(paramContext);
    if (paramContext != null) {
      localzza.zzm(paramContext);
    }
    return (zzef.zza)localzza.zzgd();
  }
  
  @Nullable
  private static String zzb(Context paramContext)
  {
    try
    {
      String str = Wrappers.packageManager(paramContext).getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      L.e(localNameNotFoundException, "Unable to find calling package info for %s", new Object[] { paramContext.getPackageName() });
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\clearcut\LogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */