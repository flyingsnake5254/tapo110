package com.google.android.gms.internal.mlkit_common;

public class zzfq
{
  private static final zzen zza = ;
  private zzdv zzb;
  private volatile zzgh zzc;
  private volatile zzdv zzd;
  
  private final zzgh zzb(zzgh paramzzgh)
  {
    if (this.zzc == null) {
      try
      {
        if (this.zzc != null) {
          break label59;
        }
        try
        {
          this.zzc = paramzzgh;
          this.zzd = zzdv.zza;
        }
        catch (zzfh localzzfh)
        {
          this.zzc = paramzzgh;
          this.zzd = zzdv.zza;
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
    if (!(paramObject instanceof zzfq)) {
      return false;
    }
    zzfq localzzfq = (zzfq)paramObject;
    zzgh localzzgh = this.zzc;
    paramObject = localzzfq.zzc;
    if ((localzzgh == null) && (paramObject == null)) {
      return zzc().equals(localzzfq.zzc());
    }
    if ((localzzgh != null) && (paramObject != null)) {
      return localzzgh.equals(paramObject);
    }
    if (localzzgh != null) {
      return localzzgh.equals(localzzfq.zzb(localzzgh.zzi()));
    }
    return zzb(((zzgj)paramObject).zzi()).equals(paramObject);
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final zzgh zza(zzgh paramzzgh)
  {
    zzgh localzzgh = this.zzc;
    this.zzb = null;
    this.zzd = null;
    this.zzc = paramzzgh;
    return localzzgh;
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
  
  public final zzdv zzc()
  {
    if (this.zzd != null) {
      return this.zzd;
    }
    try
    {
      if (this.zzd != null)
      {
        localzzdv = this.zzd;
        return localzzdv;
      }
      if (this.zzc == null) {
        this.zzd = zzdv.zza;
      } else {
        this.zzd = this.zzc.zze();
      }
      zzdv localzzdv = this.zzd;
      return localzzdv;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzfq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */