package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

abstract class BaseLinkedAtomicQueueProducerNodeRef<E>
  extends BaseLinkedAtomicQueuePad0<E>
{
  private static final AtomicReferenceFieldUpdater<BaseLinkedAtomicQueueProducerNodeRef, LinkedQueueAtomicNode> P_NODE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(BaseLinkedAtomicQueueProducerNodeRef.class, LinkedQueueAtomicNode.class, "producerNode");
  private volatile LinkedQueueAtomicNode<E> producerNode;
  
  final boolean casProducerNode(LinkedQueueAtomicNode<E> paramLinkedQueueAtomicNode1, LinkedQueueAtomicNode<E> paramLinkedQueueAtomicNode2)
  {
    return P_NODE_UPDATER.compareAndSet(this, paramLinkedQueueAtomicNode1, paramLinkedQueueAtomicNode2);
  }
  
  final LinkedQueueAtomicNode<E> lpProducerNode()
  {
    return this.producerNode;
  }
  
  final LinkedQueueAtomicNode<E> lvProducerNode()
  {
    return this.producerNode;
  }
  
  final void spProducerNode(LinkedQueueAtomicNode<E> paramLinkedQueueAtomicNode)
  {
    P_NODE_UPDATER.lazySet(this, paramLinkedQueueAtomicNode);
  }
  
  protected final LinkedQueueAtomicNode<E> xchgProducerNode(LinkedQueueAtomicNode<E> paramLinkedQueueAtomicNode)
  {
    return (LinkedQueueAtomicNode)P_NODE_UPDATER.getAndSet(this, paramLinkedQueueAtomicNode);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\BaseLinkedAtomicQueueProducerNodeRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */