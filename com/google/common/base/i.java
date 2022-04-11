package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class i
{
  private final String a;
  
  private i(i parami)
  {
    this.a = parami.a;
  }
  
  private i(String paramString)
  {
    this.a = ((String)n.o(paramString));
  }
  
  public static i f(char paramChar)
  {
    return new i(String.valueOf(paramChar));
  }
  
  public static i g(String paramString)
  {
    return new i(paramString);
  }
  
  @CanIgnoreReturnValue
  public <A extends Appendable> A a(A paramA, Iterator<?> paramIterator)
    throws IOException
  {
    n.o(paramA);
    if (paramIterator.hasNext())
    {
      paramA.append(h(paramIterator.next()));
      while (paramIterator.hasNext())
      {
        paramA.append(this.a);
        paramA.append(h(paramIterator.next()));
      }
    }
    return paramA;
  }
  
  @CanIgnoreReturnValue
  public final StringBuilder b(StringBuilder paramStringBuilder, Iterator<?> paramIterator)
  {
    try
    {
      a(paramStringBuilder, paramIterator);
      return paramStringBuilder;
    }
    catch (IOException paramStringBuilder)
    {
      throw new AssertionError(paramStringBuilder);
    }
  }
  
  public final String c(Iterable<?> paramIterable)
  {
    return d(paramIterable.iterator());
  }
  
  public final String d(Iterator<?> paramIterator)
  {
    return b(new StringBuilder(), paramIterator).toString();
  }
  
  public final String e(Object[] paramArrayOfObject)
  {
    return c(Arrays.asList(paramArrayOfObject));
  }
  
  CharSequence h(Object paramObject)
  {
    n.o(paramObject);
    if ((paramObject instanceof CharSequence)) {
      paramObject = (CharSequence)paramObject;
    } else {
      paramObject = paramObject.toString();
    }
    return (CharSequence)paramObject;
  }
  
  public i i(final String paramString)
  {
    n.o(paramString);
    return new a(this, paramString);
  }
  
  class a
    extends i
  {
    a(i parami, String paramString)
    {
      super(null);
    }
    
    CharSequence h(@NullableDecl Object paramObject)
    {
      if (paramObject == null) {
        paramObject = paramString;
      } else {
        paramObject = i.this.h(paramObject);
      }
      return (CharSequence)paramObject;
    }
    
    public i i(String paramString)
    {
      throw new UnsupportedOperationException("already specified useForNull");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */