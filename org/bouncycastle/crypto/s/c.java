package org.bouncycastle.crypto.s;

import e.a.b.a.g;
import e.a.b.a.j;
import e.a.b.a.w;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.b;
import org.bouncycastle.crypto.f;
import org.bouncycastle.crypto.i;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.o;
import org.bouncycastle.crypto.w.r;
import org.bouncycastle.crypto.w.s;

public class c
  implements e.a.b.a.c
{
  n g;
  SecureRandom h;
  
  protected g a()
  {
    return new j();
  }
  
  public b b()
  {
    BigInteger localBigInteger1 = this.g.e();
    int i = localBigInteger1.bitLength();
    BigInteger localBigInteger2;
    do
    {
      localBigInteger2 = new BigInteger(i, this.h);
    } while ((localBigInteger2.compareTo(e.a.b.a.c.c) < 0) || (localBigInteger2.compareTo(localBigInteger1) >= 0) || (w.g(localBigInteger2) < i >>> 2));
    return new b(new s(a().a(this.g.b(), localBigInteger2), this.g), new r(localBigInteger2, this.g));
  }
  
  public void c(i parami)
  {
    parami = (o)parami;
    this.h = parami.a();
    this.g = parami.b();
    if (this.h == null) {
      this.h = f.b();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\s\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */