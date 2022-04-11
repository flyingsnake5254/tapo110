package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public final class DomainNameMappingBuilder<V>
{
  private final V defaultValue;
  private final Map<String, V> map;
  
  public DomainNameMappingBuilder(int paramInt, V paramV)
  {
    this.defaultValue = ObjectUtil.checkNotNull(paramV, "defaultValue");
    this.map = new LinkedHashMap(paramInt);
  }
  
  public DomainNameMappingBuilder(V paramV)
  {
    this(4, paramV);
  }
  
  public DomainNameMappingBuilder<V> add(String paramString, V paramV)
  {
    this.map.put(ObjectUtil.checkNotNull(paramString, "hostname"), ObjectUtil.checkNotNull(paramV, "output"));
    return this;
  }
  
  public DomainNameMapping<V> build()
  {
    return new ImmutableDomainNameMapping(this.defaultValue, this.map, null);
  }
  
  private static final class ImmutableDomainNameMapping<V>
    extends DomainNameMapping<V>
  {
    private static final int REPR_CONST_PART_LENGTH = 46;
    private static final String REPR_HEADER = "ImmutableDomainNameMapping(default: ";
    private static final String REPR_MAP_CLOSING = "})";
    private static final String REPR_MAP_OPENING = ", map: {";
    private final String[] domainNamePatterns;
    private final Map<String, V> map;
    private final V[] values;
    
    private ImmutableDomainNameMapping(V paramV, Map<String, V> paramMap)
    {
      super(paramV);
      Object localObject1 = paramMap.entrySet();
      int i = ((Set)localObject1).size();
      this.domainNamePatterns = new String[i];
      this.values = new Object[i];
      paramV = new LinkedHashMap(paramMap.size());
      paramMap = ((Set)localObject1).iterator();
      for (i = 0; paramMap.hasNext(); i++)
      {
        Object localObject2 = (Map.Entry)paramMap.next();
        localObject1 = DomainNameMapping.normalizeHostname((String)((Map.Entry)localObject2).getKey());
        localObject2 = ((Map.Entry)localObject2).getValue();
        this.domainNamePatterns[i] = localObject1;
        this.values[i] = localObject2;
        paramV.put(localObject1, localObject2);
      }
      this.map = Collections.unmodifiableMap(paramV);
    }
    
    private StringBuilder appendMapping(StringBuilder paramStringBuilder, int paramInt)
    {
      return appendMapping(paramStringBuilder, this.domainNamePatterns[paramInt], this.values[paramInt].toString());
    }
    
    private static StringBuilder appendMapping(StringBuilder paramStringBuilder, String paramString1, String paramString2)
    {
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append('=');
      paramStringBuilder.append(paramString2);
      return paramStringBuilder;
    }
    
    private static int estimateBufferSize(int paramInt1, int paramInt2, int paramInt3)
    {
      return REPR_CONST_PART_LENGTH + paramInt1 + (int)(paramInt3 * paramInt2 * 1.1D);
    }
    
    @Deprecated
    public DomainNameMapping<V> add(String paramString, V paramV)
    {
      throw new UnsupportedOperationException("Immutable DomainNameMapping does not support modification after initial creation");
    }
    
    public Map<String, V> asMap()
    {
      return this.map;
    }
    
    public V map(String paramString)
    {
      if (paramString != null)
      {
        paramString = DomainNameMapping.normalizeHostname(paramString);
        int i = this.domainNamePatterns.length;
        for (int j = 0; j < i; j++) {
          if (DomainNameMapping.matches(this.domainNamePatterns[j], paramString)) {
            return (V)this.values[j];
          }
        }
      }
      return (V)this.defaultValue;
    }
    
    public String toString()
    {
      String str1 = this.defaultValue.toString();
      Object localObject = this.domainNamePatterns;
      int i = localObject.length;
      if (i == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ImmutableDomainNameMapping(default: ");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(", map: {");
        ((StringBuilder)localObject).append("})");
        return ((StringBuilder)localObject).toString();
      }
      localObject = localObject[0];
      String str2 = this.values[0].toString();
      int j = ((String)localObject).length();
      int k = str2.length();
      StringBuilder localStringBuilder = new StringBuilder(estimateBufferSize(str1.length(), i, j + k + 3));
      localStringBuilder.append("ImmutableDomainNameMapping(default: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", map: {");
      appendMapping(localStringBuilder, (String)localObject, str2);
      for (k = 1; k < i; k++)
      {
        localStringBuilder.append(", ");
        appendMapping(localStringBuilder, k);
      }
      localStringBuilder.append("})");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\DomainNameMappingBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */