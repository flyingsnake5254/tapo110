package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzcu
  extends zzdt
{
  zzcu(zzee paramzzee, Bundle paramBundle)
  {
    super(paramzzee, true);
  }
  
  final void zza()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zzb))).setConsentThirdParty(this.zza, this.zzh);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */