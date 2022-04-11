package org.bouncycastle.cert;

import org.bouncycastle.asn1.e;

public class b
  implements Cloneable
{
  final e c;
  
  public b(org.bouncycastle.asn1.x509.b paramb)
  {
    this.c = paramb.g();
  }
  
  public Object clone()
  {
    return new b(org.bouncycastle.asn1.x509.b.f(this.c));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return false;
    }
    paramObject = (b)paramObject;
    return this.c.equals(((b)paramObject).c);
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */