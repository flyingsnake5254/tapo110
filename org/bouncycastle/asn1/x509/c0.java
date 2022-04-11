package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;

public class c0
{
  public static final m A = new m("1.3.6.1.5.5.7.1.2");
  public static final m B = new m("1.3.6.1.5.5.7.1.3");
  public static final m C = new m("1.3.6.1.5.5.7.1.4");
  public static final m D = new m("2.5.29.56");
  public static final m E = new m("2.5.29.55");
  public static final m a = new m("2.5.29.9");
  public static final m b = new m("2.5.29.14");
  public static final m c = new m("2.5.29.15");
  public static final m d = new m("2.5.29.16");
  public static final m e = new m("2.5.29.17");
  public static final m f = new m("2.5.29.18");
  public static final m g = new m("2.5.29.19");
  public static final m h = new m("2.5.29.20");
  public static final m i = new m("2.5.29.21");
  public static final m j = new m("2.5.29.23");
  public static final m k = new m("2.5.29.24");
  public static final m l = new m("2.5.29.27");
  public static final m m = new m("2.5.29.28");
  public static final m n = new m("2.5.29.29");
  public static final m o = new m("2.5.29.30");
  public static final m p = new m("2.5.29.31");
  public static final m q = new m("2.5.29.32");
  public static final m r = new m("2.5.29.33");
  public static final m s = new m("2.5.29.35");
  public static final m t = new m("2.5.29.36");
  public static final m u = new m("2.5.29.37");
  public static final m v = new m("2.5.29.46");
  public static final m w = new m("2.5.29.54");
  public static final m x = new m("1.3.6.1.5.5.7.1.1");
  public static final m y = new m("1.3.6.1.5.5.7.1.11");
  public static final m z = new m("1.3.6.1.5.5.7.1.12");
  boolean F;
  n G;
  
  public static q a(c0 paramc0)
    throws IllegalArgumentException
  {
    try
    {
      paramc0 = q.i(paramc0.b().o());
      return paramc0;
    }
    catch (IOException paramc0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("can't convert extension: ");
      localStringBuilder.append(paramc0);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public n b()
  {
    return this.G;
  }
  
  public boolean c()
  {
    return this.F;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof c0;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (c0)paramObject;
    bool1 = bool2;
    if (((c0)paramObject).b().equals(b()))
    {
      bool1 = bool2;
      if (((c0)paramObject).c() == c()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    if (c()) {
      return b().hashCode();
    }
    return b().hashCode() ^ 0xFFFFFFFF;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */