package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Iterator;

@SafeParcelable.Class(creator="EventParamsCreator")
@SafeParcelable.Reserved({1})
public final class zzaq
  extends AbstractSafeParcelable
  implements Iterable<String>
{
  public static final Parcelable.Creator<zzaq> CREATOR = new zzar();
  @SafeParcelable.Field(getter="z", id=2)
  private final Bundle zza;
  
  @SafeParcelable.Constructor
  zzaq(@SafeParcelable.Param(id=2) Bundle paramBundle)
  {
    this.zza = paramBundle;
  }
  
  public final Iterator<String> iterator()
  {
    return new zzap(this);
  }
  
  public final String toString()
  {
    return this.zza.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, zzf(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  final Object zza(String paramString)
  {
    return this.zza.get(paramString);
  }
  
  final Long zzb(String paramString)
  {
    return Long.valueOf(this.zza.getLong("value"));
  }
  
  final Double zzc(String paramString)
  {
    return Double.valueOf(this.zza.getDouble("value"));
  }
  
  final String zzd(String paramString)
  {
    return this.zza.getString(paramString);
  }
  
  public final int zze()
  {
    return this.zza.size();
  }
  
  public final Bundle zzf()
  {
    return new Bundle(this.zza);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */