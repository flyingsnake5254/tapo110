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

public class CharObjectHashMap<V>
  implements CharObjectMap<V>
{
  public static final int DEFAULT_CAPACITY = 8;
  public static final float DEFAULT_LOAD_FACTOR = 0.5F;
  private static final Object NULL_VALUE = new Object();
  private final Iterable<CharObjectMap.PrimitiveEntry<V>> entries = new Iterable()
  {
    public Iterator<CharObjectMap.PrimitiveEntry<V>> iterator()
    {
      return new CharObjectHashMap.PrimitiveIterator(CharObjectHashMap.this, null);
    }
  };
  private final Set<Map.Entry<Character, V>> entrySet = new EntrySet(null);
  private final Set<Character> keySet = new KeySet(null);
  private char[] keys;
  private final float loadFactor;
  private int mask;
  private int maxSize;
  private int size;
  private V[] values;
  
  public CharObjectHashMap()
  {
    this(8, 0.5F);
  }
  
  public CharObjectHashMap(int paramInt)
  {
    this(paramInt, 0.5F);
  }
  
  public CharObjectHashMap(int paramInt, float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat <= 1.0F))
    {
      this.loadFactor = paramFloat;
      paramInt = MathUtil.safeFindNextPositivePowerOfTwo(paramInt);
      this.mask = (paramInt - 1);
      this.keys = new char[paramInt];
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
  
  private static int hashCode(char paramChar)
  {
    return paramChar;
  }
  
  private int hashIndex(char paramChar)
  {
    return hashCode(paramChar) & this.mask;
  }
  
  private int indexOf(char paramChar)
  {
    int i = hashIndex(paramChar);
    int j = i;
    int k;
    do
    {
      if (this.values[j] == null) {
        return -1;
      }
      if (paramChar == this.keys[j]) {
        return j;
      }
      k = probeNext(j);
      j = k;
    } while (k != i);
    return -1;
  }
  
  private char objectToKey(Object paramObject)
  {
    return ((Character)paramObject).charValue();
  }
  
  private int probeNext(int paramInt)
  {
    return paramInt + 1 & this.mask;
  }
  
  private void rehash(int paramInt)
  {
    char[] arrayOfChar = this.keys;
    Object[] arrayOfObject1 = this.values;
    this.keys = new char[paramInt];
    this.values = new Object[paramInt];
    this.maxSize = calcMaxSize(paramInt);
    this.mask = (paramInt - 1);
    for (paramInt = 0; paramInt < arrayOfObject1.length; paramInt++)
    {
      Object localObject = arrayOfObject1[paramInt];
      if (localObject != null)
      {
        char c = arrayOfChar[paramInt];
        for (int i = hashIndex(c);; i = probeNext(i))
        {
          Object[] arrayOfObject2 = this.values;
          if (arrayOfObject2[i] == null)
          {
            this.keys[i] = c;
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
    this.keys[paramInt] = ((char)0);
    this.values[paramInt] = null;
    i = probeNext(paramInt);
    Object localObject = this.values[i];
    int m;
    for (int j = paramInt; localObject != null; j = m)
    {
      char c = this.keys[i];
      int k = hashIndex(c);
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
        char[] arrayOfChar = this.keys;
        arrayOfChar[j] = c;
        Object[] arrayOfObject = this.values;
        arrayOfObject[j] = localObject;
        arrayOfChar[i] = ((char)0);
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
    Arrays.fill(this.keys, '\000');
    Arrays.fill(this.values, null);
    this.size = 0;
  }
  
  public boolean containsKey(char paramChar)
  {
    boolean bool;
    if (indexOf(paramChar) >= 0) {
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
  
  public Iterable<CharObjectMap.PrimitiveEntry<V>> entries()
  {
    return this.entries;
  }
  
  public Set<Map.Entry<Character, V>> entrySet()
  {
    return this.entrySet;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof CharObjectMap)) {
      return false;
    }
    paramObject = (CharObjectMap)paramObject;
    if (this.size != ((Map)paramObject).size()) {
      return false;
    }
    for (int i = 0;; i++)
    {
      Object localObject1 = this.values;
      if (i >= localObject1.length) {
        break;
      }
      localObject1 = localObject1[i];
      if (localObject1 != null)
      {
        Object localObject2 = ((CharObjectMap)paramObject).get(this.keys[i]);
        if (localObject1 == NULL_VALUE)
        {
          if (localObject2 != null) {
            return false;
          }
        }
        else if (!localObject1.equals(localObject2)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public V get(char paramChar)
  {
    int i = indexOf(paramChar);
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
    char[] arrayOfChar = this.keys;
    int j = arrayOfChar.length;
    for (int k = 0; k < j; k++) {
      i ^= hashCode(arrayOfChar[k]);
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
  
  public Set<Character> keySet()
  {
    return this.keySet;
  }
  
  protected String keyToString(char paramChar)
  {
    return Character.toString(paramChar);
  }
  
  public V put(char paramChar, V paramV)
  {
    int i = hashIndex(paramChar);
    int j = i;
    do
    {
      Object[] arrayOfObject = this.values;
      if (arrayOfObject[j] == null)
      {
        this.keys[j] = paramChar;
        arrayOfObject[j] = toInternal(paramV);
        growSize();
        return null;
      }
      if (this.keys[j] == paramChar)
      {
        Object localObject = arrayOfObject[j];
        arrayOfObject[j] = toInternal(paramV);
        return (V)toExternal(localObject);
      }
      j = probeNext(j);
    } while (j != i);
    throw new IllegalStateException("Unable to insert");
  }
  
  public V put(Character paramCharacter, V paramV)
  {
    return (V)put(objectToKey(paramCharacter), paramV);
  }
  
  public void putAll(Map<? extends Character, ? extends V> paramMap)
  {
    Object localObject;
    if ((paramMap instanceof CharObjectHashMap))
    {
      paramMap = (CharObjectHashMap)paramMap;
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
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject = (Map.Entry)paramMap.next();
      put((Character)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
    }
  }
  
  public V remove(char paramChar)
  {
    int i = indexOf(paramChar);
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
          final CharObjectHashMap<V>.PrimitiveIterator iter = new CharObjectHashMap.PrimitiveIterator(CharObjectHashMap.this, null);
          
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
        return CharObjectHashMap.this.size;
      }
    };
  }
  
  private final class EntrySet
    extends AbstractSet<Map.Entry<Character, V>>
  {
    private EntrySet() {}
    
    public Iterator<Map.Entry<Character, V>> iterator()
    {
      return new CharObjectHashMap.MapIterator(CharObjectHashMap.this, null);
    }
    
    public int size()
    {
      return CharObjectHashMap.this.size();
    }
  }
  
  private final class KeySet
    extends AbstractSet<Character>
  {
    private KeySet() {}
    
    public void clear()
    {
      CharObjectHashMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return CharObjectHashMap.this.containsKey(paramObject);
    }
    
    public Iterator<Character> iterator()
    {
      new Iterator()
      {
        private final Iterator<Map.Entry<Character, V>> iter = CharObjectHashMap.this.entrySet.iterator();
        
        public boolean hasNext()
        {
          return this.iter.hasNext();
        }
        
        public Character next()
        {
          return (Character)((Map.Entry)this.iter.next()).getKey();
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
      if (CharObjectHashMap.this.remove(paramObject) != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      Iterator localIterator = CharObjectHashMap.this.entries().iterator();
      boolean bool = false;
      while (localIterator.hasNext()) {
        if (!paramCollection.contains(Character.valueOf(((CharObjectMap.PrimitiveEntry)localIterator.next()).key())))
        {
          bool = true;
          localIterator.remove();
        }
      }
      return bool;
    }
    
    public int size()
    {
      return CharObjectHashMap.this.size();
    }
  }
  
  final class MapEntry
    implements Map.Entry<Character, V>
  {
    private final int entryIndex;
    
    MapEntry(int paramInt)
    {
      this.entryIndex = paramInt;
    }
    
    private void verifyExists()
    {
      if (CharObjectHashMap.this.values[this.entryIndex] != null) {
        return;
      }
      throw new IllegalStateException("The map entry has been removed");
    }
    
    public Character getKey()
    {
      verifyExists();
      return Character.valueOf(CharObjectHashMap.this.keys[this.entryIndex]);
    }
    
    public V getValue()
    {
      verifyExists();
      return (V)CharObjectHashMap.toExternal(CharObjectHashMap.this.values[this.entryIndex]);
    }
    
    public V setValue(V paramV)
    {
      verifyExists();
      Object localObject = CharObjectHashMap.toExternal(CharObjectHashMap.this.values[this.entryIndex]);
      CharObjectHashMap.this.values[this.entryIndex] = CharObjectHashMap.toInternal(paramV);
      return (V)localObject;
    }
  }
  
  private final class MapIterator
    implements Iterator<Map.Entry<Character, V>>
  {
    private final CharObjectHashMap<V>.PrimitiveIterator iter = new CharObjectHashMap.PrimitiveIterator(CharObjectHashMap.this, null);
    
    private MapIterator() {}
    
    public boolean hasNext()
    {
      return this.iter.hasNext();
    }
    
    public Map.Entry<Character, V> next()
    {
      if (hasNext())
      {
        this.iter.next();
        return new CharObjectHashMap.MapEntry(CharObjectHashMap.this, CharObjectHashMap.PrimitiveIterator.access$1100(this.iter));
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      this.iter.remove();
    }
  }
  
  private final class PrimitiveIterator
    implements Iterator<CharObjectMap.PrimitiveEntry<V>>, CharObjectMap.PrimitiveEntry<V>
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
      } while ((i != CharObjectHashMap.this.values.length) && (CharObjectHashMap.this.values[this.nextIndex] == null));
    }
    
    public boolean hasNext()
    {
      if (this.nextIndex == -1) {
        scanNext();
      }
      boolean bool;
      if (this.nextIndex != CharObjectHashMap.this.values.length) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public char key()
    {
      return CharObjectHashMap.this.keys[this.entryIndex];
    }
    
    public CharObjectMap.PrimitiveEntry<V> next()
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
        if (CharObjectHashMap.this.removeAt(i)) {
          this.nextIndex = this.prevIndex;
        }
        this.prevIndex = -1;
        return;
      }
      throw new IllegalStateException("next must be called before each remove.");
    }
    
    public void setValue(V paramV)
    {
      CharObjectHashMap.this.values[this.entryIndex] = CharObjectHashMap.toInternal(paramV);
    }
    
    public V value()
    {
      return (V)CharObjectHashMap.toExternal(CharObjectHashMap.this.values[this.entryIndex]);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\CharObjectHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */