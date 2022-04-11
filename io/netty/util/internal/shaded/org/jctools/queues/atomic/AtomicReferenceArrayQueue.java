package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil;
import io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class AtomicReferenceArrayQueue<E>
  extends AbstractQueue<E>
  implements IndexedQueueSizeUtil.IndexedQueue, QueueProgressIndicators, MessagePassingQueue<E>
{
  protected final AtomicReferenceArray<E> buffer;
  protected final int mask;
  
  public AtomicReferenceArrayQueue(int paramInt)
  {
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    this.mask = (paramInt - 1);
    this.buffer = new AtomicReferenceArray(paramInt);
  }
  
  public final int capacity()
  {
    return this.mask + 1;
  }
  
  public void clear()
  {
    while (poll() != null) {}
  }
  
  public final long currentConsumerIndex()
  {
    return lvConsumerIndex();
  }
  
  public final long currentProducerIndex()
  {
    return lvProducerIndex();
  }
  
  public final boolean isEmpty()
  {
    return IndexedQueueSizeUtil.isEmpty(this);
  }
  
  public final Iterator<E> iterator()
  {
    return new WeakIterator(lvConsumerIndex(), lvProducerIndex(), this.mask, this.buffer);
  }
  
  public final int size()
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
    private final AtomicReferenceArray<E> buffer;
    private final int mask;
    private E nextElement;
    private long nextIndex;
    private final long pIndex;
    
    WeakIterator(long paramLong1, long paramLong2, int paramInt, AtomicReferenceArray<E> paramAtomicReferenceArray)
    {
      this.nextIndex = paramLong1;
      this.pIndex = paramLong2;
      this.mask = paramInt;
      this.buffer = paramAtomicReferenceArray;
      this.nextElement = getNext();
    }
    
    private E getNext()
    {
      int i = this.mask;
      AtomicReferenceArray localAtomicReferenceArray = this.buffer;
      Object localObject;
      do
      {
        long l = this.nextIndex;
        if (l >= this.pIndex) {
          break;
        }
        this.nextIndex = (1L + l);
        localObject = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(l, i));
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\AtomicReferenceArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */