package com.jcraft.jsch.jce;

import java.security.SecureRandom;

public class Random
  implements com.jcraft.jsch.Random
{
  private SecureRandom random = null;
  private byte[] tmp = new byte[16];
  
  public void fill(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 > this.tmp.length) {
      this.tmp = new byte[paramInt2];
    }
    this.random.nextBytes(this.tmp);
    System.arraycopy(this.tmp, 0, paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\Random.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */