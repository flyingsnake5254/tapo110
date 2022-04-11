package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.a;

public class m0
  extends q
  implements w
{
  private final char[] c;
  
  m0(char[] paramArrayOfChar)
  {
    this.c = paramArrayOfChar;
  }
  
  protected boolean f(q paramq)
  {
    if (!(paramq instanceof m0)) {
      return false;
    }
    paramq = (m0)paramq;
    return a.d(this.c, paramq.c);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.c(30);
    paramp.i(this.c.length * 2);
    for (int i = 0;; i++)
    {
      char[] arrayOfChar = this.c;
      if (i == arrayOfChar.length) {
        break;
      }
      int j = arrayOfChar[i];
      paramp.c((byte)(j >> 8));
      paramp.c((byte)j);
    }
  }
  
  public String getString()
  {
    return new String(this.c);
  }
  
  int h()
  {
    return y1.a(this.c.length * 2) + 1 + this.c.length * 2;
  }
  
  public int hashCode()
  {
    return a.x(this.c);
  }
  
  boolean j()
  {
    return false;
  }
  
  public String toString()
  {
    return getString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\m0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */