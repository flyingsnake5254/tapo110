package org.bouncycastle.crypto.w;

import org.bouncycastle.crypto.e;

public class a
  implements e
{
  private byte[] c;
  private byte[] d;
  private a0 f;
  private int q;
  
  public a(a0 parama0, int paramInt, byte[] paramArrayOfByte)
  {
    this(parama0, paramInt, paramArrayOfByte, null);
  }
  
  public a(a0 parama0, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.f = parama0;
    this.d = paramArrayOfByte1;
    this.q = paramInt;
    this.c = paramArrayOfByte2;
  }
  
  public byte[] a()
  {
    return this.c;
  }
  
  public a0 b()
  {
    return this.f;
  }
  
  public int c()
  {
    return this.q;
  }
  
  public byte[] d()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */