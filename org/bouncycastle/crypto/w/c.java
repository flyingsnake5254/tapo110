package org.bouncycastle.crypto.w;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.i;

public class c
  extends i
{
  private e c;
  
  public c(SecureRandom paramSecureRandom, e parame)
  {
    super(paramSecureRandom, c(parame));
    this.c = parame;
  }
  
  static int c(e parame)
  {
    int i;
    if (parame.d() != 0) {
      i = parame.d();
    } else {
      i = parame.f().bitLength();
    }
    return i;
  }
  
  public e b()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */