package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class MpscChunkedAtomicArrayQueue<E>
  extends MpscChunkedAtomicArrayQueueColdProducerFields<E>
{
  long p0;
  long p1;
  long p10;
  long p11;
  long p12;
  long p13;
  long p14;
  long p15;
  long p16;
  long p17;
  long p2;
  long p3;
  long p4;
  long p5;
  long p6;
  long p7;
  
  public MpscChunkedAtomicArrayQueue(int paramInt)
  {
    super(Math.max(2, Math.min(1024, Pow2.roundToPowerOfTwo(paramInt / 8))), paramInt);
  }
  
  public MpscChunkedAtomicArrayQueue(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected long availableInQueue(long paramLong1, long paramLong2)
  {
    return this.maxQueueCapacity - (paramLong1 - paramLong2);
  }
  
  public int capacity()
  {
    return (int)(this.maxQueueCapacity / 2L);
  }
  
  protected long getCurrentBufferCapacity(long paramLong)
  {
    return paramLong;
  }
  
  protected int getNextBufferSize(AtomicReferenceArray<E> paramAtomicReferenceArray)
  {
    return AtomicQueueUtil.length(paramAtomicReferenceArray);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\MpscChunkedAtomicArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */