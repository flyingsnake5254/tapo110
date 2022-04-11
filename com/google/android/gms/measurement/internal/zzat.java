package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzat
  implements Parcelable.Creator<zzas>
{
  static void zza(zzas paramzzas, Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, paramzzas.zza, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, paramzzas.zzb, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, paramzzas.zzc, false);
    SafeParcelWriter.writeLong(paramParcel, 5, paramzzas.zzd);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */