package org.bouncycastle.asn1.t2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.d1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.t;

public class b
  extends l
{
  private t c;
  
  public b(m paramm, e parame)
  {
    f localf = new f();
    localf.a(paramm);
    localf.a(parame);
    this.c = new d1(new b1(localf));
  }
  
  private b(t paramt)
  {
    this.c = paramt;
  }
  
  public b(a[] paramArrayOfa)
  {
    this.c = new d1(paramArrayOfa);
  }
  
  public static b g(Object paramObject)
  {
    if ((paramObject instanceof b)) {
      return (b)paramObject;
    }
    if (paramObject != null) {
      return new b(t.n(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    return this.c;
  }
  
  public a f()
  {
    if (this.c.size() == 0) {
      return null;
    }
    return a.f(this.c.q(0));
  }
  
  public a[] h()
  {
    int i = this.c.size();
    a[] arrayOfa = new a[i];
    for (int j = 0; j != i; j++) {
      arrayOfa[j] = a.f(this.c.q(j));
    }
    return arrayOfa;
  }
  
  public boolean i()
  {
    int i = this.c.size();
    boolean bool = true;
    if (i <= 1) {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\t2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */