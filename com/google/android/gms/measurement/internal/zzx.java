package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzes;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzog;

final class zzx
  extends zzw
{
  private final zzes zzh;
  
  zzx(zzy paramzzy, String paramString, int paramInt, zzes paramzzes)
  {
    super(paramString, paramInt);
    this.zzh = paramzzes;
  }
  
  final int zza()
  {
    return this.zzh.zzb();
  }
  
  final boolean zzb()
  {
    return true;
  }
  
  final boolean zzc()
  {
    return false;
  }
  
  final boolean zzd(Long paramLong1, Long paramLong2, zzgh paramzzgh, boolean paramBoolean)
  {
    zzog.zzb();
    boolean bool1 = this.zza.zzs.zzc().zzn(this.zzb, zzea.zzX);
    boolean bool2 = this.zzh.zze();
    boolean bool3 = this.zzh.zzf();
    boolean bool4 = this.zzh.zzh();
    int i;
    if ((!bool2) && (!bool3) && (!bool4)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if ((paramBoolean) && (i == 0))
    {
      paramLong2 = this.zza.zzs.zzau().zzk();
      i = this.zzc;
      paramLong1 = (Long)localObject2;
      if (this.zzh.zza()) {
        paramLong1 = Integer.valueOf(this.zzh.zzb());
      }
      paramLong2.zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(i), paramLong1);
      return true;
    }
    localObject2 = this.zzh.zzd();
    bool3 = ((zzel)localObject2).zzf();
    if (paramzzgh.zzf())
    {
      if (!((zzel)localObject2).zzc())
      {
        this.zza.zzs.zzau().zze().zzb("No number filter for long property. property", this.zza.zzs.zzm().zze(paramzzgh.zzc()));
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = zzw.zze(zzw.zzg(paramzzgh.zzg(), ((zzel)localObject2).zzd()), bool3);
      }
    }
    else if (paramzzgh.zzh())
    {
      if (!((zzel)localObject2).zzc())
      {
        this.zza.zzs.zzau().zze().zzb("No number filter for double property. property", this.zza.zzs.zzm().zze(paramzzgh.zzc()));
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = zzw.zze(zzw.zzh(paramzzgh.zzi(), ((zzel)localObject2).zzd()), bool3);
      }
    }
    else if (paramzzgh.zzd())
    {
      if (!((zzel)localObject2).zza())
      {
        if (!((zzel)localObject2).zzc())
        {
          this.zza.zzs.zzau().zze().zzb("No string or number filter defined. property", this.zza.zzs.zzm().zze(paramzzgh.zzc()));
          localObject2 = localObject1;
        }
        else if (zzkp.zzl(paramzzgh.zze()))
        {
          localObject2 = zzw.zze(zzw.zzi(paramzzgh.zze(), ((zzel)localObject2).zzd()), bool3);
        }
        else
        {
          this.zza.zzs.zzau().zze().zzc("Invalid user property value for Numeric number filter. property, value", this.zza.zzs.zzm().zze(paramzzgh.zzc()), paramzzgh.zze());
          localObject2 = localObject1;
        }
      }
      else {
        localObject2 = zzw.zze(zzw.zzf(paramzzgh.zze(), ((zzel)localObject2).zzb(), this.zza.zzs.zzau()), bool3);
      }
    }
    else
    {
      this.zza.zzs.zzau().zze().zzb("User property has no value, property", this.zza.zzs.zzm().zze(paramzzgh.zzc()));
      localObject2 = localObject1;
    }
    zzek localzzek = this.zza.zzs.zzau().zzk();
    if (localObject2 == null) {
      localObject1 = "null";
    } else {
      localObject1 = localObject2;
    }
    localzzek.zzb("Property filter result", localObject1);
    if (localObject2 == null) {
      return false;
    }
    this.zzd = Boolean.TRUE;
    if ((bool4) && (!((Boolean)localObject2).booleanValue())) {
      return true;
    }
    if ((!paramBoolean) || (this.zzh.zze())) {
      this.zze = ((Boolean)localObject2);
    }
    if ((((Boolean)localObject2).booleanValue()) && (i != 0) && (paramzzgh.zza()))
    {
      long l1 = paramzzgh.zzb();
      if (paramLong1 != null) {
        l1 = paramLong1.longValue();
      }
      long l2 = l1;
      if (bool1)
      {
        l2 = l1;
        if (this.zzh.zze())
        {
          l2 = l1;
          if (!this.zzh.zzf())
          {
            l2 = l1;
            if (paramLong2 != null) {
              l2 = paramLong2.longValue();
            }
          }
        }
      }
      if (this.zzh.zzf()) {
        this.zzg = Long.valueOf(l2);
      } else {
        this.zzf = Long.valueOf(l2);
      }
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */