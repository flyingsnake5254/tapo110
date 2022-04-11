package org.bouncycastle.crypto.w;

import java.security.SecureRandom;
import org.bouncycastle.crypto.e;

public class c0
  implements e
{
  private SecureRandom c;
  private e d;
  
  public c0(e parame, SecureRandom paramSecureRandom)
  {
    this.c = paramSecureRandom;
    this.d = parame;
  }
  
  public e a()
  {
    return this.d;
  }
  
  public SecureRandom b()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */