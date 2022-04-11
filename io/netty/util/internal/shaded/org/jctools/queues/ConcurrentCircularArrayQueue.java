package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class ConcurrentCircularArrayQueue<E>
  extends ConcurrentCircularArrayQueueL0Pad<E>
  implements MessagePassingQueue<E>, IndexedQueueSizeUtil.IndexedQueue, QueueProgressIndicators
{
  protected final E[] buffer;
  protected final long mask;
  
  ConcurrentCircularArrayQueue(int paramInt)
  {
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    this.mask = (paramInt - 1);
    this.buffer = UnsafeRefArrayAccess.allocateRefArray(paramInt);
  }
  
  public int capacity()
  {
    return (int)(this.mask + 1L);
  }
  
  public void clear()
  {
    while (poll() != null) {}
  }
  
  public long currentConsumerIndex()
  {
    return lvConsumerIndex();
  }
  
  public long currentProducerIndex()
  {
    return lvProducerIndex();
  }
  
  public boolean isEmpty()
  {
    return IndexedQueueSizeUtil.isEmpty(this);
  }
  
  public Iterator<E> iterator()
  {
    return new WeakIterator(lvConsumerIndex(), lvProducerIndex(), this.mask, this.buffer);
  }
  
  public int size()
  {
    return IndexedQueueSizeUtil.size(this);
  }
  
  public String toString()
  {
    return getClass().getName();
  }
  
  private static class WeakIterator<E>
    implements Iterator<E>
  {
    private final E[] buffer;
    private final long mask;
    private E nextElement;
    private long nextIndex;
    private final long pIndex;
    
    WeakIterator(long paramLong1, long paramLong2, long paramLong3, E[] paramArrayOfE)
    {
      this.nextIndex = paramLong1;
      this.pIndex = paramLong2;
      this.mask = paramLong3;
      this.buffer = paramArrayOfE;
      this.nextElement = getNext();
    }
    
    private E getNext()
    {
      Object localObject;
      do
      {
        long l = this.nextIndex;
        if (l >= this.pIndex) {
          break;
        }
        this.nextIndex = (1L + l);
        l = UnsafeRefArrayAccess.calcCircularRefElementOffset(l, this.mask);
        localObject = UnsafeRefArrayAccess.lvRefElement(this.buffer, l);
      } while (localObject == null);
      return (E)localObject;
      return null;
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.nextElement != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public E next()
    {
      Object localObject = this.nextElement;
      if (localObject != null)
      {
        this.nextElement = getNext();
        return (E)localObject;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("remove");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\ConcurrentCircularArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */