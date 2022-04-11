package org.bouncycastle.crypto.w;

import org.bouncycastle.util.a;

public class h
{
  private byte[] a;
  private int b;
  
  public h(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public byte[] b()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof h)) {
      return false;
    }
    paramObject = (h)paramObject;
    if (((h)paramObject).b != this.b) {
      return false;
    }
    return a.c(this.a, ((h)paramObject).a);
  }
  
  public int hashCode()
  {
    return this.b ^ a.w(this.a);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */