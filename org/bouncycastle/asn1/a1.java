package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;

public class a1
  extends q
  implements w
{
  private final byte[] c;
  
  public a1(String paramString)
  {
    this(paramString, false);
  }
  
  public a1(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (!m(paramString))) {
      throw new IllegalArgumentException("string contains illegal characters");
    }
    this.c = i.e(paramString);
  }
  
  a1(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  public static boolean m(String paramString)
  {
    for (int i = paramString.length() - 1; i >= 0; i--)
    {
      int j = paramString.charAt(i);
      if (j > 127) {
        return false;
      }
      if (((97 > j) || (j > 122)) && ((65 > j) || (j > 90)) && ((48 > j) || (j > 57)) && (j != 32) && (j != 58) && (j != 61) && (j != 63)) {
        switch (j)
        {
        default: 
          switch (j)
          {
          default: 
            return false;
          }
          break;
        }
      }
    }
    return true;
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof a1)) {
      return false;
    }
    paramq = (a1)paramq;
    return a.c(this.c, paramq.c);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.g(19, this.c);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\a1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */