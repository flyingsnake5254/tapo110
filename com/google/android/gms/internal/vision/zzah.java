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

@SafeParcelable.Class(creator="LineBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzah
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzah> CREATOR = new zzag();
  @SafeParcelable.Field(id=7)
  private final float zzdw;
  @SafeParcelable.Field(id=8)
  public final String zzek;
  @SafeParcelable.Field(id=2)
  public final zzao[] zzep;
  @SafeParcelable.Field(id=3)
  public final zzab zzeq;
  @SafeParcelable.Field(id=4)
  private final zzab zzer;
  @SafeParcelable.Field(id=5)
  private final zzab zzes;
  @SafeParcelable.Field(id=6)
  public final String zzet;
  @SafeParcelable.Field(id=9)
  private final int zzeu;
  @SafeParcelable.Field(id=10)
  public final boolean zzev;
  @SafeParcelable.Field(id=11)
  public final int zzew;
  @SafeParcelable.Field(id=12)
  public final int zzex;
  
  @SafeParcelable.Constructor
  public zzah(@SafeParcelable.Param(id=2) zzao[] paramArrayOfzzao, @SafeParcelable.Param(id=3) zzab paramzzab1, @SafeParcelable.Param(id=4) zzab paramzzab2, @SafeParcelable.Param(id=5) zzab paramzzab3, @SafeParcelable.Param(id=6) String paramString1, @SafeParcelable.Param(id=7) float paramFloat, @SafeParcelable.Param(id=8) String paramString2, @SafeParcelable.Param(id=9) int paramInt1, @SafeParcelable.Param(id=10) boolean paramBoolean, @SafeParcelable.Param(id=11) int paramInt2, @SafeParcelable.Param(id=12) int paramInt3)
  {
    this.zzep = paramArrayOfzzao;
    this.zzeq = paramzzab1;
    this.zzer = paramzzab2;
    this.zzes = paramzzab3;
    this.zzet = paramString1;
    this.zzdw = paramFloat;
    this.zzek = paramString2;
    this.zzeu = paramInt1;
    this.zzev = paramBoolean;
    this.zzew = paramInt2;
    this.zzex = paramInt3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, this.zzep, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzeq, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzer, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, this.zzes, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzet, false);
    SafeParcelWriter.writeFloat(paramParcel, 7, this.zzdw);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzek, false);
    SafeParcelWriter.writeInt(paramParcel, 9, this.zzeu);
    SafeParcelWriter.writeBoolean(paramParcel, 10, this.zzev);
    SafeParcelWriter.writeInt(paramParcel, 11, this.zzew);
    SafeParcelWriter.writeInt(paramParcel, 12, this.zzex);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */