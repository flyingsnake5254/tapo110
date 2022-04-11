package com.google.mlkit.vision.barcode.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.mlkit_vision_barcode.zza;
import com.google.android.gms.internal.mlkit_vision_barcode.zzd;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;

public abstract interface a
  extends IInterface
{
  public abstract IObjectWrapper a(IObjectWrapper paramIObjectWrapper, VisionImageMetadataParcel paramVisionImageMetadataParcel)
    throws RemoteException;
  
  public abstract void a_()
    throws RemoteException;
  
  public abstract void zzb()
    throws RemoteException;
  
  public static abstract class a
    extends zza
    implements a
  {
    public a()
    {
      super();
    }
    
    protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3) {
            return false;
          }
          zzb();
          paramParcel2.writeNoException();
        }
        else
        {
          paramParcel1 = a(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (VisionImageMetadataParcel)zzd.zza(paramParcel1, VisionImageMetadataParcel.CREATOR));
          paramParcel2.writeNoException();
          zzd.zza(paramParcel2, paramParcel1);
        }
      }
      else
      {
        a_();
        paramParcel2.writeNoException();
      }
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\internal\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */