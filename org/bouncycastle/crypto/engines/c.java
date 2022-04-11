package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.f;

public class c
  extends k
{
  protected void b()
  {
    int[] arrayOfInt = this.f;
    int i = arrayOfInt[12] + 1;
    arrayOfInt[12] = i;
    if (i != 0) {
      return;
    }
    throw new IllegalStateException("attempt to increase counter past 2^32.");
  }
  
  protected void d(byte[] paramArrayOfByte)
  {
    d.n(this.d, this.f, this.g);
    f.f(this.g, paramArrayOfByte, 0);
  }
  
  public String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChaCha7539-");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
  
  protected int f()
  {
    return 12;
  }
  
  protected void j()
  {
    this.f[12] = 0;
  }
  
  protected void m(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null) {
      if (paramArrayOfByte1.length == 32)
      {
        h(paramArrayOfByte1.length, this.f, 0);
        f.h(paramArrayOfByte1, 0, this.f, 4, 8);
      }
      else
      {
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append(e());
        paramArrayOfByte1.append(" requires 256 bit key");
        throw new IllegalArgumentException(paramArrayOfByte1.toString());
      }
    }
    f.h(paramArrayOfByte2, 0, this.f, 13, 3);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\engines\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */