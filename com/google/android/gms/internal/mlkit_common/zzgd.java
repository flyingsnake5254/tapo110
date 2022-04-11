package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzgd
  implements zzge
{
  public final int zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (zzgb)paramObject1;
    paramObject2 = (zzfz)paramObject2;
    if (((LinkedHashMap)paramObject1).isEmpty()) {
      return 0;
    }
    paramObject1 = ((zzgb)paramObject1).entrySet().iterator();
    if (!((Iterator)paramObject1).hasNext()) {
      return 0;
    }
    paramObject1 = (Map.Entry)((Iterator)paramObject1).next();
    ((Map.Entry)paramObject1).getKey();
    ((Map.Entry)paramObject1).getValue();
    throw new NoSuchMethodError();
  }
  
  public final zzgc<?, ?> zza(Object paramObject)
  {
    paramObject = (zzfz)paramObject;
    throw new NoSuchMethodError();
  }
  
  public final Object zza(Object paramObject1, Object paramObject2)
  {
    zzgb localzzgb = (zzgb)paramObject1;
    paramObject2 = (zzgb)paramObject2;
    paramObject1 = localzzgb;
    if (!((LinkedHashMap)paramObject2).isEmpty())
    {
      paramObject1 = localzzgb;
      if (!localzzgb.zzc()) {
        paramObject1 = localzzgb.zza();
      }
      ((zzgb)paramObject1).zza((zzgb)paramObject2);
    }
    return paramObject1;
  }
  
  public final Map<?, ?> zzb(Object paramObject)
  {
    return (zzgb)paramObject;
  }
  
  public final Object zzc(Object paramObject)
  {
    ((zzgb)paramObject).zzb();
    return paramObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */