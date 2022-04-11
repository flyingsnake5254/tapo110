package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@SafeParcelable.Class(creator="InitializationParamsCreator")
public final class zzcl
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzcl> CREATOR = new zzcm();
  @SafeParcelable.Field(id=1)
  public final long zza;
  @SafeParcelable.Field(id=2)
  public final long zzb;
  @SafeParcelable.Field(id=3)
  public final boolean zzc;
  @Nullable
  @SafeParcelable.Field(id=4)
  public final String zzd;
  @Nullable
  @SafeParcelable.Field(id=5)
  public final String zze;
  @Nullable
  @SafeParcelable.Field(id=6)
  public final String zzf;
  @Nullable
  @SafeParcelable.Field(id=7)
  public final Bundle zzg;
  @Nullable
  @SafeParcelable.Field(id=8)
  public final String zzh;
  
  @SafeParcelable.Constructor
  public zzcl(@SafeParcelable.Param(id=1) long paramLong1, @SafeParcelable.Param(id=2) long paramLong2, @SafeParcelable.Param(id=3) boolean paramBoolean, @Nullable @SafeParcelable.Param(id=4) String paramString1, @Nullable @SafeParcelable.Param(id=5) String paramString2, @Nullable @SafeParcelable.Param(id=6) String paramString3, @Nullable @SafeParcelable.Param(id=7) Bundle paramBundle, @Nullable @SafeParcelable.Param(id=8) String paramString4)
  {
    this.zza = paramLong1;
    this.zzb = paramLong2;
    this.zzc = paramBoolean;
    this.zzd = paramString1;
    this.zze = paramString2;
    this.zzf = paramString3;
    this.zzg = paramBundle;
    this.zzh = paramString4;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, this.zza);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzb);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzd, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zze, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzf, false);
    SafeParcelWriter.writeBundle(paramParcel, 7, this.zzg, false);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzh, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzcl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */