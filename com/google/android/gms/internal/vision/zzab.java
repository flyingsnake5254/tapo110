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

@SafeParcelable.Class(creator="BoundingBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzab
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzab> CREATOR = new zzaa();
  @SafeParcelable.Field(id=5)
  public final int height;
  @SafeParcelable.Field(id=2)
  public final int left;
  @SafeParcelable.Field(id=3)
  public final int top;
  @SafeParcelable.Field(id=4)
  public final int width;
  @SafeParcelable.Field(id=6)
  public final float zzeo;
  
  @SafeParcelable.Constructor
  public zzab(@SafeParcelable.Param(id=2) int paramInt1, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) int paramInt3, @SafeParcelable.Param(id=5) int paramInt4, @SafeParcelable.Param(id=6) float paramFloat)
  {
    this.left = paramInt1;
    this.top = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.zzeo = paramFloat;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.left);
    SafeParcelWriter.writeInt(paramParcel, 3, this.top);
    SafeParcelWriter.writeInt(paramParcel, 4, this.width);
    SafeParcelWriter.writeInt(paramParcel, 5, this.height);
    SafeParcelWriter.writeFloat(paramParcel, 6, this.zzeo);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */