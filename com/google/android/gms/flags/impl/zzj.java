package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.flags.zze;

public final class zzj
{
  private static SharedPreferences zzw;
  
  public static SharedPreferences zza(Context paramContext)
    throws Exception
  {
    try
    {
      if (zzw == null)
      {
        zzk localzzk = new com/google/android/gms/flags/impl/zzk;
        localzzk.<init>(paramContext);
        zzw = (SharedPreferences)zze.zza(localzzk);
      }
      paramContext = zzw;
      return paramContext;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\flags\impl\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */