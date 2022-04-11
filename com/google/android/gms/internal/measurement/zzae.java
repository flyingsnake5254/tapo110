package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzae
  implements Iterable<zzap>, zzap, zzal
{
  final SortedMap<Integer, zzap> zza = new TreeMap();
  final Map<String, zzap> zzb = new TreeMap();
  
  public zzae() {}
  
  public zzae(List<zzap> paramList)
  {
    this();
    if (paramList != null) {
      for (int i = 0; i < paramList.size(); i++) {
        zzn(i, (zzap)paramList.get(i));
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzae)) {
      return false;
    }
    paramObject = (zzae)paramObject;
    if (zzh() != ((zzae)paramObject).zzh()) {
      return false;
    }
    if (this.zza.isEmpty()) {
      return ((zzae)paramObject).zza.isEmpty();
    }
    for (int i = ((Integer)this.zza.firstKey()).intValue(); i <= ((Integer)this.zza.lastKey()).intValue(); i++) {
      if (!zzl(i).equals(((zzae)paramObject).zzl(i))) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    return this.zza.hashCode() * 31;
  }
  
  public final Iterator<zzap> iterator()
  {
    return new zzad(this);
  }
  
  public final String toString()
  {
    return zzs(",");
  }
  
  public final List<zzap> zzb()
  {
    ArrayList localArrayList = new ArrayList(zzh());
    for (int i = 0; i < zzh(); i++) {
      localArrayList.add(zzl(i));
    }
    return localArrayList;
  }
  
  public final zzap zzbK(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    if ((!"concat".equals(paramString)) && (!"every".equals(paramString)) && (!"filter".equals(paramString)) && (!"forEach".equals(paramString)) && (!"indexOf".equals(paramString)) && (!"join".equals(paramString)) && (!"lastIndexOf".equals(paramString)) && (!"map".equals(paramString)) && (!"pop".equals(paramString)) && (!"push".equals(paramString)) && (!"reduce".equals(paramString)) && (!"reduceRight".equals(paramString)) && (!"reverse".equals(paramString)) && (!"shift".equals(paramString)) && (!"slice".equals(paramString)) && (!"some".equals(paramString)) && (!"sort".equals(paramString)) && (!"splice".equals(paramString)) && (!"toString".equals(paramString)) && (!"unshift".equals(paramString))) {
      return zzaj.zza(this, new zzat(paramString), paramzzg, paramList);
    }
    return zzbb.zza(paramString, this, paramzzg, paramList);
  }
  
  public final String zzc()
  {
    return zzs(",");
  }
  
  public final Double zzd()
  {
    if (this.zza.size() == 1) {
      return zzl(0).zzd();
    }
    if (this.zza.size() <= 0) {
      return Double.valueOf(0.0D);
    }
    return Double.valueOf(NaN.0D);
  }
  
  public final Boolean zze()
  {
    return Boolean.TRUE;
  }
  
  public final Iterator<zzap> zzf()
  {
    return new zzac(this, this.zza.keySet().iterator(), this.zzb.keySet().iterator());
  }
  
  public final Iterator<Integer> zzg()
  {
    return this.zza.keySet().iterator();
  }
  
  public final int zzh()
  {
    if (this.zza.isEmpty()) {
      return 0;
    }
    return ((Integer)this.zza.lastKey()).intValue() + 1;
  }
  
  public final int zzi()
  {
    return this.zza.size();
  }
  
  public final boolean zzj(String paramString)
  {
    return ("length".equals(paramString)) || (this.zzb.containsKey(paramString));
  }
  
  public final zzap zzk(String paramString)
  {
    if ("length".equals(paramString)) {
      return new zzah(Double.valueOf(zzh()));
    }
    if (zzj(paramString))
    {
      paramString = (zzap)this.zzb.get(paramString);
      if (paramString != null) {
        return paramString;
      }
    }
    return zzap.zzf;
  }
  
  public final zzap zzl(int paramInt)
  {
    if (paramInt < zzh())
    {
      if (zzo(paramInt))
      {
        zzap localzzap = (zzap)this.zza.get(Integer.valueOf(paramInt));
        if (localzzap != null) {
          return localzzap;
        }
      }
      return zzap.zzf;
    }
    throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
  }
  
  public final void zzm(String paramString, zzap paramzzap)
  {
    if (paramzzap == null)
    {
      this.zzb.remove(paramString);
      return;
    }
    this.zzb.put(paramString, paramzzap);
  }
  
  @RequiresNonNull({"elements"})
  public final void zzn(int paramInt, zzap paramzzap)
  {
    if (paramInt <= 32468)
    {
      if (paramInt >= 0)
      {
        if (paramzzap == null)
        {
          this.zza.remove(Integer.valueOf(paramInt));
          return;
        }
        this.zza.put(Integer.valueOf(paramInt), paramzzap);
        return;
      }
      paramzzap = new StringBuilder(32);
      paramzzap.append("Out of bounds index: ");
      paramzzap.append(paramInt);
      throw new IndexOutOfBoundsException(paramzzap.toString());
    }
    throw new IllegalStateException("Array too large");
  }
  
  public final boolean zzo(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= ((Integer)this.zza.lastKey()).intValue())) {
      return this.zza.containsKey(Integer.valueOf(paramInt));
    }
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append("Out of bounds index: ");
    localStringBuilder.append(paramInt);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public final void zzp()
  {
    this.zza.clear();
  }
  
  public final void zzq(int paramInt, zzap paramzzap)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= zzh())
      {
        zzn(paramInt, paramzzap);
        return;
      }
      for (int i = ((Integer)this.zza.lastKey()).intValue(); i >= paramInt; i--)
      {
        Object localObject = this.zza;
        Integer localInteger = Integer.valueOf(i);
        localObject = (zzap)((SortedMap)localObject).get(localInteger);
        if (localObject != null)
        {
          zzn(i + 1, (zzap)localObject);
          this.zza.remove(localInteger);
        }
      }
      zzn(paramInt, paramzzap);
      return;
    }
    paramzzap = new StringBuilder(32);
    paramzzap.append("Invalid value index: ");
    paramzzap.append(paramInt);
    throw new IllegalArgumentException(paramzzap.toString());
  }
  
  public final void zzr(int paramInt)
  {
    int i = ((Integer)this.zza.lastKey()).intValue();
    if ((paramInt <= i) && (paramInt >= 0))
    {
      this.zza.remove(Integer.valueOf(paramInt));
      int j = paramInt;
      Object localObject1;
      Object localObject2;
      if (paramInt == i)
      {
        localObject1 = this.zza;
        paramInt--;
        localObject2 = Integer.valueOf(paramInt);
        if ((!((SortedMap)localObject1).containsKey(localObject2)) && (paramInt >= 0)) {
          this.zza.put(localObject2, zzap.zzf);
        }
        return;
      }
      for (;;)
      {
        paramInt = j + 1;
        if (paramInt > ((Integer)this.zza.lastKey()).intValue()) {
          break;
        }
        localObject2 = this.zza;
        localObject1 = Integer.valueOf(paramInt);
        localObject2 = (zzap)((SortedMap)localObject2).get(localObject1);
        j = paramInt;
        if (localObject2 != null)
        {
          this.zza.put(Integer.valueOf(paramInt - 1), localObject2);
          this.zza.remove(localObject1);
          j = paramInt;
        }
      }
    }
  }
  
  public final String zzs(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    if (!this.zza.isEmpty())
    {
      for (int i = 0; i < zzh(); i++)
      {
        zzap localzzap = zzl(i);
        paramString.append(str);
        if ((!(localzzap instanceof zzau)) && (!(localzzap instanceof zzan))) {
          paramString.append(localzzap.zzc());
        }
      }
      paramString.delete(0, str.length());
    }
    return paramString.toString();
  }
  
  public final zzap zzt()
  {
    zzae localzzae = new zzae();
    Iterator localIterator = this.zza.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof zzal)) {
        localzzae.zza.put((Integer)localEntry.getKey(), (zzap)localEntry.getValue());
      } else {
        localzzae.zza.put((Integer)localEntry.getKey(), ((zzap)localEntry.getValue()).zzt());
      }
    }
    return localzzae;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */