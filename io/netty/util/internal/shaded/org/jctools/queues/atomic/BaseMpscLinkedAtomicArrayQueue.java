package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.ExitCondition;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Supplier;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.WaitStrategy;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class BaseMpscLinkedAtomicArrayQueue<E>
  extends BaseMpscLinkedAtomicArrayQueueColdProducerFields<E>
  implements MessagePassingQueue<E>, QueueProgressIndicators
{
  private static final Object BUFFER_CONSUMED = new Object();
  private static final int CONTINUE_TO_P_INDEX_CAS = 0;
  private static final Object JUMP = new Object();
  private static final int QUEUE_FULL = 2;
  private static final int QUEUE_RESIZE = 3;
  private static final int RETRY = 1;
  
  public BaseMpscLinkedAtomicArrayQueue(int paramInt)
  {
    RangeUtil.checkGreaterThanOrEqual(paramInt, 2, "initialCapacity");
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    long l = paramInt - 1 << 1;
    AtomicReferenceArray localAtomicReferenceArray = AtomicQueueUtil.allocateRefArray(paramInt + 1);
    this.producerBuffer = localAtomicReferenceArray;
    this.producerMask = l;
    this.consumerBuffer = localAtomicReferenceArray;
    this.consumerMask = l;
    soProducerLimit(l);
  }
  
  private E newBufferPeek(AtomicReferenceArray<E> paramAtomicReferenceArray, long paramLong)
  {
    paramAtomicReferenceArray = AtomicQueueUtil.lvRefElement(paramAtomicReferenceArray, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(paramLong, this.consumerMask));
    if (paramAtomicReferenceArray != null) {
      return paramAtomicReferenceArray;
    }
    throw new IllegalStateException("new buffer must have at least one element");
  }
  
  private E newBufferPoll(AtomicReferenceArray<E> paramAtomicReferenceArray, long paramLong)
  {
    int i = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(paramLong, this.consumerMask);
    Object localObject = AtomicQueueUtil.lvRefElement(paramAtomicReferenceArray, i);
    if (localObject != null)
    {
      AtomicQueueUtil.soRefElement(paramAtomicReferenceArray, i, null);
      soConsumerIndex(paramLong + 2L);
      return (E)localObject;
    }
    throw new IllegalStateException("new buffer must have at least one element");
  }
  
  private static int nextArrayOffset(long paramLong)
  {
    return AtomicQueueUtil.modifiedCalcCircularRefElementOffset(paramLong + 2L, Long.MAX_VALUE);
  }
  
  private AtomicReferenceArray<E> nextBuffer(AtomicReferenceArray<E> paramAtomicReferenceArray, long paramLong)
  {
    int i = nextArrayOffset(paramLong);
    AtomicReferenceArray localAtomicReferenceArray = (AtomicReferenceArray)AtomicQueueUtil.lvRefElement(paramAtomicReferenceArray, i);
    this.consumerBuffer = localAtomicReferenceArray;
    this.consumerMask = (AtomicQueueUtil.length(localAtomicReferenceArray) - 2 << 1);
    AtomicQueueUtil.soRefElement(paramAtomicReferenceArray, i, BUFFER_CONSUMED);
    return localAtomicReferenceArray;
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
  
  private void resize(long paramLong1, AtomicReferenceArray<E> paramAtomicReferenceArray, long paramLong2, E paramE, MessagePassingQueue.Supplier<E> paramSupplier)
  {
    int i = getNextBufferSize(paramAtomicReferenceArray);
    try
    {
      AtomicReferenceArray localAtomicReferenceArray = AtomicQueueUtil.allocateRefArray(i);
      this.producerBuffer = localAtomicReferenceArray;
      long l = i - 2 << 1;
      this.producerMask = l;
      int j = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(paramLong2, paramLong1);
      i = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(paramLong2, l);
      Object localObject = paramE;
      if (paramE == null) {
        localObject = paramSupplier.get();
      }
      AtomicQueueUtil.soRefElement(localAtomicReferenceArray, i, localObject);
      AtomicQueueUtil.soRefElement(paramAtomicReferenceArray, nextArrayOffset(paramLong1), localAtomicReferenceArray);
      paramLong1 = availableInQueue(paramLong2, lvConsumerIndex());
      RangeUtil.checkPositive(paramLong1, "availableInQueue");
      soProducerLimit(Math.min(l, paramLong1) + paramLong2);
      soProducerIndex(paramLong2 + 2L);
      AtomicQueueUtil.soRefElement(paramAtomicReferenceArray, j, JUMP);
      return;
    }
    catch (OutOfMemoryError paramAtomicReferenceArray)
    {
      soProducerIndex(paramLong2);
      throw paramAtomicReferenceArray;
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
    BaseMpscLinkedAtomicArrayQueue localBaseMpscLinkedAtomicArrayQueue = this;
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
            long l3 = localBaseMpscLinkedAtomicArrayQueue.producerMask;
            AtomicReferenceArray localAtomicReferenceArray = localBaseMpscLinkedAtomicArrayQueue.producerBuffer;
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
                    resize(l3, localAtomicReferenceArray, l2, null, paramSupplier);
                    return 1;
                  }
                }
                else {
                  return 0;
                }
              }
              else
              {
                localBaseMpscLinkedAtomicArrayQueue = this;
                continue;
              }
            }
            localBaseMpscLinkedAtomicArrayQueue = this;
            if (localBaseMpscLinkedAtomicArrayQueue.casProducerIndex(l2, l4))
            {
              i = (int)((l4 - l2) / 2L);
              for (paramInt = j; paramInt < i; paramInt++) {
                AtomicQueueUtil.soRefElement(localAtomicReferenceArray, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(paramInt * 2L + l2, l3), paramSupplier.get());
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
  
  protected abstract int getNextBufferSize(AtomicReferenceArray<E> paramAtomicReferenceArray);
  
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
        AtomicReferenceArray localAtomicReferenceArray = this.producerBuffer;
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
              resize(l3, localAtomicReferenceArray, l2, paramE, null);
              return true;
            }
          }
          else {
            return false;
          }
        }
        if (casProducerIndex(l2, 2L + l2))
        {
          AtomicQueueUtil.soRefElement(localAtomicReferenceArray, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(l2, l3), paramE);
          return true;
        }
      }
    }
  }
  
  public E peek()
  {
    AtomicReferenceArray localAtomicReferenceArray = this.consumerBuffer;
    long l1 = lpConsumerIndex();
    long l2 = this.consumerMask;
    int i = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(l1, l2);
    Object localObject1 = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, i);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (l1 != lvProducerIndex()) {
        do
        {
          localObject2 = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, i);
        } while (localObject2 == null);
      }
    }
    if (localObject2 == JUMP) {
      return (E)newBufferPeek(nextBuffer(localAtomicReferenceArray, l2), l1);
    }
    return (E)localObject2;
  }
  
  public E poll()
  {
    AtomicReferenceArray localAtomicReferenceArray = this.consumerBuffer;
    long l1 = lpConsumerIndex();
    long l2 = this.consumerMask;
    int i = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(l1, l2);
    Object localObject1 = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, i);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (l1 != lvProducerIndex()) {
        do
        {
          localObject2 = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, i);
        } while (localObject2 == null);
      } else {
        return null;
      }
    }
    if (localObject2 == JUMP) {
      return (E)newBufferPoll(nextBuffer(localAtomicReferenceArray, l2), l1);
    }
    AtomicQueueUtil.soRefElement(localAtomicReferenceArray, i, null);
    soConsumerIndex(l1 + 2L);
    return (E)localObject2;
  }
  
  public boolean relaxedOffer(E paramE)
  {
    return offer(paramE);
  }
  
  public E relaxedPeek()
  {
    AtomicReferenceArray localAtomicReferenceArray = this.consumerBuffer;
    long l1 = lpConsumerIndex();
    long l2 = this.consumerMask;
    Object localObject = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(l1, l2));
    if (localObject == JUMP) {
      return (E)newBufferPeek(nextBuffer(localAtomicReferenceArray, l2), l1);
    }
    return (E)localObject;
  }
  
  public E relaxedPoll()
  {
    AtomicReferenceArray localAtomicReferenceArray = this.consumerBuffer;
    long l1 = lpConsumerIndex();
    long l2 = this.consumerMask;
    int i = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(l1, l2);
    Object localObject = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, i);
    if (localObject == null) {
      return null;
    }
    if (localObject == JUMP) {
      return (E)newBufferPoll(nextBuffer(localAtomicReferenceArray, l2), l1);
    }
    AtomicQueueUtil.soRefElement(localAtomicReferenceArray, i, null);
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
    private AtomicReferenceArray<E> currentBuffer;
    private int mask;
    private E nextElement;
    private long nextIndex;
    private final long pIndex;
    
    WeakIterator(AtomicReferenceArray<E> paramAtomicReferenceArray, long paramLong1, long paramLong2)
    {
      this.pIndex = (paramLong2 >> 1);
      this.nextIndex = (paramLong1 >> 1);
      setBuffer(paramAtomicReferenceArray);
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
          localObject = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(l, this.mask));
        } while (localObject == null);
        if (localObject != BaseMpscLinkedAtomicArrayQueue.JUMP) {
          return (E)localObject;
        }
        int i = this.mask;
        localObject = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcRefElementOffset(i + 1));
        if ((localObject == BaseMpscLinkedAtomicArrayQueue.BUFFER_CONSUMED) || (localObject == null)) {
          break;
        }
        setBuffer((AtomicReferenceArray)localObject);
        localObject = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(l, this.mask));
      } while (localObject == null);
      return (E)localObject;
      return null;
    }
    
    private void setBuffer(AtomicReferenceArray<E> paramAtomicReferenceArray)
    {
      this.currentBuffer = paramAtomicReferenceArray;
      this.mask = (AtomicQueueUtil.length(paramAtomicReferenceArray) - 2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\BaseMpscLinkedAtomicArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */