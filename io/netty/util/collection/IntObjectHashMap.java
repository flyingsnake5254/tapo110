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

public class IntObjectHashMap<V>
  implements IntObjectMap<V>
{
  public static final int DEFAULT_CAPACITY = 8;
  public static final float DEFAULT_LOAD_FACTOR = 0.5F;
  private static final Object NULL_VALUE = new Object();
  private final Iterable<IntObjectMap.PrimitiveEntry<V>> entries = new Iterable()
  {
    public Iterator<IntObjectMap.PrimitiveEntry<V>> iterator()
    {
      return new IntObjectHashMap.PrimitiveIterator(IntObjectHashMap.this, null);
    }
  };
  private final Set<Map.Entry<Integer, V>> entrySet = new EntrySet(null);
  private final Set<Integer> keySet = new KeySet(null);
  private int[] keys;
  private final float loadFactor;
  private int mask;
  private int maxSize;
  private int size;
  private V[] values;
  
  public IntObjectHashMap()
  {
    this(8, 0.5F);
  }
  
  public IntObjectHashMap(int paramInt)
  {
    this(paramInt, 0.5F);
  }
  
  public IntObjectHashMap(int paramInt, float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat <= 1.0F))
    {
      this.loadFactor = paramFloat;
      paramInt = MathUtil.safeFindNextPositivePowerOfTwo(paramInt);
      this.mask = (paramInt - 1);
      this.keys = new int[paramInt];
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
  
  private static int hashCode(int paramInt)
  {
    return paramInt;
  }
  
  private int hashIndex(int paramInt)
  {
    return hashCode(paramInt) & this.mask;
  }
  
  private int indexOf(int paramInt)
  {
    int i = hashIndex(paramInt);
    int j = i;
    int k;
    do
    {
      if (this.values[j] == null) {
        return -1;
      }
      if (paramInt == this.keys[j]) {
        return j;
      }
      k = probeNext(j);
      j = k;
    } while (k != i);
    return -1;
  }
  
  private int objectToKey(Object paramObject)
  {
    return ((Integer)paramObject).intValue();
  }
  
  private int probeNext(int paramInt)
  {
    return paramInt + 1 & this.mask;
  }
  
  private void rehash(int paramInt)
  {
    int[] arrayOfInt = this.keys;
    Object[] arrayOfObject1 = this.values;
    this.keys = new int[paramInt];
    this.values = new Object[paramInt];
    this.maxSize = calcMaxSize(paramInt);
    this.mask = (paramInt - 1);
    for (paramInt = 0; paramInt < arrayOfObject1.length; paramInt++)
    {
      Object localObject = arrayOfObject1[paramInt];
      if (localObject != null)
      {
        int i = arrayOfInt[paramInt];
        for (int j = hashIndex(i);; j = probeNext(j))
        {
          Object[] arrayOfObject2 = this.values;
          if (arrayOfObject2[j] == null)
          {
            this.keys[j] = i;
            arrayOfObject2[j] = localObject;
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
    this.keys[paramInt] = 0;
    this.values[paramInt] = null;
    i = probeNext(paramInt);
    Object localObject = this.values[i];
    int n;
    for (int j = paramInt; localObject != null; j = n)
    {
      int k = this.keys[i];
      int m = hashIndex(k);
      if ((i >= m) || ((m > j) && (j > i)))
      {
        n = j;
        if (m <= j)
        {
          n = j;
          if (j > i) {}
        }
      }
      else
      {
        int[] arrayOfInt = this.keys;
        arrayOfInt[j] = k;
        Object[] arrayOfObject = this.values;
        arrayOfObject[j] = localObject;
        arrayOfInt[i] = 0;
        arrayOfObject[i] = null;
        n = i;
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
    Arrays.fill(this.keys, 0);
    Arrays.fill(this.values, null);
    this.size = 0;
  }
  
  public boolean containsKey(int paramInt)
  {
    boolean bool;
    if (indexOf(paramInt) >= 0) {
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
    paramObject = toInternal(paramObject);
    for (Object localObject : this.values) {
      if ((localObject != null) && (localObject.equals(paramObject))) {
        return true;
      }
    }
    return false;
  }
  
  public Iterable<IntObjectMap.PrimitiveEntry<V>> entries()
  {
    return this.entries;
  }
  
  public Set<Map.Entry<Integer, V>> entrySet()
  {
    return this.entrySet;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof IntObjectMap)) {
      return false;
    }
    paramObject = (IntObjectMap)paramObject;
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
        localObject1 = ((IntObjectMap)paramObject).get(this.keys[i]);
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
  
  public V get(int paramInt)
  {
    paramInt = indexOf(paramInt);
    Object localObject;
    if (paramInt == -1) {
      localObject = null;
    } else {
      localObject = toExternal(this.values[paramInt]);
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
    int[] arrayOfInt = this.keys;
    int j = arrayOfInt.length;
    for (int k = 0; k < j; k++) {
      i ^= hashCode(arrayOfInt[k]);
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
  
  public Set<Integer> keySet()
  {
    return this.keySet;
  }
  
  protected String keyToString(int paramInt)
  {
    return Integer.toString(paramInt);
  }
  
  public V put(int paramInt, V paramV)
  {
    int i = hashIndex(paramInt);
    int j = i;
    do
    {
      Object[] arrayOfObject = this.values;
      if (arrayOfObject[j] == null)
      {
        this.keys[j] = paramInt;
        arrayOfObject[j] = toInternal(paramV);
        growSize();
        return null;
      }
      if (this.keys[j] == paramInt)
      {
        Object localObject = arrayOfObject[j];
        arrayOfObject[j] = toInternal(paramV);
        return (V)toExternal(localObject);
      }
      j = probeNext(j);
    } while (j != i);
    throw new IllegalStateException("Unable to insert");
  }
  
  public V put(Integer paramInteger, V paramV)
  {
    return (V)put(objectToKey(paramInteger), paramV);
  }
  
  public void putAll(Map<? extends Integer, ? extends V> paramMap)
  {
    if ((paramMap instanceof IntObjectHashMap))
    {
      paramMap = (IntObjectHashMap)paramMap;
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
      put((Integer)paramMap.getKey(), paramMap.getValue());
    }
  }
  
  public V remove(int paramInt)
  {
    paramInt = indexOf(paramInt);
    if (paramInt == -1) {
      return null;
    }
    Object localObject = this.values[paramInt];
    removeAt(paramInt);
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
          final IntObjectHashMap<V>.PrimitiveIterator iter = new IntObjectHashMap.PrimitiveIterator(IntObjectHashMap.this, null);
          
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
        return IntObjectHashMap.this.size;
      }
    };
  }
  
  private final class EntrySet
    extends AbstractSet<Map.Entry<Integer, V>>
  {
    private EntrySet() {}
    
    public Iterator<Map.Entry<Integer, V>> iterator()
    {
      return new IntObjectHashMap.MapIterator(IntObjectHashMap.this, null);
    }
    
    public int size()
    {
      return IntObjectHashMap.this.size();
    }
  }
  
  private final class KeySet
    extends AbstractSet<Integer>
  {
    private KeySet() {}
    
    public void clear()
    {
      IntObjectHashMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return IntObjectHashMap.this.containsKey(paramObject);
    }
    
    public Iterator<Integer> iterator()
    {
      new Iterator()
      {
        private final Iterator<Map.Entry<Integer, V>> iter = IntObjectHashMap.this.entrySet.iterator();
        
        public boolean hasNext()
        {
          return this.iter.hasNext();
        }
        
        public Integer next()
        {
          return (Integer)((Map.Entry)this.iter.next()).getKey();
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
      if (IntObjectHashMap.this.remove(paramObject) != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      Iterator localIterator = IntObjectHashMap.this.entries().iterator();
      boolean bool = false;
      while (localIterator.hasNext()) {
        if (!paramCollection.contains(Integer.valueOf(((IntObjectMap.PrimitiveEntry)localIterator.next()).key())))
        {
          bool = true;
          localIterator.remove();
        }
      }
      return bool;
    }
    
    public int size()
    {
      return IntObjectHashMap.this.size();
    }
  }
  
  final class MapEntry
    implements Map.Entry<Integer, V>
  {
    private final int entryIndex;
    
    MapEntry(int paramInt)
    {
      this.entryIndex = paramInt;
    }
    
    private void verifyExists()
    {
      if (IntObjectHashMap.this.values[this.entryIndex] != null) {
        return;
      }
      throw new IllegalStateException("The map entry has been removed");
    }
    
    public Integer getKey()
    {
      verifyExists();
      return Integer.valueOf(IntObjectHashMap.this.keys[this.entryIndex]);
    }
    
    public V getValue()
    {
      verifyExists();
      return (V)IntObjectHashMap.toExternal(IntObjectHashMap.this.values[this.entryIndex]);
    }
    
    public V setValue(V paramV)
    {
      verifyExists();
      Object localObject = IntObjectHashMap.toExternal(IntObjectHashMap.this.values[this.entryIndex]);
      IntObjectHashMap.this.values[this.entryIndex] = IntObjectHashMap.toInternal(paramV);
      return (V)localObject;
    }
  }
  
  private final class MapIterator
    implements Iterator<Map.Entry<Integer, V>>
  {
    private final IntObjectHashMap<V>.PrimitiveIterator iter = new IntObjectHashMap.PrimitiveIterator(IntObjectHashMap.this, null);
    
    private MapIterator() {}
    
    public boolean hasNext()
    {
      return this.iter.hasNext();
    }
    
    public Map.Entry<Integer, V> next()
    {
      if (hasNext())
      {
        this.iter.next();
        return new IntObjectHashMap.MapEntry(IntObjectHashMap.this, IntObjectHashMap.PrimitiveIterator.access$1100(this.iter));
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      this.iter.remove();
    }
  }
  
  private final class PrimitiveIterator
    implements Iterator<IntObjectMap.PrimitiveEntry<V>>, IntObjectMap.PrimitiveEntry<V>
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
      } while ((i != IntObjectHashMap.this.values.length) && (IntObjectHashMap.this.values[this.nextIndex] == null));
    }
    
    public boolean hasNext()
    {
      if (this.nextIndex == -1) {
        scanNext();
      }
      boolean bool;
      if (this.nextIndex != IntObjectHashMap.this.values.length) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int key()
    {
      return IntObjectHashMap.this.keys[this.entryIndex];
    }
    
    public IntObjectMap.PrimitiveEntry<V> next()
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
        if (IntObjectHashMap.this.removeAt(i)) {
          this.nextIndex = this.prevIndex;
        }
        this.prevIndex = -1;
        return;
      }
      throw new IllegalStateException("next must be called before each remove.");
    }
    
    public void setValue(V paramV)
    {
      IntObjectHashMap.this.values[this.entryIndex] = IntObjectHashMap.toInternal(paramV);
    }
    
    public V value()
    {
      return (V)IntObjectHashMap.toExternal(IntObjectHashMap.this.values[this.entryIndex]);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\IntObjectHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */