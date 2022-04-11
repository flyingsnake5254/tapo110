package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzbt;

public final class zzkc
  extends zzke
{
  private final AlarmManager zza = (AlarmManager)this.zzs.zzax().getSystemService("alarm");
  private zzal zzb;
  private Integer zzc;
  
  protected zzkc(zzkn paramzzkn)
  {
    super(paramzzkn);
  }
  
  private final zzal zzf()
  {
    if (this.zzb == null) {
      this.zzb = new zzkb(this, this.zzf.zzN());
    }
    return this.zzb;
  }
  
  @TargetApi(24)
  private final void zzh()
  {
    JobScheduler localJobScheduler = (JobScheduler)this.zzs.zzax().getSystemService("jobscheduler");
    if (localJobScheduler != null) {
      localJobScheduler.cancel(zzi());
    }
  }
  
  private final int zzi()
  {
    if (this.zzc == null)
    {
      String str = String.valueOf(this.zzs.zzax().getPackageName());
      if (str.length() != 0) {
        str = "measurement".concat(str);
      } else {
        str = new String("measurement");
      }
      this.zzc = Integer.valueOf(str.hashCode());
    }
    return this.zzc.intValue();
  }
  
  private final PendingIntent zzj()
  {
    Context localContext = this.zzs.zzax();
    return zzbs.zza(localContext, 0, new Intent().setClassName(localContext, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), zzbs.zza);
  }
  
  protected final boolean zzaA()
  {
    AlarmManager localAlarmManager = this.zza;
    if (localAlarmManager != null) {
      localAlarmManager.cancel(zzj());
    }
    if (Build.VERSION.SDK_INT >= 24) {
      zzh();
    }
    return false;
  }
  
  public final void zzc(long paramLong)
  {
    zzZ();
    this.zzs.zzat();
    Object localObject = this.zzs.zzax();
    if (!zzku.zzam((Context)localObject)) {
      this.zzs.zzau().zzj().zza("Receiver not registered/enabled");
    }
    if (!zzku.zzP((Context)localObject, false)) {
      this.zzs.zzau().zzj().zza("Service not registered/enabled");
    }
    zzd();
    this.zzs.zzau().zzk().zzb("Scheduling upload, millis", Long.valueOf(paramLong));
    long l = this.zzs.zzay().elapsedRealtime();
    this.zzs.zzc();
    if ((paramLong < Math.max(0L, ((Long)zzea.zzw.zzb(null)).longValue())) && (!zzf().zzc())) {
      zzf().zzb(paramLong);
    }
    this.zzs.zzat();
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = this.zzs.zzax();
      ComponentName localComponentName = new ComponentName((Context)localObject, "com.google.android.gms.measurement.AppMeasurementJobService");
      int i = zzi();
      PersistableBundle localPersistableBundle = new PersistableBundle();
      localPersistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
      zzbt.zza((Context)localObject, new JobInfo.Builder(i, localComponentName).setMinimumLatency(paramLong).setOverrideDeadline(paramLong + paramLong).setExtras(localPersistableBundle).build(), "com.google.android.gms", "UploadAlarm");
      return;
    }
    localObject = this.zza;
    if (localObject != null)
    {
      this.zzs.zzc();
      ((AlarmManager)localObject).setInexactRepeating(2, l + paramLong, Math.max(((Long)zzea.zzr.zzb(null)).longValue(), paramLong), zzj());
    }
  }
  
  public final void zzd()
  {
    zzZ();
    this.zzs.zzau().zzk().zza("Unscheduling upload");
    AlarmManager localAlarmManager = this.zza;
    if (localAlarmManager != null) {
      localAlarmManager.cancel(zzj());
    }
    zzf().zzd();
    if (Build.VERSION.SDK_INT >= 24) {
      zzh();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzkc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */