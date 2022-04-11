package com.google.android.gms.measurement.internal;

abstract class zzf
  extends zze
{
  private boolean zza;
  
  zzf(zzfu paramzzfu)
  {
    super(paramzzfu);
    this.zzs.zzJ();
  }
  
  final boolean zza()
  {
    return this.zza;
  }
  
  protected final void zzb()
  {
    if (zza()) {
      return;
    }
    throw new IllegalStateException("Not initialized");
  }
  
  public final void zzc()
  {
    if (!this.zza)
    {
      if (!zze())
      {
        this.zzs.zzK();
        this.zza = true;
      }
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
  
  public final void zzd()
  {
    if (!this.zza)
    {
      zzf();
      this.zzs.zzK();
      this.zza = true;
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
  
  protected abstract boolean zze();
  
  protected void zzf() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */