package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import sun.misc.Unsafe;

abstract class MpscArrayQueueConsumerIndexField<E>
  extends MpscArrayQueueL2Pad<E>
{
  private static final long C_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpscArrayQueueConsumerIndexField.class, "consumerIndex");
  private volatile long consumerIndex;
  
  MpscArrayQueueConsumerIndexField(int paramInt)
  {
    super(paramInt);
  }
  
  final long lpConsumerIndex()
  {
    return UnsafeAccess.UNSAFE.getLong(this, C_INDEX_OFFSET);
  }
  
  public final long lvConsumerIndex()
  {
    return this.consumerIndex;
  }
  
  final void soConsumerIndex(long paramLong)
  {
    UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\MpscArrayQueueConsumerIndexField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */