package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzc
  extends zzf
  implements zzd
{
  public static zzd zzo(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
    if ((localIInterface instanceof zzd)) {
      return (zzd)localIInterface;
    }
    return new zzb(paramIBinder);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\play_billing\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */