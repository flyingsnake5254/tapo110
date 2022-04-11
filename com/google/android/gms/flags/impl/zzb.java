package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.flags.zze;

public final class zzb
  extends zza<Boolean>
{
  public static Boolean zza(SharedPreferences paramSharedPreferences, String paramString, Boolean paramBoolean)
  {
    try
    {
      zzc localzzc = new com/google/android/gms/flags/impl/zzc;
      localzzc.<init>(paramSharedPreferences, paramString, paramBoolean);
      paramSharedPreferences = (Boolean)zze.zza(localzzc);
      return paramSharedPreferences;
    }
    catch (Exception paramSharedPreferences)
    {
      paramSharedPreferences = String.valueOf(paramSharedPreferences.getMessage());
      if (paramSharedPreferences.length() != 0) {
        paramSharedPreferences = "Flag value not available, returning default: ".concat(paramSharedPreferences);
      } else {
        paramSharedPreferences = new String("Flag value not available, returning default: ");
      }
      Log.w("FlagDataUtils", paramSharedPreferences);
    }
    return paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\flags\impl\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */