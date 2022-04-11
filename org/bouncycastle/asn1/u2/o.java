package org.bouncycastle.asn1.u2;

import e.a.b.a.d;
import e.a.b.a.e;
import java.math.BigInteger;

public class o
{
  public int a(d paramd)
  {
    return (paramd.t() + 7) / 8;
  }
  
  public int b(e parame)
  {
    return (parame.f() + 7) / 8;
  }
  
  public byte[] c(BigInteger paramBigInteger, int paramInt)
  {
    paramBigInteger = paramBigInteger.toByteArray();
    byte[] arrayOfByte;
    if (paramInt < paramBigInteger.length)
    {
      arrayOfByte = new byte[paramInt];
      System.arraycopy(paramBigInteger, paramBigInteger.length - paramInt, arrayOfByte, 0, paramInt);
      return arrayOfByte;
    }
    if (paramInt > paramBigInteger.length)
    {
      arrayOfByte = new byte[paramInt];
      System.arraycopy(paramBigInteger, 0, arrayOfByte, paramInt - paramBigInteger.length, paramBigInteger.length);
      return arrayOfByte;
    }
    return paramBigInteger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u2\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */