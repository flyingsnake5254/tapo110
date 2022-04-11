package io.reactivex.h0.a;

import io.reactivex.g0.d;
import java.util.Objects;

public final class b
{
  static final d<Object, Object> a = new a();
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      paramInt1 = -1;
    } else if (paramInt1 > paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    return paramInt1;
  }
  
  public static int b(long paramLong1, long paramLong2)
  {
    boolean bool = paramLong1 < paramLong2;
    int i;
    if (bool) {
      i = -1;
    } else if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  public static boolean c(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if ((paramObject1 != paramObject2) && ((paramObject1 == null) || (!paramObject1.equals(paramObject2)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static <T> d<T, T> d()
  {
    return a;
  }
  
  public static <T> T e(T paramT, String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
  
  public static int f(int paramInt, String paramString)
  {
    if (paramInt > 0) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" > 0 required but it was ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static final class a
    implements d<Object, Object>
  {
    public boolean a(Object paramObject1, Object paramObject2)
    {
      return b.c(paramObject1, paramObject2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */