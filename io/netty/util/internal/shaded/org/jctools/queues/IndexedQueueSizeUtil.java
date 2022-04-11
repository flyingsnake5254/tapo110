package io.netty.util.internal.shaded.org.jctools.queues;

public final class IndexedQueueSizeUtil
{
  public static boolean isEmpty(IndexedQueue paramIndexedQueue)
  {
    boolean bool;
    if (paramIndexedQueue.lvConsumerIndex() == paramIndexedQueue.lvProducerIndex()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static int size(IndexedQueue paramIndexedQueue)
  {
    long l3;
    for (long l1 = paramIndexedQueue.lvConsumerIndex();; l1 = l3)
    {
      long l2 = paramIndexedQueue.lvProducerIndex();
      l3 = paramIndexedQueue.lvConsumerIndex();
      if (l1 == l3)
      {
        l1 = l2 - l3;
        if (l1 > 2147483647L) {
          return Integer.MAX_VALUE;
        }
        return (int)l1;
      }
    }
  }
  
  public static abstract interface IndexedQueue
  {
    public abstract long lvConsumerIndex();
    
    public abstract long lvProducerIndex();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\IndexedQueueSizeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */