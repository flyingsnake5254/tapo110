package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;

abstract class MpscChunkedAtomicArrayQueueColdProducerFields<E>
  extends BaseMpscLinkedAtomicArrayQueue<E>
{
  protected final long maxQueueCapacity;
  
  MpscChunkedAtomicArrayQueueColdProducerFields(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    RangeUtil.checkGreaterThanOrEqual(paramInt2, 4, "maxCapacity");
    RangeUtil.checkLessThan(Pow2.roundToPowerOfTwo(paramInt1), Pow2.roundToPowerOfTwo(paramInt2), "initialCapacity");
    this.maxQueueCapacity = (Pow2.roundToPowerOfTwo(paramInt2) << 1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\MpscChunkedAtomicArrayQueueColdProducerFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */