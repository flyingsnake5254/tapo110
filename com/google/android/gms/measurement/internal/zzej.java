package com.google.android.gms.measurement.internal;

import android.util.Log;

final class zzej
  implements Runnable
{
  zzej(zzem paramzzem, int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {}
  
  public final void run()
  {
    zzfb localzzfb = this.zzf.zzs.zzd();
    if (localzzfb.zzu())
    {
      if (zzem.zzq(this.zzf) == 0) {
        if (this.zzf.zzs.zzc().zzh())
        {
          localObject1 = this.zzf;
          ((zzgn)localObject1).zzs.zzat();
          zzem.zzr((zzem)localObject1, 'C');
        }
        else
        {
          localObject1 = this.zzf;
          ((zzgn)localObject1).zzs.zzat();
          zzem.zzr((zzem)localObject1, 'c');
        }
      }
      if (zzem.zzs(this.zzf) < 0L)
      {
        localObject1 = this.zzf;
        ((zzgn)localObject1).zzs.zzc().zzf();
        zzem.zzt((zzem)localObject1, 42004L);
      }
      char c1 = "01VDIWEA?".charAt(this.zza);
      char c2 = zzem.zzq(this.zzf);
      long l = zzem.zzs(this.zzf);
      Object localObject2 = zzem.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
      Object localObject1 = new StringBuilder(String.valueOf(localObject2).length() + 24);
      ((StringBuilder)localObject1).append("2");
      ((StringBuilder)localObject1).append(c1);
      ((StringBuilder)localObject1).append(c2);
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = localObject2;
      if (((String)localObject2).length() > 1024) {
        localObject1 = this.zzb.substring(0, 1024);
      }
      localObject2 = localzzfb.zzb;
      if (localObject2 != null) {
        ((zzez)localObject2).zza((String)localObject1, 1L);
      }
      return;
    }
    Log.println(6, this.zzf.zzn(), "Persisted config not initialized. Not logging error/warn");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */