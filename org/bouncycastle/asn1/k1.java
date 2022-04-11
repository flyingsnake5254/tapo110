package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;

public class k1
  extends q
  implements w
{
  private final byte[] c;
  
  public k1(byte[] paramArrayOfByte)
  {
    this.c = a.g(paramArrayOfByte);
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof k1)) {
      return false;
    }
    paramq = (k1)paramq;
    return a.c(this.c, paramq.c);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.g(21, this.c);
  }
  
  public String getString()
  {
    return i.b(this.c);
  }
  
  int h()
  {
    return y1.a(this.c.length) + 1 + this.c.length;
  }
  
  public int hashCode()
  {
    return a.w(this.c);
  }
  
  boolean j()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\k1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */