package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class h
  implements AlgorithmParameterSpec
{
  private BigInteger a;
  private BigInteger b;
  
  public h(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this.a = paramBigInteger1;
    this.b = paramBigInteger2;
  }
  
  public BigInteger a()
  {
    return this.b;
  }
  
  public BigInteger b()
  {
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\spec\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */