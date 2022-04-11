package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzff
{
  private final zzff.zza zza;
  
  public zzff(zzff.zza paramzza)
  {
    Preconditions.checkNotNull(paramzza);
    this.zza = paramzza;
  }
  
  @MainThread
  public final void zza(Context paramContext, Intent paramIntent)
  {
    zzfu localzzfu = zzfu.zzC(paramContext, null, null);
    zzem localzzem = localzzfu.zzau();
    if (paramIntent == null)
    {
      localzzem.zze().zza("Receiver called with null intent");
      return;
    }
    localzzfu.zzat();
    paramIntent = paramIntent.getAction();
    localzzem.zzk().zzb("Local receiver got", paramIntent);
    if ("com.google.android.gms.measurement.UPLOAD".equals(paramIntent))
    {
      paramIntent = new Intent().setClassName(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
      paramIntent.setAction("com.google.android.gms.measurement.UPLOAD");
      localzzem.zzk().zza("Starting wakeful intent.");
      this.zza.doStartService(paramContext, paramIntent);
      return;
    }
    if ("com.android.vending.INSTALL_REFERRER".equals(paramIntent)) {
      localzzem.zze().zza("Install Referrer Broadcasts are deprecated");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */