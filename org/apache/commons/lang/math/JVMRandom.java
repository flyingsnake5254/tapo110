package org.apache.commons.lang.math;

import java.util.Random;

public final class JVMRandom
  extends Random
{
  private static final Random SHARED_RANDOM = new Random();
  private static final long serialVersionUID = 1L;
  private boolean constructed = false;
  
  private static int bitsRequired(long paramLong)
  {
    int i = 0;
    for (long l = paramLong;; l >>= 1)
    {
      if (paramLong < 0L) {
        return 64 - i;
      }
      if (l == 0L) {
        return i;
      }
      i++;
      paramLong <<= 1;
    }
  }
  
  private static long next63bits()
  {
    return SHARED_RANDOM.nextLong() & 0x7FFFFFFFFFFFFFFF;
  }
  
  public static long nextLong(long paramLong)
  {
    if (paramLong > 0L)
    {
      if ((-paramLong & paramLong) == paramLong) {
        return next63bits() >> 63 - bitsRequired(paramLong - 1L);
      }
      long l1;
      long l2;
      do
      {
        l1 = next63bits();
        l2 = l1 % paramLong;
      } while (l1 - l2 + (paramLong - 1L) < 0L);
      return l2;
    }
    throw new IllegalArgumentException("Upper bound for nextInt must be positive");
  }
  
  public boolean nextBoolean()
  {
    return SHARED_RANDOM.nextBoolean();
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }
  
  public double nextDouble()
  {
    return SHARED_RANDOM.nextDouble();
  }
  
  public float nextFloat()
  {
    return SHARED_RANDOM.nextFloat();
  }
  
  public double nextGaussian()
  {
    try
    {
      UnsupportedOperationException localUnsupportedOperationException = new java/lang/UnsupportedOperationException;
      localUnsupportedOperationException.<init>();
      throw localUnsupportedOperationException;
    }
    finally {}
  }
  
  public int nextInt()
  {
    return nextInt(Integer.MAX_VALUE);
  }
  
  public int nextInt(int paramInt)
  {
    return SHARED_RANDOM.nextInt(paramInt);
  }
  
  public long nextLong()
  {
    return nextLong(Long.MAX_VALUE);
  }
  
  public void setSeed(long paramLong)
  {
    try
    {
      boolean bool = this.constructed;
      if (!bool) {
        return;
      }
      UnsupportedOperationException localUnsupportedOperationException = new java/lang/UnsupportedOperationException;
      localUnsupportedOperationException.<init>();
      throw localUnsupportedOperationException;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\math\JVMRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */