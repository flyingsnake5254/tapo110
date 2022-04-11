package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.a;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.f;
import org.bouncycastle.crypto.w.c0;
import org.bouncycastle.crypto.w.d0;
import org.bouncycastle.crypto.w.e0;
import org.bouncycastle.util.b;

public class h
  implements a
{
  private static final BigInteger a = BigInteger.valueOf(1L);
  private i b = new i();
  private d0 c;
  private SecureRandom d;
  
  public void a(boolean paramBoolean, e parame)
  {
    this.b.e(paramBoolean, parame);
    if ((parame instanceof c0))
    {
      parame = (c0)parame;
      this.c = ((d0)parame.a());
      parame = parame.b();
    }
    else
    {
      this.c = ((d0)parame);
      parame = f.b();
    }
    this.d = parame;
  }
  
  public int b()
  {
    return this.b.d();
  }
  
  public int c()
  {
    return this.b.c();
  }
  
  public byte[] d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.c != null)
    {
      BigInteger localBigInteger1 = this.b.a(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = this.c;
      if ((paramArrayOfByte instanceof e0))
      {
        paramArrayOfByte = (e0)paramArrayOfByte;
        BigInteger localBigInteger2 = paramArrayOfByte.h();
        if (localBigInteger2 != null)
        {
          BigInteger localBigInteger3 = paramArrayOfByte.c();
          paramArrayOfByte = a;
          BigInteger localBigInteger4 = b.c(paramArrayOfByte, localBigInteger3.subtract(paramArrayOfByte), this.d);
          paramArrayOfByte = localBigInteger4.modPow(localBigInteger2, localBigInteger3).multiply(localBigInteger1).mod(localBigInteger3);
          paramArrayOfByte = this.b.f(paramArrayOfByte).multiply(localBigInteger4.modInverse(localBigInteger3)).mod(localBigInteger3);
          if (localBigInteger1.equals(paramArrayOfByte.modPow(localBigInteger2, localBigInteger3))) {
            break label156;
          }
          throw new IllegalStateException("RSA engine faulty decryption/signing detected");
        }
      }
      paramArrayOfByte = this.b.f(localBigInteger1);
      label156:
      return this.b.b(paramArrayOfByte);
    }
    throw new IllegalStateException("RSA engine not initialised");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\engines\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */