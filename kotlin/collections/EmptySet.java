package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.r.a;

public final class EmptySet
  implements Set, Serializable, a
{
  public static final EmptySet INSTANCE = new EmptySet();
  private static final long serialVersionUID = 3406603774387020532L;
  
  private final Object readResolve()
  {
    return INSTANCE;
  }
  
  public boolean add(Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(Void paramVoid)
  {
    j.e(paramVoid, "element");
    return false;
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    j.e(paramCollection, "elements");
    return paramCollection.isEmpty();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof Set)) && (((Set)paramObject).isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int getSize()
  {
    return 0;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Iterator iterator()
  {
    return w.c;
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public Object[] toArray()
  {
    return e.a(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return e.b(this, paramArrayOfT);
  }
  
  public String toString()
  {
    return "[]";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\EmptySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */