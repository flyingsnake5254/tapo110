package io.netty.util.collection;

import io.netty.util.internal.MathUtil;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public class LongObjectHashMap<V>
  implements LongObjectMap<V>
{
  public static final int DEFAULT_CAPACITY = 8;
  public static final float DEFAULT_LOAD_FACTOR = 0.5F;
  private static final Object NULL_VALUE = new Object();
  private final Iterable<LongObjectMap.PrimitiveEntry<V>> entries = new Iterable()
  {
    public Iterator<LongObjectMap.PrimitiveEntry<V>> iterator()
    {
      return new LongObjectHashMap.PrimitiveIterator(LongObjectHashMap.this, null);
    }
  };
  private final Set<Map.Entry<Long, V>> entrySet = new EntrySet(null);
  private final Set<Long> keySet = new KeySet(null);
  private long[] keys;
  private final float loadFactor;
  private int mask;
  private int maxSize;
  private int size;
  private V[] values;
  
  public LongObjectHashMap()
  {
    this(8, 0.5F);
  }
  
  public LongObjectHashMap(int paramInt)
  {
    this(paramInt, 0.5F);
  }
  
  public LongObjectHashMap(int paramInt, float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat <= 1.0F))
    {
      this.loadFactor = paramFloat;
      paramInt = MathUtil.safeFindNextPositivePowerOfTwo(paramInt);
      this.mask = (paramInt - 1);
      this.keys = new long[paramInt];
      this.values = new Object[paramInt];
      this.maxSize = calcMaxSize(paramInt);
      return;
    }
    throw new IllegalArgumentException("loadFactor must be > 0 and <= 1");
  }
  
  private int calcMaxSize(int paramInt)
  {
    return Math.min(paramInt - 1, (int)(paramInt * this.loadFactor));
  }
  
  private void growSize()
  {
    int i = this.size + 1;
    this.size = i;
    if (i > this.maxSize)
    {
      Object localObject = this.keys;
      if (localObject.length != Integer.MAX_VALUE)
      {
        rehash(localObject.length << 1);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Max capacity reached at size=");
        ((StringBuilder)localObject).append(this.size);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
  }
  
  private static int hashCode(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  private int hashIndex(long paramLong)
  {
    return hashCode(paramLong) & this.mask;
  }
  
  private int indexOf(long paramLong)
  {
    int i = hashIndex(paramLong);
    int j = i;
    int k;
    do
    {
      if (this.values[j] == null) {
        return -1;
      }
      if (paramLong == this.keys[j]) {
        return j;
      }
      k = probeNext(j);
      j = k;
    } while (k != i);
    return -1;
  }
  
  private long objectToKey(Object paramObject)
  {
    return ((Long)paramObject).longValue();
  }
  
  private int probeNext(int paramInt)
  {
    return paramInt + 1 & this.mask;
  }
  
  private void rehash(int paramInt)
  {
    long[] arrayOfLong = this.keys;
    Object[] arrayOfObject1 = this.values;
    this.keys = new long[paramInt];
    this.values = new Object[paramInt];
    this.maxSize = calcMaxSize(paramInt);
    this.mask = (paramInt - 1);
    for (paramInt = 0; paramInt < arrayOfObject1.length; paramInt++)
    {
      Object localObject = arrayOfObject1[paramInt];
      if (localObject != null)
      {
        long l = arrayOfLong[paramInt];
        for (int i = hashIndex(l);; i = probeNext(i))
        {
          Object[] arrayOfObject2 = this.values;
          if (arrayOfObject2[i] == null)
          {
            this.keys[i] = l;
            arrayOfObject2[i] = localObject;
            break;
          }
        }
      }
    }
  }
  
  private boolean removeAt(int paramInt)
  {
    int i = this.size;
    boolean bool = true;
    this.size = (i - 1);
    this.keys[paramInt] = 0L;
    this.values[paramInt] = null;
    i = probeNext(paramInt);
    Object localObject = this.values[i];
    int m;
    for (int j = paramInt; localObject != null; j = m)
    {
      long l = this.keys[i];
      int k = hashIndex(l);
      if ((i >= k) || ((k > j) && (j > i)))
      {
        m = j;
        if (k <= j)
        {
          m = j;
          if (j > i) {}
        }
      }
      else
      {
        long[] arrayOfLong = this.keys;
        arrayOfLong[j] = l;
        Object[] arrayOfObject = this.values;
        arrayOfObject[j] = localObject;
        arrayOfLong[i] = 0L;
        arrayOfObject[i] = null;
        m = i;
      }
      localObject = this.values;
      i = probeNext(i);
      localObject = localObject[i];
    }
    if (j == paramInt) {
      bool = false;
    }
    return bool;
  }
  
  private static <T> T toExternal(T paramT)
  {
    T ? = paramT;
    if (paramT == NULL_VALUE) {
      ? = null;
    }
    return ?;
  }
  
  private static <T> T toInternal(T paramT)
  {
    Object localObject = paramT;
    if (paramT == null) {
      localObject = NULL_VALUE;
    }
    return (T)localObject;
  }
  
  public void clear()
  {
    Arrays.fill(this.keys, 0L);
    Arrays.fill(this.values, null);
    this.size = 0;
  }
  
  public boolean containsKey(long paramLong)
  {
    boolean bool;
    if (indexOf(paramLong) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsKey(Object paramObject)
  {
    return containsKey(objectToKey(paramObject));
  }
  
  public boolean containsValue(Object paramObject)
  {
    Object localObject1 = toInternal(paramObject);
    for (Object localObject2 : this.values) {
      if ((localObject2 != null) && (localObject2.equals(localObject1))) {
        return true;
      }
    }
    return false;
  }
  
  public Iterable<LongObjectMap.PrimitiveEntry<V>> entries()
  {
    return this.entries;
  }
  
  public Set<Map.Entry<Long, V>> entrySet()
  {
    return this.entrySet;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LongObjectMap)) {
      return false;
    }
    paramObject = (LongObjectMap)paramObject;
    if (this.size != ((Map)paramObject).size()) {
      return false;
    }
    for (int i = 0;; i++)
    {
      Object localObject1 = this.values;
      if (i >= localObject1.length) {
        break;
      }
      Object localObject2 = localObject1[i];
      if (localObject2 != null)
      {
        localObject1 = ((LongObjectMap)paramObject).get(this.keys[i]);
        if (localObject2 == NULL_VALUE)
        {
          if (localObject1 != null) {
            return false;
          }
        }
        else if (!localObject2.equals(localObject1)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public V get(long paramLong)
  {
    int i = indexOf(paramLong);
    Object localObject;
    if (i == -1) {
      localObject = null;
    } else {
      localObject = toExternal(this.values[i]);
    }
    return (V)localObject;
  }
  
  public V get(Object paramObject)
  {
    return (V)get(objectToKey(paramObject));
  }
  
  public int hashCode()
  {
    int i = this.size;
    long[] arrayOfLong = this.keys;
    int j = arrayOfLong.length;
    for (int k = 0; k < j; k++) {
      i ^= hashCode(arrayOfLong[k]);
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.size == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Set<Long> keySet()
  {
    return this.keySet;
  }
  
  protected String keyToString(long paramLong)
  {
    return Long.toString(paramLong);
  }
  
  public V put(long paramLong, V paramV)
  {
    int i = hashIndex(paramLong);
    int j = i;
    do
    {
      Object[] arrayOfObject = this.values;
      if (arrayOfObject[j] == null)
      {
        this.keys[j] = paramLong;
        arrayOfObject[j] = toInternal(paramV);
        growSize();
        return null;
      }
      if (this.keys[j] == paramLong)
      {
        Object localObject = arrayOfObject[j];
        arrayOfObject[j] = toInternal(paramV);
        return (V)toExternal(localObject);
      }
      j = probeNext(j);
    } while (j != i);
    throw new IllegalStateException("Unable to insert");
  }
  
  public V put(Long paramLong, V paramV)
  {
    return (V)put(objectToKey(paramLong), paramV);
  }
  
  public void putAll(Map<? extends Long, ? extends V> paramMap)
  {
    if ((paramMap instanceof LongObjectHashMap))
    {
      paramMap = (LongObjectHashMap)paramMap;
      for (int i = 0;; i++)
      {
        localObject = paramMap.values;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          put(paramMap.keys[i], localObject);
        }
      }
      return;
    }
    Object localObject = paramMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramMap = (Map.Entry)((Iterator)localObject).next();
      put((Long)paramMap.getKey(), paramMap.getValue());
    }
  }
  
  public V remove(long paramLong)
  {
    int i = indexOf(paramLong);
    if (i == -1) {
      return null;
    }
    Object localObject = this.values[i];
    removeAt(i);
    return (V)toExternal(localObject);
  }
  
  public V remove(Object paramObject)
  {
    return (V)remove(objectToKey(paramObject));
  }
  
  public int size()
  {
    return this.size;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.size * 4);
    localStringBuilder.append('{');
    int i = 1;
    int j = 0;
    for (;;)
    {
      Object localObject = this.values;
      if (j >= localObject.length) {
        break;
      }
      localObject = localObject[j];
      int k = i;
      if (localObject != null)
      {
        if (i == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append(keyToString(this.keys[j]));
        localStringBuilder.append('=');
        if (localObject == this) {
          localObject = "(this Map)";
        } else {
          localObject = toExternal(localObject);
        }
        localStringBuilder.append(localObject);
        k = 0;
      }
      j++;
      i = k;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public Collection<V> values()
  {
    new AbstractCollection()
    {
      public Iterator<V> iterator()
      {
        new Iterator()
        {
          final LongObjectHashMap<V>.PrimitiveIterator iter = new LongObjectHashMap.PrimitiveIterator(LongObjectHashMap.this, null);
          
          public boolean hasNext()
          {
            return this.iter.hasNext();
          }
          
          public V next()
          {
            return (V)this.iter.next().value();
          }
          
          public void remove()
          {
            this.iter.remove();
          }
        };
      }
      
      public int size()
      {
        return LongObjectHashMap.this.size;
      }
    };
  }
  
  private final class EntrySet
    extends AbstractSet<Map.Entry<Long, V>>
  {
    private EntrySet() {}
    
    public Iterator<Map.Entry<Long, V>> iterator()
    {
      return new LongObjectHashMap.MapIterator(LongObjectHashMap.this, null);
    }
    
    public int size()
    {
      return LongObjectHashMap.this.size();
    }
  }
  
  private final class KeySet
    extends AbstractSet<Long>
  {
    private KeySet() {}
    
    public void clear()
    {
      LongObjectHashMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return LongObjectHashMap.this.containsKey(paramObject);
    }
    
    public Iterator<Long> iterator()
    {
      new Iterator()
      {
        private final Iterator<Map.Entry<Long, V>> iter = LongObjectHashMap.this.entrySet.iterator();
        
        public boolean hasNext()
        {
          return this.iter.hasNext();
        }
        
        public Long next()
        {
          return (Long)((Map.Entry)this.iter.next()).getKey();
        }
        
        public void remove()
        {
          this.iter.remove();
        }
      };
    }
    
    public boolean remove(Object paramObject)
    {
      boolean bool;
      if (LongObjectHashMap.this.remove(paramObject) != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      Iterator localIterator = LongObjectHashMap.this.entries().iterator();
      boolean bool = false;
      while (localIterator.hasNext()) {
        if (!paramCollection.contains(Long.valueOf(((LongObjectMap.PrimitiveEntry)localIterator.next()).key())))
        {
          bool = true;
          localIterator.remove();
        }
      }
      return bool;
    }
    
    public int size()
    {
      return LongObjectHashMap.this.size();
    }
  }
  
  final class MapEntry
    implements Map.Entry<Long, V>
  {
    private final int entryIndex;
    
    MapEntry(int paramInt)
    {
      this.entryIndex = paramInt;
    }
    
    private void verifyExists()
    {
      if (LongObjectHashMap.this.values[this.entryIndex] != null) {
        return;
      }
      throw new IllegalStateException("The map entry has been removed");
    }
    
    public Long getKey()
    {
      verifyExists();
      return Long.valueOf(LongObjectHashMap.this.keys[this.entryIndex]);
    }
    
    public V getValue()
    {
      verifyExists();
      return (V)LongObjectHashMap.toExternal(LongObjectHashMap.this.values[this.entryIndex]);
    }
    
    public V setValue(V paramV)
    {
      verifyExists();
      Object localObject = LongObjectHashMap.toExternal(LongObjectHashMap.this.values[this.entryIndex]);
      LongObjectHashMap.this.values[this.entryIndex] = LongObjectHashMap.toInternal(paramV);
      return (V)localObject;
    }
  }
  
  private final class MapIterator
    implements Iterator<Map.Entry<Long, V>>
  {
    private final LongObjectHashMap<V>.PrimitiveIterator iter = new LongObjectHashMap.PrimitiveIterator(LongObjectHashMap.this, null);
    
    private MapIterator() {}
    
    public boolean hasNext()
    {
      return this.iter.hasNext();
    }
    
    public Map.Entry<Long, V> next()
    {
      if (hasNext())
      {
        this.iter.next();
        return new LongObjectHashMap.MapEntry(LongObjectHashMap.this, LongObjectHashMap.PrimitiveIterator.access$1100(this.iter));
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      this.iter.remove();
    }
  }
  
  private final class PrimitiveIterator
    implements Iterator<LongObjectMap.PrimitiveEntry<V>>, LongObjectMap.PrimitiveEntry<V>
  {
    private int entryIndex = -1;
    private int nextIndex = -1;
    private int prevIndex = -1;
    
    private PrimitiveIterator() {}
    
    private void scanNext()
    {
      int i;
      do
      {
        i = this.nextIndex + 1;
        this.nextIndex = i;
      } while ((i != LongObjectHashMap.this.values.length) && (LongObjectHashMap.this.values[this.nextIndex] == null));
    }
    
    public boolean hasNext()
    {
      if (this.nextIndex == -1) {
        scanNext();
      }
      boolean bool;
      if (this.nextIndex != LongObjectHashMap.this.values.length) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public long key()
    {
      return LongObjectHashMap.this.keys[this.entryIndex];
    }
    
    public LongObjectMap.PrimitiveEntry<V> next()
    {
      if (hasNext())
      {
        this.prevIndex = this.nextIndex;
        scanNext();
        this.entryIndex = this.prevIndex;
        return this;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      int i = this.prevIndex;
      if (i != -1)
      {
        if (LongObjectHashMap.this.removeAt(i)) {
          this.nextIndex = this.prevIndex;
        }
        this.prevIndex = -1;
        return;
      }
      throw new IllegalStateException("next must be called before each remove.");
    }
    
    public void setValue(V paramV)
    {
      LongObjectHashMap.this.values[this.entryIndex] = LongObjectHashMap.toInternal(paramV);
    }
    
    public V value()
    {
      return (V)LongObjectHashMap.toExternal(LongObjectHashMap.this.values[this.entryIndex]);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\LongObjectHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */