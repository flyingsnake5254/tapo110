package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.flags.zze;

public final class zzf
  extends zza<Long>
{
  public static Long zza(SharedPreferences paramSharedPreferences, String paramString, Long paramLong)
  {
    try
    {
      zzg localzzg = new com/google/android/gms/flags/impl/zzg;
      localzzg.<init>(paramSharedPreferences, paramString, paramLong);
      paramSharedPreferences = (Long)zze.zza(localzzg);
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
    return paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\flags\impl\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */