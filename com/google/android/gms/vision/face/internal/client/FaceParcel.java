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
@SafeParcelable.Class(creator="FaceParcelCreator")
public class FaceParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<FaceParcel> CREATOR = new zzd();
  @SafeParcelable.Field(id=3)
  public final float centerX;
  @SafeParcelable.Field(id=4)
  public final float centerY;
  @SafeParcelable.Field(id=6)
  public final float height;
  @SafeParcelable.Field(id=2)
  public final int id;
  @SafeParcelable.VersionField(id=1)
  private final int versionCode;
  @SafeParcelable.Field(id=5)
  public final float width;
  @SafeParcelable.Field(id=10)
  public final float zzcm;
  @SafeParcelable.Field(id=11)
  public final float zzcn;
  @SafeParcelable.Field(id=12)
  public final float zzco;
  @SafeParcelable.Field(defaultValue="-1.0f", id=15)
  public final float zzcp;
  @SafeParcelable.Field(defaultValue="3.4028235E38f", id=7)
  public final float zzdh;
  @SafeParcelable.Field(defaultValue="3.4028235E38f", id=8)
  public final float zzdi;
  @SafeParcelable.Field(defaultValue="3.4028235E38f", id=14)
  public final float zzdj;
  @SafeParcelable.Field(id=9)
  public final LandmarkParcel[] zzdk;
  @SafeParcelable.Field(id=13)
  public final zza[] zzdl;
  
  @SafeParcelable.Constructor
  public FaceParcel(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) float paramFloat1, @SafeParcelable.Param(id=4) float paramFloat2, @SafeParcelable.Param(id=5) float paramFloat3, @SafeParcelable.Param(id=6) float paramFloat4, @SafeParcelable.Param(id=7) float paramFloat5, @SafeParcelable.Param(id=8) float paramFloat6, @SafeParcelable.Param(id=14) float paramFloat7, @SafeParcelable.Param(id=9) LandmarkParcel[] paramArrayOfLandmarkParcel, @SafeParcelable.Param(id=10) float paramFloat8, @SafeParcelable.Param(id=11) float paramFloat9, @SafeParcelable.Param(id=12) float paramFloat10, @SafeParcelable.Param(id=13) zza[] paramArrayOfzza, @SafeParcelable.Param(id=15) float paramFloat11)
  {
    this.versionCode = paramInt1;
    this.id = paramInt2;
    this.centerX = paramFloat1;
    this.centerY = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
    this.zzdh = paramFloat5;
    this.zzdi = paramFloat6;
    this.zzdj = paramFloat7;
    this.zzdk = paramArrayOfLandmarkParcel;
    this.zzcm = paramFloat8;
    this.zzcn = paramFloat9;
    this.zzco = paramFloat10;
    this.zzdl = paramArrayOfzza;
    this.zzcp = paramFloat11;
  }
  
  @UsedByNative("wrapper.cc")
  public FaceParcel(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) float paramFloat1, @SafeParcelable.Param(id=4) float paramFloat2, @SafeParcelable.Param(id=5) float paramFloat3, @SafeParcelable.Param(id=6) float paramFloat4, @SafeParcelable.Param(id=7) float paramFloat5, @SafeParcelable.Param(id=8) float paramFloat6, @SafeParcelable.Param(id=9) LandmarkParcel[] paramArrayOfLandmarkParcel, @SafeParcelable.Param(id=10) float paramFloat7, @SafeParcelable.Param(id=11) float paramFloat8, @SafeParcelable.Param(id=12) float paramFloat9)
  {
    this(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, 0.0F, paramArrayOfLandmarkParcel, paramFloat7, paramFloat8, paramFloat9, new zza[0], -1.0F);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeInt(paramParcel, 2, this.id);
    SafeParcelWriter.writeFloat(paramParcel, 3, this.centerX);
    SafeParcelWriter.writeFloat(paramParcel, 4, this.centerY);
    SafeParcelWriter.writeFloat(paramParcel, 5, this.width);
    SafeParcelWriter.writeFloat(paramParcel, 6, this.height);
    SafeParcelWriter.writeFloat(paramParcel, 7, this.zzdh);
    SafeParcelWriter.writeFloat(paramParcel, 8, this.zzdi);
    SafeParcelWriter.writeTypedArray(paramParcel, 9, this.zzdk, paramInt, false);
    SafeParcelWriter.writeFloat(paramParcel, 10, this.zzcm);
    SafeParcelWriter.writeFloat(paramParcel, 11, this.zzcn);
    SafeParcelWriter.writeFloat(paramParcel, 12, this.zzco);
    SafeParcelWriter.writeTypedArray(paramParcel, 13, this.zzdl, paramInt, false);
    SafeParcelWriter.writeFloat(paramParcel, 14, this.zzdj);
    SafeParcelWriter.writeFloat(paramParcel, 15, this.zzcp);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\internal\client\FaceParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */