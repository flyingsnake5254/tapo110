package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;

final class zzal
  extends zzae<T>
{
  private final Object lock = new Object();
  private String zzec;
  private T zzed;
  
  zzal(zzao paramzzao, String paramString, Object paramObject, zzan paramzzan)
  {
    super(paramzzao, paramString, paramObject, null);
  }
  
  protected final T zza(SharedPreferences paramSharedPreferences)
  {
    try
    {
      paramSharedPreferences = zzb(paramSharedPreferences.getString(this.zzds, ""));
      return paramSharedPreferences;
    }
    catch (ClassCastException localClassCastException)
    {
      paramSharedPreferences = String.valueOf(this.zzds);
      if (paramSharedPreferences.length() != 0) {
        paramSharedPreferences = "Invalid byte[] value in SharedPreferences for ".concat(paramSharedPreferences);
      } else {
        paramSharedPreferences = new String("Invalid byte[] value in SharedPreferences for ");
      }
      Log.e("PhenotypeFlag", paramSharedPreferences, localClassCastException);
    }
    return null;
  }
  
  protected final T zzb(String paramString)
  {
    try
    {
      synchronized (this.lock)
      {
        if (!paramString.equals(this.zzec))
        {
          localObject2 = this.zzee.zzb(Base64.decode(paramString, 3));
          this.zzec = paramString;
          this.zzed = localObject2;
        }
        Object localObject2 = this.zzed;
        return (T)localObject2;
      }
      String str;
      StringBuilder localStringBuilder;
      return null;
    }
    catch (IOException|IllegalArgumentException localIOException)
    {
      str = this.zzds;
      localStringBuilder = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(paramString).length());
      localStringBuilder.append("Invalid byte[] value for ");
      localStringBuilder.append(str);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString);
      Log.e("PhenotypeFlag", localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */