package io.netty.handler.codec.http2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

final class MaxCapacityQueue<E>
  implements Queue<E>
{
  private final int maxCapacity;
  private final Queue<E> queue;
  
  MaxCapacityQueue(Queue<E> paramQueue, int paramInt)
  {
    this.queue = paramQueue;
    this.maxCapacity = paramInt;
  }
  
  public boolean add(E paramE)
  {
    if (offer(paramE)) {
      return true;
    }
    throw new IllegalStateException();
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    if (this.maxCapacity >= size() + paramCollection.size()) {
      return this.queue.addAll(paramCollection);
    }
    throw new IllegalStateException();
  }
  
  public void clear()
  {
    this.queue.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.queue.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.queue.containsAll(paramCollection);
  }
  
  public E element()
  {
    return (E)this.queue.element();
  }
  
  public boolean isEmpty()
  {
    return this.queue.isEmpty();
  }
  
  public Iterator<E> iterator()
  {
    return this.queue.iterator();
  }
  
  public boolean offer(E paramE)
  {
    if (this.maxCapacity <= this.queue.size()) {
      return false;
    }
    return this.queue.offer(paramE);
  }
  
  public E peek()
  {
    return (E)this.queue.peek();
  }
  
  public E poll()
  {
    return (E)this.queue.poll();
  }
  
  public E remove()
  {
    return (E)this.queue.remove();
  }
  
  public boolean remove(Object paramObject)
  {
    return this.queue.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.queue.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.queue.retainAll(paramCollection);
  }
  
  public int size()
  {
    return this.queue.size();
  }
  
  public Object[] toArray()
  {
    return this.queue.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.queue.toArray(paramArrayOfT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\MaxCapacityQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */