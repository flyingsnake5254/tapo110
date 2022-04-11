package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Log;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public abstract class zzht<T>
{
  private static final Object zzd = new Object();
  @Nullable
  private static volatile zzhs zze;
  private static volatile boolean zzf = false;
  private static final AtomicReference<Collection<zzht<?>>> zzg = new AtomicReference();
  private static final zzhv zzh = new zzhv(zzhm.zza);
  private static final AtomicInteger zzj = new AtomicInteger();
  final zzhr zza;
  final String zzb;
  private final T zzi;
  private volatile int zzk;
  private volatile T zzl;
  private final boolean zzm;
  
  @Deprecated
  public static void zzb(Context paramContext)
  {
    synchronized (zzd)
    {
      Object localObject2 = zze;
      Object localObject3 = paramContext.getApplicationContext();
      if (localObject3 != null) {
        paramContext = (Context)localObject3;
      }
      if ((localObject2 == null) || (((zzhs)localObject2).zza() != paramContext))
      {
        zzha.zzd();
        zzhu.zzb();
        zzhh.zzc();
        localObject3 = new com/google/android/gms/internal/measurement/zzhl;
        ((zzhl)localObject3).<init>(paramContext);
        localObject3 = zzif.zza((zzib)localObject3);
        localObject2 = new com/google/android/gms/internal/measurement/zzgx;
        ((zzgx)localObject2).<init>(paramContext, (zzib)localObject3);
        zze = (zzhs)localObject2;
        zzj.incrementAndGet();
      }
      return;
    }
  }
  
  static void zzc()
  {
    zzj.incrementAndGet();
  }
  
  abstract T zza(Object paramObject);
  
  public final String zzd()
  {
    String str = this.zza.zzd;
    return this.zzb;
  }
  
  public final T zze()
  {
    if (!this.zzm) {
      Objects.requireNonNull(this.zzb, "flagName must not be null");
    }
    int i = zzj.get();
    if (this.zzk < i) {
      try
      {
        if (this.zzk < i)
        {
          zzhs localzzhs = zze;
          Object localObject1;
          if (localzzhs != null)
          {
            boolean bool = this.zza.zzf;
            localObject1 = zzhh.zza(localzzhs.zza()).zzb("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
            if ((localObject1 != null) && (zzgv.zzc.matcher((CharSequence)localObject1).matches())) {
              if (Log.isLoggable("PhenotypeFlag", 3))
              {
                localObject1 = String.valueOf(zzd());
                if (((String)localObject1).length() != 0) {
                  localObject1 = "Bypass reading Phenotype values for flag: ".concat((String)localObject1);
                } else {
                  localObject1 = new String("Bypass reading Phenotype values for flag: ");
                }
                Log.d("PhenotypeFlag", (String)localObject1);
              }
            }
            do
            {
              do
              {
                localObject1 = null;
                break;
                if (this.zza.zzb != null)
                {
                  if (zzhj.zza(localzzhs.zza(), this.zza.zzb))
                  {
                    bool = this.zza.zzh;
                    localObject1 = zzha.zza(localzzhs.zza().getContentResolver(), this.zza.zzb);
                  }
                  else
                  {
                    localObject1 = null;
                  }
                }
                else
                {
                  localObject3 = localzzhs.zza();
                  localObject1 = this.zza.zza;
                  localObject1 = zzhu.zza((Context)localObject3, null);
                }
              } while (localObject1 == null);
              localObject1 = ((zzhe)localObject1).zze(zzd());
            } while (localObject1 == null);
            localObject1 = zza(localObject1);
            if (localObject1 == null)
            {
              bool = this.zza.zze;
              localObject1 = zzhh.zza(localzzhs.zza());
              bool = this.zza.zze;
              localObject1 = ((zzhh)localObject1).zzb(this.zzb);
              if (localObject1 != null) {
                localObject3 = zza(localObject1);
              } else {
                localObject3 = null;
              }
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = this.zzi;
              }
            }
            Object localObject3 = (zzhz)localzzhs.zzb().zza();
            if (((zzhz)localObject3).zza())
            {
              localObject1 = (zzhi)((zzhz)localObject3).zzb();
              localObject3 = this.zza;
              localObject1 = ((zzhi)localObject1).zza(((zzhr)localObject3).zzb, null, ((zzhr)localObject3).zzd, this.zzb);
              if (localObject1 == null) {
                localObject1 = this.zzi;
              } else {
                localObject1 = zza(localObject1);
              }
            }
            this.zzl = localObject1;
            this.zzk = i;
          }
          else
          {
            localObject1 = new java/lang/IllegalStateException;
            ((IllegalStateException)localObject1).<init>("Must call PhenotypeFlag.init() first");
            throw ((Throwable)localObject1);
          }
        }
      }
      finally {}
    }
    return (T)this.zzl;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */