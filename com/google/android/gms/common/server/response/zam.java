package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@ShowFirstParty
@SafeParcelable.Class(creator="FieldMapPairCreator")
public final class zam
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zam> CREATOR = new zaj();
  @SafeParcelable.VersionField(id=1)
  private final int versionCode;
  @SafeParcelable.Field(id=2)
  final String zaqz;
  @SafeParcelable.Field(id=3)
  final FastJsonResponse.Field<?, ?> zara;
  
  @SafeParcelable.Constructor
  zam(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) FastJsonResponse.Field<?, ?> paramField)
  {
    this.versionCode = paramInt;
    this.zaqz = paramString;
    this.zara = paramField;
  }
  
  zam(String paramString, FastJsonResponse.Field<?, ?> paramField)
  {
    this.versionCode = 1;
    this.zaqz = paramString;
    this.zara = paramField;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.zaqz, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zara, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\server\response\zam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */