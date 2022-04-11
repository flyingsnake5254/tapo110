package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@SafeParcelable.Class(creator="ConditionalUserPropertyParcelCreator")
public final class zzaa
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaa> CREATOR = new zzab();
  @Nullable
  @SafeParcelable.Field(id=2)
  public String zza;
  @SafeParcelable.Field(id=3)
  public String zzb;
  @SafeParcelable.Field(id=4)
  public zzkq zzc;
  @SafeParcelable.Field(id=5)
  public long zzd;
  @SafeParcelable.Field(id=6)
  public boolean zze;
  @Nullable
  @SafeParcelable.Field(id=7)
  public String zzf;
  @Nullable
  @SafeParcelable.Field(id=8)
  public final zzas zzg;
  @SafeParcelable.Field(id=9)
  public long zzh;
  @Nullable
  @SafeParcelable.Field(id=10)
  public zzas zzi;
  @SafeParcelable.Field(id=11)
  public final long zzj;
  @Nullable
  @SafeParcelable.Field(id=12)
  public final zzas zzk;
  
  zzaa(zzaa paramzzaa)
  {
    Preconditions.checkNotNull(paramzzaa);
    this.zza = paramzzaa.zza;
    this.zzb = paramzzaa.zzb;
    this.zzc = paramzzaa.zzc;
    this.zzd = paramzzaa.zzd;
    this.zze = paramzzaa.zze;
    this.zzf = paramzzaa.zzf;
    this.zzg = paramzzaa.zzg;
    this.zzh = paramzzaa.zzh;
    this.zzi = paramzzaa.zzi;
    this.zzj = paramzzaa.zzj;
    this.zzk = paramzzaa.zzk;
  }
  
  @SafeParcelable.Constructor
  zzaa(@Nullable @SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) zzkq paramzzkq, @SafeParcelable.Param(id=5) long paramLong1, @SafeParcelable.Param(id=6) boolean paramBoolean, @Nullable @SafeParcelable.Param(id=7) String paramString3, @Nullable @SafeParcelable.Param(id=8) zzas paramzzas1, @SafeParcelable.Param(id=9) long paramLong2, @Nullable @SafeParcelable.Param(id=10) zzas paramzzas2, @SafeParcelable.Param(id=11) long paramLong3, @Nullable @SafeParcelable.Param(id=12) zzas paramzzas3)
  {
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = paramzzkq;
    this.zzd = paramLong1;
    this.zze = paramBoolean;
    this.zzf = paramString3;
    this.zzg = paramzzas1;
    this.zzh = paramLong2;
    this.zzi = paramzzas2;
    this.zzj = paramLong3;
    this.zzk = paramzzas3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zza, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzb, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzc, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 5, this.zzd);
    SafeParcelWriter.writeBoolean(paramParcel, 6, this.zze);
    SafeParcelWriter.writeString(paramParcel, 7, this.zzf, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, this.zzg, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 9, this.zzh);
    SafeParcelWriter.writeParcelable(paramParcel, 10, this.zzi, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 11, this.zzj);
    SafeParcelWriter.writeParcelable(paramParcel, 12, this.zzk, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */