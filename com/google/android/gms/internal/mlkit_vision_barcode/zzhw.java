package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzhw
{
  private static final zzhw zza = new zzhw();
  private final zzia zzb = new zzhb();
  private final ConcurrentMap<Class<?>, zzib<?>> zzc = new ConcurrentHashMap();
  
  public static zzhw zza()
  {
    return zza;
  }
  
  public final <T> zzib<T> zza(Class<T> paramClass)
  {
    zzgc.zza(paramClass, "messageType");
    zzib localzzib = (zzib)this.zzc.get(paramClass);
    Object localObject = localzzib;
    if (localzzib == null)
    {
      localObject = this.zzb.zza(paramClass);
      zzgc.zza(paramClass, "messageType");
      zzgc.zza(localObject, "schema");
      paramClass = (zzib)this.zzc.putIfAbsent(paramClass, localObject);
      if (paramClass != null) {
        localObject = paramClass;
      }
    }
    return (zzib<T>)localObject;
  }
  
  public final <T> zzib<T> zza(T paramT)
  {
    return zza(paramT.getClass());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */