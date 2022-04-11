package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.a;

public class j1
  extends q
  implements w
{
  private static final char[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final byte[] d;
  
  public j1(byte[] paramArrayOfByte)
  {
    this.d = a.g(paramArrayOfByte);
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof j1)) {
      return false;
    }
    return a.c(this.d, ((j1)paramq).d);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.g(28, m());
  }
  
  public String getString()
  {
    StringBuffer localStringBuffer = new StringBuffer("#");
    Object localObject1 = new ByteArrayOutputStream();
    Object localObject2 = new p((OutputStream)localObject1);
    try
    {
      ((p)localObject2).j(this);
      localObject2 = ((ByteArrayOutputStream)localObject1).toByteArray();
      for (int i = 0; i != localObject2.length; i++)
      {
        localObject1 = c;
        localStringBuffer.append(localObject1[(localObject2[i] >>> 4 & 0xF)]);
        localStringBuffer.append(localObject1[(localObject2[i] & 0xF)]);
      }
      return localStringBuffer.toString();
    }
    catch (IOException localIOException)
    {
      throw new ASN1ParsingException("internal error encoding UniversalString");
    }
  }
  
  int h()
  {
    return y1.a(this.d.length) + 1 + this.d.length;
  }
  
  public int hashCode()
  {
    return a.w(this.d);
  }
  
  boolean j()
  {
    return false;
  }
  
  public byte[] m()
  {
    return a.g(this.d);
  }
  
  public String toString()
  {
    return getString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\j1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */