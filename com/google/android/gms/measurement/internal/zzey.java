package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzey
{
  private final String zzb;
  private final long zzc;
  private boolean zzd;
  private long zze;
  
  public zzey(zzfb paramzzfb, String paramString, long paramLong)
  {
    Preconditions.checkNotEmpty(paramString);
    this.zzb = paramString;
    this.zzc = paramLong;
  }
  
  @WorkerThread
  public final long zza()
  {
    if (!this.zzd)
    {
      this.zzd = true;
      this.zze = this.zza.zzd().getLong(this.zzb, this.zzc);
    }
    return this.zze;
  }
  
  @WorkerThread
  public final void zzb(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.zza.zzd().edit();
    localEditor.putLong(this.zzb, paramLong);
    localEditor.apply();
    this.zze = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */