package com.google.android.gms.internal.clearcut;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract interface zzl
  extends IInterface
{
  public abstract void zza(Status paramStatus)
    throws RemoteException;
  
  public abstract void zza(Status paramStatus, long paramLong)
    throws RemoteException;
  
  public abstract void zza(Status paramStatus, zzc paramzzc)
    throws RemoteException;
  
  public abstract void zza(Status paramStatus, zze[] paramArrayOfzze)
    throws RemoteException;
  
  public abstract void zza(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void zzb(Status paramStatus)
    throws RemoteException;
  
  public abstract void zzb(Status paramStatus, long paramLong)
    throws RemoteException;
  
  public abstract void zzb(Status paramStatus, zzc paramzzc)
    throws RemoteException;
  
  public abstract void zzc(Status paramStatus)
    throws RemoteException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */