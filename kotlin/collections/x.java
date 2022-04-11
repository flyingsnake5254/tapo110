package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.r.a;

final class x
  implements Map, Serializable, a
{
  public static final x c = new x();
  
  public boolean a(Void paramVoid)
  {
    j.e(paramVoid, "value");
    return false;
  }
  
  public Void b(Object paramObject)
  {
    return null;
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean containsKey(Object paramObject)
  {
    return false;
  }
  
  public Set<Map.Entry> d()
  {
    return EmptySet.INSTANCE;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof Map)) && (((Map)paramObject).isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Set<Object> f()
  {
    return EmptySet.INSTANCE;
  }
  
  public int g()
  {
    return 0;
  }
  
  public Collection h()
  {
    return EmptyList.INSTANCE;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public void putAll(Map paramMap)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public Object remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public String toString()
  {
    return "{}";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */