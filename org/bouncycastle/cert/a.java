package org.bouncycastle.cert;

import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.q;

public class a
  implements Cloneable
{
  final q c;
  
  a(r paramr)
  {
    this.c = q.f(paramr);
  }
  
  public Object clone()
  {
    return new a((r)this.c.c());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    return this.c.equals(((a)paramObject).c);
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */