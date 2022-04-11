package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzmd<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
{
  private final int zza;
  private List<zzma> zzb;
  private Map<K, V> zzc;
  private boolean zzd;
  private volatile zzmc zze;
  private Map<K, V> zzf;
  
  private final V zzk(int paramInt)
  {
    zzm();
    Object localObject = ((zzma)this.zzb.remove(paramInt)).getValue();
    if (!this.zzc.isEmpty())
    {
      Iterator localIterator = zzn().entrySet().iterator();
      List localList = this.zzb;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localList.add(new zzma(this, (Comparable)localEntry.getKey(), localEntry.getValue()));
      localIterator.remove();
    }
    return (V)localObject;
  }
  
  private final int zzl(K paramK)
  {
    int i = this.zzb.size() - 1;
    int j = 0;
    int k = i;
    int m = j;
    if (i >= 0)
    {
      k = paramK.compareTo(((zzma)this.zzb.get(i)).zza());
      if (k > 0) {
        return -(i + 2);
      }
      if (k != 0)
      {
        k = i;
        m = j;
      }
      else
      {
        return i;
      }
    }
    while (m <= k)
    {
      j = (m + k) / 2;
      i = paramK.compareTo(((zzma)this.zzb.get(j)).zza());
      if (i < 0) {
        k = j - 1;
      } else if (i > 0) {
        m = j + 1;
      } else {
        return j;
      }
    }
    return -(m + 1);
  }
  
  private final void zzm()
  {
    if (!this.zzd) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private final SortedMap<K, V> zzn()
  {
    zzm();
    if ((this.zzc.isEmpty()) && (!(this.zzc instanceof TreeMap)))
    {
      TreeMap localTreeMap = new TreeMap();
      this.zzc = localTreeMap;
      this.zzf = ((TreeMap)localTreeMap).descendingMap();
    }
    return (SortedMap)this.zzc;
  }
  
  public final void clear()
  {
    zzm();
    if (!this.zzb.isEmpty()) {
      this.zzb.clear();
    }
    if (!this.zzc.isEmpty()) {
      this.zzc.clear();
    }
  }
  
  public final boolean containsKey(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    return (zzl((Comparable)paramObject) >= 0) || (this.zzc.containsKey(paramObject));
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    if (this.zze == null) {
      this.zze = new zzmc(this, null);
    }
    return this.zze;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzmd)) {
      return super.equals(paramObject);
    }
    paramObject = (zzmd)paramObject;
    int i = size();
    if (i != ((zzmd)paramObject).size()) {
      return false;
    }
    int j = zzc();
    if (j == ((zzmd)paramObject).zzc())
    {
      for (int k = 0; k < j; k++) {
        if (!zzd(k).equals(((zzmd)paramObject).zzd(k))) {
          return false;
        }
      }
      if (j != i) {
        return this.zzc.equals(((zzmd)paramObject).zzc);
      }
      return true;
    }
    return entrySet().equals(((zzmd)paramObject).entrySet());
  }
  
  public final V get(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    int i = zzl((Comparable)paramObject);
    if (i >= 0) {
      return (V)((zzma)this.zzb.get(i)).getValue();
    }
    return (V)this.zzc.get(paramObject);
  }
  
  public final int hashCode()
  {
    int i = zzc();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += ((zzma)this.zzb.get(j)).hashCode();
      j++;
    }
    j = k;
    if (this.zzc.size() > 0) {
      j = k + this.zzc.hashCode();
    }
    return j;
  }
  
  public final V remove(Object paramObject)
  {
    zzm();
    paramObject = (Comparable)paramObject;
    int i = zzl((Comparable)paramObject);
    if (i >= 0) {
      return (V)zzk(i);
    }
    if (this.zzc.isEmpty()) {
      return null;
    }
    return (V)this.zzc.remove(paramObject);
  }
  
  public final int size()
  {
    return this.zzb.size() + this.zzc.size();
  }
  
  public void zza()
  {
    if (!this.zzd)
    {
      Map localMap;
      if (this.zzc.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(this.zzc);
      }
      this.zzc = localMap;
      if (this.zzf.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(this.zzf);
      }
      this.zzf = localMap;
      this.zzd = true;
    }
  }
  
  public final boolean zzb()
  {
    return this.zzd;
  }
  
  public final int zzc()
  {
    return this.zzb.size();
  }
  
  public final Map.Entry<K, V> zzd(int paramInt)
  {
    return (Map.Entry)this.zzb.get(paramInt);
  }
  
  public final Iterable<Map.Entry<K, V>> zze()
  {
    Object localObject;
    if (this.zzc.isEmpty()) {
      localObject = zzlz.zza();
    } else {
      localObject = this.zzc.entrySet();
    }
    return (Iterable<Map.Entry<K, V>>)localObject;
  }
  
  public final V zzf(K paramK, V paramV)
  {
    zzm();
    int i = zzl(paramK);
    if (i >= 0) {
      return (V)((zzma)this.zzb.get(i)).setValue(paramV);
    }
    zzm();
    if ((this.zzb.isEmpty()) && (!(this.zzb instanceof ArrayList))) {
      this.zzb = new ArrayList(this.zza);
    }
    int j = -(i + 1);
    if (j >= this.zza) {
      return (V)zzn().put(paramK, paramV);
    }
    int k = this.zzb.size();
    i = this.zza;
    if (k == i)
    {
      zzma localzzma = (zzma)this.zzb.remove(i - 1);
      zzn().put(localzzma.zza(), localzzma.getValue());
    }
    this.zzb.add(j, new zzma(this, paramK, paramV));
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */