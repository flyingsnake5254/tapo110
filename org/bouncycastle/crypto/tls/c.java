package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;
import org.bouncycastle.util.j;

abstract class c
  implements p0
{
  private static long a = ;
  private org.bouncycastle.crypto.prng.g b;
  private SecureRandom c;
  private a0 d;
  private x e = null;
  private x f = null;
  private i1 g = null;
  private Object h = null;
  
  c(SecureRandom paramSecureRandom, a0 parama0)
  {
    Object localObject = m1.n((short)4);
    byte[] arrayOfByte = new byte[((org.bouncycastle.crypto.g)localObject).e()];
    paramSecureRandom.nextBytes(arrayOfByte);
    localObject = new org.bouncycastle.crypto.prng.c((org.bouncycastle.crypto.g)localObject);
    this.b = ((org.bouncycastle.crypto.prng.g)localObject);
    ((org.bouncycastle.crypto.prng.g)localObject).c(f());
    this.b.c(j.a());
    this.b.a(arrayOfByte);
    this.c = paramSecureRandom;
    this.d = parama0;
  }
  
  private static long f()
  {
    try
    {
      long l = a + 1L;
      a = l;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public x a()
  {
    return this.e;
  }
  
  public x b()
  {
    return this.f;
  }
  
  public SecureRandom c()
  {
    return this.c;
  }
  
  public org.bouncycastle.crypto.prng.g d()
  {
    return this.b;
  }
  
  public a0 e()
  {
    return this.d;
  }
  
  void g(x paramx)
  {
    this.e = paramx;
  }
  
  void h(i1 parami1)
  {
    this.g = parami1;
  }
  
  void i(x paramx)
  {
    this.f = paramx;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */