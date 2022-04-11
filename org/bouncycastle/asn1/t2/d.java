package org.bouncycastle.asn1.t2;

import java.util.Vector;
import org.bouncycastle.asn1.m;

public class d
{
  private e a;
  private Vector b = new Vector();
  
  public d(e parame)
  {
    this.a = parame;
  }
  
  public d a(m[] paramArrayOfm, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    org.bouncycastle.asn1.e[] arrayOfe = new org.bouncycastle.asn1.e[i];
    for (int j = 0; j != i; j++) {
      arrayOfe[j] = this.a.e(paramArrayOfm[j], paramArrayOfString[j]);
    }
    return b(paramArrayOfm, arrayOfe);
  }
  
  public d b(m[] paramArrayOfm, org.bouncycastle.asn1.e[] paramArrayOfe)
  {
    a[] arrayOfa = new a[paramArrayOfm.length];
    for (int i = 0; i != paramArrayOfm.length; i++) {
      arrayOfa[i] = new a(paramArrayOfm[i], paramArrayOfe[i]);
    }
    return c(arrayOfa);
  }
  
  public d c(a[] paramArrayOfa)
  {
    this.b.addElement(new b(paramArrayOfa));
    return this;
  }
  
  public d d(m paramm, String paramString)
  {
    e(paramm, this.a.e(paramm, paramString));
    return this;
  }
  
  public d e(m paramm, org.bouncycastle.asn1.e parame)
  {
    this.b.addElement(new b(paramm, parame));
    return this;
  }
  
  public c f()
  {
    int i = this.b.size();
    b[] arrayOfb = new b[i];
    for (int j = 0; j != i; j++) {
      arrayOfb[j] = ((b)this.b.elementAt(j));
    }
    return new c(this.a, arrayOfb);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\t2\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */