package org.bouncycastle.asn1.u2;

import java.math.BigInteger;
import org.bouncycastle.asn1.b;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class f
  extends l
{
  private n0 c;
  private j d;
  
  private f(r paramr)
  {
    if (paramr.size() == 2)
    {
      this.c = n0.s(paramr.p(0));
      this.d = j.m(paramr.p(1));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramr.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public f(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      this.c = new n0(paramArrayOfByte);
      this.d = new j(paramInt);
      return;
    }
    throw new IllegalArgumentException("'seed' cannot be null");
  }
  
  public static f f(Object paramObject)
  {
    if ((paramObject instanceof f)) {
      return (f)paramObject;
    }
    if (paramObject != null) {
      return new f(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    org.bouncycastle.asn1.f localf = new org.bouncycastle.asn1.f();
    localf.a(this.c);
    localf.a(this.d);
    return new b1(localf);
  }
  
  public BigInteger g()
  {
    return this.d.o();
  }
  
  public byte[] h()
  {
    return this.c.o();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u2\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */