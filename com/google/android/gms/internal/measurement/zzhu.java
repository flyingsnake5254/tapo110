package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class zzhu
  implements zzhe
{
  @GuardedBy("SharedPreferencesLoader.class")
  private static final Map<String, zzhu> zza = new ArrayMap();
  private final SharedPreferences zzb;
  private final SharedPreferences.OnSharedPreferenceChangeListener zzc;
  
  static zzhu zza(Context paramContext, String paramString)
  {
    if (!zzgw.zza()) {
      try
      {
        paramContext = (zzhu)zza.get(null);
        if (paramContext != null) {
          return paramContext;
        }
        paramContext = StrictMode.allowThreadDiskReads();
        try
        {
          throw null;
        }
        finally
        {
          StrictMode.setThreadPolicy(paramContext);
        }
        throw null;
      }
      finally {}
    }
  }
  
  static void zzb()
  {
    try
    {
      Map localMap = zza;
      Object localObject1 = localMap.values().iterator();
      if (!((Iterator)localObject1).hasNext())
      {
        localMap.clear();
        return;
      }
      localObject1 = ((zzhu)((Iterator)localObject1).next()).zzb;
      throw null;
    }
    finally {}
  }
  
  public final Object zze(String paramString)
  {
    throw null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */