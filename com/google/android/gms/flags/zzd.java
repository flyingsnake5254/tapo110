package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.flags.zzb;

public abstract class zzd
  extends zzb
  implements zzc
{
  public zzd()
  {
    super("com.google.android.gms.flags.IFlagProvider");
  }
  
  public static zzc asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
    if ((localIInterface instanceof zzc)) {
      return (zzc)localIInterface;
    }
    return new zze(paramIBinder);
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            if (paramInt1 != 5) {
              return false;
            }
            paramParcel1 = getStringFlagValue(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
            paramParcel2.writeNoException();
            paramParcel2.writeString(paramParcel1);
          }
          else
          {
            long l = getLongFlagValue(paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readInt());
            paramParcel2.writeNoException();
            paramParcel2.writeLong(l);
          }
        }
        else
        {
          paramInt1 = getIntFlagValue(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
        }
      }
      else
      {
        boolean bool = getBooleanFlagValue(paramParcel1.readString(), com.google.android.gms.internal.flags.zzc.zza(paramParcel1), paramParcel1.readInt());
        paramParcel2.writeNoException();
        com.google.android.gms.internal.flags.zzc.writeBoolean(paramParcel2, bool);
      }
    }
    else
    {
      init(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\flags\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */