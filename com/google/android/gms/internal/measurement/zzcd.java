package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzcd
  extends zzbm
  implements zzcf
{
  zzcd(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
  }
  
  public final void zzb(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzbo.zzd(localParcel, paramBundle);
    zzc(1, localParcel);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzcd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */