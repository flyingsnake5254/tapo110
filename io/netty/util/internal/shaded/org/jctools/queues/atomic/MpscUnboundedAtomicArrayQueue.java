package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Supplier;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class MpscUnboundedAtomicArrayQueue<E>
  extends BaseMpscLinkedAtomicArrayQueue<E>
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
  
  public MpscUnboundedAtomicArrayQueue(int paramInt)
  {
    super(paramInt);
  }
  
  protected long availableInQueue(long paramLong1, long paramLong2)
  {
    return 2147483647L;
  }
  
  public int capacity()
  {
    return -1;
  }
  
  public int drain(MessagePassingQueue.Consumer<E> paramConsumer)
  {
    return drain(paramConsumer, 4096);
  }
  
  public int fill(MessagePassingQueue.Supplier<E> paramSupplier)
  {
    return MessagePassingQueueUtil.fillUnbounded(this, paramSupplier);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\MpscUnboundedAtomicArrayQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */