package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzd;

public final class zzk
  extends zzb
  implements zzi
{
  zzk(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
  }
  
  public final zzh newFaceDetector(IObjectWrapper paramIObjectWrapper, zzf paramzzf)
    throws RemoteException
  {
    Object localObject = obtainAndWriteInterfaceToken();
    zzd.zza((Parcel)localObject, paramIObjectWrapper);
    zzd.zza((Parcel)localObject, paramzzf);
    paramzzf = zza(1, (Parcel)localObject);
    localObject = paramzzf.readStrongBinder();
    if (localObject == null)
    {
      paramIObjectWrapper = null;
    }
    else
    {
      paramIObjectWrapper = ((IBinder)localObject).queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
      if ((paramIObjectWrapper instanceof zzh)) {
        paramIObjectWrapper = (zzh)paramIObjectWrapper;
      } else {
        paramIObjectWrapper = new zzj((IBinder)localObject);
      }
    }
    paramzzf.recycle();
    return paramIObjectWrapper;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\internal\client\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */