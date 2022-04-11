package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@SafeParcelable.Class(creator="UserAttributeParcelCreator")
public final class zzkq
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzkq> CREATOR = new zzkr();
  @SafeParcelable.Field(id=1)
  public final int zza;
  @SafeParcelable.Field(id=2)
  public final String zzb;
  @SafeParcelable.Field(id=3)
  public final long zzc;
  @Nullable
  @SafeParcelable.Field(id=4)
  public final Long zzd;
  @Nullable
  @SafeParcelable.Field(id=6)
  public final String zze;
  @Nullable
  @SafeParcelable.Field(id=7)
  public final String zzf;
  @Nullable
  @SafeParcelable.Field(id=8)
  public final Double zzg;
  
  @SafeParcelable.Constructor
  zzkq(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) long paramLong, @Nullable @SafeParcelable.Param(id=4) Long paramLong1, @SafeParcelable.Param(id=5) Float paramFloat, @Nullable @SafeParcelable.Param(id=6) String paramString2, @Nullable @SafeParcelable.Param(id=7) String paramString3, @Nullable @SafeParcelable.Param(id=8) Double paramDouble)
  {
    this.zza = paramInt;
    this.zzb = paramString1;
    this.zzc = paramLong;
    this.zzd = paramLong1;
    if (paramInt == 1)
    {
      if (paramFloat != null) {
        paramString1 = Double.valueOf(paramFloat.doubleValue());
      } else {
        paramString1 = null;
      }
      this.zzg = paramString1;
    }
    else
    {
      this.zzg = paramDouble;
    }
    this.zze = paramString2;
    this.zzf = paramString3;
  }
  
  zzkq(zzks paramzzks)
  {
    this(paramzzks.zzc, paramzzks.zzd, paramzzks.zze, paramzzks.zzb);
  }
  
  zzkq(String paramString1, long paramLong, @Nullable Object paramObject, @Nullable String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    this.zza = 2;
    this.zzb = paramString1;
    this.zzc = paramLong;
    this.zzf = paramString2;
    if (paramObject == null)
    {
      this.zzd = null;
      this.zzg = null;
      this.zze = null;
      return;
    }
    if ((paramObject instanceof Long))
    {
      this.zzd = ((Long)paramObject);
      this.zzg = null;
      this.zze = null;
      return;
    }
    if ((paramObject instanceof String))
    {
      this.zzd = null;
      this.zzg = null;
      this.zze = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      this.zzd = null;
      this.zzg = ((Double)paramObject);
      this.zze = null;
      return;
    }
    throw new IllegalArgumentException("User attribute given of un-supported type");
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzkr.zza(this, paramParcel, paramInt);
  }
  
  @Nullable
  public final Object zza()
  {
    Object localObject = this.zzd;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.zzg;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.zze;
    if (localObject != null) {
      return localObject;
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzkq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */