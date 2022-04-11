package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.n;

final class e
{
  private final g a;
  private final int b;
  
  protected e(g paramg, int paramInt)
  {
    Objects.requireNonNull(paramg, "digest == null");
    this.a = paramg;
    this.b = paramInt;
  }
  
  private byte[] d(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = u.p(paramInt, this.b);
    this.a.update(arrayOfByte, 0, arrayOfByte.length);
    this.a.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    this.a.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
    paramInt = this.b;
    paramArrayOfByte1 = new byte[paramInt];
    paramArrayOfByte2 = this.a;
    if ((paramArrayOfByte2 instanceof n)) {
      ((n)paramArrayOfByte2).j(paramArrayOfByte1, 0, paramInt);
    } else {
      paramArrayOfByte2.doFinal(paramArrayOfByte1, 0);
    }
    return paramArrayOfByte1;
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte1.length;
    int j = this.b;
    if (i == j)
    {
      if (paramArrayOfByte2.length == j) {
        return d(0, paramArrayOfByte1, paramArrayOfByte2);
      }
      throw new IllegalArgumentException("wrong in length");
    }
    throw new IllegalArgumentException("wrong key length");
  }
  
  protected byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte1.length;
    int j = this.b;
    if (i == j)
    {
      if (paramArrayOfByte2.length == j * 2) {
        return d(1, paramArrayOfByte1, paramArrayOfByte2);
      }
      throw new IllegalArgumentException("wrong in length");
    }
    throw new IllegalArgumentException("wrong key length");
  }
  
  protected byte[] c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == this.b)
    {
      if (paramArrayOfByte2.length == 32) {
        return d(3, paramArrayOfByte1, paramArrayOfByte2);
      }
      throw new IllegalArgumentException("wrong address length");
    }
    throw new IllegalArgumentException("wrong key length");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */