package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.collection.LruCache;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzab;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzpt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class zzgm
  extends zzec
{
  private final zzkn zza;
  private Boolean zzb;
  private String zzc;
  
  public zzgm(zzkn paramzzkn, String paramString)
  {
    Preconditions.checkNotNull(paramzzkn);
    this.zza = paramzzkn;
    this.zzc = null;
  }
  
  @BinderThread
  private final void zzA(zzp paramzzp, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramzzp);
    Preconditions.checkNotEmpty(paramzzp.zza);
    zzB(paramzzp.zza, false);
    this.zza.zzq().zzA(paramzzp.zzb, paramzzp.zzq, paramzzp.zzu);
  }
  
  @BinderThread
  private final void zzB(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBoolean) {}
      try
      {
        if (this.zzb == null)
        {
          if ((!"com.google.android.gms".equals(this.zzc)) && (!UidVerifier.isGooglePlayServicesUid(this.zza.zzax(), Binder.getCallingUid())) && (!GoogleSignatureVerifier.getInstance(this.zza.zzax()).isUidGoogleSigned(Binder.getCallingUid()))) {
            paramBoolean = false;
          } else {
            paramBoolean = true;
          }
          this.zzb = Boolean.valueOf(paramBoolean);
        }
        if (!this.zzb.booleanValue())
        {
          if ((this.zzc == null) && (GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzax(), Binder.getCallingUid(), paramString))) {
            this.zzc = paramString;
          }
          if (!paramString.equals(this.zzc)) {}
        }
        else
        {
          return;
        }
        SecurityException localSecurityException1 = new java/lang/SecurityException;
        localSecurityException1.<init>(String.format("Unknown calling package name '%s'.", new Object[] { paramString }));
        throw localSecurityException1;
      }
      catch (SecurityException localSecurityException2)
      {
        this.zza.zzau().zzb().zzb("Measurement Service called with invalid calling package. appId", zzem.zzl(paramString));
        throw localSecurityException2;
      }
    }
    this.zza.zzau().zzb().zza("Measurement Service called without app package");
    throw new SecurityException("Measurement Service called without app package");
  }
  
  private final void zzz(zzas paramzzas, zzp paramzzp)
  {
    this.zza.zzG();
    this.zza.zzy(paramzzas, paramzzp);
  }
  
  final void zzb(zzas paramzzas, zzp paramzzp)
  {
    if (!this.zza.zzf().zzh(paramzzp.zza))
    {
      zzz(paramzzas, paramzzp);
      return;
    }
    this.zza.zzau().zzk().zzb("EES config found for", paramzzp.zza);
    Object localObject1 = this.zza.zzf();
    Object localObject2 = paramzzp.zza;
    zzpt.zzb();
    Object localObject3 = ((zzgn)localObject1).zzs.zzc();
    Object localObject4 = zzea.zzaD;
    Object localObject5 = null;
    Object localObject6 = localObject5;
    if (((zzae)localObject3).zzn(null, (zzdz)localObject4)) {
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject6 = localObject5;
      } else {
        localObject6 = (zzc)((zzfl)localObject1).zza.get(localObject2);
      }
    }
    if (localObject6 != null) {
      try
      {
        localObject1 = paramzzas.zzb.zzf();
        localObject2 = new java/util/HashMap;
        ((HashMap)localObject2).<init>();
        localObject5 = ((Bundle)localObject1).keySet().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject4 = (String)((Iterator)localObject5).next();
          localObject3 = ((Bundle)localObject1).get((String)localObject4);
          if (localObject3 != null) {
            ((Map)localObject2).put(localObject4, localObject3);
          }
        }
        localObject3 = zzgr.zza(paramzzas.zza);
        localObject5 = localObject3;
        if (localObject3 == null) {
          localObject5 = paramzzas.zza;
        }
        localObject3 = new com/google/android/gms/internal/measurement/zzaa;
        ((com.google.android.gms.internal.measurement.zzaa)localObject3).<init>((String)localObject5, paramzzas.zzd, (Map)localObject2);
        boolean bool = ((zzc)localObject6).zzb((com.google.android.gms.internal.measurement.zzaa)localObject3);
        if (bool)
        {
          if (((zzc)localObject6).zzc())
          {
            this.zza.zzau().zzk().zzb("EES edited event", paramzzas.zza);
            zzz(zzkp.zzx(((zzc)localObject6).zze().zzc()), paramzzp);
          }
          else
          {
            zzz(paramzzas, paramzzp);
          }
          if (((zzc)localObject6).zzd())
          {
            paramzzas = ((zzc)localObject6).zze().zzf().iterator();
            while (paramzzas.hasNext())
            {
              localObject6 = (com.google.android.gms.internal.measurement.zzaa)paramzzas.next();
              this.zza.zzau().zzk().zzb("EES logging created event", ((com.google.android.gms.internal.measurement.zzaa)localObject6).zzb());
              zzz(zzkp.zzx((com.google.android.gms.internal.measurement.zzaa)localObject6), paramzzp);
            }
          }
          return;
        }
      }
      catch (zzd localzzd)
      {
        this.zza.zzau().zzb().zzc("EES error. appId, eventName", paramzzp.zzb, paramzzas.zza);
        this.zza.zzau().zzk().zzb("EES was not applied to event", paramzzas.zza);
        zzz(paramzzas, paramzzp);
        return;
      }
    }
    this.zza.zzau().zzk().zzb("EES not loaded for", paramzzp.zza);
    zzz(paramzzas, paramzzp);
  }
  
  @VisibleForTesting
  final zzas zzc(zzas paramzzas, zzp paramzzp)
  {
    if ("_cmp".equals(paramzzas.zza))
    {
      paramzzp = paramzzas.zzb;
      if ((paramzzp != null) && (paramzzp.zze() != 0))
      {
        paramzzp = paramzzas.zzb.zzd("_cis");
        if (("referrer broadcast".equals(paramzzp)) || ("referrer API".equals(paramzzp)))
        {
          this.zza.zzau().zzi().zzb("Event has been filtered ", paramzzas.toString());
          return new zzas("_cmpx", paramzzas.zzb, paramzzas.zzc, paramzzas.zzd);
        }
      }
    }
    return paramzzas;
  }
  
  @BinderThread
  public final void zzd(zzas paramzzas, zzp paramzzp)
  {
    Preconditions.checkNotNull(paramzzas);
    zzA(paramzzp, false);
    zzv(new zzgf(this, paramzzas, paramzzp));
  }
  
  @BinderThread
  public final void zze(zzkq paramzzkq, zzp paramzzp)
  {
    Preconditions.checkNotNull(paramzzkq);
    zzA(paramzzp, false);
    zzv(new zzgi(this, paramzzkq, paramzzp));
  }
  
  @BinderThread
  public final void zzf(zzp paramzzp)
  {
    zzA(paramzzp, false);
    zzv(new zzgk(this, paramzzp));
  }
  
  @BinderThread
  public final void zzg(zzas paramzzas, String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramzzas);
    Preconditions.checkNotEmpty(paramString1);
    zzB(paramString1, true);
    zzv(new zzgg(this, paramzzas, paramString1));
  }
  
  @BinderThread
  public final void zzh(zzp paramzzp)
  {
    zzA(paramzzp, false);
    zzv(new zzgd(this, paramzzp));
  }
  
  @BinderThread
  public final List<zzkq> zzi(zzp paramzzp, boolean paramBoolean)
  {
    zzA(paramzzp, false);
    Object localObject1 = paramzzp.zza;
    Preconditions.checkNotNull(localObject1);
    localObject1 = this.zza.zzav().zze(new zzgj(this, (String)localObject1));
    try
    {
      Object localObject2 = (List)((Future)localObject1).get();
      localObject1 = new java/util/ArrayList;
      ((ArrayList)localObject1).<init>(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        zzks localzzks = (zzks)((Iterator)localObject2).next();
        if ((paramBoolean) || (!zzku.zzR(localzzks.zzc)))
        {
          zzkq localzzkq = new com/google/android/gms/measurement/internal/zzkq;
          localzzkq.<init>(localzzks);
          ((List)localObject1).add(localzzkq);
        }
      }
      return (List<zzkq>)localObject1;
    }
    catch (ExecutionException localExecutionException) {}catch (InterruptedException localInterruptedException) {}
    this.zza.zzau().zzb().zzc("Failed to get user properties. appId", zzem.zzl(paramzzp.zza), localInterruptedException);
    return null;
  }
  
  @BinderThread
  public final byte[] zzj(zzas paramzzas, String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzas);
    zzB(paramString, true);
    this.zza.zzau().zzj().zzb("Log and bundle. event", this.zza.zzo().zzc(paramzzas.zza));
    long l1 = this.zza.zzay().nanoTime() / 1000000L;
    Object localObject = this.zza.zzav().zzf(new zzgh(this, paramzzas, paramString));
    try
    {
      byte[] arrayOfByte = (byte[])((Future)localObject).get();
      localObject = arrayOfByte;
      if (arrayOfByte == null)
      {
        this.zza.zzau().zzb().zzb("Log and bundle returned null. appId", zzem.zzl(paramString));
        localObject = new byte[0];
      }
      long l2 = this.zza.zzay().nanoTime();
      this.zza.zzau().zzj().zzd("Log and bundle processed. event, size, time_ms", this.zza.zzo().zzc(paramzzas.zza), Integer.valueOf(localObject.length), Long.valueOf(l2 / 1000000L - l1));
      return (byte[])localObject;
    }
    catch (ExecutionException localExecutionException) {}catch (InterruptedException localInterruptedException) {}
    this.zza.zzau().zzb().zzd("Failed to log and bundle. appId, event, error", zzem.zzl(paramString), this.zza.zzo().zzc(paramzzas.zza), localInterruptedException);
    return null;
  }
  
  @BinderThread
  public final void zzk(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    zzv(new zzgl(this, paramString2, paramString3, paramString1, paramLong));
  }
  
  @BinderThread
  public final String zzl(zzp paramzzp)
  {
    zzA(paramzzp, false);
    return this.zza.zzU(paramzzp);
  }
  
  @BinderThread
  public final void zzm(zzaa paramzzaa, zzp paramzzp)
  {
    Preconditions.checkNotNull(paramzzaa);
    Preconditions.checkNotNull(paramzzaa.zzc);
    zzA(paramzzp, false);
    paramzzaa = new zzaa(paramzzaa);
    paramzzaa.zza = paramzzp.zza;
    zzv(new zzfw(this, paramzzaa, paramzzp));
  }
  
  @BinderThread
  public final void zzn(zzaa paramzzaa)
  {
    Preconditions.checkNotNull(paramzzaa);
    Preconditions.checkNotNull(paramzzaa.zzc);
    Preconditions.checkNotEmpty(paramzzaa.zza);
    zzB(paramzzaa.zza, true);
    zzv(new zzfx(this, new zzaa(paramzzaa)));
  }
  
  @BinderThread
  public final List<zzkq> zzo(String paramString1, String paramString2, boolean paramBoolean, zzp paramzzp)
  {
    zzA(paramzzp, false);
    Object localObject = paramzzp.zza;
    Preconditions.checkNotNull(localObject);
    paramString1 = this.zza.zzav().zze(new zzfy(this, (String)localObject, paramString1, paramString2));
    try
    {
      paramString2 = (List)paramString1.get();
      paramString1 = new java/util/ArrayList;
      paramString1.<init>(paramString2.size());
      localObject = paramString2.iterator();
      while (((Iterator)localObject).hasNext())
      {
        zzks localzzks = (zzks)((Iterator)localObject).next();
        if ((paramBoolean) || (!zzku.zzR(localzzks.zzc)))
        {
          paramString2 = new com/google/android/gms/measurement/internal/zzkq;
          paramString2.<init>(localzzks);
          paramString1.add(paramString2);
        }
      }
      return paramString1;
    }
    catch (ExecutionException paramString1) {}catch (InterruptedException paramString1) {}
    this.zza.zzau().zzb().zzc("Failed to query user properties. appId", zzem.zzl(paramzzp.zza), paramString1);
    return Collections.emptyList();
  }
  
  @BinderThread
  public final List<zzkq> zzp(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    zzB(paramString1, true);
    paramString2 = this.zza.zzav().zze(new zzfz(this, paramString1, paramString2, paramString3));
    try
    {
      paramString3 = (List)paramString2.get();
      paramString2 = new java/util/ArrayList;
      paramString2.<init>(paramString3.size());
      Iterator localIterator = paramString3.iterator();
      while (localIterator.hasNext())
      {
        zzks localzzks = (zzks)localIterator.next();
        if ((paramBoolean) || (!zzku.zzR(localzzks.zzc)))
        {
          paramString3 = new com/google/android/gms/measurement/internal/zzkq;
          paramString3.<init>(localzzks);
          paramString2.add(paramString3);
        }
      }
      return paramString2;
    }
    catch (ExecutionException paramString2) {}catch (InterruptedException paramString2) {}
    this.zza.zzau().zzb().zzc("Failed to get user properties as. appId", zzem.zzl(paramString1), paramString2);
    return Collections.emptyList();
  }
  
  @BinderThread
  public final List<zzaa> zzq(String paramString1, String paramString2, zzp paramzzp)
  {
    zzA(paramzzp, false);
    paramzzp = paramzzp.zza;
    Preconditions.checkNotNull(paramzzp);
    paramString1 = this.zza.zzav().zze(new zzga(this, paramzzp, paramString1, paramString2));
    try
    {
      paramString1 = (List)paramString1.get();
      return paramString1;
    }
    catch (ExecutionException paramString1) {}catch (InterruptedException paramString1) {}
    this.zza.zzau().zzb().zzb("Failed to get conditional user properties", paramString1);
    return Collections.emptyList();
  }
  
  @BinderThread
  public final List<zzaa> zzr(String paramString1, String paramString2, String paramString3)
  {
    zzB(paramString1, true);
    paramString1 = this.zza.zzav().zze(new zzgb(this, paramString1, paramString2, paramString3));
    try
    {
      paramString1 = (List)paramString1.get();
      return paramString1;
    }
    catch (ExecutionException paramString1) {}catch (InterruptedException paramString1) {}
    this.zza.zzau().zzb().zzb("Failed to get conditional user properties as", paramString1);
    return Collections.emptyList();
  }
  
  @BinderThread
  public final void zzs(zzp paramzzp)
  {
    Preconditions.checkNotEmpty(paramzzp.zza);
    zzB(paramzzp.zza, false);
    zzv(new zzgc(this, paramzzp));
  }
  
  @BinderThread
  public final void zzt(Bundle paramBundle, zzp paramzzp)
  {
    zzA(paramzzp, false);
    paramzzp = paramzzp.zza;
    Preconditions.checkNotNull(paramzzp);
    zzv(new zzfv(this, paramzzp, paramBundle));
  }
  
  @BinderThread
  public final void zzu(zzp paramzzp)
  {
    Preconditions.checkNotEmpty(paramzzp.zza);
    Preconditions.checkNotNull(paramzzp.zzv);
    paramzzp = new zzge(this, paramzzp);
    Preconditions.checkNotNull(paramzzp);
    if (this.zza.zzav().zzd())
    {
      paramzzp.run();
      return;
    }
    this.zza.zzav().zzj(paramzzp);
  }
  
  @VisibleForTesting
  final void zzv(Runnable paramRunnable)
  {
    Preconditions.checkNotNull(paramRunnable);
    if (this.zza.zzav().zzd())
    {
      paramRunnable.run();
      return;
    }
    this.zza.zzav().zzh(paramRunnable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */