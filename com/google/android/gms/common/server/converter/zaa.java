package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;

@SafeParcelable.Class(creator="ConverterWrapperCreator")
public final class zaa
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zaa> CREATOR = new zab();
  @SafeParcelable.VersionField(id=1)
  private final int zalf;
  @SafeParcelable.Field(getter="getStringToIntConverter", id=2)
  private final StringToIntConverter zapl;
  
  @SafeParcelable.Constructor
  zaa(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) StringToIntConverter paramStringToIntConverter)
  {
    this.zalf = paramInt;
    this.zapl = paramStringToIntConverter;
  }
  
  private zaa(StringToIntConverter paramStringToIntConverter)
  {
    this.zalf = 1;
    this.zapl = paramStringToIntConverter;
  }
  
  public static zaa zaa(FastJsonResponse.FieldConverter<?, ?> paramFieldConverter)
  {
    if ((paramFieldConverter instanceof StringToIntConverter)) {
      return new zaa((StringToIntConverter)paramFieldConverter);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zapl, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final FastJsonResponse.FieldConverter<?, ?> zaci()
  {
    StringToIntConverter localStringToIntConverter = this.zapl;
    if (localStringToIntConverter != null) {
      return localStringToIntConverter;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\server\converter\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */