package com.bumptech.glide.load.j;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j
  implements h
{
  private final Map<String, List<i>> c;
  private volatile Map<String, String> d;
  
  j(Map<String, List<i>> paramMap)
  {
    this.c = Collections.unmodifiableMap(paramMap);
  }
  
  @NonNull
  private String b(@NonNull List<i> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      String str = ((i)paramList.get(j)).a();
      if (!TextUtils.isEmpty(str))
      {
        localStringBuilder.append(str);
        if (j != paramList.size() - 1) {
          localStringBuilder.append(',');
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private Map<String, String> c()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = b((List)localEntry.getValue());
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put(localEntry.getKey(), str);
      }
    }
    return localHashMap;
  }
  
  public Map<String, String> a()
  {
    if (this.d == null) {
      try
      {
        if (this.d == null) {
          this.d = Collections.unmodifiableMap(c());
        }
      }
      finally {}
    }
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof j))
    {
      paramObject = (j)paramObject;
      return this.c.equals(((j)paramObject).c);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LazyHeaders{headers=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    private static final String a;
    private static final Map<String, List<i>> b;
    private boolean c = true;
    private Map<String, List<i>> d = b;
    private boolean e = true;
    
    static
    {
      String str = b();
      a = str;
      HashMap localHashMap = new HashMap(2);
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put("User-Agent", Collections.singletonList(new j.b(str)));
      }
      b = Collections.unmodifiableMap(localHashMap);
    }
    
    @VisibleForTesting
    static String b()
    {
      String str = System.getProperty("http.agent");
      if (TextUtils.isEmpty(str)) {
        return str;
      }
      int i = str.length();
      StringBuilder localStringBuilder = new StringBuilder(str.length());
      for (int j = 0; j < i; j++)
      {
        char c1 = str.charAt(j);
        if (((c1 > '\037') || (c1 == '\t')) && (c1 < '')) {
          localStringBuilder.append(c1);
        } else {
          localStringBuilder.append('?');
        }
      }
      return localStringBuilder.toString();
    }
    
    public j a()
    {
      this.c = true;
      return new j(this.d);
    }
  }
  
  static final class b
    implements i
  {
    @NonNull
    private final String a;
    
    b(@NonNull String paramString)
    {
      this.a = paramString;
    }
    
    public String a()
    {
      return this.a;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        return this.a.equals(((b)paramObject).a);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StringHeaderFactory{value='");
      localStringBuilder.append(this.a);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */