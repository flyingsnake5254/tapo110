package com.google.android.gms.internal.clearcut;

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

class zzei<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
{
  private boolean zzgu;
  private final int zzol;
  private List<zzep> zzom;
  private Map<K, V> zzon;
  private volatile zzer zzoo;
  private Map<K, V> zzop;
  private volatile zzel zzoq;
  
  private zzei(int paramInt)
  {
    this.zzol = paramInt;
    this.zzom = Collections.emptyList();
    this.zzon = Collections.emptyMap();
    this.zzop = Collections.emptyMap();
  }
  
  private final int zza(K paramK)
  {
    int i = this.zzom.size() - 1;
    if (i >= 0)
    {
      j = paramK.compareTo((Comparable)((zzep)this.zzom.get(i)).getKey());
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
      int m = paramK.compareTo((Comparable)((zzep)this.zzom.get(k)).getKey());
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
  
  static <FieldDescriptorType extends zzca<FieldDescriptorType>> zzei<FieldDescriptorType, Object> zzaj(int paramInt)
  {
    return new zzej(paramInt);
  }
  
  private final V zzal(int paramInt)
  {
    zzdu();
    Object localObject = ((zzep)this.zzom.remove(paramInt)).getValue();
    if (!this.zzon.isEmpty())
    {
      Iterator localIterator = zzdv().entrySet().iterator();
      this.zzom.add(new zzep(this, (Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    return (V)localObject;
  }
  
  private final void zzdu()
  {
    if (!this.zzgu) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private final SortedMap<K, V> zzdv()
  {
    zzdu();
    if ((this.zzon.isEmpty()) && (!(this.zzon instanceof TreeMap)))
    {
      TreeMap localTreeMap = new TreeMap();
      this.zzon = localTreeMap;
      this.zzop = ((TreeMap)localTreeMap).descendingMap();
    }
    return (SortedMap)this.zzon;
  }
  
  public void clear()
  {
    zzdu();
    if (!this.zzom.isEmpty()) {
      this.zzom.clear();
    }
    if (!this.zzon.isEmpty()) {
      this.zzon.clear();
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    return (zza((Comparable)paramObject) >= 0) || (this.zzon.containsKey(paramObject));
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    if (this.zzoo == null) {
      this.zzoo = new zzer(this, null);
    }
    return this.zzoo;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzei)) {
      return super.equals(paramObject);
    }
    paramObject = (zzei)paramObject;
    int i = size();
    if (i != ((zzei)paramObject).size()) {
      return false;
    }
    int j = zzdr();
    if (j != ((zzei)paramObject).zzdr()) {
      return entrySet().equals(((zzei)paramObject).entrySet());
    }
    for (int k = 0; k < j; k++) {
      if (!zzak(k).equals(((zzei)paramObject).zzak(k))) {
        return false;
      }
    }
    if (j != i) {
      return this.zzon.equals(((zzei)paramObject).zzon);
    }
    return true;
  }
  
  public V get(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    int i = zza((Comparable)paramObject);
    if (i >= 0) {
      return (V)((zzep)this.zzom.get(i)).getValue();
    }
    return (V)this.zzon.get(paramObject);
  }
  
  public int hashCode()
  {
    int i = zzdr();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += ((zzep)this.zzom.get(j)).hashCode();
      j++;
    }
    j = k;
    if (this.zzon.size() > 0) {
      j = k + this.zzon.hashCode();
    }
    return j;
  }
  
  public final boolean isImmutable()
  {
    return this.zzgu;
  }
  
  public V remove(Object paramObject)
  {
    zzdu();
    paramObject = (Comparable)paramObject;
    int i = zza((Comparable)paramObject);
    if (i >= 0) {
      return (V)zzal(i);
    }
    if (this.zzon.isEmpty()) {
      return null;
    }
    return (V)this.zzon.remove(paramObject);
  }
  
  public int size()
  {
    return this.zzom.size() + this.zzon.size();
  }
  
  public final V zza(K paramK, V paramV)
  {
    zzdu();
    int i = zza(paramK);
    if (i >= 0) {
      return (V)((zzep)this.zzom.get(i)).setValue(paramV);
    }
    zzdu();
    if ((this.zzom.isEmpty()) && (!(this.zzom instanceof ArrayList))) {
      this.zzom = new ArrayList(this.zzol);
    }
    int j = -(i + 1);
    if (j >= this.zzol) {
      return (V)zzdv().put(paramK, paramV);
    }
    int k = this.zzom.size();
    i = this.zzol;
    if (k == i)
    {
      zzep localzzep = (zzep)this.zzom.remove(i - 1);
      zzdv().put((Comparable)localzzep.getKey(), localzzep.getValue());
    }
    this.zzom.add(j, new zzep(this, paramK, paramV));
    return null;
  }
  
  public final Map.Entry<K, V> zzak(int paramInt)
  {
    return (Map.Entry)this.zzom.get(paramInt);
  }
  
  public final int zzdr()
  {
    return this.zzom.size();
  }
  
  public final Iterable<Map.Entry<K, V>> zzds()
  {
    if (this.zzon.isEmpty()) {
      return zzem.zzdx();
    }
    return this.zzon.entrySet();
  }
  
  final Set<Map.Entry<K, V>> zzdt()
  {
    if (this.zzoq == null) {
      this.zzoq = new zzel(this, null);
    }
    return this.zzoq;
  }
  
  public void zzv()
  {
    if (!this.zzgu)
    {
      Map localMap;
      if (this.zzon.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(this.zzon);
      }
      this.zzon = localMap;
      if (this.zzop.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(this.zzop);
      }
      this.zzop = localMap;
      this.zzgu = true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */