package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Objects;
import javax.annotation.Nullable;

final class zzgx
  extends zzhs
{
  private final Context zza;
  private final zzib<zzhz<zzhi>> zzb;
  
  zzgx(Context paramContext, @Nullable zzib<zzhz<zzhi>> paramzzib)
  {
    Objects.requireNonNull(paramContext, "Null context");
    this.zza = paramContext;
    this.zzb = paramzzib;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof zzhs))
    {
      zzhs localzzhs = (zzhs)paramObject;
      if (this.zza.equals(localzzhs.zza()))
      {
        paramObject = this.zzb;
        if (paramObject == null ? localzzhs.zzb() == null : paramObject.equals(localzzhs.zzb())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = this.zza.hashCode();
    zzib localzzib = this.zzb;
    int j;
    if (localzzib == null) {
      j = 0;
    } else {
      j = localzzib.hashCode();
    }
    return (i ^ 0xF4243) * 1000003 ^ j;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(this.zza);
    String str2 = String.valueOf(this.zzb);
    StringBuilder localStringBuilder = new StringBuilder(str1.length() + 46 + str2.length());
    localStringBuilder.append("FlagsContext{context=");
    localStringBuilder.append(str1);
    localStringBuilder.append(", hermeticFileOverrides=");
    localStringBuilder.append(str2);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  final Context zza()
  {
    return this.zza;
  }
  
  @Nullable
  final zzib<zzhz<zzhi>> zzb()
  {
    return this.zzb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */