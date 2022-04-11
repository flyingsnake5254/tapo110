package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzhg
  implements zzhh
{
  public final int zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (zzhe)paramObject1;
    paramObject2 = (zzhc)paramObject2;
    if (((LinkedHashMap)paramObject1).isEmpty()) {
      return 0;
    }
    paramObject1 = ((zzhe)paramObject1).entrySet().iterator();
    if (!((Iterator)paramObject1).hasNext()) {
      return 0;
    }
    paramObject1 = (Map.Entry)((Iterator)paramObject1).next();
    ((Map.Entry)paramObject1).getKey();
    ((Map.Entry)paramObject1).getValue();
    throw new NoSuchMethodError();
  }
  
  public final zzhf<?, ?> zza(Object paramObject)
  {
    paramObject = (zzhc)paramObject;
    throw new NoSuchMethodError();
  }
  
  public final Object zza(Object paramObject1, Object paramObject2)
  {
    zzhe localzzhe = (zzhe)paramObject1;
    paramObject2 = (zzhe)paramObject2;
    paramObject1 = localzzhe;
    if (!((LinkedHashMap)paramObject2).isEmpty())
    {
      paramObject1 = localzzhe;
      if (!localzzhe.zzc()) {
        paramObject1 = localzzhe.zza();
      }
      ((zzhe)paramObject1).zza((zzhe)paramObject2);
    }
    return paramObject1;
  }
  
  public final Map<?, ?> zzb(Object paramObject)
  {
    return (zzhe)paramObject;
  }
  
  public final Object zzc(Object paramObject)
  {
    ((zzhe)paramObject).zzb();
    return paramObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzhg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */