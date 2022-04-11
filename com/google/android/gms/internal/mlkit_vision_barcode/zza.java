package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza
  extends Binder
  implements IInterface
{
  private static zzc zza;
  
  protected zza(String paramString)
  {
    attachInterface(this, paramString);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    boolean bool;
    if (paramInt1 > 16777215)
    {
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    else
    {
      paramParcel1.enforceInterface(getInterfaceDescriptor());
      bool = false;
    }
    if (bool) {
      return true;
    }
    return zza(paramInt1, paramParcel1, paramParcel2, paramInt2);
  }
  
  protected boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */