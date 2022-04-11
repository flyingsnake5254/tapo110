package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
public class Wrappers
{
  private static Wrappers zzhz = new Wrappers();
  private PackageManagerWrapper zzhy = null;
  
  @KeepForSdk
  public static PackageManagerWrapper packageManager(Context paramContext)
  {
    return zzhz.zzi(paramContext);
  }
  
  @VisibleForTesting
  private final PackageManagerWrapper zzi(Context paramContext)
  {
    try
    {
      if (this.zzhy == null)
      {
        if (paramContext.getApplicationContext() != null) {
          paramContext = paramContext.getApplicationContext();
        }
        PackageManagerWrapper localPackageManagerWrapper = new com/google/android/gms/common/wrappers/PackageManagerWrapper;
        localPackageManagerWrapper.<init>(paramContext);
        this.zzhy = localPackageManagerWrapper;
      }
      paramContext = this.zzhy;
      return paramContext;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\wrappers\Wrappers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */