package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzlq
{
  private static final zzlq zza = new zzlq();
  private final zzlu zzb = new zzla();
  private final ConcurrentMap<Class<?>, zzlt<?>> zzc = new ConcurrentHashMap();
  
  public static zzlq zza()
  {
    return zza;
  }
  
  public final <T> zzlt<T> zzb(Class<T> paramClass)
  {
    zzkl.zzb(paramClass, "messageType");
    zzlt localzzlt1 = (zzlt)this.zzc.get(paramClass);
    zzlt localzzlt2 = localzzlt1;
    if (localzzlt1 == null)
    {
      localzzlt2 = this.zzb.zza(paramClass);
      zzkl.zzb(paramClass, "messageType");
      zzkl.zzb(localzzlt2, "schema");
      paramClass = (zzlt)this.zzc.putIfAbsent(paramClass, localzzlt2);
      if (paramClass != null) {
        return paramClass;
      }
    }
    return localzzlt2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzlq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */