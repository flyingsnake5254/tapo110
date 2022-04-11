package com.google.common.math;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.RoundingMode;

@CanIgnoreReturnValue
final class f
{
  static void a(boolean paramBoolean, double paramDouble, RoundingMode paramRoundingMode)
  {
    if (paramBoolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rounded value is out of range for input ");
    localStringBuilder.append(paramDouble);
    localStringBuilder.append(" and rounding mode ");
    localStringBuilder.append(paramRoundingMode);
    throw new ArithmeticException(localStringBuilder.toString());
  }
  
  static void b(boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("overflow: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(")");
    throw new ArithmeticException(localStringBuilder.toString());
  }
  
  static void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\math\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */