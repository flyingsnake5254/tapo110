package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="SymbolBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzal
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzal> CREATOR = new zzak();
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SafeParcelWriter.finishObjectHeader(paramParcel, SafeParcelWriter.beginObjectHeader(paramParcel));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */