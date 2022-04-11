package io.netty.util.internal.shaded.org.jctools.util;

import sun.misc.Unsafe;

public final class UnsafeRefArrayAccess
{
  public static final long REF_ARRAY_BASE;
  public static final int REF_ELEMENT_SHIFT;
  
  static
  {
    Object localObject = UnsafeAccess.UNSAFE;
    int i = ((Unsafe)localObject).arrayIndexScale(Object[].class);
    if (4 == i)
    {
      REF_ELEMENT_SHIFT = 2;
    }
    else
    {
      if (8 != i) {
        break label44;
      }
      REF_ELEMENT_SHIFT = 3;
    }
    REF_ARRAY_BASE = ((Unsafe)localObject).arrayBaseOffset(Object[].class);
    return;
    label44:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unknown pointer size: ");
    ((StringBuilder)localObject).append(i);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public static <E> E[] allocateRefArray(int paramInt)
  {
    return new Object[paramInt];
  }
  
  public static long calcCircularRefElementOffset(long paramLong1, long paramLong2)
  {
    return REF_ARRAY_BASE + ((paramLong1 & paramLong2) << REF_ELEMENT_SHIFT);
  }
  
  public static long calcRefElementOffset(long paramLong)
  {
    return REF_ARRAY_BASE + (paramLong << REF_ELEMENT_SHIFT);
  }
  
  public static <E> E lpRefElement(E[] paramArrayOfE, long paramLong)
  {
    return (E)UnsafeAccess.UNSAFE.getObject(paramArrayOfE, paramLong);
  }
  
  public static <E> E lvRefElement(E[] paramArrayOfE, long paramLong)
  {
    return (E)UnsafeAccess.UNSAFE.getObjectVolatile(paramArrayOfE, paramLong);
  }
  
  public static <E> void soRefElement(E[] paramArrayOfE, long paramLong, E paramE)
  {
    UnsafeAccess.UNSAFE.putOrderedObject(paramArrayOfE, paramLong, paramE);
  }
  
  public static <E> void spRefElement(E[] paramArrayOfE, long paramLong, E paramE)
  {
    UnsafeAccess.UNSAFE.putObject(paramArrayOfE, paramLong, paramE);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\util\UnsafeRefArrayAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */