package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.d;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t2.c;
import org.bouncycastle.asn1.u0;
import org.bouncycastle.asn1.x;

public class o
  extends l
  implements d
{
  private e c;
  private int d;
  
  public o(int paramInt, e parame)
  {
    this.c = parame;
    this.d = paramInt;
  }
  
  public o(c paramc)
  {
    this.c = paramc;
    this.d = 4;
  }
  
  public static o f(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof o)))
    {
      if ((paramObject instanceof x))
      {
        localObject = (x)paramObject;
        int i = ((x)localObject).p();
        switch (i)
        {
        default: 
          break;
        case 8: 
          return new o(i, m.s((x)localObject, false));
        case 7: 
          return new o(i, n.n((x)localObject, false));
        case 6: 
          return new o(i, u0.n((x)localObject, false));
        case 5: 
          return new o(i, r.n((x)localObject, false));
        case 4: 
          return new o(i, c.g((x)localObject, true));
        case 3: 
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("unknown tag: ");
          ((StringBuilder)paramObject).append(i);
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        case 2: 
          return new o(i, u0.n((x)localObject, false));
        case 1: 
          return new o(i, u0.n((x)localObject, false));
        case 0: 
          return new o(i, r.n((x)localObject, false));
        }
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = f(q.i((byte[])paramObject));
          return (o)paramObject;
        }
        catch (IOException paramObject)
        {
          throw new IllegalArgumentException("unable to parse encoded general name");
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unknown object in getInstance: ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return (o)paramObject;
  }
  
  public q c()
  {
    if (this.d == 4) {
      return new g1(true, this.d, this.c);
    }
    return new g1(false, this.d, this.c);
  }
  
  public e g()
  {
    return this.c;
  }
  
  public int h()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.d);
    localStringBuffer.append(": ");
    int i = this.d;
    if ((i != 1) && (i != 2)) {
      if (i != 4)
      {
        if (i != 6)
        {
          str = this.c.toString();
          break label86;
        }
      }
      else
      {
        str = c.f(this.c).toString();
        break label86;
      }
    }
    String str = u0.m(this.c).getString();
    label86:
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */