package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.asn1.l;

public class h
{
  public static final h a = new h(new org.bouncycastle.asn1.x509.h[0]);
  protected org.bouncycastle.asn1.x509.h[] b;
  
  public h(org.bouncycastle.asn1.x509.h[] paramArrayOfh)
  {
    if (paramArrayOfh != null)
    {
      this.b = paramArrayOfh;
      return;
    }
    throw new IllegalArgumentException("'certificateList' cannot be null");
  }
  
  public static h d(InputStream paramInputStream)
    throws IOException
  {
    int i = m1.g0(paramInputStream);
    if (i == 0) {
      return a;
    }
    Object localObject = new ByteArrayInputStream(m1.Z(i, paramInputStream));
    paramInputStream = new Vector();
    while (((ByteArrayInputStream)localObject).available() > 0) {
      paramInputStream.addElement(org.bouncycastle.asn1.x509.h.g(m1.W(m1.b0((InputStream)localObject))));
    }
    localObject = new org.bouncycastle.asn1.x509.h[paramInputStream.size()];
    for (i = 0; i < paramInputStream.size(); i++) {
      localObject[i] = ((org.bouncycastle.asn1.x509.h)paramInputStream.elementAt(i));
    }
    return new h((org.bouncycastle.asn1.x509.h[])localObject);
  }
  
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    Vector localVector = new Vector(this.b.length);
    int i = 0;
    int j = 0;
    int k = 0;
    for (;;)
    {
      Object localObject = this.b;
      if (j >= localObject.length) {
        break;
      }
      localObject = localObject[j].e("DER");
      localVector.addElement(localObject);
      k += localObject.length + 3;
      j++;
    }
    m1.j(k);
    m1.C0(k, paramOutputStream);
    for (j = i; j < localVector.size(); j++) {
      m1.u0((byte[])localVector.elementAt(j), paramOutputStream);
    }
  }
  
  public org.bouncycastle.asn1.x509.h b(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public boolean c()
  {
    boolean bool;
    if (this.b.length == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */