package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;

public class t
  extends org.bouncycastle.asn1.l
{
  private n0 c;
  
  private t(n0 paramn0)
  {
    this.c = paramn0;
  }
  
  public static t f(m paramm)
  {
    return h(paramm.j(l.f));
  }
  
  public static t h(Object paramObject)
  {
    if ((paramObject instanceof t)) {
      return (t)paramObject;
    }
    if (paramObject != null) {
      return new t(n0.s(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    return this.c;
  }
  
  public byte[] g()
  {
    return this.c.o();
  }
  
  public String toString()
  {
    byte[] arrayOfByte = this.c.o();
    StringBuilder localStringBuilder;
    if (arrayOfByte.length == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyUsage: 0x");
    }
    for (int i = arrayOfByte[0] & 0xFF;; i = arrayOfByte[0] & 0xFF | (i & 0xFF) << 8)
    {
      localStringBuilder.append(Integer.toHexString(i));
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyUsage: 0x");
      i = arrayOfByte[1];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */