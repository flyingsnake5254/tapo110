package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdf
  extends zzdt
{
  zzdf(zzee paramzzee, String paramString1, String paramString2, boolean paramBoolean, zzbz paramzzbz)
  {
    super(paramzzee, true);
  }
  
  final void zza()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zze))).getUserProperties(this.zza, this.zzb, this.zzc, this.zzd);
  }
  
  protected final void zzb()
  {
    this.zzd.zzb(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */