package io.netty.handler.ssl.util;

import io.netty.util.internal.PlatformDependent;
import java.security.SecureRandom;
import java.util.Random;

final class ThreadLocalInsecureRandom
  extends SecureRandom
{
  private static final SecureRandom INSTANCE = new ThreadLocalInsecureRandom();
  private static final long serialVersionUID = -8209473337192526191L;
  
  static SecureRandom current()
  {
    return INSTANCE;
  }
  
  private static Random random()
  {
    return PlatformDependent.threadLocalRandom();
  }
  
  public byte[] generateSeed(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    random().nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  public String getAlgorithm()
  {
    return "insecure";
  }
  
  public boolean nextBoolean()
  {
    return random().nextBoolean();
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    random().nextBytes(paramArrayOfByte);
  }
  
  public double nextDouble()
  {
    return random().nextDouble();
  }
  
  public float nextFloat()
  {
    return random().nextFloat();
  }
  
  public double nextGaussian()
  {
    return random().nextGaussian();
  }
  
  public int nextInt()
  {
    return random().nextInt();
  }
  
  public int nextInt(int paramInt)
  {
    return random().nextInt(paramInt);
  }
  
  public long nextLong()
  {
    return random().nextLong();
  }
  
  public void setSeed(long paramLong) {}
  
  public void setSeed(byte[] paramArrayOfByte) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\util\ThreadLocalInsecureRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */