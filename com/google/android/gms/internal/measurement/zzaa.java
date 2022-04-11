package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;

public final class zzaa
{
  private String zza;
  private final long zzb;
  private final Map<String, Object> zzc;
  
  public zzaa(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    this.zza = paramString;
    this.zzb = paramLong;
    paramString = new HashMap();
    this.zzc = paramString;
    if (paramMap != null) {
      paramString.putAll(paramMap);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzaa)) {
      return false;
    }
    paramObject = (zzaa)paramObject;
    if (this.zzb != ((zzaa)paramObject).zzb) {
      return false;
    }
    if (!this.zza.equals(((zzaa)paramObject).zza)) {
      return false;
    }
    return this.zzc.equals(((zzaa)paramObject).zzc);
  }
  
  public final int hashCode()
  {
    int i = this.zza.hashCode();
    long l = this.zzb;
    return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.zzc.hashCode();
  }
  
  public final String toString()
  {
    String str1 = this.zza;
    long l = this.zzb;
    String str2 = String.valueOf(this.zzc);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 55 + str2.length());
    localStringBuilder.append("Event{name='");
    localStringBuilder.append(str1);
    localStringBuilder.append("', timestamp=");
    localStringBuilder.append(l);
    localStringBuilder.append(", params=");
    localStringBuilder.append(str2);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final long zza()
  {
    return this.zzb;
  }
  
  public final String zzb()
  {
    return this.zza;
  }
  
  public final void zzc(String paramString)
  {
    this.zza = paramString;
  }
  
  public final void zzd(String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      this.zzc.remove(paramString);
      return;
    }
    this.zzc.put(paramString, paramObject);
  }
  
  public final Object zze(String paramString)
  {
    if (this.zzc.containsKey(paramString)) {
      return this.zzc.get(paramString);
    }
    return null;
  }
  
  public final Map<String, Object> zzf()
  {
    return this.zzc;
  }
  
  public final zzaa zzg()
  {
    return new zzaa(this.zza, this.zzb, new HashMap(this.zzc));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */