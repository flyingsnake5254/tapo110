package com.google.mlkit.vision.barcode.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.mlkit_vision_barcode.zzb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzd;

public final class n
  extends zzb
  implements m
{
  n(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.mlkit.vision.barcode.internal.IBarcodeScannerCreator");
  }
  
  public final a newBarcodeScanner(BarcodeScannerOptionsParcel paramBarcodeScannerOptionsParcel)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzd.zza(localParcel, paramBarcodeScannerOptionsParcel);
    localParcel = zza(1, localParcel);
    paramBarcodeScannerOptionsParcel = localParcel.readStrongBinder();
    if (paramBarcodeScannerOptionsParcel == null)
    {
      paramBarcodeScannerOptionsParcel = null;
    }
    else
    {
      IInterface localIInterface = paramBarcodeScannerOptionsParcel.queryLocalInterface("com.google.mlkit.vision.barcode.internal.IBarcodeScanner");
      if ((localIInterface instanceof a)) {
        paramBarcodeScannerOptionsParcel = (a)localIInterface;
      } else {
        paramBarcodeScannerOptionsParcel = new k(paramBarcodeScannerOptionsParcel);
      }
    }
    localParcel.recycle();
    return paramBarcodeScannerOptionsParcel;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\internal\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */