package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzew
{
  private final String zzb;
  private final boolean zzc;
  private boolean zzd;
  private boolean zze;
  
  public zzew(zzfb paramzzfb, String paramString, boolean paramBoolean)
  {
    Preconditions.checkNotEmpty(paramString);
    this.zzb = paramString;
    this.zzc = paramBoolean;
  }
  
  @WorkerThread
  public final boolean zza()
  {
    if (!this.zzd)
    {
      this.zzd = true;
      this.zze = this.zza.zzd().getBoolean(this.zzb, this.zzc);
    }
    return this.zze;
  }
  
  @WorkerThread
  public final void zzb(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.zza.zzd().edit();
    localEditor.putBoolean(this.zzb, paramBoolean);
    localEditor.apply();
    this.zze = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */