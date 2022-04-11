package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbp
  extends zzbm
  implements zzbr
{
  zzbp(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
  }
  
  public final Bundle zzd(Bundle paramBundle)
    throws RemoteException
  {
    Object localObject = zza();
    zzbo.zzd((Parcel)localObject, paramBundle);
    paramBundle = zzC(1, (Parcel)localObject);
    localObject = (Bundle)zzbo.zzc(paramBundle, Bundle.CREATOR);
    paramBundle.recycle();
    return (Bundle)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */