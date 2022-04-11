package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzch
  extends zzbn
  implements zzci
{
  public zzch()
  {
    super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return false;
      }
      paramInt1 = zze();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
    }
    else
    {
      zzd(paramParcel1.readString(), paramParcel1.readString(), (Bundle)zzbo.zzc(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
      paramParcel2.writeNoException();
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */