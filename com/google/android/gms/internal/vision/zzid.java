package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzid
  implements zzia
{
  public final int zzb(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (zzib)paramObject1;
    paramObject2 = (zzhz)paramObject2;
    if (((LinkedHashMap)paramObject1).isEmpty()) {
      return 0;
    }
    paramObject1 = ((zzib)paramObject1).entrySet().iterator();
    if (!((Iterator)paramObject1).hasNext()) {
      return 0;
    }
    paramObject1 = (Map.Entry)((Iterator)paramObject1).next();
    ((Map.Entry)paramObject1).getKey();
    ((Map.Entry)paramObject1).getValue();
    throw new NoSuchMethodError();
  }
  
  public final Object zzc(Object paramObject1, Object paramObject2)
  {
    zzib localzzib = (zzib)paramObject1;
    paramObject2 = (zzib)paramObject2;
    paramObject1 = localzzib;
    if (!((LinkedHashMap)paramObject2).isEmpty())
    {
      paramObject1 = localzzib;
      if (!localzzib.isMutable()) {
        paramObject1 = localzzib.zzhe();
      }
      ((zzib)paramObject1).zza((zzib)paramObject2);
    }
    return paramObject1;
  }
  
  public final Map<?, ?> zzl(Object paramObject)
  {
    return (zzib)paramObject;
  }
  
  public final Map<?, ?> zzm(Object paramObject)
  {
    return (zzib)paramObject;
  }
  
  public final boolean zzn(Object paramObject)
  {
    return !((zzib)paramObject).isMutable();
  }
  
  public final Object zzo(Object paramObject)
  {
    ((zzib)paramObject).zzdq();
    return paramObject;
  }
  
  public final Object zzp(Object paramObject)
  {
    return zzib.zzhd().zzhe();
  }
  
  public final zzhy<?, ?> zzq(Object paramObject)
  {
    paramObject = (zzhz)paramObject;
    throw new NoSuchMethodError();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */