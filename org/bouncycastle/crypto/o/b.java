package org.bouncycastle.crypto.o;

import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.h;
import java.math.BigInteger;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.p;
import org.bouncycastle.crypto.w.r;
import org.bouncycastle.crypto.w.s;

public class b
{
  private r a;
  
  public BigInteger a(org.bouncycastle.crypto.e parame)
  {
    parame = (s)parame;
    n localn = this.a.b();
    if (localn.equals(parame.b()))
    {
      BigInteger localBigInteger1 = this.a.c();
      h localh = e.a.b.a.b.a(localn.a(), parame.c());
      if (!localh.u())
      {
        BigInteger localBigInteger2 = localn.c();
        BigInteger localBigInteger3 = localBigInteger1;
        parame = localh;
        if (!localBigInteger2.equals(c.b))
        {
          localBigInteger3 = localn.d().multiply(localBigInteger1).mod(localn.e());
          parame = e.a.b.a.b.l(localh, localBigInteger2);
        }
        parame = parame.y(localBigInteger3).A();
        if (!parame.u()) {
          return parame.f().t();
        }
        throw new IllegalStateException("Infinity is not a valid agreement value for ECDH");
      }
      throw new IllegalStateException("Infinity is not a valid public key for ECDH");
    }
    throw new IllegalStateException("ECDH public key has wrong domain parameters");
  }
  
  public int b()
  {
    return (this.a.b().a().t() + 7) / 8;
  }
  
  public void c(org.bouncycastle.crypto.e parame)
  {
    this.a = ((r)parame);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\o\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */