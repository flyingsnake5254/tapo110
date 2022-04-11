package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzo
  extends zza
  implements zzm
{
  zzo(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
  }
  
  public final boolean zza(zzk paramzzk, IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramzzk);
    zzc.zza(localParcel, paramIObjectWrapper);
    paramzzk = zza(5, localParcel);
    boolean bool = zzc.zza(paramzzk);
    paramzzk.recycle();
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */