package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

final class k
{
  private final byte[][] a;
  
  protected k(j paramj, byte[][] paramArrayOfByte)
  {
    Objects.requireNonNull(paramj, "params == null");
    Objects.requireNonNull(paramArrayOfByte, "publicKey == null");
    if (!u.k(paramArrayOfByte))
    {
      if (paramArrayOfByte.length == paramj.c())
      {
        int i = 0;
        while (i < paramArrayOfByte.length) {
          if (paramArrayOfByte[i].length == paramj.b()) {
            i++;
          } else {
            throw new IllegalArgumentException("wrong publicKey format");
          }
        }
        this.a = u.d(paramArrayOfByte);
        return;
      }
      throw new IllegalArgumentException("wrong publicKey size");
    }
    throw new NullPointerException("publicKey byte array == null");
  }
  
  protected byte[][] a()
  {
    return u.d(this.a);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */