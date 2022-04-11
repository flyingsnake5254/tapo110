package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzag
  implements zzap
{
  private final zzap zza;
  private final String zzb;
  
  public zzag()
  {
    throw null;
  }
  
  public zzag(String paramString)
  {
    this.zza = zzap.zzf;
    this.zzb = paramString;
  }
  
  public zzag(String paramString, zzap paramzzap)
  {
    this.zza = paramzzap;
    this.zzb = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzag)) {
      return false;
    }
    String str = this.zzb;
    paramObject = (zzag)paramObject;
    return (str.equals(((zzag)paramObject).zzb)) && (this.zza.equals(((zzag)paramObject).zza));
  }
  
  public final int hashCode()
  {
    return this.zzb.hashCode() * 31 + this.zza.hashCode();
  }
  
  public final zzap zzb()
  {
    return this.zza;
  }
  
  public final zzap zzbK(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    throw new IllegalStateException("Control does not have functions");
  }
  
  public final String zzc()
  {
    throw new IllegalStateException("Control is not a String");
  }
  
  public final Double zzd()
  {
    throw new IllegalStateException("Control is not a double");
  }
  
  public final Boolean zze()
  {
    throw new IllegalStateException("Control is not a boolean");
  }
  
  public final Iterator<zzap> zzf()
  {
    return null;
  }
  
  public final String zzg()
  {
    return this.zzb;
  }
  
  public final zzap zzt()
  {
    return new zzag(this.zzb, this.zza.zzt());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */