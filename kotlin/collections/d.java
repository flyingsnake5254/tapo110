package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.r.a;

final class d<T>
  implements Collection<T>, a
{
  private final T[] c;
  private final boolean d;
  
  public d(T[] paramArrayOfT, boolean paramBoolean)
  {
    this.c = paramArrayOfT;
    this.d = paramBoolean;
  }
  
  public int a()
  {
    return this.c.length;
  }
  
  public boolean add(T paramT)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(Object paramObject)
  {
    return e.j(this.c, paramObject);
  }
  
  public boolean containsAll(Collection<? extends Object> paramCollection)
  {
    j.e(paramCollection, "elements");
    boolean bool1 = paramCollection.isEmpty();
    boolean bool2 = true;
    if (bool1)
    {
      bool1 = bool2;
    }
    else
    {
      paramCollection = paramCollection.iterator();
      do
      {
        bool1 = bool2;
        if (!paramCollection.hasNext()) {
          break;
        }
      } while (contains(paramCollection.next()));
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.c.length == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<T> iterator()
  {
    return b.a(this.c);
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final Object[] toArray()
  {
    return m.a(this.c, this.d);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return kotlin.jvm.internal.e.b(this, paramArrayOfT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */