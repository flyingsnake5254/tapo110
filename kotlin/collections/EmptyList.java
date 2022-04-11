package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.r.a;

public final class EmptyList
  implements List, Serializable, RandomAccess, a
{
  public static final EmptyList INSTANCE = new EmptyList();
  private static final long serialVersionUID = -7390468764508069838L;
  
  private final Object readResolve()
  {
    return INSTANCE;
  }
  
  public void add(int paramInt, Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean add(Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(int paramInt, Collection paramCollection)
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
    if (((paramObject instanceof List)) && (((List)paramObject).isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Void get(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Empty list doesn't contain element at index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append('.');
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public int getSize()
  {
    return 0;
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public int indexOf(Void paramVoid)
  {
    j.e(paramVoid, "element");
    return -1;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Iterator iterator()
  {
    return w.c;
  }
  
  public int lastIndexOf(Void paramVoid)
  {
    j.e(paramVoid, "element");
    return -1;
  }
  
  public ListIterator listIterator()
  {
    return w.c;
  }
  
  public ListIterator listIterator(int paramInt)
  {
    if (paramInt == 0) {
      return w.c;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index: ");
    localStringBuilder.append(paramInt);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public Void remove(int paramInt)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
  
  public Void set(int paramInt, Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public List subList(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromIndex: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", toIndex: ");
    localStringBuilder.append(paramInt2);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\EmptyList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */