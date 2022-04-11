package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;

public final class MessagePassingQueueUtil
{
  public static <E> int drain(MessagePassingQueue<E> paramMessagePassingQueue, MessagePassingQueue.Consumer<E> paramConsumer)
  {
    if (paramConsumer != null)
    {
      int i = 0;
      for (;;)
      {
        Object localObject = paramMessagePassingQueue.relaxedPoll();
        if (localObject == null) {
          break;
        }
        i++;
        paramConsumer.accept(localObject);
      }
      return i;
    }
    throw new IllegalArgumentException("c is null");
  }
  
  public static <E> int drain(MessagePassingQueue<E> paramMessagePassingQueue, MessagePassingQueue.Consumer<E> paramConsumer, int paramInt)
  {
    if (paramConsumer != null)
    {
      if (paramInt >= 0)
      {
        int i = 0;
        if (paramInt == 0) {
          return 0;
        }
        while (i < paramInt)
        {
          Object localObject = paramMessagePassingQueue.relaxedPoll();
          if (localObject == null) {
            break;
          }
          paramConsumer.accept(localObject);
          i++;
        }
        return i;
      }
      paramMessagePassingQueue = new StringBuilder();
      paramMessagePassingQueue.append("limit is negative: ");
      paramMessagePassingQueue.append(paramInt);
      throw new IllegalArgumentException(paramMessagePassingQueue.toString());
    }
    throw new IllegalArgumentException("c is null");
  }
  
  public static <E> void drain(MessagePassingQueue<E> paramMessagePassingQueue, MessagePassingQueue.Consumer<E> paramConsumer, MessagePassingQueue.WaitStrategy paramWaitStrategy, MessagePassingQueue.ExitCondition paramExitCondition)
  {
    if (paramConsumer != null)
    {
      if (paramWaitStrategy != null)
      {
        if (paramExitCondition != null)
        {
          for (;;)
          {
            Object localObject;
            for (int i = 0;; i = paramWaitStrategy.idle(i))
            {
              if (!paramExitCondition.keepRunning()) {
                break label61;
              }
              localObject = paramMessagePassingQueue.relaxedPoll();
              if (localObject != null) {
                break;
              }
            }
            paramConsumer.accept(localObject);
          }
          label61:
          return;
        }
        throw new IllegalArgumentException("exit condition is null");
      }
      throw new IllegalArgumentException("wait is null");
    }
    throw new IllegalArgumentException("c is null");
  }
  
  public static <E> void fill(MessagePassingQueue<E> paramMessagePassingQueue, MessagePassingQueue.Supplier<E> paramSupplier, MessagePassingQueue.WaitStrategy paramWaitStrategy, MessagePassingQueue.ExitCondition paramExitCondition)
  {
    if (paramWaitStrategy != null)
    {
      if (paramExitCondition != null)
      {
        for (int i = 0;; i = paramWaitStrategy.idle(i))
        {
          if (!paramExitCondition.keepRunning()) {
            break label46;
          }
          if (paramMessagePassingQueue.fill(paramSupplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) != 0) {
            break;
          }
        }
        label46:
        return;
      }
      throw new IllegalArgumentException("exit condition is null");
    }
    throw new IllegalArgumentException("waiter is null");
  }
  
  public static <E> int fillBounded(MessagePassingQueue<E> paramMessagePassingQueue, MessagePassingQueue.Supplier<E> paramSupplier)
  {
    return fillInBatchesToLimit(paramMessagePassingQueue, paramSupplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH, paramMessagePassingQueue.capacity());
  }
  
  public static <E> int fillInBatchesToLimit(MessagePassingQueue<E> paramMessagePassingQueue, MessagePassingQueue.Supplier<E> paramSupplier, int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    long l2;
    do
    {
      int i = paramMessagePassingQueue.fill(paramSupplier, paramInt1);
      if (i == 0) {
        return (int)l1;
      }
      l2 = l1 + i;
      l1 = l2;
    } while (l2 <= paramInt2);
    return (int)l2;
  }
  
  public static <E> int fillUnbounded(MessagePassingQueue<E> paramMessagePassingQueue, MessagePassingQueue.Supplier<E> paramSupplier)
  {
    return fillInBatchesToLimit(paramMessagePassingQueue, paramSupplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH, 4096);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\MessagePassingQueueUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */