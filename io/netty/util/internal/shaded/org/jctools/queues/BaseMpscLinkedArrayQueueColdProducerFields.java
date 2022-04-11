package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import sun.misc.Unsafe;

abstract class BaseMpscLinkedArrayQueueColdProducerFields<E>
  extends BaseMpscLinkedArrayQueuePad3<E>
{
  private static final long P_LIMIT_OFFSET = UnsafeAccess.fieldOffset(BaseMpscLinkedArrayQueueColdProducerFields.class, "producerLimit");
  protected E[] producerBuffer;
  private volatile long producerLimit;
  protected long producerMask;
  
  final boolean casProducerLimit(long paramLong1, long paramLong2)
  {
    return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_LIMIT_OFFSET, paramLong1, paramLong2);
  }
  
  final long lvProducerLimit()
  {
    return this.producerLimit;
  }
  
  final void soProducerLimit(long paramLong)
  {
    UnsafeAccess.UNSAFE.putOrderedLong(this, P_LIMIT_OFFSET, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\BaseMpscLinkedArrayQueueColdProducerFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */