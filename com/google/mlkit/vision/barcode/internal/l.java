package com.google.mlkit.vision.barcode.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.mlkit_vision_barcode.zza;
import com.google.android.gms.internal.mlkit_vision_barcode.zzd;

public abstract class l
  extends zza
  implements m
{
  public l()
  {
    super("com.google.mlkit.vision.barcode.internal.IBarcodeScannerCreator");
  }
  
  public static m asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.mlkit.vision.barcode.internal.IBarcodeScannerCreator");
    if ((localIInterface instanceof m)) {
      return (m)localIInterface;
    }
    return new n(paramIBinder);
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      paramParcel1 = newBarcodeScanner((BarcodeScannerOptionsParcel)zzd.zza(paramParcel1, BarcodeScannerOptionsParcel.CREATOR));
      paramParcel2.writeNoException();
      zzd.zza(paramParcel2, paramParcel1);
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\internal\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */