package com.google.android.gms.vision.face.internal.client;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="ContourParcelCreator")
@SafeParcelable.Reserved({1})
public final class zza
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zza> CREATOR = new zzc();
  @SafeParcelable.Field(id=3)
  public final int type;
  @SafeParcelable.Field(id=2)
  public final PointF[] zzdf;
  
  @SafeParcelable.Constructor
  public zza(@SafeParcelable.Param(id=2) PointF[] paramArrayOfPointF, @SafeParcelable.Param(id=3) int paramInt)
  {
    this.zzdf = paramArrayOfPointF;
    this.type = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, this.zzdf, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.type);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\internal\client\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */