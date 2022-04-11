package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfa
{
  private final String zzb;
  private boolean zzc;
  private String zzd;
  
  public zzfa(zzfb paramzzfb, String paramString1, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    this.zzb = paramString1;
  }
  
  @WorkerThread
  public final String zza()
  {
    if (!this.zzc)
    {
      this.zzc = true;
      this.zzd = this.zza.zzd().getString(this.zzb, null);
    }
    return this.zzd;
  }
  
  @WorkerThread
  public final void zzb(String paramString)
  {
    SharedPreferences.Editor localEditor = this.zza.zzd().edit();
    localEditor.putString(this.zzb, paramString);
    localEditor.apply();
    this.zzd = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */