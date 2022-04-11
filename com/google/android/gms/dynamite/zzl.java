package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzl
  extends zza
  implements zzk
{
  zzl(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
  }
  
  public final IObjectWrapper zza(IObjectWrapper paramIObjectWrapper1, String paramString, int paramInt, IObjectWrapper paramIObjectWrapper2)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper1);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    zzc.zza(localParcel, paramIObjectWrapper2);
    paramIObjectWrapper1 = zza(2, localParcel);
    paramString = IObjectWrapper.Stub.asInterface(paramIObjectWrapper1.readStrongBinder());
    paramIObjectWrapper1.recycle();
    return paramString;
  }
  
  public final IObjectWrapper zzb(IObjectWrapper paramIObjectWrapper1, String paramString, int paramInt, IObjectWrapper paramIObjectWrapper2)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper1);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    zzc.zza(localParcel, paramIObjectWrapper2);
    paramIObjectWrapper1 = zza(3, localParcel);
    paramString = IObjectWrapper.Stub.asInterface(paramIObjectWrapper1.readStrongBinder());
    paramIObjectWrapper1.recycle();
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\dynamite\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */