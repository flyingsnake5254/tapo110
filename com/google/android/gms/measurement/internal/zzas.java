package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="EventParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzas
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzas> CREATOR = new zzat();
  @SafeParcelable.Field(id=2)
  public final String zza;
  @SafeParcelable.Field(id=3)
  public final zzaq zzb;
  @SafeParcelable.Field(id=4)
  public final String zzc;
  @SafeParcelable.Field(id=5)
  public final long zzd;
  
  zzas(zzas paramzzas, long paramLong)
  {
    Preconditions.checkNotNull(paramzzas);
    this.zza = paramzzas.zza;
    this.zzb = paramzzas.zzb;
    this.zzc = paramzzas.zzc;
    this.zzd = paramLong;
  }
  
  @SafeParcelable.Constructor
  public zzas(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) zzaq paramzzaq, @SafeParcelable.Param(id=4) String paramString2, @SafeParcelable.Param(id=5) long paramLong)
  {
    this.zza = paramString1;
    this.zzb = paramzzaq;
    this.zzc = paramString2;
    this.zzd = paramLong;
  }
  
  public final String toString()
  {
    String str1 = this.zzc;
    String str2 = this.zza;
    String str3 = String.valueOf(this.zzb);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 21 + String.valueOf(str2).length() + str3.length());
    localStringBuilder.append("origin=");
    localStringBuilder.append(str1);
    localStringBuilder.append(",name=");
    localStringBuilder.append(str2);
    localStringBuilder.append(",params=");
    localStringBuilder.append(str3);
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzat.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */