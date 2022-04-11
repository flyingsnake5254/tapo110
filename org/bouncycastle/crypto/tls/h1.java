package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.h;
import org.bouncycastle.crypto.r.a;
import org.bouncycastle.crypto.w.c0;
import org.bouncycastle.crypto.w.d0;

public class h1
{
  public static byte[] a(p0 paramp0, d0 paramd0, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[48];
    paramp0.c().nextBytes(arrayOfByte);
    m1.O0(paramp0.a(), arrayOfByte, 0);
    a locala = new a(new h());
    locala.a(true, new c0(paramd0, paramp0.c()));
    try
    {
      paramd0 = locala.d(arrayOfByte, 0, 48);
      if (m1.K(paramp0)) {
        paramOutputStream.write(paramd0);
      } else {
        m1.t0(paramd0, paramOutputStream);
      }
      return arrayOfByte;
    }
    catch (InvalidCipherTextException paramp0)
    {
      throw new TlsFatalAlert((short)80, paramp0);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\h1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */