package io.netty.util.internal.shaded.org.jctools.queues;

import java.util.Iterator;

abstract class BaseLinkedQueue<E>
  extends BaseLinkedQueuePad2<E>
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
        LinkedQueueNode localLinkedQueueNode;
        for (Object localObject = lpConsumerNode(); i < paramInt; localObject = localLinkedQueueNode)
        {
          localLinkedQueueNode = ((LinkedQueueNode)localObject).lvNext();
          if (localLinkedQueueNode == null) {
            return i;
          }
          paramConsumer.accept(getSingleConsumerNodeValue((LinkedQueueNode)localObject, localLinkedQueueNode));
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
  
  protected E getSingleConsumerNodeValue(LinkedQueueNode<E> paramLinkedQueueNode1, LinkedQueueNode<E> paramLinkedQueueNode2)
  {
    Object localObject = paramLinkedQueueNode2.getAndNullValue();
    paramLinkedQueueNode1.soNext(paramLinkedQueueNode1);
    spConsumerNode(paramLinkedQueueNode2);
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
  
  protected final LinkedQueueNode<E> newNode()
  {
    return new LinkedQueueNode();
  }
  
  protected final LinkedQueueNode<E> newNode(E paramE)
  {
    return new LinkedQueueNode(paramE);
  }
  
  public boolean relaxedOffer(E paramE)
  {
    return offer(paramE);
  }
  
  public E relaxedPeek()
  {
    LinkedQueueNode localLinkedQueueNode = lpConsumerNode().lvNext();
    if (localLinkedQueueNode != null) {
      return (E)localLinkedQueueNode.lpValue();
    }
    return null;
  }
  
  public E relaxedPoll()
  {
    LinkedQueueNode localLinkedQueueNode1 = lpConsumerNode();
    LinkedQueueNode localLinkedQueueNode2 = localLinkedQueueNode1.lvNext();
    if (localLinkedQueueNode2 != null) {
      return (E)getSingleConsumerNodeValue(localLinkedQueueNode1, localLinkedQueueNode2);
    }
    return null;
  }
  
  public final int size()
  {
    Object localObject = lvConsumerNode();
    LinkedQueueNode localLinkedQueueNode1 = lvProducerNode();
    int i = 0;
    while ((localObject != localLinkedQueueNode1) && (localObject != null) && (i < Integer.MAX_VALUE))
    {
      LinkedQueueNode localLinkedQueueNode2 = ((LinkedQueueNode)localObject).lvNext();
      if (localLinkedQueueNode2 == localObject) {
        return i;
      }
      i++;
      localObject = localLinkedQueueNode2;
    }
    return i;
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\BaseLinkedQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */