package com.google.android.gms.internal.vision;

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

class zzjb<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
{
  private final int zzaak;
  private List<zzjg> zzaal;
  private Map<K, V> zzaam;
  private volatile zzji zzaan;
  private Map<K, V> zzaao;
  private volatile zzjc zzaap;
  private boolean zztr;
  
  private zzjb(int paramInt)
  {
    this.zzaak = paramInt;
    this.zzaal = Collections.emptyList();
    this.zzaam = Collections.emptyMap();
    this.zzaao = Collections.emptyMap();
  }
  
  private final int zza(K paramK)
  {
    int i = this.zzaal.size() - 1;
    if (i >= 0)
    {
      j = paramK.compareTo((Comparable)((zzjg)this.zzaal.get(i)).getKey());
      if (j > 0) {
        return -(i + 2);
      }
      if (j == 0) {
        return i;
      }
    }
    int j = 0;
    while (j <= i)
    {
      int k = (j + i) / 2;
      int m = paramK.compareTo((Comparable)((zzjg)this.zzaal.get(k)).getKey());
      if (m < 0) {
        i = k - 1;
      } else if (m > 0) {
        j = k + 1;
      } else {
        return k;
      }
    }
    return -(j + 1);
  }
  
  static <FieldDescriptorType extends zzgp<FieldDescriptorType>> zzjb<FieldDescriptorType, Object> zzbu(int paramInt)
  {
    return new zzja(paramInt);
  }
  
  private final V zzbw(int paramInt)
  {
    zzib();
    Object localObject = ((zzjg)this.zzaal.remove(paramInt)).getValue();
    if (!this.zzaam.isEmpty())
    {
      Iterator localIterator = zzic().entrySet().iterator();
      this.zzaal.add(new zzjg(this, (Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    return (V)localObject;
  }
  
  private final void zzib()
  {
    if (!this.zztr) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private final SortedMap<K, V> zzic()
  {
    zzib();
    if ((this.zzaam.isEmpty()) && (!(this.zzaam instanceof TreeMap)))
    {
      TreeMap localTreeMap = new TreeMap();
      this.zzaam = localTreeMap;
      this.zzaao = ((TreeMap)localTreeMap).descendingMap();
    }
    return (SortedMap)this.zzaam;
  }
  
  public void clear()
  {
    zzib();
    if (!this.zzaal.isEmpty()) {
      this.zzaal.clear();
    }
    if (!this.zzaam.isEmpty()) {
      this.zzaam.clear();
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    return (zza((Comparable)paramObject) >= 0) || (this.zzaam.containsKey(paramObject));
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    if (this.zzaan == null) {
      this.zzaan = new zzji(this, null);
    }
    return this.zzaan;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzjb)) {
      return super.equals(paramObject);
    }
    paramObject = (zzjb)paramObject;
    int i = size();
    if (i != ((zzjb)paramObject).size()) {
      return false;
    }
    int j = zzhy();
    if (j != ((zzjb)paramObject).zzhy()) {
      return entrySet().equals(((zzjb)paramObject).entrySet());
    }
    for (int k = 0; k < j; k++) {
      if (!zzbv(k).equals(((zzjb)paramObject).zzbv(k))) {
        return false;
      }
    }
    if (j != i) {
      return this.zzaam.equals(((zzjb)paramObject).zzaam);
    }
    return true;
  }
  
  public V get(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    int i = zza((Comparable)paramObject);
    if (i >= 0) {
      return (V)((zzjg)this.zzaal.get(i)).getValue();
    }
    return (V)this.zzaam.get(paramObject);
  }
  
  public int hashCode()
  {
    int i = zzhy();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += ((zzjg)this.zzaal.get(j)).hashCode();
      j++;
    }
    j = k;
    if (this.zzaam.size() > 0) {
      j = k + this.zzaam.hashCode();
    }
    return j;
  }
  
  public final boolean isImmutable()
  {
    return this.zztr;
  }
  
  public V remove(Object paramObject)
  {
    zzib();
    paramObject = (Comparable)paramObject;
    int i = zza((Comparable)paramObject);
    if (i >= 0) {
      return (V)zzbw(i);
    }
    if (this.zzaam.isEmpty()) {
      return null;
    }
    return (V)this.zzaam.remove(paramObject);
  }
  
  public int size()
  {
    return this.zzaal.size() + this.zzaam.size();
  }
  
  public final V zza(K paramK, V paramV)
  {
    zzib();
    int i = zza(paramK);
    if (i >= 0) {
      return (V)((zzjg)this.zzaal.get(i)).setValue(paramV);
    }
    zzib();
    if ((this.zzaal.isEmpty()) && (!(this.zzaal instanceof ArrayList))) {
      this.zzaal = new ArrayList(this.zzaak);
    }
    i = -(i + 1);
    if (i >= this.zzaak) {
      return (V)zzic().put(paramK, paramV);
    }
    int j = this.zzaal.size();
    int k = this.zzaak;
    if (j == k)
    {
      zzjg localzzjg = (zzjg)this.zzaal.remove(k - 1);
      zzic().put((Comparable)localzzjg.getKey(), localzzjg.getValue());
    }
    this.zzaal.add(i, new zzjg(this, paramK, paramV));
    return null;
  }
  
  public final Map.Entry<K, V> zzbv(int paramInt)
  {
    return (Map.Entry)this.zzaal.get(paramInt);
  }
  
  public void zzdq()
  {
    if (!this.zztr)
    {
      Map localMap;
      if (this.zzaam.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(this.zzaam);
      }
      this.zzaam = localMap;
      if (this.zzaao.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(this.zzaao);
      }
      this.zzaao = localMap;
      this.zztr = true;
    }
  }
  
  public final int zzhy()
  {
    return this.zzaal.size();
  }
  
  public final Iterable<Map.Entry<K, V>> zzhz()
  {
    if (this.zzaam.isEmpty()) {
      return zzjf.zzie();
    }
    return this.zzaam.entrySet();
  }
  
  final Set<Map.Entry<K, V>> zzia()
  {
    if (this.zzaap == null) {
      this.zzaap = new zzjc(this, null);
    }
    return this.zzaap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzjb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */