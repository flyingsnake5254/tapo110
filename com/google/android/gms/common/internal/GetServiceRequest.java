package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@KeepForSdk
@SafeParcelable.Class(creator="GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
public class GetServiceRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzd();
  @SafeParcelable.VersionField(id=1)
  private final int version;
  @SafeParcelable.Field(id=2)
  private final int zzdg;
  @SafeParcelable.Field(id=3)
  private int zzdh;
  @SafeParcelable.Field(id=5)
  IBinder zzdi;
  @SafeParcelable.Field(id=6)
  Scope[] zzdj;
  @SafeParcelable.Field(id=7)
  Bundle zzdk;
  @SafeParcelable.Field(id=8)
  Account zzdl;
  @SafeParcelable.Field(id=10)
  Feature[] zzdm;
  @SafeParcelable.Field(id=11)
  Feature[] zzdn;
  @SafeParcelable.Field(id=12)
  private boolean zzdo;
  @SafeParcelable.Field(id=4)
  String zzy;
  
  public GetServiceRequest(int paramInt)
  {
    this.version = 4;
    this.zzdh = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    this.zzdg = paramInt;
    this.zzdo = true;
  }
  
  @SafeParcelable.Constructor
  GetServiceRequest(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) int paramInt3, @SafeParcelable.Param(id=4) String paramString, @SafeParcelable.Param(id=5) IBinder paramIBinder, @SafeParcelable.Param(id=6) Scope[] paramArrayOfScope, @SafeParcelable.Param(id=7) Bundle paramBundle, @SafeParcelable.Param(id=8) Account paramAccount, @SafeParcelable.Param(id=10) Feature[] paramArrayOfFeature1, @SafeParcelable.Param(id=11) Feature[] paramArrayOfFeature2, @SafeParcelable.Param(id=12) boolean paramBoolean)
  {
    this.version = paramInt1;
    this.zzdg = paramInt2;
    this.zzdh = paramInt3;
    if ("com.google.android.gms".equals(paramString)) {
      this.zzy = "com.google.android.gms";
    } else {
      this.zzy = paramString;
    }
    if (paramInt1 < 2)
    {
      paramString = null;
      if (paramIBinder != null) {
        paramString = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(paramIBinder));
      }
      this.zzdl = paramString;
    }
    else
    {
      this.zzdi = paramIBinder;
      this.zzdl = paramAccount;
    }
    this.zzdj = paramArrayOfScope;
    this.zzdk = paramBundle;
    this.zzdm = paramArrayOfFeature1;
    this.zzdn = paramArrayOfFeature2;
    this.zzdo = paramBoolean;
  }
  
  @KeepForSdk
  public Bundle getExtraArgs()
  {
    return this.zzdk;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.version);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzdg);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzdh);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzy, false);
    SafeParcelWriter.writeIBinder(paramParcel, 5, this.zzdi, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 6, this.zzdj, paramInt, false);
    SafeParcelWriter.writeBundle(paramParcel, 7, this.zzdk, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, this.zzdl, paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 10, this.zzdm, paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 11, this.zzdn, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 12, this.zzdo);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\GetServiceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */