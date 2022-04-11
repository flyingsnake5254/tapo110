package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DomainWildcardMappingBuilder<V>
{
  private final V defaultValue;
  private final Map<String, V> map;
  
  public DomainWildcardMappingBuilder(int paramInt, V paramV)
  {
    this.defaultValue = ObjectUtil.checkNotNull(paramV, "defaultValue");
    this.map = new LinkedHashMap(paramInt);
  }
  
  public DomainWildcardMappingBuilder(V paramV)
  {
    this(4, paramV);
  }
  
  private String normalizeHostName(String paramString)
  {
    ObjectUtil.checkNotNull(paramString, "hostname");
    if ((!paramString.isEmpty()) && (paramString.charAt(0) != '.'))
    {
      paramString = ImmutableDomainWildcardMapping.normalize((String)ObjectUtil.checkNotNull(paramString, "hostname"));
      if (paramString.charAt(0) == '*')
      {
        if ((paramString.length() >= 3) && (paramString.charAt(1) == '.')) {
          return paramString.substring(1);
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Wildcard Hostname '");
        localStringBuilder.append(paramString);
        localStringBuilder.append("'not valid");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hostname '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' not valid");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public DomainWildcardMappingBuilder<V> add(String paramString, V paramV)
  {
    this.map.put(normalizeHostName(paramString), ObjectUtil.checkNotNull(paramV, "output"));
    return this;
  }
  
  public Mapping<String, V> build()
  {
    return new ImmutableDomainWildcardMapping(this.defaultValue, this.map);
  }
  
  private static final class ImmutableDomainWildcardMapping<V>
    implements Mapping<String, V>
  {
    private static final String REPR_HEADER = "ImmutableDomainWildcardMapping(default: ";
    private static final String REPR_MAP_CLOSING = ")";
    private static final String REPR_MAP_OPENING = ", map: ";
    private final V defaultValue;
    private final Map<String, V> map;
    
    ImmutableDomainWildcardMapping(V paramV, Map<String, V> paramMap)
    {
      this.defaultValue = paramV;
      this.map = new LinkedHashMap(paramMap);
    }
    
    static String normalize(String paramString)
    {
      return DomainNameMapping.normalizeHostname(paramString);
    }
    
    public V map(String paramString)
    {
      if (paramString != null)
      {
        String str = normalize(paramString);
        paramString = this.map.get(str);
        if (paramString != null) {
          return paramString;
        }
        int i = str.indexOf('.');
        if (i != -1)
        {
          paramString = this.map.get(str.substring(i));
          if (paramString != null) {
            return paramString;
          }
        }
      }
      return (V)this.defaultValue;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ImmutableDomainWildcardMapping(default: ");
      localStringBuilder.append(this.defaultValue);
      localStringBuilder.append(", map: ");
      localStringBuilder.append('{');
      Iterator localIterator = this.map.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        Object localObject = str;
        if (str.charAt(0) == '.')
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append('*');
          ((StringBuilder)localObject).append(str);
          localObject = ((StringBuilder)localObject).toString();
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append('=');
        localStringBuilder.append(localEntry.getValue());
        localStringBuilder.append(", ");
      }
      localStringBuilder.setLength(localStringBuilder.length() - 2);
      localStringBuilder.append('}');
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\DomainWildcardMappingBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */