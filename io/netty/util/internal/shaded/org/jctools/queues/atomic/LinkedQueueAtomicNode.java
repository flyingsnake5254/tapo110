package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReference;

public final class LinkedQueueAtomicNode<E>
  extends AtomicReference<LinkedQueueAtomicNode<E>>
{
  private static final long serialVersionUID = 2404266111789071508L;
  private E value;
  
  LinkedQueueAtomicNode() {}
  
  LinkedQueueAtomicNode(E paramE)
  {
    spValue(paramE);
  }
  
  public E getAndNullValue()
  {
    Object localObject = lpValue();
    spValue(null);
    return (E)localObject;
  }
  
  public E lpValue()
  {
    return (E)this.value;
  }
  
  public LinkedQueueAtomicNode<E> lvNext()
  {
    return (LinkedQueueAtomicNode)get();
  }
  
  public void soNext(LinkedQueueAtomicNode<E> paramLinkedQueueAtomicNode)
  {
    lazySet(paramLinkedQueueAtomicNode);
  }
  
  public void spValue(E paramE)
  {
    this.value = paramE;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\LinkedQueueAtomicNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */