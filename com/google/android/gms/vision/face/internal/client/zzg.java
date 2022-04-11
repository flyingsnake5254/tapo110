package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.vision.zza;
import com.google.android.gms.internal.vision.zzd;
import com.google.android.gms.internal.vision.zzu;

public abstract class zzg
  extends zza
  implements zzh
{
  public zzg()
  {
    super("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4) {
            return false;
          }
          paramParcel1 = zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), (zzu)zzd.zza(paramParcel1, zzu.CREATOR));
          paramParcel2.writeNoException();
          paramParcel2.writeTypedArray(paramParcel1, 1);
        }
        else
        {
          zzn();
          paramParcel2.writeNoException();
        }
      }
      else
      {
        boolean bool = zzd(paramParcel1.readInt());
        paramParcel2.writeNoException();
        zzd.writeBoolean(paramParcel2, bool);
      }
    }
    else
    {
      paramParcel1 = zzc(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (zzu)zzd.zza(paramParcel1, zzu.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedArray(paramParcel1, 1);
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\internal\client\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */