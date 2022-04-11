package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzaq
  implements zzap
{
  private final String zza;
  private final ArrayList<zzap> zzb;
  
  public zzaq(String paramString, List<zzap> paramList)
  {
    this.zza = paramString;
    paramString = new ArrayList();
    this.zzb = paramString;
    paramString.addAll(paramList);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzaq)) {
      return false;
    }
    zzaq localzzaq = (zzaq)paramObject;
    paramObject = this.zza;
    if (paramObject != null ? !((String)paramObject).equals(localzzaq.zza) : localzzaq.zza != null) {
      return false;
    }
    return this.zzb.equals(localzzaq.zzb);
  }
  
  public final int hashCode()
  {
    String str = this.zza;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.zzb.hashCode();
  }
  
  public final String zzb()
  {
    return this.zza;
  }
  
  public final zzap zzbK(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    throw new IllegalStateException("Statement is not an evaluated entity");
  }
  
  public final String zzc()
  {
    throw new IllegalStateException("Statement cannot be cast as String");
  }
  
  public final Double zzd()
  {
    throw new IllegalStateException("Statement cannot be cast as Double");
  }
  
  public final Boolean zze()
  {
    throw new IllegalStateException("Statement cannot be cast as Boolean");
  }
  
  public final Iterator<zzap> zzf()
  {
    return null;
  }
  
  public final ArrayList<zzap> zzg()
  {
    return this.zzb;
  }
  
  public final zzap zzt()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */