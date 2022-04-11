package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzd;
import com.google.android.gms.internal.vision.zzu;

public final class zzj
  extends zzb
  implements zzh
{
  zzj(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
  }
  
  public final FaceParcel[] zza(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, zzu paramzzu)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzd.zza(localParcel, paramIObjectWrapper1);
    zzd.zza(localParcel, paramIObjectWrapper2);
    zzd.zza(localParcel, paramIObjectWrapper3);
    localParcel.writeInt(paramInt1);
    localParcel.writeInt(paramInt2);
    localParcel.writeInt(paramInt3);
    localParcel.writeInt(paramInt4);
    localParcel.writeInt(paramInt5);
    localParcel.writeInt(paramInt6);
    zzd.zza(localParcel, paramzzu);
    paramIObjectWrapper2 = zza(4, localParcel);
    paramIObjectWrapper1 = (FaceParcel[])paramIObjectWrapper2.createTypedArray(FaceParcel.CREATOR);
    paramIObjectWrapper2.recycle();
    return paramIObjectWrapper1;
  }
  
  public final FaceParcel[] zzc(IObjectWrapper paramIObjectWrapper, zzu paramzzu)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzd.zza(localParcel, paramIObjectWrapper);
    zzd.zza(localParcel, paramzzu);
    paramzzu = zza(1, localParcel);
    paramIObjectWrapper = (FaceParcel[])paramzzu.createTypedArray(FaceParcel.CREATOR);
    paramzzu.recycle();
    return paramIObjectWrapper;
  }
  
  public final boolean zzd(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    localParcel = zza(2, localParcel);
    boolean bool = zzd.zza(localParcel);
    localParcel.recycle();
    return bool;
  }
  
  public final void zzn()
    throws RemoteException
  {
    zzb(3, obtainAndWriteInterfaceToken());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\internal\client\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */