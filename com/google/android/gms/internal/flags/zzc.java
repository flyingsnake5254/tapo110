package com.google.android.gms.internal.flags;

import android.os.IInterface;
import android.os.Parcel;

public class zzc
{
  private static final ClassLoader zzd = zzc.class.getClassLoader();
  
  public static void writeBoolean(Parcel paramParcel, boolean paramBoolean)
  {
    paramParcel.writeInt(paramBoolean);
  }
  
  public static void zza(Parcel paramParcel, IInterface paramIInterface)
  {
    if (paramIInterface == null)
    {
      paramParcel.writeStrongBinder(null);
      return;
    }
    paramParcel.writeStrongBinder(paramIInterface.asBinder());
  }
  
  public static boolean zza(Parcel paramParcel)
  {
    return paramParcel.readInt() != 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\flags\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */