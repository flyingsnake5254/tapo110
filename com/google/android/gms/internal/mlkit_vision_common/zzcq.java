package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzcq
{
  public static final Component<?> zza = Component.builder(zzcq.class).add(Dependency.required(Context.class)).add(Dependency.required(m.class)).add(Dependency.required(zza.class)).factory(zzcu.zza).build();
  @Nullable
  private static List<String> zzb;
  private static boolean zzk = true;
  private static boolean zzl = true;
  private final String zzc;
  private final String zzd;
  private final zza zze;
  private final m zzf;
  private final Task<String> zzg;
  private final Task<String> zzh;
  private final Map<zzag, Long> zzi = new HashMap();
  private final Map<zzag, Object> zzj = new HashMap();
  
  private zzcq(Context paramContext, m paramm, zza paramzza)
  {
    this.zzc = paramContext.getPackageName();
    this.zzd = c.a(paramContext);
    this.zzf = paramm;
    this.zze = paramzza;
    this.zzg = h.a().b(zzct.zza);
    paramContext = h.a();
    paramm.getClass();
    this.zzh = paramContext.b(zzcs.zza(paramm));
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
  
  @WorkerThread
  public final void zza(@NonNull zzb paramzzb, @NonNull zzag paramzzag)
  {
    long l = SystemClock.elapsedRealtime();
    Object localObject = this.zzi.get(paramzzag);
    int i = 1;
    if ((localObject != null) && (l - ((Long)this.zzi.get(paramzzag)).longValue() <= TimeUnit.SECONDS.toMillis(30L))) {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    this.zzi.put(paramzzag, Long.valueOf(l));
    paramzzb = paramzzb.zza();
    h.d().execute(new zzcv(this, paramzzb, paramzzag));
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zzr.zzad paramzzad);
  }
  
  public static abstract interface zzb
  {
    public abstract zzr.zzad.zza zza();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzcq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */