package io.netty.handler.codec.http;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DateFormatter;
import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.DefaultHeaders.NameValidator;
import io.netty.handler.codec.DefaultHeadersImpl;
import io.netty.handler.codec.HeadersUtils;
import io.netty.handler.codec.ValueConverter;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class DefaultHttpHeaders
  extends HttpHeaders
{
  private static final ByteProcessor HEADER_NAME_VALIDATOR = new ByteProcessor()
  {
    public boolean process(byte paramAnonymousByte)
      throws Exception
    {
      DefaultHttpHeaders.validateHeaderNameElement(paramAnonymousByte);
      return true;
    }
  };
  private static final int HIGHEST_INVALID_VALUE_CHAR_MASK = -16;
  static final DefaultHeaders.NameValidator<CharSequence> HttpNameValidator = new DefaultHeaders.NameValidator()
  {
    public void validateName(CharSequence paramAnonymousCharSequence)
    {
      if ((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.length() != 0))
      {
        if ((paramAnonymousCharSequence instanceof AsciiString)) {
          try
          {
            ((AsciiString)paramAnonymousCharSequence).forEachByte(DefaultHttpHeaders.HEADER_NAME_VALIDATOR);
          }
          catch (Exception paramAnonymousCharSequence)
          {
            PlatformDependent.throwException(paramAnonymousCharSequence);
          }
        } else {
          for (int i = 0; i < paramAnonymousCharSequence.length(); i++) {
            DefaultHttpHeaders.validateHeaderNameElement(paramAnonymousCharSequence.charAt(i));
          }
        }
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("empty headers are not allowed [");
      localStringBuilder.append(paramAnonymousCharSequence);
      localStringBuilder.append("]");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  };
  private final DefaultHeaders<CharSequence, CharSequence, ?> headers;
  
  public DefaultHttpHeaders()
  {
    this(true);
  }
  
  protected DefaultHttpHeaders(DefaultHeaders<CharSequence, CharSequence, ?> paramDefaultHeaders)
  {
    this.headers = paramDefaultHeaders;
  }
  
  public DefaultHttpHeaders(boolean paramBoolean)
  {
    this(paramBoolean, nameValidator(paramBoolean));
  }
  
  protected DefaultHttpHeaders(boolean paramBoolean, DefaultHeaders.NameValidator<CharSequence> paramNameValidator)
  {
    this(new DefaultHeadersImpl(AsciiString.CASE_INSENSITIVE_HASHER, valueConverter(paramBoolean), paramNameValidator));
  }
  
  static DefaultHeaders.NameValidator<CharSequence> nameValidator(boolean paramBoolean)
  {
    DefaultHeaders.NameValidator localNameValidator;
    if (paramBoolean) {
      localNameValidator = HttpNameValidator;
    } else {
      localNameValidator = DefaultHeaders.NameValidator.NOT_NULL;
    }
    return localNameValidator;
  }
  
  private static void validateHeaderNameElement(byte paramByte)
  {
    if ((paramByte != 0) && (paramByte != 32) && (paramByte != 44) && (paramByte != 61) && (paramByte != 58) && (paramByte != 59)) {
      switch (paramByte)
      {
      default: 
        if (paramByte >= 0) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("a header name cannot contain non-ASCII character: ");
        localStringBuilder.append(paramByte);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("a header name cannot contain the following prohibited characters: =,;: \\t\\r\\n\\v\\f: ");
    localStringBuilder.append(paramByte);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static void validateHeaderNameElement(char paramChar)
  {
    if ((paramChar != 0) && (paramChar != ' ') && (paramChar != ',') && (paramChar != '=') && (paramChar != ':') && (paramChar != ';')) {
      switch (paramChar)
      {
      default: 
        if (paramChar <= '') {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("a header name cannot contain non-ASCII character: ");
        localStringBuilder.append(paramChar);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("a header name cannot contain the following prohibited characters: =,;: \\t\\r\\n\\v\\f: ");
    localStringBuilder.append(paramChar);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static ValueConverter<CharSequence> valueConverter(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = HeaderValueConverterAndValidator.INSTANCE;
    } else {
      localObject = HeaderValueConverter.INSTANCE;
    }
    return (ValueConverter<CharSequence>)localObject;
  }
  
  public HttpHeaders add(HttpHeaders paramHttpHeaders)
  {
    if ((paramHttpHeaders instanceof DefaultHttpHeaders))
    {
      this.headers.add(((DefaultHttpHeaders)paramHttpHeaders).headers);
      return this;
    }
    return super.add(paramHttpHeaders);
  }
  
  public HttpHeaders add(CharSequence paramCharSequence, Iterable<?> paramIterable)
  {
    this.headers.addObject(paramCharSequence, paramIterable);
    return this;
  }
  
  public HttpHeaders add(CharSequence paramCharSequence, Object paramObject)
  {
    this.headers.addObject(paramCharSequence, paramObject);
    return this;
  }
  
  public HttpHeaders add(String paramString, Iterable<?> paramIterable)
  {
    this.headers.addObject(paramString, paramIterable);
    return this;
  }
  
  public HttpHeaders add(String paramString, Object paramObject)
  {
    this.headers.addObject(paramString, paramObject);
    return this;
  }
  
  public HttpHeaders addInt(CharSequence paramCharSequence, int paramInt)
  {
    this.headers.addInt(paramCharSequence, paramInt);
    return this;
  }
  
  public HttpHeaders addShort(CharSequence paramCharSequence, short paramShort)
  {
    this.headers.addShort(paramCharSequence, paramShort);
    return this;
  }
  
  public HttpHeaders clear()
  {
    this.headers.clear();
    return this;
  }
  
  public boolean contains(CharSequence paramCharSequence)
  {
    return this.headers.contains(paramCharSequence);
  }
  
  public boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    DefaultHeaders localDefaultHeaders = this.headers;
    HashingStrategy localHashingStrategy;
    if (paramBoolean) {
      localHashingStrategy = AsciiString.CASE_INSENSITIVE_HASHER;
    } else {
      localHashingStrategy = AsciiString.CASE_SENSITIVE_HASHER;
    }
    return localDefaultHeaders.contains(paramCharSequence1, paramCharSequence2, localHashingStrategy);
  }
  
  public boolean contains(String paramString)
  {
    return contains(paramString);
  }
  
  public boolean contains(String paramString1, String paramString2, boolean paramBoolean)
  {
    return contains(paramString1, paramString2, paramBoolean);
  }
  
  public HttpHeaders copy()
  {
    return new DefaultHttpHeaders(this.headers.copy());
  }
  
  public List<Map.Entry<String, String>> entries()
  {
    if (isEmpty()) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(this.headers.size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Map.Entry)localIterator.next());
    }
    return localArrayList;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof DefaultHttpHeaders)) && (this.headers.equals(((DefaultHttpHeaders)paramObject).headers, AsciiString.CASE_SENSITIVE_HASHER))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String get(CharSequence paramCharSequence)
  {
    return HeadersUtils.getAsString(this.headers, paramCharSequence);
  }
  
  public String get(String paramString)
  {
    return get(paramString);
  }
  
  public List<String> getAll(CharSequence paramCharSequence)
  {
    return HeadersUtils.getAllAsString(this.headers, paramCharSequence);
  }
  
  public List<String> getAll(String paramString)
  {
    return getAll(paramString);
  }
  
  public int getInt(CharSequence paramCharSequence, int paramInt)
  {
    return this.headers.getInt(paramCharSequence, paramInt);
  }
  
  public Integer getInt(CharSequence paramCharSequence)
  {
    return this.headers.getInt(paramCharSequence);
  }
  
  public Short getShort(CharSequence paramCharSequence)
  {
    return this.headers.getShort(paramCharSequence);
  }
  
  public short getShort(CharSequence paramCharSequence, short paramShort)
  {
    return this.headers.getShort(paramCharSequence, paramShort);
  }
  
  public long getTimeMillis(CharSequence paramCharSequence, long paramLong)
  {
    return this.headers.getTimeMillis(paramCharSequence, paramLong);
  }
  
  public Long getTimeMillis(CharSequence paramCharSequence)
  {
    return this.headers.getTimeMillis(paramCharSequence);
  }
  
  public int hashCode()
  {
    return this.headers.hashCode(AsciiString.CASE_SENSITIVE_HASHER);
  }
  
  public boolean isEmpty()
  {
    return this.headers.isEmpty();
  }
  
  @Deprecated
  public Iterator<Map.Entry<String, String>> iterator()
  {
    return HeadersUtils.iteratorAsString(this.headers);
  }
  
  public Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence()
  {
    return this.headers.iterator();
  }
  
  public Set<String> names()
  {
    return HeadersUtils.namesAsString(this.headers);
  }
  
  public HttpHeaders remove(CharSequence paramCharSequence)
  {
    this.headers.remove(paramCharSequence);
    return this;
  }
  
  public HttpHeaders remove(String paramString)
  {
    this.headers.remove(paramString);
    return this;
  }
  
  public HttpHeaders set(HttpHeaders paramHttpHeaders)
  {
    if ((paramHttpHeaders instanceof DefaultHttpHeaders))
    {
      this.headers.set(((DefaultHttpHeaders)paramHttpHeaders).headers);
      return this;
    }
    return super.set(paramHttpHeaders);
  }
  
  public HttpHeaders set(CharSequence paramCharSequence, Iterable<?> paramIterable)
  {
    this.headers.setObject(paramCharSequence, paramIterable);
    return this;
  }
  
  public HttpHeaders set(CharSequence paramCharSequence, Object paramObject)
  {
    this.headers.setObject(paramCharSequence, paramObject);
    return this;
  }
  
  public HttpHeaders set(String paramString, Iterable<?> paramIterable)
  {
    this.headers.setObject(paramString, paramIterable);
    return this;
  }
  
  public HttpHeaders set(String paramString, Object paramObject)
  {
    this.headers.setObject(paramString, paramObject);
    return this;
  }
  
  public HttpHeaders setInt(CharSequence paramCharSequence, int paramInt)
  {
    this.headers.setInt(paramCharSequence, paramInt);
    return this;
  }
  
  public HttpHeaders setShort(CharSequence paramCharSequence, short paramShort)
  {
    this.headers.setShort(paramCharSequence, paramShort);
    return this;
  }
  
  public int size()
  {
    return this.headers.size();
  }
  
  public Iterator<CharSequence> valueCharSequenceIterator(CharSequence paramCharSequence)
  {
    return this.headers.valueIterator(paramCharSequence);
  }
  
  public Iterator<String> valueStringIterator(CharSequence paramCharSequence)
  {
    new Iterator()
    {
      public boolean hasNext()
      {
        return this.val$itr.hasNext();
      }
      
      public String next()
      {
        return ((CharSequence)this.val$itr.next()).toString();
      }
      
      public void remove()
      {
        this.val$itr.remove();
      }
    };
  }
  
  private static class HeaderValueConverter
    extends CharSequenceValueConverter
  {
    static final HeaderValueConverter INSTANCE = new HeaderValueConverter();
    
    public CharSequence convertObject(Object paramObject)
    {
      if ((paramObject instanceof CharSequence)) {
        return (CharSequence)paramObject;
      }
      if ((paramObject instanceof Date)) {
        return DateFormatter.format((Date)paramObject);
      }
      if ((paramObject instanceof Calendar)) {
        return DateFormatter.format(((Calendar)paramObject).getTime());
      }
      return paramObject.toString();
    }
  }
  
  private static final class HeaderValueConverterAndValidator
    extends DefaultHttpHeaders.HeaderValueConverter
  {
    static final HeaderValueConverterAndValidator INSTANCE = new HeaderValueConverterAndValidator();
    
    private HeaderValueConverterAndValidator()
    {
      super();
    }
    
    private static int validateValueChar(CharSequence paramCharSequence, int paramInt, char paramChar)
    {
      StringBuilder localStringBuilder;
      if ((paramChar & 0xFFFFFFF0) == 0) {
        if (paramChar != 0)
        {
          if (paramChar != '\013')
          {
            if (paramChar == '\f')
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("a header value contains a prohibited character '\\f': ");
              localStringBuilder.append(paramCharSequence);
              throw new IllegalArgumentException(localStringBuilder.toString());
            }
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("a header value contains a prohibited character '\\v': ");
            localStringBuilder.append(paramCharSequence);
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("a header value contains a prohibited character '\000': ");
          localStringBuilder.append(paramCharSequence);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2)
          {
            if ((paramChar != '\t') && (paramChar != ' '))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("only ' ' and '\\t' are allowed after '\\n': ");
              localStringBuilder.append(paramCharSequence);
              throw new IllegalArgumentException(localStringBuilder.toString());
            }
            return 0;
          }
        }
        else
        {
          if (paramChar == '\n') {
            return 2;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("only '\\n' is allowed after '\\r': ");
          localStringBuilder.append(paramCharSequence);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      else
      {
        if (paramChar == '\n') {
          break label249;
        }
        if (paramChar == '\r') {
          break label247;
        }
      }
      return paramInt;
      label247:
      return 1;
      label249:
      return 2;
    }
    
    public CharSequence convertObject(Object paramObject)
    {
      CharSequence localCharSequence = super.convertObject(paramObject);
      int i = 0;
      int j = 0;
      while (i < localCharSequence.length())
      {
        j = validateValueChar(localCharSequence, j, localCharSequence.charAt(i));
        i++;
      }
      if (j == 0) {
        return localCharSequence;
      }
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("a header value must not end with '\\r' or '\\n':");
      ((StringBuilder)paramObject).append(localCharSequence);
      throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\DefaultHttpHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */