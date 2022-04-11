package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzaa<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  private static final Object zzd = new Object();
  @NullableDecl
  transient int[] zza;
  @NullableDecl
  transient Object[] zzb;
  @NullableDecl
  transient Object[] zzc;
  @NullableDecl
  private transient Object zze;
  private transient int zzf;
  private transient int zzg;
  @NullableDecl
  private transient Set<K> zzh;
  @NullableDecl
  private transient Set<Map.Entry<K, V>> zzi;
  @NullableDecl
  private transient Collection<V> zzj;
  
  zzaa()
  {
    zzb(3);
  }
  
  zzaa(int paramInt)
  {
    zzb(12);
  }
  
  private final int zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = zzal.zza(paramInt2);
    int i = paramInt2 - 1;
    if (paramInt4 != 0) {
      zzal.zza(localObject1, paramInt3 & i, paramInt4 + 1);
    }
    Object localObject2 = this.zze;
    int[] arrayOfInt = this.zza;
    for (paramInt2 = 0; paramInt2 <= paramInt1; paramInt2++)
    {
      int k;
      for (paramInt3 = zzal.zza(localObject2, paramInt2); paramInt3 != 0; paramInt3 = k & paramInt1)
      {
        int j = paramInt3 - 1;
        k = arrayOfInt[j];
        int m = (paramInt1 ^ 0xFFFFFFFF) & k | paramInt2;
        int n = m & i;
        paramInt4 = zzal.zza(localObject1, n);
        zzal.zza(localObject1, n, paramInt3);
        arrayOfInt[j] = zzal.zza(m, paramInt4, i);
      }
    }
    this.zze = localObject1;
    zzc(i);
    return i;
  }
  
  private final int zza(@NullableDecl Object paramObject)
  {
    if (zza()) {
      return -1;
    }
    int i = zzak.zza(paramObject);
    int j = zzi();
    int k = zzal.zza(this.zze, i & j);
    if (k == 0) {
      return -1;
    }
    int m = j ^ 0xFFFFFFFF;
    int n;
    do
    {
      k--;
      n = this.zza[k];
      if (((n & m) == (i & m)) && (zze.zza(paramObject, this.zzb[k]))) {
        return k;
      }
      n &= j;
      k = n;
    } while (n != 0);
    return -1;
  }
  
  static int zzb(int paramInt1, int paramInt2)
  {
    return paramInt1 - 1;
  }
  
  @NullableDecl
  private final Object zzb(@NullableDecl Object paramObject)
  {
    if (zza()) {
      return zzd;
    }
    int i = zzi();
    int j = zzal.zza(paramObject, null, i, this.zze, this.zza, this.zzb, null);
    if (j == -1) {
      return zzd;
    }
    paramObject = this.zzc[j];
    zza(j, i);
    this.zzg -= 1;
    zzc();
    return paramObject;
  }
  
  private final void zzb(int paramInt)
  {
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.zzf = zzbj.zza(paramInt, 1, 1073741823);
      return;
    }
    throw new IllegalArgumentException("Expected size must be >= 0");
  }
  
  private final void zzc(int paramInt)
  {
    paramInt = Integer.numberOfLeadingZeros(paramInt);
    this.zzf = zzal.zza(this.zzf, 32 - paramInt, 31);
  }
  
  private final int zzi()
  {
    return (1 << (this.zzf & 0x1F)) - 1;
  }
  
  public final void clear()
  {
    if (zza()) {
      return;
    }
    zzc();
    Object localObject = zzb();
    if (localObject != null)
    {
      this.zzf = zzbj.zza(size(), 3, 1073741823);
      ((Map)localObject).clear();
      this.zze = null;
      this.zzg = 0;
      return;
    }
    Arrays.fill(this.zzb, 0, this.zzg, null);
    Arrays.fill(this.zzc, 0, this.zzg, null);
    localObject = this.zze;
    if ((localObject instanceof byte[])) {
      Arrays.fill((byte[])localObject, (byte)0);
    } else if ((localObject instanceof short[])) {
      Arrays.fill((short[])localObject, (short)0);
    } else {
      Arrays.fill((int[])localObject, 0);
    }
    Arrays.fill(this.zza, 0, this.zzg, 0);
    this.zzg = 0;
  }
  
  public final boolean containsKey(@NullableDecl Object paramObject)
  {
    Map localMap = zzb();
    if (localMap != null) {
      return localMap.containsKey(paramObject);
    }
    return zza(paramObject) != -1;
  }
  
  public final boolean containsValue(@NullableDecl Object paramObject)
  {
    Map localMap = zzb();
    if (localMap != null) {
      return localMap.containsValue(paramObject);
    }
    for (int i = 0; i < this.zzg; i++) {
      if (zze.zza(paramObject, this.zzc[i])) {
        return true;
      }
    }
    return false;
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet = this.zzi;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new zzae(this);
      this.zzi = ((Set)localObject);
    }
    return (Set<Map.Entry<K, V>>)localObject;
  }
  
  public final V get(@NullableDecl Object paramObject)
  {
    Map localMap = zzb();
    if (localMap != null) {
      return (V)localMap.get(paramObject);
    }
    int i = zza(paramObject);
    if (i == -1) {
      return null;
    }
    return (V)this.zzc[i];
  }
  
  public final boolean isEmpty()
  {
    return size() == 0;
  }
  
  public final Set<K> keySet()
  {
    Set localSet = this.zzh;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new zzag(this);
      this.zzh = ((Set)localObject);
    }
    return (Set<K>)localObject;
  }
  
  @NullableDecl
  public final V put(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    if (zza())
    {
      zzh.zza(zza(), "Arrays already allocated");
      i = this.zzf;
      j = Math.max(i + 1, 2);
      k = Integer.highestOneBit(j);
      m = k;
      if (j > (int)(k * 1.0D))
      {
        k <<= 1;
        m = k;
        if (k <= 0) {
          m = 1073741824;
        }
      }
      m = Math.max(4, m);
      this.zze = zzal.zza(m);
      zzc(m - 1);
      this.zza = new int[i];
      this.zzb = new Object[i];
      this.zzc = new Object[i];
    }
    Object localObject = zzb();
    if (localObject != null) {
      return (V)((Map)localObject).put(paramK, paramV);
    }
    int[] arrayOfInt = this.zza;
    localObject = this.zzb;
    Object[] arrayOfObject = this.zzc;
    int n = this.zzg;
    int i1 = n + 1;
    int j = zzak.zza(paramK);
    int i = zzi();
    int m = j & i;
    int k = zzal.zza(this.zze, m);
    int i2;
    if (k == 0)
    {
      if (i1 > i)
      {
        m = zza(i, zzal.zzb(i), j, n);
      }
      else
      {
        zzal.zza(this.zze, m, i1);
        m = i;
      }
    }
    else
    {
      i2 = i ^ 0xFFFFFFFF;
      m = 0;
    }
    for (;;)
    {
      int i3 = k - 1;
      int i4 = arrayOfInt[i3];
      if (((i4 & i2) == (j & i2)) && (zze.zza(paramK, localObject[i3])))
      {
        paramK = arrayOfObject[i3];
        arrayOfObject[i3] = paramV;
        return paramK;
      }
      k = i4 & i;
      m++;
      if (k == 0)
      {
        if (m >= 9)
        {
          localObject = new LinkedHashMap(zzi() + 1, 1.0F);
          for (m = zzd(); m >= 0; m = zza(m)) {
            ((Map)localObject).put(this.zzb[m], this.zzc[m]);
          }
          this.zze = localObject;
          this.zza = null;
          this.zzb = null;
          this.zzc = null;
          zzc();
          return (V)((Map)localObject).put(paramK, paramV);
        }
        if (i1 > i)
        {
          m = zza(i, zzal.zzb(i), j, n);
        }
        else
        {
          arrayOfInt[i3] = zzal.zza(i4, i1, i);
          m = i;
        }
        k = this.zza.length;
        if (i1 > k)
        {
          i = Math.min(1073741823, 0x1 | Math.max(1, k >>> 1) + k);
          if (i != k)
          {
            this.zza = Arrays.copyOf(this.zza, i);
            this.zzb = Arrays.copyOf(this.zzb, i);
            this.zzc = Arrays.copyOf(this.zzc, i);
          }
        }
        this.zza[n] = zzal.zza(j, 0, m);
        this.zzb[n] = paramK;
        this.zzc[n] = paramV;
        this.zzg = i1;
        zzc();
        return null;
      }
    }
  }
  
  @NullableDecl
  public final V remove(@NullableDecl Object paramObject)
  {
    Object localObject = zzb();
    if (localObject != null) {
      return (V)((Map)localObject).remove(paramObject);
    }
    localObject = zzb(paramObject);
    paramObject = localObject;
    if (localObject == zzd) {
      paramObject = null;
    }
    return (V)paramObject;
  }
  
  public final int size()
  {
    Map localMap = zzb();
    if (localMap != null) {
      return localMap.size();
    }
    return this.zzg;
  }
  
  public final Collection<V> values()
  {
    Collection localCollection = this.zzj;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new zzai(this);
      this.zzj = ((Collection)localObject);
    }
    return (Collection<V>)localObject;
  }
  
  final int zza(int paramInt)
  {
    
    if (paramInt < this.zzg) {
      return paramInt;
    }
    return -1;
  }
  
  final void zza(int paramInt1, int paramInt2)
  {
    int i = size() - 1;
    if (paramInt1 < i)
    {
      Object localObject1 = this.zzb;
      Object localObject2 = localObject1[i];
      localObject1[paramInt1] = localObject2;
      Object[] arrayOfObject = this.zzc;
      arrayOfObject[paramInt1] = arrayOfObject[i];
      localObject1[i] = null;
      arrayOfObject[i] = null;
      localObject1 = this.zza;
      localObject1[paramInt1] = localObject1[i];
      localObject1[i] = 0;
      int j = zzak.zza(localObject2) & paramInt2;
      int k = zzal.zza(this.zze, j);
      int m = i + 1;
      i = k;
      if (k == m)
      {
        zzal.zza(this.zze, j, paramInt1 + 1);
        return;
      }
      for (;;)
      {
        k = i - 1;
        localObject2 = this.zza;
        j = localObject2[k];
        i = j & paramInt2;
        if (i == m)
        {
          localObject2[k] = zzal.zza(j, paramInt1 + 1, paramInt2);
          return;
        }
      }
    }
    this.zzb[paramInt1] = null;
    this.zzc[paramInt1] = null;
    this.zza[paramInt1] = 0;
  }
  
  final boolean zza()
  {
    return this.zze == null;
  }
  
  @NullableDecl
  final Map<K, V> zzb()
  {
    Object localObject = this.zze;
    if ((localObject instanceof Map)) {
      return (Map)localObject;
    }
    return null;
  }
  
  final void zzc()
  {
    this.zzf += 32;
  }
  
  final int zzd()
  {
    if (isEmpty()) {
      return -1;
    }
    return 0;
  }
  
  final Iterator<K> zze()
  {
    Map localMap = zzb();
    if (localMap != null) {
      return localMap.keySet().iterator();
    }
    return new zzad(this);
  }
  
  final Iterator<Map.Entry<K, V>> zzf()
  {
    Map localMap = zzb();
    if (localMap != null) {
      return localMap.entrySet().iterator();
    }
    return new zzac(this);
  }
  
  final Iterator<V> zzg()
  {
    Map localMap = zzb();
    if (localMap != null) {
      return localMap.values().iterator();
    }
    return new zzaf(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */