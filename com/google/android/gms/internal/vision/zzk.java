package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="BarcodeDetectorOptionsCreator")
@SafeParcelable.Reserved({1})
public final class zzk
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzk> CREATOR = new zzj();
  @SafeParcelable.Field(id=2)
  public int zzbt;
  @SafeParcelable.Field(id=3)
  private boolean zzbu;
  
  public zzk() {}
  
  @SafeParcelable.Constructor
  public zzk(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) boolean paramBoolean)
  {
    this.zzbt = paramInt;
    this.zzbu = paramBoolean;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzbt);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzbu);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */