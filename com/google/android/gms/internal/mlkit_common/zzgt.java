package com.google.android.gms.internal.mlkit_common;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzgt
{
  private static final zzgt zza = new zzgt();
  private final zzgx zzb = new zzfy();
  private final ConcurrentMap<Class<?>, zzgy<?>> zzc = new ConcurrentHashMap();
  
  public static zzgt zza()
  {
    return zza;
  }
  
  public final <T> zzgy<T> zza(Class<T> paramClass)
  {
    zzfc.zza(paramClass, "messageType");
    zzgy localzzgy = (zzgy)this.zzc.get(paramClass);
    Object localObject = localzzgy;
    if (localzzgy == null)
    {
      localObject = this.zzb.zza(paramClass);
      zzfc.zza(paramClass, "messageType");
      zzfc.zza(localObject, "schema");
      paramClass = (zzgy)this.zzc.putIfAbsent(paramClass, localObject);
      if (paramClass != null) {
        localObject = paramClass;
      }
    }
    return (zzgy<T>)localObject;
  }
  
  public final <T> zzgy<T> zza(T paramT)
  {
    return zza(paramT.getClass());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */