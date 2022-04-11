package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.bouncycastle.util.a.a;

public abstract class t
  extends q
{
  private Vector c;
  private boolean d;
  
  protected t()
  {
    this.c = new Vector();
    this.d = false;
  }
  
  protected t(e parame)
  {
    Vector localVector = new Vector();
    this.c = localVector;
    this.d = false;
    localVector.addElement(parame);
  }
  
  protected t(f paramf, boolean paramBoolean)
  {
    this.c = new Vector();
    int i = 0;
    this.d = false;
    while (i != paramf.c())
    {
      this.c.addElement(paramf.b(i));
      i++;
    }
    if (paramBoolean) {
      t();
    }
  }
  
  protected t(e[] paramArrayOfe, boolean paramBoolean)
  {
    this.c = new Vector();
    int i = 0;
    this.d = false;
    while (i != paramArrayOfe.length)
    {
      this.c.addElement(paramArrayOfe[i]);
      i++;
    }
    if (paramBoolean) {
      t();
    }
  }
  
  private byte[] m(e parame)
  {
    try
    {
      parame = parame.c().e("DER");
      return parame;
    }
    catch (IOException parame)
    {
      throw new IllegalArgumentException("cannot encode object added to SET");
    }
  }
  
  public static t n(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof t)))
    {
      if ((paramObject instanceof u)) {
        return n(((u)paramObject).c());
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = n(q.i((byte[])paramObject));
          return (t)paramObject;
        }
        catch (IOException localIOException)
        {
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("failed to construct set from byte[]: ");
          ((StringBuilder)paramObject).append(localIOException.getMessage());
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        }
      }
      if ((paramObject instanceof e))
      {
        localObject = ((e)paramObject).c();
        if ((localObject instanceof t)) {
          return (t)localObject;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unknown object in getInstance: ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return (t)paramObject;
  }
  
  public static t o(x paramx, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramx.q()) {
        return (t)paramx.o();
      }
      throw new IllegalArgumentException("object implicit - explicit expected.");
    }
    Object localObject = paramx.o();
    if (paramx.q())
    {
      if ((paramx instanceof i0)) {
        return new g0((e)localObject);
      }
      return new p1((e)localObject);
    }
    if ((localObject instanceof t)) {
      return (t)localObject;
    }
    if ((localObject instanceof r))
    {
      localObject = (r)localObject;
      if ((paramx instanceof i0)) {
        return new g0(((r)localObject).r());
      }
      return new p1(((r)localObject).r());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown object in getInstance: ");
    ((StringBuilder)localObject).append(paramx.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private e p(Enumeration paramEnumeration)
  {
    e locale = (e)paramEnumeration.nextElement();
    paramEnumeration = locale;
    if (locale == null) {
      paramEnumeration = v0.c;
    }
    return paramEnumeration;
  }
  
  private boolean s(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
    boolean bool1 = false;
    boolean bool2 = false;
    for (int j = 0; j != i; j++) {
      if (paramArrayOfByte1[j] != paramArrayOfByte2[j])
      {
        if ((paramArrayOfByte1[j] & 0xFF) < (paramArrayOfByte2[j] & 0xFF)) {
          bool2 = true;
        }
        return bool2;
      }
    }
    bool2 = bool1;
    if (i == paramArrayOfByte1.length) {
      bool2 = true;
    }
    return bool2;
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof t)) {
      return false;
    }
    Object localObject1 = (t)paramq;
    if (size() != ((t)localObject1).size()) {
      return false;
    }
    paramq = r();
    localObject1 = ((t)localObject1).r();
    while (paramq.hasMoreElements())
    {
      Object localObject2 = p(paramq);
      Object localObject3 = p((Enumeration)localObject1);
      localObject2 = ((e)localObject2).c();
      localObject3 = ((e)localObject3).c();
      if ((localObject2 != localObject3) && (!((q)localObject2).equals(localObject3))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Enumeration localEnumeration = r();
    for (int i = size(); localEnumeration.hasMoreElements(); i = i * 17 ^ p(localEnumeration).hashCode()) {}
    return i;
  }
  
  public Iterator<e> iterator()
  {
    return new a.a(u());
  }
  
  boolean j()
  {
    return true;
  }
  
  q k()
  {
    if (this.d)
    {
      locald1 = new d1();
      locald1.c = this.c;
      return locald1;
    }
    Vector localVector = new Vector();
    for (int i = 0; i != this.c.size(); i++) {
      localVector.addElement(this.c.elementAt(i));
    }
    d1 locald1 = new d1();
    locald1.c = localVector;
    locald1.t();
    return locald1;
  }
  
  q l()
  {
    p1 localp1 = new p1();
    localp1.c = this.c;
    return localp1;
  }
  
  public e q(int paramInt)
  {
    return (e)this.c.elementAt(paramInt);
  }
  
  public Enumeration r()
  {
    return this.c.elements();
  }
  
  public int size()
  {
    return this.c.size();
  }
  
  protected void t()
  {
    if (!this.d)
    {
      this.d = true;
      if (this.c.size() > 1)
      {
        int i = this.c.size() - 1;
        int j = 1;
        while (j != 0)
        {
          Object localObject1 = this.c;
          int k = 0;
          localObject1 = m((e)((Vector)localObject1).elementAt(0));
          j = 0;
          int n;
          for (int m = 0; m != i; m = n)
          {
            Object localObject2 = this.c;
            n = m + 1;
            localObject2 = m((e)((Vector)localObject2).elementAt(n));
            if (s((byte[])localObject1, (byte[])localObject2))
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject2 = this.c.elementAt(m);
              Vector localVector = this.c;
              localVector.setElementAt(localVector.elementAt(n), m);
              this.c.setElementAt(localObject2, n);
              k = m;
              j = 1;
            }
          }
          i = k;
        }
      }
    }
  }
  
  public String toString()
  {
    return this.c.toString();
  }
  
  public e[] u()
  {
    e[] arrayOfe = new e[size()];
    for (int i = 0; i != size(); i++) {
      arrayOfe[i] = q(i);
    }
    return arrayOfe;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */