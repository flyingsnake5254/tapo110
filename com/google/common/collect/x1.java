package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;

public final class x1
{
  @CanIgnoreReturnValue
  static Object a(Object paramObject, int paramInt)
  {
    if (paramObject != null) {
      return paramObject;
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append("at index ");
    ((StringBuilder)paramObject).append(paramInt);
    throw new NullPointerException(((StringBuilder)paramObject).toString());
  }
  
  @CanIgnoreReturnValue
  static Object[] b(Object... paramVarArgs)
  {
    return c(paramVarArgs, paramVarArgs.length);
  }
  
  @CanIgnoreReturnValue
  static Object[] c(Object[] paramArrayOfObject, int paramInt)
  {
    for (int i = 0; i < paramInt; i++) {
      a(paramArrayOfObject[i], i);
    }
    return paramArrayOfObject;
  }
  
  @CanIgnoreReturnValue
  private static Object[] d(Iterable<?> paramIterable, Object[] paramArrayOfObject)
  {
    paramIterable = paramIterable.iterator();
    for (int i = 0; paramIterable.hasNext(); i++) {
      paramArrayOfObject[i] = paramIterable.next();
    }
    return paramArrayOfObject;
  }
  
  public static <T> T[] e(T[] paramArrayOfT, int paramInt)
  {
    return c2.b(paramArrayOfT, paramInt);
  }
  
  static Object[] f(Collection<?> paramCollection)
  {
    return d(paramCollection, new Object[paramCollection.size()]);
  }
  
  static <T> T[] g(Collection<?> paramCollection, T[] paramArrayOfT)
  {
    int i = paramCollection.size();
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < i) {
      localObject = e(paramArrayOfT, i);
    }
    d(paramCollection, (Object[])localObject);
    if (localObject.length > i) {
      localObject[i] = null;
    }
    return (T[])localObject;
  }
  
  static <T> T[] h(Object[] paramArrayOfObject, int paramInt1, int paramInt2, T[] paramArrayOfT)
  {
    n.t(paramInt1, paramInt1 + paramInt2, paramArrayOfObject.length);
    Object localObject;
    if (paramArrayOfT.length < paramInt2)
    {
      localObject = e(paramArrayOfT, paramInt2);
    }
    else
    {
      localObject = paramArrayOfT;
      if (paramArrayOfT.length > paramInt2)
      {
        paramArrayOfT[paramInt2] = null;
        localObject = paramArrayOfT;
      }
    }
    System.arraycopy(paramArrayOfObject, paramInt1, localObject, 0, paramInt2);
    return (T[])localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\x1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */