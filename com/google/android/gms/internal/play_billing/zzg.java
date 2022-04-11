package com.google.android.gms.internal.play_billing;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class zzg
{
  private static final ClassLoader zza = zzg.class.getClassLoader();
  
  public static <T extends Parcelable> T zza(Parcel paramParcel, Parcelable.Creator<T> paramCreator)
  {
    if (paramParcel.readInt() == 0) {
      return null;
    }
    return (Parcelable)paramCreator.createFromParcel(paramParcel);
  }
  
  public static void zzb(Parcel paramParcel, Parcelable paramParcelable)
  {
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\play_billing\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */