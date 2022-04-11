package com.google.android.gms.internal.mlkit_vision_barcode;

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

class zzic<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
{
  private final int zza;
  private List<zzil> zzb;
  private Map<K, V> zzc;
  private boolean zzd;
  private volatile zzin zze;
  private Map<K, V> zzf;
  private volatile zzih zzg;
  
  private zzic(int paramInt)
  {
    this.zza = paramInt;
    this.zzb = Collections.emptyList();
    this.zzc = Collections.emptyMap();
    this.zzf = Collections.emptyMap();
  }
  
  private final int zza(K paramK)
  {
    int i = this.zzb.size() - 1;
    if (i >= 0)
    {
      j = paramK.compareTo((Comparable)((zzil)this.zzb.get(i)).getKey());
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
      int m = paramK.compareTo((Comparable)((zzil)this.zzb.get(k)).getKey());
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
  
  static <FieldDescriptorType extends zzfu<FieldDescriptorType>> zzic<FieldDescriptorType, Object> zza(int paramInt)
  {
    return new zzif(paramInt);
  }
  
  private final V zzc(int paramInt)
  {
    zzf();
    Object localObject = ((zzil)this.zzb.remove(paramInt)).getValue();
    if (!this.zzc.isEmpty())
    {
      Iterator localIterator = zzg().entrySet().iterator();
      this.zzb.add(new zzil(this, (Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    return (V)localObject;
  }
  
  private final void zzf()
  {
    if (!this.zzd) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private final SortedMap<K, V> zzg()
  {
    zzf();
    if ((this.zzc.isEmpty()) && (!(this.zzc instanceof TreeMap)))
    {
      TreeMap localTreeMap = new TreeMap();
      this.zzc = localTreeMap;
      this.zzf = ((TreeMap)localTreeMap).descendingMap();
    }
    return (SortedMap)this.zzc;
  }
  
  public void clear()
  {
    zzf();
    if (!this.zzb.isEmpty()) {
      this.zzb.clear();
    }
    if (!this.zzc.isEmpty()) {
      this.zzc.clear();
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    return (zza((Comparable)paramObject) >= 0) || (this.zzc.containsKey(paramObject));
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    if (this.zze == null) {
      this.zze = new zzin(this, null);
    }
    return this.zze;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzic)) {
      return super.equals(paramObject);
    }
    paramObject = (zzic)paramObject;
    int i = size();
    if (i != ((zzic)paramObject).size()) {
      return false;
    }
    int j = zzc();
    if (j != ((zzic)paramObject).zzc()) {
      return entrySet().equals(((zzic)paramObject).entrySet());
    }
    for (int k = 0; k < j; k++) {
      if (!zzb(k).equals(((zzic)paramObject).zzb(k))) {
        return false;
      }
    }
    if (j != i) {
      return this.zzc.equals(((zzic)paramObject).zzc);
    }
    return true;
  }
  
  public V get(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    int i = zza((Comparable)paramObject);
    if (i >= 0) {
      return (V)((zzil)this.zzb.get(i)).getValue();
    }
    return (V)this.zzc.get(paramObject);
  }
  
  public int hashCode()
  {
    int i = zzc();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += ((zzil)this.zzb.get(j)).hashCode();
      j++;
    }
    j = k;
    if (this.zzc.size() > 0) {
      j = k + this.zzc.hashCode();
    }
    return j;
  }
  
  public V remove(Object paramObject)
  {
    zzf();
    paramObject = (Comparable)paramObject;
    int i = zza((Comparable)paramObject);
    if (i >= 0) {
      return (V)zzc(i);
    }
    if (this.zzc.isEmpty()) {
      return null;
    }
    return (V)this.zzc.remove(paramObject);
  }
  
  public int size()
  {
    return this.zzb.size() + this.zzc.size();
  }
  
  public final V zza(K paramK, V paramV)
  {
    zzf();
    int i = zza(paramK);
    if (i >= 0) {
      return (V)((zzil)this.zzb.get(i)).setValue(paramV);
    }
    zzf();
    if ((this.zzb.isEmpty()) && (!(this.zzb instanceof ArrayList))) {
      this.zzb = new ArrayList(this.zza);
    }
    int j = -(i + 1);
    if (j >= this.zza) {
      return (V)zzg().put(paramK, paramV);
    }
    i = this.zzb.size();
    int k = this.zza;
    if (i == k)
    {
      zzil localzzil = (zzil)this.zzb.remove(k - 1);
      zzg().put((Comparable)localzzil.getKey(), localzzil.getValue());
    }
    this.zzb.add(j, new zzil(this, paramK, paramV));
    return null;
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
  
  public final Map.Entry<K, V> zzb(int paramInt)
  {
    return (Map.Entry)this.zzb.get(paramInt);
  }
  
  public final boolean zzb()
  {
    return this.zzd;
  }
  
  public final int zzc()
  {
    return this.zzb.size();
  }
  
  public final Iterable<Map.Entry<K, V>> zzd()
  {
    if (this.zzc.isEmpty()) {
      return zzig.zza();
    }
    return this.zzc.entrySet();
  }
  
  final Set<Map.Entry<K, V>> zze()
  {
    if (this.zzg == null) {
      this.zzg = new zzih(this, null);
    }
    return this.zzg;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */