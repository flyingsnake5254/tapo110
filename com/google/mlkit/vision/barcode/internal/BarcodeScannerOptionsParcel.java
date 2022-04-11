package com.google.mlkit.vision.barcode.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@SafeParcelable.Class(creator="BarcodeScannerOptionsParcelCreator")
public class BarcodeScannerOptionsParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<BarcodeScannerOptionsParcel> CREATOR = new e();
  @SafeParcelable.Field(id=1)
  public final int c;
  
  @SafeParcelable.Constructor
  public BarcodeScannerOptionsParcel(@SafeParcelable.Param(id=1) int paramInt)
  {
    this.c = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.c);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\internal\BarcodeScannerOptionsParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */