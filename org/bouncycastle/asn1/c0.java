package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class c0
  extends n
{
  private final int d;
  private final n[] f;
  
  public c0(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 1000);
  }
  
  public c0(byte[] paramArrayOfByte, int paramInt)
  {
    this(paramArrayOfByte, null, paramInt);
  }
  
  private c0(byte[] paramArrayOfByte, n[] paramArrayOfn, int paramInt)
  {
    super(paramArrayOfByte);
    this.f = paramArrayOfn;
    this.d = paramInt;
  }
  
  public c0(n[] paramArrayOfn)
  {
    this(paramArrayOfn, 1000);
  }
  
  public c0(n[] paramArrayOfn, int paramInt)
  {
    this(t(paramArrayOfn), paramArrayOfn, paramInt);
  }
  
  static c0 q(r paramr)
  {
    n[] arrayOfn = new n[paramr.size()];
    paramr = paramr.q();
    for (int i = 0; paramr.hasMoreElements(); i++) {
      arrayOfn[i] = ((n)paramr.nextElement());
    }
    return new c0(arrayOfn);
  }
  
  private Vector r()
  {
    Vector localVector = new Vector();
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte1 = this.c;
      if (i >= arrayOfByte1.length) {
        break;
      }
      int j = this.d;
      if (i + j > arrayOfByte1.length) {
        j = arrayOfByte1.length;
      } else {
        j += i;
      }
      j -= i;
      byte[] arrayOfByte2 = new byte[j];
      System.arraycopy(arrayOfByte1, i, arrayOfByte2, 0, j);
      localVector.addElement(new x0(arrayOfByte2));
      i += this.d;
    }
    return localVector;
  }
  
  private static byte[] t(n[] paramArrayOfn)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    StringBuilder localStringBuilder;
    while (i != paramArrayOfn.length) {
      try
      {
        localByteArrayOutputStream.write(((x0)paramArrayOfn[i]).o());
        i++;
      }
      catch (IOException localIOException)
      {
        paramArrayOfn = new StringBuilder();
        paramArrayOfn.append("exception converting octets ");
        paramArrayOfn.append(localIOException.toString());
        throw new IllegalArgumentException(paramArrayOfn.toString());
      }
      catch (ClassCastException localClassCastException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramArrayOfn[i].getClass().getName());
        localStringBuilder.append(" found in input should only contain DEROctetString");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    return localStringBuilder.toByteArray();
  }
  
  public void g(p paramp)
    throws IOException
  {
    paramp.c(36);
    paramp.c(128);
    Enumeration localEnumeration = s();
    while (localEnumeration.hasMoreElements()) {
      paramp.j((e)localEnumeration.nextElement());
    }
    paramp.c(0);
    paramp.c(0);
  }
  
  int h()
    throws IOException
  {
    Enumeration localEnumeration = s();
    int i = 0;
    while (localEnumeration.hasMoreElements()) {
      i += ((e)localEnumeration.nextElement()).c().h();
    }
    return i + 2 + 2;
  }
  
  boolean j()
  {
    return true;
  }
  
  public byte[] o()
  {
    return this.c;
  }
  
  public Enumeration s()
  {
    if (this.f == null) {
      return r().elements();
    }
    return new a();
  }
  
  class a
    implements Enumeration
  {
    int a = 0;
    
    a() {}
    
    public boolean hasMoreElements()
    {
      boolean bool;
      if (this.a < c0.p(c0.this).length) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Object nextElement()
    {
      n[] arrayOfn = c0.p(c0.this);
      int i = this.a;
      this.a = (i + 1);
      return arrayOfn[i];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */