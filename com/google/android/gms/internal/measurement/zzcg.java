package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzcg
  extends zzbm
  implements zzci
{
  zzcg(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
  }
  
  public final void zzd(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzbo.zzd(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    zzc(1, localParcel);
  }
  
  public final int zze()
    throws RemoteException
  {
    Parcel localParcel = zzC(2, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */