package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class zzen
{
  @NonNull
  public final String zza;
  @NonNull
  public final String zzb;
  public final long zzc;
  @NonNull
  public final Bundle zzd;
  
  public zzen(@NonNull String paramString1, @NonNull String paramString2, @Nullable Bundle paramBundle, long paramLong)
  {
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzd = paramBundle;
    this.zzc = paramLong;
  }
  
  public static zzen zza(zzas paramzzas)
  {
    return new zzen(paramzzas.zza, paramzzas.zzc, paramzzas.zzb.zzf(), paramzzas.zzd);
  }
  
  public final String toString()
  {
    String str1 = this.zzb;
    String str2 = this.zza;
    String str3 = String.valueOf(this.zzd);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 21 + String.valueOf(str2).length() + str3.length());
    localStringBuilder.append("origin=");
    localStringBuilder.append(str1);
    localStringBuilder.append(",name=");
    localStringBuilder.append(str2);
    localStringBuilder.append(",params=");
    localStringBuilder.append(str3);
    return localStringBuilder.toString();
  }
  
  public final zzas zzb()
  {
    return new zzas(this.zza, new zzaq(new Bundle(this.zzd)), this.zzb, this.zzc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */