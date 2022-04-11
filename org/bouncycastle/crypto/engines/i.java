package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.w.c0;
import org.bouncycastle.crypto.w.d0;
import org.bouncycastle.crypto.w.e0;

class i
{
  private d0 a;
  private boolean b;
  
  public BigInteger a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= c() + 1)
    {
      if ((paramInt2 == c() + 1) && (!this.b)) {
        throw new DataLengthException("input too large for RSA cipher.");
      }
      byte[] arrayOfByte;
      if (paramInt1 == 0)
      {
        arrayOfByte = paramArrayOfByte;
        if (paramInt2 == paramArrayOfByte.length) {}
      }
      else
      {
        arrayOfByte = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      }
      paramArrayOfByte = new BigInteger(1, arrayOfByte);
      if (paramArrayOfByte.compareTo(this.a.c()) < 0) {
        return paramArrayOfByte;
      }
      throw new DataLengthException("input too large for RSA cipher.");
    }
    throw new DataLengthException("input too large for RSA cipher.");
  }
  
  public byte[] b(BigInteger paramBigInteger)
  {
    paramBigInteger = paramBigInteger.toByteArray();
    int i;
    byte[] arrayOfByte;
    if (this.b)
    {
      if ((paramBigInteger[0] == 0) && (paramBigInteger.length > d()))
      {
        i = paramBigInteger.length - 1;
        arrayOfByte = new byte[i];
        System.arraycopy(paramBigInteger, 1, arrayOfByte, 0, i);
        return arrayOfByte;
      }
      if (paramBigInteger.length < d())
      {
        i = d();
        arrayOfByte = new byte[i];
        System.arraycopy(paramBigInteger, 0, arrayOfByte, i - paramBigInteger.length, paramBigInteger.length);
        return arrayOfByte;
      }
    }
    else if (paramBigInteger[0] == 0)
    {
      i = paramBigInteger.length - 1;
      arrayOfByte = new byte[i];
      System.arraycopy(paramBigInteger, 1, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    return paramBigInteger;
  }
  
  public int c()
  {
    int i = this.a.c().bitLength();
    boolean bool = this.b;
    int j = (i + 7) / 8;
    i = j;
    if (bool) {
      i = j - 1;
    }
    return i;
  }
  
  public int d()
  {
    int i = this.a.c().bitLength();
    boolean bool = this.b;
    i = (i + 7) / 8;
    if (bool) {
      return i;
    }
    return i - 1;
  }
  
  public void e(boolean paramBoolean, e parame)
  {
    e locale = parame;
    if ((parame instanceof c0)) {
      locale = ((c0)parame).a();
    }
    this.a = ((d0)locale);
    this.b = paramBoolean;
  }
  
  public BigInteger f(BigInteger paramBigInteger)
  {
    Object localObject1 = this.a;
    if ((localObject1 instanceof e0))
    {
      Object localObject2 = (e0)localObject1;
      BigInteger localBigInteger1 = ((e0)localObject2).g();
      localObject1 = ((e0)localObject2).i();
      BigInteger localBigInteger2 = ((e0)localObject2).e();
      BigInteger localBigInteger3 = ((e0)localObject2).f();
      localObject2 = ((e0)localObject2).j();
      localBigInteger2 = paramBigInteger.remainder(localBigInteger1).modPow(localBigInteger2, localBigInteger1);
      paramBigInteger = paramBigInteger.remainder((BigInteger)localObject1).modPow(localBigInteger3, (BigInteger)localObject1);
      return localBigInteger2.subtract(paramBigInteger).multiply((BigInteger)localObject2).mod(localBigInteger1).multiply((BigInteger)localObject1).add(paramBigInteger);
    }
    return paramBigInteger.modPow(((d0)localObject1).b(), this.a.c());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\engines\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */