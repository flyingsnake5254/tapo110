package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzae
  extends zzb
  implements zzaf
{
  zzae(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
  }
  
  public final zzad zza(IObjectWrapper paramIObjectWrapper, zzam paramzzam)
    throws RemoteException
  {
    Object localObject = obtainAndWriteInterfaceToken();
    zzd.zza((Parcel)localObject, paramIObjectWrapper);
    zzd.zza((Parcel)localObject, paramzzam);
    paramzzam = zza(1, (Parcel)localObject);
    paramIObjectWrapper = paramzzam.readStrongBinder();
    if (paramIObjectWrapper == null)
    {
      paramIObjectWrapper = null;
    }
    else
    {
      localObject = paramIObjectWrapper.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
      if ((localObject instanceof zzad)) {
        paramIObjectWrapper = (zzad)localObject;
      } else {
        paramIObjectWrapper = new zzac(paramIObjectWrapper);
      }
    }
    paramzzam.recycle();
    return paramIObjectWrapper;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */