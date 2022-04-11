package com.google.android.gms.measurement.internal;

final class zzgl
  implements Runnable
{
  zzgl(zzgm paramzzgm, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public final void run()
  {
    Object localObject = this.zza;
    if (localObject == null)
    {
      zzgm.zzx(this.zze).zzN().zzx().zzn(this.zzb, null);
      return;
    }
    localObject = new zzid(this.zzc, (String)localObject, this.zzd);
    zzgm.zzx(this.zze).zzN().zzx().zzn(this.zzb, (zzid)localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzgl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */