package io.netty.handler.codec.http;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class EmptyHttpHeaders
  extends HttpHeaders
{
  static final Iterator<Map.Entry<CharSequence, CharSequence>> EMPTY_CHARS_ITERATOR = Collections.emptyList().iterator();
  public static final EmptyHttpHeaders INSTANCE = instance();
  
  @Deprecated
  static EmptyHttpHeaders instance()
  {
    return InstanceInitializer.EMPTY_HEADERS;
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
    return false;
  }
  
  public List<Map.Entry<String, String>> entries()
  {
    return Collections.emptyList();
  }
  
  public String get(String paramString)
  {
    return null;
  }
  
  public List<String> getAll(String paramString)
  {
    return Collections.emptyList();
  }
  
  public int getInt(CharSequence paramCharSequence, int paramInt)
  {
    return paramInt;
  }
  
  public Integer getInt(CharSequence paramCharSequence)
  {
    return null;
  }
  
  public Short getShort(CharSequence paramCharSequence)
  {
    return null;
  }
  
  public short getShort(CharSequence paramCharSequence, short paramShort)
  {
    return paramShort;
  }
  
  public long getTimeMillis(CharSequence paramCharSequence, long paramLong)
  {
    return paramLong;
  }
  
  public Long getTimeMillis(CharSequence paramCharSequence)
  {
    return null;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Iterator<Map.Entry<String, String>> iterator()
  {
    return entries().iterator();
  }
  
  public Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence()
  {
    return EMPTY_CHARS_ITERATOR;
  }
  
  public Set<String> names()
  {
    return Collections.emptySet();
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
    return 0;
  }
  
  @Deprecated
  private static final class InstanceInitializer
  {
    @Deprecated
    private static final EmptyHttpHeaders EMPTY_HEADERS = new EmptyHttpHeaders();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\EmptyHttpHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */