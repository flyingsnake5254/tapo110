package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="SignInRequestCreator")
public final class zah
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zah> CREATOR = new zai();
  @SafeParcelable.VersionField(id=1)
  private final int zalf;
  @SafeParcelable.Field(getter="getResolveAccountRequest", id=2)
  private final ResolveAccountRequest zasd;
  
  @SafeParcelable.Constructor
  zah(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) ResolveAccountRequest paramResolveAccountRequest)
  {
    this.zalf = paramInt;
    this.zasd = paramResolveAccountRequest;
  }
  
  public zah(ResolveAccountRequest paramResolveAccountRequest)
  {
    this(1, paramResolveAccountRequest);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zasd, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\signin\internal\zah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */