package io.netty.util.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public final class EmptyPriorityQueue<T>
  implements PriorityQueue<T>
{
  private static final PriorityQueue<Object> INSTANCE = new EmptyPriorityQueue();
  
  public static <V> EmptyPriorityQueue<V> instance()
  {
    return (EmptyPriorityQueue)INSTANCE;
  }
  
  public boolean add(T paramT)
  {
    return false;
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    return false;
  }
  
  public void clear() {}
  
  public void clearIgnoringIndexes() {}
  
  public boolean contains(Object paramObject)
  {
    return false;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return false;
  }
  
  public boolean containsTyped(T paramT)
  {
    return false;
  }
  
  public T element()
  {
    throw new NoSuchElementException();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof PriorityQueue)) && (((PriorityQueue)paramObject).isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Iterator<T> iterator()
  {
    return Collections.emptyList().iterator();
  }
  
  public boolean offer(T paramT)
  {
    return false;
  }
  
  public T peek()
  {
    return null;
  }
  
  public T poll()
  {
    return null;
  }
  
  public void priorityChanged(T paramT) {}
  
  public T remove()
  {
    throw new NoSuchElementException();
  }
  
  public boolean remove(Object paramObject)
  {
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return false;
  }
  
  public boolean removeTyped(T paramT)
  {
    return false;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return false;
  }
  
  public int size()
  {
    return 0;
  }
  
  public Object[] toArray()
  {
    return EmptyArrays.EMPTY_OBJECTS;
  }
  
  public <T1> T1[] toArray(T1[] paramArrayOfT1)
  {
    if (paramArrayOfT1.length > 0) {
      paramArrayOfT1[0] = null;
    }
    return paramArrayOfT1;
  }
  
  public String toString()
  {
    return EmptyPriorityQueue.class.getSimpleName();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\EmptyPriorityQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */