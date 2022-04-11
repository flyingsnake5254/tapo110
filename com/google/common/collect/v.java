package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

final class v
{
  static void a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 != null) {
        return;
      }
      paramObject2 = new StringBuilder();
      ((StringBuilder)paramObject2).append("null value in entry: ");
      ((StringBuilder)paramObject2).append(paramObject1);
      ((StringBuilder)paramObject2).append("=null");
      throw new NullPointerException(((StringBuilder)paramObject2).toString());
    }
    paramObject1 = new StringBuilder();
    ((StringBuilder)paramObject1).append("null key in entry: null=");
    ((StringBuilder)paramObject1).append(paramObject2);
    throw new NullPointerException(((StringBuilder)paramObject1).toString());
  }
  
  @CanIgnoreReturnValue
  static int b(int paramInt, String paramString)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" cannot be negative but was: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @CanIgnoreReturnValue
  static long c(long paramLong, String paramString)
  {
    if (paramLong >= 0L) {
      return paramLong;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" cannot be negative but was: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static void d(int paramInt, String paramString)
  {
    if (paramInt > 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" must be positive but was: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static void e(boolean paramBoolean)
  {
    n.v(paramBoolean, "no calls to next() since the last call to remove()");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */