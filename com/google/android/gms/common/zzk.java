package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="GoogleCertificatesQueryCreator")
public final class zzk
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzk> CREATOR = new zzl();
  @SafeParcelable.Field(getter="getAllowTestKeys", id=3)
  private final boolean zzaa;
  @SafeParcelable.Field(defaultValue="false", getter="getForbidTestKeys", id=4)
  private final boolean zzab;
  @SafeParcelable.Field(getter="getCallingPackage", id=1)
  private final String zzy;
  @Nullable
  @SafeParcelable.Field(getter="getCallingCertificateBinder", id=2, type="android.os.IBinder")
  private final zze zzz;
  
  @SafeParcelable.Constructor
  zzk(@SafeParcelable.Param(id=1) String paramString, @SafeParcelable.Param(id=2) @Nullable IBinder paramIBinder, @SafeParcelable.Param(id=3) boolean paramBoolean1, @SafeParcelable.Param(id=4) boolean paramBoolean2)
  {
    this.zzy = paramString;
    this.zzz = zza(paramIBinder);
    this.zzaa = paramBoolean1;
    this.zzab = paramBoolean2;
  }
  
  zzk(String paramString, @Nullable zze paramzze, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzy = paramString;
    this.zzz = paramzze;
    this.zzaa = paramBoolean1;
    this.zzab = paramBoolean2;
  }
  
  @Nullable
  private static zze zza(@Nullable IBinder paramIBinder)
  {
    Object localObject = null;
    if (paramIBinder == null) {
      return null;
    }
    try
    {
      paramIBinder = zzj.zzb(paramIBinder).zzb();
      if (paramIBinder == null) {
        paramIBinder = null;
      } else {
        paramIBinder = (byte[])ObjectWrapper.unwrap(paramIBinder);
      }
      if (paramIBinder != null)
      {
        paramIBinder = new zzf(paramIBinder);
      }
      else
      {
        Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
        paramIBinder = (IBinder)localObject;
      }
      return paramIBinder;
    }
    catch (RemoteException paramIBinder)
    {
      Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", paramIBinder);
    }
    return null;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzy, false);
    Object localObject = this.zzz;
    if (localObject == null)
    {
      Log.w("GoogleCertificatesQuery", "certificate binder is null");
      localObject = null;
    }
    else
    {
      localObject = ((zzb)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject, false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzaa);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzab);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */