package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdq
  extends zzdt
{
  zzdq(zzee paramzzee, zzdv paramzzdv)
  {
    super(paramzzee, true);
  }
  
  final void zza()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zzb))).unregisterOnMeasurementEventListener(this.zza);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */