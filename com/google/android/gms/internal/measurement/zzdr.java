package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdr
  extends zzdt
{
  zzdr(zzee paramzzee, Long paramLong, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramzzee, true);
  }
  
  final void zza()
    throws RemoteException
  {
    Long localLong = this.zza;
    long l;
    if (localLong == null) {
      l = this.zzh;
    } else {
      l = localLong.longValue();
    }
    ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zzg))).logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, l);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */