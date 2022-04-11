package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzc
{
  final zzf zza;
  zzg zzb;
  final zzab zzc;
  private final zzz zzd;
  
  public zzc()
  {
    this.zza = localzzf;
    this.zzb = localzzf.zzb.zzc();
    this.zzc = new zzab();
    this.zzd = new zzz();
    Object localObject = new zza(this);
    localzzf.zzd.zza("internal.registerCallback", (Callable)localObject);
    localObject = new zzb(this);
    localzzf.zzd.zza("internal.eventLogger", (Callable)localObject);
  }
  
  public final void zza(String paramString, Callable<? extends zzai> paramCallable)
  {
    this.zza.zzd.zza(paramString, paramCallable);
  }
  
  public final boolean zzb(zzaa paramzzaa)
    throws zzd
  {
    try
    {
      this.zzc.zzb(paramzzaa);
      zzg localzzg = this.zza.zzc;
      paramzzaa = new com/google/android/gms/internal/measurement/zzah;
      paramzzaa.<init>(Double.valueOf(0.0D));
      localzzg.zze("runtime.counter", paramzzaa);
      this.zzd.zzb(this.zzb.zzc(), this.zzc);
      if (!zzc())
      {
        boolean bool = zzd();
        if (!bool) {
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  public final boolean zzc()
  {
    return !this.zzc.zzc().equals(this.zzc.zza());
  }
  
  public final boolean zzd()
  {
    return !this.zzc.zzf().isEmpty();
  }
  
  public final zzab zze()
  {
    return this.zzc;
  }
  
  public final void zzf(zzgo paramzzgo)
    throws zzd
  {
    try
    {
      this.zzb = this.zza.zzb.zzc();
      Object localObject1 = paramzzgo.zza();
      if (!(this.zza.zza(this.zzb, (zzgt[])((List)localObject1).toArray(new zzgt[0])) instanceof zzag))
      {
        Object localObject2 = paramzzgo.zzb().zza().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (zzgm)((Iterator)localObject2).next();
          paramzzgo = ((zzgm)localObject1).zzb();
          localObject1 = ((zzgm)localObject1).zza();
          Iterator localIterator = paramzzgo.iterator();
          while (localIterator.hasNext())
          {
            paramzzgo = (zzgt)localIterator.next();
            zzap localzzap = this.zza.zza(this.zzb, new zzgt[] { paramzzgo });
            if (!(localzzap instanceof zzam)) {
              break label292;
            }
            paramzzgo = this.zzb;
            if (!paramzzgo.zzd((String)localObject1))
            {
              paramzzgo = null;
            }
            else
            {
              paramzzgo = paramzzgo.zzh((String)localObject1);
              if (!(paramzzgo instanceof zzai))
              {
                localObject2 = new java/lang/IllegalStateException;
                paramzzgo = String.valueOf(localObject1);
                if (paramzzgo.length() != 0) {
                  paramzzgo = "Invalid function name: ".concat(paramzzgo);
                } else {
                  paramzzgo = new String("Invalid function name: ");
                }
                ((IllegalStateException)localObject2).<init>(paramzzgo);
                throw ((Throwable)localObject2);
              }
              paramzzgo = (zzai)paramzzgo;
            }
            if (paramzzgo == null)
            {
              localObject2 = new java/lang/IllegalStateException;
              paramzzgo = String.valueOf(localObject1);
              if (paramzzgo.length() != 0) {
                paramzzgo = "Rule function is undefined: ".concat(paramzzgo);
              } else {
                paramzzgo = new String("Rule function is undefined: ");
              }
              ((IllegalStateException)localObject2).<init>(paramzzgo);
              throw ((Throwable)localObject2);
            }
            paramzzgo.zza(this.zzb, Collections.singletonList(localzzap));
          }
          continue;
          label292:
          paramzzgo = new java/lang/IllegalArgumentException;
          paramzzgo.<init>("Invalid rule definition");
          throw paramzzgo;
        }
        return;
      }
      paramzzgo = new java/lang/IllegalStateException;
      paramzzgo.<init>("Program loading failed");
      throw paramzzgo;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */