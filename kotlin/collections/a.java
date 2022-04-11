package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;

public abstract class a<E>
  implements Collection<E>, kotlin.jvm.internal.r.a
{
  public abstract int a();
  
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(Object paramObject)
  {
    boolean bool1 = isEmpty();
    boolean bool2 = false;
    if (bool1)
    {
      bool1 = bool2;
    }
    else
    {
      Iterator localIterator = iterator();
      do
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!j.a(localIterator.next(), paramObject));
      bool1 = true;
    }
    return bool1;
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
  
  public Object[] toArray()
  {
    return e.a(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    j.e(paramArrayOfT, "array");
    paramArrayOfT = e.b(this, paramArrayOfT);
    Objects.requireNonNull(paramArrayOfT, "null cannot be cast to non-null type kotlin.Array<T>");
    return paramArrayOfT;
  }
  
  public String toString()
  {
    return l.E(this, ", ", "[", "]", 0, null, new a(this), 24, null);
  }
  
  static final class a
    extends Lambda
    implements kotlin.jvm.b.l<E, CharSequence>
  {
    a(a parama)
    {
      super();
    }
    
    public final CharSequence a(E paramE)
    {
      if (paramE == this.c) {
        paramE = "(this Collection)";
      } else {
        paramE = String.valueOf(paramE);
      }
      return paramE;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */