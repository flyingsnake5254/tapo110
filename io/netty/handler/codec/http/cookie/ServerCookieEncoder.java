package io.netty.handler.codec.http.cookie;

import io.netty.handler.codec.DateFormatter;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ServerCookieEncoder
  extends CookieEncoder
{
  public static final ServerCookieEncoder LAX = new ServerCookieEncoder(false);
  public static final ServerCookieEncoder STRICT = new ServerCookieEncoder(true);
  
  private ServerCookieEncoder(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  private static List<String> dedup(List<String> paramList, Map<String, Integer> paramMap)
  {
    boolean[] arrayOfBoolean = new boolean[paramList.size()];
    Iterator localIterator = paramMap.values().iterator();
    while (localIterator.hasNext()) {
      arrayOfBoolean[((Integer)localIterator.next()).intValue()] = true;
    }
    paramMap = new ArrayList(paramMap.size());
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      if (arrayOfBoolean[i] != 0) {
        paramMap.add(paramList.get(i));
      }
      i++;
    }
    return paramMap;
  }
  
  public String encode(Cookie paramCookie)
  {
    String str = ((Cookie)ObjectUtil.checkNotNull(paramCookie, "cookie")).name();
    Object localObject;
    if (paramCookie.value() != null) {
      localObject = paramCookie.value();
    } else {
      localObject = "";
    }
    validateCookie(str, (String)localObject);
    StringBuilder localStringBuilder = CookieUtil.stringBuilder();
    if (paramCookie.wrap()) {
      CookieUtil.addQuoted(localStringBuilder, str, (String)localObject);
    } else {
      CookieUtil.add(localStringBuilder, str, (String)localObject);
    }
    if (paramCookie.maxAge() != Long.MIN_VALUE)
    {
      CookieUtil.add(localStringBuilder, "Max-Age", paramCookie.maxAge());
      localObject = new Date(paramCookie.maxAge() * 1000L + System.currentTimeMillis());
      localStringBuilder.append("Expires");
      localStringBuilder.append('=');
      DateFormatter.append((Date)localObject, localStringBuilder);
      localStringBuilder.append(';');
      localStringBuilder.append(' ');
    }
    if (paramCookie.path() != null) {
      CookieUtil.add(localStringBuilder, "Path", paramCookie.path());
    }
    if (paramCookie.domain() != null) {
      CookieUtil.add(localStringBuilder, "Domain", paramCookie.domain());
    }
    if (paramCookie.isSecure()) {
      CookieUtil.add(localStringBuilder, "Secure");
    }
    if (paramCookie.isHttpOnly()) {
      CookieUtil.add(localStringBuilder, "HTTPOnly");
    }
    if ((paramCookie instanceof DefaultCookie))
    {
      paramCookie = (DefaultCookie)paramCookie;
      if (paramCookie.sameSite() != null) {
        CookieUtil.add(localStringBuilder, "SameSite", paramCookie.sameSite().name());
      }
    }
    return CookieUtil.stripTrailingSeparator(localStringBuilder);
  }
  
  public String encode(String paramString1, String paramString2)
  {
    return encode(new DefaultCookie(paramString1, paramString2));
  }
  
  public List<String> encode(Iterable<? extends Cookie> paramIterable)
  {
    Object localObject = ((Iterable)ObjectUtil.checkNotNull(paramIterable, "cookies")).iterator();
    if (!((Iterator)localObject).hasNext()) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    Cookie localCookie = (Cookie)((Iterator)localObject).next();
    if ((this.strict) && (((Iterator)localObject).hasNext())) {
      paramIterable = new HashMap();
    } else {
      paramIterable = null;
    }
    localArrayList.add(encode(localCookie));
    int i;
    if (paramIterable != null)
    {
      if (paramIterable.put(localCookie.name(), Integer.valueOf(0)) != null)
      {
        i = 1;
        j = 1;
        break label134;
      }
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = 0;
    label134:
    while (((Iterator)localObject).hasNext())
    {
      localCookie = (Cookie)((Iterator)localObject).next();
      localArrayList.add(encode(localCookie));
      if (paramIterable != null)
      {
        int k;
        if (paramIterable.put(localCookie.name(), Integer.valueOf(i)) != null) {
          k = 1;
        } else {
          k = 0;
        }
        j = k | j;
        i++;
      }
    }
    localObject = localArrayList;
    if (j != 0) {
      localObject = dedup(localArrayList, paramIterable);
    }
    return (List<String>)localObject;
  }
  
  public List<String> encode(Collection<? extends Cookie> paramCollection)
  {
    if (((Collection)ObjectUtil.checkNotNull(paramCollection, "cookies")).isEmpty()) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    HashMap localHashMap;
    if ((this.strict) && (paramCollection.size() > 1)) {
      localHashMap = new HashMap();
    } else {
      localHashMap = null;
    }
    paramCollection = paramCollection.iterator();
    int i = 0;
    int j = 0;
    while (paramCollection.hasNext())
    {
      Cookie localCookie = (Cookie)paramCollection.next();
      localArrayList.add(encode(localCookie));
      if (localHashMap != null)
      {
        int k;
        if (localHashMap.put(localCookie.name(), Integer.valueOf(j)) != null) {
          k = 1;
        } else {
          k = 0;
        }
        i |= k;
        j++;
      }
    }
    paramCollection = localArrayList;
    if (i != 0) {
      paramCollection = dedup(localArrayList, localHashMap);
    }
    return paramCollection;
  }
  
  public List<String> encode(Cookie... paramVarArgs)
  {
    if (((Cookie[])ObjectUtil.checkNotNull(paramVarArgs, "cookies")).length == 0) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    HashMap localHashMap;
    if ((this.strict) && (paramVarArgs.length > 1)) {
      localHashMap = new HashMap();
    } else {
      localHashMap = null;
    }
    int i = 0;
    int k;
    for (int j = 0; i < paramVarArgs.length; j = k)
    {
      Cookie localCookie = paramVarArgs[i];
      localArrayList.add(encode(localCookie));
      k = j;
      if (localHashMap != null)
      {
        if (localHashMap.put(localCookie.name(), Integer.valueOf(i)) != null) {
          k = 1;
        } else {
          k = 0;
        }
        k = j | k;
      }
      i++;
    }
    paramVarArgs = localArrayList;
    if (j != 0) {
      paramVarArgs = dedup(localArrayList, localHashMap);
    }
    return paramVarArgs;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cookie\ServerCookieEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */