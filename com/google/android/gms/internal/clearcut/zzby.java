package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class zzby<FieldDescriptorType extends zzca<FieldDescriptorType>>
{
  private static final zzby zzgw = new zzby(true);
  private final zzei<FieldDescriptorType, Object> zzgt;
  private boolean zzgu;
  private boolean zzgv = false;
  
  private zzby()
  {
    this.zzgt = zzei.zzaj(16);
  }
  
  private zzby(boolean paramBoolean)
  {
    this.zzgt = zzei.zzaj(0);
    zzv();
  }
  
  static int zza(zzfl paramzzfl, int paramInt, Object paramObject)
  {
    int i = zzbn.zzr(paramInt);
    paramInt = i;
    if (paramzzfl == zzfl.zzql)
    {
      zzci.zzf((zzdo)paramObject);
      paramInt = i << 1;
    }
    return paramInt + zzb(paramzzfl, paramObject);
  }
  
  private final Object zza(FieldDescriptorType paramFieldDescriptorType)
  {
    Object localObject = this.zzgt.get(paramFieldDescriptorType);
    paramFieldDescriptorType = (FieldDescriptorType)localObject;
    if ((localObject instanceof zzcr)) {
      paramFieldDescriptorType = zzcr.zzbr();
    }
    return paramFieldDescriptorType;
  }
  
  static void zza(zzbn paramzzbn, zzfl paramzzfl, int paramInt, Object paramObject)
    throws IOException
  {
    if (paramzzfl == zzfl.zzql)
    {
      paramzzfl = (zzdo)paramObject;
      zzci.zzf(paramzzfl);
      paramzzbn.zzb(paramInt, 3);
      paramzzfl.zzb(paramzzbn);
      paramzzbn.zzb(paramInt, 4);
      return;
    }
    paramzzbn.zzb(paramInt, paramzzfl.zzel());
    switch (zzbz.zzgq[paramzzfl.ordinal()])
    {
    default: 
      break;
    case 18: 
      if ((paramObject instanceof zzcj))
      {
        paramzzbn.zzn(((zzcj)paramObject).zzc());
        return;
      }
      paramzzbn.zzn(((Integer)paramObject).intValue());
      break;
    case 17: 
      paramzzbn.zzc(((Long)paramObject).longValue());
      return;
    case 16: 
      paramzzbn.zzp(((Integer)paramObject).intValue());
      return;
    case 15: 
      paramzzbn.zzd(((Long)paramObject).longValue());
      return;
    case 14: 
      paramzzbn.zzq(((Integer)paramObject).intValue());
      return;
    case 13: 
      paramzzbn.zzo(((Integer)paramObject).intValue());
      return;
    case 12: 
      if ((paramObject instanceof zzbb))
      {
        paramzzbn.zza((zzbb)paramObject);
        return;
      }
      paramzzfl = (byte[])paramObject;
      paramzzbn.zzd(paramzzfl, 0, paramzzfl.length);
      return;
    case 11: 
      if ((paramObject instanceof zzbb))
      {
        paramzzbn.zza((zzbb)paramObject);
        return;
      }
      paramzzbn.zzg((String)paramObject);
      return;
    case 10: 
      paramzzbn.zzb((zzdo)paramObject);
      return;
    case 9: 
      ((zzdo)paramObject).zzb(paramzzbn);
      return;
    case 8: 
      paramzzbn.zza(((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      paramzzbn.zzq(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramzzbn.zzd(((Long)paramObject).longValue());
      return;
    case 5: 
      paramzzbn.zzn(((Integer)paramObject).intValue());
      return;
    case 4: 
      paramzzbn.zzb(((Long)paramObject).longValue());
      return;
    case 3: 
      paramzzbn.zzb(((Long)paramObject).longValue());
      return;
    case 2: 
      paramzzbn.zza(((Float)paramObject).floatValue());
      return;
    case 1: 
      paramzzbn.zza(((Double)paramObject).doubleValue());
    }
  }
  
  private final void zza(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.zzaw())
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
          zza(paramFieldDescriptorType.zzau(), paramObject);
        }
        paramObject = localArrayList;
      }
      else
      {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    else {
      zza(paramFieldDescriptorType.zzau(), paramObject);
    }
    if ((paramObject instanceof zzcr)) {
      this.zzgv = true;
    }
    this.zzgt.zza(paramFieldDescriptorType, paramObject);
  }
  
  private static void zza(zzfl paramzzfl, Object paramObject)
  {
    zzci.checkNotNull(paramObject);
    int i = zzbz.zzgx[paramzzfl.zzek().ordinal()];
    boolean bool1 = true;
    boolean bool2 = false;
    switch (i)
    {
    default: 
      break;
    case 9: 
      bool2 = bool1;
      if ((paramObject instanceof zzdo)) {
        break label201;
      }
      if ((paramObject instanceof zzcr)) {
        bool2 = bool1;
      }
      break;
    case 8: 
    case 7: 
      do
      {
        do
        {
          bool2 = false;
          break;
          bool2 = bool1;
          if ((paramObject instanceof Integer)) {
            break;
          }
        } while (!(paramObject instanceof zzcj));
        bool2 = bool1;
        break;
        bool2 = bool1;
        if ((paramObject instanceof zzbb)) {
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
    }
    bool2 = paramObject instanceof Integer;
    label201:
    if (bool2) {
      return;
    }
    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
  }
  
  public static <T extends zzca<T>> zzby<T> zzar()
  {
    return zzgw;
  }
  
  private static int zzb(zzca<?> paramzzca, Object paramObject)
  {
    zzfl localzzfl = paramzzca.zzau();
    int i = paramzzca.zzc();
    if (paramzzca.zzaw())
    {
      boolean bool = paramzzca.zzax();
      int j = 0;
      int k = 0;
      paramzzca = (List)paramObject;
      if (bool)
      {
        paramzzca = paramzzca.iterator();
        while (paramzzca.hasNext()) {
          k += zzb(localzzfl, paramzzca.next());
        }
        return zzbn.zzr(i) + k + zzbn.zzz(k);
      }
      paramzzca = paramzzca.iterator();
      k = j;
      while (paramzzca.hasNext()) {
        k += zza(localzzfl, i, paramzzca.next());
      }
      return k;
    }
    return zza(localzzfl, i, paramObject);
  }
  
  private static int zzb(zzfl paramzzfl, Object paramObject)
  {
    switch (zzbz.zzgq[paramzzfl.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      if ((paramObject instanceof zzcj)) {
        return zzbn.zzx(((zzcj)paramObject).zzc());
      }
      return zzbn.zzx(((Integer)paramObject).intValue());
    case 17: 
      return zzbn.zzg(((Long)paramObject).longValue());
    case 16: 
      return zzbn.zzu(((Integer)paramObject).intValue());
    case 15: 
      return zzbn.zzi(((Long)paramObject).longValue());
    case 14: 
      return zzbn.zzw(((Integer)paramObject).intValue());
    case 13: 
      return zzbn.zzt(((Integer)paramObject).intValue());
    case 12: 
      if ((paramObject instanceof zzbb)) {
        return zzbn.zzb((zzbb)paramObject);
      }
      return zzbn.zzd((byte[])paramObject);
    case 11: 
      if ((paramObject instanceof zzbb)) {
        return zzbn.zzb((zzbb)paramObject);
      }
      return zzbn.zzh((String)paramObject);
    case 10: 
      if ((paramObject instanceof zzcr)) {
        return zzbn.zza((zzcr)paramObject);
      }
      return zzbn.zzc((zzdo)paramObject);
    case 9: 
      return zzbn.zzd((zzdo)paramObject);
    case 8: 
      return zzbn.zzb(((Boolean)paramObject).booleanValue());
    case 7: 
      return zzbn.zzv(((Integer)paramObject).intValue());
    case 6: 
      return zzbn.zzh(((Long)paramObject).longValue());
    case 5: 
      return zzbn.zzs(((Integer)paramObject).intValue());
    case 4: 
      return zzbn.zzf(((Long)paramObject).longValue());
    case 3: 
      return zzbn.zze(((Long)paramObject).longValue());
    case 2: 
      return zzbn.zzb(((Float)paramObject).floatValue());
    }
    return zzbn.zzb(((Double)paramObject).doubleValue());
  }
  
  private static boolean zzb(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    zzca localzzca = (zzca)paramEntry.getKey();
    if (localzzca.zzav() == zzfq.zzrf)
    {
      boolean bool = localzzca.zzaw();
      paramEntry = paramEntry.getValue();
      if (bool)
      {
        paramEntry = ((List)paramEntry).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((zzdo)paramEntry.next()).isInitialized());
        return false;
      }
      if ((paramEntry instanceof zzdo))
      {
        if (!((zzdo)paramEntry).isInitialized()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof zzcr)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  private final void zzc(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    zzca localzzca = (zzca)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<FieldDescriptorType, Object>)localObject1;
    if ((localObject1 instanceof zzcr)) {
      paramEntry = zzcr.zzbr();
    }
    if (localzzca.zzaw())
    {
      Object localObject2 = zza(localzzca);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      localObject2 = ((List)paramEntry).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramEntry = ((Iterator)localObject2).next();
        ((List)localObject1).add(zzd(paramEntry));
      }
      this.zzgt.zza(localzzca, localObject1);
      return;
    }
    if (localzzca.zzav() == zzfq.zzrf)
    {
      localObject1 = zza(localzzca);
      if (localObject1 == null)
      {
        this.zzgt.zza(localzzca, zzd(paramEntry));
        return;
      }
      if ((localObject1 instanceof zzdv)) {
        paramEntry = localzzca.zza((zzdv)localObject1, (zzdv)paramEntry);
      } else {
        paramEntry = localzzca.zza(((zzdo)localObject1).zzbc(), (zzdo)paramEntry).zzbj();
      }
      this.zzgt.zza(localzzca, paramEntry);
      return;
    }
    this.zzgt.zza(localzzca, zzd(paramEntry));
  }
  
  private static int zzd(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    zzca localzzca = (zzca)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localzzca.zzav() == zzfq.zzrf) && (!localzzca.zzaw()) && (!localzzca.zzax()))
    {
      boolean bool = localObject instanceof zzcr;
      int i = ((zzca)paramEntry.getKey()).zzc();
      if (bool) {
        return zzbn.zzb(i, (zzcr)localObject);
      }
      return zzbn.zzd(i, (zzdo)localObject);
    }
    return zzb(localzzca, localObject);
  }
  
  private static Object zzd(Object paramObject)
  {
    if ((paramObject instanceof zzdv)) {
      return ((zzdv)paramObject).zzci();
    }
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      byte[] arrayOfByte = new byte[paramObject.length];
      System.arraycopy(paramObject, 0, arrayOfByte, 0, paramObject.length);
      return arrayOfByte;
    }
    return paramObject;
  }
  
  final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator()
  {
    if (this.zzgv) {
      return new zzcu(this.zzgt.zzdt().iterator());
    }
    return this.zzgt.zzdt().iterator();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzby)) {
      return false;
    }
    paramObject = (zzby)paramObject;
    return this.zzgt.equals(((zzby)paramObject).zzgt);
  }
  
  public final int hashCode()
  {
    return this.zzgt.hashCode();
  }
  
  final boolean isEmpty()
  {
    return this.zzgt.isEmpty();
  }
  
  public final boolean isImmutable()
  {
    return this.zzgu;
  }
  
  public final boolean isInitialized()
  {
    for (int i = 0; i < this.zzgt.zzdr(); i++) {
      if (!zzb(this.zzgt.zzak(i))) {
        return false;
      }
    }
    Iterator localIterator = this.zzgt.zzds().iterator();
    while (localIterator.hasNext()) {
      if (!zzb((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    if (this.zzgv) {
      return new zzcu(this.zzgt.entrySet().iterator());
    }
    return this.zzgt.entrySet().iterator();
  }
  
  public final void zza(zzby<FieldDescriptorType> paramzzby)
  {
    for (int i = 0; i < paramzzby.zzgt.zzdr(); i++) {
      zzc(paramzzby.zzgt.zzak(i));
    }
    paramzzby = paramzzby.zzgt.zzds().iterator();
    while (paramzzby.hasNext()) {
      zzc((Map.Entry)paramzzby.next());
    }
  }
  
  public final int zzas()
  {
    int i = 0;
    int j = 0;
    while (i < this.zzgt.zzdr())
    {
      localObject = this.zzgt.zzak(i);
      j += zzb((zzca)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i++;
    }
    Object localObject = this.zzgt.zzds().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      j += zzb((zzca)localEntry.getKey(), localEntry.getValue());
    }
    return j;
  }
  
  public final int zzat()
  {
    int i = 0;
    int j = 0;
    while (i < this.zzgt.zzdr())
    {
      j += zzd(this.zzgt.zzak(i));
      i++;
    }
    Iterator localIterator = this.zzgt.zzds().iterator();
    while (localIterator.hasNext()) {
      j += zzd((Map.Entry)localIterator.next());
    }
    return j;
  }
  
  public final void zzv()
  {
    if (this.zzgu) {
      return;
    }
    this.zzgt.zzv();
    this.zzgu = true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */