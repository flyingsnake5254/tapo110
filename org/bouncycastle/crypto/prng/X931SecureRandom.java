package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

public class X931SecureRandom
  extends SecureRandom
{
  private final i drbg;
  private final boolean predictionResistant;
  private final SecureRandom randomSource;
  
  X931SecureRandom(SecureRandom paramSecureRandom, i parami, boolean paramBoolean)
  {
    this.randomSource = paramSecureRandom;
    this.predictionResistant = paramBoolean;
  }
  
  public byte[] generateSeed(int paramInt)
  {
    throw null;
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    try
    {
      throw null;
      throw paramArrayOfByte;
    }
    finally
    {
      for (;;) {}
    }
  }
  
  public void setSeed(long paramLong)
  {
    try
    {
      SecureRandom localSecureRandom = this.randomSource;
      if (localSecureRandom != null) {
        localSecureRandom.setSeed(paramLong);
      }
      return;
    }
    finally {}
  }
  
  public void setSeed(byte[] paramArrayOfByte)
  {
    try
    {
      SecureRandom localSecureRandom = this.randomSource;
      if (localSecureRandom != null) {
        localSecureRandom.setSeed(paramArrayOfByte);
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\prng\X931SecureRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */