package com.google.android.gms.tasks;

public class CancellationTokenSource
{
  private final zza zzc = new zza();
  
  public void cancel()
  {
    this.zzc.cancel();
  }
  
  public CancellationToken getToken()
  {
    return this.zzc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\tasks\CancellationTokenSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */