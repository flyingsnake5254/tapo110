package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzp
  extends zzb
  implements zzn
{
  zzp(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
  }
  
  public final zzl zza(IObjectWrapper paramIObjectWrapper, zzk paramzzk)
    throws RemoteException
  {
    Object localObject = obtainAndWriteInterfaceToken();
    zzd.zza((Parcel)localObject, paramIObjectWrapper);
    zzd.zza((Parcel)localObject, paramzzk);
    paramzzk = zza(1, (Parcel)localObject);
    paramIObjectWrapper = paramzzk.readStrongBinder();
    if (paramIObjectWrapper == null)
    {
      paramIObjectWrapper = null;
    }
    else
    {
      localObject = paramIObjectWrapper.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
      if ((localObject instanceof zzl)) {
        paramIObjectWrapper = (zzl)localObject;
      } else {
        paramIObjectWrapper = new zzo(paramIObjectWrapper);
      }
    }
    paramzzk.recycle();
    return paramIObjectWrapper;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */