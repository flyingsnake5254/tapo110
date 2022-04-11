package org.bouncycastle.util;

import org.bouncycastle.crypto.p.j;

public class c
{
  private static char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private final byte[] b;
  
  public c(byte[] paramArrayOfByte)
  {
    this.b = a(paramArrayOfByte);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    j localj = new j(160);
    localj.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = new byte[localj.e()];
    localj.doFinal(paramArrayOfByte, 0);
    return paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof c)) {
      return a.c(((c)paramObject).b, this.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return a.w(this.b);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i != this.b.length; i++)
    {
      if (i > 0) {
        localStringBuffer.append(":");
      }
      localStringBuffer.append(a[(this.b[i] >>> 4 & 0xF)]);
      localStringBuffer.append(a[(this.b[i] & 0xF)]);
    }
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */