package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

final class c2
{
  static <T> T[] a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, T[] paramArrayOfT)
  {
    return Arrays.copyOfRange(paramArrayOfObject, paramInt1, paramInt2, paramArrayOfT.getClass());
  }
  
  static <T> T[] b(T[] paramArrayOfT, int paramInt)
  {
    return (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt);
  }
  
  static <K, V> Map<K, V> c(int paramInt)
  {
    return x.l(paramInt);
  }
  
  static <E> Set<E> d(int paramInt)
  {
    return y.h(paramInt);
  }
  
  static <K, V> Map<K, V> e(int paramInt)
  {
    return z.H(paramInt);
  }
  
  static <E> Set<E> f(int paramInt)
  {
    return a0.x(paramInt);
  }
  
  static <E> Set<E> g()
  {
    return y.g();
  }
  
  static <K, V> Map<K, V> h()
  {
    return x.h();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\c2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */