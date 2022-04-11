package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
@SafeParcelable.Class(creator="StatusCreator")
public final class Status
  extends AbstractSafeParcelable
  implements Result, ReflectedParcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new zzb();
  @KeepForSdk
  public static final Status RESULT_CANCELED;
  @KeepForSdk
  public static final Status RESULT_DEAD_CLIENT;
  @KeepForSdk
  public static final Status RESULT_INTERNAL_ERROR;
  @KeepForSdk
  public static final Status RESULT_INTERRUPTED;
  @KeepForSdk
  @VisibleForTesting
  public static final Status RESULT_SUCCESS = new Status(0);
  @KeepForSdk
  public static final Status RESULT_TIMEOUT;
  private static final Status zzar;
  @SafeParcelable.VersionField(id=1000)
  private final int zzg;
  @SafeParcelable.Field(getter="getStatusCode", id=1)
  private final int zzh;
  @Nullable
  @SafeParcelable.Field(getter="getPendingIntent", id=3)
  private final PendingIntent zzi;
  @Nullable
  @SafeParcelable.Field(getter="getStatusMessage", id=2)
  private final String zzj;
  
  static
  {
    RESULT_INTERRUPTED = new Status(14);
    RESULT_INTERNAL_ERROR = new Status(8);
    RESULT_TIMEOUT = new Status(15);
    RESULT_CANCELED = new Status(16);
    zzar = new Status(17);
    RESULT_DEAD_CLIENT = new Status(18);
  }
  
  @KeepForSdk
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  @KeepForSdk
  @SafeParcelable.Constructor
  Status(@SafeParcelable.Param(id=1000) int paramInt1, @SafeParcelable.Param(id=1) int paramInt2, @Nullable @SafeParcelable.Param(id=2) String paramString, @Nullable @SafeParcelable.Param(id=3) PendingIntent paramPendingIntent)
  {
    this.zzg = paramInt1;
    this.zzh = paramInt2;
    this.zzj = paramString;
    this.zzi = paramPendingIntent;
  }
  
  @KeepForSdk
  public Status(int paramInt, @Nullable String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  @KeepForSdk
  public Status(int paramInt, @Nullable String paramString, @Nullable PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {
      return false;
    }
    paramObject = (Status)paramObject;
    return (this.zzg == ((Status)paramObject).zzg) && (this.zzh == ((Status)paramObject).zzh) && (Objects.equal(this.zzj, ((Status)paramObject).zzj)) && (Objects.equal(this.zzi, ((Status)paramObject).zzi));
  }
  
  public final PendingIntent getResolution()
  {
    return this.zzi;
  }
  
  @KeepForSdk
  public final Status getStatus()
  {
    return this;
  }
  
  public final int getStatusCode()
  {
    return this.zzh;
  }
  
  @Nullable
  public final String getStatusMessage()
  {
    return this.zzj;
  }
  
  @VisibleForTesting
  public final boolean hasResolution()
  {
    return this.zzi != null;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzg), Integer.valueOf(this.zzh), this.zzj, this.zzi });
  }
  
  public final boolean isCanceled()
  {
    return this.zzh == 16;
  }
  
  public final boolean isInterrupted()
  {
    return this.zzh == 14;
  }
  
  public final boolean isSuccess()
  {
    return this.zzh <= 0;
  }
  
  public final void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {
      return;
    }
    paramActivity.startIntentSenderForResult(this.zzi.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).add("statusCode", zzg()).add("resolution", this.zzi).toString();
  }
  
  @KeepForSdk
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getStatusCode());
    SafeParcelWriter.writeString(paramParcel, 2, getStatusMessage(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzi, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zzg);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final String zzg()
  {
    String str = this.zzj;
    if (str != null) {
      return str;
    }
    return CommonStatusCodes.getStatusCodeString(this.zzh);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */