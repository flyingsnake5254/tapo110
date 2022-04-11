package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class d0
{
  protected short a;
  protected short b;
  
  public d0(short paramShort1, short paramShort2)
  {
    if (m1.U(paramShort1))
    {
      if (m1.U(paramShort2))
      {
        if (paramShort2 != 0)
        {
          this.a = paramShort1;
          this.b = paramShort2;
          return;
        }
        throw new IllegalArgumentException("'signature' MUST NOT be \"anonymous\"");
      }
      throw new IllegalArgumentException("'signature' should be a uint8");
    }
    throw new IllegalArgumentException("'hash' should be a uint8");
  }
  
  public static d0 d(InputStream paramInputStream)
    throws IOException
  {
    return new d0(m1.j0(paramInputStream), m1.j0(paramInputStream));
  }
  
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    m1.H0(b(), paramOutputStream);
    m1.H0(c(), paramOutputStream);
  }
  
  public short b()
  {
    return this.a;
  }
  
  public short c()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof d0;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (d0)paramObject;
    bool1 = bool2;
    if (((d0)paramObject).b() == b())
    {
      bool1 = bool2;
      if (((d0)paramObject).c() == c()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return b() << 16 | c();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */