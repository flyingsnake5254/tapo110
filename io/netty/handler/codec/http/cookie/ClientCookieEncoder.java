package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class ClientCookieEncoder
  extends CookieEncoder
{
  static final Comparator<Cookie> COOKIE_COMPARATOR = new Comparator()
  {
    public int compare(Cookie paramAnonymousCookie1, Cookie paramAnonymousCookie2)
    {
      paramAnonymousCookie1 = paramAnonymousCookie1.path();
      paramAnonymousCookie2 = paramAnonymousCookie2.path();
      int i = Integer.MAX_VALUE;
      int j;
      if (paramAnonymousCookie1 == null) {
        j = Integer.MAX_VALUE;
      } else {
        j = paramAnonymousCookie1.length();
      }
      if (paramAnonymousCookie2 != null) {
        i = paramAnonymousCookie2.length();
      }
      return i - j;
    }
  };
  public static final ClientCookieEncoder LAX;
  public static final ClientCookieEncoder STRICT = new ClientCookieEncoder(true);
  
  static
  {
    LAX = new ClientCookieEncoder(false);
  }
  
  private ClientCookieEncoder(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  private void encode(StringBuilder paramStringBuilder, Cookie paramCookie)
  {
    String str1 = paramCookie.name();
    String str2;
    if (paramCookie.value() != null) {
      str2 = paramCookie.value();
    } else {
      str2 = "";
    }
    validateCookie(str1, str2);
    if (paramCookie.wrap()) {
      CookieUtil.addQuoted(paramStringBuilder, str1, str2);
    } else {
      CookieUtil.add(paramStringBuilder, str1, str2);
    }
  }
  
  public String encode(Cookie paramCookie)
  {
    StringBuilder localStringBuilder = CookieUtil.stringBuilder();
    encode(localStringBuilder, (Cookie)ObjectUtil.checkNotNull(paramCookie, "cookie"));
    return CookieUtil.stripTrailingSeparator(localStringBuilder);
  }
  
  public String encode(Iterable<? extends Cookie> paramIterable)
  {
    Iterator localIterator = ((Iterable)ObjectUtil.checkNotNull(paramIterable, "cookies")).iterator();
    if (!localIterator.hasNext()) {
      return null;
    }
    paramIterable = CookieUtil.stringBuilder();
    if (this.strict)
    {
      Cookie localCookie = (Cookie)localIterator.next();
      if (!localIterator.hasNext())
      {
        encode(paramIterable, localCookie);
      }
      else
      {
        Object localObject = InternalThreadLocalMap.get().arrayList();
        ((List)localObject).add(localCookie);
        while (localIterator.hasNext()) {
          ((List)localObject).add(localIterator.next());
        }
        int i = 0;
        localObject = (Cookie[])((List)localObject).toArray(new Cookie[0]);
        Arrays.sort((Object[])localObject, COOKIE_COMPARATOR);
        int j = localObject.length;
        while (i < j)
        {
          encode(paramIterable, localObject[i]);
          i++;
        }
      }
    }
    else
    {
      while (localIterator.hasNext()) {
        encode(paramIterable, (Cookie)localIterator.next());
      }
    }
    return CookieUtil.stripTrailingSeparatorOrNull(paramIterable);
  }
  
  public String encode(String paramString1, String paramString2)
  {
    return encode(new DefaultCookie(paramString1, paramString2));
  }
  
  public String encode(Collection<? extends Cookie> paramCollection)
  {
    if (((Collection)ObjectUtil.checkNotNull(paramCollection, "cookies")).isEmpty()) {
      return null;
    }
    StringBuilder localStringBuilder = CookieUtil.stringBuilder();
    if (this.strict)
    {
      if (paramCollection.size() == 1)
      {
        encode(localStringBuilder, (Cookie)paramCollection.iterator().next());
      }
      else
      {
        int i = 0;
        paramCollection = (Cookie[])paramCollection.toArray(new Cookie[0]);
        Arrays.sort(paramCollection, COOKIE_COMPARATOR);
        int j = paramCollection.length;
        while (i < j)
        {
          encode(localStringBuilder, paramCollection[i]);
          i++;
        }
      }
    }
    else
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        encode(localStringBuilder, (Cookie)paramCollection.next());
      }
    }
    return CookieUtil.stripTrailingSeparatorOrNull(localStringBuilder);
  }
  
  public String encode(Cookie... paramVarArgs)
  {
    if (((Cookie[])ObjectUtil.checkNotNull(paramVarArgs, "cookies")).length == 0) {
      return null;
    }
    StringBuilder localStringBuilder = CookieUtil.stringBuilder();
    boolean bool = this.strict;
    int i = 0;
    int j = 0;
    if (bool)
    {
      if (paramVarArgs.length == 1)
      {
        encode(localStringBuilder, paramVarArgs[0]);
      }
      else
      {
        paramVarArgs = (Cookie[])Arrays.copyOf(paramVarArgs, paramVarArgs.length);
        Arrays.sort(paramVarArgs, COOKIE_COMPARATOR);
        i = paramVarArgs.length;
        while (j < i)
        {
          encode(localStringBuilder, paramVarArgs[j]);
          j++;
        }
      }
    }
    else
    {
      int k = paramVarArgs.length;
      for (j = i; j < k; j++) {
        encode(localStringBuilder, paramVarArgs[j]);
      }
    }
    return CookieUtil.stripTrailingSeparatorOrNull(localStringBuilder);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cookie\ClientCookieEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */