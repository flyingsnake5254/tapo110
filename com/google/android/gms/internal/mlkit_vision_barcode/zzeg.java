package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.tasks.Task;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.c;
import com.google.mlkit.common.sdkinternal.h;
import com.google.mlkit.common.sdkinternal.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzeg
{
  public static final Component<?> zza = Component.builder(zzeg.class).add(Dependency.required(Context.class)).add(Dependency.required(m.class)).add(Dependency.required(zzc.class)).factory(zzek.zza).build();
  @Nullable
  private static List<String> zzb;
  private static boolean zzk = true;
  private static boolean zzl = true;
  private final String zzc;
  private final String zzd;
  private final zzc zze;
  private final m zzf;
  private final Task<String> zzg;
  private final Task<String> zzh;
  private final Map<zzbw, Long> zzi = new HashMap();
  private final Map<zzbw, zzat<Object, Long>> zzj = new HashMap();
  
  private zzeg(Context paramContext, m paramm, zzc paramzzc)
  {
    this.zzc = paramContext.getPackageName();
    this.zzd = c.a(paramContext);
    this.zzf = paramm;
    this.zze = paramzzc;
    this.zzg = h.a().b(zzej.zza);
    paramContext = h.a();
    paramm.getClass();
    this.zzh = paramContext.b(zzei.zza(paramm));
  }
  
  @VisibleForTesting
  private static long zza(List<Long> paramList, double paramDouble)
  {
    return ((Long)paramList.get(Math.max((int)Math.ceil(paramDouble / 100.0D * paramList.size()) - 1, 0))).longValue();
  }
  
  @WorkerThread
  private final boolean zza(@NonNull zzbw paramzzbw, long paramLong1, long paramLong2)
  {
    if (this.zzi.get(paramzzbw) == null) {
      return true;
    }
    return paramLong1 - ((Long)this.zzi.get(paramzzbw)).longValue() > TimeUnit.SECONDS.toMillis(30L);
  }
  
  @NonNull
  private static List<String> zzb()
  {
    try
    {
      Object localObject1 = zzb;
      if (localObject1 != null) {
        return (List<String>)localObject1;
      }
      localObject1 = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
      Object localObject3 = new java/util/ArrayList;
      ((ArrayList)localObject3).<init>(((LocaleListCompat)localObject1).size());
      zzb = (List)localObject3;
      for (int i = 0; i < ((LocaleListCompat)localObject1).size(); i++)
      {
        localObject3 = ((LocaleListCompat)localObject1).get(i);
        zzb.add(c.b((Locale)localObject3));
      }
      localObject1 = zzb;
      return (List<String>)localObject1;
    }
    finally {}
  }
  
  public final void zza(@NonNull zzbl.zzad.zza paramzza, @NonNull zzbw paramzzbw)
  {
    h.d().execute(new zzel(this, paramzza, paramzzbw));
  }
  
  @WorkerThread
  public final void zza(@NonNull zza paramzza, @NonNull zzbw paramzzbw)
  {
    long l = SystemClock.elapsedRealtime();
    if (!zza(paramzzbw, l, 30L)) {
      return;
    }
    this.zzi.put(paramzzbw, Long.valueOf(l));
    zza(paramzza.zza(), paramzzbw);
  }
  
  @WorkerThread
  public final <K> void zza(@NonNull K paramK, long paramLong, @NonNull zzbw paramzzbw, @NonNull zzb<K> paramzzb)
  {
    if (!zzk) {
      return;
    }
    if (!this.zzj.containsKey(paramzzbw)) {
      this.zzj.put(paramzzbw, zzw.zzf());
    }
    zzat localzzat = (zzat)this.zzj.get(paramzzbw);
    localzzat.zza(paramK, Long.valueOf(paramLong));
    paramLong = SystemClock.elapsedRealtime();
    if (!zza(paramzzbw, paramLong, 30L)) {
      return;
    }
    this.zzi.put(paramzzbw, Long.valueOf(paramLong));
    paramK = localzzat.zzh().iterator();
    while (paramK.hasNext())
    {
      Object localObject1 = paramK.next();
      Object localObject2 = localzzat.zza(localObject1);
      Collections.sort((List)localObject2);
      zzbl.zzab.zza localzza = zzbl.zzab.zza();
      paramLong = 0L;
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext()) {
        paramLong += ((Long)localIterator.next()).longValue();
      }
      localObject2 = (zzbl.zzab)localzza.zzc(paramLong / ((List)localObject2).size()).zza(zza((List)localObject2, 100.0D)).zzf(zza((List)localObject2, 75.0D)).zze(zza((List)localObject2, 50.0D)).zzd(zza((List)localObject2, 25.0D)).zzb(zza((List)localObject2, 0.0D)).zzg();
      zza(paramzzb.zza(localObject1, localzzat.zza(localObject1).size(), (zzbl.zzab)localObject2), paramzzbw);
    }
    this.zzj.remove(paramzzbw);
  }
  
  public static abstract interface zza
  {
    public abstract zzbl.zzad.zza zza();
  }
  
  public static abstract interface zzb<K>
  {
    public abstract zzbl.zzad.zza zza(K paramK, int paramInt, zzbl.zzab paramzzab);
  }
  
  public static abstract interface zzc
  {
    public abstract void zza(zzbl.zzad paramzzad);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */