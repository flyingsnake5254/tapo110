package io.netty.util.internal.shaded.org.jctools.util;

public final class RangeUtil
{
  public static int checkGreaterThanOrEqual(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 >= paramInt2) {
      return paramInt1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" (expected: >= ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(')');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static int checkLessThan(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" (expected: < ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(')');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static int checkLessThanOrEqual(int paramInt, long paramLong, String paramString)
  {
    if (paramInt <= paramLong) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: <= ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(')');
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\util\RangeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */