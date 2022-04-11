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
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Frame.Metadata;

@SafeParcelable.Class(creator="FrameMetadataParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzu
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzu> CREATOR = new zzt();
  @SafeParcelable.Field(id=3)
  public int height;
  @SafeParcelable.Field(id=4)
  public int id;
  @SafeParcelable.Field(id=6)
  public int rotation;
  @SafeParcelable.Field(id=2)
  public int width;
  @SafeParcelable.Field(id=5)
  public long zzaz;
  
  public zzu() {}
  
  @SafeParcelable.Constructor
  public zzu(@SafeParcelable.Param(id=2) int paramInt1, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) int paramInt3, @SafeParcelable.Param(id=5) long paramLong, @SafeParcelable.Param(id=6) int paramInt4)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.id = paramInt3;
    this.zzaz = paramLong;
    this.rotation = paramInt4;
  }
  
  public static zzu zzd(Frame paramFrame)
  {
    zzu localzzu = new zzu();
    localzzu.width = paramFrame.getMetadata().getWidth();
    localzzu.height = paramFrame.getMetadata().getHeight();
    localzzu.rotation = paramFrame.getMetadata().getRotation();
    localzzu.id = paramFrame.getMetadata().getId();
    localzzu.zzaz = paramFrame.getMetadata().getTimestampMillis();
    return localzzu;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.width);
    SafeParcelWriter.writeInt(paramParcel, 3, this.height);
    SafeParcelWriter.writeInt(paramParcel, 4, this.id);
    SafeParcelWriter.writeLong(paramParcel, 5, this.zzaz);
    SafeParcelWriter.writeInt(paramParcel, 6, this.rotation);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */