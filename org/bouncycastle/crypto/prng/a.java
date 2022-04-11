package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

public class a
  implements e
{
  private final SecureRandom a;
  private final boolean b;
  
  public a(SecureRandom paramSecureRandom, boolean paramBoolean)
  {
    this.a = paramSecureRandom;
    this.b = paramBoolean;
  }
  
  public d get(final int paramInt)
  {
    return new a(paramInt);
  }
  
  class a
    implements d
  {
    a(int paramInt) {}
    
    public byte[] a()
    {
      if ((!(a.a(a.this) instanceof SP800SecureRandom)) && (!(a.a(a.this) instanceof X931SecureRandom))) {
        return a.a(a.this).generateSeed((paramInt + 7) / 8);
      }
      byte[] arrayOfByte = new byte[(paramInt + 7) / 8];
      a.a(a.this).nextBytes(arrayOfByte);
      return arrayOfByte;
    }
    
    public int b()
    {
      return paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\prng\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */