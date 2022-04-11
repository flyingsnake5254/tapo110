package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PersistableBundle;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzjq<T extends Context,  extends zzjp>
{
  private final T zza;
  
  public zzjq(T paramT)
  {
    Preconditions.checkNotNull(paramT);
    this.zza = paramT;
  }
  
  private final zzem zzk()
  {
    return zzfu.zzC(this.zza, null, null).zzau();
  }
  
  @MainThread
  public final void zza()
  {
    zzfu localzzfu = zzfu.zzC(this.zza, null, null);
    zzem localzzem = localzzfu.zzau();
    localzzfu.zzat();
    localzzem.zzk().zza("Local AppMeasurementService is starting up");
  }
  
  @MainThread
  public final void zzb()
  {
    zzfu localzzfu = zzfu.zzC(this.zza, null, null);
    zzem localzzem = localzzfu.zzau();
    localzzfu.zzat();
    localzzem.zzk().zza("Local AppMeasurementService is shutting down");
  }
  
  @MainThread
  public final int zzc(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzfu localzzfu = zzfu.zzC(this.zza, null, null);
    zzem localzzem = localzzfu.zzau();
    if (paramIntent == null)
    {
      localzzem.zze().zza("AppMeasurementService started with null intent");
      return 2;
    }
    String str = paramIntent.getAction();
    localzzfu.zzat();
    localzzem.zzk().zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str)) {
      zzd(new zzjm(this, paramInt2, localzzem, paramIntent));
    }
    return 2;
  }
  
  public final void zzd(Runnable paramRunnable)
  {
    zzkn localzzkn = zzkn.zza(this.zza);
    localzzkn.zzav().zzh(new zzjo(this, localzzkn, paramRunnable));
  }
  
  @MainThread
  public final IBinder zze(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzk().zzb().zza("onBind called with null intent");
      return null;
    }
    paramIntent = paramIntent.getAction();
    if ("com.google.android.gms.measurement.START".equals(paramIntent)) {
      return new zzgm(zzkn.zza(this.zza), null);
    }
    zzk().zze().zzb("onBind received unknown action", paramIntent);
    return null;
  }
  
  @MainThread
  public final boolean zzf(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzk().zzb().zza("onUnbind called with null intent");
      return true;
    }
    paramIntent = paramIntent.getAction();
    zzk().zzk().zzb("onUnbind called for intent. action", paramIntent);
    return true;
  }
  
  @TargetApi(24)
  @MainThread
  public final boolean zzg(JobParameters paramJobParameters)
  {
    zzfu localzzfu = zzfu.zzC(this.zza, null, null);
    zzem localzzem = localzzfu.zzau();
    String str = paramJobParameters.getExtras().getString("action");
    localzzfu.zzat();
    localzzem.zzk().zzb("Local AppMeasurementJobService called. action", str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str)) {
      zzd(new zzjn(this, localzzem, paramJobParameters));
    }
    return true;
  }
  
  @MainThread
  public final void zzh(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzk().zzb().zza("onRebind called with null intent");
      return;
    }
    paramIntent = paramIntent.getAction();
    zzk().zzk().zzb("onRebind called. action", paramIntent);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzjq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */