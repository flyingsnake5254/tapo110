package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.n2.j;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.d0;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.util.i;

public class JCERSAPublicKey
  implements RSAPublicKey
{
  static final long serialVersionUID = 2675817738516720772L;
  private BigInteger modulus;
  private BigInteger publicExponent;
  
  JCERSAPublicKey(RSAPublicKey paramRSAPublicKey)
  {
    this.modulus = paramRSAPublicKey.getModulus();
    this.publicExponent = paramRSAPublicKey.getPublicExponent();
  }
  
  JCERSAPublicKey(RSAPublicKeySpec paramRSAPublicKeySpec)
  {
    this.modulus = paramRSAPublicKeySpec.getModulus();
    this.publicExponent = paramRSAPublicKeySpec.getPublicExponent();
  }
  
  JCERSAPublicKey(w paramw)
  {
    try
    {
      paramw = j.f(paramw.j());
      this.modulus = paramw.g();
      this.publicExponent = paramw.h();
      return;
    }
    catch (IOException paramw)
    {
      throw new IllegalArgumentException("invalid info structure in RSA public key");
    }
  }
  
  JCERSAPublicKey(d0 paramd0)
  {
    this.modulus = paramd0.c();
    this.publicExponent = paramd0.b();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof RSAPublicKey)) {
      return false;
    }
    paramObject = (RSAPublicKey)paramObject;
    if ((!getModulus().equals(((RSAPublicKey)paramObject).getModulus())) || (!getPublicExponent().equals(((RSAPublicKey)paramObject).getPublicExponent()))) {
      bool = false;
    }
    return bool;
  }
  
  public String getAlgorithm()
  {
    return "RSA";
  }
  
  public byte[] getEncoded()
  {
    return c.c(new a(g.B, v0.c), new j(getModulus(), getPublicExponent()));
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public BigInteger getModulus()
  {
    return this.modulus;
  }
  
  public BigInteger getPublicExponent()
  {
    return this.publicExponent;
  }
  
  public int hashCode()
  {
    return getModulus().hashCode() ^ getPublicExponent().hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = i.d();
    localStringBuffer.append("RSA Public Key");
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\JCERSAPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */