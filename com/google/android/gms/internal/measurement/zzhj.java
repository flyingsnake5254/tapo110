package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;

public final class zzhj
{
  static volatile zzhz<Boolean> zza = ;
  private static final Object zzb = new Object();
  
  public static boolean zza(Context paramContext, Uri arg1)
  {
    ??? = ???.getAuthority();
    bool1 = "com.google.android.gms.phenotype".equals(???);
    bool2 = false;
    if (!bool1)
    {
      paramContext = new StringBuilder(String.valueOf(???).length() + 91);
      paramContext.append(???);
      paramContext.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
      Log.e("PhenotypeClientHelper", paramContext.toString());
      return false;
    }
    if (zza.zza()) {
      return ((Boolean)zza.zzb()).booleanValue();
    }
    synchronized (zzb)
    {
      if (zza.zza())
      {
        bool1 = ((Boolean)zza.zzb()).booleanValue();
        return bool1;
      }
      if (!"com.google.android.gms".equals(paramContext.getPackageName()))
      {
        ProviderInfo localProviderInfo = paramContext.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0);
        bool1 = bool2;
        if (localProviderInfo == null) {
          break label195;
        }
        if (!"com.google.android.gms".equals(localProviderInfo.packageName))
        {
          bool1 = bool2;
          break label195;
        }
      }
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext = paramContext.getApplicationInfo("com.google.android.gms", 0);
        bool1 = bool2;
        if ((paramContext.flags & 0x81) != 0) {
          bool1 = true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          label195:
          bool1 = bool2;
        }
      }
      zza = zzhz.zzd(Boolean.valueOf(bool1));
      return ((Boolean)zza.zzb()).booleanValue();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */