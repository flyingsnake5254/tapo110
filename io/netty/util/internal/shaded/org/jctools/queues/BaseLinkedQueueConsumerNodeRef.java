package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import sun.misc.Unsafe;

abstract class BaseLinkedQueueConsumerNodeRef<E>
  extends BaseLinkedQueuePad1<E>
{
  private static final long C_NODE_OFFSET = UnsafeAccess.fieldOffset(BaseLinkedQueueConsumerNodeRef.class, "consumerNode");
  private LinkedQueueNode<E> consumerNode;
  
  final LinkedQueueNode<E> lpConsumerNode()
  {
    return this.consumerNode;
  }
  
  final LinkedQueueNode<E> lvConsumerNode()
  {
    return (LinkedQueueNode)UnsafeAccess.UNSAFE.getObjectVolatile(this, C_NODE_OFFSET);
  }
  
  final void spConsumerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    this.consumerNode = paramLinkedQueueNode;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\BaseLinkedQueueConsumerNodeRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */