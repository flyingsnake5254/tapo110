package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import org.bouncycastle.crypto.prng.j.c;

public class SP800SecureRandom
  extends SecureRandom
{
  private c drbg;
  private final b drbgProvider;
  private final d entropySource;
  private final boolean predictionResistant;
  private final SecureRandom randomSource;
  
  SP800SecureRandom(SecureRandom paramSecureRandom, d paramd, b paramb, boolean paramBoolean)
  {
    this.randomSource = paramSecureRandom;
    this.entropySource = paramd;
    this.drbgProvider = paramb;
    this.predictionResistant = paramBoolean;
  }
  
  public byte[] generateSeed(int paramInt)
  {
    return f.a(this.entropySource, paramInt);
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.drbg == null) {
        this.drbg = this.drbgProvider.a(this.entropySource);
      }
      if (this.drbg.a(paramArrayOfByte, null, this.predictionResistant) < 0)
      {
        this.drbg.b(null);
        this.drbg.a(paramArrayOfByte, null, this.predictionResistant);
      }
      return;
    }
    finally {}
  }
  
  public void reseed(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.drbg == null) {
        this.drbg = this.drbgProvider.a(this.entropySource);
      }
      this.drbg.b(paramArrayOfByte);
      return;
    }
    finally {}
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\prng\SP800SecureRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */