package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class zzd
{
  private static final ClassLoader zza = zzd.class.getClassLoader();
  
  public static <T extends Parcelable> T zza(Parcel paramParcel, Parcelable.Creator<T> paramCreator)
  {
    if (paramParcel.readInt() == 0) {
      return null;
    }
    return (Parcelable)paramCreator.createFromParcel(paramParcel);
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
  
  public static void zza(Parcel paramParcel, Parcelable paramParcelable)
  {
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */