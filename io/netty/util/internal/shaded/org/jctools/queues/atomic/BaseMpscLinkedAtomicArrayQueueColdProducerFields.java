package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class BaseMpscLinkedAtomicArrayQueueColdProducerFields<E>
  extends BaseMpscLinkedAtomicArrayQueuePad3<E>
{
  private static final AtomicLongFieldUpdater<BaseMpscLinkedAtomicArrayQueueColdProducerFields> P_LIMIT_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseMpscLinkedAtomicArrayQueueColdProducerFields.class, "producerLimit");
  protected AtomicReferenceArray<E> producerBuffer;
  private volatile long producerLimit;
  protected long producerMask;
  
  final boolean casProducerLimit(long paramLong1, long paramLong2)
  {
    return P_LIMIT_UPDATER.compareAndSet(this, paramLong1, paramLong2);
  }
  
  final long lvProducerLimit()
  {
    return this.producerLimit;
  }
  
  final void soProducerLimit(long paramLong)
  {
    P_LIMIT_UPDATER.lazySet(this, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\BaseMpscLinkedAtomicArrayQueueColdProducerFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */