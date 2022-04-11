package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.util.Clock;

abstract class zzdt
  implements Runnable
{
  final long zzh;
  final long zzi;
  final boolean zzj;
  
  zzdt(zzee paramzzee, boolean paramBoolean)
  {
    this.zzh = paramzzee.zza.currentTimeMillis();
    this.zzi = paramzzee.zza.elapsedRealtime();
    this.zzj = paramBoolean;
  }
  
  public final void run()
  {
    if (zzee.zzK(this.zzk))
    {
      zzb();
      return;
    }
    try
    {
      zza();
      return;
    }
    catch (Exception localException)
    {
      zzee.zzL(this.zzk, localException, false, this.zzj);
      zzb();
    }
  }
  
  abstract void zza()
    throws RemoteException;
  
  protected void zzb() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzdt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */