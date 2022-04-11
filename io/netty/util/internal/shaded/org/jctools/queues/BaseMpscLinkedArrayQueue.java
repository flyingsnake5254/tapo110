package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

abstract class BaseMpscLinkedArrayQueue<E>
  extends BaseMpscLinkedArrayQueueColdProducerFields<E>
  implements MessagePassingQueue<E>, QueueProgressIndicators
{
  private static final Object BUFFER_CONSUMED = new Object();
  private static final int CONTINUE_TO_P_INDEX_CAS = 0;
  private static final Object JUMP = new Object();
  private static final int QUEUE_FULL = 2;
  private static final int QUEUE_RESIZE = 3;
  private static final int RETRY = 1;
  
  public BaseMpscLinkedArrayQueue(int paramInt)
  {
    RangeUtil.checkGreaterThanOrEqual(paramInt, 2, "initialCapacity");
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    long l = paramInt - 1 << 1;
    Object[] arrayOfObject = UnsafeRefArrayAccess.allocateRefArray(paramInt + 1);
    this.producerBuffer = arrayOfObject;
    this.producerMask = l;
    this.consumerBuffer = arrayOfObject;
    this.consumerMask = l;
    soProducerLimit(l);
  }
  
  private E newBufferPeek(E[] paramArrayOfE, long paramLong)
  {
    paramArrayOfE = UnsafeRefArrayAccess.lvRefElement(paramArrayOfE, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(paramLong, this.consumerMask));
    if (paramArrayOfE != null) {
      return paramArrayOfE;
    }
    throw new IllegalStateException("new buffer must have at least one element");
  }
  
  private E newBufferPoll(E[] paramArrayOfE, long paramLong)
  {
    long l = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(paramLong, this.consumerMask);
    Object localObject = UnsafeRefArrayAccess.lvRefElement(paramArrayOfE, l);
    if (localObject != null)
    {
      UnsafeRefArrayAccess.soRefElement(paramArrayOfE, l, null);
      soConsumerIndex(paramLong + 2L);
      return (E)localObject;
    }
    throw new IllegalStateException("new buffer must have at least one element");
  }
  
  private static long nextArrayOffset(long paramLong)
  {
    return LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(paramLong + 2L, Long.MAX_VALUE);
  }
  
  private E[] nextBuffer(E[] paramArrayOfE, long paramLong)
  {
    paramLong = nextArrayOffset(paramLong);
    Object[] arrayOfObject = (Object[])UnsafeRefArrayAccess.lvRefElement(paramArrayOfE, paramLong);
    this.consumerBuffer = arrayOfObject;
    this.consumerMask = (LinkedArrayQueueUtil.length(arrayOfObject) - 2 << 1);
    UnsafeRefArrayAccess.soRefElement(paramArrayOfE, paramLong, BUFFER_CONSUMED);
    return arrayOfObject;
  }
  
  private int offerSlowPath(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = lvConsumerIndex();
    paramLong1 = getCurrentBufferCapacity(paramLong1) + l;
    if (paramLong1 > paramLong2)
    {
      if (!casProducerLimit(paramLong3, paramLong1)) {
        return 1;
      }
      return 0;
    }
    if (availableInQueue(paramLong2, l) <= 0L) {
      return 2;
    }
    if (casProducerIndex(paramLong2, 1L + paramLong2)) {
      return 3;
    }
    return 1;
  }
  
  private void resize(long paramLong1, E[] paramArrayOfE, long paramLong2, E paramE, MessagePassingQueue.Supplier<E> paramSupplier)
  {
    int i = getNextBufferSize(paramArrayOfE);
    try
    {
      Object[] arrayOfObject = UnsafeRefArrayAccess.allocateRefArray(i);
      this.producerBuffer = arrayOfObject;
      long l1 = i - 2 << 1;
      this.producerMask = l1;
      long l2 = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(paramLong2, paramLong1);
      long l3 = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(paramLong2, l1);
      Object localObject = paramE;
      if (paramE == null) {
        localObject = paramSupplier.get();
      }
      UnsafeRefArrayAccess.soRefElement(arrayOfObject, l3, localObject);
      UnsafeRefArrayAccess.soRefElement(paramArrayOfE, nextArrayOffset(paramLong1), arrayOfObject);
      paramLong1 = availableInQueue(paramLong2, lvConsumerIndex());
      RangeUtil.checkPositive(paramLong1, "availableInQueue");
      soProducerLimit(Math.min(l1, paramLong1) + paramLong2);
      soProducerIndex(paramLong2 + 2L);
      UnsafeRefArrayAccess.soRefElement(paramArrayOfE, l2, JUMP);
      return;
    }
    catch (OutOfMemoryError paramArrayOfE)
    {
      soProducerIndex(paramLong2);
      throw paramArrayOfE;
    }
  }
  
  protected abstract long availableInQueue(long paramLong1, long paramLong2);
  
  public abstract int capacity();
  
  public long currentConsumerIndex()
  {
    return lvConsumerIndex() / 2L;
  }
  
  public long currentProducerIndex()
  {
    return lvProducerIndex() / 2L;
  }
  
  public int drain(MessagePassingQueue.Consumer<E> paramConsumer)
  {
    return drain(paramConsumer, capacity());
  }
  
  public int drain(MessagePassingQueue.Consumer<E> paramConsumer, int paramInt)
  {
    return MessagePassingQueueUtil.drain(this, paramConsumer, paramInt);
  }
  
  public void drain(MessagePassingQueue.Consumer<E> paramConsumer, MessagePassingQueue.WaitStrategy paramWaitStrategy, MessagePassingQueue.ExitCondition paramExitCondition)
  {
    MessagePassingQueueUtil.drain(this, paramConsumer, paramWaitStrategy, paramExitCondition);
  }
  
  public int fill(MessagePassingQueue.Supplier<E> paramSupplier)
  {
    int i = capacity();
    long l1 = 0L;
    long l2;
    do
    {
      int j = fill(paramSupplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH);
      if (j == 0) {
        return (int)l1;
      }
      l2 = l1 + j;
      l1 = l2;
    } while (l2 <= i);
    return (int)l2;
  }
  
  public int fill(MessagePassingQueue.Supplier<E> paramSupplier, int paramInt)
  {
    BaseMpscLinkedArrayQueue localBaseMpscLinkedArrayQueue = this;
    int i = paramInt;
    if (paramSupplier != null)
    {
      if (i >= 0)
      {
        int j = 0;
        if (i == 0) {
          return 0;
        }
        for (;;)
        {
          long l1 = lvProducerLimit();
          long l2 = lvProducerIndex();
          if ((l2 & 1L) != 1L)
          {
            long l3 = localBaseMpscLinkedArrayQueue.producerMask;
            Object[] arrayOfObject = localBaseMpscLinkedArrayQueue.producerBuffer;
            long l4 = Math.min(l1, paramInt * 2L + l2);
            if (l2 >= l1)
            {
              i = offerSlowPath(l3, l2, l1);
              if ((i != 0) && (i != 1))
              {
                if (i != 2)
                {
                  if (i == 3)
                  {
                    resize(l3, arrayOfObject, l2, null, paramSupplier);
                    return 1;
                  }
                }
                else {
                  return 0;
                }
              }
              else
              {
                localBaseMpscLinkedArrayQueue = this;
                continue;
              }
            }
            localBaseMpscLinkedArrayQueue = this;
            if (localBaseMpscLinkedArrayQueue.casProducerIndex(l2, l4))
            {
              i = (int)((l4 - l2) / 2L);
              for (paramInt = j; paramInt < i; paramInt++) {
                UnsafeRefArrayAccess.soRefElement(arrayOfObject, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(paramInt * 2L + l2, l3), paramSupplier.get());
              }
              return i;
            }
          }
        }
      }
      paramSupplier = new StringBuilder();
      paramSupplier.append("limit is negative:");
      paramSupplier.append(paramInt);
      throw new IllegalArgumentException(paramSupplier.toString());
    }
    throw new IllegalArgumentException("supplier is null");
  }
  
  public void fill(MessagePassingQueue.Supplier<E> paramSupplier, MessagePassingQueue.WaitStrategy paramWaitStrategy, MessagePassingQueue.ExitCondition paramExitCondition)
  {
    MessagePassingQueueUtil.fill(this, paramSupplier, paramWaitStrategy, paramExitCondition);
  }
  
  protected abstract long getCurrentBufferCapacity(long paramLong);
  
  protected abstract int getNextBufferSize(E[] paramArrayOfE);
  
  public boolean isEmpty()
  {
    boolean bool;
    if (lvConsumerIndex() == lvProducerIndex()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<E> iterator()
  {
    return new WeakIterator(this.consumerBuffer, lvConsumerIndex(), lvProducerIndex());
  }
  
  public boolean offer(E paramE)
  {
    Objects.requireNonNull(paramE);
    for (;;)
    {
      long l1 = lvProducerLimit();
      long l2 = lvProducerIndex();
      if ((l2 & 1L) != 1L)
      {
        long l3 = this.producerMask;
        Object[] arrayOfObject = this.producerBuffer;
        if (l1 <= l2)
        {
          int i = offerSlowPath(l3, l2, l1);
          if (i == 1) {
            continue;
          }
          if (i != 2)
          {
            if (i == 3)
            {
              resize(l3, arrayOfObject, l2, paramE, null);
              return true;
            }
          }
          else {
            return false;
          }
        }
        if (casProducerIndex(l2, 2L + l2))
        {
          UnsafeRefArrayAccess.soRefElement(arrayOfObject, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(l2, l3), paramE);
          return true;
        }
      }
    }
  }
  
  public E peek()
  {
    Object[] arrayOfObject = this.consumerBuffer;
    long l1 = lpConsumerIndex();
    long l2 = this.consumerMask;
    long l3 = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(l1, l2);
    Object localObject1 = UnsafeRefArrayAccess.lvRefElement(arrayOfObject, l3);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (l1 != lvProducerIndex()) {
        do
        {
          localObject2 = UnsafeRefArrayAccess.lvRefElement(arrayOfObject, l3);
        } while (localObject2 == null);
      }
    }
    if (localObject2 == JUMP) {
      return (E)newBufferPeek(nextBuffer(arrayOfObject, l2), l1);
    }
    return (E)localObject2;
  }
  
  public E poll()
  {
    Object[] arrayOfObject = this.consumerBuffer;
    long l1 = lpConsumerIndex();
    long l2 = this.consumerMask;
    long l3 = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(l1, l2);
    Object localObject1 = UnsafeRefArrayAccess.lvRefElement(arrayOfObject, l3);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (l1 != lvProducerIndex()) {
        do
        {
          localObject2 = UnsafeRefArrayAccess.lvRefElement(arrayOfObject, l3);
        } while (localObject2 == null);
      } else {
        return null;
      }
    }
    if (localObject2 == JUMP) {
      return (E)newBufferPoll(nextBuffer(arrayOfObject, l2), l1);
    }
    UnsafeRefArrayAccess.soRefElement(arrayOfObject, l3, null);
    soConsumerIndex(l1 + 2L);
    return (E)localObject2;
  }
  
  public boolean relaxedOffer(E paramE)
  {
    return offer(paramE);
  }
  
  public E relaxedPeek()
  {
    Object[] arrayOfObject = this.consumerBuffer;
    long l1 = lpConsumerIndex();
    long l2 = this.consumerMask;
    Object localObject = UnsafeRefArrayAccess.lvRefElement(arrayOfObject, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(l1, l2));
    if (localObject == JUMP) {
      return (E)newBufferPeek(nextBuffer(arrayOfObject, l2), l1);
    }
    return (E)localObject;
  }
  
  public E relaxedPoll()
  {
    Object[] arrayOfObject = this.consumerBuffer;
    long l1 = lpConsumerIndex();
    long l2 = this.consumerMask;
    long l3 = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(l1, l2);
    Object localObject = UnsafeRefArrayAccess.lvRefElement(arrayOfObject, l3);
    if (localObject == null) {
      return null;
    }
    if (localObject == JUMP) {
      return (E)newBufferPoll(nextBuffer(arrayOfObject, l2), l1);
    }
    UnsafeRefArrayAccess.soRefElement(arrayOfObject, l3, null);
    soConsumerIndex(l1 + 2L);
    return (E)localObject;
  }
  
  public int size()
  {
    long l3;
    for (long l1 = lvConsumerIndex();; l1 = l3)
    {
      long l2 = lvProducerIndex();
      l3 = lvConsumerIndex();
      if (l1 == l3)
      {
        l1 = l2 - l3 >> 1;
        if (l1 > 2147483647L) {
          return Integer.MAX_VALUE;
        }
        return (int)l1;
      }
    }
  }
  
  public String toString()
  {
    return getClass().getName();
  }
  
  private static class WeakIterator<E>
    implements Iterator<E>
  {
    private E[] currentBuffer;
    private int mask;
    private E nextElement;
    private long nextIndex;
    private final long pIndex;
    
    WeakIterator(E[] paramArrayOfE, long paramLong1, long paramLong2)
    {
      this.pIndex = (paramLong2 >> 1);
      this.nextIndex = (paramLong1 >> 1);
      setBuffer(paramArrayOfE);
      this.nextElement = getNext();
    }
    
    private E getNext()
    {
      Object localObject;
      do
      {
        long l;
        do
        {
          l = this.nextIndex;
          if (l >= this.pIndex) {
            break;
          }
          this.nextIndex = (1L + l);
          localObject = UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(l, this.mask));
        } while (localObject == null);
        if (localObject != BaseMpscLinkedArrayQueue.JUMP) {
          return (E)localObject;
        }
        int i = this.mask;
        localObject = UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcRefElementOffset(i + 1));
        if ((localObject == BaseMpscLinkedArrayQueue.BUFFER_CONSUMED) || (localObject == null)) {
          break;
        }
        setBuffer((Object[])localObject);
        localObject = UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(l, this.mask));
      } while (localObject == null);
      return (E)localObject;
      return null;
    }
    
    private void setBuffer(E[] paramArrayOfE)
    {
      this.currentBuffer = paramArrayOfE;
      this.mask = (LinkedArrayQueueUtil.length(paramArrayOfE) - 2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\BaseMpscLinkedArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */