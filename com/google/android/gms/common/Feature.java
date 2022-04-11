package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
@SafeParcelable.Class(creator="FeatureCreator")
public class Feature
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Feature> CREATOR = new zzb();
  @SafeParcelable.Field(getter="getName", id=1)
  private final String name;
  @Deprecated
  @SafeParcelable.Field(getter="getOldVersion", id=2)
  private final int zzk;
  @SafeParcelable.Field(defaultValue="-1", getter="getVersion", id=3)
  private final long zzl;
  
  @SafeParcelable.Constructor
  public Feature(@SafeParcelable.Param(id=1) String paramString, @SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) long paramLong)
  {
    this.name = paramString;
    this.zzk = paramInt;
    this.zzl = paramLong;
  }
  
  @KeepForSdk
  public Feature(String paramString, long paramLong)
  {
    this.name = paramString;
    this.zzl = paramLong;
    this.zzk = -1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Feature))
    {
      paramObject = (Feature)paramObject;
      if (((getName() != null) && (getName().equals(((Feature)paramObject).getName()))) || ((getName() == null) && (((Feature)paramObject).getName() == null) && (getVersion() == ((Feature)paramObject).getVersion()))) {
        return true;
      }
    }
    return false;
  }
  
  @KeepForSdk
  public String getName()
  {
    return this.name;
  }
  
  @KeepForSdk
  public long getVersion()
  {
    long l1 = this.zzl;
    long l2 = l1;
    if (l1 == -1L) {
      l2 = this.zzk;
    }
    return l2;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { getName(), Long.valueOf(getVersion()) });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzk);
    SafeParcelWriter.writeLong(paramParcel, 3, getVersion());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\Feature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */