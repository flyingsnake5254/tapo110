package com.google.android.gms.internal.vision;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;

public abstract interface zzl
  extends IInterface
{
  public abstract Barcode[] zza(IObjectWrapper paramIObjectWrapper, zzu paramzzu)
    throws RemoteException;
  
  public abstract Barcode[] zzb(IObjectWrapper paramIObjectWrapper, zzu paramzzu)
    throws RemoteException;
  
  public abstract void zzn()
    throws RemoteException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */