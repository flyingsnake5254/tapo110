package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.i;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.p;
import org.bouncycastle.jce.interfaces.b;

public class d
  implements b
{
  private Hashtable c;
  private Vector d;
  
  public d()
  {
    this(new Hashtable(), new Vector());
  }
  
  d(Hashtable paramHashtable, Vector paramVector)
  {
    this.c = paramHashtable;
    this.d = paramVector;
  }
  
  public void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    Object localObject = paramObjectInputStream.readObject();
    if ((localObject instanceof Hashtable))
    {
      this.c = ((Hashtable)localObject);
      this.d = ((Vector)paramObjectInputStream.readObject());
    }
    else
    {
      localObject = new i((byte[])localObject);
      for (;;)
      {
        paramObjectInputStream = (m)((i)localObject).t();
        if (paramObjectInputStream == null) {
          break;
        }
        setBagAttribute(paramObjectInputStream, ((i)localObject).t());
      }
    }
  }
  
  public void b(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    if (this.d.size() == 0)
    {
      paramObjectOutputStream.writeObject(new Hashtable());
      paramObjectOutputStream.writeObject(new Vector());
    }
    else
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      p localp = new p(localByteArrayOutputStream);
      Enumeration localEnumeration = getBagAttributeKeys();
      while (localEnumeration.hasMoreElements())
      {
        m localm = (m)localEnumeration.nextElement();
        localp.j(localm);
        localp.j((e)this.c.get(localm));
      }
      paramObjectOutputStream.writeObject(localByteArrayOutputStream.toByteArray());
    }
  }
  
  public e getBagAttribute(m paramm)
  {
    return (e)this.c.get(paramm);
  }
  
  public Enumeration getBagAttributeKeys()
  {
    return this.d.elements();
  }
  
  public void setBagAttribute(m paramm, e parame)
  {
    if (this.c.containsKey(paramm))
    {
      this.c.put(paramm, parame);
    }
    else
    {
      this.c.put(paramm, parame);
      this.d.addElement(paramm);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */