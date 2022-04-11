package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.flags.zze;

public final class zzh
  extends zza<String>
{
  public static String zza(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    try
    {
      zzi localzzi = new com/google/android/gms/flags/impl/zzi;
      localzzi.<init>(paramSharedPreferences, paramString1, paramString2);
      paramSharedPreferences = (String)zze.zza(localzzi);
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
    return paramString2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\flags\impl\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */