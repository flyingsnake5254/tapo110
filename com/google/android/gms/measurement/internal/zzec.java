package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbn;
import com.google.android.gms.internal.measurement.zzbo;

public abstract class zzec
  extends zzbn
  implements zzed
{
  public zzec()
  {
    super("com.google.android.gms.measurement.internal.IMeasurementService");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    case 3: 
    case 8: 
    default: 
      return false;
    case 20: 
      zzu((zzp)zzbo.zzc(paramParcel1, zzp.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 19: 
      zzt((Bundle)zzbo.zzc(paramParcel1, Bundle.CREATOR), (zzp)zzbo.zzc(paramParcel1, zzp.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 18: 
      zzs((zzp)zzbo.zzc(paramParcel1, zzp.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 17: 
      paramParcel1 = zzr(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 16: 
      paramParcel1 = zzq(paramParcel1.readString(), paramParcel1.readString(), (zzp)zzbo.zzc(paramParcel1, zzp.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 15: 
      paramParcel1 = zzp(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), zzbo.zza(paramParcel1));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 14: 
      paramParcel1 = zzo(paramParcel1.readString(), paramParcel1.readString(), zzbo.zza(paramParcel1), (zzp)zzbo.zzc(paramParcel1, zzp.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 13: 
      zzn((zzaa)zzbo.zzc(paramParcel1, zzaa.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 12: 
      zzm((zzaa)zzbo.zzc(paramParcel1, zzaa.CREATOR), (zzp)zzbo.zzc(paramParcel1, zzp.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 11: 
      paramParcel1 = zzl((zzp)zzbo.zzc(paramParcel1, zzp.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      break;
    case 10: 
      zzk(paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      break;
    case 9: 
      paramParcel1 = zzj((zzas)zzbo.zzc(paramParcel1, zzas.CREATOR), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      break;
    case 7: 
      paramParcel1 = zzi((zzp)zzbo.zzc(paramParcel1, zzp.CREATOR), zzbo.zza(paramParcel1));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 6: 
      zzh((zzp)zzbo.zzc(paramParcel1, zzp.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 5: 
      zzg((zzas)zzbo.zzc(paramParcel1, zzas.CREATOR), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      break;
    case 4: 
      zzf((zzp)zzbo.zzc(paramParcel1, zzp.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 2: 
      zze((zzkq)zzbo.zzc(paramParcel1, zzkq.CREATOR), (zzp)zzbo.zzc(paramParcel1, zzp.CREATOR));
      paramParcel2.writeNoException();
      break;
    case 1: 
      zzd((zzas)zzbo.zzc(paramParcel1, zzas.CREATOR), (zzp)zzbo.zzc(paramParcel1, zzp.CREATOR));
      paramParcel2.writeNoException();
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */