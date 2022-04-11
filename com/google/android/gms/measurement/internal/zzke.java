package com.google.android.gms.measurement.internal;

abstract class zzke
  extends zzkd
{
  private boolean zza;
  
  zzke(zzkn paramzzkn)
  {
    super(paramzzkn);
    this.zzf.zzL();
  }
  
  final boolean zzY()
  {
    return this.zza;
  }
  
  protected final void zzZ()
  {
    if (zzY()) {
      return;
    }
    throw new IllegalStateException("Not initialized");
  }
  
  protected abstract boolean zzaA();
  
  public final void zzaa()
  {
    if (!this.zza)
    {
      zzaA();
      this.zzf.zzM();
      this.zza = true;
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */