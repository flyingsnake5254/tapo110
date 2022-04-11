package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbq
  extends zzbn
  implements zzbr
{
  public static zzbr zzb(IBinder paramIBinder)
  {
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    if ((localIInterface instanceof zzbr)) {
      return (zzbr)localIInterface;
    }
    return new zzbp(paramIBinder);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzbq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */