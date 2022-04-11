package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@KeepForSdk
@SafeParcelable.Class(creator="FavaDiagnosticsEntityCreator")
public class FavaDiagnosticsEntity
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @KeepForSdk
  public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new zaa();
  @SafeParcelable.VersionField(id=1)
  private final int zalf;
  @SafeParcelable.Field(id=2)
  private final String zapj;
  @SafeParcelable.Field(id=3)
  private final int zapk;
  
  @SafeParcelable.Constructor
  public FavaDiagnosticsEntity(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) int paramInt2)
  {
    this.zalf = paramInt1;
    this.zapj = paramString;
    this.zapk = paramInt2;
  }
  
  @KeepForSdk
  public FavaDiagnosticsEntity(String paramString, int paramInt)
  {
    this.zalf = 1;
    this.zapj = paramString;
    this.zapk = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeString(paramParcel, 2, this.zapj, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zapk);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\server\FavaDiagnosticsEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */