package io.netty.handler.codec;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class EmptyHeaders<K, V, T extends Headers<K, V, T>>
  implements Headers<K, V, T>
{
  private T thisT()
  {
    return this;
  }
  
  public T add(Headers<? extends K, ? extends V, ?> paramHeaders)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T add(K paramK, Iterable<? extends V> paramIterable)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T add(K paramK, V paramV)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T add(K paramK, V... paramVarArgs)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T addBoolean(K paramK, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T addByte(K paramK, byte paramByte)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T addChar(K paramK, char paramChar)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T addDouble(K paramK, double paramDouble)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T addFloat(K paramK, float paramFloat)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T addInt(K paramK, int paramInt)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T addLong(K paramK, long paramLong)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T addObject(K paramK, Iterable<?> paramIterable)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T addObject(K paramK, Object paramObject)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T addObject(K paramK, Object... paramVarArgs)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T addShort(K paramK, short paramShort)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T addTimeMillis(K paramK, long paramLong)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T clear()
  {
    return thisT();
  }
  
  public boolean contains(K paramK)
  {
    return false;
  }
  
  public boolean contains(K paramK, V paramV)
  {
    return false;
  }
  
  public boolean containsBoolean(K paramK, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean containsByte(K paramK, byte paramByte)
  {
    return false;
  }
  
  public boolean containsChar(K paramK, char paramChar)
  {
    return false;
  }
  
  public boolean containsDouble(K paramK, double paramDouble)
  {
    return false;
  }
  
  public boolean containsFloat(K paramK, float paramFloat)
  {
    return false;
  }
  
  public boolean containsInt(K paramK, int paramInt)
  {
    return false;
  }
  
  public boolean containsLong(K paramK, long paramLong)
  {
    return false;
  }
  
  public boolean containsObject(K paramK, Object paramObject)
  {
    return false;
  }
  
  public boolean containsShort(K paramK, short paramShort)
  {
    return false;
  }
  
  public boolean containsTimeMillis(K paramK, long paramLong)
  {
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Headers;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Headers)paramObject;
    bool1 = bool2;
    if (isEmpty())
    {
      bool1 = bool2;
      if (((Headers)paramObject).isEmpty()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public V get(K paramK)
  {
    return null;
  }
  
  public V get(K paramK, V paramV)
  {
    return paramV;
  }
  
  public List<V> getAll(K paramK)
  {
    return Collections.emptyList();
  }
  
  public List<V> getAllAndRemove(K paramK)
  {
    return Collections.emptyList();
  }
  
  public V getAndRemove(K paramK)
  {
    return null;
  }
  
  public V getAndRemove(K paramK, V paramV)
  {
    return paramV;
  }
  
  public Boolean getBoolean(K paramK)
  {
    return null;
  }
  
  public boolean getBoolean(K paramK, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public Boolean getBooleanAndRemove(K paramK)
  {
    return null;
  }
  
  public boolean getBooleanAndRemove(K paramK, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public byte getByte(K paramK, byte paramByte)
  {
    return paramByte;
  }
  
  public Byte getByte(K paramK)
  {
    return null;
  }
  
  public byte getByteAndRemove(K paramK, byte paramByte)
  {
    return paramByte;
  }
  
  public Byte getByteAndRemove(K paramK)
  {
    return null;
  }
  
  public char getChar(K paramK, char paramChar)
  {
    return paramChar;
  }
  
  public Character getChar(K paramK)
  {
    return null;
  }
  
  public char getCharAndRemove(K paramK, char paramChar)
  {
    return paramChar;
  }
  
  public Character getCharAndRemove(K paramK)
  {
    return null;
  }
  
  public double getDouble(K paramK, double paramDouble)
  {
    return paramDouble;
  }
  
  public Double getDouble(K paramK)
  {
    return null;
  }
  
  public double getDoubleAndRemove(K paramK, double paramDouble)
  {
    return paramDouble;
  }
  
  public Double getDoubleAndRemove(K paramK)
  {
    return null;
  }
  
  public float getFloat(K paramK, float paramFloat)
  {
    return paramFloat;
  }
  
  public Float getFloat(K paramK)
  {
    return null;
  }
  
  public float getFloatAndRemove(K paramK, float paramFloat)
  {
    return paramFloat;
  }
  
  public Float getFloatAndRemove(K paramK)
  {
    return null;
  }
  
  public int getInt(K paramK, int paramInt)
  {
    return paramInt;
  }
  
  public Integer getInt(K paramK)
  {
    return null;
  }
  
  public int getIntAndRemove(K paramK, int paramInt)
  {
    return paramInt;
  }
  
  public Integer getIntAndRemove(K paramK)
  {
    return null;
  }
  
  public long getLong(K paramK, long paramLong)
  {
    return paramLong;
  }
  
  public Long getLong(K paramK)
  {
    return null;
  }
  
  public long getLongAndRemove(K paramK, long paramLong)
  {
    return paramLong;
  }
  
  public Long getLongAndRemove(K paramK)
  {
    return null;
  }
  
  public Short getShort(K paramK)
  {
    return null;
  }
  
  public short getShort(K paramK, short paramShort)
  {
    return paramShort;
  }
  
  public Short getShortAndRemove(K paramK)
  {
    return null;
  }
  
  public short getShortAndRemove(K paramK, short paramShort)
  {
    return paramShort;
  }
  
  public long getTimeMillis(K paramK, long paramLong)
  {
    return paramLong;
  }
  
  public Long getTimeMillis(K paramK)
  {
    return null;
  }
  
  public long getTimeMillisAndRemove(K paramK, long paramLong)
  {
    return paramLong;
  }
  
  public Long getTimeMillisAndRemove(K paramK)
  {
    return null;
  }
  
  public int hashCode()
  {
    return -1028477387;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return Collections.emptyList().iterator();
  }
  
  public Set<K> names()
  {
    return Collections.emptySet();
  }
  
  public boolean remove(K paramK)
  {
    return false;
  }
  
  public T set(Headers<? extends K, ? extends V, ?> paramHeaders)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T set(K paramK, Iterable<? extends V> paramIterable)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T set(K paramK, V paramV)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T set(K paramK, V... paramVarArgs)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setAll(Headers<? extends K, ? extends V, ?> paramHeaders)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setBoolean(K paramK, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setByte(K paramK, byte paramByte)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setChar(K paramK, char paramChar)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setDouble(K paramK, double paramDouble)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setFloat(K paramK, float paramFloat)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setInt(K paramK, int paramInt)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setLong(K paramK, long paramLong)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setObject(K paramK, Iterable<?> paramIterable)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setObject(K paramK, Object paramObject)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setObject(K paramK, Object... paramVarArgs)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setShort(K paramK, short paramShort)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public T setTimeMillis(K paramK, long paramLong)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public int size()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(getClass().getSimpleName());
    localStringBuilder.append('[');
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public Iterator<V> valueIterator(K paramK)
  {
    return Collections.emptyList().iterator();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\EmptyHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */