package com.google.android.gms.vision.face.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzu;

public abstract interface zzh
  extends IInterface
{
  public abstract FaceParcel[] zza(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, zzu paramzzu)
    throws RemoteException;
  
  public abstract FaceParcel[] zzc(IObjectWrapper paramIObjectWrapper, zzu paramzzu)
    throws RemoteException;
  
  public abstract boolean zzd(int paramInt)
    throws RemoteException;
  
  public abstract void zzn()
    throws RemoteException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\internal\client\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */