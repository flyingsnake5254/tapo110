package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzdg
  extends zzdt
{
  zzdg(zzee paramzzee, boolean paramBoolean, int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    super(paramzzee, false);
  }
  
  final void zza()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zzc))).logHealthData(5, this.zza, ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(null), ObjectWrapper.wrap(null));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzdg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */