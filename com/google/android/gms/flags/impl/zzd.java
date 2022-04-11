package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;

public final class zzd
  extends zza<Integer>
{
  public static Integer zza(SharedPreferences paramSharedPreferences, String paramString, Integer paramInteger)
  {
    try
    {
      zze localzze = new com/google/android/gms/flags/impl/zze;
      localzze.<init>(paramSharedPreferences, paramString, paramInteger);
      paramSharedPreferences = (Integer)com.google.android.gms.internal.flags.zze.zza(localzze);
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
    return paramInteger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\flags\impl\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */