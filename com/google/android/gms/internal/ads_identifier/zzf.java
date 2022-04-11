package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzf
  extends zzb
  implements zze
{
  public static zze zza(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    if ((localIInterface instanceof zze)) {
      return (zze)localIInterface;
    }
    return new zzg(paramIBinder);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\ads_identifier\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */