package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@SafeParcelable.Class(creator="CollectForDebugParcelableCreator")
public final class zzc
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzc> CREATOR = new zzd();
  @SafeParcelable.Field(defaultValue="false", id=1)
  private final boolean zzad;
  @SafeParcelable.Field(id=3)
  private final long zzae;
  @SafeParcelable.Field(id=2)
  private final long zzaf;
  
  @SafeParcelable.Constructor
  public zzc(@SafeParcelable.Param(id=1) boolean paramBoolean, @SafeParcelable.Param(id=3) long paramLong1, @SafeParcelable.Param(id=2) long paramLong2)
  {
    this.zzad = paramBoolean;
    this.zzae = paramLong1;
    this.zzaf = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof zzc))
    {
      paramObject = (zzc)paramObject;
      if ((this.zzad == ((zzc)paramObject).zzad) && (this.zzae == ((zzc)paramObject).zzae) && (this.zzaf == ((zzc)paramObject).zzaf)) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Boolean.valueOf(this.zzad), Long.valueOf(this.zzae), Long.valueOf(this.zzaf) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CollectForDebugParcelable[skipPersistentStorage: ");
    localStringBuilder.append(this.zzad);
    localStringBuilder.append(",collectForDebugStartTimeMillis: ");
    localStringBuilder.append(this.zzae);
    localStringBuilder.append(",collectForDebugExpiryTimeMillis: ");
    localStringBuilder.append(this.zzaf);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, this.zzad);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzaf);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzae);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\clearcut\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */