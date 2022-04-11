package com.google.android.gms.measurement.internal;

abstract class zzgo
  extends zzgn
{
  private boolean zza;
  
  zzgo(zzfu paramzzfu)
  {
    super(paramzzfu);
    this.zzs.zzJ();
  }
  
  protected abstract boolean zza();
  
  protected void zzaz() {}
  
  final boolean zzu()
  {
    return this.zza;
  }
  
  protected final void zzv()
  {
    if (zzu()) {
      return;
    }
    throw new IllegalStateException("Not initialized");
  }
  
  public final void zzx()
  {
    if (!this.zza)
    {
      if (!zza())
      {
        this.zzs.zzK();
        this.zza = true;
      }
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
  
  public final void zzy()
  {
    if (!this.zza)
    {
      zzaz();
      this.zzs.zzK();
      this.zza = true;
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */