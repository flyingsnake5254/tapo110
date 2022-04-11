package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.SecureRandom;

public final class zzez
{
  @VisibleForTesting
  final String zza;
  private final String zzc;
  private final String zzd;
  private final long zze;
  
  @WorkerThread
  private final void zzc()
  {
    this.zzb.zzg();
    long l = this.zzb.zzs.zzay().currentTimeMillis();
    SharedPreferences.Editor localEditor = this.zzb.zzd().edit();
    localEditor.remove(this.zzc);
    localEditor.remove(this.zzd);
    localEditor.putLong(this.zza, l);
    localEditor.apply();
  }
  
  @WorkerThread
  private final long zzd()
  {
    return this.zzb.zzd().getLong(this.zza, 0L);
  }
  
  @WorkerThread
  public final void zza(String paramString, long paramLong)
  {
    this.zzb.zzg();
    if (zzd() == 0L) {
      zzc();
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    long l1 = this.zzb.zzd().getLong(this.zzc, 0L);
    if (l1 <= 0L)
    {
      paramString = this.zzb.zzd().edit();
      paramString.putString(this.zzd, str);
      paramString.putLong(this.zzc, 1L);
      paramString.apply();
      return;
    }
    paramLong = this.zzb.zzs.zzl().zzf().nextLong();
    long l2 = l1 + 1L;
    l1 = Long.MAX_VALUE / l2;
    paramString = this.zzb.zzd().edit();
    if ((paramLong & 0x7FFFFFFFFFFFFFFF) < l1) {
      paramString.putString(this.zzd, str);
    }
    paramString.putLong(this.zzc, l2);
    paramString.apply();
  }
  
  @WorkerThread
  public final Pair<String, Long> zzb()
  {
    this.zzb.zzg();
    this.zzb.zzg();
    long l1 = zzd();
    if (l1 == 0L)
    {
      zzc();
      l1 = 0L;
    }
    else
    {
      l1 = Math.abs(l1 - this.zzb.zzs.zzay().currentTimeMillis());
    }
    long l2 = this.zze;
    if (l1 < l2) {
      return null;
    }
    if (l1 > l2 + l2)
    {
      zzc();
      return null;
    }
    String str = this.zzb.zzd().getString(this.zzd, null);
    l1 = this.zzb.zzd().getLong(this.zzc, 0L);
    zzc();
    if ((str != null) && (l1 > 0L)) {
      return new Pair(str, Long.valueOf(l1));
    }
    return zzfb.zza;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */