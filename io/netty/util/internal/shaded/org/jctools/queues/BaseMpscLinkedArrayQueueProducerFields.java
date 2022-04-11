package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import sun.misc.Unsafe;

abstract class BaseMpscLinkedArrayQueueProducerFields<E>
  extends BaseMpscLinkedArrayQueuePad1<E>
{
  private static final long P_INDEX_OFFSET = UnsafeAccess.fieldOffset(BaseMpscLinkedArrayQueueProducerFields.class, "producerIndex");
  private volatile long producerIndex;
  
  final boolean casProducerIndex(long paramLong1, long paramLong2)
  {
    return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_INDEX_OFFSET, paramLong1, paramLong2);
  }
  
  public final long lvProducerIndex()
  {
    return this.producerIndex;
  }
  
  final void soProducerIndex(long paramLong)
  {
    UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\BaseMpscLinkedArrayQueueProducerFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */