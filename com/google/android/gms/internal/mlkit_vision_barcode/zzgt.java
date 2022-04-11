package com.google.android.gms.internal.mlkit_vision_barcode;

public class zzgt
{
  private static final zzfo zza = ;
  private zzew zzb;
  private volatile zzhk zzc;
  private volatile zzew zzd;
  
  private final zzhk zzb(zzhk paramzzhk)
  {
    if (this.zzc == null) {
      try
      {
        if (this.zzc != null) {
          break label59;
        }
        try
        {
          this.zzc = paramzzhk;
          this.zzd = zzew.zza;
        }
        catch (zzgk localzzgk)
        {
          this.zzc = paramzzhk;
          this.zzd = zzew.zza;
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
    if (!(paramObject instanceof zzgt)) {
      return false;
    }
    paramObject = (zzgt)paramObject;
    zzhk localzzhk1 = this.zzc;
    zzhk localzzhk2 = ((zzgt)paramObject).zzc;
    if ((localzzhk1 == null) && (localzzhk2 == null)) {
      return zzc().equals(((zzgt)paramObject).zzc());
    }
    if ((localzzhk1 != null) && (localzzhk2 != null)) {
      return localzzhk1.equals(localzzhk2);
    }
    if (localzzhk1 != null) {
      return localzzhk1.equals(((zzgt)paramObject).zzb(localzzhk1.zzo()));
    }
    return zzb(localzzhk2.zzo()).equals(localzzhk2);
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final zzhk zza(zzhk paramzzhk)
  {
    zzhk localzzhk = this.zzc;
    this.zzb = null;
    this.zzd = null;
    this.zzc = paramzzhk;
    return localzzhk;
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
  
  public final zzew zzc()
  {
    if (this.zzd != null) {
      return this.zzd;
    }
    try
    {
      if (this.zzd != null)
      {
        localzzew = this.zzd;
        return localzzew;
      }
      if (this.zzc == null) {
        this.zzd = zzew.zza;
      } else {
        this.zzd = this.zzc.zze();
      }
      zzew localzzew = this.zzd;
      return localzzew;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */