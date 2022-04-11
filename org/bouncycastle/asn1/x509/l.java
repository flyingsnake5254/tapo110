package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.c;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class l
  extends org.bouncycastle.asn1.l
{
  public static final m H3 = new m("2.5.29.27").t();
  public static final m I3 = new m("2.5.29.28").t();
  public static final m J3 = new m("2.5.29.29").t();
  public static final m K3 = new m("2.5.29.30").t();
  public static final m L3 = new m("2.5.29.31").t();
  public static final m M3 = new m("2.5.29.32").t();
  public static final m N3 = new m("2.5.29.33").t();
  public static final m O3 = new m("2.5.29.35").t();
  public static final m P3 = new m("2.5.29.36").t();
  public static final m Q3 = new m("2.5.29.37").t();
  public static final m R3 = new m("2.5.29.46").t();
  public static final m S3 = new m("2.5.29.54").t();
  public static final m T3 = new m("1.3.6.1.5.5.7.1.1").t();
  public static final m U3 = new m("1.3.6.1.5.5.7.1.11").t();
  public static final m V3 = new m("1.3.6.1.5.5.7.1.12").t();
  public static final m W3 = new m("1.3.6.1.5.5.7.1.2").t();
  public static final m X3 = new m("1.3.6.1.5.5.7.1.3").t();
  public static final m Y3 = new m("1.3.6.1.5.5.7.1.4").t();
  public static final m Z3 = new m("2.5.29.56").t();
  public static final m a4 = new m("2.5.29.55").t();
  public static final m b4 = new m("2.5.29.60").t();
  public static final m c = new m("2.5.29.9").t();
  public static final m d = new m("2.5.29.14").t();
  public static final m f = new m("2.5.29.15").t();
  public static final m p0;
  public static final m p1;
  public static final m p2;
  public static final m p3;
  public static final m q = new m("2.5.29.16").t();
  public static final m x = new m("2.5.29.17").t();
  public static final m y = new m("2.5.29.18").t();
  public static final m z = new m("2.5.29.19").t();
  private m c4;
  private boolean d4;
  private n e4;
  
  static
  {
    p0 = new m("2.5.29.20").t();
    p1 = new m("2.5.29.21").t();
    p2 = new m("2.5.29.23").t();
    p3 = new m("2.5.29.24").t();
  }
  
  private l(r paramr)
  {
    if (paramr.size() == 2)
    {
      this.c4 = m.r(paramr.p(0));
      this.d4 = false;
    }
    for (paramr = paramr.p(1);; paramr = paramr.p(2))
    {
      this.e4 = n.m(paramr);
      break;
      if (paramr.size() != 3) {
        break label91;
      }
      this.c4 = m.r(paramr.p(0));
      this.d4 = c.n(paramr.p(1)).q();
    }
    return;
    label91:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramr.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static q f(l paraml)
    throws IllegalArgumentException
  {
    try
    {
      paraml = q.i(paraml.h().o());
      return paraml;
    }
    catch (IOException localIOException)
    {
      paraml = new StringBuilder();
      paraml.append("can't convert extension: ");
      paraml.append(localIOException);
      throw new IllegalArgumentException(paraml.toString());
    }
  }
  
  public static l i(Object paramObject)
  {
    if ((paramObject instanceof l)) {
      return (l)paramObject;
    }
    if (paramObject != null) {
      return new l(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c4);
    if (this.d4) {
      localf.a(c.p(true));
    }
    localf.a(this.e4);
    return new b1(localf);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof l;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (l)paramObject;
    bool1 = bool2;
    if (((l)paramObject).g().equals(g()))
    {
      bool1 = bool2;
      if (((l)paramObject).h().equals(h()))
      {
        bool1 = bool2;
        if (((l)paramObject).k() == k()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public m g()
  {
    return this.c4;
  }
  
  public n h()
  {
    return this.e4;
  }
  
  public int hashCode()
  {
    if (k()) {
      return h().hashCode() ^ g().hashCode();
    }
    return h().hashCode() ^ g().hashCode() ^ 0xFFFFFFFF;
  }
  
  public e j()
  {
    return f(this);
  }
  
  public boolean k()
  {
    return this.d4;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */