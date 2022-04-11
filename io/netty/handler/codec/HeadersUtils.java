package io.netty.handler.codec;

import io.netty.util.internal.ObjectUtil;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class HeadersUtils
{
  public static <K, V> List<String> getAllAsString(Headers<K, V, ?> paramHeaders, K paramK)
  {
    new AbstractList()
    {
      public String get(int paramAnonymousInt)
      {
        Object localObject = this.val$allNames.get(paramAnonymousInt);
        if (localObject != null) {
          localObject = localObject.toString();
        } else {
          localObject = null;
        }
        return (String)localObject;
      }
      
      public int size()
      {
        return this.val$allNames.size();
      }
    };
  }
  
  public static <K, V> String getAsString(Headers<K, V, ?> paramHeaders, K paramK)
  {
    paramHeaders = paramHeaders.get(paramK);
    if (paramHeaders != null) {
      paramHeaders = paramHeaders.toString();
    } else {
      paramHeaders = null;
    }
    return paramHeaders;
  }
  
  public static Iterator<Map.Entry<String, String>> iteratorAsString(Iterable<Map.Entry<CharSequence, CharSequence>> paramIterable)
  {
    return new StringEntryIterator(paramIterable.iterator());
  }
  
  public static Set<String> namesAsString(Headers<CharSequence, CharSequence, ?> paramHeaders)
  {
    return new CharSequenceDelegatingStringSet(paramHeaders.names());
  }
  
  public static <K, V> String toString(Class<?> paramClass, Iterator<Map.Entry<K, V>> paramIterator, int paramInt)
  {
    Object localObject = paramClass.getSimpleName();
    if (paramInt == 0)
    {
      paramClass = new StringBuilder();
      paramClass.append((String)localObject);
      paramClass.append("[]");
      return paramClass.toString();
    }
    paramClass = new StringBuilder(((String)localObject).length() + 2 + paramInt * 20);
    paramClass.append((String)localObject);
    paramClass.append('[');
    while (paramIterator.hasNext())
    {
      localObject = (Map.Entry)paramIterator.next();
      paramClass.append(((Map.Entry)localObject).getKey());
      paramClass.append(": ");
      paramClass.append(((Map.Entry)localObject).getValue());
      paramClass.append(", ");
    }
    paramClass.setLength(paramClass.length() - 2);
    paramClass.append(']');
    return paramClass.toString();
  }
  
  private static final class CharSequenceDelegatingStringSet
    extends HeadersUtils.DelegatingStringSet<CharSequence>
  {
    CharSequenceDelegatingStringSet(Set<CharSequence> paramSet)
    {
      super();
    }
    
    public boolean add(String paramString)
    {
      return this.allNames.add(paramString);
    }
    
    public boolean addAll(Collection<? extends String> paramCollection)
    {
      return this.allNames.addAll(paramCollection);
    }
  }
  
  private static abstract class DelegatingStringSet<T>
    extends AbstractCollection<String>
    implements Set<String>
  {
    protected final Set<T> allNames;
    
    DelegatingStringSet(Set<T> paramSet)
    {
      this.allNames = ((Set)ObjectUtil.checkNotNull(paramSet, "allNames"));
    }
    
    public void clear()
    {
      this.allNames.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return this.allNames.contains(paramObject.toString());
    }
    
    public boolean isEmpty()
    {
      return this.allNames.isEmpty();
    }
    
    public Iterator<String> iterator()
    {
      return new HeadersUtils.StringIterator(this.allNames.iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      return this.allNames.remove(paramObject);
    }
    
    public int size()
    {
      return this.allNames.size();
    }
  }
  
  private static final class StringEntry
    implements Map.Entry<String, String>
  {
    private final Map.Entry<CharSequence, CharSequence> entry;
    private String name;
    private String value;
    
    StringEntry(Map.Entry<CharSequence, CharSequence> paramEntry)
    {
      this.entry = paramEntry;
    }
    
    public String getKey()
    {
      if (this.name == null) {
        this.name = ((CharSequence)this.entry.getKey()).toString();
      }
      return this.name;
    }
    
    public String getValue()
    {
      if ((this.value == null) && (this.entry.getValue() != null)) {
        this.value = ((CharSequence)this.entry.getValue()).toString();
      }
      return this.value;
    }
    
    public String setValue(String paramString)
    {
      String str = getValue();
      this.entry.setValue(paramString);
      return str;
    }
    
    public String toString()
    {
      return this.entry.toString();
    }
  }
  
  private static final class StringEntryIterator
    implements Iterator<Map.Entry<String, String>>
  {
    private final Iterator<Map.Entry<CharSequence, CharSequence>> iter;
    
    StringEntryIterator(Iterator<Map.Entry<CharSequence, CharSequence>> paramIterator)
    {
      this.iter = paramIterator;
    }
    
    public boolean hasNext()
    {
      return this.iter.hasNext();
    }
    
    public Map.Entry<String, String> next()
    {
      return new HeadersUtils.StringEntry((Map.Entry)this.iter.next());
    }
    
    public void remove()
    {
      this.iter.remove();
    }
  }
  
  private static final class StringIterator<T>
    implements Iterator<String>
  {
    private final Iterator<T> iter;
    
    StringIterator(Iterator<T> paramIterator)
    {
      this.iter = paramIterator;
    }
    
    public boolean hasNext()
    {
      return this.iter.hasNext();
    }
    
    public String next()
    {
      Object localObject = this.iter.next();
      if (localObject != null) {
        localObject = localObject.toString();
      } else {
        localObject = null;
      }
      return (String)localObject;
    }
    
    public void remove()
    {
      this.iter.remove();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\HeadersUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */