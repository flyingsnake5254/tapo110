package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.crypto.w.e0;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;

public class BCRSAPrivateCrtKey
  extends BCRSAPrivateKey
  implements RSAPrivateCrtKey
{
  static final long serialVersionUID = 7834723820638524718L;
  private BigInteger crtCoefficient;
  private BigInteger primeExponentP;
  private BigInteger primeExponentQ;
  private BigInteger primeP;
  private BigInteger primeQ;
  private BigInteger publicExponent;
  
  BCRSAPrivateCrtKey(RSAPrivateCrtKey paramRSAPrivateCrtKey)
  {
    this.modulus = paramRSAPrivateCrtKey.getModulus();
    this.publicExponent = paramRSAPrivateCrtKey.getPublicExponent();
    this.privateExponent = paramRSAPrivateCrtKey.getPrivateExponent();
    this.primeP = paramRSAPrivateCrtKey.getPrimeP();
    this.primeQ = paramRSAPrivateCrtKey.getPrimeQ();
    this.primeExponentP = paramRSAPrivateCrtKey.getPrimeExponentP();
    this.primeExponentQ = paramRSAPrivateCrtKey.getPrimeExponentQ();
    this.crtCoefficient = paramRSAPrivateCrtKey.getCrtCoefficient();
  }
  
  BCRSAPrivateCrtKey(RSAPrivateCrtKeySpec paramRSAPrivateCrtKeySpec)
  {
    this.modulus = paramRSAPrivateCrtKeySpec.getModulus();
    this.publicExponent = paramRSAPrivateCrtKeySpec.getPublicExponent();
    this.privateExponent = paramRSAPrivateCrtKeySpec.getPrivateExponent();
    this.primeP = paramRSAPrivateCrtKeySpec.getPrimeP();
    this.primeQ = paramRSAPrivateCrtKeySpec.getPrimeQ();
    this.primeExponentP = paramRSAPrivateCrtKeySpec.getPrimeExponentP();
    this.primeExponentQ = paramRSAPrivateCrtKeySpec.getPrimeExponentQ();
    this.crtCoefficient = paramRSAPrivateCrtKeySpec.getCrtCoefficient();
  }
  
  BCRSAPrivateCrtKey(h paramh)
    throws IOException
  {
    this(org.bouncycastle.asn1.n2.i.i(paramh.i()));
  }
  
  BCRSAPrivateCrtKey(org.bouncycastle.asn1.n2.i parami)
  {
    this.modulus = parami.j();
    this.publicExponent = parami.n();
    this.privateExponent = parami.m();
    this.primeP = parami.k();
    this.primeQ = parami.l();
    this.primeExponentP = parami.g();
    this.primeExponentQ = parami.h();
    this.crtCoefficient = parami.f();
  }
  
  BCRSAPrivateCrtKey(e0 parame0)
  {
    super(parame0);
    this.publicExponent = parame0.h();
    this.primeP = parame0.g();
    this.primeQ = parame0.i();
    this.primeExponentP = parame0.e();
    this.primeExponentQ = parame0.f();
    this.crtCoefficient = parame0.j();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof RSAPrivateCrtKey)) {
      return false;
    }
    paramObject = (RSAPrivateCrtKey)paramObject;
    if ((!getModulus().equals(((RSAPrivateCrtKey)paramObject).getModulus())) || (!getPublicExponent().equals(((RSAPrivateCrtKey)paramObject).getPublicExponent())) || (!getPrivateExponent().equals(((RSAPrivateCrtKey)paramObject).getPrivateExponent())) || (!getPrimeP().equals(((RSAPrivateCrtKey)paramObject).getPrimeP())) || (!getPrimeQ().equals(((RSAPrivateCrtKey)paramObject).getPrimeQ())) || (!getPrimeExponentP().equals(((RSAPrivateCrtKey)paramObject).getPrimeExponentP())) || (!getPrimeExponentQ().equals(((RSAPrivateCrtKey)paramObject).getPrimeExponentQ())) || (!getCrtCoefficient().equals(((RSAPrivateCrtKey)paramObject).getCrtCoefficient()))) {
      bool = false;
    }
    return bool;
  }
  
  public BigInteger getCrtCoefficient()
  {
    return this.crtCoefficient;
  }
  
  public byte[] getEncoded()
  {
    return c.b(new org.bouncycastle.asn1.x509.a(g.B, v0.c), new org.bouncycastle.asn1.n2.i(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public BigInteger getPrimeExponentP()
  {
    return this.primeExponentP;
  }
  
  public BigInteger getPrimeExponentQ()
  {
    return this.primeExponentQ;
  }
  
  public BigInteger getPrimeP()
  {
    return this.primeP;
  }
  
  public BigInteger getPrimeQ()
  {
    return this.primeQ;
  }
  
  public BigInteger getPublicExponent()
  {
    return this.publicExponent;
  }
  
  public int hashCode()
  {
    return getModulus().hashCode() ^ getPublicExponent().hashCode() ^ getPrivateExponent().hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = org.bouncycastle.util.i.d();
    localStringBuffer.append("RSA Private CRT Key [");
    localStringBuffer.append(a.a(getModulus(), getPublicExponent()));
    localStringBuffer.append("]");
    localStringBuffer.append(str);
    localStringBuffer.append("            modulus: ");
    localStringBuffer.append(getModulus().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("    public exponent: ");
    localStringBuffer.append(getPublicExponent().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\BCRSAPrivateCrtKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */