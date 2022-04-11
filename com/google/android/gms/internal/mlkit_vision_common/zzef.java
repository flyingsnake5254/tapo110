package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class zzef<T extends zzeh<T>>
{
  private static final zzef zzd = new zzef(true);
  final zzgn<T, Object> zza;
  private boolean zzb;
  private boolean zzc;
  
  private zzef()
  {
    this.zza = zzgn.zza(16);
  }
  
  private zzef(zzgn<T, Object> paramzzgn)
  {
    this.zza = paramzzgn;
    zzb();
  }
  
  private zzef(boolean paramBoolean)
  {
    this(zzgn.zza(0));
    zzb();
  }
  
  public static int zza(zzeh<?> paramzzeh, Object paramObject)
  {
    zzho localzzho = paramzzeh.zzb();
    int i = paramzzeh.zza();
    if (paramzzeh.zzd())
    {
      boolean bool = paramzzeh.zze();
      int j = 0;
      int k = 0;
      if (bool)
      {
        paramzzeh = ((List)paramObject).iterator();
        while (paramzzeh.hasNext()) {
          k += zzb(localzzho, paramzzeh.next());
        }
        return zzdw.zze(i) + k + zzdw.zzl(k);
      }
      paramzzeh = ((List)paramObject).iterator();
      k = j;
      while (paramzzeh.hasNext()) {
        k += zza(localzzho, i, paramzzeh.next());
      }
      return k;
    }
    return zza(localzzho, i, paramObject);
  }
  
  static int zza(zzho paramzzho, int paramInt, Object paramObject)
  {
    int i = zzdw.zze(paramInt);
    paramInt = i;
    if (paramzzho == zzho.zzj)
    {
      zzem.zza((zzfv)paramObject);
      paramInt = i << 1;
    }
    return paramInt + zzb(paramzzho, paramObject);
  }
  
  public static <T extends zzeh<T>> zzef<T> zza()
  {
    return zzd;
  }
  
  private final Object zza(T paramT)
  {
    Object localObject = this.zza.get(paramT);
    paramT = (T)localObject;
    if ((localObject instanceof zzew))
    {
      paramT = (zzew)localObject;
      paramT = zzew.zza();
    }
    return paramT;
  }
  
  private static Object zza(Object paramObject)
  {
    if ((paramObject instanceof zzgb)) {
      return ((zzgb)paramObject).zza();
    }
    if ((paramObject instanceof byte[]))
    {
      byte[] arrayOfByte = (byte[])paramObject;
      paramObject = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, paramObject, 0, arrayOfByte.length);
      return paramObject;
    }
    return paramObject;
  }
  
  static void zza(zzdw paramzzdw, zzho paramzzho, int paramInt, Object paramObject)
    throws IOException
  {
    if (paramzzho == zzho.zzj)
    {
      paramzzho = (zzfv)paramObject;
      zzem.zza(paramzzho);
      paramzzdw.zza(paramInt, 3);
      paramzzho.zza(paramzzdw);
      paramzzdw.zza(paramInt, 4);
      return;
    }
    paramzzdw.zza(paramInt, paramzzho.zzb());
    switch (zzee.zzb[paramzzho.ordinal()])
    {
    default: 
      break;
    case 18: 
      if ((paramObject instanceof zzep))
      {
        paramzzdw.zza(((zzep)paramObject).zza());
        return;
      }
      paramzzdw.zza(((Integer)paramObject).intValue());
      break;
    case 17: 
      paramzzdw.zzb(((Long)paramObject).longValue());
      return;
    case 16: 
      paramzzdw.zzc(((Integer)paramObject).intValue());
      return;
    case 15: 
      paramzzdw.zzc(((Long)paramObject).longValue());
      return;
    case 14: 
      paramzzdw.zzd(((Integer)paramObject).intValue());
      return;
    case 13: 
      paramzzdw.zzb(((Integer)paramObject).intValue());
      return;
    case 12: 
      if ((paramObject instanceof zzdj))
      {
        paramzzdw.zza((zzdj)paramObject);
        return;
      }
      paramzzho = (byte[])paramObject;
      paramzzdw.zzb(paramzzho, 0, paramzzho.length);
      return;
    case 11: 
      if ((paramObject instanceof zzdj))
      {
        paramzzdw.zza((zzdj)paramObject);
        return;
      }
      paramzzdw.zza((String)paramObject);
      return;
    case 10: 
      paramzzdw.zza((zzfv)paramObject);
      return;
    case 9: 
      ((zzfv)paramObject).zza(paramzzdw);
      return;
    case 8: 
      paramzzdw.zza(((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      paramzzdw.zzd(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramzzdw.zzc(((Long)paramObject).longValue());
      return;
    case 5: 
      paramzzdw.zza(((Integer)paramObject).intValue());
      return;
    case 4: 
      paramzzdw.zza(((Long)paramObject).longValue());
      return;
    case 3: 
      paramzzdw.zza(((Long)paramObject).longValue());
      return;
    case 2: 
      paramzzdw.zza(((Float)paramObject).floatValue());
      return;
    case 1: 
      paramzzdw.zza(((Double)paramObject).doubleValue());
    }
  }
  
  private static void zza(zzho paramzzho, Object paramObject)
  {
    zzem.zza(paramObject);
    int i = zzee.zza[paramzzho.zza().ordinal()];
    boolean bool1 = true;
    boolean bool2;
    switch (i)
    {
    default: 
    case 9: 
    case 8: 
    case 7: 
      do
      {
        do
        {
          do
          {
            bool2 = false;
            break;
            bool2 = bool1;
            if ((paramObject instanceof zzfv)) {
              break;
            }
          } while (!(paramObject instanceof zzew));
          bool2 = bool1;
          break;
          bool2 = bool1;
          if ((paramObject instanceof Integer)) {
            break;
          }
        } while (!(paramObject instanceof zzep));
        bool2 = bool1;
        break;
        bool2 = bool1;
        if ((paramObject instanceof zzdj)) {
          break;
        }
      } while (!(paramObject instanceof byte[]));
      bool2 = bool1;
      break;
    case 6: 
      bool2 = paramObject instanceof String;
      break;
    case 5: 
      bool2 = paramObject instanceof Boolean;
      break;
    case 4: 
      bool2 = paramObject instanceof Double;
      break;
    case 3: 
      bool2 = paramObject instanceof Float;
      break;
    case 2: 
      bool2 = paramObject instanceof Long;
      break;
    case 1: 
      bool2 = paramObject instanceof Integer;
    }
    if (bool2) {
      return;
    }
    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
  }
  
  private static <T extends zzeh<T>> boolean zza(Map.Entry<T, Object> paramEntry)
  {
    zzeh localzzeh = (zzeh)paramEntry.getKey();
    if (localzzeh.zzc() == zzhv.zzi)
    {
      if (localzzeh.zzd())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((zzfv)paramEntry.next()).zzi());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof zzfv))
      {
        if (!((zzfv)paramEntry).zzi()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof zzew)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  private static int zzb(zzho paramzzho, Object paramObject)
  {
    switch (zzee.zzb[paramzzho.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      if ((paramObject instanceof zzep)) {
        return zzdw.zzk(((zzep)paramObject).zza());
      }
      return zzdw.zzk(((Integer)paramObject).intValue());
    case 17: 
      return zzdw.zzf(((Long)paramObject).longValue());
    case 16: 
      return zzdw.zzh(((Integer)paramObject).intValue());
    case 15: 
      return zzdw.zzh(((Long)paramObject).longValue());
    case 14: 
      return zzdw.zzj(((Integer)paramObject).intValue());
    case 13: 
      return zzdw.zzg(((Integer)paramObject).intValue());
    case 12: 
      if ((paramObject instanceof zzdj)) {
        return zzdw.zzb((zzdj)paramObject);
      }
      return zzdw.zzb((byte[])paramObject);
    case 11: 
      if ((paramObject instanceof zzdj)) {
        return zzdw.zzb((zzdj)paramObject);
      }
      return zzdw.zzb((String)paramObject);
    case 10: 
      if ((paramObject instanceof zzew)) {
        return zzdw.zza((zzew)paramObject);
      }
      return zzdw.zzb((zzfv)paramObject);
    case 9: 
      return zzdw.zzc((zzfv)paramObject);
    case 8: 
      return zzdw.zzb(((Boolean)paramObject).booleanValue());
    case 7: 
      return zzdw.zzi(((Integer)paramObject).intValue());
    case 6: 
      return zzdw.zzg(((Long)paramObject).longValue());
    case 5: 
      return zzdw.zzf(((Integer)paramObject).intValue());
    case 4: 
      return zzdw.zze(((Long)paramObject).longValue());
    case 3: 
      return zzdw.zzd(((Long)paramObject).longValue());
    case 2: 
      return zzdw.zzb(((Float)paramObject).floatValue());
    }
    return zzdw.zzb(((Double)paramObject).doubleValue());
  }
  
  private final void zzb(T paramT, Object paramObject)
  {
    if (paramT.zzd())
    {
      if ((paramObject instanceof List))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((List)paramObject);
        int i = localArrayList.size();
        int j = 0;
        while (j < i)
        {
          paramObject = localArrayList.get(j);
          j++;
          zza(paramT.zzb(), paramObject);
        }
        paramObject = localArrayList;
      }
      else
      {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    else {
      zza(paramT.zzb(), paramObject);
    }
    if ((paramObject instanceof zzew)) {
      this.zzc = true;
    }
    this.zza.zza(paramT, paramObject);
  }
  
  private final void zzb(Map.Entry<T, Object> paramEntry)
  {
    zzeh localzzeh = (zzeh)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<T, Object>)localObject1;
    if ((localObject1 instanceof zzew))
    {
      paramEntry = (zzew)localObject1;
      paramEntry = zzew.zza();
    }
    if (localzzeh.zzd())
    {
      Object localObject2 = zza(localzzeh);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      localObject2 = ((List)paramEntry).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramEntry = ((Iterator)localObject2).next();
        ((List)localObject1).add(zza(paramEntry));
      }
      this.zza.zza(localzzeh, localObject1);
      return;
    }
    if (localzzeh.zzc() == zzhv.zzi)
    {
      localObject1 = zza(localzzeh);
      if (localObject1 == null)
      {
        this.zza.zza(localzzeh, zza(paramEntry));
        return;
      }
      if ((localObject1 instanceof zzgb)) {
        paramEntry = localzzeh.zza((zzgb)localObject1, (zzgb)paramEntry);
      } else {
        paramEntry = localzzeh.zza(((zzfv)localObject1).zzm(), (zzfv)paramEntry).zzg();
      }
      this.zza.zza(localzzeh, paramEntry);
      return;
    }
    this.zza.zza(localzzeh, zza(paramEntry));
  }
  
  private static int zzc(Map.Entry<T, Object> paramEntry)
  {
    zzeh localzzeh = (zzeh)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localzzeh.zzc() == zzhv.zzi) && (!localzzeh.zzd()) && (!localzzeh.zze()))
    {
      if ((localObject instanceof zzew)) {
        return zzdw.zzb(((zzeh)paramEntry.getKey()).zza(), (zzew)localObject);
      }
      return zzdw.zzb(((zzeh)paramEntry.getKey()).zza(), (zzfv)localObject);
    }
    return zza(localzzeh, localObject);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzef)) {
      return false;
    }
    paramObject = (zzef)paramObject;
    return this.zza.equals(((zzef)paramObject).zza);
  }
  
  public final int hashCode()
  {
    return this.zza.hashCode();
  }
  
  public final void zza(zzef<T> paramzzef)
  {
    for (int i = 0; i < paramzzef.zza.zzc(); i++) {
      zzb(paramzzef.zza.zzb(i));
    }
    paramzzef = paramzzef.zza.zzd().iterator();
    while (paramzzef.hasNext()) {
      zzb((Map.Entry)paramzzef.next());
    }
  }
  
  public final void zzb()
  {
    if (this.zzb) {
      return;
    }
    this.zza.zza();
    this.zzb = true;
  }
  
  public final boolean zzc()
  {
    return this.zzb;
  }
  
  public final Iterator<Map.Entry<T, Object>> zzd()
  {
    if (this.zzc) {
      return new zzfb(this.zza.entrySet().iterator());
    }
    return this.zza.entrySet().iterator();
  }
  
  final Iterator<Map.Entry<T, Object>> zze()
  {
    if (this.zzc) {
      return new zzfb(this.zza.zze().iterator());
    }
    return this.zza.zze().iterator();
  }
  
  public final boolean zzf()
  {
    for (int i = 0; i < this.zza.zzc(); i++) {
      if (!zza(this.zza.zzb(i))) {
        return false;
      }
    }
    Iterator localIterator = this.zza.zzd().iterator();
    while (localIterator.hasNext()) {
      if (!zza((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final int zzg()
  {
    int i = 0;
    int j = 0;
    while (i < this.zza.zzc())
    {
      j += zzc(this.zza.zzb(i));
      i++;
    }
    Iterator localIterator = this.zza.zzd().iterator();
    while (localIterator.hasNext()) {
      j += zzc((Map.Entry)localIterator.next());
    }
    return j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */