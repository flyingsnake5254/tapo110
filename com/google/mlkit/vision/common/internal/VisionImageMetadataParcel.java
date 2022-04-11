package com.google.mlkit.vision.common.internal;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
@SafeParcelable.Class(creator="VisionImageMetadataParcelCreator")
public class VisionImageMetadataParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<VisionImageMetadataParcel> CREATOR = new j();
  @KeepForSdk
  @SafeParcelable.Field(id=1)
  public final int c;
  @KeepForSdk
  @SafeParcelable.Field(id=2)
  public final int d;
  @SafeParcelable.Field(id=3)
  private final int f;
  @KeepForSdk
  @SafeParcelable.Field(id=4)
  public final long q;
  @KeepForSdk
  @SafeParcelable.Field(id=5)
  public final int x;
  
  @SafeParcelable.Constructor
  public VisionImageMetadataParcel(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) int paramInt3, @SafeParcelable.Param(id=4) long paramLong, @SafeParcelable.Param(id=5) int paramInt4)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.f = paramInt3;
    this.q = paramLong;
    this.x = paramInt4;
  }
  
  @Nullable
  @KeepForSdk
  public Matrix a()
  {
    if (this.x == 0) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postTranslate(-this.c / 2.0F, -this.d / 2.0F);
    localMatrix.postRotate(this.x * 90);
    int i;
    if (this.x % 2 != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0) {
      j = this.d;
    } else {
      j = this.c;
    }
    if (i != 0) {
      i = this.c;
    } else {
      i = this.d;
    }
    localMatrix.postTranslate(j / 2.0F, i / 2.0F);
    return localMatrix;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.c);
    SafeParcelWriter.writeInt(paramParcel, 2, this.d);
    SafeParcelWriter.writeInt(paramParcel, 3, this.f);
    SafeParcelWriter.writeLong(paramParcel, 4, this.q);
    SafeParcelWriter.writeInt(paramParcel, 5, this.x);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\common\internal\VisionImageMetadataParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */