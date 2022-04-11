package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import org.bouncycastle.asn1.t2.c;

public class i
{
  protected short[] a;
  protected Vector b;
  protected Vector c;
  
  public i(short[] paramArrayOfShort, Vector paramVector1, Vector paramVector2)
  {
    this.a = paramArrayOfShort;
    this.b = paramVector1;
    this.c = paramVector2;
  }
  
  public static i b(p0 paramp0, InputStream paramInputStream)
    throws IOException
  {
    int i = m1.j0(paramInputStream);
    short[] arrayOfShort = new short[i];
    for (int j = 0; j < i; j++) {
      arrayOfShort[j] = m1.j0(paramInputStream);
    }
    Vector localVector = null;
    if (m1.P(paramp0)) {
      localVector = m1.V(false, paramInputStream);
    }
    paramp0 = new Vector();
    paramInputStream = new ByteArrayInputStream(m1.a0(paramInputStream));
    while (paramInputStream.available() > 0) {
      paramp0.addElement(c.f(m1.Y(m1.a0(paramInputStream))));
    }
    return new i(arrayOfShort, localVector, paramp0);
  }
  
  public Vector a()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */