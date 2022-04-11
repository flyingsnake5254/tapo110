package io.netty.util.internal.shaded.org.jctools.util;

public final class Pow2
{
  public static final int MAX_POW2 = 1073741824;
  
  public static long align(long paramLong, int paramInt)
  {
    if (isPowerOfTwo(paramInt))
    {
      paramInt--;
      return paramLong + paramInt & (paramInt ^ 0xFFFFFFFF);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("alignment must be a power of 2:");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static boolean isPowerOfTwo(int paramInt)
  {
    boolean bool;
    if ((paramInt & paramInt - 1) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static int roundToPowerOfTwo(int paramInt)
  {
    if (paramInt <= 1073741824)
    {
      if (paramInt >= 0) {
        return 1 << 32 - Integer.numberOfLeadingZeros(paramInt - 1);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Given value:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(". Expecting value >= 0.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("There is no larger power of 2 int for value:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" since it exceeds 2^31.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\util\Pow2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */