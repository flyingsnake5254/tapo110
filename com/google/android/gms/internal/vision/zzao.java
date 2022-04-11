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

@SafeParcelable.Class(creator="WordBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzao
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzao> CREATOR = new zzar();
  @SafeParcelable.Field(id=6)
  private final float zzdw;
  @SafeParcelable.Field(id=7)
  public final String zzek;
  @SafeParcelable.Field(id=3)
  public final zzab zzeq;
  @SafeParcelable.Field(id=4)
  private final zzab zzer;
  @SafeParcelable.Field(id=5)
  public final String zzet;
  @SafeParcelable.Field(id=2)
  private final zzal[] zzez;
  @SafeParcelable.Field(id=8)
  private final boolean zzfa;
  
  @SafeParcelable.Constructor
  public zzao(@SafeParcelable.Param(id=2) zzal[] paramArrayOfzzal, @SafeParcelable.Param(id=3) zzab paramzzab1, @SafeParcelable.Param(id=4) zzab paramzzab2, @SafeParcelable.Param(id=5) String paramString1, @SafeParcelable.Param(id=6) float paramFloat, @SafeParcelable.Param(id=7) String paramString2, @SafeParcelable.Param(id=8) boolean paramBoolean)
  {
    this.zzez = paramArrayOfzzal;
    this.zzeq = paramzzab1;
    this.zzer = paramzzab2;
    this.zzet = paramString1;
    this.zzdw = paramFloat;
    this.zzek = paramString2;
    this.zzfa = paramBoolean;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, this.zzez, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzeq, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzer, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzet, false);
    SafeParcelWriter.writeFloat(paramParcel, 6, this.zzdw);
    SafeParcelWriter.writeString(paramParcel, 7, this.zzek, false);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzfa);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */