package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public class DomainNameMapping<V>
  implements Mapping<String, V>
{
  final V defaultValue;
  private final Map<String, V> map;
  private final Map<String, V> unmodifiableMap;
  
  @Deprecated
  public DomainNameMapping(int paramInt, V paramV)
  {
    this(new LinkedHashMap(paramInt), paramV);
  }
  
  @Deprecated
  public DomainNameMapping(V paramV)
  {
    this(4, paramV);
  }
  
  DomainNameMapping(Map<String, V> paramMap, V paramV)
  {
    this.defaultValue = ObjectUtil.checkNotNull(paramV, "defaultValue");
    this.map = paramMap;
    if (paramMap != null) {
      paramMap = Collections.unmodifiableMap(paramMap);
    } else {
      paramMap = null;
    }
    this.unmodifiableMap = paramMap;
  }
  
  static boolean matches(String paramString1, String paramString2)
  {
    if (paramString1.startsWith("*."))
    {
      int i = paramString2.length();
      boolean bool = false;
      if ((paramString1.regionMatches(2, paramString2, 0, i)) || (StringUtil.commonSuffixOfLength(paramString2, paramString1, paramString1.length() - 1))) {
        bool = true;
      }
      return bool;
    }
    return paramString1.equals(paramString2);
  }
  
  private static boolean needsNormalization(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++) {
      if (paramString.charAt(j) > '') {
        return true;
      }
    }
    return false;
  }
  
  static String normalizeHostname(String paramString)
  {
    String str = paramString;
    if (needsNormalization(paramString)) {
      str = IDN.toASCII(paramString, 1);
    }
    return str.toLowerCase(Locale.US);
  }
  
  @Deprecated
  public DomainNameMapping<V> add(String paramString, V paramV)
  {
    this.map.put(normalizeHostname((String)ObjectUtil.checkNotNull(paramString, "hostname")), ObjectUtil.checkNotNull(paramV, "output"));
    return this;
  }
  
  public Map<String, V> asMap()
  {
    return this.unmodifiableMap;
  }
  
  public V map(String paramString)
  {
    if (paramString != null)
    {
      String str = normalizeHostname(paramString);
      Iterator localIterator = this.map.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramString = (Map.Entry)localIterator.next();
        if (matches((String)paramString.getKey(), str)) {
          return (V)paramString.getValue();
        }
      }
    }
    return (V)this.defaultValue;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(default: ");
    localStringBuilder.append(this.defaultValue);
    localStringBuilder.append(", map: ");
    localStringBuilder.append(this.map);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\DomainNameMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */