package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzco
  extends zzdt
{
  zzco(zzee paramzzee, String paramString1, String paramString2, Bundle paramBundle)
  {
    super(paramzzee, true);
  }
  
  final void zza()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zzd))).clearConditionalUserProperty(this.zza, this.zzb, this.zzc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */