package com.google.android.gms.internal.clearcut;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza
  implements IInterface
{
  private final IBinder zza;
  private final String zzb;
  
  protected zza(IBinder paramIBinder, String paramString)
  {
    this.zza = paramIBinder;
    this.zzb = paramString;
  }
  
  public IBinder asBinder()
  {
    return this.zza;
  }
  
  protected final Parcel obtainAndWriteInterfaceToken()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zzb);
    return localParcel;
  }
  
  protected final void transactOneway(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    try
    {
      this.zza.transact(1, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */