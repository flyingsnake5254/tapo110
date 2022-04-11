package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

public final class zzan
{
  final String zza;
  final String zzb;
  final String zzc;
  final long zzd;
  final long zze;
  final zzaq zzf;
  
  zzan(zzfu paramzzfu, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty(paramString3);
    this.zza = paramString2;
    this.zzb = paramString3;
    paramString3 = paramString1;
    if (true == TextUtils.isEmpty(paramString1)) {
      paramString3 = null;
    }
    this.zzc = paramString3;
    this.zzd = paramLong1;
    this.zze = paramLong2;
    if ((paramLong2 != 0L) && (paramLong2 > paramLong1)) {
      paramzzfu.zzau().zze().zzb("Event created with reverse previous/current timestamps. appId", zzem.zzl(paramString2));
    }
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      paramBundle = new Bundle(paramBundle);
      paramString2 = paramBundle.keySet().iterator();
      while (paramString2.hasNext())
      {
        paramString1 = (String)paramString2.next();
        if (paramString1 == null)
        {
          paramzzfu.zzau().zzb().zza("Param name can't be null");
          paramString2.remove();
        }
        else
        {
          paramString3 = paramzzfu.zzl().zzE(paramString1, paramBundle.get(paramString1));
          if (paramString3 == null)
          {
            paramzzfu.zzau().zze().zzb("Param value can't be null", paramzzfu.zzm().zzd(paramString1));
            paramString2.remove();
          }
          else
          {
            paramzzfu.zzl().zzL(paramBundle, paramString1, paramString3);
          }
        }
      }
      paramzzfu = new zzaq(paramBundle);
    }
    else
    {
      paramzzfu = new zzaq(new Bundle());
    }
    this.zzf = paramzzfu;
  }
  
  private zzan(zzfu paramzzfu, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, zzaq paramzzaq)
  {
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty(paramString3);
    Preconditions.checkNotNull(paramzzaq);
    this.zza = paramString2;
    this.zzb = paramString3;
    String str = paramString1;
    if (true == TextUtils.isEmpty(paramString1)) {
      str = null;
    }
    this.zzc = str;
    this.zzd = paramLong1;
    this.zze = paramLong2;
    if ((paramLong2 != 0L) && (paramLong2 > paramLong1)) {
      paramzzfu.zzau().zze().zzc("Event created with reverse previous/current timestamps. appId, name", zzem.zzl(paramString2), zzem.zzl(paramString3));
    }
    this.zzf = paramzzaq;
  }
  
  public final String toString()
  {
    String str1 = this.zza;
    String str2 = this.zzb;
    String str3 = String.valueOf(this.zzf);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 33 + String.valueOf(str2).length() + str3.length());
    localStringBuilder.append("Event{appId='");
    localStringBuilder.append(str1);
    localStringBuilder.append("', name='");
    localStringBuilder.append(str2);
    localStringBuilder.append("', params=");
    localStringBuilder.append(str3);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  final zzan zza(zzfu paramzzfu, long paramLong)
  {
    return new zzan(paramzzfu, this.zzc, this.zza, this.zzb, this.zzd, paramLong, this.zzf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */