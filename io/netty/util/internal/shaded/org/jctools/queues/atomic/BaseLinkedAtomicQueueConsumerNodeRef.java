package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

abstract class BaseLinkedAtomicQueueConsumerNodeRef<E>
  extends BaseLinkedAtomicQueuePad1<E>
{
  private static final AtomicReferenceFieldUpdater<BaseLinkedAtomicQueueConsumerNodeRef, LinkedQueueAtomicNode> C_NODE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(BaseLinkedAtomicQueueConsumerNodeRef.class, LinkedQueueAtomicNode.class, "consumerNode");
  private volatile LinkedQueueAtomicNode<E> consumerNode;
  
  final LinkedQueueAtomicNode<E> lpConsumerNode()
  {
    return this.consumerNode;
  }
  
  final LinkedQueueAtomicNode<E> lvConsumerNode()
  {
    return this.consumerNode;
  }
  
  final void spConsumerNode(LinkedQueueAtomicNode<E> paramLinkedQueueAtomicNode)
  {
    C_NODE_UPDATER.lazySet(this, paramLinkedQueueAtomicNode);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\BaseLinkedAtomicQueueConsumerNodeRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */