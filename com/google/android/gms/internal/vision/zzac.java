package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzac
  extends zzb
  implements zzad
{
  zzac(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
  }
  
  public final zzah[] zza(IObjectWrapper paramIObjectWrapper, zzu paramzzu, zzaj paramzzaj)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzd.zza(localParcel, paramIObjectWrapper);
    zzd.zza(localParcel, paramzzu);
    zzd.zza(localParcel, paramzzaj);
    paramzzu = zza(3, localParcel);
    paramIObjectWrapper = (zzah[])paramzzu.createTypedArray(zzah.CREATOR);
    paramzzu.recycle();
    return paramIObjectWrapper;
  }
  
  public final void zzr()
    throws RemoteException
  {
    zzb(2, obtainAndWriteInterfaceToken());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */