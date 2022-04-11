package io.netty.handler.codec.http;

import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.DefaultHeaders.NameValidator;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.ValueConverter;
import io.netty.util.AsciiString;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.StringUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class CombinedHttpHeaders
  extends DefaultHttpHeaders
{
  public CombinedHttpHeaders(boolean paramBoolean)
  {
    super(new CombinedHttpHeadersImpl(AsciiString.CASE_INSENSITIVE_HASHER, DefaultHttpHeaders.valueConverter(paramBoolean), DefaultHttpHeaders.nameValidator(paramBoolean)));
  }
  
  public boolean containsValue(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    return super.containsValue(paramCharSequence1, StringUtil.trimOws(paramCharSequence2), paramBoolean);
  }
  
  private static final class CombinedHttpHeadersImpl
    extends DefaultHeaders<CharSequence, CharSequence, CombinedHttpHeadersImpl>
  {
    private static final int VALUE_LENGTH_ESTIMATE = 10;
    private CsvValueEscaper<CharSequence> charSequenceEscaper;
    private CsvValueEscaper<Object> objectEscaper;
    
    CombinedHttpHeadersImpl(HashingStrategy<CharSequence> paramHashingStrategy, ValueConverter<CharSequence> paramValueConverter, DefaultHeaders.NameValidator<CharSequence> paramNameValidator)
    {
      super(paramValueConverter, paramNameValidator);
    }
    
    private CombinedHttpHeadersImpl addEscapedValue(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
    {
      CharSequence localCharSequence = (CharSequence)super.get(paramCharSequence1);
      if ((localCharSequence != null) && (!cannotBeCombined(paramCharSequence1))) {
        super.set(paramCharSequence1, commaSeparateEscapedValues(localCharSequence, paramCharSequence2));
      } else {
        super.add(paramCharSequence1, paramCharSequence2);
      }
      return this;
    }
    
    private static boolean cannotBeCombined(CharSequence paramCharSequence)
    {
      return HttpHeaderNames.SET_COOKIE.contentEqualsIgnoreCase(paramCharSequence);
    }
    
    private CsvValueEscaper<CharSequence> charSequenceEscaper()
    {
      if (this.charSequenceEscaper == null) {
        this.charSequenceEscaper = new CsvValueEscaper()
        {
          public CharSequence escape(CharSequence paramAnonymousCharSequence)
          {
            return StringUtil.escapeCsv(paramAnonymousCharSequence, true);
          }
        };
      }
      return this.charSequenceEscaper;
    }
    
    private static <T> CharSequence commaSeparate(CsvValueEscaper<T> paramCsvValueEscaper, Iterable<? extends T> paramIterable)
    {
      StringBuilder localStringBuilder;
      if ((paramIterable instanceof Collection)) {
        localStringBuilder = new StringBuilder(((Collection)paramIterable).size() * 10);
      } else {
        localStringBuilder = new StringBuilder();
      }
      Iterator localIterator = paramIterable.iterator();
      if (localIterator.hasNext())
      {
        for (paramIterable = localIterator.next(); localIterator.hasNext(); paramIterable = localIterator.next())
        {
          localStringBuilder.append(paramCsvValueEscaper.escape(paramIterable));
          localStringBuilder.append(',');
        }
        localStringBuilder.append(paramCsvValueEscaper.escape(paramIterable));
      }
      return localStringBuilder;
    }
    
    private static <T> CharSequence commaSeparate(CsvValueEscaper<T> paramCsvValueEscaper, T... paramVarArgs)
    {
      StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 10);
      if (paramVarArgs.length > 0)
      {
        int i = paramVarArgs.length - 1;
        for (int j = 0; j < i; j++)
        {
          localStringBuilder.append(paramCsvValueEscaper.escape(paramVarArgs[j]));
          localStringBuilder.append(',');
        }
        localStringBuilder.append(paramCsvValueEscaper.escape(paramVarArgs[i]));
      }
      return localStringBuilder;
    }
    
    private static CharSequence commaSeparateEscapedValues(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
    {
      StringBuilder localStringBuilder = new StringBuilder(paramCharSequence1.length() + 1 + paramCharSequence2.length());
      localStringBuilder.append(paramCharSequence1);
      localStringBuilder.append(',');
      localStringBuilder.append(paramCharSequence2);
      return localStringBuilder;
    }
    
    private CsvValueEscaper<Object> objectEscaper()
    {
      if (this.objectEscaper == null) {
        this.objectEscaper = new CsvValueEscaper()
        {
          public CharSequence escape(Object paramAnonymousObject)
          {
            return StringUtil.escapeCsv((CharSequence)CombinedHttpHeaders.CombinedHttpHeadersImpl.this.valueConverter().convertObject(paramAnonymousObject), true);
          }
        };
      }
      return this.objectEscaper;
    }
    
    public CombinedHttpHeadersImpl add(Headers<? extends CharSequence, ? extends CharSequence, ?> paramHeaders)
    {
      if (paramHeaders != this)
      {
        Object localObject;
        if ((paramHeaders instanceof CombinedHttpHeadersImpl))
        {
          if (isEmpty())
          {
            addImpl(paramHeaders);
          }
          else
          {
            localObject = paramHeaders.iterator();
            while (((Iterator)localObject).hasNext())
            {
              paramHeaders = (Map.Entry)((Iterator)localObject).next();
              addEscapedValue((CharSequence)paramHeaders.getKey(), (CharSequence)paramHeaders.getValue());
            }
          }
        }
        else
        {
          paramHeaders = paramHeaders.iterator();
          while (paramHeaders.hasNext())
          {
            localObject = (Map.Entry)paramHeaders.next();
            add((CharSequence)((Map.Entry)localObject).getKey(), (CharSequence)((Map.Entry)localObject).getValue());
          }
        }
        return this;
      }
      throw new IllegalArgumentException("can't add to itself.");
    }
    
    public CombinedHttpHeadersImpl add(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
    {
      return addEscapedValue(paramCharSequence1, charSequenceEscaper().escape(paramCharSequence2));
    }
    
    public CombinedHttpHeadersImpl add(CharSequence paramCharSequence, Iterable<? extends CharSequence> paramIterable)
    {
      return addEscapedValue(paramCharSequence, commaSeparate(charSequenceEscaper(), paramIterable));
    }
    
    public CombinedHttpHeadersImpl add(CharSequence paramCharSequence, CharSequence... paramVarArgs)
    {
      return addEscapedValue(paramCharSequence, commaSeparate(charSequenceEscaper(), paramVarArgs));
    }
    
    public CombinedHttpHeadersImpl addObject(CharSequence paramCharSequence, Iterable<?> paramIterable)
    {
      return addEscapedValue(paramCharSequence, commaSeparate(objectEscaper(), paramIterable));
    }
    
    public CombinedHttpHeadersImpl addObject(CharSequence paramCharSequence, Object paramObject)
    {
      return addEscapedValue(paramCharSequence, commaSeparate(objectEscaper(), new Object[] { paramObject }));
    }
    
    public CombinedHttpHeadersImpl addObject(CharSequence paramCharSequence, Object... paramVarArgs)
    {
      return addEscapedValue(paramCharSequence, commaSeparate(objectEscaper(), paramVarArgs));
    }
    
    public List<CharSequence> getAll(CharSequence paramCharSequence)
    {
      List localList = super.getAll(paramCharSequence);
      if ((!localList.isEmpty()) && (!cannotBeCombined(paramCharSequence)))
      {
        if (localList.size() == 1) {
          return StringUtil.unescapeCsvFields((CharSequence)localList.get(0));
        }
        throw new IllegalStateException("CombinedHttpHeaders should only have one value");
      }
      return localList;
    }
    
    public CombinedHttpHeadersImpl set(Headers<? extends CharSequence, ? extends CharSequence, ?> paramHeaders)
    {
      if (paramHeaders == this) {
        return this;
      }
      clear();
      return add(paramHeaders);
    }
    
    public CombinedHttpHeadersImpl set(CharSequence paramCharSequence, Iterable<? extends CharSequence> paramIterable)
    {
      super.set(paramCharSequence, commaSeparate(charSequenceEscaper(), paramIterable));
      return this;
    }
    
    public CombinedHttpHeadersImpl set(CharSequence paramCharSequence, CharSequence... paramVarArgs)
    {
      super.set(paramCharSequence, commaSeparate(charSequenceEscaper(), paramVarArgs));
      return this;
    }
    
    public CombinedHttpHeadersImpl setAll(Headers<? extends CharSequence, ? extends CharSequence, ?> paramHeaders)
    {
      if (paramHeaders == this) {
        return this;
      }
      Iterator localIterator = paramHeaders.names().iterator();
      while (localIterator.hasNext()) {
        remove((CharSequence)localIterator.next());
      }
      return add(paramHeaders);
    }
    
    public CombinedHttpHeadersImpl setObject(CharSequence paramCharSequence, Iterable<?> paramIterable)
    {
      super.set(paramCharSequence, commaSeparate(objectEscaper(), paramIterable));
      return this;
    }
    
    public CombinedHttpHeadersImpl setObject(CharSequence paramCharSequence, Object paramObject)
    {
      super.set(paramCharSequence, commaSeparate(objectEscaper(), new Object[] { paramObject }));
      return this;
    }
    
    public CombinedHttpHeadersImpl setObject(CharSequence paramCharSequence, Object... paramVarArgs)
    {
      super.set(paramCharSequence, commaSeparate(objectEscaper(), paramVarArgs));
      return this;
    }
    
    public Iterator<CharSequence> valueIterator(CharSequence paramCharSequence)
    {
      Iterator localIterator = super.valueIterator(paramCharSequence);
      if ((localIterator.hasNext()) && (!cannotBeCombined(paramCharSequence)))
      {
        paramCharSequence = StringUtil.unescapeCsvFields((CharSequence)localIterator.next()).iterator();
        if (!localIterator.hasNext()) {
          return paramCharSequence;
        }
        throw new IllegalStateException("CombinedHttpHeaders should only have one value");
      }
      return localIterator;
    }
    
    private static abstract interface CsvValueEscaper<T>
    {
      public abstract CharSequence escape(T paramT);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\CombinedHttpHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */