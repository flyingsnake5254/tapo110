package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="AuthAccountResultCreator")
public final class zaa
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<zaa> CREATOR = new zab();
  @SafeParcelable.VersionField(id=1)
  private final int zalf;
  @SafeParcelable.Field(getter="getConnectionResultCode", id=2)
  private int zarz;
  @SafeParcelable.Field(getter="getRawAuthResolutionIntent", id=3)
  private Intent zasa;
  
  public zaa()
  {
    this(0, null);
  }
  
  @SafeParcelable.Constructor
  zaa(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) Intent paramIntent)
  {
    this.zalf = paramInt1;
    this.zarz = paramInt2;
    this.zasa = paramIntent;
  }
  
  private zaa(int paramInt, Intent paramIntent)
  {
    this(2, 0, null);
  }
  
  public final Status getStatus()
  {
    if (this.zarz == 0) {
      return Status.RESULT_SUCCESS;
    }
    return Status.RESULT_CANCELED;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zarz);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zasa, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\signin\internal\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */