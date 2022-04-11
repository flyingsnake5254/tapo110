package com.google.mlkit.vision.barcode.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.mlkit_vision_barcode.zzb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzd;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;

public final class k
  extends zzb
  implements a
{
  k(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.mlkit.vision.barcode.internal.IBarcodeScanner");
  }
  
  public final IObjectWrapper a(IObjectWrapper paramIObjectWrapper, VisionImageMetadataParcel paramVisionImageMetadataParcel)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzd.zza(localParcel, paramIObjectWrapper);
    zzd.zza(localParcel, paramVisionImageMetadataParcel);
    paramVisionImageMetadataParcel = zza(2, localParcel);
    paramIObjectWrapper = IObjectWrapper.Stub.asInterface(paramVisionImageMetadataParcel.readStrongBinder());
    paramVisionImageMetadataParcel.recycle();
    return paramIObjectWrapper;
  }
  
  public final void a_()
    throws RemoteException
  {
    zzb(1, zza());
  }
  
  public final void zzb()
    throws RemoteException
  {
    zzb(3, zza());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\internal\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */