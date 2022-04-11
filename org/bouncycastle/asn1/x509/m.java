package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class m
  extends org.bouncycastle.asn1.l
{
  private Hashtable c = new Hashtable();
  private Vector d = new Vector();
  
  private m(r paramr)
  {
    Object localObject = paramr.q();
    while (((Enumeration)localObject).hasMoreElements())
    {
      paramr = l.i(((Enumeration)localObject).nextElement());
      if (!this.c.containsKey(paramr.g()))
      {
        this.c.put(paramr.g(), paramr);
        this.d.addElement(paramr.g());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("repeated extension found: ");
        ((StringBuilder)localObject).append(paramr.g());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
  }
  
  public m(l[] paramArrayOfl)
  {
    for (int i = 0; i != paramArrayOfl.length; i++)
    {
      l locall = paramArrayOfl[i];
      this.d.addElement(locall.g());
      this.c.put(locall.g(), locall);
    }
  }
  
  private org.bouncycastle.asn1.m[] i(boolean paramBoolean)
  {
    Vector localVector = new Vector();
    for (int i = 0; i != this.d.size(); i++)
    {
      Object localObject = this.d.elementAt(i);
      if (((l)this.c.get(localObject)).k() == paramBoolean) {
        localVector.addElement(localObject);
      }
    }
    return n(localVector);
  }
  
  public static m k(Object paramObject)
  {
    if ((paramObject instanceof m)) {
      return (m)paramObject;
    }
    if (paramObject != null) {
      return new m(r.m(paramObject));
    }
    return null;
  }
  
  private org.bouncycastle.asn1.m[] n(Vector paramVector)
  {
    int i = paramVector.size();
    org.bouncycastle.asn1.m[] arrayOfm = new org.bouncycastle.asn1.m[i];
    for (int j = 0; j != i; j++) {
      arrayOfm[j] = ((org.bouncycastle.asn1.m)paramVector.elementAt(j));
    }
    return arrayOfm;
  }
  
  public q c()
  {
    f localf = new f();
    Enumeration localEnumeration = this.d.elements();
    while (localEnumeration.hasMoreElements())
    {
      org.bouncycastle.asn1.m localm = (org.bouncycastle.asn1.m)localEnumeration.nextElement();
      localf.a((l)this.c.get(localm));
    }
    return new b1(localf);
  }
  
  public org.bouncycastle.asn1.m[] f()
  {
    return i(true);
  }
  
  public l g(org.bouncycastle.asn1.m paramm)
  {
    return (l)this.c.get(paramm);
  }
  
  public org.bouncycastle.asn1.m[] h()
  {
    return n(this.d);
  }
  
  public e j(org.bouncycastle.asn1.m paramm)
  {
    paramm = g(paramm);
    if (paramm != null) {
      return paramm.j();
    }
    return null;
  }
  
  public org.bouncycastle.asn1.m[] l()
  {
    return i(false);
  }
  
  public Enumeration m()
  {
    return this.d.elements();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */