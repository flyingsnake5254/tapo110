package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

public class c
  extends ECParameterSpec
{
  private String a;
  
  public c(String paramString, EllipticCurve paramEllipticCurve, ECPoint paramECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    super(paramEllipticCurve, paramECPoint, paramBigInteger1, paramBigInteger2.intValue());
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\spec\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */