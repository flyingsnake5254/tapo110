package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class MpscAtomicArrayQueueProducerIndexField<E>
  extends MpscAtomicArrayQueueL1Pad<E>
{
  private static final AtomicLongFieldUpdater<MpscAtomicArrayQueueProducerIndexField> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueProducerIndexField.class, "producerIndex");
  private volatile long producerIndex;
  
  MpscAtomicArrayQueueProducerIndexField(int paramInt)
  {
    super(paramInt);
  }
  
  final boolean casProducerIndex(long paramLong1, long paramLong2)
  {
    return P_INDEX_UPDATER.compareAndSet(this, paramLong1, paramLong2);
  }
  
  public final long lvProducerIndex()
  {
    return this.producerIndex;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\MpscAtomicArrayQueueProducerIndexField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */