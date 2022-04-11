package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.ExitCondition;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Supplier;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.WaitStrategy;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class MpscAtomicArrayQueue<E>
  extends MpscAtomicArrayQueueL3Pad<E>
{
  public MpscAtomicArrayQueue(int paramInt)
  {
    super(paramInt);
  }
  
  public int drain(MessagePassingQueue.Consumer<E> paramConsumer)
  {
    return drain(paramConsumer, capacity());
  }
  
  public int drain(MessagePassingQueue.Consumer<E> paramConsumer, int paramInt)
  {
    if (paramConsumer != null)
    {
      if (paramInt >= 0)
      {
        int i = 0;
        if (paramInt == 0) {
          return 0;
        }
        AtomicReferenceArray localAtomicReferenceArray = this.buffer;
        int j = this.mask;
        long l1 = lpConsumerIndex();
        while (i < paramInt)
        {
          long l2 = i + l1;
          int k = AtomicQueueUtil.calcCircularRefElementOffset(l2, j);
          Object localObject = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, k);
          if (localObject == null) {
            return i;
          }
          AtomicQueueUtil.soRefElement(localAtomicReferenceArray, k, null);
          soConsumerIndex(l2 + 1L);
          paramConsumer.accept(localObject);
          i++;
        }
        return paramInt;
      }
      paramConsumer = new StringBuilder();
      paramConsumer.append("limit is negative: ");
      paramConsumer.append(paramInt);
      throw new IllegalArgumentException(paramConsumer.toString());
    }
    throw new IllegalArgumentException("c is null");
  }
  
  public void drain(MessagePassingQueue.Consumer<E> paramConsumer, MessagePassingQueue.WaitStrategy paramWaitStrategy, MessagePassingQueue.ExitCondition paramExitCondition)
  {
    MessagePassingQueueUtil.drain(this, paramConsumer, paramWaitStrategy, paramExitCondition);
  }
  
  public final int failFastOffer(E paramE)
  {
    Objects.requireNonNull(paramE);
    int i = this.mask;
    long l1 = i + 1;
    long l2 = lvProducerIndex();
    if (l2 >= lvProducerLimit())
    {
      l1 = lvConsumerIndex() + l1;
      if (l2 >= l1) {
        return 1;
      }
      soProducerLimit(l1);
    }
    if (!casProducerIndex(l2, 1L + l2)) {
      return -1;
    }
    i = AtomicQueueUtil.calcCircularRefElementOffset(l2, i);
    AtomicQueueUtil.soRefElement(this.buffer, i, paramE);
    return 0;
  }
  
  public int fill(MessagePassingQueue.Supplier<E> paramSupplier)
  {
    return MessagePassingQueueUtil.fillBounded(this, paramSupplier);
  }
  
  public int fill(MessagePassingQueue.Supplier<E> paramSupplier, int paramInt)
  {
    if (paramSupplier != null)
    {
      if (paramInt >= 0)
      {
        int i = 0;
        if (paramInt == 0) {
          return 0;
        }
        int j = this.mask;
        long l1 = j + 1;
        long l2 = lvProducerLimit();
        long l3;
        int k;
        do
        {
          l3 = lvProducerIndex();
          long l4 = l2 - l3;
          long l5 = l4;
          if (l4 <= 0L)
          {
            l2 = lvConsumerIndex() + l1;
            l5 = l2 - l3;
            if (l5 <= 0L) {
              return 0;
            }
            soProducerLimit(l2);
          }
          k = Math.min((int)l5, paramInt);
        } while (!casProducerIndex(l3, k + l3));
        AtomicReferenceArray localAtomicReferenceArray = this.buffer;
        for (paramInt = i; paramInt < k; paramInt++) {
          AtomicQueueUtil.soRefElement(localAtomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(paramInt + l3, j), paramSupplier.get());
        }
        return k;
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
  
  public boolean offer(E paramE)
  {
    Objects.requireNonNull(paramE);
    int i = this.mask;
    long l1 = lvProducerLimit();
    long l2;
    do
    {
      l2 = lvProducerIndex();
      long l3 = l1;
      if (l2 >= l1)
      {
        l3 = lvConsumerIndex() + i + 1L;
        if (l2 >= l3) {
          return false;
        }
        soProducerLimit(l3);
      }
      l1 = l3;
    } while (!casProducerIndex(l2, 1L + l2));
    i = AtomicQueueUtil.calcCircularRefElementOffset(l2, i);
    AtomicQueueUtil.soRefElement(this.buffer, i, paramE);
    return true;
  }
  
  public boolean offerIfBelowThreshold(E paramE, int paramInt)
  {
    Objects.requireNonNull(paramE);
    int i = this.mask;
    long l1 = i + 1;
    long l2 = lvProducerLimit();
    long l3;
    do
    {
      l3 = lvProducerIndex();
      long l4 = paramInt;
      long l5 = l2;
      if (l1 - (l2 - l3) >= l4)
      {
        l5 = lvConsumerIndex();
        if (l3 - l5 >= l4) {
          return false;
        }
        l5 += l1;
        soProducerLimit(l5);
      }
      l2 = l5;
    } while (!casProducerIndex(l3, 1L + l3));
    paramInt = AtomicQueueUtil.calcCircularRefElementOffset(l3, i);
    AtomicQueueUtil.soRefElement(this.buffer, paramInt, paramE);
    return true;
  }
  
  public E peek()
  {
    AtomicReferenceArray localAtomicReferenceArray = this.buffer;
    long l = lpConsumerIndex();
    int i = AtomicQueueUtil.calcCircularRefElementOffset(l, this.mask);
    Object localObject1 = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, i);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (l != lvProducerIndex()) {
        do
        {
          localObject2 = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, i);
        } while (localObject2 == null);
      } else {
        return null;
      }
    }
    return (E)localObject2;
  }
  
  public E poll()
  {
    long l = lpConsumerIndex();
    int i = AtomicQueueUtil.calcCircularRefElementOffset(l, this.mask);
    AtomicReferenceArray localAtomicReferenceArray = this.buffer;
    Object localObject1 = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, i);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (l != lvProducerIndex()) {
        do
        {
          localObject2 = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, i);
        } while (localObject2 == null);
      } else {
        return null;
      }
    }
    AtomicQueueUtil.soRefElement(localAtomicReferenceArray, i, null);
    soConsumerIndex(l + 1L);
    return (E)localObject2;
  }
  
  public boolean relaxedOffer(E paramE)
  {
    return offer(paramE);
  }
  
  public E relaxedPeek()
  {
    AtomicReferenceArray localAtomicReferenceArray = this.buffer;
    int i = this.mask;
    return (E)AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex(), i));
  }
  
  public E relaxedPoll()
  {
    AtomicReferenceArray localAtomicReferenceArray = this.buffer;
    long l = lpConsumerIndex();
    int i = AtomicQueueUtil.calcCircularRefElementOffset(l, this.mask);
    Object localObject = AtomicQueueUtil.lvRefElement(localAtomicReferenceArray, i);
    if (localObject == null) {
      return null;
    }
    AtomicQueueUtil.soRefElement(localAtomicReferenceArray, i, null);
    soConsumerIndex(l + 1L);
    return (E)localObject;
  }
  
  @Deprecated
  public int weakOffer(E paramE)
  {
    return failFastOffer(paramE);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\MpscAtomicArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */