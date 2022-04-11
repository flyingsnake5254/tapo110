package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzfr
  implements zzfo
{
  public final int zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (zzfp)paramObject1;
    paramObject2 = (zzfn)paramObject2;
    if (((LinkedHashMap)paramObject1).isEmpty()) {
      return 0;
    }
    paramObject1 = ((zzfp)paramObject1).entrySet().iterator();
    if (!((Iterator)paramObject1).hasNext()) {
      return 0;
    }
    paramObject1 = (Map.Entry)((Iterator)paramObject1).next();
    ((Map.Entry)paramObject1).getKey();
    ((Map.Entry)paramObject1).getValue();
    throw new NoSuchMethodError();
  }
  
  public final Object zza(Object paramObject1, Object paramObject2)
  {
    zzfp localzzfp = (zzfp)paramObject1;
    paramObject2 = (zzfp)paramObject2;
    paramObject1 = localzzfp;
    if (!((LinkedHashMap)paramObject2).isEmpty())
    {
      paramObject1 = localzzfp;
      if (!localzzfp.zzc()) {
        paramObject1 = localzzfp.zza();
      }
      ((zzfp)paramObject1).zza((zzfp)paramObject2);
    }
    return paramObject1;
  }
  
  public final Map<?, ?> zza(Object paramObject)
  {
    return (zzfp)paramObject;
  }
  
  public final Object zzb(Object paramObject)
  {
    ((zzfp)paramObject).zzb();
    return paramObject;
  }
  
  public final zzfm<?, ?> zzc(Object paramObject)
  {
    paramObject = (zzfn)paramObject;
    throw new NoSuchMethodError();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzfr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */