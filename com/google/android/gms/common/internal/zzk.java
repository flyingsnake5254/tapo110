package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.common.zza;

public final class zzk
  extends zza
  implements zzi
{
  zzk(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.ICertData");
  }
  
  public final IObjectWrapper zzb()
    throws RemoteException
  {
    Parcel localParcel = zza(1, zza());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }
  
  public final int zzc()
    throws RemoteException
  {
    Parcel localParcel = zza(2, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */