package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;

public final class zzo
  extends zzb
  implements zzl
{
  zzo(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
  }
  
  public final Barcode[] zza(IObjectWrapper paramIObjectWrapper, zzu paramzzu)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzd.zza(localParcel, paramIObjectWrapper);
    zzd.zza(localParcel, paramzzu);
    paramIObjectWrapper = zza(1, localParcel);
    paramzzu = (Barcode[])paramIObjectWrapper.createTypedArray(Barcode.CREATOR);
    paramIObjectWrapper.recycle();
    return paramzzu;
  }
  
  public final Barcode[] zzb(IObjectWrapper paramIObjectWrapper, zzu paramzzu)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzd.zza(localParcel, paramIObjectWrapper);
    zzd.zza(localParcel, paramzzu);
    paramzzu = zza(2, localParcel);
    paramIObjectWrapper = (Barcode[])paramzzu.createTypedArray(Barcode.CREATOR);
    paramzzu.recycle();
    return paramIObjectWrapper;
  }
  
  public final void zzn()
    throws RemoteException
  {
    zzb(3, obtainAndWriteInterfaceToken());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */