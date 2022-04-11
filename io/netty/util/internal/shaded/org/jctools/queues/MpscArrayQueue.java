package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;
import java.util.Objects;

public class MpscArrayQueue<E>
  extends MpscArrayQueueL3Pad<E>
{
  public MpscArrayQueue(int paramInt)
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
        Object[] arrayOfObject = this.buffer;
        long l1 = this.mask;
        long l2 = lpConsumerIndex();
        while (i < paramInt)
        {
          long l3 = i + l2;
          long l4 = UnsafeRefArrayAccess.calcCircularRefElementOffset(l3, l1);
          Object localObject = UnsafeRefArrayAccess.lvRefElement(arrayOfObject, l4);
          if (localObject == null) {
            return i;
          }
          UnsafeRefArrayAccess.soRefElement(arrayOfObject, l4, null);
          soConsumerIndex(l3 + 1L);
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
    long l1 = this.mask;
    long l2 = lvProducerIndex();
    if (l2 >= lvProducerLimit())
    {
      long l3 = lvConsumerIndex() + (l1 + 1L);
      if (l2 >= l3) {
        return 1;
      }
      soProducerLimit(l3);
    }
    if (!casProducerIndex(l2, 1L + l2)) {
      return -1;
    }
    l2 = UnsafeRefArrayAccess.calcCircularRefElementOffset(l2, l1);
    UnsafeRefArrayAccess.soRefElement(this.buffer, l2, paramE);
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
        long l1 = this.mask;
        long l2 = lvProducerLimit();
        long l3;
        int j;
        do
        {
          l3 = lvProducerIndex();
          long l4 = l2 - l3;
          long l5 = l4;
          if (l4 <= 0L)
          {
            l2 = lvConsumerIndex() + (1L + l1);
            l5 = l2 - l3;
            if (l5 <= 0L) {
              return 0;
            }
            soProducerLimit(l2);
          }
          j = Math.min((int)l5, paramInt);
        } while (!casProducerIndex(l3, j + l3));
        Object[] arrayOfObject = this.buffer;
        for (paramInt = i; paramInt < j; paramInt++) {
          UnsafeRefArrayAccess.soRefElement(arrayOfObject, UnsafeRefArrayAccess.calcCircularRefElementOffset(paramInt + l3, l1), paramSupplier.get());
        }
        return j;
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
    long l1 = this.mask;
    long l2 = lvProducerLimit();
    long l3;
    do
    {
      l3 = lvProducerIndex();
      l4 = l2;
      if (l3 >= l2)
      {
        l4 = lvConsumerIndex() + l1 + 1L;
        if (l3 >= l4) {
          return false;
        }
        soProducerLimit(l4);
      }
      l2 = l4;
    } while (!casProducerIndex(l3, 1L + l3));
    long l4 = UnsafeRefArrayAccess.calcCircularRefElementOffset(l3, l1);
    UnsafeRefArrayAccess.soRefElement(this.buffer, l4, paramE);
    return true;
  }
  
  public boolean offerIfBelowThreshold(E paramE, int paramInt)
  {
    Objects.requireNonNull(paramE);
    long l1 = this.mask;
    long l2 = l1 + 1L;
    long l6;
    for (long l3 = lvProducerLimit();; l3 = l6)
    {
      long l4 = lvProducerIndex();
      long l5 = paramInt;
      l6 = l3;
      if (l2 - (l3 - l4) >= l5)
      {
        l3 = lvConsumerIndex();
        if (l4 - l3 >= l5) {
          return false;
        }
        l6 = l3 + l2;
        soProducerLimit(l6);
      }
      if (casProducerIndex(l4, l4 + 1L))
      {
        l3 = UnsafeRefArrayAccess.calcCircularRefElementOffset(l4, l1);
        UnsafeRefArrayAccess.soRefElement(this.buffer, l3, paramE);
        return true;
      }
    }
  }
  
  public E peek()
  {
    Object[] arrayOfObject = this.buffer;
    long l1 = lpConsumerIndex();
    long l2 = UnsafeRefArrayAccess.calcCircularRefElementOffset(l1, this.mask);
    Object localObject1 = UnsafeRefArrayAccess.lvRefElement(arrayOfObject, l2);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (l1 != lvProducerIndex()) {
        do
        {
          localObject2 = UnsafeRefArrayAccess.lvRefElement(arrayOfObject, l2);
        } while (localObject2 == null);
      } else {
        return null;
      }
    }
    return (E)localObject2;
  }
  
  public E poll()
  {
    long l1 = lpConsumerIndex();
    long l2 = UnsafeRefArrayAccess.calcCircularRefElementOffset(l1, this.mask);
    Object[] arrayOfObject = this.buffer;
    Object localObject1 = UnsafeRefArrayAccess.lvRefElement(arrayOfObject, l2);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (l1 != lvProducerIndex()) {
        do
        {
          localObject2 = UnsafeRefArrayAccess.lvRefElement(arrayOfObject, l2);
        } while (localObject2 == null);
      } else {
        return null;
      }
    }
    UnsafeRefArrayAccess.soRefElement(arrayOfObject, l2, null);
    soConsumerIndex(l1 + 1L);
    return (E)localObject2;
  }
  
  public boolean relaxedOffer(E paramE)
  {
    return offer(paramE);
  }
  
  public E relaxedPeek()
  {
    Object[] arrayOfObject = this.buffer;
    long l = this.mask;
    return (E)UnsafeRefArrayAccess.lvRefElement(arrayOfObject, UnsafeRefArrayAccess.calcCircularRefElementOffset(lpConsumerIndex(), l));
  }
  
  public E relaxedPoll()
  {
    Object[] arrayOfObject = this.buffer;
    long l1 = lpConsumerIndex();
    long l2 = UnsafeRefArrayAccess.calcCircularRefElementOffset(l1, this.mask);
    Object localObject = UnsafeRefArrayAccess.lvRefElement(arrayOfObject, l2);
    if (localObject == null) {
      return null;
    }
    UnsafeRefArrayAccess.soRefElement(arrayOfObject, l2, null);
    soConsumerIndex(l1 + 1L);
    return (E)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\MpscArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */