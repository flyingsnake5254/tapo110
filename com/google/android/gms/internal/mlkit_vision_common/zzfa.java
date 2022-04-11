package com.google.android.gms.internal.mlkit_vision_common;

public class zzfa
{
  private static final zzeb zza = ;
  private zzdj zzb;
  private volatile zzfv zzc;
  private volatile zzdj zzd;
  
  private final zzfv zzb(zzfv paramzzfv)
  {
    if (this.zzc == null) {
      try
      {
        if (this.zzc != null) {
          break label59;
        }
        try
        {
          this.zzc = paramzzfv;
          this.zzd = zzdj.zza;
        }
        catch (zzev localzzev)
        {
          this.zzc = paramzzfv;
          this.zzd = zzdj.zza;
        }
      }
      finally {}
    }
    label59:
    return this.zzc;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzfa)) {
      return false;
    }
    paramObject = (zzfa)paramObject;
    zzfv localzzfv1 = this.zzc;
    zzfv localzzfv2 = ((zzfa)paramObject).zzc;
    if ((localzzfv1 == null) && (localzzfv2 == null)) {
      return zzc().equals(((zzfa)paramObject).zzc());
    }
    if ((localzzfv1 != null) && (localzzfv2 != null)) {
      return localzzfv1.equals(localzzfv2);
    }
    if (localzzfv1 != null) {
      return localzzfv1.equals(((zzfa)paramObject).zzb(localzzfv1.zzn()));
    }
    return zzb(localzzfv2.zzn()).equals(localzzfv2);
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final zzfv zza(zzfv paramzzfv)
  {
    zzfv localzzfv = this.zzc;
    this.zzb = null;
    this.zzd = null;
    this.zzc = paramzzfv;
    return localzzfv;
  }
  
  public final int zzb()
  {
    if (this.zzd != null) {
      return this.zzd.zza();
    }
    if (this.zzc != null) {
      return this.zzc.zzj();
    }
    return 0;
  }
  
  public final zzdj zzc()
  {
    if (this.zzd != null) {
      return this.zzd;
    }
    try
    {
      if (this.zzd != null)
      {
        localzzdj = this.zzd;
        return localzzdj;
      }
      if (this.zzc == null) {
        this.zzd = zzdj.zza;
      } else {
        this.zzd = this.zzc.zze();
      }
      zzdj localzzdj = this.zzd;
      return localzzdj;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */