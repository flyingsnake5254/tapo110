package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import sun.misc.Unsafe;

abstract class MpscArrayQueueProducerLimitField<E>
  extends MpscArrayQueueMidPad<E>
{
  private static final long P_LIMIT_OFFSET = UnsafeAccess.fieldOffset(MpscArrayQueueProducerLimitField.class, "producerLimit");
  private volatile long producerLimit;
  
  MpscArrayQueueProducerLimitField(int paramInt)
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
    UnsafeAccess.UNSAFE.putOrderedLong(this, P_LIMIT_OFFSET, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\MpscArrayQueueProducerLimitField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */