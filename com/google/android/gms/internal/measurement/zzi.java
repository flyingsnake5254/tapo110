package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzi
{
  public static zzap zza(Object paramObject)
  {
    if (paramObject == null) {
      return zzap.zzg;
    }
    if ((paramObject instanceof String)) {
      return new zzat((String)paramObject);
    }
    if ((paramObject instanceof Double)) {
      return new zzah((Double)paramObject);
    }
    if ((paramObject instanceof Long)) {
      return new zzah(Double.valueOf(((Long)paramObject).doubleValue()));
    }
    if ((paramObject instanceof Integer)) {
      return new zzah(Double.valueOf(((Integer)paramObject).doubleValue()));
    }
    if ((paramObject instanceof Boolean)) {
      return new zzaf((Boolean)paramObject);
    }
    throw new IllegalArgumentException("Invalid value type");
  }
  
  public static zzap zzb(zzgt paramzzgt)
  {
    if (paramzzgt == null) {
      return zzap.zzf;
    }
    Object localObject1 = zzgs.zza;
    int i = paramzzgt.zza().ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4)
            {
              Object localObject2 = paramzzgt.zzb();
              localObject1 = new ArrayList();
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                ((List)localObject1).add(zzb((zzgt)((Iterator)localObject2).next()));
              }
              return new zzaq(paramzzgt.zzc(), (List)localObject1);
            }
            localObject1 = String.valueOf(paramzzgt);
            paramzzgt = new StringBuilder(((String)localObject1).length() + 16);
            paramzzgt.append("Invalid entity: ");
            paramzzgt.append((String)localObject1);
            throw new IllegalStateException(paramzzgt.toString());
          }
          if (paramzzgt.zzf()) {
            return new zzaf(Boolean.valueOf(paramzzgt.zzg()));
          }
          return new zzaf(null);
        }
        if (paramzzgt.zzh()) {
          return new zzah(Double.valueOf(paramzzgt.zzi()));
        }
        return new zzah(null);
      }
      if (paramzzgt.zzd()) {
        return new zzat(paramzzgt.zze());
      }
      return zzap.zzm;
    }
    throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */