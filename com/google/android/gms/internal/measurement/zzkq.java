package com.google.android.gms.internal.measurement;

public class zzkq
{
  private static final zzjp zzb = ;
  protected volatile zzli zza;
  private volatile zzjd zzc;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzkq)) {
      return false;
    }
    zzkq localzzkq = (zzkq)paramObject;
    paramObject = this.zza;
    zzli localzzli = localzzkq.zza;
    if ((paramObject == null) && (localzzli == null)) {
      return zzb().equals(localzzkq.zzb());
    }
    if ((paramObject != null) && (localzzli != null)) {
      return paramObject.equals(localzzli);
    }
    if (paramObject != null)
    {
      localzzkq.zzc(((zzlj)paramObject).zzbL());
      return paramObject.equals(localzzkq.zza);
    }
    zzc(localzzli.zzbL());
    return this.zza.equals(localzzli);
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final int zza()
  {
    if (this.zzc != null) {
      return ((zzjb)this.zzc).zza.length;
    }
    if (this.zza != null) {
      return this.zza.zzbw();
    }
    return 0;
  }
  
  public final zzjd zzb()
  {
    if (this.zzc != null) {
      return this.zzc;
    }
    try
    {
      if (this.zzc != null)
      {
        localzzjd = this.zzc;
        return localzzjd;
      }
      if (this.zza == null) {
        this.zzc = zzjd.zzb;
      } else {
        this.zzc = this.zza.zzbo();
      }
      zzjd localzzjd = this.zzc;
      return localzzjd;
    }
    finally {}
  }
  
  protected final void zzc(zzli paramzzli)
  {
    if (this.zza != null) {
      return;
    }
    try
    {
      zzli localzzli = this.zza;
      if (localzzli == null)
      {
        try
        {
          this.zza = paramzzli;
          this.zzc = zzjd.zzb;
        }
        catch (zzkn localzzkn)
        {
          this.zza = paramzzli;
          this.zzc = zzjd.zzb;
        }
        return;
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzkq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */