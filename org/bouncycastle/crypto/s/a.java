package org.bouncycastle.crypto.s;

import java.math.BigInteger;
import org.bouncycastle.crypto.i;
import org.bouncycastle.crypto.w.c;
import org.bouncycastle.crypto.w.e;
import org.bouncycastle.crypto.w.f;
import org.bouncycastle.crypto.w.g;

public class a
{
  private c a;
  
  public org.bouncycastle.crypto.b a()
  {
    b localb = b.a;
    e locale = this.a.b();
    BigInteger localBigInteger = localb.a(locale, this.a.a());
    return new org.bouncycastle.crypto.b(new g(localb.b(locale, localBigInteger), locale), new f(localBigInteger, locale));
  }
  
  public void b(i parami)
  {
    this.a = ((c)parami);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\s\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */