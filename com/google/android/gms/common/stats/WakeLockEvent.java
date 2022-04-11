package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;

@SafeParcelable.Class(creator="WakeLockEventCreator")
public final class WakeLockEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
  private long durationMillis;
  @SafeParcelable.VersionField(id=1)
  private final int versionCode;
  @SafeParcelable.Field(getter="getTimeMillis", id=2)
  private final long zzfo;
  @SafeParcelable.Field(getter="getEventType", id=11)
  private int zzfp;
  @SafeParcelable.Field(getter="getWakeLockName", id=4)
  private final String zzfq;
  @SafeParcelable.Field(getter="getSecondaryWakeLockName", id=10)
  private final String zzfr;
  @SafeParcelable.Field(getter="getCodePackage", id=17)
  private final String zzfs;
  @SafeParcelable.Field(getter="getWakeLockType", id=5)
  private final int zzft;
  @SafeParcelable.Field(getter="getCallingPackages", id=6)
  private final List<String> zzfu;
  @SafeParcelable.Field(getter="getEventKey", id=12)
  private final String zzfv;
  @SafeParcelable.Field(getter="getElapsedRealtime", id=8)
  private final long zzfw;
  @SafeParcelable.Field(getter="getDeviceState", id=14)
  private int zzfx;
  @SafeParcelable.Field(getter="getHostPackage", id=13)
  private final String zzfy;
  @SafeParcelable.Field(getter="getBeginPowerPercentage", id=15)
  private final float zzfz;
  @SafeParcelable.Field(getter="getTimeout", id=16)
  private final long zzga;
  @SafeParcelable.Field(getter="getAcquiredWithTimeout", id=18)
  private final boolean zzgb;
  
  @SafeParcelable.Constructor
  WakeLockEvent(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) long paramLong1, @SafeParcelable.Param(id=11) int paramInt2, @SafeParcelable.Param(id=4) String paramString1, @SafeParcelable.Param(id=5) int paramInt3, @SafeParcelable.Param(id=6) List<String> paramList, @SafeParcelable.Param(id=12) String paramString2, @SafeParcelable.Param(id=8) long paramLong2, @SafeParcelable.Param(id=14) int paramInt4, @SafeParcelable.Param(id=10) String paramString3, @SafeParcelable.Param(id=13) String paramString4, @SafeParcelable.Param(id=15) float paramFloat, @SafeParcelable.Param(id=16) long paramLong3, @SafeParcelable.Param(id=17) String paramString5, @SafeParcelable.Param(id=18) boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.zzfo = paramLong1;
    this.zzfp = paramInt2;
    this.zzfq = paramString1;
    this.zzfr = paramString3;
    this.zzfs = paramString5;
    this.zzft = paramInt3;
    this.durationMillis = -1L;
    this.zzfu = paramList;
    this.zzfv = paramString2;
    this.zzfw = paramLong2;
    this.zzfx = paramInt4;
    this.zzfy = paramString4;
    this.zzfz = paramFloat;
    this.zzga = paramLong3;
    this.zzgb = paramBoolean;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5, boolean paramBoolean)
  {
    this(2, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3, paramString5, paramBoolean);
  }
  
  public final int getEventType()
  {
    return this.zzfp;
  }
  
  public final long getTimeMillis()
  {
    return this.zzfo;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeLong(paramParcel, 2, getTimeMillis());
    SafeParcelWriter.writeString(paramParcel, 4, this.zzfq, false);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzft);
    SafeParcelWriter.writeStringList(paramParcel, 6, this.zzfu, false);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zzfw);
    SafeParcelWriter.writeString(paramParcel, 10, this.zzfr, false);
    SafeParcelWriter.writeInt(paramParcel, 11, getEventType());
    SafeParcelWriter.writeString(paramParcel, 12, this.zzfv, false);
    SafeParcelWriter.writeString(paramParcel, 13, this.zzfy, false);
    SafeParcelWriter.writeInt(paramParcel, 14, this.zzfx);
    SafeParcelWriter.writeFloat(paramParcel, 15, this.zzfz);
    SafeParcelWriter.writeLong(paramParcel, 16, this.zzga);
    SafeParcelWriter.writeString(paramParcel, 17, this.zzfs, false);
    SafeParcelWriter.writeBoolean(paramParcel, 18, this.zzgb);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final long zzu()
  {
    return this.durationMillis;
  }
  
  public final String zzv()
  {
    String str = this.zzfq;
    int i = this.zzft;
    Object localObject1 = this.zzfu;
    Object localObject2 = "";
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = TextUtils.join(",", (Iterable)localObject1);
    }
    int j = this.zzfx;
    Object localObject3 = this.zzfr;
    Object localObject4 = localObject3;
    if (localObject3 == null) {
      localObject4 = "";
    }
    Object localObject5 = this.zzfy;
    localObject3 = localObject5;
    if (localObject5 == null) {
      localObject3 = "";
    }
    float f = this.zzfz;
    localObject5 = this.zzfs;
    if (localObject5 != null) {
      localObject2 = localObject5;
    }
    boolean bool = this.zzgb;
    localObject5 = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(localObject1).length() + String.valueOf(localObject4).length() + String.valueOf(localObject3).length() + String.valueOf(localObject2).length());
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(str);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(i);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject1);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(j);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject4);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject3);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(f);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject2);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(bool);
    return ((StringBuilder)localObject5).toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\stats\WakeLockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */