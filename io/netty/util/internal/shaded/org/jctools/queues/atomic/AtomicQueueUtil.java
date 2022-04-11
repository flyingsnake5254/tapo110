package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

final class AtomicQueueUtil
{
  static AtomicLongArray allocateLongArray(int paramInt)
  {
    return new AtomicLongArray(paramInt);
  }
  
  static <E> AtomicReferenceArray<E> allocateRefArray(int paramInt)
  {
    return new AtomicReferenceArray(paramInt);
  }
  
  static int calcCircularLongElementOffset(long paramLong, int paramInt)
  {
    return (int)(paramLong & paramInt);
  }
  
  static int calcCircularRefElementOffset(long paramLong1, long paramLong2)
  {
    return (int)(paramLong1 & paramLong2);
  }
  
  static int calcLongElementOffset(long paramLong)
  {
    return (int)paramLong;
  }
  
  static int calcRefElementOffset(long paramLong)
  {
    return (int)paramLong;
  }
  
  static int length(AtomicReferenceArray<?> paramAtomicReferenceArray)
  {
    return paramAtomicReferenceArray.length();
  }
  
  static long lpLongElement(AtomicLongArray paramAtomicLongArray, int paramInt)
  {
    return paramAtomicLongArray.get(paramInt);
  }
  
  static <E> E lpRefElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt)
  {
    return (E)paramAtomicReferenceArray.get(paramInt);
  }
  
  static long lvLongElement(AtomicLongArray paramAtomicLongArray, int paramInt)
  {
    return paramAtomicLongArray.get(paramInt);
  }
  
  static <E> E lvRefElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt)
  {
    return (E)paramAtomicReferenceArray.get(paramInt);
  }
  
  static int modifiedCalcCircularRefElementOffset(long paramLong1, long paramLong2)
  {
    return (int)(paramLong1 & paramLong2) >> 1;
  }
  
  static int nextArrayOffset(AtomicReferenceArray<?> paramAtomicReferenceArray)
  {
    return length(paramAtomicReferenceArray) - 1;
  }
  
  static void soLongElement(AtomicLongArray paramAtomicLongArray, int paramInt, long paramLong)
  {
    paramAtomicLongArray.lazySet(paramInt, paramLong);
  }
  
  static void soRefElement(AtomicReferenceArray paramAtomicReferenceArray, int paramInt, Object paramObject)
  {
    paramAtomicReferenceArray.lazySet(paramInt, paramObject);
  }
  
  static void spLongElement(AtomicLongArray paramAtomicLongArray, int paramInt, long paramLong)
  {
    paramAtomicLongArray.lazySet(paramInt, paramLong);
  }
  
  static <E> void spRefElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt, E paramE)
  {
    paramAtomicReferenceArray.lazySet(paramInt, paramE);
  }
  
  static <E> void svRefElement(AtomicReferenceArray<E> paramAtomicReferenceArray, int paramInt, E paramE)
  {
    paramAtomicReferenceArray.set(paramInt, paramE);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\AtomicQueueUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */