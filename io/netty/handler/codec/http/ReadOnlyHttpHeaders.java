package io.netty.handler.codec.http;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DefaultHeaders.NameValidator;
import io.netty.util.AsciiString;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class ReadOnlyHttpHeaders
  extends HttpHeaders
{
  private final CharSequence[] nameValuePairs;
  
  public ReadOnlyHttpHeaders(boolean paramBoolean, CharSequence... paramVarArgs)
  {
    if ((paramVarArgs.length & 0x1) == 0)
    {
      if (paramBoolean) {
        validateHeaders(paramVarArgs);
      }
      this.nameValuePairs = paramVarArgs;
      return;
    }
    throw newInvalidArraySizeException();
  }
  
  private CharSequence get0(CharSequence paramCharSequence)
  {
    int i = AsciiString.hashCode(paramCharSequence);
    for (int j = 0;; j += 2)
    {
      Object localObject = this.nameValuePairs;
      if (j >= localObject.length) {
        break;
      }
      localObject = localObject[j];
      if ((AsciiString.hashCode((CharSequence)localObject) == i) && (AsciiString.contentEqualsIgnoreCase((CharSequence)localObject, paramCharSequence))) {
        return this.nameValuePairs[(j + 1)];
      }
    }
    return null;
  }
  
  private static IllegalArgumentException newInvalidArraySizeException()
  {
    return new IllegalArgumentException("nameValuePairs must be arrays of [name, value] pairs");
  }
  
  private static void validateHeaders(CharSequence... paramVarArgs)
  {
    for (int i = 0; i < paramVarArgs.length; i += 2) {
      DefaultHttpHeaders.HttpNameValidator.validateName(paramVarArgs[i]);
    }
  }
  
  public HttpHeaders add(String paramString, Iterable<?> paramIterable)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public HttpHeaders add(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public HttpHeaders addInt(CharSequence paramCharSequence, int paramInt)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public HttpHeaders addShort(CharSequence paramCharSequence, short paramShort)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public HttpHeaders clear()
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public boolean contains(String paramString)
  {
    boolean bool;
    if (get0(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean contains(String paramString1, String paramString2, boolean paramBoolean)
  {
    return containsValue(paramString1, paramString2, paramBoolean);
  }
  
  public boolean containsValue(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    CharSequence[] arrayOfCharSequence;
    if (paramBoolean) {
      for (i = 0;; i += 2)
      {
        arrayOfCharSequence = this.nameValuePairs;
        if (i >= arrayOfCharSequence.length) {
          break;
        }
        if ((AsciiString.contentEqualsIgnoreCase(arrayOfCharSequence[i], paramCharSequence1)) && (AsciiString.contentEqualsIgnoreCase(this.nameValuePairs[(i + 1)], paramCharSequence2))) {
          return true;
        }
      }
    }
    for (int i = 0;; i += 2)
    {
      arrayOfCharSequence = this.nameValuePairs;
      if (i >= arrayOfCharSequence.length) {
        break;
      }
      if ((AsciiString.contentEqualsIgnoreCase(arrayOfCharSequence[i], paramCharSequence1)) && (AsciiString.contentEquals(this.nameValuePairs[(i + 1)], paramCharSequence2))) {
        return true;
      }
    }
    return false;
  }
  
  public List<Map.Entry<String, String>> entries()
  {
    if (isEmpty()) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(size());
    for (int i = 0; i < this.nameValuePairs.length; i += 2) {
      localArrayList.add(new AbstractMap.SimpleImmutableEntry(this.nameValuePairs[i].toString(), this.nameValuePairs[(i + 1)].toString()));
    }
    return localArrayList;
  }
  
  public String get(String paramString)
  {
    paramString = get0(paramString);
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  public List<String> getAll(String paramString)
  {
    if (isEmpty()) {
      return Collections.emptyList();
    }
    int i = AsciiString.hashCode(paramString);
    ArrayList localArrayList = new ArrayList(4);
    for (int j = 0;; j += 2)
    {
      Object localObject = this.nameValuePairs;
      if (j >= localObject.length) {
        break;
      }
      localObject = localObject[j];
      if ((AsciiString.hashCode((CharSequence)localObject) == i) && (AsciiString.contentEqualsIgnoreCase((CharSequence)localObject, paramString))) {
        localArrayList.add(this.nameValuePairs[(j + 1)].toString());
      }
    }
    return localArrayList;
  }
  
  public int getInt(CharSequence paramCharSequence, int paramInt)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence != null) {
      paramInt = CharSequenceValueConverter.INSTANCE.convertToInt(paramCharSequence);
    }
    return paramInt;
  }
  
  public Integer getInt(CharSequence paramCharSequence)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence == null) {
      paramCharSequence = null;
    } else {
      paramCharSequence = Integer.valueOf(CharSequenceValueConverter.INSTANCE.convertToInt(paramCharSequence));
    }
    return paramCharSequence;
  }
  
  public Short getShort(CharSequence paramCharSequence)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence == null) {
      paramCharSequence = null;
    } else {
      paramCharSequence = Short.valueOf(CharSequenceValueConverter.INSTANCE.convertToShort(paramCharSequence));
    }
    return paramCharSequence;
  }
  
  public short getShort(CharSequence paramCharSequence, short paramShort)
  {
    paramCharSequence = get0(paramCharSequence);
    short s;
    if (paramCharSequence == null)
    {
      s = paramShort;
    }
    else
    {
      paramShort = CharSequenceValueConverter.INSTANCE.convertToShort(paramCharSequence);
      s = paramShort;
    }
    return s;
  }
  
  public long getTimeMillis(CharSequence paramCharSequence, long paramLong)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence != null) {
      paramLong = CharSequenceValueConverter.INSTANCE.convertToTimeMillis(paramCharSequence);
    }
    return paramLong;
  }
  
  public Long getTimeMillis(CharSequence paramCharSequence)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence == null) {
      paramCharSequence = null;
    } else {
      paramCharSequence = Long.valueOf(CharSequenceValueConverter.INSTANCE.convertToTimeMillis(paramCharSequence));
    }
    return paramCharSequence;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.nameValuePairs.length == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<Map.Entry<String, String>> iterator()
  {
    return new ReadOnlyStringIterator(null);
  }
  
  public Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence()
  {
    return new ReadOnlyIterator(null);
  }
  
  public Set<String> names()
  {
    if (isEmpty()) {
      return Collections.emptySet();
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(size());
    for (int i = 0;; i += 2)
    {
      CharSequence[] arrayOfCharSequence = this.nameValuePairs;
      if (i >= arrayOfCharSequence.length) {
        break;
      }
      localLinkedHashSet.add(arrayOfCharSequence[i].toString());
    }
    return localLinkedHashSet;
  }
  
  public HttpHeaders remove(String paramString)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public HttpHeaders set(String paramString, Iterable<?> paramIterable)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public HttpHeaders set(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public HttpHeaders setInt(CharSequence paramCharSequence, int paramInt)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public HttpHeaders setShort(CharSequence paramCharSequence, short paramShort)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public int size()
  {
    return this.nameValuePairs.length >>> 1;
  }
  
  public Iterator<CharSequence> valueCharSequenceIterator(CharSequence paramCharSequence)
  {
    return new ReadOnlyValueIterator(paramCharSequence);
  }
  
  public Iterator<String> valueStringIterator(CharSequence paramCharSequence)
  {
    return new ReadOnlyStringValueIterator(paramCharSequence);
  }
  
  private final class ReadOnlyIterator
    implements Map.Entry<CharSequence, CharSequence>, Iterator<Map.Entry<CharSequence, CharSequence>>
  {
    private CharSequence key;
    private int nextNameIndex;
    private CharSequence value;
    
    private ReadOnlyIterator() {}
    
    public CharSequence getKey()
    {
      return this.key;
    }
    
    public CharSequence getValue()
    {
      return this.value;
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.nextNameIndex != ReadOnlyHttpHeaders.this.nameValuePairs.length) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Map.Entry<CharSequence, CharSequence> next()
    {
      if (hasNext())
      {
        this.key = ReadOnlyHttpHeaders.this.nameValuePairs[this.nextNameIndex];
        CharSequence[] arrayOfCharSequence = ReadOnlyHttpHeaders.this.nameValuePairs;
        int i = this.nextNameIndex;
        this.value = arrayOfCharSequence[(i + 1)];
        this.nextNameIndex = (i + 2);
        return this;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("read only");
    }
    
    public CharSequence setValue(CharSequence paramCharSequence)
    {
      throw new UnsupportedOperationException("read only");
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.key.toString());
      localStringBuilder.append('=');
      localStringBuilder.append(this.value.toString());
      return localStringBuilder.toString();
    }
  }
  
  private final class ReadOnlyStringIterator
    implements Map.Entry<String, String>, Iterator<Map.Entry<String, String>>
  {
    private String key;
    private int nextNameIndex;
    private String value;
    
    private ReadOnlyStringIterator() {}
    
    public String getKey()
    {
      return this.key;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.nextNameIndex != ReadOnlyHttpHeaders.this.nameValuePairs.length) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Map.Entry<String, String> next()
    {
      if (hasNext())
      {
        this.key = ReadOnlyHttpHeaders.this.nameValuePairs[this.nextNameIndex].toString();
        this.value = ReadOnlyHttpHeaders.this.nameValuePairs[(this.nextNameIndex + 1)].toString();
        this.nextNameIndex += 2;
        return this;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("read only");
    }
    
    public String setValue(String paramString)
    {
      throw new UnsupportedOperationException("read only");
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.key);
      localStringBuilder.append('=');
      localStringBuilder.append(this.value);
      return localStringBuilder.toString();
    }
  }
  
  private final class ReadOnlyStringValueIterator
    implements Iterator<String>
  {
    private final CharSequence name;
    private final int nameHash;
    private int nextNameIndex;
    
    ReadOnlyStringValueIterator(CharSequence paramCharSequence)
    {
      this.name = paramCharSequence;
      this.nameHash = AsciiString.hashCode(paramCharSequence);
      this.nextNameIndex = findNextValue();
    }
    
    private int findNextValue()
    {
      for (int i = this.nextNameIndex; i < ReadOnlyHttpHeaders.this.nameValuePairs.length; i += 2)
      {
        CharSequence localCharSequence = ReadOnlyHttpHeaders.this.nameValuePairs[i];
        if ((this.nameHash == AsciiString.hashCode(localCharSequence)) && (AsciiString.contentEqualsIgnoreCase(this.name, localCharSequence))) {
          return i;
        }
      }
      return -1;
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.nextNameIndex != -1) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public String next()
    {
      if (hasNext())
      {
        String str = ReadOnlyHttpHeaders.this.nameValuePairs[(this.nextNameIndex + 1)].toString();
        this.nextNameIndex = findNextValue();
        return str;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("read only");
    }
  }
  
  private final class ReadOnlyValueIterator
    implements Iterator<CharSequence>
  {
    private final CharSequence name;
    private final int nameHash;
    private int nextNameIndex;
    
    ReadOnlyValueIterator(CharSequence paramCharSequence)
    {
      this.name = paramCharSequence;
      this.nameHash = AsciiString.hashCode(paramCharSequence);
      this.nextNameIndex = findNextValue();
    }
    
    private int findNextValue()
    {
      for (int i = this.nextNameIndex; i < ReadOnlyHttpHeaders.this.nameValuePairs.length; i += 2)
      {
        CharSequence localCharSequence = ReadOnlyHttpHeaders.this.nameValuePairs[i];
        if ((this.nameHash == AsciiString.hashCode(localCharSequence)) && (AsciiString.contentEqualsIgnoreCase(this.name, localCharSequence))) {
          return i;
        }
      }
      return -1;
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.nextNameIndex != -1) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public CharSequence next()
    {
      if (hasNext())
      {
        CharSequence localCharSequence = ReadOnlyHttpHeaders.this.nameValuePairs[(this.nextNameIndex + 1)];
        this.nextNameIndex = findNextValue();
        return localCharSequence;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("read only");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\ReadOnlyHttpHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */