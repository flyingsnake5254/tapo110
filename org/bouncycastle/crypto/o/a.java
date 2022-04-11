package org.bouncycastle.crypto.o;

import java.math.BigInteger;
import org.bouncycastle.crypto.w.b;
import org.bouncycastle.crypto.w.c0;
import org.bouncycastle.crypto.w.d;
import org.bouncycastle.crypto.w.f;
import org.bouncycastle.crypto.w.g;

public class a
{
  private static final BigInteger a = BigInteger.valueOf(1L);
  private f b;
  private org.bouncycastle.crypto.w.e c;
  
  public BigInteger a(org.bouncycastle.crypto.e parame)
  {
    Object localObject = (g)parame;
    if (((d)localObject).b().equals(this.c))
    {
      parame = this.c.f();
      BigInteger localBigInteger = ((g)localObject).c();
      if (localBigInteger != null)
      {
        localObject = a;
        if ((localBigInteger.compareTo((BigInteger)localObject) > 0) && (localBigInteger.compareTo(parame.subtract((BigInteger)localObject)) < 0))
        {
          parame = localBigInteger.modPow(this.b.c(), parame);
          if (!parame.equals(localObject)) {
            return parame;
          }
          throw new IllegalStateException("Shared key can't be 1");
        }
      }
      throw new IllegalArgumentException("Diffie-Hellman public key is weak");
    }
    throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
  }
  
  public void b(org.bouncycastle.crypto.e parame)
  {
    org.bouncycastle.crypto.e locale = parame;
    if ((parame instanceof c0)) {
      locale = ((c0)parame).a();
    }
    parame = (b)locale;
    if ((parame instanceof f))
    {
      parame = (f)parame;
      this.b = parame;
      this.c = parame.b();
      return;
    }
    throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\o\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */