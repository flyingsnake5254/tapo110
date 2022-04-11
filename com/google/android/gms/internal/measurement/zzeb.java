package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzeb
  extends zzdt
{
  zzeb(zzed paramzzed, Activity paramActivity, zzbz paramzzbz)
  {
    super(paramzzed.zza, true);
  }
  
  final void zza()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zzc.zza))).onActivitySaveInstanceState(ObjectWrapper.wrap(this.zza), this.zzb, this.zzi);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */