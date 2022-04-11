package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class zzer<T extends zzet<T>>
{
  private static final zzer zzd = new zzer(true);
  final zzgz<T, Object> zza;
  private boolean zzb;
  private boolean zzc;
  
  private zzer()
  {
    this.zza = zzgz.zza(16);
  }
  
  private zzer(zzgz<T, Object> paramzzgz)
  {
    this.zza = paramzzgz;
    zzb();
  }
  
  private zzer(boolean paramBoolean)
  {
    this(zzgz.zza(0));
    zzb();
  }
  
  public static int zza(zzet<?> paramzzet, Object paramObject)
  {
    zzie localzzie = paramzzet.zzb();
    int i = paramzzet.zza();
    if (paramzzet.zzd())
    {
      boolean bool = paramzzet.zze();
      int j = 0;
      int k = 0;
      if (bool)
      {
        paramzzet = ((List)paramObject).iterator();
        while (paramzzet.hasNext()) {
          k += zzb(localzzie, paramzzet.next());
        }
        return zzem.zze(i) + k + zzem.zzl(k);
      }
      paramzzet = ((List)paramObject).iterator();
      k = j;
      while (paramzzet.hasNext()) {
        k += zza(localzzie, i, paramzzet.next());
      }
      return k;
    }
    return zza(localzzie, i, paramObject);
  }
  
  static int zza(zzie paramzzie, int paramInt, Object paramObject)
  {
    int i = zzem.zze(paramInt);
    paramInt = i;
    if (paramzzie == zzie.zzj)
    {
      zzfc.zza((zzgh)paramObject);
      paramInt = i << 1;
    }
    return paramInt + zzb(paramzzie, paramObject);
  }
  
  public static <T extends zzet<T>> zzer<T> zza()
  {
    return zzd;
  }
  
  private final Object zza(T paramT)
  {
    Object localObject = this.zza.get(paramT);
    paramT = (T)localObject;
    if ((localObject instanceof zzfm))
    {
      paramT = (zzfm)localObject;
      paramT = zzfm.zza();
    }
    return paramT;
  }
  
  private static Object zza(Object paramObject)
  {
    if ((paramObject instanceof zzgn)) {
      return ((zzgn)paramObject).zza();
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
  
  static void zza(zzem paramzzem, zzie paramzzie, int paramInt, Object paramObject)
    throws IOException
  {
    if (paramzzie == zzie.zzj)
    {
      paramzzie = (zzgh)paramObject;
      zzfc.zza(paramzzie);
      paramzzem.zza(paramInt, 3);
      paramzzie.zza(paramzzem);
      paramzzem.zza(paramInt, 4);
      return;
    }
    paramzzem.zza(paramInt, paramzzie.zzb());
    switch (zzeu.zzb[paramzzie.ordinal()])
    {
    default: 
      break;
    case 18: 
      if ((paramObject instanceof zzfb))
      {
        paramzzem.zza(((zzfb)paramObject).zza());
        return;
      }
      paramzzem.zza(((Integer)paramObject).intValue());
      break;
    case 17: 
      paramzzem.zzb(((Long)paramObject).longValue());
      return;
    case 16: 
      paramzzem.zzc(((Integer)paramObject).intValue());
      return;
    case 15: 
      paramzzem.zzc(((Long)paramObject).longValue());
      return;
    case 14: 
      paramzzem.zzd(((Integer)paramObject).intValue());
      return;
    case 13: 
      paramzzem.zzb(((Integer)paramObject).intValue());
      return;
    case 12: 
      if ((paramObject instanceof zzdv))
      {
        paramzzem.zza((zzdv)paramObject);
        return;
      }
      paramzzie = (byte[])paramObject;
      paramzzem.zzb(paramzzie, 0, paramzzie.length);
      return;
    case 11: 
      if ((paramObject instanceof zzdv))
      {
        paramzzem.zza((zzdv)paramObject);
        return;
      }
      paramzzem.zza((String)paramObject);
      return;
    case 10: 
      paramzzem.zza((zzgh)paramObject);
      return;
    case 9: 
      ((zzgh)paramObject).zza(paramzzem);
      return;
    case 8: 
      paramzzem.zza(((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      paramzzem.zzd(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramzzem.zzc(((Long)paramObject).longValue());
      return;
    case 5: 
      paramzzem.zza(((Integer)paramObject).intValue());
      return;
    case 4: 
      paramzzem.zza(((Long)paramObject).longValue());
      return;
    case 3: 
      paramzzem.zza(((Long)paramObject).longValue());
      return;
    case 2: 
      paramzzem.zza(((Float)paramObject).floatValue());
      return;
    case 1: 
      paramzzem.zza(((Double)paramObject).doubleValue());
    }
  }
  
  private static void zza(zzie paramzzie, Object paramObject)
  {
    zzfc.zza(paramObject);
    int i = zzeu.zza[paramzzie.zza().ordinal()];
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
            if ((paramObject instanceof zzgh)) {
              break;
            }
          } while (!(paramObject instanceof zzfm));
          bool2 = bool1;
          break;
          bool2 = bool1;
          if ((paramObject instanceof Integer)) {
            break;
          }
        } while (!(paramObject instanceof zzfb));
        bool2 = bool1;
        break;
        bool2 = bool1;
        if ((paramObject instanceof zzdv)) {
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
  
  private static <T extends zzet<T>> boolean zza(Map.Entry<T, Object> paramEntry)
  {
    zzet localzzet = (zzet)paramEntry.getKey();
    if (localzzet.zzc() == zzih.zzi)
    {
      if (localzzet.zzd())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((zzgh)paramEntry.next()).a_());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof zzgh))
      {
        if (!((zzgh)paramEntry).a_()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof zzfm)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  private static int zzb(zzie paramzzie, Object paramObject)
  {
    switch (zzeu.zzb[paramzzie.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      if ((paramObject instanceof zzfb)) {
        return zzem.zzk(((zzfb)paramObject).zza());
      }
      return zzem.zzk(((Integer)paramObject).intValue());
    case 17: 
      return zzem.zzf(((Long)paramObject).longValue());
    case 16: 
      return zzem.zzh(((Integer)paramObject).intValue());
    case 15: 
      return zzem.zzh(((Long)paramObject).longValue());
    case 14: 
      return zzem.zzj(((Integer)paramObject).intValue());
    case 13: 
      return zzem.zzg(((Integer)paramObject).intValue());
    case 12: 
      if ((paramObject instanceof zzdv)) {
        return zzem.zzb((zzdv)paramObject);
      }
      return zzem.zzb((byte[])paramObject);
    case 11: 
      if ((paramObject instanceof zzdv)) {
        return zzem.zzb((zzdv)paramObject);
      }
      return zzem.zzb((String)paramObject);
    case 10: 
      if ((paramObject instanceof zzfm)) {
        return zzem.zza((zzfm)paramObject);
      }
      return zzem.zzb((zzgh)paramObject);
    case 9: 
      return zzem.zzc((zzgh)paramObject);
    case 8: 
      return zzem.zzb(((Boolean)paramObject).booleanValue());
    case 7: 
      return zzem.zzi(((Integer)paramObject).intValue());
    case 6: 
      return zzem.zzg(((Long)paramObject).longValue());
    case 5: 
      return zzem.zzf(((Integer)paramObject).intValue());
    case 4: 
      return zzem.zze(((Long)paramObject).longValue());
    case 3: 
      return zzem.zzd(((Long)paramObject).longValue());
    case 2: 
      return zzem.zzb(((Float)paramObject).floatValue());
    }
    return zzem.zzb(((Double)paramObject).doubleValue());
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
    if ((paramObject instanceof zzfm)) {
      this.zzc = true;
    }
    this.zza.zza(paramT, paramObject);
  }
  
  private final void zzb(Map.Entry<T, Object> paramEntry)
  {
    zzet localzzet = (zzet)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<T, Object>)localObject1;
    if ((localObject1 instanceof zzfm))
    {
      paramEntry = (zzfm)localObject1;
      paramEntry = zzfm.zza();
    }
    if (localzzet.zzd())
    {
      Object localObject2 = zza(localzzet);
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
      this.zza.zza(localzzet, localObject1);
      return;
    }
    if (localzzet.zzc() == zzih.zzi)
    {
      localObject1 = zza(localzzet);
      if (localObject1 == null)
      {
        this.zza.zza(localzzet, zza(paramEntry));
        return;
      }
      if ((localObject1 instanceof zzgn)) {
        paramEntry = localzzet.zza((zzgn)localObject1, (zzgn)paramEntry);
      } else {
        paramEntry = localzzet.zza(((zzgh)localObject1).zzm(), (zzgh)paramEntry).zzh();
      }
      this.zza.zza(localzzet, paramEntry);
      return;
    }
    this.zza.zza(localzzet, zza(paramEntry));
  }
  
  private static int zzc(Map.Entry<T, Object> paramEntry)
  {
    zzet localzzet = (zzet)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localzzet.zzc() == zzih.zzi) && (!localzzet.zzd()) && (!localzzet.zze()))
    {
      if ((localObject instanceof zzfm)) {
        return zzem.zzb(((zzet)paramEntry.getKey()).zza(), (zzfm)localObject);
      }
      return zzem.zzb(((zzet)paramEntry.getKey()).zza(), (zzgh)localObject);
    }
    return zza(localzzet, localObject);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzer)) {
      return false;
    }
    paramObject = (zzer)paramObject;
    return this.zza.equals(((zzer)paramObject).zza);
  }
  
  public final int hashCode()
  {
    return this.zza.hashCode();
  }
  
  public final void zza(zzer<T> paramzzer)
  {
    for (int i = 0; i < paramzzer.zza.zzc(); i++) {
      zzb(paramzzer.zza.zzb(i));
    }
    paramzzer = paramzzer.zza.zzd().iterator();
    while (paramzzer.hasNext()) {
      zzb((Map.Entry)paramzzer.next());
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
      return new zzfn(this.zza.entrySet().iterator());
    }
    return this.zza.entrySet().iterator();
  }
  
  final Iterator<Map.Entry<T, Object>> zze()
  {
    if (this.zzc) {
      return new zzfn(this.zza.zze().iterator());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */