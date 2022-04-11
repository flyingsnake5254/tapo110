package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.ExitCondition;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.WaitStrategy;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import java.util.Iterator;

abstract class BaseLinkedAtomicQueue<E>
  extends BaseLinkedAtomicQueuePad2<E>
{
  public int capacity()
  {
    return -1;
  }
  
  public int drain(MessagePassingQueue.Consumer<E> paramConsumer)
  {
    return MessagePassingQueueUtil.drain(this, paramConsumer);
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
        LinkedQueueAtomicNode localLinkedQueueAtomicNode;
        for (Object localObject = lpConsumerNode(); i < paramInt; localObject = localLinkedQueueAtomicNode)
        {
          localLinkedQueueAtomicNode = ((LinkedQueueAtomicNode)localObject).lvNext();
          if (localLinkedQueueAtomicNode == null) {
            return i;
          }
          paramConsumer.accept(getSingleConsumerNodeValue((LinkedQueueAtomicNode)localObject, localLinkedQueueAtomicNode));
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
  
  protected E getSingleConsumerNodeValue(LinkedQueueAtomicNode<E> paramLinkedQueueAtomicNode1, LinkedQueueAtomicNode<E> paramLinkedQueueAtomicNode2)
  {
    Object localObject = paramLinkedQueueAtomicNode2.getAndNullValue();
    paramLinkedQueueAtomicNode1.soNext(paramLinkedQueueAtomicNode1);
    spConsumerNode(paramLinkedQueueAtomicNode2);
    return (E)localObject;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (lvConsumerNode() == lvProducerNode()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final Iterator<E> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  protected final LinkedQueueAtomicNode<E> newNode()
  {
    return new LinkedQueueAtomicNode();
  }
  
  protected final LinkedQueueAtomicNode<E> newNode(E paramE)
  {
    return new LinkedQueueAtomicNode(paramE);
  }
  
  public boolean relaxedOffer(E paramE)
  {
    return offer(paramE);
  }
  
  public E relaxedPeek()
  {
    LinkedQueueAtomicNode localLinkedQueueAtomicNode = lpConsumerNode().lvNext();
    if (localLinkedQueueAtomicNode != null) {
      return (E)localLinkedQueueAtomicNode.lpValue();
    }
    return null;
  }
  
  public E relaxedPoll()
  {
    LinkedQueueAtomicNode localLinkedQueueAtomicNode1 = lpConsumerNode();
    LinkedQueueAtomicNode localLinkedQueueAtomicNode2 = localLinkedQueueAtomicNode1.lvNext();
    if (localLinkedQueueAtomicNode2 != null) {
      return (E)getSingleConsumerNodeValue(localLinkedQueueAtomicNode1, localLinkedQueueAtomicNode2);
    }
    return null;
  }
  
  public final int size()
  {
    Object localObject = lvConsumerNode();
    LinkedQueueAtomicNode localLinkedQueueAtomicNode1 = lvProducerNode();
    int i = 0;
    while ((localObject != localLinkedQueueAtomicNode1) && (localObject != null) && (i < Integer.MAX_VALUE))
    {
      LinkedQueueAtomicNode localLinkedQueueAtomicNode2 = ((LinkedQueueAtomicNode)localObject).lvNext();
      if (localLinkedQueueAtomicNode2 == localObject) {
        return i;
      }
      i++;
      localObject = localLinkedQueueAtomicNode2;
    }
    return i;
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\BaseLinkedAtomicQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */