package org.bouncycastle.crypto.tls;

import java.io.IOException;

public class w
  extends b
{
  protected c1 i;
  
  public w(c1 paramc1)
  {
    this(new n(), paramc1);
  }
  
  public w(j0 paramj0, c1 paramc1)
  {
    super(paramj0);
    this.i = paramc1;
  }
  
  protected x0 C(int paramInt)
  {
    return new e1(paramInt, this.c, this.i, null, null, this.d, this.e, this.f);
  }
  
  public x0 h()
    throws IOException
  {
    int j = m1.D(this.g);
    if (j != 24) {
      switch (j)
      {
      default: 
        throw new TlsFatalAlert((short)80);
      }
    }
    return C(j);
  }
  
  public int[] j()
  {
    return new int[] { 49207, 49205, 178, 144 };
  }
  
  public g0 u()
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */