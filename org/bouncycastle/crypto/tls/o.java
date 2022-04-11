package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.crypto.g;
import org.bouncycastle.util.h;

class o
  implements v0
{
  protected p0 a;
  private p b;
  private Hashtable c;
  private Short d;
  
  o()
  {
    this.b = new p();
    this.c = new Hashtable();
    this.d = null;
  }
  
  private o(Short paramShort, g paramg)
  {
    this.b = null;
    Hashtable localHashtable = new Hashtable();
    this.c = localHashtable;
    this.d = paramShort;
    localHashtable.put(paramShort, paramg);
  }
  
  public void a(p0 paramp0)
  {
    this.a = paramp0;
  }
  
  public String b()
  {
    throw new IllegalStateException("Use fork() to get a definite Digest");
  }
  
  public void c(byte paramByte)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((ByteArrayOutputStream)localObject).write(paramByte);
      return;
    }
    localObject = this.c.elements();
    while (((Enumeration)localObject).hasMoreElements()) {
      ((g)((Enumeration)localObject).nextElement()).c(paramByte);
    }
  }
  
  public v0 d()
  {
    g localg = m1.l(this.d.shortValue(), (g)this.c.get(this.d));
    Object localObject = this.b;
    if (localObject != null) {
      ((p)localObject).a(localg);
    }
    localObject = new o(this.d, localg);
    ((o)localObject).a(this.a);
    return (v0)localObject;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    throw new IllegalStateException("Use fork() to get a definite Digest");
  }
  
  public int e()
  {
    throw new IllegalStateException("Use fork() to get a definite Digest");
  }
  
  public g f()
  {
    m();
    if (this.b != null)
    {
      g localg = m1.n(this.d.shortValue());
      this.b.a(localg);
      return localg;
    }
    return m1.l(this.d.shortValue(), (g)this.c.get(this.d));
  }
  
  public v0 g()
  {
    int i = this.a.e().g();
    if (i == 0)
    {
      localObject = new m();
      ((m)localObject).a(this.a);
      this.b.a((g)localObject);
      return ((m)localObject).g();
    }
    Object localObject = h.a(m1.C(i));
    this.d = ((Short)localObject);
    n((Short)localObject);
    return this;
  }
  
  public void h(short paramShort)
  {
    if (this.b != null)
    {
      n(h.a(paramShort));
      return;
    }
    throw new IllegalStateException("Too late to track more hash algorithms");
  }
  
  public byte[] i(short paramShort)
  {
    Object localObject1 = (g)this.c.get(h.a(paramShort));
    if (localObject1 != null)
    {
      localObject1 = m1.l(paramShort, (g)localObject1);
      Object localObject2 = this.b;
      if (localObject2 != null) {
        ((p)localObject2).a((g)localObject1);
      }
      localObject2 = new byte[((g)localObject1).e()];
      ((g)localObject1).doFinal((byte[])localObject2, 0);
      return (byte[])localObject2;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("HashAlgorithm.");
    ((StringBuilder)localObject1).append(s.b(paramShort));
    ((StringBuilder)localObject1).append(" is not being tracked");
    throw new IllegalStateException(((StringBuilder)localObject1).toString());
  }
  
  public void l()
  {
    m();
  }
  
  protected void m()
  {
    if ((this.b != null) && (this.c.size() <= 4))
    {
      Enumeration localEnumeration = this.c.elements();
      while (localEnumeration.hasMoreElements())
      {
        g localg = (g)localEnumeration.nextElement();
        this.b.a(localg);
      }
      this.b = null;
    }
  }
  
  protected void n(Short paramShort)
  {
    if (!this.c.containsKey(paramShort))
    {
      g localg = m1.n(paramShort.shortValue());
      this.c.put(paramShort, localg);
    }
  }
  
  public void reset()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((ByteArrayOutputStream)localObject).reset();
      return;
    }
    localObject = this.c.elements();
    while (((Enumeration)localObject).hasMoreElements()) {
      ((g)((Enumeration)localObject).nextElement()).reset();
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((ByteArrayOutputStream)localObject).write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    localObject = this.c.elements();
    while (((Enumeration)localObject).hasMoreElements()) {
      ((g)((Enumeration)localObject).nextElement()).update(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */