package org.bouncycastle.asn1.u2;

import java.math.BigInteger;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;

public class b
  extends l
{
  private j c;
  
  private b(j paramj)
  {
    if (paramj != null)
    {
      this.c = paramj;
      return;
    }
    throw new IllegalArgumentException("'y' cannot be null");
  }
  
  public static b f(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof b)))
    {
      if ((paramObject instanceof j)) {
        return new b((j)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid DHPublicKey: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (b)paramObject;
  }
  
  public q c()
  {
    return this.c;
  }
  
  public BigInteger g()
  {
    return this.c.o();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */