package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import sun.misc.Unsafe;

final class LinkedQueueNode<E>
{
  private static final long NEXT_OFFSET = UnsafeAccess.fieldOffset(LinkedQueueNode.class, "next");
  private volatile LinkedQueueNode<E> next;
  private E value;
  
  LinkedQueueNode()
  {
    this(null);
  }
  
  LinkedQueueNode(E paramE)
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
  
  public LinkedQueueNode<E> lvNext()
  {
    return this.next;
  }
  
  public void soNext(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    UnsafeAccess.UNSAFE.putOrderedObject(this, NEXT_OFFSET, paramLinkedQueueNode);
  }
  
  public void spValue(E paramE)
  {
    this.value = paramE;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\LinkedQueueNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */