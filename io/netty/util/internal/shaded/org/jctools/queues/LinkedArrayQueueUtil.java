package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

final class LinkedArrayQueueUtil
{
  static int length(Object[] paramArrayOfObject)
  {
    return paramArrayOfObject.length;
  }
  
  static long modifiedCalcCircularRefElementOffset(long paramLong1, long paramLong2)
  {
    return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((paramLong1 & paramLong2) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT - 1);
  }
  
  static long nextArrayOffset(Object[] paramArrayOfObject)
  {
    return UnsafeRefArrayAccess.REF_ARRAY_BASE + (length(paramArrayOfObject) - 1 << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\LinkedArrayQueueUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */