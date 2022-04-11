package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzdk
  implements zzdj
{
  public final int zzb(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (zzdi)paramObject1;
    if (((LinkedHashMap)paramObject1).isEmpty()) {
      return 0;
    }
    paramObject1 = ((zzdi)paramObject1).entrySet().iterator();
    if (!((Iterator)paramObject1).hasNext()) {
      return 0;
    }
    paramObject1 = (Map.Entry)((Iterator)paramObject1).next();
    ((Map.Entry)paramObject1).getKey();
    ((Map.Entry)paramObject1).getValue();
    throw new NoSuchMethodError();
  }
  
  public final Object zzb(Object paramObject1, Object paramObject2)
  {
    zzdi localzzdi = (zzdi)paramObject1;
    paramObject2 = (zzdi)paramObject2;
    paramObject1 = localzzdi;
    if (!((LinkedHashMap)paramObject2).isEmpty())
    {
      paramObject1 = localzzdi;
      if (!localzzdi.isMutable()) {
        paramObject1 = localzzdi.zzca();
      }
      ((zzdi)paramObject1).zza((zzdi)paramObject2);
    }
    return paramObject1;
  }
  
  public final Map<?, ?> zzg(Object paramObject)
  {
    return (zzdi)paramObject;
  }
  
  public final Map<?, ?> zzh(Object paramObject)
  {
    return (zzdi)paramObject;
  }
  
  public final boolean zzi(Object paramObject)
  {
    return !((zzdi)paramObject).isMutable();
  }
  
  public final Object zzj(Object paramObject)
  {
    ((zzdi)paramObject).zzv();
    return paramObject;
  }
  
  public final Object zzk(Object paramObject)
  {
    return zzdi.zzbz().zzca();
  }
  
  public final zzdh<?, ?> zzl(Object paramObject)
  {
    throw new NoSuchMethodError();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */