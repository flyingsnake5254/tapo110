package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.b;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class w
  extends l
{
  private a c;
  private n0 d;
  
  public w(r paramr)
  {
    if (paramr.size() == 2)
    {
      paramr = paramr.q();
      this.c = a.g(paramr.nextElement());
      this.d = n0.s(paramr.nextElement());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramr.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public w(a parama, e parame)
    throws IOException
  {
    this.d = new n0(parame);
    this.c = parama;
  }
  
  public w(a parama, byte[] paramArrayOfByte)
  {
    this.d = new n0(paramArrayOfByte);
    this.c = parama;
  }
  
  public static w h(Object paramObject)
  {
    if ((paramObject instanceof w)) {
      return (w)paramObject;
    }
    if (paramObject != null) {
      return new w(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    return new b1(localf);
  }
  
  public a f()
  {
    return this.c;
  }
  
  public a g()
  {
    return this.c;
  }
  
  public n0 i()
  {
    return this.d;
  }
  
  public q j()
    throws IOException
  {
    return q.i(this.d.p());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */