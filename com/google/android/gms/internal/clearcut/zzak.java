package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;

final class zzak
  extends zzae<String>
{
  zzak(zzao paramzzao, String paramString1, String paramString2)
  {
    super(paramzzao, paramString1, paramString2, null);
  }
  
  private final String zzc(SharedPreferences paramSharedPreferences)
  {
    try
    {
      paramSharedPreferences = paramSharedPreferences.getString(this.zzds, null);
      return paramSharedPreferences;
    }
    catch (ClassCastException localClassCastException)
    {
      paramSharedPreferences = String.valueOf(this.zzds);
      if (paramSharedPreferences.length() != 0) {
        paramSharedPreferences = "Invalid string value in SharedPreferences for ".concat(paramSharedPreferences);
      } else {
        paramSharedPreferences = new String("Invalid string value in SharedPreferences for ");
      }
      Log.e("PhenotypeFlag", paramSharedPreferences, localClassCastException);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */