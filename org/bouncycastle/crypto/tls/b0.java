package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.crypto.w.e;
import org.bouncycastle.crypto.w.g;

public class b0
{
  protected g a;
  
  public b0(g paramg)
  {
    if (paramg != null)
    {
      this.a = paramg;
      return;
    }
    throw new IllegalArgumentException("'publicKey' cannot be null");
  }
  
  public static b0 b(InputStream paramInputStream)
    throws IOException
  {
    BigInteger localBigInteger1 = r0.f(paramInputStream);
    BigInteger localBigInteger2 = r0.f(paramInputStream);
    return new b0(r0.h(new g(r0.f(paramInputStream), new e(localBigInteger1, localBigInteger2))));
  }
  
  public g a()
  {
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */