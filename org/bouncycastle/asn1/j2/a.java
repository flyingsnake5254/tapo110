package org.bouncycastle.asn1.j2;

import java.util.Hashtable;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.p2.c;
import org.bouncycastle.asn1.p2.d;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.util.i;

public class a
{
  static final Hashtable a = new Hashtable();
  static final Hashtable b = new Hashtable();
  
  static
  {
    a("B-571", d.F);
    a("B-409", d.D);
    a("B-283", d.n);
    a("B-233", d.t);
    a("B-163", d.l);
    a("K-571", d.E);
    a("K-409", d.C);
    a("K-283", d.m);
    a("K-233", d.s);
    a("K-163", d.b);
    a("P-521", d.B);
    a("P-384", d.A);
    a("P-256", d.H);
    a("P-224", d.z);
    a("P-192", d.G);
  }
  
  static void a(String paramString, m paramm)
  {
    a.put(paramString, paramm);
    b.put(paramm, paramString);
  }
  
  public static j b(String paramString)
  {
    paramString = (m)a.get(i.j(paramString));
    if (paramString != null) {
      return c(paramString);
    }
    return null;
  }
  
  public static j c(m paramm)
  {
    return c.i(paramm);
  }
  
  public static String d(m paramm)
  {
    return (String)b.get(paramm);
  }
  
  public static m e(String paramString)
  {
    return (m)a.get(i.j(paramString));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\j2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */