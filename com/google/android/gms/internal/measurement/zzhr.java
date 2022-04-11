package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

public final class zzhr
{
  final String zza = null;
  final Uri zzb;
  final String zzc;
  final String zzd;
  final boolean zze;
  final boolean zzf;
  final boolean zzg;
  final boolean zzh;
  @Nullable
  final zzhy<Context, Boolean> zzi;
  
  public zzhr(Uri paramUri)
  {
    this.zzb = paramUri;
    this.zzc = "";
    this.zzd = "";
    this.zze = false;
    this.zzf = false;
    this.zzg = false;
    this.zzh = false;
    this.zzi = null;
  }
  
  public final zzht<Long> zza(String paramString, long paramLong)
  {
    return new zzhn(this, paramString, Long.valueOf(paramLong), true);
  }
  
  public final zzht<Boolean> zzb(String paramString, boolean paramBoolean)
  {
    return new zzho(this, paramString, Boolean.valueOf(paramBoolean), true);
  }
  
  public final zzht<Double> zzc(String paramString, double paramDouble)
  {
    return new zzhp(this, "measurement.test.double_flag", Double.valueOf(-3.0D), true);
  }
  
  public final zzht<String> zzd(String paramString1, String paramString2)
  {
    return new zzhq(this, paramString1, paramString2, true);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzhr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */