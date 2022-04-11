package com.google.android.gms.internal.clearcut;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zze;

public final class zzo
  extends zza
  implements zzn
{
  zzo(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
  }
  
  public final void zza(zzl paramzzl, zze paramzze)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzl);
    zzc.zza(localParcel, paramzze);
    transactOneway(1, localParcel);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */