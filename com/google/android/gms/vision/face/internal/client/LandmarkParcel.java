package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@UsedByNative("wrapper.cc")
@SafeParcelable.Class(creator="LandmarkParcelCreator")
public final class LandmarkParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LandmarkParcel> CREATOR = new zzm();
  @SafeParcelable.Field(id=4)
  public final int type;
  @SafeParcelable.VersionField(id=1)
  private final int versionCode;
  @SafeParcelable.Field(id=2)
  public final float x;
  @SafeParcelable.Field(id=3)
  public final float y;
  
  @UsedByNative("wrapper.cc")
  @SafeParcelable.Constructor
  public LandmarkParcel(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) float paramFloat1, @SafeParcelable.Param(id=3) float paramFloat2, @SafeParcelable.Param(id=4) int paramInt2)
  {
    this.versionCode = paramInt1;
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.type = paramInt2;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeFloat(paramParcel, 2, this.x);
    SafeParcelWriter.writeFloat(paramParcel, 3, this.y);
    SafeParcelWriter.writeInt(paramParcel, 4, this.type);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\internal\client\LandmarkParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */