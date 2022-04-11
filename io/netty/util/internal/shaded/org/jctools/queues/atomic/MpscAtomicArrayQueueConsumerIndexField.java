package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class MpscAtomicArrayQueueConsumerIndexField<E>
  extends MpscAtomicArrayQueueL2Pad<E>
{
  private static final AtomicLongFieldUpdater<MpscAtomicArrayQueueConsumerIndexField> C_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueConsumerIndexField.class, "consumerIndex");
  private volatile long consumerIndex;
  
  MpscAtomicArrayQueueConsumerIndexField(int paramInt)
  {
    super(paramInt);
  }
  
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\MpscAtomicArrayQueueConsumerIndexField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */