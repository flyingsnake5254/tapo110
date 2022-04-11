package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class BaseMpscLinkedAtomicArrayQueueConsumerFields<E>
  extends BaseMpscLinkedAtomicArrayQueuePad2<E>
{
  private static final AtomicLongFieldUpdater<BaseMpscLinkedAtomicArrayQueueConsumerFields> C_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseMpscLinkedAtomicArrayQueueConsumerFields.class, "consumerIndex");
  protected AtomicReferenceArray<E> consumerBuffer;
  private volatile long consumerIndex;
  protected long consumerMask;
  
  final long lpConsumerIndex()
  {
    return this.consumerIndex;
  }
  
  public final long lvConsumerIndex()
  {
    return this.consumerIndex;
  }
  
  final void soConsumerIndex(long paramLong)
  {
    C_INDEX_UPDATER.lazySet(this, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\BaseMpscLinkedAtomicArrayQueueConsumerFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */