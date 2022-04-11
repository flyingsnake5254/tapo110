package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.ExitCondition;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Supplier;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.WaitStrategy;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import java.util.Objects;

public class SpscLinkedAtomicQueue<E>
  extends BaseLinkedAtomicQueue<E>
{
  public SpscLinkedAtomicQueue()
  {
    LinkedQueueAtomicNode localLinkedQueueAtomicNode = newNode();
    spProducerNode(localLinkedQueueAtomicNode);
    spConsumerNode(localLinkedQueueAtomicNode);
    localLinkedQueueAtomicNode.soNext(null);
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
        LinkedQueueAtomicNode localLinkedQueueAtomicNode1 = newNode(paramSupplier.get());
        int i = 1;
        LinkedQueueAtomicNode localLinkedQueueAtomicNode2;
        for (Object localObject = localLinkedQueueAtomicNode1; i < paramInt; localObject = localLinkedQueueAtomicNode2)
        {
          localLinkedQueueAtomicNode2 = newNode(paramSupplier.get());
          ((LinkedQueueAtomicNode)localObject).soNext(localLinkedQueueAtomicNode2);
          i++;
        }
        lpProducerNode().soNext(localLinkedQueueAtomicNode1);
        spProducerNode((LinkedQueueAtomicNode)localObject);
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
              paramWaitStrategy.soNext((LinkedQueueAtomicNode)localObject);
              spProducerNode((LinkedQueueAtomicNode)localObject);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\SpscLinkedAtomicQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */