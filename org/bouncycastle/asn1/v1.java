package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

class v1
  extends r
{
  private byte[] d;
  
  v1(byte[] paramArrayOfByte)
    throws IOException
  {
    this.d = paramArrayOfByte;
  }
  
  private void s()
  {
    u1 localu1 = new u1(this.d);
    while (localu1.hasMoreElements()) {
      this.c.addElement(localu1.nextElement());
    }
    this.d = null;
  }
  
  void g(p paramp)
    throws IOException
  {
    byte[] arrayOfByte = this.d;
    if (arrayOfByte != null) {
      paramp.g(48, arrayOfByte);
    } else {
      super.l().g(paramp);
    }
  }
  
  int h()
    throws IOException
  {
    byte[] arrayOfByte = this.d;
    if (arrayOfByte != null) {
      return y1.a(arrayOfByte.length) + 1 + this.d.length;
    }
    return super.l().h();
  }
  
  q k()
  {
    if (this.d != null) {
      s();
    }
    return super.k();
  }
  
  q l()
  {
    if (this.d != null) {
      s();
    }
    return super.l();
  }
  
  public e p(int paramInt)
  {
    try
    {
      if (this.d != null) {
        s();
      }
      e locale = super.p(paramInt);
      return locale;
    }
    finally {}
  }
  
  public Enumeration q()
  {
    try
    {
      Object localObject1 = this.d;
      if (localObject1 == null)
      {
        localObject1 = super.q();
        return (Enumeration)localObject1;
      }
      localObject1 = new u1((byte[])localObject1);
      return (Enumeration)localObject1;
    }
    finally {}
  }
  
  public int size()
  {
    try
    {
      if (this.d != null) {
        s();
      }
      int i = super.size();
      return i;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\v1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */