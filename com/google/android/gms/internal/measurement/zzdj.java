package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdj
  extends zzdt
{
  zzdj(zzee paramzzee, String paramString, zzbz paramzzbz)
  {
    super(paramzzee, true);
  }
  
  final void zza()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zzc))).getMaxUserProperties(this.zza, this.zzb);
  }
  
  protected final void zzb()
  {
    this.zzb.zzb(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */