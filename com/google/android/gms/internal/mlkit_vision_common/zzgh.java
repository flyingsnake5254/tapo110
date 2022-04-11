package com.google.android.gms.internal.mlkit_vision_common;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzgh
{
  private static final zzgh zza = new zzgh();
  private final zzgl zzb = new zzfi();
  private final ConcurrentMap<Class<?>, zzgi<?>> zzc = new ConcurrentHashMap();
  
  public static zzgh zza()
  {
    return zza;
  }
  
  public final <T> zzgi<T> zza(Class<T> paramClass)
  {
    zzem.zza(paramClass, "messageType");
    zzgi localzzgi = (zzgi)this.zzc.get(paramClass);
    Object localObject = localzzgi;
    if (localzzgi == null)
    {
      localObject = this.zzb.zza(paramClass);
      zzem.zza(paramClass, "messageType");
      zzem.zza(localObject, "schema");
      paramClass = (zzgi)this.zzc.putIfAbsent(paramClass, localObject);
      if (paramClass != null) {
        localObject = paramClass;
      }
    }
    return (zzgi<T>)localObject;
  }
  
  public final <T> zzgi<T> zza(T paramT)
  {
    return zza(paramT.getClass());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzgh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */