package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdb
  extends zzdt
{
  zzdb(zzee paramzzee, zzbz paramzzbz)
  {
    super(paramzzee, true);
  }
  
  final void zza()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zzb))).getCachedAppInstanceId(this.zza);
  }
  
  protected final void zzb()
  {
    this.zza.zzb(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */