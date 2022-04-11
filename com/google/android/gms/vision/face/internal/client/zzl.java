package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.vision.zza;
import com.google.android.gms.internal.vision.zzd;

public abstract class zzl
  extends zza
  implements zzi
{
  public zzl()
  {
    super("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
  }
  
  public static zzi asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
    if ((localIInterface instanceof zzi)) {
      return (zzi)localIInterface;
    }
    return new zzk(paramIBinder);
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      paramParcel1 = newFaceDetector(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (zzf)zzd.zza(paramParcel1, zzf.CREATOR));
      paramParcel2.writeNoException();
      zzd.zza(paramParcel2, paramParcel1);
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\internal\client\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */