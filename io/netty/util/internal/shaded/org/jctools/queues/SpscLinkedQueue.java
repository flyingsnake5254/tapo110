package io.netty.util.internal.shaded.org.jctools.queues;

import java.util.Objects;

public class SpscLinkedQueue<E>
  extends BaseLinkedQueue<E>
{
  public SpscLinkedQueue()
  {
    LinkedQueueNode localLinkedQueueNode = newNode();
    spProducerNode(localLinkedQueueNode);
    spConsumerNode(localLinkedQueueNode);
    localLinkedQueueNode.soNext(null);
  }
  
  public int fill(MessagePassingQueue.Supplier<E> paramSupplier)
  {
    return MessagePassingQueueUtil.fillUnbounded(this, paramSupplier);
  }
  
  public int fill(MessagePassingQueue.Supplier<E> paramSupplier, int paramInt)
  {
    if (paramSupplier != null)
    {
      if (paramInt >= 0)
      {
        if (paramInt == 0) {
          return 0;
        }
        LinkedQueueNode localLinkedQueueNode1 = newNode(paramSupplier.get());
        int i = 1;
        LinkedQueueNode localLinkedQueueNode2;
        for (Object localObject = localLinkedQueueNode1; i < paramInt; localObject = localLinkedQueueNode2)
        {
          localLinkedQueueNode2 = newNode(paramSupplier.get());
          ((LinkedQueueNode)localObject).soNext(localLinkedQueueNode2);
          i++;
        }
        lpProducerNode().soNext(localLinkedQueueNode1);
        spProducerNode((LinkedQueueNode)localObject);
        return paramInt;
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
    if (paramWaitStrategy != null)
    {
      if (paramExitCondition != null)
      {
        if (paramSupplier != null)
        {
          Object localObject = lpProducerNode();
          if (paramExitCondition.keepRunning())
          {
            int i = 0;
            for (paramWaitStrategy = (MessagePassingQueue.WaitStrategy)localObject;; paramWaitStrategy = (MessagePassingQueue.WaitStrategy)localObject)
            {
              localObject = paramWaitStrategy;
              if (i >= 4096) {
                break;
              }
              localObject = newNode(paramSupplier.get());
              paramWaitStrategy.soNext((LinkedQueueNode)localObject);
              spProducerNode((LinkedQueueNode)localObject);
              i++;
            }
          }
          return;
        }
        throw new IllegalArgumentException("supplier is null");
      }
      throw new IllegalArgumentException("exit condition is null");
    }
    throw new IllegalArgumentException("waiter is null");
  }
  
  public boolean offer(E paramE)
  {
    Objects.requireNonNull(paramE);
    paramE = newNode(paramE);
    lpProducerNode().soNext(paramE);
    spProducerNode(paramE);
    return true;
  }
  
  public E peek()
  {
    return (E)relaxedPeek();
  }
  
  public E poll()
  {
    return (E)relaxedPoll();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\SpscLinkedQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */