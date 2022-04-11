package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.bouncycastle.util.a.a;

public abstract class r
  extends q
{
  protected Vector c;
  
  protected r()
  {
    this.c = new Vector();
  }
  
  protected r(e parame)
  {
    Vector localVector = new Vector();
    this.c = localVector;
    localVector.addElement(parame);
  }
  
  protected r(f paramf)
  {
    this.c = new Vector();
    for (int i = 0; i != paramf.c(); i++) {
      this.c.addElement(paramf.b(i));
    }
  }
  
  protected r(e[] paramArrayOfe)
  {
    this.c = new Vector();
    for (int i = 0; i != paramArrayOfe.length; i++) {
      this.c.addElement(paramArrayOfe[i]);
    }
  }
  
  public static r m(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof r)))
    {
      if ((paramObject instanceof s)) {
        return m(((s)paramObject).c());
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = m(q.i((byte[])paramObject));
          return (r)paramObject;
        }
        catch (IOException localIOException)
        {
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("failed to construct sequence from byte[]: ");
          ((StringBuilder)paramObject).append(localIOException.getMessage());
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        }
      }
      if ((paramObject instanceof e))
      {
        localObject = ((e)paramObject).c();
        if ((localObject instanceof r)) {
          return (r)localObject;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unknown object in getInstance: ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return (r)paramObject;
  }
  
  public static r n(x paramx, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramx.q()) {
        return m(paramx.o().c());
      }
      throw new IllegalArgumentException("object implicit - explicit expected.");
    }
    Object localObject = paramx.o();
    if (paramx.q())
    {
      if ((paramx instanceof i0)) {
        return new e0((e)localObject);
      }
      return new o1((e)localObject);
    }
    if ((localObject instanceof r)) {
      return (r)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown object in getInstance: ");
    ((StringBuilder)localObject).append(paramx.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private e o(Enumeration paramEnumeration)
  {
    return (e)paramEnumeration.nextElement();
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof r)) {
      return false;
    }
    Object localObject1 = (r)paramq;
    if (size() != ((r)localObject1).size()) {
      return false;
    }
    paramq = q();
    localObject1 = ((r)localObject1).q();
    while (paramq.hasMoreElements())
    {
      Object localObject2 = o(paramq);
      Object localObject3 = o((Enumeration)localObject1);
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
    Enumeration localEnumeration = q();
    for (int i = size(); localEnumeration.hasMoreElements(); i = i * 17 ^ o(localEnumeration).hashCode()) {}
    return i;
  }
  
  public Iterator<e> iterator()
  {
    return new a.a(r());
  }
  
  boolean j()
  {
    return true;
  }
  
  q k()
  {
    b1 localb1 = new b1();
    localb1.c = this.c;
    return localb1;
  }
  
  q l()
  {
    o1 localo1 = new o1();
    localo1.c = this.c;
    return localo1;
  }
  
  public e p(int paramInt)
  {
    return (e)this.c.elementAt(paramInt);
  }
  
  public Enumeration q()
  {
    return this.c.elements();
  }
  
  public e[] r()
  {
    e[] arrayOfe = new e[size()];
    for (int i = 0; i != size(); i++) {
      arrayOfe[i] = p(i);
    }
    return arrayOfe;
  }
  
  public int size()
  {
    return this.c.size();
  }
  
  public String toString()
  {
    return this.c.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */