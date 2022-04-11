package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdh
  extends zzdt
{
  zzdh(zzee paramzzee, Bundle paramBundle, zzbz paramzzbz)
  {
    super(paramzzee, true);
  }
  
  final void zza()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zzc))).performAction(this.zza, this.zzb, this.zzh);
  }
  
  protected final void zzb()
  {
    this.zzb.zzb(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */