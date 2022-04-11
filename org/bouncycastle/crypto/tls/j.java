package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.l2.a;

public class j
{
  protected short a;
  protected Object b;
  
  public j(short paramShort, Object paramObject)
  {
    if (a(paramShort, paramObject))
    {
      this.a = paramShort;
      this.b = paramObject;
      return;
    }
    throw new IllegalArgumentException("'response' is not an instance of the correct type");
  }
  
  protected static boolean a(short paramShort, Object paramObject)
  {
    if (paramShort == 1) {
      return paramObject instanceof a;
    }
    throw new IllegalArgumentException("'statusType' is an unsupported CertificateStatusType");
  }
  
  public static j b(InputStream paramInputStream)
    throws IOException
  {
    short s = m1.j0(paramInputStream);
    if (s == 1) {
      return new j(s, a.f(m1.Y(m1.b0(paramInputStream))));
    }
    throw new TlsFatalAlert((short)50);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */