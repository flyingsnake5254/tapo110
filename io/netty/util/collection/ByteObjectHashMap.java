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

public class ByteObjectHashMap<V>
  implements ByteObjectMap<V>
{
  public static final int DEFAULT_CAPACITY = 8;
  public static final float DEFAULT_LOAD_FACTOR = 0.5F;
  private static final Object NULL_VALUE = new Object();
  private final Iterable<ByteObjectMap.PrimitiveEntry<V>> entries = new Iterable()
  {
    public Iterator<ByteObjectMap.PrimitiveEntry<V>> iterator()
    {
      return new ByteObjectHashMap.PrimitiveIterator(ByteObjectHashMap.this, null);
    }
  };
  private final Set<Map.Entry<Byte, V>> entrySet = new EntrySet(null);
  private final Set<Byte> keySet = new KeySet(null);
  private byte[] keys;
  private final float loadFactor;
  private int mask;
  private int maxSize;
  private int size;
  private V[] values;
  
  public ByteObjectHashMap()
  {
    this(8, 0.5F);
  }
  
  public ByteObjectHashMap(int paramInt)
  {
    this(paramInt, 0.5F);
  }
  
  public ByteObjectHashMap(int paramInt, float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat <= 1.0F))
    {
      this.loadFactor = paramFloat;
      paramInt = MathUtil.safeFindNextPositivePowerOfTwo(paramInt);
      this.mask = (paramInt - 1);
      this.keys = new byte[paramInt];
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
  
  private static int hashCode(byte paramByte)
  {
    return paramByte;
  }
  
  private int hashIndex(byte paramByte)
  {
    return hashCode(paramByte) & this.mask;
  }
  
  private int indexOf(byte paramByte)
  {
    int i = hashIndex(paramByte);
    int j = i;
    int k;
    do
    {
      if (this.values[j] == null) {
        return -1;
      }
      if (paramByte == this.keys[j]) {
        return j;
      }
      k = probeNext(j);
      j = k;
    } while (k != i);
    return -1;
  }
  
  private byte objectToKey(Object paramObject)
  {
    return ((Byte)paramObject).byteValue();
  }
  
  private int probeNext(int paramInt)
  {
    return paramInt + 1 & this.mask;
  }
  
  private void rehash(int paramInt)
  {
    byte[] arrayOfByte = this.keys;
    Object[] arrayOfObject1 = this.values;
    this.keys = new byte[paramInt];
    this.values = new Object[paramInt];
    this.maxSize = calcMaxSize(paramInt);
    this.mask = (paramInt - 1);
    for (paramInt = 0; paramInt < arrayOfObject1.length; paramInt++)
    {
      Object localObject = arrayOfObject1[paramInt];
      if (localObject != null)
      {
        byte b = arrayOfByte[paramInt];
        for (int i = hashIndex(b);; i = probeNext(i))
        {
          Object[] arrayOfObject2 = this.values;
          if (arrayOfObject2[i] == null)
          {
            this.keys[i] = b;
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
    this.keys[paramInt] = ((byte)0);
    this.values[paramInt] = null;
    i = probeNext(paramInt);
    Object localObject = this.values[i];
    int m;
    for (int j = paramInt; localObject != null; j = m)
    {
      byte b = this.keys[i];
      int k = hashIndex(b);
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
        byte[] arrayOfByte = this.keys;
        arrayOfByte[j] = b;
        Object[] arrayOfObject = this.values;
        arrayOfObject[j] = localObject;
        arrayOfByte[i] = ((byte)0);
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
    Arrays.fill(this.keys, (byte)0);
    Arrays.fill(this.values, null);
    this.size = 0;
  }
  
  public boolean containsKey(byte paramByte)
  {
    boolean bool;
    if (indexOf(paramByte) >= 0) {
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
  
  public Iterable<ByteObjectMap.PrimitiveEntry<V>> entries()
  {
    return this.entries;
  }
  
  public Set<Map.Entry<Byte, V>> entrySet()
  {
    return this.entrySet;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ByteObjectMap)) {
      return false;
    }
    paramObject = (ByteObjectMap)paramObject;
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
        localObject1 = ((ByteObjectMap)paramObject).get(this.keys[i]);
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
  
  public V get(byte paramByte)
  {
    int i = indexOf(paramByte);
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
    byte[] arrayOfByte = this.keys;
    int j = arrayOfByte.length;
    for (int k = 0; k < j; k++) {
      i ^= hashCode(arrayOfByte[k]);
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
  
  public Set<Byte> keySet()
  {
    return this.keySet;
  }
  
  protected String keyToString(byte paramByte)
  {
    return Byte.toString(paramByte);
  }
  
  public V put(byte paramByte, V paramV)
  {
    int i = hashIndex(paramByte);
    int j = i;
    do
    {
      Object[] arrayOfObject = this.values;
      if (arrayOfObject[j] == null)
      {
        this.keys[j] = paramByte;
        arrayOfObject[j] = toInternal(paramV);
        growSize();
        return null;
      }
      if (this.keys[j] == paramByte)
      {
        Object localObject = arrayOfObject[j];
        arrayOfObject[j] = toInternal(paramV);
        return (V)toExternal(localObject);
      }
      j = probeNext(j);
    } while (j != i);
    throw new IllegalStateException("Unable to insert");
  }
  
  public V put(Byte paramByte, V paramV)
  {
    return (V)put(objectToKey(paramByte), paramV);
  }
  
  public void putAll(Map<? extends Byte, ? extends V> paramMap)
  {
    if ((paramMap instanceof ByteObjectHashMap))
    {
      paramMap = (ByteObjectHashMap)paramMap;
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
      put((Byte)paramMap.getKey(), paramMap.getValue());
    }
  }
  
  public V remove(byte paramByte)
  {
    int i = indexOf(paramByte);
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
          final ByteObjectHashMap<V>.PrimitiveIterator iter = new ByteObjectHashMap.PrimitiveIterator(ByteObjectHashMap.this, null);
          
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
        return ByteObjectHashMap.this.size;
      }
    };
  }
  
  private final class EntrySet
    extends AbstractSet<Map.Entry<Byte, V>>
  {
    private EntrySet() {}
    
    public Iterator<Map.Entry<Byte, V>> iterator()
    {
      return new ByteObjectHashMap.MapIterator(ByteObjectHashMap.this, null);
    }
    
    public int size()
    {
      return ByteObjectHashMap.this.size();
    }
  }
  
  private final class KeySet
    extends AbstractSet<Byte>
  {
    private KeySet() {}
    
    public void clear()
    {
      ByteObjectHashMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return ByteObjectHashMap.this.containsKey(paramObject);
    }
    
    public Iterator<Byte> iterator()
    {
      new Iterator()
      {
        private final Iterator<Map.Entry<Byte, V>> iter = ByteObjectHashMap.this.entrySet.iterator();
        
        public boolean hasNext()
        {
          return this.iter.hasNext();
        }
        
        public Byte next()
        {
          return (Byte)((Map.Entry)this.iter.next()).getKey();
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
      if (ByteObjectHashMap.this.remove(paramObject) != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      Iterator localIterator = ByteObjectHashMap.this.entries().iterator();
      boolean bool = false;
      while (localIterator.hasNext()) {
        if (!paramCollection.contains(Byte.valueOf(((ByteObjectMap.PrimitiveEntry)localIterator.next()).key())))
        {
          bool = true;
          localIterator.remove();
        }
      }
      return bool;
    }
    
    public int size()
    {
      return ByteObjectHashMap.this.size();
    }
  }
  
  final class MapEntry
    implements Map.Entry<Byte, V>
  {
    private final int entryIndex;
    
    MapEntry(int paramInt)
    {
      this.entryIndex = paramInt;
    }
    
    private void verifyExists()
    {
      if (ByteObjectHashMap.this.values[this.entryIndex] != null) {
        return;
      }
      throw new IllegalStateException("The map entry has been removed");
    }
    
    public Byte getKey()
    {
      verifyExists();
      return Byte.valueOf(ByteObjectHashMap.this.keys[this.entryIndex]);
    }
    
    public V getValue()
    {
      verifyExists();
      return (V)ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
    }
    
    public V setValue(V paramV)
    {
      verifyExists();
      Object localObject = ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
      ByteObjectHashMap.this.values[this.entryIndex] = ByteObjectHashMap.toInternal(paramV);
      return (V)localObject;
    }
  }
  
  private final class MapIterator
    implements Iterator<Map.Entry<Byte, V>>
  {
    private final ByteObjectHashMap<V>.PrimitiveIterator iter = new ByteObjectHashMap.PrimitiveIterator(ByteObjectHashMap.this, null);
    
    private MapIterator() {}
    
    public boolean hasNext()
    {
      return this.iter.hasNext();
    }
    
    public Map.Entry<Byte, V> next()
    {
      if (hasNext())
      {
        this.iter.next();
        return new ByteObjectHashMap.MapEntry(ByteObjectHashMap.this, ByteObjectHashMap.PrimitiveIterator.access$1100(this.iter));
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      this.iter.remove();
    }
  }
  
  private final class PrimitiveIterator
    implements Iterator<ByteObjectMap.PrimitiveEntry<V>>, ByteObjectMap.PrimitiveEntry<V>
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
      } while ((i != ByteObjectHashMap.this.values.length) && (ByteObjectHashMap.this.values[this.nextIndex] == null));
    }
    
    public boolean hasNext()
    {
      if (this.nextIndex == -1) {
        scanNext();
      }
      boolean bool;
      if (this.nextIndex != ByteObjectHashMap.this.values.length) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public byte key()
    {
      return ByteObjectHashMap.this.keys[this.entryIndex];
    }
    
    public ByteObjectMap.PrimitiveEntry<V> next()
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
        if (ByteObjectHashMap.this.removeAt(i)) {
          this.nextIndex = this.prevIndex;
        }
        this.prevIndex = -1;
        return;
      }
      throw new IllegalStateException("next must be called before each remove.");
    }
    
    public void setValue(V paramV)
    {
      ByteObjectHashMap.this.values[this.entryIndex] = ByteObjectHashMap.toInternal(paramV);
    }
    
    public V value()
    {
      return (V)ByteObjectHashMap.toExternal(ByteObjectHashMap.this.values[this.entryIndex]);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\ByteObjectHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */