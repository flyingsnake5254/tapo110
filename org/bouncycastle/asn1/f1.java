package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;

public class f1
  extends q
  implements w
{
  private byte[] c;
  
  public f1(byte[] paramArrayOfByte)
  {
    this.c = a.g(paramArrayOfByte);
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof f1)) {
      return false;
    }
    return a.c(this.c, ((f1)paramq).c);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.g(20, this.c);
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
  
  public String toString()
  {
    return getString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\f1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */