package com.google.android.gms.measurement.internal;

import android.content.pm.PackageInfo;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzfe
{
  final zzfu zza;
  
  zzfe(zzfu paramzzfu)
  {
    this.zza = paramzzfu;
  }
  
  @VisibleForTesting
  final boolean zza()
  {
    boolean bool = false;
    try
    {
      PackageManagerWrapper localPackageManagerWrapper = Wrappers.packageManager(this.zza.zzax());
      if (localPackageManagerWrapper == null)
      {
        this.zza.zzau().zzk().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
        return false;
      }
      int i = localPackageManagerWrapper.getPackageInfo("com.android.vending", 128).versionCode;
      if (i >= 80837300) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      this.zza.zzau().zzk().zzb("Failed to retrieve Play Store version for Install Referrer", localException);
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */