package org.bouncycastle.crypto.w;

import org.bouncycastle.util.a;

public class m
{
  private int a;
  private byte[] b;
  private int c;
  
  public m(byte[] paramArrayOfByte, int paramInt)
  {
    this(paramArrayOfByte, paramInt, -1);
  }
  
  public m(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.b = paramArrayOfByte;
    this.c = paramInt1;
    this.a = paramInt2;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public byte[] b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof m)) {
      return false;
    }
    paramObject = (m)paramObject;
    if (((m)paramObject).c != this.c) {
      return false;
    }
    return a.c(this.b, ((m)paramObject).b);
  }
  
  public int hashCode()
  {
    return this.c ^ a.w(this.b);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */