package com.google.android.gms.phenotype;

import android.content.SharedPreferences;
import android.util.Log;

final class zzs
  extends PhenotypeFlag<String>
{
  zzs(PhenotypeFlag.Factory paramFactory, String paramString1, String paramString2)
  {
    super(paramFactory, paramString1, paramString2, null);
  }
  
  private final String zzb(SharedPreferences paramSharedPreferences)
  {
    try
    {
      paramSharedPreferences = paramSharedPreferences.getString(this.zzap, null);
      return paramSharedPreferences;
    }
    catch (ClassCastException localClassCastException)
    {
      paramSharedPreferences = String.valueOf(this.zzap);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\phenotype\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */