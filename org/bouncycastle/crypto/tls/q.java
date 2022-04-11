package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;

public class q
{
  protected d0 a;
  protected byte[] b;
  
  public q(d0 paramd0, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.a = paramd0;
      this.b = paramArrayOfByte;
      return;
    }
    throw new IllegalArgumentException("'signature' cannot be null");
  }
  
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    d0 locald0 = this.a;
    if (locald0 != null) {
      locald0.a(paramOutputStream);
    }
    m1.t0(this.b, paramOutputStream);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */