package org.bouncycastle.crypto.w;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.i;

public class o
  extends i
{
  private n c;
  
  public o(n paramn, SecureRandom paramSecureRandom)
  {
    super(paramSecureRandom, paramn.e().bitLength());
    this.c = paramn;
  }
  
  public n b()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */