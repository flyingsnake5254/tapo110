package okhttp3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

public final class Challenge
{
  private final Map<String, String> authParams;
  private final String scheme;
  
  public Challenge(String paramString1, String paramString2)
  {
    Objects.requireNonNull(paramString1, "scheme == null");
    Objects.requireNonNull(paramString2, "realm == null");
    this.scheme = paramString1;
    this.authParams = Collections.singletonMap("realm", paramString2);
  }
  
  public Challenge(String paramString, Map<String, String> paramMap)
  {
    Objects.requireNonNull(paramString, "scheme == null");
    Objects.requireNonNull(paramMap, "authParams == null");
    this.scheme = paramString;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      if (paramMap.getKey() == null) {
        paramString = null;
      } else {
        paramString = ((String)paramMap.getKey()).toLowerCase(Locale.US);
      }
      localLinkedHashMap.put(paramString, paramMap.getValue());
    }
    this.authParams = Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  public Map<String, String> authParams()
  {
    return this.authParams;
  }
  
  public Charset charset()
  {
    Object localObject = (String)this.authParams.get("charset");
    if (localObject != null) {}
    try
    {
      localObject = Charset.forName((String)localObject);
      return (Charset)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return Util.ISO_8859_1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Challenge))
    {
      paramObject = (Challenge)paramObject;
      if ((((Challenge)paramObject).scheme.equals(this.scheme)) && (((Challenge)paramObject).authParams.equals(this.authParams))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public int hashCode()
  {
    return (899 + this.scheme.hashCode()) * 31 + this.authParams.hashCode();
  }
  
  public String realm()
  {
    return (String)this.authParams.get("realm");
  }
  
  public String scheme()
  {
    return this.scheme;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.scheme);
    localStringBuilder.append(" authParams=");
    localStringBuilder.append(this.authParams);
    return localStringBuilder.toString();
  }
  
  public Challenge withCharset(Charset paramCharset)
  {
    Objects.requireNonNull(paramCharset, "charset == null");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.authParams);
    localLinkedHashMap.put("charset", paramCharset.name());
    return new Challenge(this.scheme, localLinkedHashMap);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\Challenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */