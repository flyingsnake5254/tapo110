package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Set;

public final class k
  extends i
{
  private final LinkedTreeMap<String, i> a = new LinkedTreeMap();
  
  public Set<Map.Entry<String, i>> entrySet()
  {
    return this.a.entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject != this) && ((!(paramObject instanceof k)) || (!((k)paramObject).a.equals(this.a)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public void j(String paramString, i parami)
  {
    LinkedTreeMap localLinkedTreeMap = this.a;
    Object localObject = parami;
    if (parami == null) {
      localObject = j.a;
    }
    localLinkedTreeMap.put(paramString, localObject);
  }
  
  public void k(String paramString, Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      paramBoolean = j.a;
    } else {
      paramBoolean = new m(paramBoolean);
    }
    j(paramString, paramBoolean);
  }
  
  public void l(String paramString, Number paramNumber)
  {
    if (paramNumber == null) {
      paramNumber = j.a;
    } else {
      paramNumber = new m(paramNumber);
    }
    j(paramString, paramNumber);
  }
  
  public void m(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      paramString2 = j.a;
    } else {
      paramString2 = new m(paramString2);
    }
    j(paramString1, paramString2);
  }
  
  public i n(String paramString)
  {
    return (i)this.a.get(paramString);
  }
  
  public boolean o(String paramString)
  {
    return this.a.containsKey(paramString);
  }
  
  public Set<String> p()
  {
    return this.a.keySet();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */