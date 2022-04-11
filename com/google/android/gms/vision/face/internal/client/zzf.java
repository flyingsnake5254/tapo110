package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="FaceSettingsParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzf
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzf> CREATOR = new zze();
  @SafeParcelable.Field(id=3)
  public int landmarkType;
  @SafeParcelable.Field(id=2)
  public int mode;
  @SafeParcelable.Field(defaultValue="-1", id=7)
  public float proportionalMinFaceSize;
  @SafeParcelable.Field(id=6)
  public boolean trackingEnabled;
  @SafeParcelable.Field(id=5)
  public boolean zzcv;
  @SafeParcelable.Field(id=4)
  public int zzcw;
  
  public zzf() {}
  
  @SafeParcelable.Constructor
  public zzf(@SafeParcelable.Param(id=2) int paramInt1, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) int paramInt3, @SafeParcelable.Param(id=5) boolean paramBoolean1, @SafeParcelable.Param(id=6) boolean paramBoolean2, @SafeParcelable.Param(id=7) float paramFloat)
  {
    this.mode = paramInt1;
    this.landmarkType = paramInt2;
    this.zzcw = paramInt3;
    this.zzcv = paramBoolean1;
    this.trackingEnabled = paramBoolean2;
    this.proportionalMinFaceSize = paramFloat;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.mode);
    SafeParcelWriter.writeInt(paramParcel, 3, this.landmarkType);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzcw);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zzcv);
    SafeParcelWriter.writeBoolean(paramParcel, 6, this.trackingEnabled);
    SafeParcelWriter.writeFloat(paramParcel, 7, this.proportionalMinFaceSize);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\internal\client\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */