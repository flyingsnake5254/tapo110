package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import sun.misc.Unsafe;

abstract class BaseLinkedQueueProducerNodeRef<E>
  extends BaseLinkedQueuePad0<E>
{
  static final long P_NODE_OFFSET = UnsafeAccess.fieldOffset(BaseLinkedQueueProducerNodeRef.class, "producerNode");
  private LinkedQueueNode<E> producerNode;
  
  final boolean casProducerNode(LinkedQueueNode<E> paramLinkedQueueNode1, LinkedQueueNode<E> paramLinkedQueueNode2)
  {
    return UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, paramLinkedQueueNode1, paramLinkedQueueNode2);
  }
  
  final LinkedQueueNode<E> lpProducerNode()
  {
    return this.producerNode;
  }
  
  final LinkedQueueNode<E> lvProducerNode()
  {
    return (LinkedQueueNode)UnsafeAccess.UNSAFE.getObjectVolatile(this, P_NODE_OFFSET);
  }
  
  final void spProducerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    this.producerNode = paramLinkedQueueNode;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\BaseLinkedQueueProducerNodeRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */