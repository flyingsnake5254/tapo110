package com.google.android.gms.measurement.internal;

final class zziu
  extends zzal
{
  zziu(zzjk paramzzjk, zzgp paramzzgp)
  {
    super(paramzzgp);
  }
  
  public final void zza()
  {
    zzjk localzzjk = this.zza;
    localzzjk.zzg();
    if (!localzzjk.zzh()) {
      return;
    }
    localzzjk.zzs.zzau().zzk().zza("Inactivity, disconnecting from the service");
    localzzjk.zzF();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zziu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */