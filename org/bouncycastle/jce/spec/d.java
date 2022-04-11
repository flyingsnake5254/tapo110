package org.bouncycastle.jce.spec;

import e.a.b.a.h;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class d
  implements AlgorithmParameterSpec
{
  private e.a.b.a.d a;
  private byte[] b;
  private h c;
  private BigInteger d;
  private BigInteger e;
  
  public d(e.a.b.a.d paramd, h paramh, BigInteger paramBigInteger)
  {
    this.a = paramd;
    this.c = paramh.A();
    this.d = paramBigInteger;
    this.e = BigInteger.valueOf(1L);
    this.b = null;
  }
  
  public d(e.a.b.a.d paramd, h paramh, BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte)
  {
    this.a = paramd;
    this.c = paramh.A();
    this.d = paramBigInteger1;
    this.e = paramBigInteger2;
    this.b = paramArrayOfByte;
  }
  
  public e.a.b.a.d a()
  {
    return this.a;
  }
  
  public h b()
  {
    return this.c;
  }
  
  public BigInteger c()
  {
    return this.e;
  }
  
  public BigInteger d()
  {
    return this.d;
  }
  
  public byte[] e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof d;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (d)paramObject;
    bool1 = bool2;
    if (a().m(((d)paramObject).a()))
    {
      bool1 = bool2;
      if (b().e(((d)paramObject).b())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return a().hashCode() ^ b().hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\spec\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */