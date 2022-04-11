package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzkr
  implements Parcelable.Creator<zzkq>
{
  static void zza(zzkq paramzzkq, Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, paramzzkq.zza);
    SafeParcelWriter.writeString(paramParcel, 2, paramzzkq.zzb, false);
    SafeParcelWriter.writeLong(paramParcel, 3, paramzzkq.zzc);
    SafeParcelWriter.writeLongObject(paramParcel, 4, paramzzkq.zzd, false);
    SafeParcelWriter.writeFloatObject(paramParcel, 5, null, false);
    SafeParcelWriter.writeString(paramParcel, 6, paramzzkq.zze, false);
    SafeParcelWriter.writeString(paramParcel, 7, paramzzkq.zzf, false);
    SafeParcelWriter.writeDoubleObject(paramParcel, 8, paramzzkq.zzg, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzkr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */