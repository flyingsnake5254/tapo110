package org.bouncycastle.crypto.p;

import org.bouncycastle.crypto.n;

public class k
  extends b
  implements n
{
  public k(int paramInt)
  {
    super(v(paramInt));
  }
  
  private static int v(int paramInt)
  {
    if ((paramInt != 128) && (paramInt != 256))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("'bitLength' ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" not supported for SHAKE");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SHAKE");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    return j(paramArrayOfByte, paramInt, e());
  }
  
  public int j(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = w(paramArrayOfByte, paramInt1, paramInt2);
    reset();
    return paramInt1;
  }
  
  public int w(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.g) {
      q(15, 4);
    }
    u(paramArrayOfByte, paramInt1, paramInt2 * 8L);
    return paramInt2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\p\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */