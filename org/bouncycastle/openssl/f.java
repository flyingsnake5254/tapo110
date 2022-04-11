package org.bouncycastle.openssl;

import java.io.IOException;
import org.bouncycastle.asn1.i;
import org.bouncycastle.asn1.l;
import org.bouncycastle.cert.X509CertificateHolder;

public class f
{
  private final X509CertificateHolder a;
  private final a b;
  
  public f(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new i(paramArrayOfByte);
    this.a = new X509CertificateHolder(paramArrayOfByte.t().d());
    paramArrayOfByte = paramArrayOfByte.t();
    if (paramArrayOfByte != null) {
      this.b = new a(paramArrayOfByte.d());
    } else {
      this.b = null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\openssl\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */