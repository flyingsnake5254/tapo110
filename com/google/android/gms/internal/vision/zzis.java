package com.google.android.gms.internal.vision;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzis
{
  private static final zzis zzaac = new zzis();
  private final zziz zzaad = new zzhu();
  private final ConcurrentMap<Class<?>, zziw<?>> zzaae = new ConcurrentHashMap();
  
  public static zzis zzhp()
  {
    return zzaac;
  }
  
  public final <T> zziw<T> zzf(Class<T> paramClass)
  {
    zzgy.zza(paramClass, "messageType");
    zziw localzziw = (zziw)this.zzaae.get(paramClass);
    Object localObject = localzziw;
    if (localzziw == null)
    {
      localObject = this.zzaad.zze(paramClass);
      zzgy.zza(paramClass, "messageType");
      zzgy.zza(localObject, "schema");
      paramClass = (zziw)this.zzaae.putIfAbsent(paramClass, localObject);
      if (paramClass != null) {
        localObject = paramClass;
      }
    }
    return (zziw<T>)localObject;
  }
  
  public final <T> zziw<T> zzv(T paramT)
  {
    return zzf(paramT.getClass());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */