package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzm
  extends zzb
  implements zzl
{
  public zzm()
  {
    super("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 9: 
      zzb((Status)zzc.zza(paramParcel1, Status.CREATOR), (com.google.android.gms.clearcut.zzc)zzc.zza(paramParcel1, com.google.android.gms.clearcut.zzc.CREATOR));
      break;
    case 8: 
      zza((Status)zzc.zza(paramParcel1, Status.CREATOR), (com.google.android.gms.clearcut.zzc)zzc.zza(paramParcel1, com.google.android.gms.clearcut.zzc.CREATOR));
      break;
    case 7: 
      zza((DataHolder)zzc.zza(paramParcel1, DataHolder.CREATOR));
      break;
    case 6: 
      zza((Status)zzc.zza(paramParcel1, Status.CREATOR), (zze[])paramParcel1.createTypedArray(zze.CREATOR));
      break;
    case 5: 
      zzb((Status)zzc.zza(paramParcel1, Status.CREATOR), paramParcel1.readLong());
      break;
    case 4: 
      zzc((Status)zzc.zza(paramParcel1, Status.CREATOR));
      break;
    case 3: 
      zza((Status)zzc.zza(paramParcel1, Status.CREATOR), paramParcel1.readLong());
      break;
    case 2: 
      zzb((Status)zzc.zza(paramParcel1, Status.CREATOR));
      break;
    case 1: 
      zza((Status)zzc.zza(paramParcel1, Status.CREATOR));
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */