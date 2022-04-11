package io.netty.util.internal;

import java.util.Collection;
import java.util.Objects;

public final class ObjectUtil
{
  public static <T extends Collection<?>> T checkNonEmpty(T paramT, String paramString)
  {
    checkNotNull(paramT, paramString);
    int i = paramT.size();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".size");
    checkPositive(i, localStringBuilder.toString());
    return paramT;
  }
  
  public static <T> T[] checkNonEmpty(T[] paramArrayOfT, String paramString)
  {
    checkNotNull(paramArrayOfT, paramString);
    int i = paramArrayOfT.length;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".length");
    checkPositive(i, localStringBuilder.toString());
    return paramArrayOfT;
  }
  
  public static <T> T checkNotNull(T paramT, String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
  
  public static int checkPositive(int paramInt, String paramString)
  {
    if (paramInt > 0) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: > 0)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static long checkPositive(long paramLong, String paramString)
  {
    if (paramLong > 0L) {
      return paramLong;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" (expected: > 0)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static int checkPositiveOrZero(int paramInt, String paramString)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: >= 0)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static long checkPositiveOrZero(long paramLong, String paramString)
  {
    if (paramLong >= 0L) {
      return paramLong;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" (expected: >= 0)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static int intValue(Integer paramInteger, int paramInt)
  {
    if (paramInteger != null) {
      paramInt = paramInteger.intValue();
    }
    return paramInt;
  }
  
  public static long longValue(Long paramLong, long paramLong1)
  {
    if (paramLong != null) {
      paramLong1 = paramLong.longValue();
    }
    return paramLong1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\ObjectUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */