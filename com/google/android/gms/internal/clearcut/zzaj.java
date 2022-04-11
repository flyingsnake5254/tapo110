package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;

final class zzaj
  extends zzae<Boolean>
{
  zzaj(zzao paramzzao, String paramString, Boolean paramBoolean)
  {
    super(paramzzao, paramString, paramBoolean, null);
  }
  
  private final Boolean zzb(SharedPreferences paramSharedPreferences)
  {
    try
    {
      boolean bool = paramSharedPreferences.getBoolean(this.zzds, false);
      return Boolean.valueOf(bool);
    }
    catch (ClassCastException localClassCastException)
    {
      paramSharedPreferences = String.valueOf(this.zzds);
      if (paramSharedPreferences.length() != 0) {
        paramSharedPreferences = "Invalid boolean value in SharedPreferences for ".concat(paramSharedPreferences);
      } else {
        paramSharedPreferences = new String("Invalid boolean value in SharedPreferences for ");
      }
      Log.e("PhenotypeFlag", paramSharedPreferences, localClassCastException);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */