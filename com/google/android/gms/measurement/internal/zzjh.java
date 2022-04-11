package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

final class zzjh
  implements Runnable
{
  zzjh(zzjj paramzzjj) {}
  
  public final void run()
  {
    zzjk localzzjk = this.zza.zza;
    Context localContext = localzzjk.zzs.zzax();
    this.zza.zza.zzs.zzat();
    zzjk.zzJ(localzzjk, new ComponentName(localContext, "com.google.android.gms.measurement.AppMeasurementService"));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzjh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */