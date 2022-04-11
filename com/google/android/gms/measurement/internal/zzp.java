package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.List;

@SafeParcelable.Class(creator="AppMetadataCreator")
@SafeParcelable.Reserved({1, 17, 20})
public final class zzp
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzp> CREATOR = new zzq();
  @Nullable
  @SafeParcelable.Field(id=2)
  public final String zza;
  @Nullable
  @SafeParcelable.Field(id=3)
  public final String zzb;
  @Nullable
  @SafeParcelable.Field(id=4)
  public final String zzc;
  @Nullable
  @SafeParcelable.Field(id=5)
  public final String zzd;
  @SafeParcelable.Field(id=6)
  public final long zze;
  @SafeParcelable.Field(id=7)
  public final long zzf;
  @Nullable
  @SafeParcelable.Field(id=8)
  public final String zzg;
  @SafeParcelable.Field(defaultValue="true", id=9)
  public final boolean zzh;
  @SafeParcelable.Field(id=10)
  public final boolean zzi;
  @SafeParcelable.Field(defaultValueUnchecked="Integer.MIN_VALUE", id=11)
  public final long zzj;
  @Nullable
  @SafeParcelable.Field(id=12)
  public final String zzk;
  @SafeParcelable.Field(id=13)
  public final long zzl;
  @SafeParcelable.Field(id=14)
  public final long zzm;
  @SafeParcelable.Field(id=15)
  public final int zzn;
  @SafeParcelable.Field(defaultValue="true", id=16)
  public final boolean zzo;
  @SafeParcelable.Field(id=18)
  public final boolean zzp;
  @Nullable
  @SafeParcelable.Field(id=19)
  public final String zzq;
  @Nullable
  @SafeParcelable.Field(id=21)
  public final Boolean zzr;
  @SafeParcelable.Field(id=22)
  public final long zzs;
  @Nullable
  @SafeParcelable.Field(id=23)
  public final List<String> zzt;
  @Nullable
  @SafeParcelable.Field(id=24)
  public final String zzu;
  @SafeParcelable.Field(defaultValue="", id=25)
  public final String zzv;
  
  zzp(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, long paramLong1, @Nullable String paramString4, long paramLong2, long paramLong3, @Nullable String paramString5, boolean paramBoolean1, boolean paramBoolean2, @Nullable String paramString6, long paramLong4, long paramLong5, int paramInt, boolean paramBoolean3, boolean paramBoolean4, @Nullable String paramString7, @Nullable Boolean paramBoolean, long paramLong6, @Nullable List<String> paramList, @Nullable String paramString8, String paramString9)
  {
    Preconditions.checkNotEmpty(paramString1);
    this.zza = paramString1;
    if (true != TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    } else {
      paramString1 = null;
    }
    this.zzb = paramString1;
    this.zzc = paramString3;
    this.zzj = paramLong1;
    this.zzd = paramString4;
    this.zze = paramLong2;
    this.zzf = paramLong3;
    this.zzg = paramString5;
    this.zzh = paramBoolean1;
    this.zzi = paramBoolean2;
    this.zzk = paramString6;
    this.zzl = paramLong4;
    this.zzm = paramLong5;
    this.zzn = paramInt;
    this.zzo = paramBoolean3;
    this.zzp = paramBoolean4;
    this.zzq = paramString7;
    this.zzr = paramBoolean;
    this.zzs = paramLong6;
    this.zzt = paramList;
    this.zzu = paramString8;
    this.zzv = paramString9;
  }
  
  @SafeParcelable.Constructor
  zzp(@Nullable @SafeParcelable.Param(id=2) String paramString1, @Nullable @SafeParcelable.Param(id=3) String paramString2, @Nullable @SafeParcelable.Param(id=4) String paramString3, @Nullable @SafeParcelable.Param(id=5) String paramString4, @SafeParcelable.Param(id=6) long paramLong1, @SafeParcelable.Param(id=7) long paramLong2, @Nullable @SafeParcelable.Param(id=8) String paramString5, @SafeParcelable.Param(id=9) boolean paramBoolean1, @SafeParcelable.Param(id=10) boolean paramBoolean2, @SafeParcelable.Param(id=11) long paramLong3, @Nullable @SafeParcelable.Param(id=12) String paramString6, @SafeParcelable.Param(id=13) long paramLong4, @SafeParcelable.Param(id=14) long paramLong5, @SafeParcelable.Param(id=15) int paramInt, @SafeParcelable.Param(id=16) boolean paramBoolean3, @SafeParcelable.Param(id=18) boolean paramBoolean4, @Nullable @SafeParcelable.Param(id=19) String paramString7, @Nullable @SafeParcelable.Param(id=21) Boolean paramBoolean, @SafeParcelable.Param(id=22) long paramLong6, @Nullable @SafeParcelable.Param(id=23) List<String> paramList, @Nullable @SafeParcelable.Param(id=24) String paramString8, @SafeParcelable.Param(id=25) String paramString9)
  {
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = paramString3;
    this.zzj = paramLong3;
    this.zzd = paramString4;
    this.zze = paramLong1;
    this.zzf = paramLong2;
    this.zzg = paramString5;
    this.zzh = paramBoolean1;
    this.zzi = paramBoolean2;
    this.zzk = paramString6;
    this.zzl = paramLong4;
    this.zzm = paramLong5;
    this.zzn = paramInt;
    this.zzo = paramBoolean3;
    this.zzp = paramBoolean4;
    this.zzq = paramString7;
    this.zzr = paramBoolean;
    this.zzs = paramLong6;
    this.zzt = paramList;
    this.zzu = paramString8;
    this.zzv = paramString9;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zza, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzb, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzc, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzd, false);
    SafeParcelWriter.writeLong(paramParcel, 6, this.zze);
    SafeParcelWriter.writeLong(paramParcel, 7, this.zzf);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzg, false);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzh);
    SafeParcelWriter.writeBoolean(paramParcel, 10, this.zzi);
    SafeParcelWriter.writeLong(paramParcel, 11, this.zzj);
    SafeParcelWriter.writeString(paramParcel, 12, this.zzk, false);
    SafeParcelWriter.writeLong(paramParcel, 13, this.zzl);
    SafeParcelWriter.writeLong(paramParcel, 14, this.zzm);
    SafeParcelWriter.writeInt(paramParcel, 15, this.zzn);
    SafeParcelWriter.writeBoolean(paramParcel, 16, this.zzo);
    SafeParcelWriter.writeBoolean(paramParcel, 18, this.zzp);
    SafeParcelWriter.writeString(paramParcel, 19, this.zzq, false);
    SafeParcelWriter.writeBooleanObject(paramParcel, 21, this.zzr, false);
    SafeParcelWriter.writeLong(paramParcel, 22, this.zzs);
    SafeParcelWriter.writeStringList(paramParcel, 23, this.zzt, false);
    SafeParcelWriter.writeString(paramParcel, 24, this.zzu, false);
    SafeParcelWriter.writeString(paramParcel, 25, this.zzv, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */