package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzbo
  implements zzaz
{
  @GuardedBy("SharedPreferencesLoader.class")
  private static final Map<String, zzbo> zzgr = new ArrayMap();
  private final Object zzfu;
  private volatile Map<String, ?> zzfv;
  @GuardedBy("this")
  private final List<zzaw> zzfw;
  private final SharedPreferences zzgs;
  private final SharedPreferences.OnSharedPreferenceChangeListener zzgt;
  
  private zzbo(SharedPreferences paramSharedPreferences)
  {
    zzbr localzzbr = new zzbr(this);
    this.zzgt = localzzbr;
    this.zzfu = new Object();
    this.zzfw = new ArrayList();
    this.zzgs = paramSharedPreferences;
    paramSharedPreferences.registerOnSharedPreferenceChangeListener(localzzbr);
  }
  
  static zzbo zzb(Context paramContext, String paramString)
  {
    boolean bool;
    if ((zzas.zzt()) && (!paramString.startsWith("direct_boot:"))) {
      bool = zzas.isUserUnlocked(paramContext);
    } else {
      bool = true;
    }
    if (!bool) {
      return null;
    }
    try
    {
      Map localMap = zzgr;
      zzbo localzzbo1 = (zzbo)localMap.get(paramString);
      zzbo localzzbo2 = localzzbo1;
      if (localzzbo1 == null)
      {
        localzzbo2 = new com/google/android/gms/internal/vision/zzbo;
        localzzbo2.<init>(zzc(paramContext, paramString));
        localMap.put(paramString, localzzbo2);
      }
      return localzzbo2;
    }
    finally {}
  }
  
  private static SharedPreferences zzc(Context paramContext, String paramString)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      if (paramString.startsWith("direct_boot:"))
      {
        Context localContext = paramContext;
        if (zzas.zzt()) {
          localContext = paramContext.createDeviceProtectedStorageContext();
        }
        paramContext = localContext.getSharedPreferences(paramString.substring(12), 0);
        return paramContext;
      }
      paramContext = paramContext.getSharedPreferences(paramString, 0);
      return paramContext;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
  
  static void zzy()
  {
    try
    {
      Iterator localIterator = zzgr.values().iterator();
      while (localIterator.hasNext())
      {
        zzbo localzzbo = (zzbo)localIterator.next();
        localzzbo.zzgs.unregisterOnSharedPreferenceChangeListener(localzzbo.zzgt);
      }
      zzgr.clear();
      return;
    }
    finally {}
  }
  
  public final Object zzb(String paramString)
  {
    Object localObject1 = this.zzfv;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      synchronized (this.zzfu)
      {
        localObject1 = this.zzfv;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject1 = StrictMode.allowThreadDiskReads();
        }
        try
        {
          localObject2 = this.zzgs.getAll();
          this.zzfv = ((Map)localObject2);
          StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)localObject1);
        }
        finally
        {
          StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)localObject1);
        }
      }
    }
    if (localObject2 != null) {
      return ((Map)localObject2).get(paramString);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */