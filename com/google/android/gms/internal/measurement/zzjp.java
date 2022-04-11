package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzjp
{
  static final zzjp zza = new zzjp(true);
  private static volatile boolean zzb = false;
  private static volatile zzjp zzc;
  private static volatile zzjp zzd;
  private final Map<zzjo, zzkb<?, ?>> zze;
  
  zzjp()
  {
    this.zze = new HashMap();
  }
  
  zzjp(boolean paramBoolean)
  {
    this.zze = Collections.emptyMap();
  }
  
  public static zzjp zza()
  {
    zzjp localzzjp1 = zzc;
    zzjp localzzjp2 = localzzjp1;
    if (localzzjp1 == null) {
      try
      {
        localzzjp1 = zzc;
        localzzjp2 = localzzjp1;
        if (localzzjp1 == null)
        {
          localzzjp2 = zza;
          zzc = localzzjp2;
        }
      }
      finally {}
    }
    return localzzjp3;
  }
  
  public static zzjp zzb()
  {
    zzjp localzzjp = zzd;
    if (localzzjp != null) {
      return localzzjp;
    }
    try
    {
      localzzjp = zzd;
      if (localzzjp != null) {
        return localzzjp;
      }
      localzzjp = zzjx.zzb(zzjp.class);
      zzd = localzzjp;
      return localzzjp;
    }
    finally {}
  }
  
  public final <ContainingType extends zzli> zzkb<ContainingType, ?> zzc(ContainingType paramContainingType, int paramInt)
  {
    return (zzkb)this.zze.get(new zzjo(paramContainingType, paramInt));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */