package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class zzfs<T extends zzfu<T>>
{
  private static final zzfs zzd = new zzfs(true);
  final zzic<T, Object> zza;
  private boolean zzb;
  private boolean zzc;
  
  private zzfs()
  {
    this.zza = zzic.zza(16);
  }
  
  private zzfs(zzic<T, Object> paramzzic)
  {
    this.zza = paramzzic;
    zzb();
  }
  
  private zzfs(boolean paramBoolean)
  {
    this(zzic.zza(0));
    zzb();
  }
  
  public static int zza(zzfu<?> paramzzfu, Object paramObject)
  {
    zzjh localzzjh = paramzzfu.zzb();
    int i = paramzzfu.zza();
    if (paramzzfu.zzd())
    {
      boolean bool = paramzzfu.zze();
      int j = 0;
      int k = 0;
      if (bool)
      {
        paramzzfu = ((List)paramObject).iterator();
        while (paramzzfu.hasNext()) {
          k += zzb(localzzjh, paramzzfu.next());
        }
        return zzfn.zze(i) + k + zzfn.zzl(k);
      }
      paramzzfu = ((List)paramObject).iterator();
      k = j;
      while (paramzzfu.hasNext()) {
        k += zza(localzzjh, i, paramzzfu.next());
      }
      return k;
    }
    return zza(localzzjh, i, paramObject);
  }
  
  static int zza(zzjh paramzzjh, int paramInt, Object paramObject)
  {
    int i = zzfn.zze(paramInt);
    paramInt = i;
    if (paramzzjh == zzjh.zzj)
    {
      zzgc.zza((zzhk)paramObject);
      paramInt = i << 1;
    }
    return paramInt + zzb(paramzzjh, paramObject);
  }
  
  public static <T extends zzfu<T>> zzfs<T> zza()
  {
    return zzd;
  }
  
  private final Object zza(T paramT)
  {
    Object localObject = this.zza.get(paramT);
    paramT = (T)localObject;
    if ((localObject instanceof zzgp))
    {
      paramT = (zzgp)localObject;
      paramT = zzgp.zza();
    }
    return paramT;
  }
  
  private static Object zza(Object paramObject)
  {
    if ((paramObject instanceof zzhq)) {
      return ((zzhq)paramObject).zza();
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
  
  static void zza(zzfn paramzzfn, zzjh paramzzjh, int paramInt, Object paramObject)
    throws IOException
  {
    if (paramzzjh == zzjh.zzj)
    {
      paramzzjh = (zzhk)paramObject;
      zzgc.zza(paramzzjh);
      paramzzfn.zza(paramInt, 3);
      paramzzjh.zza(paramzzfn);
      paramzzfn.zza(paramInt, 4);
      return;
    }
    paramzzfn.zza(paramInt, paramzzjh.zzb());
    switch (zzfv.zzb[paramzzjh.ordinal()])
    {
    default: 
      break;
    case 18: 
      if ((paramObject instanceof zzgf))
      {
        paramzzfn.zza(((zzgf)paramObject).zza());
        return;
      }
      paramzzfn.zza(((Integer)paramObject).intValue());
      break;
    case 17: 
      paramzzfn.zzb(((Long)paramObject).longValue());
      return;
    case 16: 
      paramzzfn.zzc(((Integer)paramObject).intValue());
      return;
    case 15: 
      paramzzfn.zzc(((Long)paramObject).longValue());
      return;
    case 14: 
      paramzzfn.zzd(((Integer)paramObject).intValue());
      return;
    case 13: 
      paramzzfn.zzb(((Integer)paramObject).intValue());
      return;
    case 12: 
      if ((paramObject instanceof zzew))
      {
        paramzzfn.zza((zzew)paramObject);
        return;
      }
      paramzzjh = (byte[])paramObject;
      paramzzfn.zzb(paramzzjh, 0, paramzzjh.length);
      return;
    case 11: 
      if ((paramObject instanceof zzew))
      {
        paramzzfn.zza((zzew)paramObject);
        return;
      }
      paramzzfn.zza((String)paramObject);
      return;
    case 10: 
      paramzzfn.zza((zzhk)paramObject);
      return;
    case 9: 
      ((zzhk)paramObject).zza(paramzzfn);
      return;
    case 8: 
      paramzzfn.zza(((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      paramzzfn.zzd(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramzzfn.zzc(((Long)paramObject).longValue());
      return;
    case 5: 
      paramzzfn.zza(((Integer)paramObject).intValue());
      return;
    case 4: 
      paramzzfn.zza(((Long)paramObject).longValue());
      return;
    case 3: 
      paramzzfn.zza(((Long)paramObject).longValue());
      return;
    case 2: 
      paramzzfn.zza(((Float)paramObject).floatValue());
      return;
    case 1: 
      paramzzfn.zza(((Double)paramObject).doubleValue());
    }
  }
  
  private static void zza(zzjh paramzzjh, Object paramObject)
  {
    zzgc.zza(paramObject);
    int i = zzfv.zza[paramzzjh.zza().ordinal()];
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
            if ((paramObject instanceof zzhk)) {
              break;
            }
          } while (!(paramObject instanceof zzgp));
          bool2 = bool1;
          break;
          bool2 = bool1;
          if ((paramObject instanceof Integer)) {
            break;
          }
        } while (!(paramObject instanceof zzgf));
        bool2 = bool1;
        break;
        bool2 = bool1;
        if ((paramObject instanceof zzew)) {
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
  
  private static <T extends zzfu<T>> boolean zza(Map.Entry<T, Object> paramEntry)
  {
    zzfu localzzfu = (zzfu)paramEntry.getKey();
    if (localzzfu.zzc() == zzjk.zzi)
    {
      if (localzzfu.zzd())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((zzhk)paramEntry.next()).zzi());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof zzhk))
      {
        if (!((zzhk)paramEntry).zzi()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof zzgp)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  private static int zzb(zzjh paramzzjh, Object paramObject)
  {
    switch (zzfv.zzb[paramzzjh.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      if ((paramObject instanceof zzgf)) {
        return zzfn.zzk(((zzgf)paramObject).zza());
      }
      return zzfn.zzk(((Integer)paramObject).intValue());
    case 17: 
      return zzfn.zzf(((Long)paramObject).longValue());
    case 16: 
      return zzfn.zzh(((Integer)paramObject).intValue());
    case 15: 
      return zzfn.zzh(((Long)paramObject).longValue());
    case 14: 
      return zzfn.zzj(((Integer)paramObject).intValue());
    case 13: 
      return zzfn.zzg(((Integer)paramObject).intValue());
    case 12: 
      if ((paramObject instanceof zzew)) {
        return zzfn.zzb((zzew)paramObject);
      }
      return zzfn.zzb((byte[])paramObject);
    case 11: 
      if ((paramObject instanceof zzew)) {
        return zzfn.zzb((zzew)paramObject);
      }
      return zzfn.zzb((String)paramObject);
    case 10: 
      if ((paramObject instanceof zzgp)) {
        return zzfn.zza((zzgp)paramObject);
      }
      return zzfn.zzb((zzhk)paramObject);
    case 9: 
      return zzfn.zzc((zzhk)paramObject);
    case 8: 
      return zzfn.zzb(((Boolean)paramObject).booleanValue());
    case 7: 
      return zzfn.zzi(((Integer)paramObject).intValue());
    case 6: 
      return zzfn.zzg(((Long)paramObject).longValue());
    case 5: 
      return zzfn.zzf(((Integer)paramObject).intValue());
    case 4: 
      return zzfn.zze(((Long)paramObject).longValue());
    case 3: 
      return zzfn.zzd(((Long)paramObject).longValue());
    case 2: 
      return zzfn.zzb(((Float)paramObject).floatValue());
    }
    return zzfn.zzb(((Double)paramObject).doubleValue());
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
    if ((paramObject instanceof zzgp)) {
      this.zzc = true;
    }
    this.zza.zza(paramT, paramObject);
  }
  
  private final void zzb(Map.Entry<T, Object> paramEntry)
  {
    zzfu localzzfu = (zzfu)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<T, Object>)localObject1;
    if ((localObject1 instanceof zzgp))
    {
      paramEntry = (zzgp)localObject1;
      paramEntry = zzgp.zza();
    }
    if (localzzfu.zzd())
    {
      Object localObject2 = zza(localzzfu);
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
      this.zza.zza(localzzfu, localObject1);
      return;
    }
    if (localzzfu.zzc() == zzjk.zzi)
    {
      localObject1 = zza(localzzfu);
      if (localObject1 == null)
      {
        this.zza.zza(localzzfu, zza(paramEntry));
        return;
      }
      if ((localObject1 instanceof zzhq)) {
        paramEntry = localzzfu.zza((zzhq)localObject1, (zzhq)paramEntry);
      } else {
        paramEntry = localzzfu.zza(((zzhk)localObject1).zzn(), (zzhk)paramEntry).zzg();
      }
      this.zza.zza(localzzfu, paramEntry);
      return;
    }
    this.zza.zza(localzzfu, zza(paramEntry));
  }
  
  private static int zzc(Map.Entry<T, Object> paramEntry)
  {
    zzfu localzzfu = (zzfu)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localzzfu.zzc() == zzjk.zzi) && (!localzzfu.zzd()) && (!localzzfu.zze()))
    {
      if ((localObject instanceof zzgp)) {
        return zzfn.zzb(((zzfu)paramEntry.getKey()).zza(), (zzgp)localObject);
      }
      return zzfn.zzb(((zzfu)paramEntry.getKey()).zza(), (zzhk)localObject);
    }
    return zza(localzzfu, localObject);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzfs)) {
      return false;
    }
    paramObject = (zzfs)paramObject;
    return this.zza.equals(((zzfs)paramObject).zza);
  }
  
  public final int hashCode()
  {
    return this.zza.hashCode();
  }
  
  public final void zza(zzfs<T> paramzzfs)
  {
    for (int i = 0; i < paramzzfs.zza.zzc(); i++) {
      zzb(paramzzfs.zza.zzb(i));
    }
    paramzzfs = paramzzfs.zza.zzd().iterator();
    while (paramzzfs.hasNext()) {
      zzb((Map.Entry)paramzzfs.next());
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
      return new zzgq(this.zza.entrySet().iterator());
    }
    return this.zza.entrySet().iterator();
  }
  
  final Iterator<Map.Entry<T, Object>> zze()
  {
    if (this.zzc) {
      return new zzgq(this.zza.zze().iterator());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */