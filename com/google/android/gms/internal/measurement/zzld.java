package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

final class zzld
{
  public static final int zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (zzlc)paramObject1;
    paramObject2 = (zzlb)paramObject2;
    if (!((LinkedHashMap)paramObject1).isEmpty())
    {
      paramObject1 = ((zzlc)paramObject1).entrySet().iterator();
      if (((Iterator)paramObject1).hasNext()) {}
    }
    else
    {
      return 0;
    }
    paramObject1 = (Map.Entry)((Iterator)paramObject1).next();
    ((Map.Entry)paramObject1).getKey();
    ((Map.Entry)paramObject1).getValue();
    throw null;
  }
  
  public static final Object zzb(Object paramObject1, Object paramObject2)
  {
    zzlc localzzlc = (zzlc)paramObject1;
    paramObject2 = (zzlc)paramObject2;
    paramObject1 = localzzlc;
    if (!((LinkedHashMap)paramObject2).isEmpty())
    {
      paramObject1 = localzzlc;
      if (!localzzlc.zze()) {
        paramObject1 = localzzlc.zzc();
      }
      ((zzlc)paramObject1).zzb((zzlc)paramObject2);
    }
    return paramObject1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */