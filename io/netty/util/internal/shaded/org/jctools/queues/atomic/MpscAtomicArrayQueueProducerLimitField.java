package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class MpscAtomicArrayQueueProducerLimitField<E>
  extends MpscAtomicArrayQueueMidPad<E>
{
  private static final AtomicLongFieldUpdater<MpscAtomicArrayQueueProducerLimitField> P_LIMIT_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueProducerLimitField.class, "producerLimit");
  private volatile long producerLimit;
  
  MpscAtomicArrayQueueProducerLimitField(int paramInt)
  {
    super(paramInt);
    this.producerLimit = paramInt;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\MpscAtomicArrayQueueProducerLimitField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */