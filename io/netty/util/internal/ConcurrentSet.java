package io.netty.util.internal;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

@Deprecated
public final class ConcurrentSet<E>
  extends AbstractSet<E>
  implements Serializable
{
  private static final long serialVersionUID = -6761513279741915432L;
  private final ConcurrentMap<E, Boolean> map = PlatformDependent.newConcurrentHashMap();
  
  public boolean add(E paramE)
  {
    boolean bool;
    if (this.map.putIfAbsent(paramE, Boolean.TRUE) == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void clear()
  {
    this.map.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }
  
  public Iterator<E> iterator()
  {
    return this.map.keySet().iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    boolean bool;
    if (this.map.remove(paramObject) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int size()
  {
    return this.map.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\ConcurrentSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */