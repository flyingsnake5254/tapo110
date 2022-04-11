package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class HashBiMap<K, V>
  extends AbstractMap<K, V>
  implements t<K, V>, Serializable
{
  private static final int ABSENT = -1;
  private static final int ENDPOINT = -2;
  private transient Set<Map.Entry<K, V>> entrySet;
  @NullableDecl
  private transient int firstInInsertionOrder;
  private transient int[] hashTableKToV;
  private transient int[] hashTableVToK;
  @MonotonicNonNullDecl
  @RetainedWith
  private transient t<V, K> inverse;
  private transient Set<K> keySet;
  transient K[] keys;
  @NullableDecl
  private transient int lastInInsertionOrder;
  transient int modCount;
  private transient int[] nextInBucketKToV;
  private transient int[] nextInBucketVToK;
  private transient int[] nextInInsertionOrder;
  private transient int[] prevInInsertionOrder;
  transient int size;
  private transient Set<V> valueSet;
  transient V[] values;
  
  private HashBiMap(int paramInt)
  {
    init(paramInt);
  }
  
  private int bucket(int paramInt)
  {
    return paramInt & this.hashTableKToV.length - 1;
  }
  
  public static <K, V> HashBiMap<K, V> create()
  {
    return create(16);
  }
  
  public static <K, V> HashBiMap<K, V> create(int paramInt)
  {
    return new HashBiMap(paramInt);
  }
  
  public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> paramMap)
  {
    HashBiMap localHashBiMap = create(paramMap.size());
    localHashBiMap.putAll(paramMap);
    return localHashBiMap;
  }
  
  private static int[] createFilledWithAbsent(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    Arrays.fill(arrayOfInt, -1);
    return arrayOfInt;
  }
  
  private void deleteFromTableKToV(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramInt1 != -1) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    paramInt2 = bucket(paramInt2);
    Object localObject = this.hashTableKToV;
    if (localObject[paramInt2] == paramInt1)
    {
      int[] arrayOfInt = this.nextInBucketKToV;
      localObject[paramInt2] = arrayOfInt[paramInt1];
      arrayOfInt[paramInt1] = -1;
      return;
    }
    int i = localObject[paramInt2];
    for (paramInt2 = this.nextInBucketKToV[i];; paramInt2 = this.nextInBucketKToV[i])
    {
      int j = i;
      i = paramInt2;
      if (i == -1) {
        break;
      }
      if (i == paramInt1)
      {
        localObject = this.nextInBucketKToV;
        localObject[j] = localObject[paramInt1];
        localObject[paramInt1] = -1;
        return;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected to find entry with key ");
    ((StringBuilder)localObject).append(this.keys[paramInt1]);
    throw new AssertionError(((StringBuilder)localObject).toString());
  }
  
  private void deleteFromTableVToK(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramInt1 != -1) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    paramInt2 = bucket(paramInt2);
    Object localObject = this.hashTableVToK;
    if (localObject[paramInt2] == paramInt1)
    {
      int[] arrayOfInt = this.nextInBucketVToK;
      localObject[paramInt2] = arrayOfInt[paramInt1];
      arrayOfInt[paramInt1] = -1;
      return;
    }
    int i = localObject[paramInt2];
    for (paramInt2 = this.nextInBucketVToK[i];; paramInt2 = this.nextInBucketVToK[i])
    {
      int j = i;
      i = paramInt2;
      if (i == -1) {
        break;
      }
      if (i == paramInt1)
      {
        localObject = this.nextInBucketVToK;
        localObject[j] = localObject[paramInt1];
        localObject[paramInt1] = -1;
        return;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected to find entry with value ");
    ((StringBuilder)localObject).append(this.values[paramInt1]);
    throw new AssertionError(((StringBuilder)localObject).toString());
  }
  
  private void ensureCapacity(int paramInt)
  {
    int[] arrayOfInt1 = this.nextInBucketKToV;
    int i;
    if (arrayOfInt1.length < paramInt)
    {
      i = ImmutableCollection.b.e(arrayOfInt1.length, paramInt);
      this.keys = Arrays.copyOf(this.keys, i);
      this.values = Arrays.copyOf(this.values, i);
      this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, i);
      this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, i);
      this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, i);
      this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, i);
    }
    if (this.hashTableKToV.length < paramInt)
    {
      paramInt = y0.a(paramInt, 1.0D);
      this.hashTableKToV = createFilledWithAbsent(paramInt);
      this.hashTableVToK = createFilledWithAbsent(paramInt);
      for (paramInt = 0; paramInt < this.size; paramInt++)
      {
        i = bucket(y0.d(this.keys[paramInt]));
        arrayOfInt1 = this.nextInBucketKToV;
        int[] arrayOfInt2 = this.hashTableKToV;
        arrayOfInt1[paramInt] = arrayOfInt2[i];
        arrayOfInt2[i] = paramInt;
        i = bucket(y0.d(this.values[paramInt]));
        arrayOfInt2 = this.nextInBucketVToK;
        arrayOfInt1 = this.hashTableVToK;
        arrayOfInt2[paramInt] = arrayOfInt1[i];
        arrayOfInt1[i] = paramInt;
      }
    }
  }
  
  private static int[] expandAndFillWithAbsent(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt.length;
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramInt);
    Arrays.fill(paramArrayOfInt, i, paramInt, -1);
    return paramArrayOfInt;
  }
  
  private void insertIntoTableKToV(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramInt1 != -1) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    paramInt2 = bucket(paramInt2);
    int[] arrayOfInt1 = this.nextInBucketKToV;
    int[] arrayOfInt2 = this.hashTableKToV;
    arrayOfInt1[paramInt1] = arrayOfInt2[paramInt2];
    arrayOfInt2[paramInt2] = paramInt1;
  }
  
  private void insertIntoTableVToK(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramInt1 != -1) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    paramInt2 = bucket(paramInt2);
    int[] arrayOfInt1 = this.nextInBucketVToK;
    int[] arrayOfInt2 = this.hashTableVToK;
    arrayOfInt1[paramInt1] = arrayOfInt2[paramInt2];
    arrayOfInt2[paramInt2] = paramInt1;
  }
  
  private void moveEntryToIndex(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    int i = this.prevInInsertionOrder[paramInt1];
    int j = this.nextInInsertionOrder[paramInt1];
    setSucceeds(i, paramInt2);
    setSucceeds(paramInt2, j);
    Object[] arrayOfObject1 = this.keys;
    Object localObject1 = arrayOfObject1[paramInt1];
    Object[] arrayOfObject2 = this.values;
    Object localObject2 = arrayOfObject2[paramInt1];
    arrayOfObject1[paramInt2] = localObject1;
    arrayOfObject2[paramInt2] = localObject2;
    i = bucket(y0.d(localObject1));
    localObject1 = this.hashTableKToV;
    if (localObject1[i] == paramInt1) {
      localObject1[i] = paramInt2;
    } else {
      j = localObject1[i];
    }
    int k;
    for (i = this.nextInBucketKToV[j];; i = k)
    {
      if (i == paramInt1)
      {
        this.nextInBucketKToV[j] = paramInt2;
        localObject1 = this.nextInBucketKToV;
        localObject1[paramInt2] = localObject1[paramInt1];
        localObject1[paramInt1] = -1;
        i = bucket(y0.d(localObject2));
        localObject2 = this.hashTableVToK;
        if (localObject2[i] == paramInt1) {
          localObject2[i] = paramInt2;
        } else {
          j = localObject2[i];
        }
        for (i = this.nextInBucketVToK[j];; i = k)
        {
          if (i == paramInt1)
          {
            this.nextInBucketVToK[j] = paramInt2;
            localObject2 = this.nextInBucketVToK;
            localObject2[paramInt2] = localObject2[paramInt1];
            localObject2[paramInt1] = -1;
            return;
          }
          k = this.nextInBucketVToK[i];
          j = i;
        }
      }
      k = this.nextInBucketKToV[i];
      j = i;
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int i = r2.h(paramObjectInputStream);
    init(16);
    r2.c(this, paramObjectInputStream, i);
  }
  
  private void removeEntry(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramInt1 != -1) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    deleteFromTableKToV(paramInt1, paramInt2);
    deleteFromTableVToK(paramInt1, paramInt3);
    setSucceeds(this.prevInInsertionOrder[paramInt1], this.nextInInsertionOrder[paramInt1]);
    moveEntryToIndex(this.size - 1, paramInt1);
    Object[] arrayOfObject = this.keys;
    paramInt1 = this.size;
    arrayOfObject[(paramInt1 - 1)] = null;
    this.values[(paramInt1 - 1)] = null;
    this.size = (paramInt1 - 1);
    this.modCount += 1;
  }
  
  private void replaceKeyInEntry(int paramInt, @NullableDecl K paramK, boolean paramBoolean)
  {
    boolean bool;
    if (paramInt != -1) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    int i = y0.d(paramK);
    int j = findEntryByKey(paramK, i);
    int k = this.lastInInsertionOrder;
    int m = -2;
    int n = paramInt;
    if (j != -1) {
      if (paramBoolean)
      {
        int i1 = this.prevInInsertionOrder[j];
        int i2 = this.nextInInsertionOrder[j];
        removeEntryKeyHashKnown(j, i);
        k = i1;
        m = i2;
        n = paramInt;
        if (paramInt == this.size)
        {
          n = j;
          k = i1;
          m = i2;
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Key already present in map: ");
        localStringBuilder.append(paramK);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    if (k == n)
    {
      paramInt = this.prevInInsertionOrder[n];
    }
    else
    {
      paramInt = k;
      if (k == this.size) {
        paramInt = j;
      }
    }
    if (m == n) {
      j = this.nextInInsertionOrder[n];
    } else if (m != this.size) {
      j = m;
    }
    setSucceeds(this.prevInInsertionOrder[n], this.nextInInsertionOrder[n]);
    deleteFromTableKToV(n, y0.d(this.keys[n]));
    this.keys[n] = paramK;
    insertIntoTableKToV(n, y0.d(paramK));
    setSucceeds(paramInt, n);
    setSucceeds(n, j);
  }
  
  private void replaceValueInEntry(int paramInt, @NullableDecl V paramV, boolean paramBoolean)
  {
    boolean bool;
    if (paramInt != -1) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    int i = y0.d(paramV);
    int j = findEntryByValue(paramV, i);
    int k = paramInt;
    if (j != -1) {
      if (paramBoolean)
      {
        removeEntryValueHashKnown(j, i);
        k = paramInt;
        if (paramInt == this.size) {
          k = j;
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Value already present in map: ");
        localStringBuilder.append(paramV);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    deleteFromTableVToK(k, y0.d(this.values[k]));
    this.values[k] = paramV;
    insertIntoTableVToK(k, i);
  }
  
  private void setSucceeds(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -2) {
      this.firstInInsertionOrder = paramInt2;
    } else {
      this.nextInInsertionOrder[paramInt1] = paramInt2;
    }
    if (paramInt2 == -2) {
      this.lastInInsertionOrder = paramInt1;
    } else {
      this.prevInInsertionOrder[paramInt2] = paramInt1;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    r2.i(this, paramObjectOutputStream);
  }
  
  public void clear()
  {
    Arrays.fill(this.keys, 0, this.size, null);
    Arrays.fill(this.values, 0, this.size, null);
    Arrays.fill(this.hashTableKToV, -1);
    Arrays.fill(this.hashTableVToK, -1);
    Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
    Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
    Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
    Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
    this.size = 0;
    this.firstInInsertionOrder = -2;
    this.lastInInsertionOrder = -2;
    this.modCount += 1;
  }
  
  public boolean containsKey(@NullableDecl Object paramObject)
  {
    boolean bool;
    if (findEntryByKey(paramObject) != -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    boolean bool;
    if (findEntryByValue(paramObject) != -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet = this.entrySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new c();
      this.entrySet = ((Set)localObject);
    }
    return (Set<Map.Entry<K, V>>)localObject;
  }
  
  int findEntry(@NullableDecl Object paramObject, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, Object[] paramArrayOfObject)
  {
    for (paramInt = paramArrayOfInt1[bucket(paramInt)]; paramInt != -1; paramInt = paramArrayOfInt2[paramInt]) {
      if (k.a(paramArrayOfObject[paramInt], paramObject)) {
        return paramInt;
      }
    }
    return -1;
  }
  
  int findEntryByKey(@NullableDecl Object paramObject)
  {
    return findEntryByKey(paramObject, y0.d(paramObject));
  }
  
  int findEntryByKey(@NullableDecl Object paramObject, int paramInt)
  {
    return findEntry(paramObject, paramInt, this.hashTableKToV, this.nextInBucketKToV, this.keys);
  }
  
  int findEntryByValue(@NullableDecl Object paramObject)
  {
    return findEntryByValue(paramObject, y0.d(paramObject));
  }
  
  int findEntryByValue(@NullableDecl Object paramObject, int paramInt)
  {
    return findEntry(paramObject, paramInt, this.hashTableVToK, this.nextInBucketVToK, this.values);
  }
  
  @NullableDecl
  @CanIgnoreReturnValue
  public V forcePut(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    return (V)put(paramK, paramV, true);
  }
  
  @NullableDecl
  public V get(@NullableDecl Object paramObject)
  {
    int i = findEntryByKey(paramObject);
    if (i == -1) {
      paramObject = null;
    } else {
      paramObject = this.values[i];
    }
    return (V)paramObject;
  }
  
  @NullableDecl
  K getInverse(@NullableDecl Object paramObject)
  {
    int i = findEntryByValue(paramObject);
    if (i == -1) {
      paramObject = null;
    } else {
      paramObject = this.keys[i];
    }
    return (K)paramObject;
  }
  
  void init(int paramInt)
  {
    v.b(paramInt, "expectedSize");
    int i = y0.a(paramInt, 1.0D);
    this.size = 0;
    this.keys = new Object[paramInt];
    this.values = new Object[paramInt];
    this.hashTableKToV = createFilledWithAbsent(i);
    this.hashTableVToK = createFilledWithAbsent(i);
    this.nextInBucketKToV = createFilledWithAbsent(paramInt);
    this.nextInBucketVToK = createFilledWithAbsent(paramInt);
    this.firstInInsertionOrder = -2;
    this.lastInInsertionOrder = -2;
    this.prevInInsertionOrder = createFilledWithAbsent(paramInt);
    this.nextInInsertionOrder = createFilledWithAbsent(paramInt);
  }
  
  public t<V, K> inverse()
  {
    t localt = this.inverse;
    Object localObject = localt;
    if (localt == null)
    {
      localObject = new d(this);
      this.inverse = ((t)localObject);
    }
    return (t<V, K>)localObject;
  }
  
  public Set<K> keySet()
  {
    Set localSet = this.keySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new f();
      this.keySet = ((Set)localObject);
    }
    return (Set<K>)localObject;
  }
  
  @CanIgnoreReturnValue
  public V put(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    return (V)put(paramK, paramV, false);
  }
  
  @NullableDecl
  V put(@NullableDecl K paramK, @NullableDecl V paramV, boolean paramBoolean)
  {
    int i = y0.d(paramK);
    int j = findEntryByKey(paramK, i);
    if (j != -1)
    {
      paramK = this.values[j];
      if (k.a(paramK, paramV)) {
        return paramV;
      }
      replaceValueInEntry(j, paramV, paramBoolean);
      return paramK;
    }
    j = y0.d(paramV);
    int k = findEntryByValue(paramV, j);
    if (paramBoolean)
    {
      if (k != -1) {
        removeEntryValueHashKnown(k, j);
      }
    }
    else
    {
      if (k == -1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      n.j(paramBoolean, "Value already present: %s", paramV);
    }
    ensureCapacity(this.size + 1);
    Object[] arrayOfObject = this.keys;
    k = this.size;
    arrayOfObject[k] = paramK;
    this.values[k] = paramV;
    insertIntoTableKToV(k, i);
    insertIntoTableVToK(this.size, j);
    setSucceeds(this.lastInInsertionOrder, this.size);
    setSucceeds(this.size, -2);
    this.size += 1;
    this.modCount += 1;
    return null;
  }
  
  @NullableDecl
  K putInverse(@NullableDecl V paramV, @NullableDecl K paramK, boolean paramBoolean)
  {
    int i = y0.d(paramV);
    int j = findEntryByValue(paramV, i);
    if (j != -1)
    {
      paramV = this.keys[j];
      if (k.a(paramV, paramK)) {
        return paramK;
      }
      replaceKeyInEntry(j, paramK, paramBoolean);
      return paramV;
    }
    j = this.lastInInsertionOrder;
    int k = y0.d(paramK);
    int m = findEntryByKey(paramK, k);
    if (paramBoolean)
    {
      if (m != -1)
      {
        j = this.prevInInsertionOrder[m];
        removeEntryKeyHashKnown(m, k);
      }
    }
    else
    {
      if (m == -1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      n.j(paramBoolean, "Key already present: %s", paramK);
    }
    ensureCapacity(this.size + 1);
    Object[] arrayOfObject = this.keys;
    m = this.size;
    arrayOfObject[m] = paramK;
    this.values[m] = paramV;
    insertIntoTableKToV(m, k);
    insertIntoTableVToK(this.size, i);
    if (j == -2) {
      i = this.firstInInsertionOrder;
    } else {
      i = this.nextInInsertionOrder[j];
    }
    setSucceeds(j, this.size);
    setSucceeds(this.size, i);
    this.size += 1;
    this.modCount += 1;
    return null;
  }
  
  @NullableDecl
  @CanIgnoreReturnValue
  public V remove(@NullableDecl Object paramObject)
  {
    int i = y0.d(paramObject);
    int j = findEntryByKey(paramObject, i);
    if (j == -1) {
      return null;
    }
    paramObject = this.values[j];
    removeEntryKeyHashKnown(j, i);
    return (V)paramObject;
  }
  
  void removeEntry(int paramInt)
  {
    removeEntryKeyHashKnown(paramInt, y0.d(this.keys[paramInt]));
  }
  
  void removeEntryKeyHashKnown(int paramInt1, int paramInt2)
  {
    removeEntry(paramInt1, paramInt2, y0.d(this.values[paramInt1]));
  }
  
  void removeEntryValueHashKnown(int paramInt1, int paramInt2)
  {
    removeEntry(paramInt1, y0.d(this.keys[paramInt1]), paramInt2);
  }
  
  @NullableDecl
  K removeInverse(@NullableDecl Object paramObject)
  {
    int i = y0.d(paramObject);
    int j = findEntryByValue(paramObject, i);
    if (j == -1) {
      return null;
    }
    paramObject = this.keys[j];
    removeEntryValueHashKnown(j, i);
    return (K)paramObject;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public Set<V> values()
  {
    Set localSet = this.valueSet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new g();
      this.valueSet = ((Set)localObject);
    }
    return (Set<V>)localObject;
  }
  
  final class a
    extends g<K, V>
  {
    @NullableDecl
    final K c = HashBiMap.this.keys[paramInt];
    int d;
    
    a(int paramInt)
    {
      this.d = paramInt;
    }
    
    void g()
    {
      int i = this.d;
      if (i != -1)
      {
        HashBiMap localHashBiMap = HashBiMap.this;
        if ((i <= localHashBiMap.size) && (k.a(localHashBiMap.keys[i], this.c))) {}
      }
      else
      {
        this.d = HashBiMap.this.findEntryByKey(this.c);
      }
    }
    
    public K getKey()
    {
      return (K)this.c;
    }
    
    @NullableDecl
    public V getValue()
    {
      g();
      int i = this.d;
      Object localObject;
      if (i == -1) {
        localObject = null;
      } else {
        localObject = HashBiMap.this.values[i];
      }
      return (V)localObject;
    }
    
    public V setValue(V paramV)
    {
      g();
      int i = this.d;
      if (i == -1) {
        return (V)HashBiMap.this.put(this.c, paramV);
      }
      Object localObject = HashBiMap.this.values[i];
      if (k.a(localObject, paramV)) {
        return paramV;
      }
      HashBiMap.this.replaceValueInEntry(this.d, paramV, false);
      return (V)localObject;
    }
  }
  
  static final class b<K, V>
    extends g<V, K>
  {
    final HashBiMap<K, V> c;
    final V d;
    int f;
    
    b(HashBiMap<K, V> paramHashBiMap, int paramInt)
    {
      this.c = paramHashBiMap;
      this.d = paramHashBiMap.values[paramInt];
      this.f = paramInt;
    }
    
    private void g()
    {
      int i = this.f;
      if (i != -1)
      {
        HashBiMap localHashBiMap = this.c;
        if ((i <= localHashBiMap.size) && (k.a(this.d, localHashBiMap.values[i]))) {}
      }
      else
      {
        this.f = this.c.findEntryByValue(this.d);
      }
    }
    
    public V getKey()
    {
      return (V)this.d;
    }
    
    public K getValue()
    {
      g();
      int i = this.f;
      Object localObject;
      if (i == -1) {
        localObject = null;
      } else {
        localObject = this.c.keys[i];
      }
      return (K)localObject;
    }
    
    public K setValue(K paramK)
    {
      g();
      int i = this.f;
      if (i == -1) {
        return (K)this.c.putInverse(this.d, paramK, false);
      }
      Object localObject = this.c.keys[i];
      if (k.a(localObject, paramK)) {
        return paramK;
      }
      this.c.replaceKeyInEntry(this.f, paramK, false);
      return (K)localObject;
    }
  }
  
  final class c
    extends HashBiMap.h<K, V, Map.Entry<K, V>>
  {
    c()
    {
      super();
    }
    
    Map.Entry<K, V> b(int paramInt)
    {
      return new HashBiMap.a(HashBiMap.this, paramInt);
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        Object localObject = (Map.Entry)paramObject;
        paramObject = ((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        int i = HashBiMap.this.findEntryByKey(paramObject);
        bool3 = bool2;
        if (i != -1)
        {
          bool3 = bool2;
          if (k.a(localObject, HashBiMap.this.values[i])) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object paramObject)
    {
      if ((paramObject instanceof Map.Entry))
      {
        Object localObject = (Map.Entry)paramObject;
        paramObject = ((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        int i = y0.d(paramObject);
        int j = HashBiMap.this.findEntryByKey(paramObject, i);
        if ((j != -1) && (k.a(localObject, HashBiMap.this.values[j])))
        {
          HashBiMap.this.removeEntryKeyHashKnown(j, i);
          return true;
        }
      }
      return false;
    }
  }
  
  static class d<K, V>
    extends AbstractMap<V, K>
    implements t<V, K>, Serializable
  {
    private final HashBiMap<K, V> c;
    private transient Set<Map.Entry<V, K>> d;
    
    d(HashBiMap<K, V> paramHashBiMap)
    {
      this.c = paramHashBiMap;
    }
    
    public Set<K> a()
    {
      return this.c.keySet();
    }
    
    public void clear()
    {
      this.c.clear();
    }
    
    public boolean containsKey(@NullableDecl Object paramObject)
    {
      return this.c.containsValue(paramObject);
    }
    
    public boolean containsValue(@NullableDecl Object paramObject)
    {
      return this.c.containsKey(paramObject);
    }
    
    public Set<Map.Entry<V, K>> entrySet()
    {
      Set localSet = this.d;
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new HashBiMap.e(this.c);
        this.d = ((Set)localObject);
      }
      return (Set<Map.Entry<V, K>>)localObject;
    }
    
    @NullableDecl
    public K get(@NullableDecl Object paramObject)
    {
      return (K)this.c.getInverse(paramObject);
    }
    
    public Set<V> keySet()
    {
      return this.c.values();
    }
    
    @NullableDecl
    @CanIgnoreReturnValue
    public K put(@NullableDecl V paramV, @NullableDecl K paramK)
    {
      return (K)this.c.putInverse(paramV, paramK, false);
    }
    
    @NullableDecl
    @CanIgnoreReturnValue
    public K remove(@NullableDecl Object paramObject)
    {
      return (K)this.c.removeInverse(paramObject);
    }
    
    public int size()
    {
      return this.c.size;
    }
  }
  
  static class e<K, V>
    extends HashBiMap.h<K, V, Map.Entry<V, K>>
  {
    e(HashBiMap<K, V> paramHashBiMap)
    {
      super();
    }
    
    Map.Entry<V, K> b(int paramInt)
    {
      return new HashBiMap.b(this.c, paramInt);
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        Object localObject = (Map.Entry)paramObject;
        paramObject = ((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        int i = this.c.findEntryByValue(paramObject);
        bool3 = bool2;
        if (i != -1)
        {
          bool3 = bool2;
          if (k.a(this.c.keys[i], localObject)) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    public boolean remove(Object paramObject)
    {
      if ((paramObject instanceof Map.Entry))
      {
        Object localObject = (Map.Entry)paramObject;
        paramObject = ((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        int i = y0.d(paramObject);
        int j = this.c.findEntryByValue(paramObject, i);
        if ((j != -1) && (k.a(this.c.keys[j], localObject)))
        {
          this.c.removeEntryValueHashKnown(j, i);
          return true;
        }
      }
      return false;
    }
  }
  
  final class f
    extends HashBiMap.h<K, V, K>
  {
    f()
    {
      super();
    }
    
    K a(int paramInt)
    {
      return (K)HashBiMap.this.keys[paramInt];
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      return HashBiMap.this.containsKey(paramObject);
    }
    
    public boolean remove(@NullableDecl Object paramObject)
    {
      int i = y0.d(paramObject);
      int j = HashBiMap.this.findEntryByKey(paramObject, i);
      if (j != -1)
      {
        HashBiMap.this.removeEntryKeyHashKnown(j, i);
        return true;
      }
      return false;
    }
  }
  
  final class g
    extends HashBiMap.h<K, V, V>
  {
    g()
    {
      super();
    }
    
    V a(int paramInt)
    {
      return (V)HashBiMap.this.values[paramInt];
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      return HashBiMap.this.containsValue(paramObject);
    }
    
    public boolean remove(@NullableDecl Object paramObject)
    {
      int i = y0.d(paramObject);
      int j = HashBiMap.this.findEntryByValue(paramObject, i);
      if (j != -1)
      {
        HashBiMap.this.removeEntryValueHashKnown(j, i);
        return true;
      }
      return false;
    }
  }
  
  static abstract class h<K, V, T>
    extends AbstractSet<T>
  {
    final HashBiMap<K, V> c;
    
    h(HashBiMap<K, V> paramHashBiMap)
    {
      this.c = paramHashBiMap;
    }
    
    abstract T a(int paramInt);
    
    public void clear()
    {
      this.c.clear();
    }
    
    public Iterator<T> iterator()
    {
      return new a();
    }
    
    public int size()
    {
      return this.c.size;
    }
    
    class a
      implements Iterator<T>
    {
      private int c = HashBiMap.h.this.c.firstInInsertionOrder;
      private int d = -1;
      private int f;
      private int q;
      
      a()
      {
        this$1 = HashBiMap.h.this.c;
        this.f = HashBiMap.h.this.modCount;
        this.q = HashBiMap.h.this.size;
      }
      
      private void a()
      {
        if (HashBiMap.h.this.c.modCount == this.f) {
          return;
        }
        throw new ConcurrentModificationException();
      }
      
      public boolean hasNext()
      {
        a();
        boolean bool;
        if ((this.c != -2) && (this.q > 0)) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public T next()
      {
        if (hasNext())
        {
          Object localObject = HashBiMap.h.this.a(this.c);
          this.d = this.c;
          this.c = HashBiMap.h.this.c.nextInInsertionOrder[this.c];
          this.q -= 1;
          return (T)localObject;
        }
        throw new NoSuchElementException();
      }
      
      public void remove()
      {
        a();
        boolean bool;
        if (this.d != -1) {
          bool = true;
        } else {
          bool = false;
        }
        v.e(bool);
        HashBiMap.h.this.c.removeEntry(this.d);
        int i = this.c;
        HashBiMap localHashBiMap = HashBiMap.h.this.c;
        if (i == localHashBiMap.size) {
          this.c = this.d;
        }
        this.d = -1;
        this.f = localHashBiMap.modCount;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\HashBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */