package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzdx
  extends zzdt
{
  zzdx(zzed paramzzed, Activity paramActivity)
  {
    super(paramzzed.zza, true);
  }
  
  final void zza()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zzb.zza))).onActivityStarted(ObjectWrapper.wrap(this.zza), this.zzi);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzdx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */