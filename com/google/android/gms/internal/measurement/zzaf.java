package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzaf
  implements zzap
{
  private final boolean zza;
  
  public zzaf(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      this.zza = false;
      return;
    }
    this.zza = paramBoolean.booleanValue();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzaf)) {
      return false;
    }
    paramObject = (zzaf)paramObject;
    return this.zza == ((zzaf)paramObject).zza;
  }
  
  public final int hashCode()
  {
    return Boolean.valueOf(this.zza).hashCode();
  }
  
  public final String toString()
  {
    return String.valueOf(this.zza);
  }
  
  public final zzap zzbK(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    if ("toString".equals(paramString)) {
      return new zzat(Boolean.toString(this.zza));
    }
    throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[] { Boolean.toString(this.zza), paramString }));
  }
  
  public final String zzc()
  {
    return Boolean.toString(this.zza);
  }
  
  public final Double zzd()
  {
    double d;
    if (true != this.zza) {
      d = 0.0D;
    } else {
      d = 1.0D;
    }
    return Double.valueOf(d);
  }
  
  public final Boolean zze()
  {
    return Boolean.valueOf(this.zza);
  }
  
  public final Iterator<zzap> zzf()
  {
    return null;
  }
  
  public final zzap zzt()
  {
    return new zzaf(Boolean.valueOf(this.zza));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */