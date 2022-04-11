package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class BaseMpscLinkedAtomicArrayQueueProducerFields<E>
  extends BaseMpscLinkedAtomicArrayQueuePad1<E>
{
  private static final AtomicLongFieldUpdater<BaseMpscLinkedAtomicArrayQueueProducerFields> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseMpscLinkedAtomicArrayQueueProducerFields.class, "producerIndex");
  private volatile long producerIndex;
  
  final boolean casProducerIndex(long paramLong1, long paramLong2)
  {
    return P_INDEX_UPDATER.compareAndSet(this, paramLong1, paramLong2);
  }
  
  public final long lvProducerIndex()
  {
    return this.producerIndex;
  }
  
  final void soProducerIndex(long paramLong)
  {
    P_INDEX_UPDATER.lazySet(this, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\BaseMpscLinkedAtomicArrayQueueProducerFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */