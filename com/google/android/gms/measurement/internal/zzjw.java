package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;

final class zzjw
  extends zzal
{
  zzjw(zzjx paramzzjx, zzgp paramzzgp)
  {
    super(paramzzgp);
  }
  
  @WorkerThread
  public final void zza()
  {
    zzjx localzzjx = this.zza;
    localzzjx.zzc.zzg();
    localzzjx.zzd(false, false, localzzjx.zzc.zzs.zzay().elapsedRealtime());
    localzzjx.zzc.zzs.zzB().zzc(localzzjx.zzc.zzs.zzay().elapsedRealtime());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzjw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */