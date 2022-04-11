package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;

public final class zzbh
{
  private static volatile zzcs<Boolean> zzgd = ;
  private static final Object zzge = new Object();
  
  public static boolean zza(Context paramContext, Uri arg1)
  {
    ??? = ???.getAuthority();
    boolean bool1 = "com.google.android.gms.phenotype".equals(???);
    boolean bool2 = false;
    if (!bool1)
    {
      paramContext = new StringBuilder(String.valueOf(???).length() + 91);
      paramContext.append(???);
      paramContext.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
      Log.e("PhenotypeClientHelper", paramContext.toString());
      return false;
    }
    if (zzgd.isPresent()) {
      return ((Boolean)zzgd.get()).booleanValue();
    }
    synchronized (zzge)
    {
      if (zzgd.isPresent())
      {
        bool1 = ((Boolean)zzgd.get()).booleanValue();
        return bool1;
      }
      if ("com.google.android.gms".equals(paramContext.getPackageName())) {}
      ProviderInfo localProviderInfo;
      do
      {
        i = 1;
        break;
        localProviderInfo = paramContext.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0);
      } while ((localProviderInfo != null) && ("com.google.android.gms".equals(localProviderInfo.packageName)));
      int i = 0;
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (zzh(paramContext)) {
          bool1 = true;
        }
      }
      zzgd = zzcs.zzc(Boolean.valueOf(bool1));
      return ((Boolean)zzgd.get()).booleanValue();
    }
  }
  
  private static boolean zzh(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getApplicationInfo("com.google.android.gms", 0);
      if ((paramContext.flags & 0x81) != 0) {
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */